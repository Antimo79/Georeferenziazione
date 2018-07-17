import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GeoreferenziazioneSharedModule } from 'app/shared';
import {
    BbbaGeo01MySuffixComponent,
    BbbaGeo01MySuffixDetailComponent,
    BbbaGeo01MySuffixUpdateComponent,
    BbbaGeo01MySuffixDeletePopupComponent,
    BbbaGeo01MySuffixDeleteDialogComponent,
    bbbaGeo01Route,
    bbbaGeo01PopupRoute
} from './';

const ENTITY_STATES = [...bbbaGeo01Route, ...bbbaGeo01PopupRoute];

@NgModule({
    imports: [GeoreferenziazioneSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        BbbaGeo01MySuffixComponent,
        BbbaGeo01MySuffixDetailComponent,
        BbbaGeo01MySuffixUpdateComponent,
        BbbaGeo01MySuffixDeleteDialogComponent,
        BbbaGeo01MySuffixDeletePopupComponent
    ],
    entryComponents: [
        BbbaGeo01MySuffixComponent,
        BbbaGeo01MySuffixUpdateComponent,
        BbbaGeo01MySuffixDeleteDialogComponent,
        BbbaGeo01MySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GeoreferenziazioneBbbaGeo01MySuffixModule {}
