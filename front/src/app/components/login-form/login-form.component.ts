import { CommonModule } from '@angular/common';
import { Component, Input, Output, ViewChild } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { FloatLabelModule } from 'primeng/floatlabel';
import { InputTextModule } from 'primeng/inputtext';
import { Router } from '@angular/router';
import { emailCustomValidator } from '../../util/customValidators';
import { PasswordModule } from 'primeng/password';

@Component({
  selector: 'app-login-form',
  standalone: true,
  imports: [
    ButtonModule,
    FloatLabelModule,
    InputTextModule,
    CommonModule,
    ReactiveFormsModule,
    PasswordModule,
],
  templateUrl: './login-form.component.html',
})
export class LoginFormComponent {
  
  constructor(
    private fb : FormBuilder,
    private router : Router
  ){}

  userForm : FormGroup = this.fb.group({
    username: ['', [Validators.required, emailCustomValidator]],
    password: ['', [Validators.required]]
  })

 
  sendData(){
    this.markAllAsTouched(this.userForm);

    if(this.userForm.valid){
      //TO_DO implementar seguridad del front 
      //aca se dispara la peticion de logeo
    }
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

  hasError(nameField : any){
    let field = this.userForm.get(nameField); 
    return (field?.dirty || field?.touched) && field?.invalid;
  }

} 
