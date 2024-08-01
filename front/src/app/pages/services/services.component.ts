import { Component, OnInit } from '@angular/core';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { PageComponent } from '../../components/page/page.component';
import { ServiceResponse, StatusService } from '../../interfaces/model.interfaces';
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
      field: "serviceType",
      sortable: true
    },
    {
      header: "Vehículo",
      field: "vehicle",
      sortable: true
    },
    {
      header: "Estado",
      field: "status",
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
      header: "Repuestos",
      field: "spareParts",
      sortable: false
    },
    {
      header: "Empleados",
      field: "employees",
      sortable: false
    },
    {
      header: "Precio",
      field: "price",
      sortable: true
    },
    {
      header: "Fecha de pago",
      field: "payDate",
      sortable: false
    },
    {
      header: "Cliente",
      field: "client",
      sortable: true
    },
  ]

  constructor(private servicesService: ServicesService) {}


  ngOnInit(): void {
    this.loadServices();
  }

  loadServices() {
    this.servicesService.getAll().subscribe(response => {
      this.serviceList = response.filter(e => e.status !== StatusService.CANCELLED);
    })
  }
}
