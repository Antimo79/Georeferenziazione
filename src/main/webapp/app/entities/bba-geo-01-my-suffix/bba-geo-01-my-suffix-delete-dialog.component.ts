import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IBbaGeo01MySuffix } from 'app/shared/model/bba-geo-01-my-suffix.model';
import { BbaGeo01MySuffixService } from './bba-geo-01-my-suffix.service';

@Component({
    selector: 'jhi-bba-geo-01-my-suffix-delete-dialog',
    templateUrl: './bba-geo-01-my-suffix-delete-dialog.component.html'
})
export class BbaGeo01MySuffixDeleteDialogComponent {
    bbaGeo01: IBbaGeo01MySuffix;

    constructor(
        private bbaGeo01Service: BbaGeo01MySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.bbaGeo01Service.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'bbaGeo01ListModification',
                content: 'Deleted an bbaGeo01'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-bba-geo-01-my-suffix-delete-popup',
    template: ''
})
export class BbaGeo01MySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ bbaGeo01 }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(BbaGeo01MySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.bbaGeo01 = bbaGeo01;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    }
                );
            }, 0);
        });
    }

    ngOnDestroy() {
        this.ngbModalRef = null;
    }
}
