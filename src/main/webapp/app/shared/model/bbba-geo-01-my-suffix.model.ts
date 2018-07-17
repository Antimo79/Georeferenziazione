import { IBbaGeo02ClMySuffix } from 'app/shared/model//bba-geo-02-cl-my-suffix.model';

export interface IBbbaGeo01MySuffix {
    id?: number;
    coordx?: string;
    coordy?: string;
    chiave?: IBbaGeo02ClMySuffix;
}

export class BbbaGeo01MySuffix implements IBbbaGeo01MySuffix {
    constructor(public id?: number, public coordx?: string, public coordy?: string, public chiave?: IBbaGeo02ClMySuffix) {}
}
