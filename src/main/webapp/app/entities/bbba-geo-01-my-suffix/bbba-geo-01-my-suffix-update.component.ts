import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IBbbaGeo01MySuffix } from 'app/shared/model/bbba-geo-01-my-suffix.model';
import { BbbaGeo01MySuffixService } from './bbba-geo-01-my-suffix.service';
import { IBbaGeo02ClMySuffix } from 'app/shared/model/bba-geo-02-cl-my-suffix.model';
import { BbaGeo02ClMySuffixService } from 'app/entities/bba-geo-02-cl-my-suffix';

@Component({
    selector: 'jhi-bbba-geo-01-my-suffix-update',
    templateUrl: './bbba-geo-01-my-suffix-update.component.html'
})
export class BbbaGeo01MySuffixUpdateComponent implements OnInit {
    private _bbbaGeo01: IBbbaGeo01MySuffix;
    isSaving: boolean;

    bbageo02cls: IBbaGeo02ClMySuffix[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private bbbaGeo01Service: BbbaGeo01MySuffixService,
        private bbaGeo02ClService: BbaGeo02ClMySuffixService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ bbbaGeo01 }) => {
            this.bbbaGeo01 = bbbaGeo01;
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
        if (this.bbbaGeo01.id !== undefined) {
            this.subscribeToSaveResponse(this.bbbaGeo01Service.update(this.bbbaGeo01));
        } else {
            this.subscribeToSaveResponse(this.bbbaGeo01Service.create(this.bbbaGeo01));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IBbbaGeo01MySuffix>>) {
        result.subscribe((res: HttpResponse<IBbbaGeo01MySuffix>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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
    get bbbaGeo01() {
        return this._bbbaGeo01;
    }

    set bbbaGeo01(bbbaGeo01: IBbbaGeo01MySuffix) {
        this._bbbaGeo01 = bbbaGeo01;
    }
}
