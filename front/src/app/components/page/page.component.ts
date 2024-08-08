import { Component, EventEmitter, Input, Output, ViewChild } from '@angular/core';
import { Table, TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { TooltipModule } from 'primeng/tooltip';
import { IconFieldModule } from 'primeng/iconfield';
import { InputIconModule } from 'primeng/inputicon';
import { InputTextModule } from 'primeng/inputtext';
import { CommonModule } from '@angular/common';
import { Column } from '../../interfaces/components.interface';
import { ActionButtonsComponent, ActionButtonConfig } from '../action-buttons/action-buttons.component';

@Component({
  selector: 'app-page',
  standalone: true,
  imports: [
    ActionButtonsComponent,
    CommonModule,
    ButtonModule,
    IconFieldModule, 
    InputTextModule, 
    InputIconModule,
    TableModule,
    TooltipModule],
  templateUrl: './page.component.html',
  styleUrl: './page.component.css'
})
export class PageComponent {
  @ViewChild('table') dt!: Table;

  @Input() title?: string = "";
  @Input() labelButtonAdd?: string = "";
  @Input() data : any [] = [];
  @Input() cols!: Column[];
  @Input() buttonConfig!: ActionButtonConfig[];
  @Input() canCreate : boolean = false;
  
  @Output() onCreate = new EventEmitter;

  buttonStyle = {
    fontSize: '0.8rem'
  };

  iconFieldStyle = {
    fontSize: '0.8rem',
    paddingTop: '0.5rem',
    paddingBottom: '0.5rem',
  };

  create(){
    if(!this.canCreate) return;
    this.onCreate.emit();
  }

  filter(event : any){
    this.dt.filterGlobal(event.target.value, 'contains');
  }

  getNestedProperty(obj: any, path: string): any {
    return path.split('.').reduce((o, p) => o && o[p], obj);
  }
}
