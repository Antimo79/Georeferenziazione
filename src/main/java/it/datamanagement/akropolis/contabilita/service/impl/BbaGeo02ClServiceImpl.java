package it.datamanagement.akropolis.contabilita.service.impl;

import it.datamanagement.akropolis.contabilita.service.BbaGeo02ClService;
import it.datamanagement.akropolis.contabilita.domain.BbaGeo02Cl;
import it.datamanagement.akropolis.contabilita.repository.BbaGeo02ClRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
/**
 * Service Implementation for managing BbaGeo02Cl.
 */
@Service
@Transactional
public class BbaGeo02ClServiceImpl implements BbaGeo02ClService {

    private final Logger log = LoggerFactory.getLogger(BbaGeo02ClServiceImpl.class);

    private final BbaGeo02ClRepository bbaGeo02ClRepository;

    public BbaGeo02ClServiceImpl(BbaGeo02ClRepository bbaGeo02ClRepository) {
        this.bbaGeo02ClRepository = bbaGeo02ClRepository;
    }

    /**
     * Save a bbaGeo02Cl.
     *
     * @param bbaGeo02Cl the entity to save
     * @return the persisted entity
     */
    @Override
    public BbaGeo02Cl save(BbaGeo02Cl bbaGeo02Cl) {
        log.debug("Request to save BbaGeo02Cl : {}", bbaGeo02Cl);        return bbaGeo02ClRepository.save(bbaGeo02Cl);
    }

    /**
     * Get all the bbaGeo02Cls.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<BbaGeo02Cl> findAll() {
        log.debug("Request to get all BbaGeo02Cls");
        return bbaGeo02ClRepository.findAll();
    }


    /**
     * Get one bbaGeo02Cl by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BbaGeo02Cl> findOne(Long id) {
        log.debug("Request to get BbaGeo02Cl : {}", id);
        return bbaGeo02ClRepository.findById(id);
    }

    /**
     * Delete the bbaGeo02Cl by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BbaGeo02Cl : {}", id);
        bbaGeo02ClRepository.deleteById(id);
    }
}
