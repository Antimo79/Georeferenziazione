package it.datamanagement.akropolis.contabilita.service.impl;

import it.datamanagement.akropolis.contabilita.service.BbaGeo01Service;
import it.datamanagement.akropolis.contabilita.domain.BbaGeo01;
import it.datamanagement.akropolis.contabilita.repository.BbaGeo01Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
/**
 * Service Implementation for managing BbaGeo01.
 */
@Service
@Transactional
public class BbaGeo01ServiceImpl implements BbaGeo01Service {

    private final Logger log = LoggerFactory.getLogger(BbaGeo01ServiceImpl.class);

    private final BbaGeo01Repository bbaGeo01Repository;

    public BbaGeo01ServiceImpl(BbaGeo01Repository bbaGeo01Repository) {
        this.bbaGeo01Repository = bbaGeo01Repository;
    }

    /**
     * Save a bbaGeo01.
     *
     * @param bbaGeo01 the entity to save
     * @return the persisted entity
     */
    @Override
    public BbaGeo01 save(BbaGeo01 bbaGeo01) {
        log.debug("Request to save BbaGeo01 : {}", bbaGeo01);        return bbaGeo01Repository.save(bbaGeo01);
    }

    /**
     * Get all the bbaGeo01S.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<BbaGeo01> findAll() {
        log.debug("Request to get all BbaGeo01S");
        return bbaGeo01Repository.findAll();
    }


    /**
     * Get one bbaGeo01 by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BbaGeo01> findOne(Long id) {
        log.debug("Request to get BbaGeo01 : {}", id);
        return bbaGeo01Repository.findById(id);
    }

    /**
     * Delete the bbaGeo01 by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BbaGeo01 : {}", id);
        bbaGeo01Repository.deleteById(id);
    }
}
