package it.datamanagement.akropolis.contabilita.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A CutcUtzUbic.
 */
@Entity
@Table(name = "cutc_utz_ubic")
public class CutcUtzUbic implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "db_cd_utz")
    private String dbCdUtz;

    @Column(name = "id_ti_utz")
    private String idTiUtz;

    @Column(name = "cdti_utz")
    private String cdtiUtz;

    @Column(name = "db_ti_utz")
    private String dbTiUtz;

    @Column(name = "id_bas_11")
    private String idBas11;

    @Column(name = "cd_strd")
    private String cdStrd;

    @Column(name = "db_posta")
    private String dbPosta;

    @Column(name = "db_alfab")
    private String dbAlfab;

    @Column(name = "db_perc_ini")
    private String dbPercIni;

    @Column(name = "db_perc_final")
    private String dbPercFinal;

    @Column(name = "dt_canc")
    private String dtCanc;

    @Column(name = "ni_civ")
    private Integer niCiv;

    @Column(name = "db_lette_civ")
    private String dbLetteCiv;

    @Column(name = "ti_colore_civ")
    private String tiColoreCiv;

    @Column(name = "cd_uni_urb")
    private String cdUniUrb;

    @Column(name = "db_uni_urb")
    private String dbUniUrb;

    @Column(name = "cd_circs")
    private String cdCircs;

    @Column(name = "db_circs")
    private String dbCircs;

    @Column(name = "cd_cap")
    private String cdCap;

    @Column(name = "cd_sez_vig")
    private String cdSezVig;

    @Column(name = "db_sez_vig")
    private String dbSezVig;

    @Column(name = "ni_interno")
    private Integer niInterno;

    @Column(name = "db_lette_interno")
    private String dbLetteInterno;

    @Column(name = "db_interno_scala")
    private String dbInternoScala;

    @Column(name = "fl_allin")
    private String flAllin;

    @Column(name = "id_ente")
    private String idEnte;

    @ManyToOne
    @JsonIgnoreProperties("")
    private BbbaGeo01 chiave;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDbCdUtz() {
        return dbCdUtz;
    }

    public CutcUtzUbic dbCdUtz(String dbCdUtz) {
        this.dbCdUtz = dbCdUtz;
        return this;
    }

    public void setDbCdUtz(String dbCdUtz) {
        this.dbCdUtz = dbCdUtz;
    }

    public String getIdTiUtz() {
        return idTiUtz;
    }

    public CutcUtzUbic idTiUtz(String idTiUtz) {
        this.idTiUtz = idTiUtz;
        return this;
    }

    public void setIdTiUtz(String idTiUtz) {
        this.idTiUtz = idTiUtz;
    }

    public String getCdtiUtz() {
        return cdtiUtz;
    }

    public CutcUtzUbic cdtiUtz(String cdtiUtz) {
        this.cdtiUtz = cdtiUtz;
        return this;
    }

    public void setCdtiUtz(String cdtiUtz) {
        this.cdtiUtz = cdtiUtz;
    }

    public String getDbTiUtz() {
        return dbTiUtz;
    }

    public CutcUtzUbic dbTiUtz(String dbTiUtz) {
        this.dbTiUtz = dbTiUtz;
        return this;
    }

    public void setDbTiUtz(String dbTiUtz) {
        this.dbTiUtz = dbTiUtz;
    }

    public String getIdBas11() {
        return idBas11;
    }

    public CutcUtzUbic idBas11(String idBas11) {
        this.idBas11 = idBas11;
        return this;
    }

    public void setIdBas11(String idBas11) {
        this.idBas11 = idBas11;
    }

    public String getCdStrd() {
        return cdStrd;
    }

    public CutcUtzUbic cdStrd(String cdStrd) {
        this.cdStrd = cdStrd;
        return this;
    }

    public void setCdStrd(String cdStrd) {
        this.cdStrd = cdStrd;
    }

    public String getDbPosta() {
        return dbPosta;
    }

    public CutcUtzUbic dbPosta(String dbPosta) {
        this.dbPosta = dbPosta;
        return this;
    }

    public void setDbPosta(String dbPosta) {
        this.dbPosta = dbPosta;
    }

    public String getDbAlfab() {
        return dbAlfab;
    }

    public CutcUtzUbic dbAlfab(String dbAlfab) {
        this.dbAlfab = dbAlfab;
        return this;
    }

    public void setDbAlfab(String dbAlfab) {
        this.dbAlfab = dbAlfab;
    }

    public String getDbPercIni() {
        return dbPercIni;
    }

    public CutcUtzUbic dbPercIni(String dbPercIni) {
        this.dbPercIni = dbPercIni;
        return this;
    }

    public void setDbPercIni(String dbPercIni) {
        this.dbPercIni = dbPercIni;
    }

    public String getDbPercFinal() {
        return dbPercFinal;
    }

    public CutcUtzUbic dbPercFinal(String dbPercFinal) {
        this.dbPercFinal = dbPercFinal;
        return this;
    }

    public void setDbPercFinal(String dbPercFinal) {
        this.dbPercFinal = dbPercFinal;
    }

    public String getDtCanc() {
        return dtCanc;
    }

    public CutcUtzUbic dtCanc(String dtCanc) {
        this.dtCanc = dtCanc;
        return this;
    }

    public void setDtCanc(String dtCanc) {
        this.dtCanc = dtCanc;
    }

    public Integer getNiCiv() {
        return niCiv;
    }

    public CutcUtzUbic niCiv(Integer niCiv) {
        this.niCiv = niCiv;
        return this;
    }

    public void setNiCiv(Integer niCiv) {
        this.niCiv = niCiv;
    }

    public String getDbLetteCiv() {
        return dbLetteCiv;
    }

    public CutcUtzUbic dbLetteCiv(String dbLetteCiv) {
        this.dbLetteCiv = dbLetteCiv;
        return this;
    }

    public void setDbLetteCiv(String dbLetteCiv) {
        this.dbLetteCiv = dbLetteCiv;
    }

    public String getTiColoreCiv() {
        return tiColoreCiv;
    }

    public CutcUtzUbic tiColoreCiv(String tiColoreCiv) {
        this.tiColoreCiv = tiColoreCiv;
        return this;
    }

    public void setTiColoreCiv(String tiColoreCiv) {
        this.tiColoreCiv = tiColoreCiv;
    }

    public String getCdUniUrb() {
        return cdUniUrb;
    }

    public CutcUtzUbic cdUniUrb(String cdUniUrb) {
        this.cdUniUrb = cdUniUrb;
        return this;
    }

    public void setCdUniUrb(String cdUniUrb) {
        this.cdUniUrb = cdUniUrb;
    }

    public String getDbUniUrb() {
        return dbUniUrb;
    }

    public CutcUtzUbic dbUniUrb(String dbUniUrb) {
        this.dbUniUrb = dbUniUrb;
        return this;
    }

    public void setDbUniUrb(String dbUniUrb) {
        this.dbUniUrb = dbUniUrb;
    }

    public String getCdCircs() {
        return cdCircs;
    }

    public CutcUtzUbic cdCircs(String cdCircs) {
        this.cdCircs = cdCircs;
        return this;
    }

    public void setCdCircs(String cdCircs) {
        this.cdCircs = cdCircs;
    }

    public String getDbCircs() {
        return dbCircs;
    }

    public CutcUtzUbic dbCircs(String dbCircs) {
        this.dbCircs = dbCircs;
        return this;
    }

    public void setDbCircs(String dbCircs) {
        this.dbCircs = dbCircs;
    }

    public String getCdCap() {
        return cdCap;
    }

    public CutcUtzUbic cdCap(String cdCap) {
        this.cdCap = cdCap;
        return this;
    }

    public void setCdCap(String cdCap) {
        this.cdCap = cdCap;
    }

    public String getCdSezVig() {
        return cdSezVig;
    }

    public CutcUtzUbic cdSezVig(String cdSezVig) {
        this.cdSezVig = cdSezVig;
        return this;
    }

    public void setCdSezVig(String cdSezVig) {
        this.cdSezVig = cdSezVig;
    }

    public String getDbSezVig() {
        return dbSezVig;
    }

    public CutcUtzUbic dbSezVig(String dbSezVig) {
        this.dbSezVig = dbSezVig;
        return this;
    }

    public void setDbSezVig(String dbSezVig) {
        this.dbSezVig = dbSezVig;
    }

    public Integer getNiInterno() {
        return niInterno;
    }

    public CutcUtzUbic niInterno(Integer niInterno) {
        this.niInterno = niInterno;
        return this;
    }

    public void setNiInterno(Integer niInterno) {
        this.niInterno = niInterno;
    }

    public String getDbLetteInterno() {
        return dbLetteInterno;
    }

    public CutcUtzUbic dbLetteInterno(String dbLetteInterno) {
        this.dbLetteInterno = dbLetteInterno;
        return this;
    }

    public void setDbLetteInterno(String dbLetteInterno) {
        this.dbLetteInterno = dbLetteInterno;
    }

    public String getDbInternoScala() {
        return dbInternoScala;
    }

    public CutcUtzUbic dbInternoScala(String dbInternoScala) {
        this.dbInternoScala = dbInternoScala;
        return this;
    }

    public void setDbInternoScala(String dbInternoScala) {
        this.dbInternoScala = dbInternoScala;
    }

    public String getFlAllin() {
        return flAllin;
    }

    public CutcUtzUbic flAllin(String flAllin) {
        this.flAllin = flAllin;
        return this;
    }

    public void setFlAllin(String flAllin) {
        this.flAllin = flAllin;
    }

    public String getIdEnte() {
        return idEnte;
    }

    public CutcUtzUbic idEnte(String idEnte) {
        this.idEnte = idEnte;
        return this;
    }

    public void setIdEnte(String idEnte) {
        this.idEnte = idEnte;
    }

    public BbbaGeo01 getChiave() {
        return chiave;
    }

    public CutcUtzUbic chiave(BbbaGeo01 bbbaGeo01) {
        this.chiave = bbbaGeo01;
        return this;
    }

    public void setChiave(BbbaGeo01 bbbaGeo01) {
        this.chiave = bbbaGeo01;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CutcUtzUbic cutcUtzUbic = (CutcUtzUbic) o;
        if (cutcUtzUbic.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), cutcUtzUbic.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CutcUtzUbic{" +
            "id=" + getId() +
            ", dbCdUtz='" + getDbCdUtz() + "'" +
            ", idTiUtz='" + getIdTiUtz() + "'" +
            ", cdtiUtz='" + getCdtiUtz() + "'" +
            ", dbTiUtz='" + getDbTiUtz() + "'" +
            ", idBas11='" + getIdBas11() + "'" +
            ", cdStrd='" + getCdStrd() + "'" +
            ", dbPosta='" + getDbPosta() + "'" +
            ", dbAlfab='" + getDbAlfab() + "'" +
            ", dbPercIni='" + getDbPercIni() + "'" +
            ", dbPercFinal='" + getDbPercFinal() + "'" +
            ", dtCanc='" + getDtCanc() + "'" +
            ", niCiv=" + getNiCiv() +
            ", dbLetteCiv='" + getDbLetteCiv() + "'" +
            ", tiColoreCiv='" + getTiColoreCiv() + "'" +
            ", cdUniUrb='" + getCdUniUrb() + "'" +
            ", dbUniUrb='" + getDbUniUrb() + "'" +
            ", cdCircs='" + getCdCircs() + "'" +
            ", dbCircs='" + getDbCircs() + "'" +
            ", cdCap='" + getCdCap() + "'" +
            ", cdSezVig='" + getCdSezVig() + "'" +
            ", dbSezVig='" + getDbSezVig() + "'" +
            ", niInterno=" + getNiInterno() +
            ", dbLetteInterno='" + getDbLetteInterno() + "'" +
            ", dbInternoScala='" + getDbInternoScala() + "'" +
            ", flAllin='" + getFlAllin() + "'" +
            ", idEnte='" + getIdEnte() + "'" +
            "}";
    }
}
