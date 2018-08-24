import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IBbaGeo01MySuffix } from 'app/shared/model/bba-geo-01-my-suffix.model';
import { BbaGeo01MySuffixService } from './bba-geo-01-my-suffix.service';
import { IBbaGeo02ClMySuffix } from 'app/shared/model/bba-geo-02-cl-my-suffix.model';
import { BbaGeo02ClMySuffixService } from 'app/entities/bba-geo-02-cl-my-suffix';

@Component({
    selector: 'jhi-bba-geo-01-my-suffix-update',
    templateUrl: './bba-geo-01-my-suffix-update.component.html'
})
export class BbaGeo01MySuffixUpdateComponent implements OnInit {
    private _bbaGeo01: IBbaGeo01MySuffix;
    isSaving: boolean;

    bbageo02cls: IBbaGeo02ClMySuffix[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private bbaGeo01Service: BbaGeo01MySuffixService,
        private bbaGeo02ClService: BbaGeo02ClMySuffixService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ bbaGeo01 }) => {
            this.bbaGeo01 = bbaGeo01;
        });
        this.bbaGeo02ClService.query().subscribe(
            (res: HttpResponse<IBbaGeo02ClMySuffix[]>) => {
                this.bbageo02cls = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.bbaGeo01.id !== undefined) {
            this.subscribeToSaveResponse(this.bbaGeo01Service.update(this.bbaGeo01));
        } else {
            this.subscribeToSaveResponse(this.bbaGeo01Service.create(this.bbaGeo01));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IBbaGeo01MySuffix>>) {
        result.subscribe((res: HttpResponse<IBbaGeo01MySuffix>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    trackBbaGeo02ClById(index: number, item: IBbaGeo02ClMySuffix) {
        return item.id;
    }
    get bbaGeo01() {
        return this._bbaGeo01;
    }

    set bbaGeo01(bbaGeo01: IBbaGeo01MySuffix) {
        this._bbaGeo01 = bbaGeo01;
    }
}
