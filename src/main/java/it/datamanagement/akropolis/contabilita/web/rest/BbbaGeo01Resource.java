package it.datamanagement.akropolis.contabilita.web.rest;

import com.codahale.metrics.annotation.Timed;
import it.datamanagement.akropolis.contabilita.domain.BbbaGeo01;
import it.datamanagement.akropolis.contabilita.service.BbbaGeo01Service;
import it.datamanagement.akropolis.contabilita.web.rest.errors.BadRequestAlertException;
import it.datamanagement.akropolis.contabilita.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing BbbaGeo01.
 */
@RestController
@RequestMapping("/api")
public class BbbaGeo01Resource {

    private final Logger log = LoggerFactory.getLogger(BbbaGeo01Resource.class);

    private static final String ENTITY_NAME = "bbbaGeo01";

    private final BbbaGeo01Service bbbaGeo01Service;

    public BbbaGeo01Resource(BbbaGeo01Service bbbaGeo01Service) {
        this.bbbaGeo01Service = bbbaGeo01Service;
    }

    /**
     * POST  /bbba-geo-01-s : Create a new bbbaGeo01.
     *
     * @param bbbaGeo01 the bbbaGeo01 to create
     * @return the ResponseEntity with status 201 (Created) and with body the new bbbaGeo01, or with status 400 (Bad Request) if the bbbaGeo01 has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/bbba-geo-01-s")
    @Timed
    public ResponseEntity<BbbaGeo01> createBbbaGeo01(@RequestBody BbbaGeo01 bbbaGeo01) throws URISyntaxException {
        log.debug("REST request to save BbbaGeo01 : {}", bbbaGeo01);
        if (bbbaGeo01.getId() != null) {
            throw new BadRequestAlertException("A new bbbaGeo01 cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BbbaGeo01 result = bbbaGeo01Service.save(bbbaGeo01);
        return ResponseEntity.created(new URI("/api/bbba-geo-01-s/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /bbba-geo-01-s : Updates an existing bbbaGeo01.
     *
     * @param bbbaGeo01 the bbbaGeo01 to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated bbbaGeo01,
     * or with status 400 (Bad Request) if the bbbaGeo01 is not valid,
     * or with status 500 (Internal Server Error) if the bbbaGeo01 couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/bbba-geo-01-s")
    @Timed
    public ResponseEntity<BbbaGeo01> updateBbbaGeo01(@RequestBody BbbaGeo01 bbbaGeo01) throws URISyntaxException {
        log.debug("REST request to update BbbaGeo01 : {}", bbbaGeo01);
        if (bbbaGeo01.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BbbaGeo01 result = bbbaGeo01Service.save(bbbaGeo01);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, bbbaGeo01.getId().toString()))
            .body(result);
    }

    /**
     * GET  /bbba-geo-01-s : get all the bbbaGeo01S.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of bbbaGeo01S in body
     */
    @GetMapping("/bbba-geo-01-s")
    @Timed
    public List<BbbaGeo01> getAllBbbaGeo01S() {
        log.debug("REST request to get all BbbaGeo01S");
        return bbbaGeo01Service.findAll();
    }

    /**
     * GET  /bbba-geo-01-s/:id : get the "id" bbbaGeo01.
     *
     * @param id the id of the bbbaGeo01 to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the bbbaGeo01, or with status 404 (Not Found)
     */
    @GetMapping("/bbba-geo-01-s/{id}")
    @Timed
    public ResponseEntity<BbbaGeo01> getBbbaGeo01(@PathVariable Long id) {
        log.debug("REST request to get BbbaGeo01 : {}", id);
        Optional<BbbaGeo01> bbbaGeo01 = bbbaGeo01Service.findOne(id);
        return ResponseUtil.wrapOrNotFound(bbbaGeo01);
    }

    /**
     * DELETE  /bbba-geo-01-s/:id : delete the "id" bbbaGeo01.
     *
     * @param id the id of the bbbaGeo01 to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/bbba-geo-01-s/{id}")
    @Timed
    public ResponseEntity<Void> deleteBbbaGeo01(@PathVariable Long id) {
        log.debug("REST request to delete BbbaGeo01 : {}", id);
        bbbaGeo01Service.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
