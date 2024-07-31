import { Routes } from '@angular/router';
import { ClientComponent } from './pages/client/client.component';
import { VehicleComponent } from './pages/vehicle/vehicle.component';
import { EmployeeComponent } from './pages/employee/employee.component';

export const routes: Routes = [
    { path: 'clientes', component: ClientComponent },
    { path: 'vehicles', component: VehicleComponent },
    { path: 'employees', component: EmployeeComponent }
];
