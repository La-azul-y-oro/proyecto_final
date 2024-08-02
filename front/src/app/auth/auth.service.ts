import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, catchError, map, tap, throwError } from 'rxjs';
import { Router } from '@angular/router';
import { environment } from '../../enviroments/enviroments';
import { EmployeeLogin } from '../interfaces/model.interfaces';
import { jwtDecode } from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  url: string = `${environment.apiUrl}/auth`;

  currentEmployeeLoginOn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  currentEmployeeData: BehaviorSubject<string | null> = new BehaviorSubject<string | null>(null);

  constructor(private httpClient: HttpClient, private router : Router) { 
    this.currentEmployeeLoginOn = new BehaviorSubject<boolean>(sessionStorage.getItem("token") != null);
    const token = sessionStorage.getItem("token");
    if (token) {
      this.currentEmployeeData.next(token);
    }
  }

  login(credentials: EmployeeLogin): Observable<any> {
    return this.httpClient.post<any>(this.url + "/login", credentials).pipe(
      tap((employeeData) => {
        sessionStorage.setItem("token", employeeData.token);
        this.currentEmployeeData.next(employeeData.token);
        this.currentEmployeeLoginOn.next(true);
      }),
      map((employeeData) => employeeData.token),
      catchError(this.handleError)
    );
  }

  logout() {
    sessionStorage.removeItem("token");
    this.currentEmployeeLoginOn.next(false);
    this.currentEmployeeData.next("");
    this.router.navigate(['/login']);
  }

  private handleError(error:HttpErrorResponse) {
    if(error.status===0) {
      console.error('Se ha producido un error ', error.error);
    }
    else {
      console.error('Backend retornó el código de estado ', error);
    }
    return throwError(()=> new Error('Algo falló. Por favor intente nuevamente.'));
  }

  private decodeToken(token: string) {
    try {
      return jwtDecode<string>(token);
    } catch (Error) {
      console.error('Error decodificando token', Error);
      return null;
    }
  }

  get employeeToken() {
    return this.currentEmployeeData.value;
  }

}