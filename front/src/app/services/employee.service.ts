import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EmployeeRequest, EmployeeResponse } from '../interfaces/model.interfaces';
import { GenericService } from './generic-service.class';
import { PageParams, CustomPage } from '../interfaces/components.interface';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService extends GenericService<EmployeeRequest, EmployeeResponse>{
  url: string = `${this.baseUrl}/employees`;

  constructor(private httpClient: HttpClient) {
    super();
  }

  create(request: EmployeeRequest) : Observable<EmployeeResponse>{
    return this.httpClient.post<any>(this.url, request);
  }

  update(id: number, request: EmployeeRequest) : Observable<EmployeeResponse>{
    return this.httpClient.put<any>(`${this.url}/${id}`, request);
  }

  getAll() : Observable<EmployeeResponse []>{
    return this.httpClient.get<EmployeeResponse []>(`${this.url}/all`);
  }

  getById(id: number) : Observable<EmployeeResponse>{
    return this.httpClient.get<EmployeeResponse>(`${this.url}/${id}`);
  }

  deleteById(id: number) : Observable<void>{
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }

  getByPage(params: PageParams): Observable<CustomPage<EmployeeResponse>> {
    const httpParams = this.createHttpParams(params);
    return this.httpClient.get<any>(this.url, { params: httpParams });
  }
}
