export interface IBbaGeo01MySuffix {
    id?: number;
    coordx?: string;
    coordy?: string;
    sisRif?: string;
    idRecInt?: string;
    idRecEst?: string;
    idEnte?: string;
}

export class BbaGeo01MySuffix implements IBbaGeo01MySuffix {
    constructor(
        public id?: number,
        public coordx?: string,
        public coordy?: string,
        public sisRif?: string,
        public idRecInt?: string,
        public idRecEst?: string,
        public idEnte?: string
    ) {}
}
