import { Component, EventEmitter, Input, Output } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { MenuModule } from 'primeng/menu';
import { SidebarModule } from 'primeng/sidebar';
import { TooltipModule } from 'primeng/tooltip';
import { AuthService } from '../../auth/auth.service';
import { hasValidRoles } from '../../util/rolesUtil';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [
    CommonModule,
    MenuModule,
    SidebarModule,
    TooltipModule
  ],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent {
  @Input() visible : boolean = false;
  @Output() hide = new EventEmitter;

  textTooltip : string = "Función no disponible";

  year : number = new Date().getFullYear();

  menubarStyle = {
    width: '100%',
  };

  items: MenuItem[] = [
  {
    label: 'Inicio',
    icon: 'pi pi-home',
    path: 'inicio'
  },
  {
    label: 'Clientes',
    icon: 'pi pi-users',
    path: 'clientes',
    isDisabled: !hasValidRoles(this.authService.employeeData, ["ROLE_ADMIN", "ROLE_ADMINISTRATIVE"])
  },
  {
    label: 'Pagos',
    icon: 'pi pi-wallet',
    isDisabled: !hasValidRoles(this.authService.employeeData, [])
  },
  {
    label: 'Servicios',
    icon: 'pi pi-history',
    path: 'servicios',
    isDisabled: !hasValidRoles(this.authService.employeeData, ["ROLE_ADMIN", "ROLE_ADMINISTRATIVE", "ROLE_MECHANIC"])
  },
  {
    label: 'Vehiculos',
    icon: 'pi pi-car',
    path: 'vehiculos',
    isDisabled: !hasValidRoles(this.authService.employeeData, ["ROLE_ADMIN", "ROLE_ADMINISTRATIVE"])
  },
  {
    label: 'Inventario',
    icon: 'pi pi-objects-column',
    isDisabled: !hasValidRoles(this.authService.employeeData, [])
  },
  {
    label: 'Marcas',
    icon: 'pi pi-sparkles',
    isDisabled: !hasValidRoles(this.authService.employeeData, [])
  },
  {
    label: 'Proveedores',
    icon: 'pi pi-warehouse',
    isDisabled: !hasValidRoles(this.authService.employeeData, [])
  },
  {
    label: 'Repuestos',
    icon: 'pi pi-wrench',
    isDisabled: !hasValidRoles(this.authService.employeeData, [])
  },
  {
    label: 'Empleados',
    icon: 'pi pi-briefcase',
    path: 'empleados',
    isDisabled: !hasValidRoles(this.authService.employeeData, ["ROLE_ADMIN"])
  }];

  constructor (
    private authService : AuthService
  ){}

  sidebarStyle = {
    border: 'none',
  };

  hideEmit(){
    this.hide.emit();
  }
}
