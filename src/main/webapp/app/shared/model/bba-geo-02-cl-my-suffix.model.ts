import { IBbaGeo01MySuffix } from 'app/shared/model//bba-geo-01-my-suffix.model';

export interface IBbaGeo02ClMySuffix {
    id?: number;
    dbClasse?: string;
    idApl?: string;
    cdTiDocInde?: string;
    dbNmClasse?: string;
    idEnte?: string;
    bbaGeo01S?: IBbaGeo01MySuffix[];
}

export class BbaGeo02ClMySuffix implements IBbaGeo02ClMySuffix {
    constructor(
        public id?: number,
        public dbClasse?: string,
        public idApl?: string,
        public cdTiDocInde?: string,
        public dbNmClasse?: string,
        public idEnte?: string,
        public bbaGeo01S?: IBbaGeo01MySuffix[]
    ) {}
}
