import { HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CustomPage, PageParams } from '../interfaces/components.interface';
import { environment } from '../../enviroments/enviroments';

/**
 * @param <T> Request
 * @param <R> Response
 */
export abstract class GenericService<T, R> {

  protected baseUrl: string = environment.apiUrl;

  protected createHttpParams(params: PageParams): HttpParams {
    let httpParams = new HttpParams()
      .set('page', params.page.toString())
      .set('size', params.size.toString());

    if (params.sort) {
      httpParams = httpParams.set('sort', params.sort);
    }

    return httpParams;
  }

  abstract getAll(): Observable<R[]>;
  abstract getById(id: number): Observable<R>;
  abstract deleteById(id: number): Observable<void>;
  abstract update(id: number, request: T): Observable<R>;
  abstract create(request: T): Observable<R>;
  abstract getByPage(params: PageParams): Observable<CustomPage<R>>;
}
