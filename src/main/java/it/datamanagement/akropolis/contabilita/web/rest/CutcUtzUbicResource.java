package it.datamanagement.akropolis.contabilita.web.rest;

import com.codahale.metrics.annotation.Timed;
import it.datamanagement.akropolis.contabilita.domain.CutcUtzUbic;
import it.datamanagement.akropolis.contabilita.service.CutcUtzUbicService;
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
 * REST controller for managing CutcUtzUbic.
 */
@RestController
@RequestMapping("/api")
public class CutcUtzUbicResource {

    private final Logger log = LoggerFactory.getLogger(CutcUtzUbicResource.class);

    private static final String ENTITY_NAME = "cutcUtzUbic";

    private final CutcUtzUbicService cutcUtzUbicService;

    public CutcUtzUbicResource(CutcUtzUbicService cutcUtzUbicService) {
        this.cutcUtzUbicService = cutcUtzUbicService;
    }

    /**
     * POST  /cutc-utz-ubics : Create a new cutcUtzUbic.
     *
     * @param cutcUtzUbic the cutcUtzUbic to create
     * @return the ResponseEntity with status 201 (Created) and with body the new cutcUtzUbic, or with status 400 (Bad Request) if the cutcUtzUbic has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/cutc-utz-ubics")
    @Timed
    public ResponseEntity<CutcUtzUbic> createCutcUtzUbic(@RequestBody CutcUtzUbic cutcUtzUbic) throws URISyntaxException {
        log.debug("REST request to save CutcUtzUbic : {}", cutcUtzUbic);
        if (cutcUtzUbic.getId() != null) {
            throw new BadRequestAlertException("A new cutcUtzUbic cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CutcUtzUbic result = cutcUtzUbicService.save(cutcUtzUbic);
        return ResponseEntity.created(new URI("/api/cutc-utz-ubics/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /cutc-utz-ubics : Updates an existing cutcUtzUbic.
     *
     * @param cutcUtzUbic the cutcUtzUbic to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated cutcUtzUbic,
     * or with status 400 (Bad Request) if the cutcUtzUbic is not valid,
     * or with status 500 (Internal Server Error) if the cutcUtzUbic couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/cutc-utz-ubics")
    @Timed
    public ResponseEntity<CutcUtzUbic> updateCutcUtzUbic(@RequestBody CutcUtzUbic cutcUtzUbic) throws URISyntaxException {
        log.debug("REST request to update CutcUtzUbic : {}", cutcUtzUbic);
        if (cutcUtzUbic.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CutcUtzUbic result = cutcUtzUbicService.save(cutcUtzUbic);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, cutcUtzUbic.getId().toString()))
            .body(result);
    }

    /**
     * GET  /cutc-utz-ubics : get all the cutcUtzUbics.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of cutcUtzUbics in body
     */
    @GetMapping("/cutc-utz-ubics")
    @Timed
    public List<CutcUtzUbic> getAllCutcUtzUbics() {
        log.debug("REST request to get all CutcUtzUbics");
        return cutcUtzUbicService.findAll();
    }

    /**
     * GET  /cutc-utz-ubics/:id : get the "id" cutcUtzUbic.
     *
     * @param id the id of the cutcUtzUbic to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the cutcUtzUbic, or with status 404 (Not Found)
     */
    @GetMapping("/cutc-utz-ubics/{id}")
    @Timed
    public ResponseEntity<CutcUtzUbic> getCutcUtzUbic(@PathVariable Long id) {
        log.debug("REST request to get CutcUtzUbic : {}", id);
        Optional<CutcUtzUbic> cutcUtzUbic = cutcUtzUbicService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cutcUtzUbic);
    }

    /**
     * DELETE  /cutc-utz-ubics/:id : delete the "id" cutcUtzUbic.
     *
     * @param id the id of the cutcUtzUbic to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/cutc-utz-ubics/{id}")
    @Timed
    public ResponseEntity<Void> deleteCutcUtzUbic(@PathVariable Long id) {
        log.debug("REST request to delete CutcUtzUbic : {}", id);
        cutcUtzUbicService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
