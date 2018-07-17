import { IBbaGeo02ClMySuffix } from 'app/shared/model//bba-geo-02-cl-my-suffix.model';

export interface IBbbaGeo01MySuffix {
    id?: number;
    coordx?: string;
    coordy?: string;
    sisRif?: string;
    idRecInt?: string;
    idRecEst?: string;
    idEnte?: string;
    idClasse?: string;
    chiave?: IBbaGeo02ClMySuffix;
}

export class BbbaGeo01MySuffix implements IBbbaGeo01MySuffix {
    constructor(
        public id?: number,
        public coordx?: string,
        public coordy?: string,
        public sisRif?: string,
        public idRecInt?: string,
        public idRecEst?: string,
        public idEnte?: string,
        public idClasse?: string,
        public chiave?: IBbaGeo02ClMySuffix
    ) {}
}
