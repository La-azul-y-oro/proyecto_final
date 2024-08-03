import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges, ViewChild } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, Validators, FormGroup, FormControl } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { DialogModule } from 'primeng/dialog';
import { DropdownModule } from 'primeng/dropdown';
import { FloatLabelModule } from 'primeng/floatlabel';
import { InputTextModule } from 'primeng/inputtext';
import { FormField, TypeField } from '../../interfaces/components.interface';
import { noWhitespaceValidator, vehiclePlateValidator } from '../../util/customValidators';
import { FormComponent } from '../form/form.component';
import { FormArray } from '@angular/forms';
import { InputNumberModule } from 'primeng/inputnumber';
import { VehicleResponse, VehicleRequest, BrandResponse, BrandCategory } from '../../interfaces/model.interfaces';
import { BrandService } from '../../services/brand.service';
import { markAllAsTouched } from '../../util/formUtils';

@Component({
  selector: 'app-vehicle-form',
  standalone: true,
  imports: [ButtonModule, DialogModule, DropdownModule, FloatLabelModule, InputTextModule, InputNumberModule, CommonModule, ReactiveFormsModule, FormComponent],
  templateUrl: './vehicle-form.component.html',
  styleUrl: './vehicle-form.component.css'
})
export class VehicleFormComponent implements OnInit, OnChanges {
  @ViewChild("form") vehicleForm!: FormComponent;
  @Input() data? : any;
  @Output() onSave = new EventEmitter;
  @Output() onUpdate = new EventEmitter;

  brands: { label: string, value: number }[] = [];
  fields: FormField[];

  visible : boolean = false;
  isEditMode : boolean = false;
  form!: FormGroup;
  title? : string;
  @Input() titleOnCreate : string = "Crear registro";
  @Input() titleOnUpdate : string = "Actualizar registro";

  status!: boolean;
  idToUpdated? : number;
  vehicleList: VehicleResponse[] = [];
  dataVehicle?: VehicleRequest;

  constructor (private fb : FormBuilder, private brandService : BrandService ){
    this.fields = [
      {
        label: 'Patente', 
        controlName: 'plate', 
        type: TypeField.TEXT, 
        placeholder: 'Ingrese la patente', 
        errorMessage: 'Dato obligatorio. Formatos válidos: AAA111 / AA111BB',
        validators: [Validators.required, vehiclePlateValidator]
      },
      {
        label: 'Marca', 
        controlName: 'brandId', 
        type: TypeField.SELECT, 
        placeholder: '', 
        errorMessage: 'Seleccione una marca',
        selectList: this.brands,
        validators: [Validators.required],
      },
      {
        label: 'Modelo', 
        controlName: 'model', 
        type: TypeField.TEXT, 
        placeholder: 'Ingrese el modelo', 
        errorMessage: 'Dato obligatorio. Máximo 50 caracteres.',
        validators: [Validators.required, Validators.maxLength(50), noWhitespaceValidator]
      },
      {
        label: 'Kilometraje', 
        controlName: 'mileage', 
        type: TypeField.NUMBER, 
        placeholder: 'Ingrese el kilometraje', 
        errorMessage: 'Dato obligatorio. No puede ser negativo.',
        validators: [Validators.required, Validators.min(0), Validators.max(999999)]
      },
      {
        label: 'Observaciones', 
        controlName: 'observations', 
        type: TypeField.TEXT, 
        placeholder: 'Ingrese las observaciones', 
        errorMessage: 'Máximo 300 caracteres.',
        validators: [Validators.maxLength(300)]
      }
    ];
  }

  ngOnInit() {
    this.form = this.fb.group({});
    this.fields?.forEach(f => {
      const control = new FormControl(null, f.validators);
      this.form.addControl(f.controlName, control);
    });

    this.brandService.getAll().subscribe((brands: BrandResponse[]) => {
      this.brands = brands
        .filter(brand => brand.category !== BrandCategory.SPAREPART && !brand.deleted)
        .map(brand => ({
          label: brand.name,
          value: brand.id
      }));
      this.fields.find(field => field.controlName === 'brandId')!.selectList = this.brands;
    });
  }

  ngOnChanges(): void {
    if(this.data) {
      this.form.patchValue(this.data);
      this.title = this.titleOnUpdate;
      this.isEditMode = true;
    }else{
      this.title = this.titleOnCreate;
      this.isEditMode = false;
    }
  }

  showForm(){
    this.visible = true;
    this.form.reset();
  }

  showFormEdit(vehicle: any){
    this.idToUpdated = vehicle.id;
    
    const vehicleData: VehicleRequest = {
      plate: vehicle.plate,
      brandId: vehicle.brand.id,
      model: vehicle.model,
      mileage: vehicle.mileage,
      observations: vehicle.observations
    };

    this.dataVehicle = vehicleData;
    this.form.patchValue(this.dataVehicle);
    this.isEditMode = true;
    this.title = this.titleOnUpdate;
    this.visible = true;    
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

  saveData(data : any){
    this.onSave.emit(data)
  }

  updateData(data : any){
    this.onUpdate.emit(data)
  }

  sendData(){
    markAllAsTouched(this.form);

    if(this.form.valid){
      (this.isEditMode) ? this.onUpdate.emit({ id: this.idToUpdated!, vehicle: this.form.value }) : this.onSave.emit(this.form.value);
      this.visible = false;
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
}