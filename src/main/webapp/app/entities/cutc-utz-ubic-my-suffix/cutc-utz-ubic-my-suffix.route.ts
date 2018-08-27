import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { CutcUtzUbicMySuffix } from 'app/shared/model/cutc-utz-ubic-my-suffix.model';
import { CutcUtzUbicMySuffixService } from './cutc-utz-ubic-my-suffix.service';
import { CutcUtzUbicMySuffixComponent } from './cutc-utz-ubic-my-suffix.component';
import { CutcUtzUbicMySuffixDetailComponent } from './cutc-utz-ubic-my-suffix-detail.component';
import { CutcUtzUbicMySuffixUpdateComponent } from './cutc-utz-ubic-my-suffix-update.component';
import { CutcUtzUbicMySuffixDeletePopupComponent } from './cutc-utz-ubic-my-suffix-delete-dialog.component';
import { ICutcUtzUbicMySuffix } from 'app/shared/model/cutc-utz-ubic-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class CutcUtzUbicMySuffixResolve implements Resolve<ICutcUtzUbicMySuffix> {
    constructor(private service: CutcUtzUbicMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((cutcUtzUbic: HttpResponse<CutcUtzUbicMySuffix>) => cutcUtzUbic.body));
        }
        return of(new CutcUtzUbicMySuffix());
    }
}

export const cutcUtzUbicRoute: Routes = [
    {
        path: 'cutc-utz-ubic-my-suffix',
        component: CutcUtzUbicMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'georeferenziazioneApp.cutcUtzUbic.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'cutc-utz-ubic-my-suffix/:id/view',
        component: CutcUtzUbicMySuffixDetailComponent,
        resolve: {
            cutcUtzUbic: CutcUtzUbicMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'georeferenziazioneApp.cutcUtzUbic.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'cutc-utz-ubic-my-suffix/new',
        component: CutcUtzUbicMySuffixUpdateComponent,
        resolve: {
            cutcUtzUbic: CutcUtzUbicMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'georeferenziazioneApp.cutcUtzUbic.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'cutc-utz-ubic-my-suffix/:id/edit',
        component: CutcUtzUbicMySuffixUpdateComponent,
        resolve: {
            cutcUtzUbic: CutcUtzUbicMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'georeferenziazioneApp.cutcUtzUbic.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const cutcUtzUbicPopupRoute: Routes = [
    {
        path: 'cutc-utz-ubic-my-suffix/:id/delete',
        component: CutcUtzUbicMySuffixDeletePopupComponent,
        resolve: {
            cutcUtzUbic: CutcUtzUbicMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'georeferenziazioneApp.cutcUtzUbic.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
