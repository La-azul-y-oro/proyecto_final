import { Injectable } from "@angular/core";
import { ServiceTypeRequest, ServiceTypeResponse } from "../interfaces/model.interfaces";
import { GenericService } from "./generic-service.class";
import { Observable } from "rxjs";
import { PageParams, CustomPage } from "../interfaces/components.interface";
import { HttpClient } from "@angular/common/http";

@Injectable({
    providedIn: 'root'
})
export class ServiceTypeService extends GenericService<ServiceTypeRequest, ServiceTypeResponse>{

    url: string = `${this.baseUrl}/service_types`;

    constructor(private httpClient: HttpClient){
        super();
    }

    getAll(): Observable<ServiceTypeResponse[]> {
        return this.httpClient.get<ServiceTypeResponse[]>(`${this.url}/all`);
    }
    getById(id: number): Observable<ServiceTypeResponse> {
        return this.httpClient.get<ServiceTypeResponse>(`${this.url}/${id}`);
    }
    deleteById(id: number): Observable<any> {
        return this.httpClient.delete<any>(`${this.url}/${id}`);
    }
    update(id: number, request: ServiceTypeRequest): Observable<ServiceTypeResponse> {
        return this.httpClient.put<ServiceTypeResponse>(`${this.url}/${id}`, request);
    }
    create(request: ServiceTypeRequest): Observable<ServiceTypeResponse> {
        return this.httpClient.post<ServiceTypeResponse>(this.url, request);
    }
    getByPage(params: PageParams): Observable<CustomPage<ServiceTypeResponse>> {
        const httpParams = this.createHttpParams(params);
        return this.httpClient.get<any>(this.url, { params: httpParams });
    }
    
}