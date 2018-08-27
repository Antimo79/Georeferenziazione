import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { ICutcUtzUbicMySuffix } from 'app/shared/model/cutc-utz-ubic-my-suffix.model';
import { Principal } from 'app/core';
import { CutcUtzUbicMySuffixService } from './cutc-utz-ubic-my-suffix.service';

@Component({
    selector: 'jhi-cutc-utz-ubic-my-suffix',
    templateUrl: './cutc-utz-ubic-my-suffix.component.html'
})
export class CutcUtzUbicMySuffixComponent implements OnInit, OnDestroy {
    cutcUtzUbics: ICutcUtzUbicMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private cutcUtzUbicService: CutcUtzUbicMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.cutcUtzUbicService.query().subscribe(
            (res: HttpResponse<ICutcUtzUbicMySuffix[]>) => {
                this.cutcUtzUbics = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInCutcUtzUbics();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: ICutcUtzUbicMySuffix) {
        return item.id;
    }

    registerChangeInCutcUtzUbics() {
        this.eventSubscriber = this.eventManager.subscribe('cutcUtzUbicListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
