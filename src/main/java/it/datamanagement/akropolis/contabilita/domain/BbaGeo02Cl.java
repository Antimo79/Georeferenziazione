package it.datamanagement.akropolis.contabilita.domain;

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
            "}";
    }
}
