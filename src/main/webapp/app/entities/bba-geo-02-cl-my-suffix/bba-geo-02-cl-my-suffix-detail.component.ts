import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IBbaGeo02ClMySuffix } from 'app/shared/model/bba-geo-02-cl-my-suffix.model';

@Component({
    selector: 'jhi-bba-geo-02-cl-my-suffix-detail',
    templateUrl: './bba-geo-02-cl-my-suffix-detail.component.html'
})
export class BbaGeo02ClMySuffixDetailComponent implements OnInit {
    bbaGeo02Cl: IBbaGeo02ClMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ bbaGeo02Cl }) => {
            this.bbaGeo02Cl = bbaGeo02Cl;
        });
    }

    previousState() {
        window.history.back();
    }
}
