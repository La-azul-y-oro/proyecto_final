import { Component, Input } from '@angular/core';
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

  constructor(private messageService: MessageService) { }

  showSuccessDelete(){
    this.messageService.add(this.successDelete);
  }

  showErrorDelete(){
    this.messageService.add(this.errorDelete);
  }
}
