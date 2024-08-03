import { Component, OnInit, ViewChild } from '@angular/core';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { PageComponent } from '../../components/page/page.component';
import { EmployeeBasicResponse, ServiceRequest, ServiceResponse, SparePartResponse, StatusService, VehicleBasicResponse } from '../../interfaces/model.interfaces';
import { Column } from '../../interfaces/components.interface';
import { ServicesService } from '../../services/services.service';
import { ToastComponent } from '../../components/toast/toast.component';
import { ServiceFormComponent } from '../../components/service-form/service-form.component';
import { CommonModule } from '@angular/common';
import { ActionButtonConfig } from '../../components/action-buttons/action-buttons.component';
import { ConfirmDialogComponent } from '../../components/confirm-dialog/confirm-dialog.component';
import { hasValidRoles } from '../../util/rolesUtil';
import { AuthService } from '../../auth/auth.service';

@Component({
  selector: 'app-services',
  standalone: true,
  imports: [
    ButtonModule,
    TableModule,
    PageComponent,
    ToastComponent,
    ConfirmDialogComponent,
    ServiceFormComponent,
    CommonModule],
  templateUrl: './services.component.html',
  styleUrl: './services.component.css'
})
export class ServicesComponent implements OnInit {
  @ViewChild('form') form!: ServiceFormComponent;
  @ViewChild('toast') toast!: ToastComponent;
  @ViewChild('dialog') dialog!: ConfirmDialogComponent;

  title: string = "Servicios";
  labelButtonAdd: string = "Agregar servicio";
  status!: boolean;
  serviceList: ServiceResponse[] = [];
  idToUpdated?: number;
  dataService?: ServiceRequest;

  canCreate : boolean = hasValidRoles(this.authService.employeeData,["ROLE_ADMIN", "ROLE_ADMINISTRATIVE"]);
  canEdit : boolean = hasValidRoles(this.authService.employeeData, ["ROLE_ADMIN", "ROLE_ADMINISTRATIVE", "ROLE_MECHANIC"]);
  canRemove : boolean = hasValidRoles(this.authService.employeeData, ["ROLE_ADMIN", "ROLE_ADMINISTRATIVE"]);

  columns: Column[] = [
    {
      header: "Servicio",
      field: "serviceType.name",
      sortable: true
    },
    {
      header: "Vehículo",
      field: "vehicleCompound",
      sortable: true
    },
    {
      header: "Estado",
      field: "showedStatus",
      sortable: true
    },
    {
      header: "Inicio",
      field: "startDate",
      sortable: false
    },
    {
      header: "Fin",
      field: "finalDate",
      sortable: false
    },
    {
      header: "Precio",
      field: "price",
      sortable: true
    },
    {
      header: "Cliente",
      field: "clientName",
      sortable: true
    },
  ]

  buttonConfig: ActionButtonConfig[] = [
    { 
      icon: 'pi pi-link', 
      tooltip: 'Ver elementos relacionados', 
      severity: 'info', 
      action: (data: any) => this.linkService(data) 
    },
    { 
      icon: 'pi pi-pencil', 
      tooltip: 'Editar registro', 
      severity: 'success', 
      isDisabled: !this.canEdit,
      action: (data: any) => this.canEdit ? this.openFormEdit(data) : null 
    },
    { 
      icon: 'pi pi-trash', 
      tooltip: 'Borrar registro', 
      severity: 'danger', 
      isDisabled: !this.canRemove,
      action: (data: any) => this.canRemove ? this.openConfirmDialog(data) : null
    }
  ];

  constructor(
    private servicesService: ServicesService,
    private authService : AuthService
  ) {}


  ngOnInit(): void {
    this.loadServices();
  }

  openForm(){
    this.form.showForm();
  }

  openFormEdit(service: any){
    this.idToUpdated = service.id;
    this.dataService = { ...service };
    this.form.showForm();
  }

  openConfirmDialog(service: ServiceResponse){
    this.dialog.openDialog(service.id);
  }

  save(service: ServiceRequest){
    this.servicesService.create(service).subscribe({
      next: (service: ServiceResponse) => {
        this.handlePostCreate(service);
        this.toast.showSuccessCreate();
      },
      error: (error) => {
        this.toast.showErrorCreate();
        console.error(error);
      }
    });
  }

  update(service: ServiceRequest){
    this.servicesService.update(this.idToUpdated!, service).subscribe({
      next: (service) => {
        this.handlePostUpdate(service);
        this.toast.showSuccessUpdate();
      },
      error: (error) => {
        this.toast.showErrorUpdate();
        console.error(error);
      }
    });
  }

  handlePostCreate(service: ServiceResponse) {
    let list = [...this.serviceList];
    list.push(this.processService(service));

    this.serviceList = list;

    this.form.resetAndHideForm();
  }

  handlePostUpdate(service: ServiceResponse) {
    const index = this.serviceList.findIndex(item => item.id === service.id);
    this.serviceList[index] = this.processService(service);

    this.form.resetAndHideForm();
    this.idToUpdated = undefined;
    this.dataService = undefined;
  }

  deleteService(id: number) {
    this.servicesService.deleteById(id).subscribe({
      next: () => { 
        this.toast.showSuccessDelete();
        this.serviceList = this.serviceList.filter(item => item.id !== id);
      },
      error: (error) => {
        this.toast.showErrorDelete();
        console.log(error);
      }
    });
  }

  loadServices() {
    this.servicesService.getAll().subscribe(response => {
      this.serviceList = response
        .filter(e => e.status !== StatusService.CANCELLED)
        .map(e => {
          return this.processService(e);
        });
    })
  }

  private processService(service: ServiceResponse) {
    const vehicle: VehicleBasicResponse = service.vehicle;
    const vehicleCompound: string = `${vehicle.brand || ''} ${vehicle.model || ''} ${vehicle.plate || ''}`.trim();

    const spareParts: SparePartResponse[] = service.spareParts;
    const sparePartsCompound: string = spareParts.map(part => part.name).join(', ');

    const employees: EmployeeBasicResponse[] = service.employees;
    const employeesCompound: string = employees.map(employee => employee.name + ' ' + employee.lastName).join(', ');

    const showedStatus: string = this.mapStatusToDescription(service.status);

    const clientName: string = service.client.businessName 
      ? service.client.businessName 
      : `${service.client.name} ${service.client.lastName}`;

    service = {
      ...service,
      vehicleCompound,
      sparePartsCompound,
      employeesCompound,
      showedStatus,
      clientName
    }

    return service;
  }

  private mapStatusToDescription(status: StatusService): string {
    const statusMapping: { [key in StatusService]: string } = {
      [StatusService.TO_DO]: 'Pendiente',
      [StatusService.IN_PROGRESS]: 'En progreso',
      [StatusService.FINISHED]: 'Finalizado',
      [StatusService.CANCELLED]: 'Cancelado'
    };
    return statusMapping[status];
  }

  linkService(service: ServiceResponse){
    alert("TODO relacionadas sin implementar");
  }
}
