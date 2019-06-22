import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICutcUtzUbicMySuffix } from 'app/shared/model/cutc-utz-ubic-my-suffix.model';
import { CutcUtzUbicMySuffixService } from './cutc-utz-ubic-my-suffix.service';

@Component({
    selector: 'jhi-cutc-utz-ubic-my-suffix-delete-dialog',
    templateUrl: './cutc-utz-ubic-my-suffix-delete-dialog.component.html'
})
export class CutcUtzUbicMySuffixDeleteDialogComponent {
    cutcUtzUbic: ICutcUtzUbicMySuffix;

    constructor(
        private cutcUtzUbicService: CutcUtzUbicMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.cutcUtzUbicService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'cutcUtzUbicListModification',
                content: 'Deleted an cutcUtzUbic'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-cutc-utz-ubic-my-suffix-delete-popup',
    template: ''
})
export class CutcUtzUbicMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ cutcUtzUbic }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(CutcUtzUbicMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.cutcUtzUbic = cutcUtzUbic;
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
