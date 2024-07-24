import { Component, ViewChild } from '@angular/core';
import { ButtonModule } from 'primeng/button';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { TableModule } from 'primeng/table';
import { ToastModule } from 'primeng/toast';
import { ClientService } from '../../services/client.service';
import { ClientRequest, ClientResponse } from '../../interfaces/model.interfaces';
import { PageComponent } from '../../components/page/page.component';
import { Column } from '../../interfaces/components.interface';
import { ConfirmDialogComponent } from '../../components/confirm-dialog/confirm-dialog.component';
import { ToastComponent } from '../../components/toast/toast.component';
import { ClientFormComponent } from '../../components/client-form/client-form.component';
import { TooltipModule } from 'primeng/tooltip';
import { ActionButtonConfig } from '../../components/action-buttons/action-buttons.component';

@Component({
  selector: 'app-client',
  standalone: true,
  imports: [
    ButtonModule,
    ClientFormComponent,
    ConfirmDialogModule,
    ConfirmDialogComponent,
    ToastComponent,
    PageComponent,
    TableModule,
    ToastModule,
    TooltipModule],
  templateUrl: './client.component.html',
  styleUrl: './client.component.css'
})
export class ClientComponent {
  @ViewChild('dialog') dialog!: ConfirmDialogComponent;
  @ViewChild('toast') toast!: ToastComponent;
  @ViewChild('form') form!: ClientFormComponent;

  title : string = "Clientes";
  labelButtonAdd : string = "Agregar cliente";
  status! : boolean;
  idToUpdated? : number;
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

  buttonConfig: ActionButtonConfig[] = [
    { 
      icon: 'pi pi-link', 
      tooltip: 'Ver elementos relacionados', 
      severity: 'info', 
      action: (data: any) => this.linkClient(data) 
    },
    { 
      icon: 'pi pi-pencil', 
      tooltip: 'Editar registro', 
      severity: 'success', 
      action: (data: any) => this.openFormEdit(data) 
    },
    { 
      icon: 'pi pi-trash', 
      tooltip: 'Borrar registro', 
      severity: 'danger', 
      action: (data: any) => this.openConfirmDialog(data)
    }
  ];

  dataClient? : ClientRequest;

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

  openForm(){
    this.form.showForm();
  }

  save(client : ClientRequest){
    this.clientService.create(client).subscribe({
      next: (client) => {
        this.toast.showSuccessCreate();
        this.clientList.push(client);

        this.form.resetAndHideForm();

      },
      error: (error) => {
        this.toast.showErrorCreate();
        console.error(error);
      }
    }) 
  }

  openFormEdit(client : any){
    this.idToUpdated = client.id;
    this.dataClient = { ...client };
    this.form.showForm();
  }

  update(client : ClientRequest){
    this.clientService.update(this.idToUpdated!, client).subscribe({
      next: (client) => {
        this.toast.showSuccessUpdate();
        this.handlePostUpdate(client);
      },
      error: (error) => {
        this.toast.showErrorUpdate();
        console.error(error);
      }
    }) 
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

  handlePostUpdate(client : ClientResponse){
    const index = this.clientList.findIndex(item => item.id === client.id);
    this.clientList[index] = client;

    this.form.resetAndHideForm();
    this.idToUpdated = undefined;
    this.dataClient = undefined;
  }
}
