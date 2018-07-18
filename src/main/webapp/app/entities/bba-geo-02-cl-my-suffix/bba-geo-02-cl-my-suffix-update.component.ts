import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IBbaGeo02ClMySuffix } from 'app/shared/model/bba-geo-02-cl-my-suffix.model';
import { BbaGeo02ClMySuffixService } from './bba-geo-02-cl-my-suffix.service';

@Component({
    selector: 'jhi-bba-geo-02-cl-my-suffix-update',
    templateUrl: './bba-geo-02-cl-my-suffix-update.component.html'
})
export class BbaGeo02ClMySuffixUpdateComponent implements OnInit {
    private _bbaGeo02Cl: IBbaGeo02ClMySuffix;
    isSaving: boolean;

    constructor(private bbaGeo02ClService: BbaGeo02ClMySuffixService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ bbaGeo02Cl }) => {
            this.bbaGeo02Cl = bbaGeo02Cl;
        });
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
    get bbaGeo02Cl() {
        return this._bbaGeo02Cl;
    }

    set bbaGeo02Cl(bbaGeo02Cl: IBbaGeo02ClMySuffix) {
        this._bbaGeo02Cl = bbaGeo02Cl;
    }
}
