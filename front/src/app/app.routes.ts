import { Routes } from '@angular/router';
import { ClientComponent } from './pages/client/client.component';
import { VehicleComponent } from './pages/vehicle/vehicle.component';
import { LoginFormComponent } from './components/login-form/login-form.component';
import { ServicesComponent } from './pages/services/services.component';
import { EmployeeComponent } from './pages/employee/employee.component';

export const routes: Routes = [
    { path: 'clientes', component: ClientComponent },
    { path: 'vehicles', component: VehicleComponent },
    { path: 'login', component: LoginFormComponent},
    { path: 'employees', component: EmployeeComponent},
    { path: 'services', component: ServicesComponent}
];
