import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { VehicleRequest, VehicleResponse } from '../interfaces/model.interfaces';
import { CustomPage, PageParams } from '../interfaces/components.interface';
import { GenericService } from './generic-service.class';

@Injectable({
  providedIn: 'root'
})
export class VehicleService extends GenericService<VehicleRequest, VehicleResponse>{
  url: string = `${this.baseUrl}/vehicles`;

  constructor(private httpClient: HttpClient) {
    super();
  }

  getAll() : Observable<VehicleResponse []>{
    return this.httpClient.get<VehicleResponse []>(`${this.url}/all`);
  }

  getById(id: number) : Observable<VehicleResponse>{
    return this.httpClient.get<VehicleResponse>(`${this.url}/${id}`);
  }

  deleteById(id: number) : Observable<any>{
    return this.httpClient.delete<any>(`${this.url}/${id}`);
  }

  update(id: number, request: VehicleRequest) : Observable<VehicleResponse>{
    return this.httpClient.put<any>(`${this.url}/${id}`, request);
  }

  create(request: VehicleRequest) : Observable<VehicleResponse>{
    return this.httpClient.post<any>(this.url, request);
  }

  getByPage(params: PageParams): Observable<CustomPage<VehicleResponse>> {
    const httpParams = this.createHttpParams(params);
    return this.httpClient.get<any>(this.url, { params: httpParams });
  }
}
