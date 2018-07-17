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
            "}";
    }
}
