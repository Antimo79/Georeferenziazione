import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IBbaGeo02ClMySuffix } from 'app/shared/model/bba-geo-02-cl-my-suffix.model';

type EntityResponseType = HttpResponse<IBbaGeo02ClMySuffix>;
type EntityArrayResponseType = HttpResponse<IBbaGeo02ClMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class BbaGeo02ClMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/bba-geo-02-cls';

    constructor(private http: HttpClient) {}

    create(bbaGeo02Cl: IBbaGeo02ClMySuffix): Observable<EntityResponseType> {
        return this.http.post<IBbaGeo02ClMySuffix>(this.resourceUrl, bbaGeo02Cl, { observe: 'response' });
    }

    update(bbaGeo02Cl: IBbaGeo02ClMySuffix): Observable<EntityResponseType> {
        return this.http.put<IBbaGeo02ClMySuffix>(this.resourceUrl, bbaGeo02Cl, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IBbaGeo02ClMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IBbaGeo02ClMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
