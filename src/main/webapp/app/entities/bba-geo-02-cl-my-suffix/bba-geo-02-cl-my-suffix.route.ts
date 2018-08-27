import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { BbaGeo02ClMySuffix } from 'app/shared/model/bba-geo-02-cl-my-suffix.model';
import { BbaGeo02ClMySuffixService } from './bba-geo-02-cl-my-suffix.service';
import { BbaGeo02ClMySuffixComponent } from './bba-geo-02-cl-my-suffix.component';
import { BbaGeo02ClMySuffixDetailComponent } from './bba-geo-02-cl-my-suffix-detail.component';
import { BbaGeo02ClMySuffixUpdateComponent } from './bba-geo-02-cl-my-suffix-update.component';
import { BbaGeo02ClMySuffixDeletePopupComponent } from './bba-geo-02-cl-my-suffix-delete-dialog.component';
import { IBbaGeo02ClMySuffix } from 'app/shared/model/bba-geo-02-cl-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class BbaGeo02ClMySuffixResolve implements Resolve<IBbaGeo02ClMySuffix> {
    constructor(private service: BbaGeo02ClMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((bbaGeo02Cl: HttpResponse<BbaGeo02ClMySuffix>) => bbaGeo02Cl.body));
        }
        return of(new BbaGeo02ClMySuffix());
    }
}

export const bbaGeo02ClRoute: Routes = [
    {
        path: 'bba-geo-02-cl-my-suffix',
        component: BbaGeo02ClMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'georeferenziazioneApp.bbaGeo02Cl.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bba-geo-02-cl-my-suffix/:id/view',
        component: BbaGeo02ClMySuffixDetailComponent,
        resolve: {
            bbaGeo02Cl: BbaGeo02ClMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'georeferenziazioneApp.bbaGeo02Cl.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bba-geo-02-cl-my-suffix/new',
        component: BbaGeo02ClMySuffixUpdateComponent,
        resolve: {
            bbaGeo02Cl: BbaGeo02ClMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'georeferenziazioneApp.bbaGeo02Cl.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'bba-geo-02-cl-my-suffix/:id/edit',
        component: BbaGeo02ClMySuffixUpdateComponent,
        resolve: {
            bbaGeo02Cl: BbaGeo02ClMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'georeferenziazioneApp.bbaGeo02Cl.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const bbaGeo02ClPopupRoute: Routes = [
    {
        path: 'bba-geo-02-cl-my-suffix/:id/delete',
        component: BbaGeo02ClMySuffixDeletePopupComponent,
        resolve: {
            bbaGeo02Cl: BbaGeo02ClMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'georeferenziazioneApp.bbaGeo02Cl.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
