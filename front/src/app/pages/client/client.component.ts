import { Component, ViewChild } from '@angular/core';
import { ButtonModule } from 'primeng/button';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { TableModule } from 'primeng/table';
import { ToastModule } from 'primeng/toast';
import { ClientService } from '../../services/client.service';
import { ClientResponse } from '../../interfaces/client';
import { PageComponent } from '../../components/page/page.component';
import { Column } from '../../interfaces/table.interface';
import { ConfirmDialogComponent } from '../../components/confirm-dialog/confirm-dialog.component';
import { ToastComponent } from '../../components/toast/toast.component';

@Component({
  selector: 'app-client',
  standalone: true,
  imports: [
    ButtonModule,
    ConfirmDialogModule,
    ConfirmDialogComponent,
    ToastComponent,
    PageComponent,
    TableModule,
    ToastModule],
  templateUrl: './client.component.html',
  styleUrl: './client.component.css'
})
export class ClientComponent {
  @ViewChild('dialog') dialog!: ConfirmDialogComponent;
  @ViewChild('toast') toast!: ToastComponent;

  title : string = "Clientes";
  labelButtonAdd : string = "Agregar cliente";
  status! : boolean;

  clientList : ClientResponse[] = [];

  columns : Column []= [
    {
      header: "Nombre",
      field: "name",
      sortable: true
    },
    {
      header: "Apellido",
      field: "lastName",
      sortable: true
    },
    {
      header: "Tipo documento",
      field: "category",
      sortable: true
    },
    {
      header: "Nro. documento",
      field: "identificationNumber",
      sortable: true
    },
    {
      header: "Nombre empresa",
      field: "businessName",
      sortable: true
    },
    {
      header: "E-mail",
      field: "email",
      sortable: true
    }
  ];

  constructor(
    private clientService : ClientService
  ){}

  ngOnInit(){
    this.loadClients();
  }

  loadClients(){
    this.clientService.getAll().subscribe(response => {
      this.clientList = response.filter(e => !e.deleted);
    });
  }

  createClient(){
    alert("TODO crear sin implementar");
  }

  editClient(client : any){
    alert("TODO editar sin implementar");
  }

  openConfirmDialog(client : any){
    this.dialog.openDialog(client.id);
  }
  
  deleteClient(id : any){
    this.clientService.deleteById(id).subscribe({
      next: () => {
        this.toast.showSuccessDelete();
        this.clientList = this.clientList.filter(item => item.id !== id);
      },
      error: (error) => {
        this.toast.showErrorDelete();
        console.error(error);
      }
    }) 
  }

  linkClient(client : any){
    alert("TODO relacionadas sin implementar");
  }
}
