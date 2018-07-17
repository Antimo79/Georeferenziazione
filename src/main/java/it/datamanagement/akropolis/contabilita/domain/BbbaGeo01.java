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
            "}";
    }
}
