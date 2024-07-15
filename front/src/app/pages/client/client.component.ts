import { Component } from '@angular/core';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { ClientService } from '../../services/client.service';
import { ClientResponse } from '../../interfaces/client';
import { PageComponent } from '../../components/page/page.component';
import { Column } from '../../interfaces/table.interface';

@Component({
  selector: 'app-client',
  standalone: true,
  imports: [ButtonModule, TableModule, PageComponent],
  templateUrl: './client.component.html',
  styleUrl: './client.component.css'
})
export class ClientComponent {
  title : string = "Clientes";
  labelButtonAdd : string = "Agregar cliente";

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
      this.clientList = response;
    });
  }

  createClient(){
    alert("TODO crear sin implementar");
  }

  editClient(client : any){
    alert("TODO editar sin implementar");
  }

  deleteClient(client : any){
    alert("TODO borrar sin implementar");
  }

  linkClient(client : any){
    alert("TODO relacionadas sin implementar");
  }
}
