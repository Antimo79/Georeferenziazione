import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IBbaGeo01MySuffix } from 'app/shared/model/bba-geo-01-my-suffix.model';

type EntityResponseType = HttpResponse<IBbaGeo01MySuffix>;
type EntityArrayResponseType = HttpResponse<IBbaGeo01MySuffix[]>;

@Injectable({ providedIn: 'root' })
export class BbaGeo01MySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/bba-geo-01-s';

    constructor(private http: HttpClient) {}

    create(bbaGeo01: IBbaGeo01MySuffix): Observable<EntityResponseType> {
        return this.http.post<IBbaGeo01MySuffix>(this.resourceUrl, bbaGeo01, { observe: 'response' });
    }

    update(bbaGeo01: IBbaGeo01MySuffix): Observable<EntityResponseType> {
        return this.http.put<IBbaGeo01MySuffix>(this.resourceUrl, bbaGeo01, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IBbaGeo01MySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IBbaGeo01MySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
