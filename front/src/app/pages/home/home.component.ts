import { Component } from '@angular/core';
import { CardModule } from 'primeng/card';
import { DividerModule } from 'primeng/divider';
import { CarouselModule } from 'primeng/carousel';
import { EmployeeBasicResponse, ServiceResponse, SparePartResponse, StatusService, VehicleBasicResponse } from '../../interfaces/model.interfaces';
import { ButtonModule } from 'primeng/button';
import { ServicesService } from '../../services/services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CardModule, DividerModule, CarouselModule, ButtonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  welcome: string = '';
  serviceList: ServiceResponse[] = [];

  constructor(private servicesService: ServicesService, private router: Router) {}

  ngOnInit() {
    this.loadWelcome();
    this.loadServices();
  }

  loadServices() {
    this.servicesService.getAll().subscribe(response => {
      this.serviceList = response
        .filter(e => e.status !== StatusService.CANCELLED && e.status !== StatusService.FINISHED)
        .sort((a, b) => {
          if (a.status === StatusService.TO_DO && b.status !== StatusService.TO_DO) return -1;
          if (a.status === StatusService.IN_PROGRESS && b.status !== StatusService.IN_PROGRESS) return b.status === StatusService.TO_DO ? 1 : -1;
          return 0;
        })
        .map(e => {
          return this.processService(e);
        });
    });
  }


  private processService(service: ServiceResponse) {
    const vehicle: VehicleBasicResponse = service.vehicle;
    const vehicleCompound: string = `${vehicle.brand || ''} ${vehicle.model || ''}`.trim();
    const showedStatus: string = this.mapStatusToDescription(service.status);
    service = { ...service, vehicleCompound, showedStatus }
    return service;
  }

  private mapStatusToDescription(status: StatusService): string {
    const statusMapping: { [key in StatusService]: string } = {
      [StatusService.TO_DO]: 'Pendiente',
      [StatusService.IN_PROGRESS]: 'En progreso',
      [StatusService.FINISHED]: 'Finalizado',
      [StatusService.CANCELLED]: 'Cancelado'
    };
    return statusMapping[status];
  }

  private loadWelcome() {
    const hours = new Date().getHours();
    if (hours < 12) {
      this.welcome = 'Buenos días';
    } else if (hours < 20) {
      this.welcome = 'Buenas tardes';
    } else {
      this.welcome = 'Buenas noches';
    }
  }

  goToServices() {
    this.router.navigate(['/servicios']);
  }
    
}