package it.datamanagement.akropolis.contabilita.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A BbaGeo01.
 */
@Entity
@Table(name = "bba_geo_01")
public class BbaGeo01 implements Serializable {

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

    public BbaGeo01 coordx(String coordx) {
        this.coordx = coordx;
        return this;
    }

    public void setCoordx(String coordx) {
        this.coordx = coordx;
    }

    public String getCoordy() {
        return coordy;
    }

    public BbaGeo01 coordy(String coordy) {
        this.coordy = coordy;
        return this;
    }

    public void setCoordy(String coordy) {
        this.coordy = coordy;
    }

    public String getSisRif() {
        return sisRif;
    }

    public BbaGeo01 sisRif(String sisRif) {
        this.sisRif = sisRif;
        return this;
    }

    public void setSisRif(String sisRif) {
        this.sisRif = sisRif;
    }

    public String getIdRecInt() {
        return idRecInt;
    }

    public BbaGeo01 idRecInt(String idRecInt) {
        this.idRecInt = idRecInt;
        return this;
    }

    public void setIdRecInt(String idRecInt) {
        this.idRecInt = idRecInt;
    }

    public String getIdRecEst() {
        return idRecEst;
    }

    public BbaGeo01 idRecEst(String idRecEst) {
        this.idRecEst = idRecEst;
        return this;
    }

    public void setIdRecEst(String idRecEst) {
        this.idRecEst = idRecEst;
    }

    public String getIdEnte() {
        return idEnte;
    }

    public BbaGeo01 idEnte(String idEnte) {
        this.idEnte = idEnte;
        return this;
    }

    public void setIdEnte(String idEnte) {
        this.idEnte = idEnte;
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
        BbaGeo01 bbaGeo01 = (BbaGeo01) o;
        if (bbaGeo01.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bbaGeo01.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BbaGeo01{" +
            "id=" + getId() +
            ", coordx='" + getCoordx() + "'" +
            ", coordy='" + getCoordy() + "'" +
            ", sisRif='" + getSisRif() + "'" +
            ", idRecInt='" + getIdRecInt() + "'" +
            ", idRecEst='" + getIdRecEst() + "'" +
            ", idEnte='" + getIdEnte() + "'" +
            "}";
    }
}
