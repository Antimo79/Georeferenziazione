import { IBbbaGeo01MySuffix } from 'app/shared/model//bbba-geo-01-my-suffix.model';

export interface ICutcUtzUbicMySuffix {
    id?: number;
    dbCdUtz?: string;
    chiave?: IBbbaGeo01MySuffix;
}

export class CutcUtzUbicMySuffix implements ICutcUtzUbicMySuffix {
    constructor(public id?: number, public dbCdUtz?: string, public chiave?: IBbbaGeo01MySuffix) {}
}
