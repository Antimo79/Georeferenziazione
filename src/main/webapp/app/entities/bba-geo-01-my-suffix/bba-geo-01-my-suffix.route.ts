import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { BbaGeo01MySuffix } from 'app/shared/model/bba-geo-01-my-suffix.model';
import { BbaGeo01MySuffixService } from './bba-geo-01-my-suffix.service';
import { BbaGeo01MySuffixComponent } from './bba-geo-01-my-suffix.component';
import { BbaGeo01MySuffixDetailComponent } from './bba-geo-01-my-suffix-detail.component';
import { BbaGeo01MySuffixUpdateComponent } from './bba-geo-01-my-suffix-update.component';
import { BbaGeo01MySuffixDeletePopupComponent } from './bba-geo-01-my-suffix-delete-dialog.component';
import { IBbaGeo01MySuffix } from 'app/shared/model/bba-geo-01-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class BbaGeo01MySuffixResolve implements Resolve<IBbaGeo01MySuffix> {
    constructor(private service: BbaGeo01MySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((bbaGeo01: HttpResponse<BbaGeo01MySuffix>) => bbaGeo01.body));
        }
        return of(new BbaGeo01MySuffix());
    }
}

export const bbaGeo01Route: Routes = [
    {
        path: 'bba-geo-01-my-suffix',
        component: BbaGeo01MySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'georeferenziazioneApp.bbaGeo01.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bba-geo-01-my-suffix/:id/view',
        component: BbaGeo01MySuffixDetailComponent,
        resolve: {
            bbaGeo01: BbaGeo01MySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'georeferenziazioneApp.bbaGeo01.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bba-geo-01-my-suffix/new',
        component: BbaGeo01MySuffixUpdateComponent,
        resolve: {
            bbaGeo01: BbaGeo01MySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'georeferenziazioneApp.bbaGeo01.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bba-geo-01-my-suffix/:id/edit',
        component: BbaGeo01MySuffixUpdateComponent,
        resolve: {
            bbaGeo01: BbaGeo01MySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'georeferenziazioneApp.bbaGeo01.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const bbaGeo01PopupRoute: Routes = [
    {
        path: 'bba-geo-01-my-suffix/:id/delete',
        component: BbaGeo01MySuffixDeletePopupComponent,
        resolve: {
            bbaGeo01: BbaGeo01MySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'georeferenziazioneApp.bbaGeo01.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
