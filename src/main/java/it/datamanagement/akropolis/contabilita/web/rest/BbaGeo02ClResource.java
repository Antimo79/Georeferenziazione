package it.datamanagement.akropolis.contabilita.web.rest;

import com.codahale.metrics.annotation.Timed;
import it.datamanagement.akropolis.contabilita.domain.BbaGeo02Cl;
import it.datamanagement.akropolis.contabilita.service.BbaGeo02ClService;
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
 * REST controller for managing BbaGeo02Cl.
 */
@RestController
@RequestMapping("/api")
public class BbaGeo02ClResource {

    private final Logger log = LoggerFactory.getLogger(BbaGeo02ClResource.class);

    private static final String ENTITY_NAME = "bbaGeo02Cl";

    private final BbaGeo02ClService bbaGeo02ClService;

    public BbaGeo02ClResource(BbaGeo02ClService bbaGeo02ClService) {
        this.bbaGeo02ClService = bbaGeo02ClService;
    }

    /**
     * POST  /bba-geo-02-cls : Create a new bbaGeo02Cl.
     *
     * @param bbaGeo02Cl the bbaGeo02Cl to create
     * @return the ResponseEntity with status 201 (Created) and with body the new bbaGeo02Cl, or with status 400 (Bad Request) if the bbaGeo02Cl has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/bba-geo-02-cls")
    @Timed
    public ResponseEntity<BbaGeo02Cl> createBbaGeo02Cl(@RequestBody BbaGeo02Cl bbaGeo02Cl) throws URISyntaxException {
        log.debug("REST request to save BbaGeo02Cl : {}", bbaGeo02Cl);
        if (bbaGeo02Cl.getId() != null) {
            throw new BadRequestAlertException("A new bbaGeo02Cl cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BbaGeo02Cl result = bbaGeo02ClService.save(bbaGeo02Cl);
        return ResponseEntity.created(new URI("/api/bba-geo-02-cls/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /bba-geo-02-cls : Updates an existing bbaGeo02Cl.
     *
     * @param bbaGeo02Cl the bbaGeo02Cl to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated bbaGeo02Cl,
     * or with status 400 (Bad Request) if the bbaGeo02Cl is not valid,
     * or with status 500 (Internal Server Error) if the bbaGeo02Cl couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/bba-geo-02-cls")
    @Timed
    public ResponseEntity<BbaGeo02Cl> updateBbaGeo02Cl(@RequestBody BbaGeo02Cl bbaGeo02Cl) throws URISyntaxException {
        log.debug("REST request to update BbaGeo02Cl : {}", bbaGeo02Cl);
        if (bbaGeo02Cl.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BbaGeo02Cl result = bbaGeo02ClService.save(bbaGeo02Cl);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, bbaGeo02Cl.getId().toString()))
            .body(result);
    }

    /**
     * GET  /bba-geo-02-cls : get all the bbaGeo02Cls.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of bbaGeo02Cls in body
     */
    @GetMapping("/bba-geo-02-cls")
    @Timed
    public List<BbaGeo02Cl> getAllBbaGeo02Cls() {
        log.debug("REST request to get all BbaGeo02Cls");
        return bbaGeo02ClService.findAll();
    }

    /**
     * GET  /bba-geo-02-cls/:id : get the "id" bbaGeo02Cl.
     *
     * @param id the id of the bbaGeo02Cl to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the bbaGeo02Cl, or with status 404 (Not Found)
     */
    @GetMapping("/bba-geo-02-cls/{id}")
    @Timed
    public ResponseEntity<BbaGeo02Cl> getBbaGeo02Cl(@PathVariable Long id) {
        log.debug("REST request to get BbaGeo02Cl : {}", id);
        Optional<BbaGeo02Cl> bbaGeo02Cl = bbaGeo02ClService.findOne(id);
        return ResponseUtil.wrapOrNotFound(bbaGeo02Cl);
    }

    /**
     * DELETE  /bba-geo-02-cls/:id : delete the "id" bbaGeo02Cl.
     *
     * @param id the id of the bbaGeo02Cl to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/bba-geo-02-cls/{id}")
    @Timed
    public ResponseEntity<Void> deleteBbaGeo02Cl(@PathVariable Long id) {
        log.debug("REST request to delete BbaGeo02Cl : {}", id);
        bbaGeo02ClService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
