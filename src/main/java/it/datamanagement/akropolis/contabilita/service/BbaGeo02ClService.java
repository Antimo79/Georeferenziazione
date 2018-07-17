package it.datamanagement.akropolis.contabilita.service;

import it.datamanagement.akropolis.contabilita.domain.BbaGeo02Cl;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing BbaGeo02Cl.
 */
public interface BbaGeo02ClService {

    /**
     * Save a bbaGeo02Cl.
     *
     * @param bbaGeo02Cl the entity to save
     * @return the persisted entity
     */
    BbaGeo02Cl save(BbaGeo02Cl bbaGeo02Cl);

    /**
     * Get all the bbaGeo02Cls.
     *
     * @return the list of entities
     */
    List<BbaGeo02Cl> findAll();


    /**
     * Get the "id" bbaGeo02Cl.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<BbaGeo02Cl> findOne(Long id);

    /**
     * Delete the "id" bbaGeo02Cl.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
