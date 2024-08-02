import { Component, OnInit } from '@angular/core';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { PageComponent } from '../../components/page/page.component';
import { EmployeeBasicResponse, ServiceResponse, SparePartResponse, StatusService, VehicleBasicResponse } from '../../interfaces/model.interfaces';
import { Column } from '../../interfaces/components.interface';
import { ServicesService } from '../../services/services.service';

@Component({
  selector: 'app-services',
  standalone: true,
  imports: [ButtonModule, TableModule, PageComponent],
  templateUrl: './services.component.html',
  styleUrl: './services.component.css'
})
export class ServicesComponent implements OnInit {

  title: string = "Servicios";
  labelButtonAdd: string = "Agregar servicio";
  status!: boolean;
  serviceList: ServiceResponse[] = [];

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

  constructor(private servicesService: ServicesService) {}


  ngOnInit(): void {
    this.loadServices();
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
}
