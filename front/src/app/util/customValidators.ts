import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export function emailCustomValidator(control: AbstractControl): ValidationErrors | null {
  const emailRegex = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Z|a-z]{2,}$/;
  const valid = emailRegex.test(control.value);
  return valid ? null : { invalidEmail: true };
}

export function nroDocumentValidator(control: AbstractControl): ValidationErrors | null {
  const value = control.value;
  if (!value) {
    return null;
  }

  const isValid = /^\d{8}$/.test(value) || /^\d{11}$/.test(value);
  return isValid ? null : { 'invalidDigits': { value: control.value } };
}

export function noWhitespaceValidator(control: AbstractControl): ValidationErrors | null {
  const value = control.value as string;
  if (value && /^\s*$/.test(value)) {
    return { 'whitespace': true };
  }
  return null;
}