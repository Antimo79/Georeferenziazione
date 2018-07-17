import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { BbbaGeo01MySuffix } from 'app/shared/model/bbba-geo-01-my-suffix.model';
import { BbbaGeo01MySuffixService } from './bbba-geo-01-my-suffix.service';
import { BbbaGeo01MySuffixComponent } from './bbba-geo-01-my-suffix.component';
import { BbbaGeo01MySuffixDetailComponent } from './bbba-geo-01-my-suffix-detail.component';
import { BbbaGeo01MySuffixUpdateComponent } from './bbba-geo-01-my-suffix-update.component';
import { BbbaGeo01MySuffixDeletePopupComponent } from './bbba-geo-01-my-suffix-delete-dialog.component';
import { IBbbaGeo01MySuffix } from 'app/shared/model/bbba-geo-01-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class BbbaGeo01MySuffixResolve implements Resolve<IBbbaGeo01MySuffix> {
    constructor(private service: BbbaGeo01MySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((bbbaGeo01: HttpResponse<BbbaGeo01MySuffix>) => bbbaGeo01.body));
        }
        return of(new BbbaGeo01MySuffix());
    }
}

export const bbbaGeo01Route: Routes = [
    {
        path: 'bbba-geo-01-my-suffix',
        component: BbbaGeo01MySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'georeferenziazioneApp.bbbaGeo01.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bbba-geo-01-my-suffix/:id/view',
        component: BbbaGeo01MySuffixDetailComponent,
        resolve: {
            bbbaGeo01: BbbaGeo01MySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'georeferenziazioneApp.bbbaGeo01.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bbba-geo-01-my-suffix/new',
        component: BbbaGeo01MySuffixUpdateComponent,
        resolve: {
            bbbaGeo01: BbbaGeo01MySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'georeferenziazioneApp.bbbaGeo01.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bbba-geo-01-my-suffix/:id/edit',
        component: BbbaGeo01MySuffixUpdateComponent,
        resolve: {
            bbbaGeo01: BbbaGeo01MySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'georeferenziazioneApp.bbbaGeo01.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const bbbaGeo01PopupRoute: Routes = [
    {
        path: 'bbba-geo-01-my-suffix/:id/delete',
        component: BbbaGeo01MySuffixDeletePopupComponent,
        resolve: {
            bbbaGeo01: BbbaGeo01MySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'georeferenziazioneApp.bbbaGeo01.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
