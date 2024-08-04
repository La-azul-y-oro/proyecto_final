import { Routes } from '@angular/router';
import { ClientComponent } from './pages/client/client.component';
import { VehicleComponent } from './pages/vehicle/vehicle.component';
import { LoginFormComponent } from './components/login-form/login-form.component';
import { ServicesComponent } from './pages/services/services.component';
import { EmployeeComponent } from './pages/employee/employee.component';
import { authGuard, authGuardNotLogin } from './auth/auth.guard';
import { HomeComponent } from './pages/home/home.component';

export const routes: Routes = [
    { path: 'inicio', component: HomeComponent, canActivate: [authGuard] },
    { path: 'clientes', component: ClientComponent, canActivate: [authGuard] },
    { path: 'vehiculos', component: VehicleComponent, canActivate: [authGuard] },
    { path: 'login', component: LoginFormComponent, canActivate: [authGuardNotLogin] },
    { path: 'empleados', component: EmployeeComponent, canActivate: [authGuard] },
    { path: 'servicios', component: ServicesComponent, canActivate: [authGuard] },
    { path: '', redirectTo: 'inicio', pathMatch: 'full' },
    { path: '**', redirectTo: 'inicio' }
];
