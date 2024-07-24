import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { PageParams, CustomPage } from "../interfaces/components.interface";
import { BrandRequest, BrandResponse } from "../interfaces/model.interfaces";
import { GenericService } from "./generic-service.class";

@Injectable({
    providedIn: 'root'
  })
  export class BrandService extends GenericService<BrandRequest, BrandResponse>{
    url: string = `${this.baseUrl}/brands`;
  
    constructor(private httpClient: HttpClient) {
      super();
    }
  
    getAll() : Observable<BrandResponse []>{
      return this.httpClient.get<BrandResponse []>(`${this.url}/all`);
    }
  
    getById(id: number) : Observable<BrandResponse>{
      return this.httpClient.get<BrandResponse>(`${this.url}/${id}`);
    }
  
    deleteById(id: number) : Observable<any>{
      return this.httpClient.delete<any>(`${this.url}/${id}`);
    }
  
    update(id: number, request: BrandRequest) : Observable<BrandResponse>{
      return this.httpClient.put<any>(`${this.url}/${id}`, request);
    }
  
    create(request: BrandRequest) : Observable<BrandResponse>{
      return this.httpClient.post<any>(this.url, request);
    }
  
    getByPage(params: PageParams): Observable<CustomPage<BrandResponse>> {
      const httpParams = this.createHttpParams(params);
      return this.httpClient.get<any>(this.url, { params: httpParams });
    }
  }