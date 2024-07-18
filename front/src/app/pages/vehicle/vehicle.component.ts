import { Component } from '@angular/core';
import { PageComponent } from '../../components/page/page.component';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { VehicleResponse } from '../../interfaces/vehicle';
import { Column } from '../../interfaces/table.interface';
import { VehicleService } from '../../services/vehicle.service';

@Component({
  selector: 'app-vehicle',
  standalone: true,
  imports: [ButtonModule, TableModule, PageComponent],
  templateUrl: './vehicle.component.html',
  styleUrl: './vehicle.component.css'
})
export class VehicleComponent {
  title : string = "Vehículos";
  labelButtonAdd : string = "Agregar vehículo";

  vehicleList : VehicleResponse[] = [];

  columns : Column []= [
    {
      header: "Patente",
      field: "plate",
      sortable: true
    },
    {
      header: "Marca",
      field: "brandDto",
      sortable: true
      // TODO brandDto: BrandResponse
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

  constructor(
    private vehicleService : VehicleService
  ){}

  ngOnInit(){
    this.loadVehicles();
  }

  loadVehicles(){
    this.vehicleService.getAll().subscribe(response => {
      this.vehicleList = response;
    });
  }

  createVehicle(){
    alert("TODO crear sin implementar");
  }

  editVehicle(vehicle : any){
    alert("TODO editar sin implementar");
  }

  deleteVehicle(vehicle : any){
    alert("TODO borrar sin implementar");
  }

  linkVehicle(vehicle : any){
    alert("TODO relacionadas sin implementar");
  }
}

