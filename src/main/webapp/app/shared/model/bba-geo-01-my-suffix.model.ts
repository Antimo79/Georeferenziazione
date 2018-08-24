import { IBbaGeo02ClMySuffix } from 'app/shared/model//bba-geo-02-cl-my-suffix.model';

export interface IBbaGeo01MySuffix {
    id?: number;
    coordx?: string;
    coordy?: string;
    sisRif?: string;
    idRecInt?: string;
    idRecEst?: string;
    idEnte?: string;
    idClasse?: IBbaGeo02ClMySuffix;
}

export class BbaGeo01MySuffix implements IBbaGeo01MySuffix {
    constructor(
        public id?: number,
        public coordx?: string,
        public coordy?: string,
        public sisRif?: string,
        public idRecInt?: string,
        public idRecEst?: string,
        public idEnte?: string,
        public idClasse?: IBbaGeo02ClMySuffix
    ) {}
}
