import { Injectable } from '@angular/core';
import { GenericService } from './generic-service.class';
import { Observable } from 'rxjs';
import { PageParams, CustomPage } from '../interfaces/components.interface';
import { HttpClient } from '@angular/common/http';
import { ServiceRequest, ServiceResponse } from '../interfaces/model.interfaces';


@Injectable({
  providedIn: 'root'
})
export class ServicesService extends GenericService <ServiceRequest, ServiceResponse>{
  url: string = `${this.baseUrl}/services`;
  
  constructor(private httpClient: HttpClient) {
    super();
  }

  getAll() : Observable<ServiceResponse[]> {
    return this.httpClient.get<ServiceResponse []>( `${this.url}/all`);
  }
  getById(id: number): Observable<ServiceResponse> {
    return this.httpClient.get<ServiceResponse>( `${this.url}/${id}`);
  }
  deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }
  update(id: number, request: ServiceRequest): Observable<ServiceResponse> {
    return this.httpClient.put<ServiceResponse>(`${this.url}/${id}`, request);
  }
  create(request: ServiceRequest): Observable<ServiceResponse> {
    return this.httpClient.post<any>(this.url, request)
  }
  getByPage(params: PageParams): Observable<CustomPage<ServiceResponse>> {
    const httpParams = this.createHttpParams(params);
    return this.httpClient.get<any>(this.url, { params: httpParams});
  }

}
