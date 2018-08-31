import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IBbaGeo02ClMySuffix } from 'app/shared/model/bba-geo-02-cl-my-suffix.model';
import { BbaGeo02ClMySuffixService } from './bba-geo-02-cl-my-suffix.service';
import { IBbaGeo01MySuffix } from 'app/shared/model/bba-geo-01-my-suffix.model';
import { BbaGeo01MySuffixService } from 'app/entities/bba-geo-01-my-suffix';

@Component({
    selector: 'jhi-bba-geo-02-cl-my-suffix-update',
    templateUrl: './bba-geo-02-cl-my-suffix-update.component.html'
})
export class BbaGeo02ClMySuffixUpdateComponent implements OnInit {
    private _bbaGeo02Cl: IBbaGeo02ClMySuffix;
    isSaving: boolean;

    bbageo01s: IBbaGeo01MySuffix[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private bbaGeo02ClService: BbaGeo02ClMySuffixService,
        private bbaGeo01Service: BbaGeo01MySuffixService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ bbaGeo02Cl }) => {
            this.bbaGeo02Cl = bbaGeo02Cl;
        });
        this.bbaGeo01Service.query().subscribe(
            (res: HttpResponse<IBbaGeo01MySuffix[]>) => {
                this.bbageo01s = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.bbaGeo02Cl.id !== undefined) {
            this.subscribeToSaveResponse(this.bbaGeo02ClService.update(this.bbaGeo02Cl));
        } else {
            this.subscribeToSaveResponse(this.bbaGeo02ClService.create(this.bbaGeo02Cl));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IBbaGeo02ClMySuffix>>) {
        result.subscribe((res: HttpResponse<IBbaGeo02ClMySuffix>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    trackBbaGeo01ById(index: number, item: IBbaGeo01MySuffix) {
        return item.id;
    }
    get bbaGeo02Cl() {
        return this._bbaGeo02Cl;
    }

    set bbaGeo02Cl(bbaGeo02Cl: IBbaGeo02ClMySuffix) {
        this._bbaGeo02Cl = bbaGeo02Cl;
    }
}
