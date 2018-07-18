import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IBbaGeo02ClMySuffix } from 'app/shared/model/bba-geo-02-cl-my-suffix.model';
import { BbaGeo02ClMySuffixService } from './bba-geo-02-cl-my-suffix.service';

@Component({
    selector: 'jhi-bba-geo-02-cl-my-suffix-delete-dialog',
    templateUrl: './bba-geo-02-cl-my-suffix-delete-dialog.component.html'
})
export class BbaGeo02ClMySuffixDeleteDialogComponent {
    bbaGeo02Cl: IBbaGeo02ClMySuffix;

    constructor(
        private bbaGeo02ClService: BbaGeo02ClMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.bbaGeo02ClService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'bbaGeo02ClListModification',
                content: 'Deleted an bbaGeo02Cl'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-bba-geo-02-cl-my-suffix-delete-popup',
    template: ''
})
export class BbaGeo02ClMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ bbaGeo02Cl }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(BbaGeo02ClMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.bbaGeo02Cl = bbaGeo02Cl;
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
