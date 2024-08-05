import { Component, OnInit, ViewChild } from '@angular/core';
import { PageComponent } from '../../components/page/page.component';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { BrandResponse, VehicleRequest, VehicleResponse } from '../../interfaces/model.interfaces';
import { Column } from '../../interfaces/components.interface';
import { VehicleService } from '../../services/vehicle.service';
import { ConfirmDialogComponent } from '../../components/confirm-dialog/confirm-dialog.component';
import { ToastComponent } from '../../components/toast/toast.component';
import { ActionButtonConfig } from '../../components/action-buttons/action-buttons.component';
import { CommonModule } from '@angular/common';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { VehicleFormComponent } from '../../components/vehicle-form/vehicle-form.component';
import { BrandService } from '../../services/brand.service';
import { AuthService } from '../../auth/auth.service';
import { hasValidRoles } from '../../util/rolesUtil';

@Component({
  selector: 'app-vehicle',
  standalone: true,
  imports: [ButtonModule, TableModule, PageComponent, ConfirmDialogComponent, ConfirmDialogModule, ToastComponent, VehicleFormComponent, CommonModule],
  templateUrl: './vehicle.component.html',
  styleUrl: './vehicle.component.css'
})
export class VehicleComponent implements OnInit {
  @ViewChild('dialog') dialog!: ConfirmDialogComponent;
  @ViewChild('toast') toast!: ToastComponent;
  @ViewChild('form') form!: VehicleFormComponent;

  title: string = "Vehiculos";
  labelButtonAdd: string = "Agregar vehiculo";
  status!: boolean;
  idToUpdated? : number;
  vehicleList: VehicleResponse[] = [];
  brandList: BrandResponse[] = [];
  dataVehicle?: VehicleRequest;

  canCreate : boolean = hasValidRoles(this.authService.employeeData, ["ROLE_ADMIN", "ROLE_ADMINISTRATIVE"]);
  canEdit : boolean = hasValidRoles(this.authService.employeeData, ["ROLE_ADMIN", "ROLE_ADMINISTRATIVE"]);
  canRemove : boolean = hasValidRoles(this.authService.employeeData, ["ROLE_ADMIN"]);

  columns: Column[] = [
    {
      header: "Patente",
      field: "plate",
      sortable: true
    },
    {
      header: "Marca",
      field: "brand.name",
      sortable: true
    },
    {
      header: "Modelo",
      field: "model",
      sortable: true
    },
    {
      header: "Kilometraje",
      field: "mileage",
      sortable: true
    },
    {
      header: "Observaciones",
      field: "observations",
      sortable: true
    }
  ];

  buttonConfig: ActionButtonConfig[] = [
    { 
      icon: 'pi pi-link', 
      tooltip: 'Ver elementos relacionados', 
      severity: 'info', 
      action: (data: any) => this.linkVehicle(data) 
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
    private vehicleService: VehicleService, 
    private brandService: BrandService,
    private authService : AuthService
  ) {}

  ngOnInit() {
    this.loadVehicles();
    this.loadBrands();
  }

  loadVehicles() {
    this.vehicleService.getAll().subscribe(response => {
      this.vehicleList = response.filter(e => !e.deleted);
    });
  }

  loadBrands() {
    this.brandService.getAll().subscribe(response => {
      this.brandList = response.filter(e => !e.deleted);
    });
  }

  openForm() {
    this.form.showForm();
  }

  save(vehicle: VehicleRequest) {
    this.vehicleService.create(vehicle).subscribe({
      next: (vehicle: VehicleResponse) => {
        this.toast.showSuccessCreate();
        this.handlePostCreate(vehicle);
      },
      error: (error) => {
        this.toast.showErrorCreate();
        console.error(error);
      }
    });
  }

  openFormEdit(vehicle: any) {
    this.form.showFormEdit(vehicle);
  }

  update(event: { id: number, vehicle: VehicleRequest }) {
    this.vehicleService.update(event.id, event.vehicle).subscribe({
      next: (vehicle) => {
        this.toast.showSuccessUpdate();
        this.handlePostUpdate(vehicle);
      },
      error: (error) => {
        this.toast.showErrorUpdate();
        console.error(error);
      }
    }) 
  }

  handlePostUpdate(vehicle: VehicleResponse) {
    const index = this.vehicleList.findIndex(item => item.id === vehicle.id);
    this.vehicleList[index] = vehicle;

    this.form.resetAndHideForm();
    this.idToUpdated = undefined;
    this.dataVehicle = undefined;
  }

  handlePostCreate(vehicle : VehicleResponse){
    let list = [...this.vehicleList];
    list.push(vehicle);
    
    this.vehicleList = list;

    this.form.resetAndHideForm();
  }

  openConfirmDialog(vehicle: VehicleResponse) {
    this.dialog.openDialog(vehicle.id);
  }

  deleteVehicle(id: number) {
    this.vehicleService.deleteById(id).subscribe({
      next: () => {
        this.toast.showSuccessDelete();
        this.vehicleList = this.vehicleList.filter(item => item.id !== id);
      },
      error: (error) => {
        this.toast.showErrorDelete();
        console.error(error);
      }
    });
  }

  linkVehicle(vehicle: VehicleResponse) {
    alert("TODO relacionadas sin implementar");
  }  
}