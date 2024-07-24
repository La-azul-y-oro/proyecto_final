import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ClientRequest, ClientResponse } from '../interfaces/model.interfaces';
import { CustomPage, PageParams } from '../interfaces/components.interface';
import { GenericService } from './generic-service.class';

@Injectable({
  providedIn: 'root'
})
export class ClientService extends GenericService<ClientRequest, ClientResponse>{
  url: string = `${this.baseUrl}/clients`;

  constructor(private httpClient: HttpClient) {
    super();
  }

  getAll() : Observable<ClientResponse []>{
    return this.httpClient.get<ClientResponse []>(`${this.url}/all`);
  }

  getById(id: number) : Observable<ClientResponse>{
    return this.httpClient.get<ClientResponse>(`${this.url}/${id}`);
  }

  deleteById(id: number) : Observable<any>{
    return this.httpClient.delete<any>(`${this.url}/${id}`);
  }

  update(id: number, request: ClientRequest) : Observable<ClientResponse>{
    return this.httpClient.put<any>(`${this.url}/${id}`, request);
  }

  create(request: ClientRequest) : Observable<ClientResponse>{
    return this.httpClient.post<any>(this.url, request);
  }

  getByPage(params: PageParams): Observable<CustomPage<ClientResponse>> {
    const httpParams = this.createHttpParams(params);
    return this.httpClient.get<any>(this.url, { params: httpParams });
  }
}
