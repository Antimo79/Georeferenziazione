import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IBbaGeo01MySuffix } from 'app/shared/model/bba-geo-01-my-suffix.model';
import { Principal } from 'app/core';
import { BbaGeo01MySuffixService } from './bba-geo-01-my-suffix.service';

@Component({
    selector: 'jhi-bba-geo-01-my-suffix',
    templateUrl: './bba-geo-01-my-suffix.component.html'
})
export class BbaGeo01MySuffixComponent implements OnInit, OnDestroy {
    bbaGeo01S: IBbaGeo01MySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private bbaGeo01Service: BbaGeo01MySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.bbaGeo01Service.query().subscribe(
            (res: HttpResponse<IBbaGeo01MySuffix[]>) => {
                this.bbaGeo01S = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInBbaGeo01S();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IBbaGeo01MySuffix) {
        return item.id;
    }

    registerChangeInBbaGeo01S() {
        this.eventSubscriber = this.eventManager.subscribe('bbaGeo01ListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
