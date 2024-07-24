import { Component, ViewChild } from '@angular/core';
import { PageComponent } from '../../components/page/page.component';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { VehicleResponse } from '../../interfaces/model.interfaces';
import { Column } from '../../interfaces/components.interface';
import { VehicleService } from '../../services/vehicle.service';
import { ConfirmDialogComponent } from '../../components/confirm-dialog/confirm-dialog.component';
import { ToastComponent } from '../../components/toast/toast.component';
import { ActionButtonConfig } from '../../components/action-buttons/action-buttons.component';

@Component({
  selector: 'app-vehicle',
  standalone: true,
  imports: [ButtonModule, TableModule, PageComponent, ConfirmDialogComponent, ToastComponent],
  templateUrl: './vehicle.component.html',
  styleUrl: './vehicle.component.css'
})
export class VehicleComponent {
  @ViewChild('dialog') dialog!: ConfirmDialogComponent;
  @ViewChild('toast') toast!: ToastComponent;
  
  title : string = "Vehículos";
  labelButtonAdd : string = "Agregar vehículo";
  status! : boolean;

  vehicleList : VehicleResponse[] = [];

  columns : Column []= [
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
      action: (data: any) => this.editVehicle(data) 
    },
    { 
      icon: 'pi pi-trash', 
      tooltip: 'Borrar registro', 
      severity: 'danger', 
      action: (data: any) => this.openConfirmDialog(data)
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
      this.vehicleList = response.filter(e => !e.deleted);
    });
  }

  createVehicle(){
    alert("TODO crear sin implementar");
  }

  editVehicle(vehicle : any){
    alert("TODO editar sin implementar");
  }

  openConfirmDialog(vehicle : any){
    this.dialog.openDialog(vehicle.id);
  }

  deleteVehicle(id : any){
    this.vehicleService.deleteById(id).subscribe({
      next: () => {
        this.toast.showSuccessDelete();
        this.vehicleList = this.vehicleList.filter(item => item.id !== id);
      },
      error: (error) => {
        this.toast.showErrorDelete();
        console.error(error);
      }
    })
  }

  linkVehicle(vehicle : any){
    alert("TODO relacionadas sin implementar");
  }
}

