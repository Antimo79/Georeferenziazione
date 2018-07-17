package it.datamanagement.akropolis.contabilita.web.rest;

import it.datamanagement.akropolis.contabilita.GeoreferenziazioneApp;

import it.datamanagement.akropolis.contabilita.domain.BbbaGeo01;
import it.datamanagement.akropolis.contabilita.repository.BbbaGeo01Repository;
import it.datamanagement.akropolis.contabilita.service.BbbaGeo01Service;
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
 * Test class for the BbbaGeo01Resource REST controller.
 *
 * @see BbbaGeo01Resource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GeoreferenziazioneApp.class)
public class BbbaGeo01ResourceIntTest {

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
    private BbbaGeo01Repository bbbaGeo01Repository;

    

    @Autowired
    private BbbaGeo01Service bbbaGeo01Service;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restBbbaGeo01MockMvc;

    private BbbaGeo01 bbbaGeo01;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final BbbaGeo01Resource bbbaGeo01Resource = new BbbaGeo01Resource(bbbaGeo01Service);
        this.restBbbaGeo01MockMvc = MockMvcBuilders.standaloneSetup(bbbaGeo01Resource)
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
    public static BbbaGeo01 createEntity(EntityManager em) {
        BbbaGeo01 bbbaGeo01 = new BbbaGeo01()
            .coordx(DEFAULT_COORDX)
            .coordy(DEFAULT_COORDY)
            .sisRif(DEFAULT_SIS_RIF)
            .idRecInt(DEFAULT_ID_REC_INT)
            .idRecEst(DEFAULT_ID_REC_EST)
            .idEnte(DEFAULT_ID_ENTE)
            .idClasse(DEFAULT_ID_CLASSE);
        return bbbaGeo01;
    }

    @Before
    public void initTest() {
        bbbaGeo01 = createEntity(em);
    }

    @Test
    @Transactional
    public void createBbbaGeo01() throws Exception {
        int databaseSizeBeforeCreate = bbbaGeo01Repository.findAll().size();

        // Create the BbbaGeo01
        restBbbaGeo01MockMvc.perform(post("/api/bbba-geo-01-s")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bbbaGeo01)))
            .andExpect(status().isCreated());

        // Validate the BbbaGeo01 in the database
        List<BbbaGeo01> bbbaGeo01List = bbbaGeo01Repository.findAll();
        assertThat(bbbaGeo01List).hasSize(databaseSizeBeforeCreate + 1);
        BbbaGeo01 testBbbaGeo01 = bbbaGeo01List.get(bbbaGeo01List.size() - 1);
        assertThat(testBbbaGeo01.getCoordx()).isEqualTo(DEFAULT_COORDX);
        assertThat(testBbbaGeo01.getCoordy()).isEqualTo(DEFAULT_COORDY);
        assertThat(testBbbaGeo01.getSisRif()).isEqualTo(DEFAULT_SIS_RIF);
        assertThat(testBbbaGeo01.getIdRecInt()).isEqualTo(DEFAULT_ID_REC_INT);
        assertThat(testBbbaGeo01.getIdRecEst()).isEqualTo(DEFAULT_ID_REC_EST);
        assertThat(testBbbaGeo01.getIdEnte()).isEqualTo(DEFAULT_ID_ENTE);
        assertThat(testBbbaGeo01.getIdClasse()).isEqualTo(DEFAULT_ID_CLASSE);
    }

    @Test
    @Transactional
    public void createBbbaGeo01WithExistingId() throws Exception {
        int databaseSizeBeforeCreate = bbbaGeo01Repository.findAll().size();

        // Create the BbbaGeo01 with an existing ID
        bbbaGeo01.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBbbaGeo01MockMvc.perform(post("/api/bbba-geo-01-s")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bbbaGeo01)))
            .andExpect(status().isBadRequest());

        // Validate the BbbaGeo01 in the database
        List<BbbaGeo01> bbbaGeo01List = bbbaGeo01Repository.findAll();
        assertThat(bbbaGeo01List).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllBbbaGeo01S() throws Exception {
        // Initialize the database
        bbbaGeo01Repository.saveAndFlush(bbbaGeo01);

        // Get all the bbbaGeo01List
        restBbbaGeo01MockMvc.perform(get("/api/bbba-geo-01-s?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(bbbaGeo01.getId().intValue())))
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
    public void getBbbaGeo01() throws Exception {
        // Initialize the database
        bbbaGeo01Repository.saveAndFlush(bbbaGeo01);

        // Get the bbbaGeo01
        restBbbaGeo01MockMvc.perform(get("/api/bbba-geo-01-s/{id}", bbbaGeo01.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(bbbaGeo01.getId().intValue()))
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
    public void getNonExistingBbbaGeo01() throws Exception {
        // Get the bbbaGeo01
        restBbbaGeo01MockMvc.perform(get("/api/bbba-geo-01-s/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBbbaGeo01() throws Exception {
        // Initialize the database
        bbbaGeo01Service.save(bbbaGeo01);

        int databaseSizeBeforeUpdate = bbbaGeo01Repository.findAll().size();

        // Update the bbbaGeo01
        BbbaGeo01 updatedBbbaGeo01 = bbbaGeo01Repository.findById(bbbaGeo01.getId()).get();
        // Disconnect from session so that the updates on updatedBbbaGeo01 are not directly saved in db
        em.detach(updatedBbbaGeo01);
        updatedBbbaGeo01
            .coordx(UPDATED_COORDX)
            .coordy(UPDATED_COORDY)
            .sisRif(UPDATED_SIS_RIF)
            .idRecInt(UPDATED_ID_REC_INT)
            .idRecEst(UPDATED_ID_REC_EST)
            .idEnte(UPDATED_ID_ENTE)
            .idClasse(UPDATED_ID_CLASSE);

        restBbbaGeo01MockMvc.perform(put("/api/bbba-geo-01-s")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedBbbaGeo01)))
            .andExpect(status().isOk());

        // Validate the BbbaGeo01 in the database
        List<BbbaGeo01> bbbaGeo01List = bbbaGeo01Repository.findAll();
        assertThat(bbbaGeo01List).hasSize(databaseSizeBeforeUpdate);
        BbbaGeo01 testBbbaGeo01 = bbbaGeo01List.get(bbbaGeo01List.size() - 1);
        assertThat(testBbbaGeo01.getCoordx()).isEqualTo(UPDATED_COORDX);
        assertThat(testBbbaGeo01.getCoordy()).isEqualTo(UPDATED_COORDY);
        assertThat(testBbbaGeo01.getSisRif()).isEqualTo(UPDATED_SIS_RIF);
        assertThat(testBbbaGeo01.getIdRecInt()).isEqualTo(UPDATED_ID_REC_INT);
        assertThat(testBbbaGeo01.getIdRecEst()).isEqualTo(UPDATED_ID_REC_EST);
        assertThat(testBbbaGeo01.getIdEnte()).isEqualTo(UPDATED_ID_ENTE);
        assertThat(testBbbaGeo01.getIdClasse()).isEqualTo(UPDATED_ID_CLASSE);
    }

    @Test
    @Transactional
    public void updateNonExistingBbbaGeo01() throws Exception {
        int databaseSizeBeforeUpdate = bbbaGeo01Repository.findAll().size();

        // Create the BbbaGeo01

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restBbbaGeo01MockMvc.perform(put("/api/bbba-geo-01-s")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bbbaGeo01)))
            .andExpect(status().isBadRequest());

        // Validate the BbbaGeo01 in the database
        List<BbbaGeo01> bbbaGeo01List = bbbaGeo01Repository.findAll();
        assertThat(bbbaGeo01List).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteBbbaGeo01() throws Exception {
        // Initialize the database
        bbbaGeo01Service.save(bbbaGeo01);

        int databaseSizeBeforeDelete = bbbaGeo01Repository.findAll().size();

        // Get the bbbaGeo01
        restBbbaGeo01MockMvc.perform(delete("/api/bbba-geo-01-s/{id}", bbbaGeo01.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<BbbaGeo01> bbbaGeo01List = bbbaGeo01Repository.findAll();
        assertThat(bbbaGeo01List).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BbbaGeo01.class);
        BbbaGeo01 bbbaGeo011 = new BbbaGeo01();
        bbbaGeo011.setId(1L);
        BbbaGeo01 bbbaGeo012 = new BbbaGeo01();
        bbbaGeo012.setId(bbbaGeo011.getId());
        assertThat(bbbaGeo011).isEqualTo(bbbaGeo012);
        bbbaGeo012.setId(2L);
        assertThat(bbbaGeo011).isNotEqualTo(bbbaGeo012);
        bbbaGeo011.setId(null);
        assertThat(bbbaGeo011).isNotEqualTo(bbbaGeo012);
    }
}
