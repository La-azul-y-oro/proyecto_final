import { Component, EventEmitter, Input, Output } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { SidebarModule } from 'primeng/sidebar';
import { MenuModule } from 'primeng/menu';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [SidebarModule, MenuModule],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent {
  @Input() visible : boolean = false;
  @Output() hide = new EventEmitter;

  year : number = new Date().getFullYear();

  menubarStyle = {
    width: '100%',
  };

  items: MenuItem[] = [{
    label: 'Clientes',
    icon: 'pi pi-users',
    path: 'clientes'
  },
  {
    label: 'Pagos',
    icon: 'pi pi-wallet',
    disabled: true
  },
  {
    label: 'Servicios',
    icon: 'pi pi-history'
  },
  {
    label: 'Vehiculos',
    icon: 'pi pi-car',
    path: 'vehicles'
  },
  {
    label: 'Inventario',
    icon: 'pi pi-objects-column',
    disabled: true
  },
  {
    label: 'Marcas',
    icon: 'pi pi-sparkles',
    disabled: true
  },
  {
    label: 'Proveedores',
    icon: 'pi pi-warehouse',
    disabled: true
  },
  {
    label: 'Repuestos',
    icon: 'pi pi-wrench',
    disabled: true
  }];

  sidebarStyle = {
    border: 'none',
  };

  hideEmit(){
    this.hide.emit();
  }
}
