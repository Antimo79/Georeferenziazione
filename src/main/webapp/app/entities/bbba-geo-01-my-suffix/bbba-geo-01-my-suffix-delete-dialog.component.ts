import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IBbbaGeo01MySuffix } from 'app/shared/model/bbba-geo-01-my-suffix.model';
import { BbbaGeo01MySuffixService } from './bbba-geo-01-my-suffix.service';

@Component({
    selector: 'jhi-bbba-geo-01-my-suffix-delete-dialog',
    templateUrl: './bbba-geo-01-my-suffix-delete-dialog.component.html'
})
export class BbbaGeo01MySuffixDeleteDialogComponent {
    bbbaGeo01: IBbbaGeo01MySuffix;

    constructor(
        private bbbaGeo01Service: BbbaGeo01MySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.bbbaGeo01Service.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'bbbaGeo01ListModification',
                content: 'Deleted an bbbaGeo01'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-bbba-geo-01-my-suffix-delete-popup',
    template: ''
})
export class BbbaGeo01MySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ bbbaGeo01 }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(BbbaGeo01MySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.bbbaGeo01 = bbbaGeo01;
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
