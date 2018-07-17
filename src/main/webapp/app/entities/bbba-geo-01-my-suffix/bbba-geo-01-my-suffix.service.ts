import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IBbbaGeo01MySuffix } from 'app/shared/model/bbba-geo-01-my-suffix.model';

type EntityResponseType = HttpResponse<IBbbaGeo01MySuffix>;
type EntityArrayResponseType = HttpResponse<IBbbaGeo01MySuffix[]>;

@Injectable({ providedIn: 'root' })
export class BbbaGeo01MySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/bbba-geo-01-s';

    constructor(private http: HttpClient) {}

    create(bbbaGeo01: IBbbaGeo01MySuffix): Observable<EntityResponseType> {
        return this.http.post<IBbbaGeo01MySuffix>(this.resourceUrl, bbbaGeo01, { observe: 'response' });
    }

    update(bbbaGeo01: IBbbaGeo01MySuffix): Observable<EntityResponseType> {
        return this.http.put<IBbbaGeo01MySuffix>(this.resourceUrl, bbbaGeo01, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IBbbaGeo01MySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IBbbaGeo01MySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
