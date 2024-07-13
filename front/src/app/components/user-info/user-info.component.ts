import { Component } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { MenubarModule } from 'primeng/menubar';

@Component({
  selector: 'app-user-info',
  standalone: true,
  imports: [MenubarModule],
  templateUrl: './user-info.component.html',
  styleUrl: './user-info.component.css'
})
export class UserInfoComponent {
  menubarStyle = {
    border: 'none',
    fontSize: '0.85rem'
  };

  items: MenuItem[] = [{
    label: 'Juan Carlos',
    icon: 'pi pi-user',
    items:[
      {
        label: 'Cerrar sesión',
        icon: 'pi pi-power-off'
      }
    ]
  }];
}
