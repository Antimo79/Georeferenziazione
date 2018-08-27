import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GeoreferenziazioneSharedModule } from 'app/shared';
import {
    CutcUtzUbicMySuffixComponent,
    CutcUtzUbicMySuffixDetailComponent,
    CutcUtzUbicMySuffixUpdateComponent,
    CutcUtzUbicMySuffixDeletePopupComponent,
    CutcUtzUbicMySuffixDeleteDialogComponent,
    cutcUtzUbicRoute,
    cutcUtzUbicPopupRoute
} from './';

const ENTITY_STATES = [...cutcUtzUbicRoute, ...cutcUtzUbicPopupRoute];

@NgModule({
    imports: [GeoreferenziazioneSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        CutcUtzUbicMySuffixComponent,
        CutcUtzUbicMySuffixDetailComponent,
        CutcUtzUbicMySuffixUpdateComponent,
        CutcUtzUbicMySuffixDeleteDialogComponent,
        CutcUtzUbicMySuffixDeletePopupComponent
    ],
    entryComponents: [
        CutcUtzUbicMySuffixComponent,
        CutcUtzUbicMySuffixUpdateComponent,
        CutcUtzUbicMySuffixDeleteDialogComponent,
        CutcUtzUbicMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GeoreferenziazioneCutcUtzUbicMySuffixModule {}
