export interface IBbaGeo02ClMySuffix {
    id?: number;
    dbClasse?: string;
}

export class BbaGeo02ClMySuffix implements IBbaGeo02ClMySuffix {
    constructor(public id?: number, public dbClasse?: string) {}
}
