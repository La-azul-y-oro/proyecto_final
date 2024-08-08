import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { map, take } from 'rxjs';
import { AuthService } from './auth.service';
import { hasValidRoles } from '../util/rolesUtil';

export const authGuard: CanActivateFn = (route, state) => {
  const authService = inject(AuthService);
  const router = inject(Router);

  return authService.currentEmployeeLoginOn.pipe(
    take(1),
    map((loggedIn: boolean) => {
      if (loggedIn) {
        return true;
      } else {
        router.navigate(['/login']);
        return false;
      }
    })
  );
};

export const clientGuard: CanActivateFn = (route, state) => {
  const authService = inject(AuthService);
  const router = inject(Router);

  return authService.currentEmployeeLoginOn.pipe(
    take(1),
    map((loggedIn: boolean) => {
      if(!loggedIn) router.navigate(['/login']);
      return hasValidRoles(authService.employeeData, ["ROLE_ADMIN", "ROLE_ADMINISTRATIVE"]);
    })
  );
};

export const servicesGuard: CanActivateFn = (route, state) => {
  const authService = inject(AuthService);
  const router = inject(Router);

  return authService.currentEmployeeLoginOn.pipe(
    take(1),
    map((loggedIn: boolean) => {
      if(!loggedIn) router.navigate(['/login']);
      return hasValidRoles(authService.employeeData, ["ROLE_ADMIN", "ROLE_ADMINISTRATIVE", "ROLE_MECHANIC"]);
    })
  );
};

export const vehiclesGuard: CanActivateFn = (route, state) => {
  const authService = inject(AuthService);
  const router = inject(Router);

  return authService.currentEmployeeLoginOn.pipe(
    take(1),
    map((loggedIn: boolean) => {
      if(!loggedIn) router.navigate(['/login']);
      return hasValidRoles(authService.employeeData, ["ROLE_ADMIN", "ROLE_ADMINISTRATIVE"]);
    })
  );
};

export const employeeGuard: CanActivateFn = (route, state) => {
  const authService = inject(AuthService);
  const router = inject(Router);

  return authService.currentEmployeeLoginOn.pipe(
    take(1),
    map((loggedIn: boolean) => {
      if(!loggedIn) router.navigate(['/login']);
      return hasValidRoles(authService.employeeData, ["ROLE_ADMIN"]);
    })
  );
};

export const authGuardNotLogin: CanActivateFn = (route, state) => {
  const authService = inject(AuthService);
  const router = inject(Router);

  return authService.currentEmployeeLoginOn.pipe(
    take(1),
    map((loggedIn: boolean) => {
      if (loggedIn) {
        router.navigate(['/inicio']);
        return false;
      } else {
        return true;
      }
    })
  );
};