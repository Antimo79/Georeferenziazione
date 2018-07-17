import { IBbbaGeo01MySuffix } from 'app/shared/model//bbba-geo-01-my-suffix.model';

export interface ICutcUtzUbicMySuffix {
    id?: number;
    dbCdUtz?: string;
    idTiUtz?: string;
    cdtiUtz?: string;
    dbTiUtz?: string;
    idBas11?: string;
    cdStrd?: string;
    dbPosta?: string;
    dbAlfab?: string;
    dbPercIni?: string;
    dbPercFinal?: string;
    dtCanc?: string;
    niCiv?: number;
    dbLetteCiv?: string;
    tiColoreCiv?: string;
    cdUniUrb?: string;
    dbUniUrb?: string;
    cdCircs?: string;
    dbCircs?: string;
    cdCap?: string;
    cdSezVig?: string;
    dbSezVig?: string;
    niInterno?: number;
    dbLetteInterno?: string;
    dbInternoScala?: string;
    flAllin?: string;
    idEnte?: string;
    chiave?: IBbbaGeo01MySuffix;
}

export class CutcUtzUbicMySuffix implements ICutcUtzUbicMySuffix {
    constructor(
        public id?: number,
        public dbCdUtz?: string,
        public idTiUtz?: string,
        public cdtiUtz?: string,
        public dbTiUtz?: string,
        public idBas11?: string,
        public cdStrd?: string,
        public dbPosta?: string,
        public dbAlfab?: string,
        public dbPercIni?: string,
        public dbPercFinal?: string,
        public dtCanc?: string,
        public niCiv?: number,
        public dbLetteCiv?: string,
        public tiColoreCiv?: string,
        public cdUniUrb?: string,
        public dbUniUrb?: string,
        public cdCircs?: string,
        public dbCircs?: string,
        public cdCap?: string,
        public cdSezVig?: string,
        public dbSezVig?: string,
        public niInterno?: number,
        public dbLetteInterno?: string,
        public dbInternoScala?: string,
        public flAllin?: string,
        public idEnte?: string,
        public chiave?: IBbbaGeo01MySuffix
    ) {}
}
