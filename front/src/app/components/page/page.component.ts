import { Component, EventEmitter, Input, Output, ViewChild } from '@angular/core';
import { Table, TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { TooltipModule } from 'primeng/tooltip';
import { IconFieldModule } from 'primeng/iconfield';
import { InputIconModule } from 'primeng/inputicon';
import { InputTextModule } from 'primeng/inputtext';
import { CommonModule } from '@angular/common';
import { Column } from '../../interfaces/table.interface';

@Component({
  selector: 'app-page',
  standalone: true,
  imports: [
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
  @Input() data? : any [] = [];
  @Input() cols!: Column[];
  
  @Output() onCreate = new EventEmitter;
  @Output() onEdit = new EventEmitter;
  @Output() onDelete = new EventEmitter;
  @Output() onLink = new EventEmitter;
  
  buttonStyle = {
    fontSize: '0.8rem'
  };

  iconFieldStyle = {
    fontSize: '0.8rem',
    paddingTop: '0.5rem',
    paddingBottom: '0.5rem',
  };

  styleButtonAction = {
    height: '30px',
    width: '30px', 
    padding: '0px',
  };

  create(){
    this.onCreate.emit();
  }

  link(item : any){
    this.onLink.emit(item);
  }

  edit(item : any){
    this.onEdit.emit(item);
  }

  remove(item : any){
    this.onDelete.emit(item);
  }

  filter(event : any){
    this.dt.filterGlobal(event.target.value, 'contains');
  }
}
