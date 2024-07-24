import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { DialogModule } from 'primeng/dialog';
import { DropdownModule } from 'primeng/dropdown';
import { FloatLabelModule } from 'primeng/floatlabel';
import { InputNumberModule } from 'primeng/inputnumber';
import { InputTextModule } from 'primeng/inputtext';
import { FormField, TypeField } from '../../interfaces/components.interface';

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
    ReactiveFormsModule
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
      this.form.patchValue(this.data)
      this.title = this.titleOnUpdate;
      this.isEditMode = true;
    }else{
      this.title = this.titleOnCreate;
      this.isEditMode = false;
    }
  }

  sendData(){
    this.markAllAsTouched(this.form);

    if(this.form.valid){
      (this.isEditMode) ? this.onUpdate.emit(this.form.value) : this.onSave.emit(this.form.value)
    }
  }

  hasError(nameField : any){
    let field = this.form.get(nameField); 
    return (field?.dirty || field?.touched) && field?.invalid;
  }

  isText(field : TypeField){
    return field === TypeField.TEXT;
  }

  isNumber(field : TypeField){
    return field === TypeField.NUMBER;
  }

  isSelect(field : TypeField){
    return field === TypeField.SELECT;
  }

  resetAll(){
    this.form.reset();
    this.data = undefined;
    this.isEditMode = false;
    this.title = this.titleOnCreate;    
  }

  markAllAsTouched(formGroup: FormGroup): void {
    Object.keys(formGroup.controls).forEach(field => {
      const control = formGroup.get(field);
      control?.markAsTouched({ onlySelf: true });
      control?.markAsDirty({ onlySelf: true });
  
      // Si el control es un FormGroup (anidado), marca todos sus campos también
      if (control instanceof FormGroup) {
        this.markAllAsTouched(control);
      }
  
      // Si el control es un FormArray, marca todos sus campos también
      if (control instanceof FormArray) {
        control.controls.forEach(group => this.markAllAsTouched(group as FormGroup));
      }
    });
  }
}
