package it.datamanagement.akropolis.contabilita.web.rest;

import it.datamanagement.akropolis.contabilita.GeoreferenziazioneApp;

import it.datamanagement.akropolis.contabilita.domain.BbaGeo01;
import it.datamanagement.akropolis.contabilita.repository.BbaGeo01Repository;
import it.datamanagement.akropolis.contabilita.service.BbaGeo01Service;
import it.datamanagement.akropolis.contabilita.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


import static it.datamanagement.akropolis.contabilita.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the BbaGeo01Resource REST controller.
 *
 * @see BbaGeo01Resource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GeoreferenziazioneApp.class)
public class BbaGeo01ResourceIntTest {

    private static final String DEFAULT_COORDX = "AAAAAAAAAA";
    private static final String UPDATED_COORDX = "BBBBBBBBBB";

    private static final String DEFAULT_COORDY = "AAAAAAAAAA";
    private static final String UPDATED_COORDY = "BBBBBBBBBB";

    private static final String DEFAULT_SIS_RIF = "AAAAAAAAAA";
    private static final String UPDATED_SIS_RIF = "BBBBBBBBBB";

    private static final String DEFAULT_ID_REC_INT = "AAAAAAAAAA";
    private static final String UPDATED_ID_REC_INT = "BBBBBBBBBB";

    private static final String DEFAULT_ID_REC_EST = "AAAAAAAAAA";
    private static final String UPDATED_ID_REC_EST = "BBBBBBBBBB";

    private static final String DEFAULT_ID_ENTE = "AAAAAAAAAA";
    private static final String UPDATED_ID_ENTE = "BBBBBBBBBB";

    private static final String DEFAULT_ID_CLASSE = "AAAAAAAAAA";
    private static final String UPDATED_ID_CLASSE = "BBBBBBBBBB";

    @Autowired
    private BbaGeo01Repository bbaGeo01Repository;

    

    @Autowired
    private BbaGeo01Service bbaGeo01Service;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restBbaGeo01MockMvc;

    private BbaGeo01 bbaGeo01;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final BbaGeo01Resource bbaGeo01Resource = new BbaGeo01Resource(bbaGeo01Service);
        this.restBbaGeo01MockMvc = MockMvcBuilders.standaloneSetup(bbaGeo01Resource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BbaGeo01 createEntity(EntityManager em) {
        BbaGeo01 bbaGeo01 = new BbaGeo01()
            .coordx(DEFAULT_COORDX)
            .coordy(DEFAULT_COORDY)
            .sisRif(DEFAULT_SIS_RIF)
            .idRecInt(DEFAULT_ID_REC_INT)
            .idRecEst(DEFAULT_ID_REC_EST)
            .idEnte(DEFAULT_ID_ENTE)
            .idClasse(DEFAULT_ID_CLASSE);
        return bbaGeo01;
    }

    @Before
    public void initTest() {
        bbaGeo01 = createEntity(em);
    }

    @Test
    @Transactional
    public void createBbaGeo01() throws Exception {
        int databaseSizeBeforeCreate = bbaGeo01Repository.findAll().size();

        // Create the BbaGeo01
        restBbaGeo01MockMvc.perform(post("/api/bba-geo-01-s")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bbaGeo01)))
            .andExpect(status().isCreated());

        // Validate the BbaGeo01 in the database
        List<BbaGeo01> bbaGeo01List = bbaGeo01Repository.findAll();
        assertThat(bbaGeo01List).hasSize(databaseSizeBeforeCreate + 1);
        BbaGeo01 testBbaGeo01 = bbaGeo01List.get(bbaGeo01List.size() - 1);
        assertThat(testBbaGeo01.getCoordx()).isEqualTo(DEFAULT_COORDX);
        assertThat(testBbaGeo01.getCoordy()).isEqualTo(DEFAULT_COORDY);
        assertThat(testBbaGeo01.getSisRif()).isEqualTo(DEFAULT_SIS_RIF);
        assertThat(testBbaGeo01.getIdRecInt()).isEqualTo(DEFAULT_ID_REC_INT);
        assertThat(testBbaGeo01.getIdRecEst()).isEqualTo(DEFAULT_ID_REC_EST);
        assertThat(testBbaGeo01.getIdEnte()).isEqualTo(DEFAULT_ID_ENTE);
        assertThat(testBbaGeo01.getIdClasse()).isEqualTo(DEFAULT_ID_CLASSE);
    }

    @Test
    @Transactional
    public void createBbaGeo01WithExistingId() throws Exception {
        int databaseSizeBeforeCreate = bbaGeo01Repository.findAll().size();

        // Create the BbaGeo01 with an existing ID
        bbaGeo01.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBbaGeo01MockMvc.perform(post("/api/bba-geo-01-s")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bbaGeo01)))
            .andExpect(status().isBadRequest());

        // Validate the BbaGeo01 in the database
        List<BbaGeo01> bbaGeo01List = bbaGeo01Repository.findAll();
        assertThat(bbaGeo01List).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllBbaGeo01S() throws Exception {
        // Initialize the database
        bbaGeo01Repository.saveAndFlush(bbaGeo01);

        // Get all the bbaGeo01List
        restBbaGeo01MockMvc.perform(get("/api/bba-geo-01-s?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(bbaGeo01.getId().intValue())))
            .andExpect(jsonPath("$.[*].coordx").value(hasItem(DEFAULT_COORDX.toString())))
            .andExpect(jsonPath("$.[*].coordy").value(hasItem(DEFAULT_COORDY.toString())))
            .andExpect(jsonPath("$.[*].sisRif").value(hasItem(DEFAULT_SIS_RIF.toString())))
            .andExpect(jsonPath("$.[*].idRecInt").value(hasItem(DEFAULT_ID_REC_INT.toString())))
            .andExpect(jsonPath("$.[*].idRecEst").value(hasItem(DEFAULT_ID_REC_EST.toString())))
            .andExpect(jsonPath("$.[*].idEnte").value(hasItem(DEFAULT_ID_ENTE.toString())))
            .andExpect(jsonPath("$.[*].idClasse").value(hasItem(DEFAULT_ID_CLASSE.toString())));
    }
    

    @Test
    @Transactional
    public void getBbaGeo01() throws Exception {
        // Initialize the database
        bbaGeo01Repository.saveAndFlush(bbaGeo01);

        // Get the bbaGeo01
        restBbaGeo01MockMvc.perform(get("/api/bba-geo-01-s/{id}", bbaGeo01.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(bbaGeo01.getId().intValue()))
            .andExpect(jsonPath("$.coordx").value(DEFAULT_COORDX.toString()))
            .andExpect(jsonPath("$.coordy").value(DEFAULT_COORDY.toString()))
            .andExpect(jsonPath("$.sisRif").value(DEFAULT_SIS_RIF.toString()))
            .andExpect(jsonPath("$.idRecInt").value(DEFAULT_ID_REC_INT.toString()))
            .andExpect(jsonPath("$.idRecEst").value(DEFAULT_ID_REC_EST.toString()))
            .andExpect(jsonPath("$.idEnte").value(DEFAULT_ID_ENTE.toString()))
            .andExpect(jsonPath("$.idClasse").value(DEFAULT_ID_CLASSE.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingBbaGeo01() throws Exception {
        // Get the bbaGeo01
        restBbaGeo01MockMvc.perform(get("/api/bba-geo-01-s/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBbaGeo01() throws Exception {
        // Initialize the database
        bbaGeo01Service.save(bbaGeo01);

        int databaseSizeBeforeUpdate = bbaGeo01Repository.findAll().size();

        // Update the bbaGeo01
        BbaGeo01 updatedBbaGeo01 = bbaGeo01Repository.findById(bbaGeo01.getId()).get();
        // Disconnect from session so that the updates on updatedBbaGeo01 are not directly saved in db
        em.detach(updatedBbaGeo01);
        updatedBbaGeo01
            .coordx(UPDATED_COORDX)
            .coordy(UPDATED_COORDY)
            .sisRif(UPDATED_SIS_RIF)
            .idRecInt(UPDATED_ID_REC_INT)
            .idRecEst(UPDATED_ID_REC_EST)
            .idEnte(UPDATED_ID_ENTE)
            .idClasse(UPDATED_ID_CLASSE);

        restBbaGeo01MockMvc.perform(put("/api/bba-geo-01-s")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedBbaGeo01)))
            .andExpect(status().isOk());

        // Validate the BbaGeo01 in the database
        List<BbaGeo01> bbaGeo01List = bbaGeo01Repository.findAll();
        assertThat(bbaGeo01List).hasSize(databaseSizeBeforeUpdate);
        BbaGeo01 testBbaGeo01 = bbaGeo01List.get(bbaGeo01List.size() - 1);
        assertThat(testBbaGeo01.getCoordx()).isEqualTo(UPDATED_COORDX);
        assertThat(testBbaGeo01.getCoordy()).isEqualTo(UPDATED_COORDY);
        assertThat(testBbaGeo01.getSisRif()).isEqualTo(UPDATED_SIS_RIF);
        assertThat(testBbaGeo01.getIdRecInt()).isEqualTo(UPDATED_ID_REC_INT);
        assertThat(testBbaGeo01.getIdRecEst()).isEqualTo(UPDATED_ID_REC_EST);
        assertThat(testBbaGeo01.getIdEnte()).isEqualTo(UPDATED_ID_ENTE);
        assertThat(testBbaGeo01.getIdClasse()).isEqualTo(UPDATED_ID_CLASSE);
    }

    @Test
    @Transactional
    public void updateNonExistingBbaGeo01() throws Exception {
        int databaseSizeBeforeUpdate = bbaGeo01Repository.findAll().size();

        // Create the BbaGeo01

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restBbaGeo01MockMvc.perform(put("/api/bba-geo-01-s")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bbaGeo01)))
            .andExpect(status().isBadRequest());

        // Validate the BbaGeo01 in the database
        List<BbaGeo01> bbaGeo01List = bbaGeo01Repository.findAll();
        assertThat(bbaGeo01List).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteBbaGeo01() throws Exception {
        // Initialize the database
        bbaGeo01Service.save(bbaGeo01);

        int databaseSizeBeforeDelete = bbaGeo01Repository.findAll().size();

        // Get the bbaGeo01
        restBbaGeo01MockMvc.perform(delete("/api/bba-geo-01-s/{id}", bbaGeo01.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<BbaGeo01> bbaGeo01List = bbaGeo01Repository.findAll();
        assertThat(bbaGeo01List).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BbaGeo01.class);
        BbaGeo01 bbaGeo011 = new BbaGeo01();
        bbaGeo011.setId(1L);
        BbaGeo01 bbaGeo012 = new BbaGeo01();
        bbaGeo012.setId(bbaGeo011.getId());
        assertThat(bbaGeo011).isEqualTo(bbaGeo012);
        bbaGeo012.setId(2L);
        assertThat(bbaGeo011).isNotEqualTo(bbaGeo012);
        bbaGeo011.setId(null);
        assertThat(bbaGeo011).isNotEqualTo(bbaGeo012);
    }
}
