import { Component, EventEmitter, Input, Output, ViewChild } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { FormField, TypeField } from '../../interfaces/components.interface';
import { FormComponent } from '../form/form.component';
import { emailCustomValidator, noWhitespaceValidator, nroDniValidator,  } from '../../util/customValidators';

@Component({
  selector: 'app-employee-form',
  standalone: true,
  imports: [
    CommonModule, 
    ReactiveFormsModule,
    FormComponent
  ],
  templateUrl: './employee-form.component.html'
})
export class EmployeeFormComponent {
  @ViewChild("form") clientForm!: FormComponent;
  @Input() data? : any;
  @Output() onSave = new EventEmitter;
  @Output() onUpdate = new EventEmitter;

  roles: { label: string, value: string }[];
  fields: FormField[];

  constructor (
    private fb : FormBuilder
  ){
    this.roles = [
      {
        label: "Administrativo",
        value: "ROLE_ADMINISTRATIVE"
      },
      {
        label: "Mecánico",
        value: "ROLE_MECHANIC"
      },
      {
        label: "Admin",
        value: "ROLE_ADMIN"
      }
    ];

    this.fields = [
      {
        label: 'Nombre', 
        controlName: 'name', 
        type: TypeField.TEXT, 
        placeholder: 'Ingrese el nombre', 
        errorMessage: 'Dato obligatorio. Máximo 50 caracteres.',
        validators: [Validators.required, Validators.maxLength(50), noWhitespaceValidator]
      },
      {
        label: 'Apellido',
        controlName: 'lastName',
        type: TypeField.TEXT,
        placeholder: 'Ingrese el apellido',
        errorMessage: 'Dato obligatorio. Máximo 50 caracteres.',
        validators: [Validators.required, Validators.maxLength(50), noWhitespaceValidator]
      },
      {
        label: 'Email',
        controlName: 'email',
        type: TypeField.TEXT,
        placeholder: 'Ingrese el email',
        errorMessage: 'El mail es inválido.',
        validators: [Validators.required, emailCustomValidator]
      },
      {
        label: 'Número de documento', 
        controlName: 'identificationNumber',
        type: TypeField.NUMBER,
        placeholder: 'Ingrese el número de documento',
        errorMessage: 'Debe ingresar 8 digitos para DNI.',
        validators: [Validators.required, nroDniValidator],
        min: 10000000,
        max: 99999999,
        maxLength: 8
      },
      {
        label: 'Rol', 
        controlName: 'role',
        type: TypeField.SELECT,
        placeholder: 'Ingrese el rol',
        errorMessage: 'El dato es obligatorio',
        selectList: this.roles,
        validators: [Validators.required]
      },
      {
        label: 'Calle', 
        controlName: 'street',
        type: TypeField.TEXT,
        placeholder: 'Ingrese la calle',
        errorMessage: 'Máximo 255 caracteres. No se permiten espacios en blanco',
        validators: [Validators.maxLength(255), noWhitespaceValidator],
        groupBy: "address"
      },
      {
        label: 'Número', 
        controlName: 'number',
        type: TypeField.NUMBER,
        placeholder: 'Ingrese el número',
        errorMessage: 'Dato obligatorio. Máximo 6 digitos.',
        validators: [Validators.required, Validators.min(0), Validators.max(999999)],
        groupBy: "address",
        min: 0,
        maxLength: 6
      },
      {
        label: 'Piso', 
        controlName: 'floor',
        type: TypeField.TEXT,
        placeholder: 'Ingrese el piso',
        errorMessage: 'No se permiten espacios en blanco',
        validators: [noWhitespaceValidator],
        groupBy: "address"
      },
      {
        label: 'Departamento', 
        controlName: 'department',
        type: TypeField.TEXT,
        placeholder: 'Ingrese el departamento',
        errorMessage: 'No se permiten espacios en blanco',
        validators: [noWhitespaceValidator],
        groupBy: "address"
      },
      {
        label: 'Contraseña', 
        controlName: 'password',
        type: TypeField.PASSWORD,
        placeholder: 'Ingrese la contraseña',
        errorMessage: 'El dato es obligatorio',
        validators: [Validators.required],
        disabledOnUpdate: true
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
    this.clientForm.form.reset();
    this.clientForm.visible = true;
  }

  resetAndHideForm(){
    this.clientForm.resetAll();
    this.clientForm.visible = false;
  }
}
