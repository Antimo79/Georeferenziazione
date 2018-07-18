import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { JhiAlertService } from 'ng-jhipster';

import { ICutcUtzUbicMySuffix } from 'app/shared/model/cutc-utz-ubic-my-suffix.model';
import { CutcUtzUbicMySuffixService } from './cutc-utz-ubic-my-suffix.service';
import { IBbbaGeo01MySuffix } from 'app/shared/model/bbba-geo-01-my-suffix.model';
import { BbbaGeo01MySuffixService } from 'app/entities/bbba-geo-01-my-suffix';

@Component({
    selector: 'jhi-cutc-utz-ubic-my-suffix-update',
    templateUrl: './cutc-utz-ubic-my-suffix-update.component.html'
})
export class CutcUtzUbicMySuffixUpdateComponent implements OnInit {
    private _cutcUtzUbic: ICutcUtzUbicMySuffix;
    isSaving: boolean;

    bbbageo01s: IBbbaGeo01MySuffix[];
    dtUltAllin: string;

    constructor(
        private jhiAlertService: JhiAlertService,
        private cutcUtzUbicService: CutcUtzUbicMySuffixService,
        private bbbaGeo01Service: BbbaGeo01MySuffixService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ cutcUtzUbic }) => {
            this.cutcUtzUbic = cutcUtzUbic;
        });
        this.bbbaGeo01Service.query().subscribe(
            (res: HttpResponse<IBbbaGeo01MySuffix[]>) => {
                this.bbbageo01s = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        this.cutcUtzUbic.dtUltAllin = moment(this.dtUltAllin, DATE_TIME_FORMAT);
        if (this.cutcUtzUbic.id !== undefined) {
            this.subscribeToSaveResponse(this.cutcUtzUbicService.update(this.cutcUtzUbic));
        } else {
            this.subscribeToSaveResponse(this.cutcUtzUbicService.create(this.cutcUtzUbic));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<ICutcUtzUbicMySuffix>>) {
        result.subscribe((res: HttpResponse<ICutcUtzUbicMySuffix>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    trackBbbaGeo01ById(index: number, item: IBbbaGeo01MySuffix) {
        return item.id;
    }
    get cutcUtzUbic() {
        return this._cutcUtzUbic;
    }

    set cutcUtzUbic(cutcUtzUbic: ICutcUtzUbicMySuffix) {
        this._cutcUtzUbic = cutcUtzUbic;
        this.dtUltAllin = moment(cutcUtzUbic.dtUltAllin).format(DATE_TIME_FORMAT);
    }
}
