import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

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
        const copy = this.convertDateFromClient(cutcUtzUbic);
        return this.http
            .post<ICutcUtzUbicMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(cutcUtzUbic: ICutcUtzUbicMySuffix): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(cutcUtzUbic);
        return this.http
            .put<ICutcUtzUbicMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<ICutcUtzUbicMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<ICutcUtzUbicMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' })
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    private convertDateFromClient(cutcUtzUbic: ICutcUtzUbicMySuffix): ICutcUtzUbicMySuffix {
        const copy: ICutcUtzUbicMySuffix = Object.assign({}, cutcUtzUbic, {
            dtUltAllin: cutcUtzUbic.dtUltAllin != null && cutcUtzUbic.dtUltAllin.isValid() ? cutcUtzUbic.dtUltAllin.toJSON() : null
        });
        return copy;
    }

    private convertDateFromServer(res: EntityResponseType): EntityResponseType {
        res.body.dtUltAllin = res.body.dtUltAllin != null ? moment(res.body.dtUltAllin) : null;
        return res;
    }

    private convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        res.body.forEach((cutcUtzUbic: ICutcUtzUbicMySuffix) => {
            cutcUtzUbic.dtUltAllin = cutcUtzUbic.dtUltAllin != null ? moment(cutcUtzUbic.dtUltAllin) : null;
        });
        return res;
    }
}
