import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GeoreferenziazioneSharedModule } from 'app/shared';
import {
    BbaGeo02ClMySuffixComponent,
    BbaGeo02ClMySuffixDetailComponent,
    BbaGeo02ClMySuffixUpdateComponent,
    BbaGeo02ClMySuffixDeletePopupComponent,
    BbaGeo02ClMySuffixDeleteDialogComponent,
    bbaGeo02ClRoute,
    bbaGeo02ClPopupRoute
} from './';

const ENTITY_STATES = [...bbaGeo02ClRoute, ...bbaGeo02ClPopupRoute];

@NgModule({
    imports: [GeoreferenziazioneSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        BbaGeo02ClMySuffixComponent,
        BbaGeo02ClMySuffixDetailComponent,
        BbaGeo02ClMySuffixUpdateComponent,
        BbaGeo02ClMySuffixDeleteDialogComponent,
        BbaGeo02ClMySuffixDeletePopupComponent
    ],
    entryComponents: [
        BbaGeo02ClMySuffixComponent,
        BbaGeo02ClMySuffixUpdateComponent,
        BbaGeo02ClMySuffixDeleteDialogComponent,
        BbaGeo02ClMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GeoreferenziazioneBbaGeo02ClMySuffixModule {}
