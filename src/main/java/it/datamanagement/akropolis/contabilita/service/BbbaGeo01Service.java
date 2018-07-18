package it.datamanagement.akropolis.contabilita.service;

import it.datamanagement.akropolis.contabilita.domain.BbbaGeo01;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing BbbaGeo01.
 */
public interface BbbaGeo01Service {

    /**
     * Save a bbbaGeo01.
     *
     * @param bbbaGeo01 the entity to save
     * @return the persisted entity
     */
    BbbaGeo01 save(BbbaGeo01 bbbaGeo01);

    /**
     * Get all the bbbaGeo01S.
     *
     * @return the list of entities
     */
    List<BbbaGeo01> findAll();


    /**
     * Get the "id" bbbaGeo01.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<BbbaGeo01> findOne(Long id);

    /**
     * Delete the "id" bbbaGeo01.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
