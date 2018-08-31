import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { ICutcUtzUbicMySuffix } from 'app/shared/model/cutc-utz-ubic-my-suffix.model';
import { CutcUtzUbicMySuffixService } from './cutc-utz-ubic-my-suffix.service';

@Component({
    selector: 'jhi-cutc-utz-ubic-my-suffix-update',
    templateUrl: './cutc-utz-ubic-my-suffix-update.component.html'
})
export class CutcUtzUbicMySuffixUpdateComponent implements OnInit {
    private _cutcUtzUbic: ICutcUtzUbicMySuffix;
    isSaving: boolean;
    dtUltAllin: string;

    constructor(private cutcUtzUbicService: CutcUtzUbicMySuffixService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ cutcUtzUbic }) => {
            this.cutcUtzUbic = cutcUtzUbic;
        });
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
    get cutcUtzUbic() {
        return this._cutcUtzUbic;
    }

    set cutcUtzUbic(cutcUtzUbic: ICutcUtzUbicMySuffix) {
        this._cutcUtzUbic = cutcUtzUbic;
        this.dtUltAllin = moment(cutcUtzUbic.dtUltAllin).format(DATE_TIME_FORMAT);
    }
}
