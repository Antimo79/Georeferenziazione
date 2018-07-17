export interface IBbaGeo02ClMySuffix {
    id?: number;
    dbClasse?: string;
    idApl?: string;
    cdTiDocInde?: string;
    dbNmClasse?: string;
    idEnte?: string;
}

export class BbaGeo02ClMySuffix implements IBbaGeo02ClMySuffix {
    constructor(
        public id?: number,
        public dbClasse?: string,
        public idApl?: string,
        public cdTiDocInde?: string,
        public dbNmClasse?: string,
        public idEnte?: string
    ) {}
}
