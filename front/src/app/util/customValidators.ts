import { AbstractControl, ValidationErrors } from '@angular/forms';

export function emailCustomValidator(control: AbstractControl): ValidationErrors | null {
  const emailRegex = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Z|a-z]{2,}$/;
  const valid = emailRegex.test(control.value);
  return valid ? null : { invalidEmail: true };
}

export function nroDniValidator(control: AbstractControl): ValidationErrors | null {
  const value = control.value;
  if (!value) {
    return null;
  }

  const isValid = /^\d{8}$/.test(value);
  return isValid ? null : { 'invalidDigits': { value: control.value } };
}

export function nroDniCuitValidator(control: AbstractControl): ValidationErrors | null {
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

export function vehiclePlateValidator(control: AbstractControl): ValidationErrors | null {
  const value = control.value as string;
  const regex = /^[A-Z]{3}\d{3}$|^[A-Z]{2}\d{3}[A-Z]{2}$/;
  if (value && !regex.test(value)) {
    return { 'invalidVehiclePlate': true };
  }
  return null;
}

export function dateValidator(control: AbstractControl): ValidationErrors | null {
  const regex = /^\d{4}-\d{2}-\d{2}$/;
  const date = control.value as string;

  if (!date) {
    return null;
  }

  if (!regex.test(date)) {
    return { 'invalidDate': true };
  }

  const parts = date.split('-');
  const year = parseInt(parts[0], 10);
  const month = parseInt(parts[1], 10) - 1;
  const day = parseInt(parts[2], 10);

  const dateObject = new Date(year, month, day);

  const isValidDate =
    dateObject.getFullYear() === year &&
    dateObject.getMonth() === month &&
    dateObject.getDate() === day;

  return isValidDate ? null : { 'invalidDate': true };
}