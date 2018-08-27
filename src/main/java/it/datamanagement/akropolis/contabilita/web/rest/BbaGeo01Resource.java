package it.datamanagement.akropolis.contabilita.web.rest;

import com.codahale.metrics.annotation.Timed;
import it.datamanagement.akropolis.contabilita.domain.BbaGeo01;
import it.datamanagement.akropolis.contabilita.service.BbaGeo01Service;
import it.datamanagement.akropolis.contabilita.web.rest.errors.BadRequestAlertException;
import it.datamanagement.akropolis.contabilita.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing BbaGeo01.
 */
@RestController
@RequestMapping("/api")
public class BbaGeo01Resource {

    private final Logger log = LoggerFactory.getLogger(BbaGeo01Resource.class);

    private static final String ENTITY_NAME = "bbaGeo01";

    private final BbaGeo01Service bbaGeo01Service;

    public BbaGeo01Resource(BbaGeo01Service bbaGeo01Service) {
        this.bbaGeo01Service = bbaGeo01Service;
    }

    /**
     * POST  /bba-geo-01-s : Create a new bbaGeo01.
     *
     * @param bbaGeo01 the bbaGeo01 to create
     * @return the ResponseEntity with status 201 (Created) and with body the new bbaGeo01, or with status 400 (Bad Request) if the bbaGeo01 has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/bba-geo-01-s")
    @Timed
    public ResponseEntity<BbaGeo01> createBbaGeo01(@Valid @RequestBody BbaGeo01 bbaGeo01) throws URISyntaxException {
        log.debug("REST request to save BbaGeo01 : {}", bbaGeo01);
        if (bbaGeo01.getId() != null) {
            throw new BadRequestAlertException("A new bbaGeo01 cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BbaGeo01 result = bbaGeo01Service.save(bbaGeo01);
        return ResponseEntity.created(new URI("/api/bba-geo-01-s/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /bba-geo-01-s : Updates an existing bbaGeo01.
     *
     * @param bbaGeo01 the bbaGeo01 to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated bbaGeo01,
     * or with status 400 (Bad Request) if the bbaGeo01 is not valid,
     * or with status 500 (Internal Server Error) if the bbaGeo01 couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/bba-geo-01-s")
    @Timed
    public ResponseEntity<BbaGeo01> updateBbaGeo01(@Valid @RequestBody BbaGeo01 bbaGeo01) throws URISyntaxException {
        log.debug("REST request to update BbaGeo01 : {}", bbaGeo01);
        if (bbaGeo01.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BbaGeo01 result = bbaGeo01Service.save(bbaGeo01);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, bbaGeo01.getId().toString()))
            .body(result);
    }

    /**
     * GET  /bba-geo-01-s : get all the bbaGeo01S.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of bbaGeo01S in body
     */
    @GetMapping("/bba-geo-01-s")
    @Timed
    public List<BbaGeo01> getAllBbaGeo01S() {
        log.debug("REST request to get all BbaGeo01S");
        return bbaGeo01Service.findAll();
    }

    /**
     * GET  /bba-geo-01-s/:id : get the "id" bbaGeo01.
     *
     * @param id the id of the bbaGeo01 to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the bbaGeo01, or with status 404 (Not Found)
     */
    @GetMapping("/bba-geo-01-s/{id}")
    @Timed
    public ResponseEntity<BbaGeo01> getBbaGeo01(@PathVariable Long id) {
        log.debug("REST request to get BbaGeo01 : {}", id);
        Optional<BbaGeo01> bbaGeo01 = bbaGeo01Service.findOne(id);
        return ResponseUtil.wrapOrNotFound(bbaGeo01);
    }

    /**
     * DELETE  /bba-geo-01-s/:id : delete the "id" bbaGeo01.
     *
     * @param id the id of the bbaGeo01 to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/bba-geo-01-s/{id}")
    @Timed
    public ResponseEntity<Void> deleteBbaGeo01(@PathVariable Long id) {
        log.debug("REST request to delete BbaGeo01 : {}", id);
        bbaGeo01Service.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
