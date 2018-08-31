package it.datamanagement.akropolis.contabilita.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * not an ignored comment
 */
@ApiModel(description = "not an ignored comment")
@Entity
@Table(name = "bba_geo_02_cl")
public class BbaGeo02Cl implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "db_classe")
    private String dbClasse;

    @Column(name = "id_apl")
    private String idApl;

    @Column(name = "cd_ti_doc_inde")
    private String cdTiDocInde;

    @Column(name = "db_nm_classe")
    private String dbNmClasse;

    @Column(name = "id_ente")
    private String idEnte;

    @ManyToOne
    @JsonIgnoreProperties("")
    private BbaGeo01 bbaGeo01;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDbClasse() {
        return dbClasse;
    }

    public BbaGeo02Cl dbClasse(String dbClasse) {
        this.dbClasse = dbClasse;
        return this;
    }

    public void setDbClasse(String dbClasse) {
        this.dbClasse = dbClasse;
    }

    public String getIdApl() {
        return idApl;
    }

    public BbaGeo02Cl idApl(String idApl) {
        this.idApl = idApl;
        return this;
    }

    public void setIdApl(String idApl) {
        this.idApl = idApl;
    }

    public String getCdTiDocInde() {
        return cdTiDocInde;
    }

    public BbaGeo02Cl cdTiDocInde(String cdTiDocInde) {
        this.cdTiDocInde = cdTiDocInde;
        return this;
    }

    public void setCdTiDocInde(String cdTiDocInde) {
        this.cdTiDocInde = cdTiDocInde;
    }

    public String getDbNmClasse() {
        return dbNmClasse;
    }

    public BbaGeo02Cl dbNmClasse(String dbNmClasse) {
        this.dbNmClasse = dbNmClasse;
        return this;
    }

    public void setDbNmClasse(String dbNmClasse) {
        this.dbNmClasse = dbNmClasse;
    }

    public String getIdEnte() {
        return idEnte;
    }

    public BbaGeo02Cl idEnte(String idEnte) {
        this.idEnte = idEnte;
        return this;
    }

    public void setIdEnte(String idEnte) {
        this.idEnte = idEnte;
    }

    public BbaGeo01 getBbaGeo01() {
        return bbaGeo01;
    }

    public BbaGeo02Cl bbaGeo01(BbaGeo01 bbaGeo01) {
        this.bbaGeo01 = bbaGeo01;
        return this;
    }

    public void setBbaGeo01(BbaGeo01 bbaGeo01) {
        this.bbaGeo01 = bbaGeo01;
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
        BbaGeo02Cl bbaGeo02Cl = (BbaGeo02Cl) o;
        if (bbaGeo02Cl.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bbaGeo02Cl.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BbaGeo02Cl{" +
            "id=" + getId() +
            ", dbClasse='" + getDbClasse() + "'" +
            ", idApl='" + getIdApl() + "'" +
            ", cdTiDocInde='" + getCdTiDocInde() + "'" +
            ", dbNmClasse='" + getDbNmClasse() + "'" +
            ", idEnte='" + getIdEnte() + "'" +
            "}";
    }
}
