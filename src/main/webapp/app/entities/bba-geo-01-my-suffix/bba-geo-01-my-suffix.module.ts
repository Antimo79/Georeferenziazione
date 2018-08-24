import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GeoreferenziazioneSharedModule } from 'app/shared';
import {
    BbaGeo01MySuffixComponent,
    BbaGeo01MySuffixDetailComponent,
    BbaGeo01MySuffixUpdateComponent,
    BbaGeo01MySuffixDeletePopupComponent,
    BbaGeo01MySuffixDeleteDialogComponent,
    bbaGeo01Route,
    bbaGeo01PopupRoute
} from './';

const ENTITY_STATES = [...bbaGeo01Route, ...bbaGeo01PopupRoute];

@NgModule({
    imports: [GeoreferenziazioneSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        BbaGeo01MySuffixComponent,
        BbaGeo01MySuffixDetailComponent,
        BbaGeo01MySuffixUpdateComponent,
        BbaGeo01MySuffixDeleteDialogComponent,
        BbaGeo01MySuffixDeletePopupComponent
    ],
    entryComponents: [
        BbaGeo01MySuffixComponent,
        BbaGeo01MySuffixUpdateComponent,
        BbaGeo01MySuffixDeleteDialogComponent,
        BbaGeo01MySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GeoreferenziazioneBbaGeo01MySuffixModule {}
