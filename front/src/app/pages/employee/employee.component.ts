import { Component, ViewChild } from '@angular/core';
import { ActionButtonConfig } from '../../components/action-buttons/action-buttons.component';
import { EmployeeRequest, EmployeeResponse, Role } from '../../interfaces/model.interfaces';
import { ConfirmDialogComponent } from '../../components/confirm-dialog/confirm-dialog.component';
import { ToastComponent } from '../../components/toast/toast.component';
import { Column } from '../../interfaces/components.interface';
import { EmployeeService } from '../../services/employee.service';
import { EmployeeFormComponent } from '../../components/employee-form/employee-form.component';
import { PageComponent } from '../../components/page/page.component';
import { ToastModule } from 'primeng/toast';
import { hasValidRoles } from '../../util/rolesUtil';
import { AuthService } from '../../auth/auth.service';


@Component({
  selector: 'app-employee',
  standalone: true,
  imports: [
    ConfirmDialogComponent,
    EmployeeFormComponent,
    ToastComponent,
    PageComponent,
    ToastModule
  ],
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent {
  @ViewChild('dialog') dialog!: ConfirmDialogComponent;
  @ViewChild('toast') toast!: ToastComponent;
  @ViewChild('form') form!: EmployeeFormComponent;

  title : string = "Empleados";
  labelButtonAdd : string = "Agregar empleado";
  status! : boolean;
  idToUpdated? : number;
  employeeList : EmployeeResponse[] = [];

  canCreate : boolean = hasValidRoles(this.authService.employeeData, ["ROLE_ADMIN"]);
  canEdit : boolean = hasValidRoles(this.authService.employeeData, ["ROLE_ADMIN"]);
  canRemove : boolean = hasValidRoles(this.authService.employeeData, ["ROLE_ADMIN"]);

  columns : Column []= [
    {
      header: "Nombre",
      field: "name",
      sortable: true
    },
    {
      header: "Apellido",
      field: "lastName",
      sortable: true
    },
    {
      header: "E-Mail",
      field: "email",
      sortable: true
    },
    {
      header: "Nro. documento",
      field: "identificationNumber",
      sortable: true
    },
    {
      header: "Rol",
      field: "roleText",
      sortable: true
    },
    {
      header: "Dirección",
      field: "addressCompound",
      sortable: true
    }
  ];

  buttonConfig: ActionButtonConfig[] = [
    { 
      icon: 'pi pi-pencil', 
      tooltip: 'Editar registro', 
      severity: 'success', 
      isDisabled: !this.canEdit,
      action: (data: any) => this.canEdit ? this.openFormEdit(data) : null 
    },
    { 
      icon: 'pi pi-trash', 
      tooltip: 'Borrar registro', 
      severity: 'danger', 
      isDisabled: !this.canRemove,
      action: (data: any) => this.canRemove ? this.openConfirmDialog(data) : null
    }
  ];

  dataEmployee? : EmployeeRequest;

  constructor(
    private employeeService : EmployeeService,
    private authService : AuthService
  ){}

  ngOnInit(){
    this.loadEmployees();
  }

  loadEmployees(){
    this.employeeService.getAll().subscribe(response => {
       this.employeeList = response
      .filter(e => !e.deleted)
      .map(e => {
        return this.processEmployee(e);
      });

    });
  }

  openForm(){
    this.form.showForm();
  }

  save(employee : EmployeeRequest){
    this.employeeService.create(employee).subscribe({
      next: (employee) => {
        this.toast.showSuccessCreate();
        this.handlePostCreate(employee);
      },
      error: (error: any) => {
        this.toast.showErrorCreate();
        console.error(error);
      }
    }) 
  }

  openFormEdit(employee : any){
    this.idToUpdated = employee.id;
    this.dataEmployee = { ...employee };
    this.form.showForm();
  }

  update(employee : EmployeeRequest){
    this.employeeService.update(this.idToUpdated!, employee).subscribe({
      next: (employee) => {
        this.toast.showSuccessUpdate();
        this.handlePostUpdate(employee);
      },
      error: (error) => {
        this.toast.showErrorUpdate();
        console.error(error);
      }
    }) 
  }

  openConfirmDialog(employee : any){
    this.dialog.openDialog(employee.id);
  }
  
  deleteEmployee(id : any){
    this.employeeService.deleteById(id).subscribe({
      next: () => {
        this.toast.showSuccessDelete();
        this.employeeList = this.employeeList.filter(item => item.id !== id);
      },
      error: (error) => {
        this.toast.showErrorDelete();
        console.error(error);
      }
    }) 
  }

  linkemployee(employee : any){
    alert("TODO relacionadas sin implementar");
  }

  handlePostUpdate(employee : EmployeeResponse){
    const updatedEmployee = this.processEmployee(employee);

    const index = this.employeeList.findIndex(item => item.id === employee.id);
    this.employeeList[index] = updatedEmployee;

    this.form.resetAndHideForm();
    this.idToUpdated = undefined;
    this.dataEmployee = undefined;
  }

  handlePostCreate(employee : EmployeeResponse){
    const newEmployee = this.processEmployee(employee);

    let list = [...this.employeeList];
    list.push(newEmployee);
    
    this.employeeList = list;

    this.form.resetAndHideForm();
  }

  private processEmployee(employee : EmployeeResponse) : EmployeeResponse{
    const roleText = Role[employee.role as unknown as keyof typeof Role];
    const addr = employee.address;
    const addressCompound = `${addr.street || ''} ${addr.number || ''} ${addr.floor || ''} ${addr.department || ''}`.trim();

    employee = {
        ...employee,
        roleText,
        addressCompound
    }

    return employee;
  }
}
