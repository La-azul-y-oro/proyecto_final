import { Component, EventEmitter, Output } from '@angular/core';
import { ConfirmationService } from 'primeng/api';
import { ConfirmDialogModule } from 'primeng/confirmdialog';

@Component({
  selector: 'app-confirm-dialog',
  standalone: true,
  imports: [ConfirmDialogModule],
  templateUrl: './confirm-dialog.component.html'
})
export class ConfirmDialogComponent {
  @Output() onConfirm = new EventEmitter;

  constructor(
    private confirmationService: ConfirmationService
  ){}

  openDialog(id : any){
    this.confirmationService.confirm({
        header: 'Eliminar registro',
        message: '¿Desea continuar?',
        icon: 'pi pi-info-circle',
        acceptButtonStyleClass:"p-button-outlined p-button-danger",
        rejectButtonStyleClass:"p-button-outlined me-3",
        acceptIcon: 'pi pi-check me-2',
        rejectIcon: 'pi pi-times me-2',
        acceptLabel: "Si",

        accept: () => {
            this.onConfirm.emit(id);
        },
    });
}

}
