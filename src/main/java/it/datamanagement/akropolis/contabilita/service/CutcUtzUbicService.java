package it.datamanagement.akropolis.contabilita.service;

import it.datamanagement.akropolis.contabilita.domain.CutcUtzUbic;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing CutcUtzUbic.
 */
public interface CutcUtzUbicService {

    /**
     * Save a cutcUtzUbic.
     *
     * @param cutcUtzUbic the entity to save
     * @return the persisted entity
     */
    CutcUtzUbic save(CutcUtzUbic cutcUtzUbic);

    /**
     * Get all the cutcUtzUbics.
     *
     * @return the list of entities
     */
    List<CutcUtzUbic> findAll();


    /**
     * Get the "id" cutcUtzUbic.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<CutcUtzUbic> findOne(Long id);

    /**
     * Delete the "id" cutcUtzUbic.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
