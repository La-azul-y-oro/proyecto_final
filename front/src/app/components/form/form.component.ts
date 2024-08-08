import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, OnChanges, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { DialogModule } from 'primeng/dialog';
import { DropdownModule } from 'primeng/dropdown';
import { FloatLabelModule } from 'primeng/floatlabel';
import { InputNumberModule } from 'primeng/inputnumber';
import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import { FormField, TypeField } from '../../interfaces/components.interface';
import { markAllAsTouched } from '../../util/formUtils';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [
    ButtonModule,
    DialogModule,
    DropdownModule,
    FloatLabelModule,
    InputNumberModule,
    InputTextModule,
    CommonModule, 
    ReactiveFormsModule,
    PasswordModule
  ],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent implements OnChanges{
  @Input() data? : any;
  @Input() titleOnCreate : string = "Crear registro";
  @Input() titleOnUpdate : string = "Actualizar registro";
  @Input() fields!: FormField[];

  @Output() onSave = new EventEmitter;
  @Output() onUpdate = new EventEmitter;

  visible : boolean = false;
  form!: FormGroup;
  isEditMode : boolean = false;
  title? : string;

  constructor (
    private fb : FormBuilder
  ){}

  ngOnInit(){
    this.form = this.fb.group({});
    this.fields?.forEach(f => {
      const control = new FormControl(null, f.validators);

      this.form.addControl(f.controlName, control);
    });
  }

  ngOnChanges(): void {
    if(this.data) {
      this.ungroupFormFields(this.data)

      this.title = this.titleOnUpdate;
      this.isEditMode = true;

      this.fields?.forEach(field => {
        if (field.disabledOnUpdate) {
          this.form.get(field.controlName)?.disable();
        }
      });
    }else{
      this.title = this.titleOnCreate;
      this.isEditMode = false;
    }
  }

  sendData(){
    markAllAsTouched(this.form);

    if(this.form.valid){
      const form = this.groupFormFields();
      (this.isEditMode) ? this.onUpdate.emit(form) : this.onSave.emit(form)
    }
  }

  hasError(nameField : any){
    let field = this.form.get(nameField); 
    return (field?.dirty || field?.touched) && field?.invalid;
  }

  isFieldType(field: TypeField, type: string): boolean {
    switch (type) {
      case TypeField.TEXT:
        return field === TypeField.TEXT;
      case TypeField.NUMBER:
        return field === TypeField.NUMBER;
      case TypeField.SELECT:
        return field === TypeField.SELECT;
      case TypeField.PASSWORD:
        return field === TypeField.PASSWORD;
      default:
        return false;
    }
  } 

  resetAll(){
    this.form.reset();
    this.data = undefined;
    this.isEditMode = false;
    this.title = this.titleOnCreate;
    this.form.enable();
  }

  private groupFormFields() {
    const organizedData: any = {};
  
    this.fields.forEach(field => {
      const controlValue = this.form.get(field.controlName)?.value;
      
      if (field.groupBy) {
        if (!organizedData[field.groupBy]) {
          organizedData[field.groupBy] = {};
        }
        organizedData[field.groupBy][field.controlName] = controlValue;
      } else {
        organizedData[field.controlName] = controlValue;
      }
    });
  
    return organizedData;
  }

  private ungroupFormFields(organizedData: any) {
    Object.keys(organizedData).forEach(key => {
      const value = organizedData[key];
  
      if (typeof value === 'object' && value !== null && !Array.isArray(value)) {
        Object.keys(value).forEach(subKey => {
          this.form.get(subKey)?.patchValue(value[subKey]);
        });
      } else {
        this.form.get(key)?.patchValue(value);
      }
    });
  }

}
