import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ICutcUtzUbicMySuffix } from 'app/shared/model/cutc-utz-ubic-my-suffix.model';

type EntityResponseType = HttpResponse<ICutcUtzUbicMySuffix>;
type EntityArrayResponseType = HttpResponse<ICutcUtzUbicMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class CutcUtzUbicMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/cutc-utz-ubics';

    constructor(private http: HttpClient) {}

    create(cutcUtzUbic: ICutcUtzUbicMySuffix): Observable<EntityResponseType> {
        return this.http.post<ICutcUtzUbicMySuffix>(this.resourceUrl, cutcUtzUbic, { observe: 'response' });
    }

    update(cutcUtzUbic: ICutcUtzUbicMySuffix): Observable<EntityResponseType> {
        return this.http.put<ICutcUtzUbicMySuffix>(this.resourceUrl, cutcUtzUbic, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<ICutcUtzUbicMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<ICutcUtzUbicMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
