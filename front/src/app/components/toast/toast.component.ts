import { Component } from '@angular/core';
import { MessageService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';

@Component({
  selector: 'app-toast',
  standalone: true,
  imports: [ToastModule],
  templateUrl: './toast.component.html'
})
export class ToastComponent{

  baseSuccess = {severity: 'success', summary: 'Éxito'};
  baseError = {severity: 'error', summary: 'Error'};

  successDelete = {...this.baseSuccess, detail: 'El registro ha sido dado de baja.'};
  errorDelete = {...this.baseError, detail: 'No se ha podido eliminar el registro.'}
  
  successCreate = {...this.baseSuccess, detail: 'El registro se ha creado.'};
  errorCreate = {...this.baseError, detail: 'No se ha podido crear el registro.'}

  successUpdate = {...this.baseSuccess, detail: 'El registro se ha actualizado.'};
  errorUpdate = {...this.baseError, detail: 'No se ha podido actualizar el registro.'}

  constructor(private messageService: MessageService) { }

  showSuccessDelete(){
    this.messageService.add(this.successDelete);
  }
  showErrorDelete(){
    this.messageService.add(this.errorDelete);
  }

  showSuccessCreate() {
    this.messageService.add(this.successCreate);
  }
  showErrorCreate() {
    this.messageService.add(this.errorCreate);
  }

  showSuccessUpdate() {
    this.messageService.add(this.successUpdate);
  }
  showErrorUpdate() {
    this.messageService.add(this.errorUpdate);
  }
}
