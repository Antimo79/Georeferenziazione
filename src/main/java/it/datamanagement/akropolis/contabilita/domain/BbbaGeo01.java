package it.datamanagement.akropolis.contabilita.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A BbbaGeo01.
 */
@Entity
@Table(name = "bbba_geo_01")
public class BbbaGeo01 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "coordx")
    private String coordx;

    @Column(name = "coordy")
    private String coordy;

    @Column(name = "sis_rif")
    private String sisRif;

    @Column(name = "id_rec_int")
    private String idRecInt;

    @Column(name = "id_rec_est")
    private String idRecEst;

    @Column(name = "id_ente")
    private String idEnte;

    @Column(name = "id_classe")
    private String idClasse;

    @ManyToOne
    @JsonIgnoreProperties("")
    private BbaGeo02Cl chiave;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoordx() {
        return coordx;
    }

    public BbbaGeo01 coordx(String coordx) {
        this.coordx = coordx;
        return this;
    }

    public void setCoordx(String coordx) {
        this.coordx = coordx;
    }

    public String getCoordy() {
        return coordy;
    }

    public BbbaGeo01 coordy(String coordy) {
        this.coordy = coordy;
        return this;
    }

    public void setCoordy(String coordy) {
        this.coordy = coordy;
    }

    public String getSisRif() {
        return sisRif;
    }

    public BbbaGeo01 sisRif(String sisRif) {
        this.sisRif = sisRif;
        return this;
    }

    public void setSisRif(String sisRif) {
        this.sisRif = sisRif;
    }

    public String getIdRecInt() {
        return idRecInt;
    }

    public BbbaGeo01 idRecInt(String idRecInt) {
        this.idRecInt = idRecInt;
        return this;
    }

    public void setIdRecInt(String idRecInt) {
        this.idRecInt = idRecInt;
    }

    public String getIdRecEst() {
        return idRecEst;
    }

    public BbbaGeo01 idRecEst(String idRecEst) {
        this.idRecEst = idRecEst;
        return this;
    }

    public void setIdRecEst(String idRecEst) {
        this.idRecEst = idRecEst;
    }

    public String getIdEnte() {
        return idEnte;
    }

    public BbbaGeo01 idEnte(String idEnte) {
        this.idEnte = idEnte;
        return this;
    }

    public void setIdEnte(String idEnte) {
        this.idEnte = idEnte;
    }

    public String getIdClasse() {
        return idClasse;
    }

    public BbbaGeo01 idClasse(String idClasse) {
        this.idClasse = idClasse;
        return this;
    }

    public void setIdClasse(String idClasse) {
        this.idClasse = idClasse;
    }

    public BbaGeo02Cl getChiave() {
        return chiave;
    }

    public BbbaGeo01 chiave(BbaGeo02Cl bbaGeo02Cl) {
        this.chiave = bbaGeo02Cl;
        return this;
    }

    public void setChiave(BbaGeo02Cl bbaGeo02Cl) {
        this.chiave = bbaGeo02Cl;
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
        BbbaGeo01 bbbaGeo01 = (BbbaGeo01) o;
        if (bbbaGeo01.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bbbaGeo01.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BbbaGeo01{" +
            "id=" + getId() +
            ", coordx='" + getCoordx() + "'" +
            ", coordy='" + getCoordy() + "'" +
            ", sisRif='" + getSisRif() + "'" +
            ", idRecInt='" + getIdRecInt() + "'" +
            ", idRecEst='" + getIdRecEst() + "'" +
            ", idEnte='" + getIdEnte() + "'" +
            ", idClasse='" + getIdClasse() + "'" +
            "}";
    }
}