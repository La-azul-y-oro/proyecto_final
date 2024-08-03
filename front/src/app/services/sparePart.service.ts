import { Observable } from "rxjs";
import { PageParams, CustomPage } from "../interfaces/components.interface";
import { SparePartRequest, SparePartResponse } from "../interfaces/model.interfaces";
import { GenericService } from "./generic-service.class";
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class SparePartService extends GenericService<SparePartRequest, SparePartResponse>{
    
    url: string = `${this.baseUrl}/spare_parts`;

    constructor(private httpClient: HttpClient){
        super();
    }
    
    override getAll(): Observable<SparePartResponse[]> {
        return this.httpClient.get<SparePartResponse[]>(`${this.url}/all`);
    }
    override getById(id: number): Observable<SparePartResponse> {
        return this.httpClient.get<SparePartResponse>(`${this.url}/${id}`);
    }
    override deleteById(id: number): Observable<any> {
        return this.httpClient.delete<any>(`${this.url}/${id}`);
    }
    override update(id: number, request: SparePartRequest): Observable<SparePartResponse> {
        return this.httpClient.put<SparePartResponse>(`${this.url}/${id}`, request);
    }
    override create(request: SparePartRequest): Observable<SparePartResponse> {
        return this.httpClient.post<SparePartResponse>(this.url, request);
    }
    override getByPage(params: PageParams): Observable<CustomPage<SparePartResponse>> {
        const httpParams = this.createHttpParams(params);
        return this.httpClient.get<any>(this.url, { params: httpParams });
    }
    
}