import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { FloatLabelModule } from 'primeng/floatlabel';
import { InputTextModule } from 'primeng/inputtext';
import { Router } from '@angular/router';
import { emailCustomValidator } from '../../util/customValidators';
import { PasswordModule } from 'primeng/password';
import { AuthService } from '../../auth/auth.service';
import { EmployeeLogin } from '../../interfaces/model.interfaces';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/api';

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
    ToastModule
],
  templateUrl: './login-form.component.html',
  styleUrl: './login-form.component.css'
})
export class LoginFormComponent {
  loading : boolean = false;

  constructor(
    private authService : AuthService,
    private fb : FormBuilder,
    private router : Router,
    private messageService: MessageService
  ){}

  employeeForm : FormGroup = this.fb.group({
    email: ['', [Validators.required, emailCustomValidator]],
    password: ['', [Validators.required]]
  })

 
  sendData(){
    this.markAllAsTouched(this.employeeForm);

    if(this.employeeForm.valid){
      let employee : EmployeeLogin = this.employeeForm.value;
      this.loading = true;
      this.authService.login(employee).subscribe({
        next: (token) => {
          this.router.navigate(['/inicio']);
        },
        error: (error) => {
          this.loading = false;
          const errorMsg = error.message;
          if (error.message?.includes('Error Status: 4')) {
            this.showToastError('Woooo, las credenciales son inválidas 🥴');
          } else{
            this.showToastError('Ha ocurrido un error. Intente nuevamente o ponganse en contacto con el administrador.');
          }
        }
      })
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
    let field = this.employeeForm.get(nameField); 
    return (field?.dirty || field?.touched) && field?.invalid;
  }

  showToastError(message : string) {
    this.messageService.add({
      severity: 'error',
      summary: 'Error',
      detail: message
    });
  }
} 
