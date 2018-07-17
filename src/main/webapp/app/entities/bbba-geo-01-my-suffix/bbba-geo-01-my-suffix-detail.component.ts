import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IBbbaGeo01MySuffix } from 'app/shared/model/bbba-geo-01-my-suffix.model';

@Component({
    selector: 'jhi-bbba-geo-01-my-suffix-detail',
    templateUrl: './bbba-geo-01-my-suffix-detail.component.html'
})
export class BbbaGeo01MySuffixDetailComponent implements OnInit {
    bbbaGeo01: IBbbaGeo01MySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ bbbaGeo01 }) => {
            this.bbbaGeo01 = bbbaGeo01;
        });
    }

    previousState() {
        window.history.back();
    }
}
