import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IBbaGeo02ClMySuffix } from 'app/shared/model/bba-geo-02-cl-my-suffix.model';
import { Principal } from 'app/core';
import { BbaGeo02ClMySuffixService } from './bba-geo-02-cl-my-suffix.service';

@Component({
    selector: 'jhi-bba-geo-02-cl-my-suffix',
    templateUrl: './bba-geo-02-cl-my-suffix.component.html'
})
export class BbaGeo02ClMySuffixComponent implements OnInit, OnDestroy {
    bbaGeo02Cls: IBbaGeo02ClMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private bbaGeo02ClService: BbaGeo02ClMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.bbaGeo02ClService.query().subscribe(
            (res: HttpResponse<IBbaGeo02ClMySuffix[]>) => {
                this.bbaGeo02Cls = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInBbaGeo02Cls();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IBbaGeo02ClMySuffix) {
        return item.id;
    }

    registerChangeInBbaGeo02Cls() {
        this.eventSubscriber = this.eventManager.subscribe('bbaGeo02ClListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
