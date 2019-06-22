package it.datamanagement.akropolis.contabilita.service;

import it.datamanagement.akropolis.contabilita.domain.BbaGeo01;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing BbaGeo01.
 */
public interface BbaGeo01Service {

    /**
     * Save a bbaGeo01.
     *
     * @param bbaGeo01 the entity to save
     * @return the persisted entity
     */
    BbaGeo01 save(BbaGeo01 bbaGeo01);

    /**
     * Get all the bbaGeo01S.
     *
     * @return the list of entities
     */
    List<BbaGeo01> findAll();


    /**
     * Get the "id" bbaGeo01.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<BbaGeo01> findOne(Long id);

    /**
     * Delete the "id" bbaGeo01.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
