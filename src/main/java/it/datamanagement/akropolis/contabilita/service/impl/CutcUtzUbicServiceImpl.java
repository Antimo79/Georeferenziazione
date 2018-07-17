package it.datamanagement.akropolis.contabilita.service.impl;

import it.datamanagement.akropolis.contabilita.service.CutcUtzUbicService;
import it.datamanagement.akropolis.contabilita.domain.CutcUtzUbic;
import it.datamanagement.akropolis.contabilita.repository.CutcUtzUbicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
/**
 * Service Implementation for managing CutcUtzUbic.
 */
@Service
@Transactional
public class CutcUtzUbicServiceImpl implements CutcUtzUbicService {

    private final Logger log = LoggerFactory.getLogger(CutcUtzUbicServiceImpl.class);

    private final CutcUtzUbicRepository cutcUtzUbicRepository;

    public CutcUtzUbicServiceImpl(CutcUtzUbicRepository cutcUtzUbicRepository) {
        this.cutcUtzUbicRepository = cutcUtzUbicRepository;
    }

    /**
     * Save a cutcUtzUbic.
     *
     * @param cutcUtzUbic the entity to save
     * @return the persisted entity
     */
    @Override
    public CutcUtzUbic save(CutcUtzUbic cutcUtzUbic) {
        log.debug("Request to save CutcUtzUbic : {}", cutcUtzUbic);        return cutcUtzUbicRepository.save(cutcUtzUbic);
    }

    /**
     * Get all the cutcUtzUbics.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<CutcUtzUbic> findAll() {
        log.debug("Request to get all CutcUtzUbics");
        return cutcUtzUbicRepository.findAll();
    }


    /**
     * Get one cutcUtzUbic by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<CutcUtzUbic> findOne(Long id) {
        log.debug("Request to get CutcUtzUbic : {}", id);
        return cutcUtzUbicRepository.findById(id);
    }

    /**
     * Delete the cutcUtzUbic by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CutcUtzUbic : {}", id);
        cutcUtzUbicRepository.deleteById(id);
    }
}
