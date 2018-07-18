package it.datamanagement.akropolis.contabilita.web.rest;

import it.datamanagement.akropolis.contabilita.GeoreferenziazioneApp;

import it.datamanagement.akropolis.contabilita.domain.BbaGeo02Cl;
import it.datamanagement.akropolis.contabilita.repository.BbaGeo02ClRepository;
import it.datamanagement.akropolis.contabilita.service.BbaGeo02ClService;
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
 * Test class for the BbaGeo02ClResource REST controller.
 *
 * @see BbaGeo02ClResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GeoreferenziazioneApp.class)
public class BbaGeo02ClResourceIntTest {

    private static final String DEFAULT_DB_CLASSE = "AAAAAAAAAA";
    private static final String UPDATED_DB_CLASSE = "BBBBBBBBBB";

    private static final String DEFAULT_ID_APL = "AAAAAAAAAA";
    private static final String UPDATED_ID_APL = "BBBBBBBBBB";

    private static final String DEFAULT_CD_TI_DOC_INDE = "AAAAAAAAAA";
    private static final String UPDATED_CD_TI_DOC_INDE = "BBBBBBBBBB";

    private static final String DEFAULT_DB_NM_CLASSE = "AAAAAAAAAA";
    private static final String UPDATED_DB_NM_CLASSE = "BBBBBBBBBB";

    private static final String DEFAULT_ID_ENTE = "AAAAAAAAAA";
    private static final String UPDATED_ID_ENTE = "BBBBBBBBBB";

    @Autowired
    private BbaGeo02ClRepository bbaGeo02ClRepository;

    

    @Autowired
    private BbaGeo02ClService bbaGeo02ClService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restBbaGeo02ClMockMvc;

    private BbaGeo02Cl bbaGeo02Cl;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final BbaGeo02ClResource bbaGeo02ClResource = new BbaGeo02ClResource(bbaGeo02ClService);
        this.restBbaGeo02ClMockMvc = MockMvcBuilders.standaloneSetup(bbaGeo02ClResource)
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
    public static BbaGeo02Cl createEntity(EntityManager em) {
        BbaGeo02Cl bbaGeo02Cl = new BbaGeo02Cl()
            .dbClasse(DEFAULT_DB_CLASSE)
            .idApl(DEFAULT_ID_APL)
            .cdTiDocInde(DEFAULT_CD_TI_DOC_INDE)
            .dbNmClasse(DEFAULT_DB_NM_CLASSE)
            .idEnte(DEFAULT_ID_ENTE);
        return bbaGeo02Cl;
    }

    @Before
    public void initTest() {
        bbaGeo02Cl = createEntity(em);
    }

    @Test
    @Transactional
    public void createBbaGeo02Cl() throws Exception {
        int databaseSizeBeforeCreate = bbaGeo02ClRepository.findAll().size();

        // Create the BbaGeo02Cl
        restBbaGeo02ClMockMvc.perform(post("/api/bba-geo-02-cls")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bbaGeo02Cl)))
            .andExpect(status().isCreated());

        // Validate the BbaGeo02Cl in the database
        List<BbaGeo02Cl> bbaGeo02ClList = bbaGeo02ClRepository.findAll();
        assertThat(bbaGeo02ClList).hasSize(databaseSizeBeforeCreate + 1);
        BbaGeo02Cl testBbaGeo02Cl = bbaGeo02ClList.get(bbaGeo02ClList.size() - 1);
        assertThat(testBbaGeo02Cl.getDbClasse()).isEqualTo(DEFAULT_DB_CLASSE);
        assertThat(testBbaGeo02Cl.getIdApl()).isEqualTo(DEFAULT_ID_APL);
        assertThat(testBbaGeo02Cl.getCdTiDocInde()).isEqualTo(DEFAULT_CD_TI_DOC_INDE);
        assertThat(testBbaGeo02Cl.getDbNmClasse()).isEqualTo(DEFAULT_DB_NM_CLASSE);
        assertThat(testBbaGeo02Cl.getIdEnte()).isEqualTo(DEFAULT_ID_ENTE);
    }

    @Test
    @Transactional
    public void createBbaGeo02ClWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = bbaGeo02ClRepository.findAll().size();

        // Create the BbaGeo02Cl with an existing ID
        bbaGeo02Cl.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBbaGeo02ClMockMvc.perform(post("/api/bba-geo-02-cls")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bbaGeo02Cl)))
            .andExpect(status().isBadRequest());

        // Validate the BbaGeo02Cl in the database
        List<BbaGeo02Cl> bbaGeo02ClList = bbaGeo02ClRepository.findAll();
        assertThat(bbaGeo02ClList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllBbaGeo02Cls() throws Exception {
        // Initialize the database
        bbaGeo02ClRepository.saveAndFlush(bbaGeo02Cl);

        // Get all the bbaGeo02ClList
        restBbaGeo02ClMockMvc.perform(get("/api/bba-geo-02-cls?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(bbaGeo02Cl.getId().intValue())))
            .andExpect(jsonPath("$.[*].dbClasse").value(hasItem(DEFAULT_DB_CLASSE.toString())))
            .andExpect(jsonPath("$.[*].idApl").value(hasItem(DEFAULT_ID_APL.toString())))
            .andExpect(jsonPath("$.[*].cdTiDocInde").value(hasItem(DEFAULT_CD_TI_DOC_INDE.toString())))
            .andExpect(jsonPath("$.[*].dbNmClasse").value(hasItem(DEFAULT_DB_NM_CLASSE.toString())))
            .andExpect(jsonPath("$.[*].idEnte").value(hasItem(DEFAULT_ID_ENTE.toString())));
    }
    

    @Test
    @Transactional
    public void getBbaGeo02Cl() throws Exception {
        // Initialize the database
        bbaGeo02ClRepository.saveAndFlush(bbaGeo02Cl);

        // Get the bbaGeo02Cl
        restBbaGeo02ClMockMvc.perform(get("/api/bba-geo-02-cls/{id}", bbaGeo02Cl.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(bbaGeo02Cl.getId().intValue()))
            .andExpect(jsonPath("$.dbClasse").value(DEFAULT_DB_CLASSE.toString()))
            .andExpect(jsonPath("$.idApl").value(DEFAULT_ID_APL.toString()))
            .andExpect(jsonPath("$.cdTiDocInde").value(DEFAULT_CD_TI_DOC_INDE.toString()))
            .andExpect(jsonPath("$.dbNmClasse").value(DEFAULT_DB_NM_CLASSE.toString()))
            .andExpect(jsonPath("$.idEnte").value(DEFAULT_ID_ENTE.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingBbaGeo02Cl() throws Exception {
        // Get the bbaGeo02Cl
        restBbaGeo02ClMockMvc.perform(get("/api/bba-geo-02-cls/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBbaGeo02Cl() throws Exception {
        // Initialize the database
        bbaGeo02ClService.save(bbaGeo02Cl);

        int databaseSizeBeforeUpdate = bbaGeo02ClRepository.findAll().size();

        // Update the bbaGeo02Cl
        BbaGeo02Cl updatedBbaGeo02Cl = bbaGeo02ClRepository.findById(bbaGeo02Cl.getId()).get();
        // Disconnect from session so that the updates on updatedBbaGeo02Cl are not directly saved in db
        em.detach(updatedBbaGeo02Cl);
        updatedBbaGeo02Cl
            .dbClasse(UPDATED_DB_CLASSE)
            .idApl(UPDATED_ID_APL)
            .cdTiDocInde(UPDATED_CD_TI_DOC_INDE)
            .dbNmClasse(UPDATED_DB_NM_CLASSE)
            .idEnte(UPDATED_ID_ENTE);

        restBbaGeo02ClMockMvc.perform(put("/api/bba-geo-02-cls")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedBbaGeo02Cl)))
            .andExpect(status().isOk());

        // Validate the BbaGeo02Cl in the database
        List<BbaGeo02Cl> bbaGeo02ClList = bbaGeo02ClRepository.findAll();
        assertThat(bbaGeo02ClList).hasSize(databaseSizeBeforeUpdate);
        BbaGeo02Cl testBbaGeo02Cl = bbaGeo02ClList.get(bbaGeo02ClList.size() - 1);
        assertThat(testBbaGeo02Cl.getDbClasse()).isEqualTo(UPDATED_DB_CLASSE);
        assertThat(testBbaGeo02Cl.getIdApl()).isEqualTo(UPDATED_ID_APL);
        assertThat(testBbaGeo02Cl.getCdTiDocInde()).isEqualTo(UPDATED_CD_TI_DOC_INDE);
        assertThat(testBbaGeo02Cl.getDbNmClasse()).isEqualTo(UPDATED_DB_NM_CLASSE);
        assertThat(testBbaGeo02Cl.getIdEnte()).isEqualTo(UPDATED_ID_ENTE);
    }

    @Test
    @Transactional
    public void updateNonExistingBbaGeo02Cl() throws Exception {
        int databaseSizeBeforeUpdate = bbaGeo02ClRepository.findAll().size();

        // Create the BbaGeo02Cl

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restBbaGeo02ClMockMvc.perform(put("/api/bba-geo-02-cls")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bbaGeo02Cl)))
            .andExpect(status().isBadRequest());

        // Validate the BbaGeo02Cl in the database
        List<BbaGeo02Cl> bbaGeo02ClList = bbaGeo02ClRepository.findAll();
        assertThat(bbaGeo02ClList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteBbaGeo02Cl() throws Exception {
        // Initialize the database
        bbaGeo02ClService.save(bbaGeo02Cl);

        int databaseSizeBeforeDelete = bbaGeo02ClRepository.findAll().size();

        // Get the bbaGeo02Cl
        restBbaGeo02ClMockMvc.perform(delete("/api/bba-geo-02-cls/{id}", bbaGeo02Cl.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<BbaGeo02Cl> bbaGeo02ClList = bbaGeo02ClRepository.findAll();
        assertThat(bbaGeo02ClList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BbaGeo02Cl.class);
        BbaGeo02Cl bbaGeo02Cl1 = new BbaGeo02Cl();
        bbaGeo02Cl1.setId(1L);
        BbaGeo02Cl bbaGeo02Cl2 = new BbaGeo02Cl();
        bbaGeo02Cl2.setId(bbaGeo02Cl1.getId());
        assertThat(bbaGeo02Cl1).isEqualTo(bbaGeo02Cl2);
        bbaGeo02Cl2.setId(2L);
        assertThat(bbaGeo02Cl1).isNotEqualTo(bbaGeo02Cl2);
        bbaGeo02Cl1.setId(null);
        assertThat(bbaGeo02Cl1).isNotEqualTo(bbaGeo02Cl2);
    }
}
