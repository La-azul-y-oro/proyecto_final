import { FormArray, FormGroup } from "@angular/forms";

export const markAllAsTouched = (formGroup: FormGroup) =>  {
    Object.keys(formGroup.controls).forEach(field => {
      const control = formGroup.get(field);
      control?.markAsTouched({ onlySelf: true });
      control?.markAsDirty({ onlySelf: true });
  
      if (control instanceof FormGroup) {
        markAllAsTouched(control);
      }
  
      if (control instanceof FormArray) {
        control.controls.forEach(group => markAllAsTouched(group as FormGroup));
      }
    });
  }