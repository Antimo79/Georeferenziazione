import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IBbbaGeo01MySuffix } from 'app/shared/model/bbba-geo-01-my-suffix.model';
import { Principal } from 'app/core';
import { BbbaGeo01MySuffixService } from './bbba-geo-01-my-suffix.service';

@Component({
    selector: 'jhi-bbba-geo-01-my-suffix',
    templateUrl: './bbba-geo-01-my-suffix.component.html'
})
export class BbbaGeo01MySuffixComponent implements OnInit, OnDestroy {
    bbbaGeo01S: IBbbaGeo01MySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private bbbaGeo01Service: BbbaGeo01MySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.bbbaGeo01Service.query().subscribe(
            (res: HttpResponse<IBbbaGeo01MySuffix[]>) => {
                this.bbbaGeo01S = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInBbbaGeo01S();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IBbbaGeo01MySuffix) {
        return item.id;
    }

    registerChangeInBbbaGeo01S() {
        this.eventSubscriber = this.eventManager.subscribe('bbbaGeo01ListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
