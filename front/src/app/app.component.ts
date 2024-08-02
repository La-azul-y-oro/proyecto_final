import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { MessageService } from 'primeng/api';
import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';
import { ToastModule } from 'primeng/toast';
import { HeaderComponent } from './shared/header/header.component';
import { SidebarComponent } from './shared/sidebar/sidebar.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ButtonModule, CardModule, ToastModule, HeaderComponent, SidebarComponent, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  isSidebarVisible: boolean = false;

  constructor(private router: Router, private messageService: MessageService) { }

  toggleSidebar() {
    this.isSidebarVisible = !this.isSidebarVisible;
  }

  showToast() {
    this.messageService.add({ severity: 'success', summary: 'Bienvenido', detail: 'YAY! el toast funciona' });
  }

  routeLogin() {
    return this.router.url !== '/login';
  }

}