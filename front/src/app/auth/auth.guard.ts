import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { map, take } from 'rxjs';
import { AuthService } from './auth.service';

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