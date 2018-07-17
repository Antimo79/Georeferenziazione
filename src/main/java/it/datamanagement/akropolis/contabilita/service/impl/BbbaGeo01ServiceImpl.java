package it.datamanagement.akropolis.contabilita.service.impl;

import it.datamanagement.akropolis.contabilita.service.BbbaGeo01Service;
import it.datamanagement.akropolis.contabilita.domain.BbbaGeo01;
import it.datamanagement.akropolis.contabilita.repository.BbbaGeo01Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
/**
 * Service Implementation for managing BbbaGeo01.
 */
@Service
@Transactional
public class BbbaGeo01ServiceImpl implements BbbaGeo01Service {

    private final Logger log = LoggerFactory.getLogger(BbbaGeo01ServiceImpl.class);

    private final BbbaGeo01Repository bbbaGeo01Repository;

    public BbbaGeo01ServiceImpl(BbbaGeo01Repository bbbaGeo01Repository) {
        this.bbbaGeo01Repository = bbbaGeo01Repository;
    }

    /**
     * Save a bbbaGeo01.
     *
     * @param bbbaGeo01 the entity to save
     * @return the persisted entity
     */
    @Override
    public BbbaGeo01 save(BbbaGeo01 bbbaGeo01) {
        log.debug("Request to save BbbaGeo01 : {}", bbbaGeo01);        return bbbaGeo01Repository.save(bbbaGeo01);
    }

    /**
     * Get all the bbbaGeo01S.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<BbbaGeo01> findAll() {
        log.debug("Request to get all BbbaGeo01S");
        return bbbaGeo01Repository.findAll();
    }


    /**
     * Get one bbbaGeo01 by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BbbaGeo01> findOne(Long id) {
        log.debug("Request to get BbbaGeo01 : {}", id);
        return bbbaGeo01Repository.findById(id);
    }

    /**
     * Delete the bbbaGeo01 by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BbbaGeo01 : {}", id);
        bbbaGeo01Repository.deleteById(id);
    }
}
