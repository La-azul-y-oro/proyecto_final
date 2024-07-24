import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output, ViewChild } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, Validators } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { DialogModule } from 'primeng/dialog';
import { DropdownModule } from 'primeng/dropdown';
import { FloatLabelModule } from 'primeng/floatlabel';
import { InputTextModule } from 'primeng/inputtext';
import { FormField, TypeField } from '../../interfaces/components.interface';
import { noWhitespaceValidator } from '../../util/customValidators';
import { FormComponent } from '../form/form.component';

@Component({
  selector: 'app-vehicle-form',
  standalone: true,
  imports: [ButtonModule, DialogModule, DropdownModule, FloatLabelModule, InputTextModule, CommonModule, ReactiveFormsModule, FormComponent],
  templateUrl: './vehicle-form.component.html'
})
export class VehicleFormComponent {
  @ViewChild("form") vehicleForm!: FormComponent;
  @Input() data? : any;
  @Output() onSave = new EventEmitter;
  @Output() onUpdate = new EventEmitter;

  brands: { label: string, value: string }[] = [];
  fields: FormField[];

  constructor (private fb : FormBuilder ){
    this.fields = [
      {
        label: 'Patente', 
        controlName: 'plate', 
        type: TypeField.TEXT, 
        placeholder: 'Ingrese la patente', 
        errorMessage: 'Dato obligatorio. Máximo 7 caracteres.',
        validators: [Validators.required, Validators.maxLength(7)]
      },
      {
        label: 'Marca', 
        controlName: 'brandId', 
        type: TypeField.NUMBER, 
        placeholder: 'Ingrese el brandId', 
        errorMessage: 'Seleccione una marca.',
        validators: [Validators.required],
        // TODO hacer el SELECT de brandName
      },
      {
        label: 'Modelo', 
        controlName: 'model', 
        type: TypeField.TEXT, 
        placeholder: 'Ingrese el modelo', 
        errorMessage: 'Dato obligatorio. Máximo 50 caracteres.',
        validators: [Validators.required, Validators.maxLength(50), noWhitespaceValidator]
      },
      {
        label: 'Kilometraje', 
        controlName: 'mileage', 
        type: TypeField.NUMBER, 
        placeholder: 'Ingrese el kilometraje', 
        errorMessage: 'Dato obligatorio.',
        validators: [Validators.required, noWhitespaceValidator]
      },
      {
        label: 'Observaciones', 
        controlName: 'observations', 
        type: TypeField.TEXT, 
        placeholder: 'Ingrese las observaciones', 
        errorMessage: 'Máximo 300 caracteres.',
        validators: [Validators.maxLength(300)]
      }
    ];
  }

  saveData(data : any){
    this.onSave.emit(data)
  }

  updateData(data : any){
    this.onUpdate.emit(data)
  }

  showForm(){
    this.vehicleForm.form.reset();
    this.vehicleForm.visible = true;
  }

  resetAndHideForm(){
    this.vehicleForm.resetAll();
    this.vehicleForm.visible = false;
  }
}