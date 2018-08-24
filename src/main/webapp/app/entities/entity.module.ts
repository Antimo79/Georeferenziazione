import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { GeoreferenziazioneCutcUtzUbicMySuffixModule } from './cutc-utz-ubic-my-suffix/cutc-utz-ubic-my-suffix.module';
import { GeoreferenziazioneBbaGeo01MySuffixModule } from './bba-geo-01-my-suffix/bba-geo-01-my-suffix.module';
import { GeoreferenziazioneBbaGeo02ClMySuffixModule } from './bba-geo-02-cl-my-suffix/bba-geo-02-cl-my-suffix.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        GeoreferenziazioneCutcUtzUbicMySuffixModule,
        GeoreferenziazioneBbaGeo01MySuffixModule,
        GeoreferenziazioneBbaGeo02ClMySuffixModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GeoreferenziazioneEntityModule {}
