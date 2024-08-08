import { Component, EventEmitter, Input, OnChanges, OnInit, Output, ViewChild } from '@angular/core';
import { FormComponent } from '../form/form.component';
import { FormField, TypeField } from '../../interfaces/components.interface';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ServiceTypeService } from '../../services/serviceType.service';
import { VehicleService } from '../../services/vehicle.service';
import { ClientService } from '../../services/client.service';
import { EmployeeService } from '../../services/employee.service';
import { ClientResponse, EmployeeBasicResponse, EmployeeResponse, ServiceResponse, ServiceTypeResponse, SparePartResponse, StatusService, VehicleResponse } from '../../interfaces/model.interfaces';
import { SparePartService } from '../../services/sparePart.service';
import { DialogModule } from 'primeng/dialog';
import { FloatLabelModule } from 'primeng/floatlabel';
import { InputNumberModule } from 'primeng/inputnumber';
import { ButtonModule } from 'primeng/button';
import { DropdownModule } from 'primeng/dropdown';
import { InputTextModule } from 'primeng/inputtext';
import { CommonModule } from '@angular/common';
import { MultiSelectModule } from 'primeng/multiselect';
import { hasValidRoles } from '../../util/rolesUtil';
import { AuthService } from '../../auth/auth.service';
import { markAllAsTouched } from '../../util/formUtils';

@Component({
  selector: 'app-service-form',
  standalone: true,
  imports: [
    FormComponent,
    DialogModule,
    FloatLabelModule,
    InputNumberModule,
    InputTextModule,
    DropdownModule,
    ButtonModule,
    CommonModule,
    ReactiveFormsModule,
    MultiSelectModule
  ],
  templateUrl: './service-form.component.html',
  styleUrl: './service-form.component.css'
})
export class ServiceFormComponent implements OnInit, OnChanges {
  @ViewChild("form") servicesForm!: FormComponent;
  @Input() data: any;
  @Input() titleOnCreate: string = 'Crear registro';
  @Input() titleOnUpdate: string = 'Actualizar registro';
  @Output() onSave = new EventEmitter;
  @Output() onUpdate = new EventEmitter; 

  canEdit = hasValidRoles(this.authService.employeeData,["ROLE_ADMIN", "ROLE_ADMINISTRATIVE"]);

  fields: FormField[];
  serviceTypes: { label: string, value: number }[] = [];
  vehicles: { label: string, value: number }[] = [];
  clients: { label: string, value: number }[] = [];
  employees: { label: string, value: number }[] = [];
  spareParts: { label: string, value: number }[] = [];
  statusOptions: { label: string, value: StatusService }[] = [
    { label: 'Pendiente', value: StatusService.TO_DO },
    { label: 'En progreso', value: StatusService.IN_PROGRESS },
    { label: 'Finalizado', value: StatusService.FINISHED },
    { label: 'Cancelado', value: StatusService.CANCELLED }
  ];

  form!: FormGroup;
  visible: boolean = false;
  isEditMode: boolean = false;
  title?: string;
  status!: boolean;
  idToUpdated? : number;
  serviceList: ServiceResponse[] = []; 

  constructor(
    private fb: FormBuilder,
    private serviceTypeService: ServiceTypeService,
    private vehicleService: VehicleService,
    private clientService: ClientService, 
    private employeeService: EmployeeService,
    private sparePartsService: SparePartService,
    private authService : AuthService
  ){    
    this.fields = [
      {
        label: 'Tipo de servicio',
        controlName: 'serviceTypeId',
        type: TypeField.SELECT,
        placeholder: '',
        errorMessage: 'Seleccione un tipo de servicio',
        selectList: this.serviceTypes,
        validators: [Validators.required],
        disabledOnUpdate: !this.canEdit
      },
      {
        label: 'Vehículo',
        controlName: 'vehicleId',
        type: TypeField.SELECT,
        placeholder: '',
        errorMessage: 'Seleccione un vehículo',
        selectList: this.vehicles,
        validators: [Validators.required],
        disabledOnUpdate: !this.canEdit
      },
      {
        label: 'Cliente',
        controlName: 'clientId',
        type: TypeField.SELECT,
        placeholder: '',
        errorMessage: 'Seleccione un cliente',
        selectList: this.clients,
        validators: [Validators.required],
        disabledOnUpdate: !this.canEdit
      },
      {
        label: 'Repuestos',
        controlName: 'sparePartsIds',
        type: TypeField.MULTISELECT,
        placeholder: '',
        selectList: this.spareParts
      },
      {
        label: 'Empleados asignados',
        controlName: 'employeesIds',
        type: TypeField.MULTISELECT,
        placeholder: '',
        selectList: this.employees,
        disabledOnUpdate: !this.canEdit
      },
      {
        label: 'Estado',
        controlName: 'status',
        type: TypeField.SELECT,
        placeholder: '',
        selectList: this.statusOptions,
        errorMessage: 'Indique un estado',
        validators: [Validators.required],
      },
      {
        label: 'Precio',
        controlName: 'price',
        type: TypeField.NUMBER,
        placeholder: '$0.00',
        disabledOnUpdate: !this.canEdit
      }
    ]
  }

  ngOnInit(): void {
    this.form = this.fb.group({});
    this.fields?.forEach(f => {
      const control = new FormControl(null, f.validators);
      this.form.addControl(f.controlName, control);
    })
    
    this.getServicesTypes();
    this.getVehicles();
    this.getClients();
    this.getSpareParts();
    this.getMechanics();
  }


  ngOnChanges(): void {
    if(this.data){
      const sparePartsIds = this.data.spareParts?.map((sparePart: SparePartResponse) => sparePart.id);
      const employeesIds = this.data.employees?.map((employee: EmployeeBasicResponse) => employee.id);

      const service = {
        ...this.data,
        sparePartsIds,
        employeesIds,
        clientId: this.data.client.id,
        vehicleId: this.data.vehicle.id,
        serviceTypeId: this.data.serviceType.id,
      };

      this.form.patchValue(service);
      this.title = this.titleOnUpdate;
      this.isEditMode = true;

      this.fields?.forEach(field => {
        if (field.disabledOnUpdate) {
          this.form.get(field.controlName)?.disable();
        }
      });
    } else{
      this.title = this.titleOnCreate;
      this.isEditMode = false;
    }
  }

  private getClientName(client: ClientResponse): string {
    if(!client.businessName){
      return (client.name + ' ' + client.lastName);
    } else{
      return client.businessName;
    }
  }

  showForm(){
    this.visible = true;
    this.form.reset();
  }

  resetAndHideForm(){
    this.form.reset();
    this.data = undefined;
    this.isEditMode = false;
    this.title = this.titleOnCreate;
    this.visible = false;
  }

  isText(field : TypeField){
    return field === TypeField.TEXT;
  }

  isNumber(field : TypeField){
    return field === TypeField.NUMBER;
  }

  isSelect(field : TypeField){
    return field === TypeField.SELECT;
  }

  isMultiSelect(field: TypeField){
    return field === TypeField.MULTISELECT;
  }

  isCalendar(field: TypeField){
    return field === TypeField.CALENDAR;
  }

  sendData(){
    markAllAsTouched(this.form);

    if(this.form.valid){
      (this.isEditMode) ? this.onUpdate.emit(this.form.value ) : this.onSave.emit(this.form.value);
    }
  }

  hasError(nameField : any){
    let field = this.form.get(nameField); 
    return (field?.dirty || field?.touched) && field?.invalid;
  }

  resetAll(){
    this.form.reset();
    this.data = undefined;
    this.isEditMode = false;
    this.title = this.titleOnCreate;
  }

  private getMechanics() {
    this.employeeService.getAll().subscribe((employees: EmployeeResponse[]) => {
      this.employees = employees
        .filter(employee => !employee.deleted && employee.role as string == "ROLE_MECHANIC")
        .map(employee => ({
          label: (employee.name + ' ' + employee.lastName),
          value: employee.id
        }));
      this.fields.find(field => field.controlName === 'employeesIds')!.selectList = this.employees;
    });
  }

  private getSpareParts() {
    this.sparePartsService.getAll().subscribe((spareParts: SparePartResponse[]) => {
      this.spareParts = spareParts
        .filter(sparePart => !sparePart.isDeleted)
        .map(sparePart => ({
          label: sparePart.name,
          value: sparePart.id
        }));
      this.fields.find(field => field.controlName === 'sparePartsIds')!.selectList = this.spareParts;
    });
  }

  private getClients() {
    this.clientService.getAll().subscribe((clients: ClientResponse[]) => {
      this.clients = clients
        .filter(client => !client.deleted)
        .map(client => ({
          label: this.getClientName(client),
          value: client.id
        }));
      this.fields.find(field => field.controlName === 'clientId')!.selectList = this.clients;
    });
  }

  private getVehicles() {
    this.vehicleService.getAll().subscribe((vehicles: VehicleResponse[]) => {
      this.vehicles = vehicles
        .filter(vehicle => !vehicle.deleted)
        .map(vehicle => ({
          label: `${vehicle.brand.name || ''} ${vehicle.model || ''} - ${vehicle.plate || ''}`,
          value: vehicle.id
        }));
      this.fields.find(field => field.controlName === 'vehicleId')!.selectList = this.vehicles;
    });
  }

  private getServicesTypes() {
    this.serviceTypeService.getAll().subscribe((serviceTypes: ServiceTypeResponse[]) => {
      this.serviceTypes = serviceTypes
        .filter(serviceType => !serviceType.isDeleted)
        .map(serviceType => ({
          label: serviceType.name,
          value: serviceType.id
        }));
      this.fields.find(field => field.controlName === 'serviceTypeId')!.selectList = this.serviceTypes;
    });
  }
}
