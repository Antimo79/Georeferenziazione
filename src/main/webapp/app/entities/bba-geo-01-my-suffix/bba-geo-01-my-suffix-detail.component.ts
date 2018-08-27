import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IBbaGeo01MySuffix } from 'app/shared/model/bba-geo-01-my-suffix.model';

@Component({
    selector: 'jhi-bba-geo-01-my-suffix-detail',
    templateUrl: './bba-geo-01-my-suffix-detail.component.html'
})
export class BbaGeo01MySuffixDetailComponent implements OnInit {
    bbaGeo01: IBbaGeo01MySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ bbaGeo01 }) => {
            this.bbaGeo01 = bbaGeo01;
        });
    }

    previousState() {
        window.history.back();
    }
}
