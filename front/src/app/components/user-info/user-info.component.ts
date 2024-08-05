import { Component } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { MenubarModule } from 'primeng/menubar';
import { AuthService } from '../../auth/auth.service';
import { Role } from '../../interfaces/model.interfaces';

@Component({
  selector: 'app-user-info',
  standalone: true,
  imports: [MenubarModule],
  templateUrl: './user-info.component.html',
  styleUrl: './user-info.component.css'
})
export class UserInfoComponent {

  constructor(
    private authService : AuthService
  ) {}
  
  menubarStyle = {
    border: 'none',
    fontSize: '0.85rem'
  };

  items: MenuItem[] = [{
    label: this.getUserInfo(),
    icon: 'pi pi-user',
    items:[
      {
        label: 'Cerrar sesión',
        icon: 'pi pi-power-off',
        command: () => this.authService.logout()
      }
    ]
  }];

  private getUserInfo() : string{
    const userInfo = this.authService?.employeeData as any;
    const name = userInfo?.name;
    const lastName = userInfo?.lastName;
    const role = (userInfo?.role) ? `- ${Role[userInfo.role as keyof typeof Role]}` : "";

    return `${name} ${lastName} ${role}`;
  }

}
