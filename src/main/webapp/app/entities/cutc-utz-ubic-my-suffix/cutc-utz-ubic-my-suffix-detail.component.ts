import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICutcUtzUbicMySuffix } from 'app/shared/model/cutc-utz-ubic-my-suffix.model';

@Component({
    selector: 'jhi-cutc-utz-ubic-my-suffix-detail',
    templateUrl: './cutc-utz-ubic-my-suffix-detail.component.html'
})
export class CutcUtzUbicMySuffixDetailComponent implements OnInit {
    cutcUtzUbic: ICutcUtzUbicMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ cutcUtzUbic }) => {
            this.cutcUtzUbic = cutcUtzUbic;
        });
    }

    previousState() {
        window.history.back();
    }
}
