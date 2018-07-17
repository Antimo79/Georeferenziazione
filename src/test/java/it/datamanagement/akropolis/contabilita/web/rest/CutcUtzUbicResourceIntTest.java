package it.datamanagement.akropolis.contabilita.web.rest;

import it.datamanagement.akropolis.contabilita.GeoreferenziazioneApp;

import it.datamanagement.akropolis.contabilita.domain.CutcUtzUbic;
import it.datamanagement.akropolis.contabilita.repository.CutcUtzUbicRepository;
import it.datamanagement.akropolis.contabilita.service.CutcUtzUbicService;
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
 * Test class for the CutcUtzUbicResource REST controller.
 *
 * @see CutcUtzUbicResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GeoreferenziazioneApp.class)
public class CutcUtzUbicResourceIntTest {

    private static final String DEFAULT_DB_CD_UTZ = "AAAAAAAAAA";
    private static final String UPDATED_DB_CD_UTZ = "BBBBBBBBBB";

    @Autowired
    private CutcUtzUbicRepository cutcUtzUbicRepository;

    

    @Autowired
    private CutcUtzUbicService cutcUtzUbicService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restCutcUtzUbicMockMvc;

    private CutcUtzUbic cutcUtzUbic;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final CutcUtzUbicResource cutcUtzUbicResource = new CutcUtzUbicResource(cutcUtzUbicService);
        this.restCutcUtzUbicMockMvc = MockMvcBuilders.standaloneSetup(cutcUtzUbicResource)
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
    public static CutcUtzUbic createEntity(EntityManager em) {
        CutcUtzUbic cutcUtzUbic = new CutcUtzUbic()
            .dbCdUtz(DEFAULT_DB_CD_UTZ);
        return cutcUtzUbic;
    }

    @Before
    public void initTest() {
        cutcUtzUbic = createEntity(em);
    }

    @Test
    @Transactional
    public void createCutcUtzUbic() throws Exception {
        int databaseSizeBeforeCreate = cutcUtzUbicRepository.findAll().size();

        // Create the CutcUtzUbic
        restCutcUtzUbicMockMvc.perform(post("/api/cutc-utz-ubics")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cutcUtzUbic)))
            .andExpect(status().isCreated());

        // Validate the CutcUtzUbic in the database
        List<CutcUtzUbic> cutcUtzUbicList = cutcUtzUbicRepository.findAll();
        assertThat(cutcUtzUbicList).hasSize(databaseSizeBeforeCreate + 1);
        CutcUtzUbic testCutcUtzUbic = cutcUtzUbicList.get(cutcUtzUbicList.size() - 1);
        assertThat(testCutcUtzUbic.getDbCdUtz()).isEqualTo(DEFAULT_DB_CD_UTZ);
    }

    @Test
    @Transactional
    public void createCutcUtzUbicWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = cutcUtzUbicRepository.findAll().size();

        // Create the CutcUtzUbic with an existing ID
        cutcUtzUbic.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCutcUtzUbicMockMvc.perform(post("/api/cutc-utz-ubics")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cutcUtzUbic)))
            .andExpect(status().isBadRequest());

        // Validate the CutcUtzUbic in the database
        List<CutcUtzUbic> cutcUtzUbicList = cutcUtzUbicRepository.findAll();
        assertThat(cutcUtzUbicList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllCutcUtzUbics() throws Exception {
        // Initialize the database
        cutcUtzUbicRepository.saveAndFlush(cutcUtzUbic);

        // Get all the cutcUtzUbicList
        restCutcUtzUbicMockMvc.perform(get("/api/cutc-utz-ubics?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(cutcUtzUbic.getId().intValue())))
            .andExpect(jsonPath("$.[*].dbCdUtz").value(hasItem(DEFAULT_DB_CD_UTZ.toString())));
    }
    

    @Test
    @Transactional
    public void getCutcUtzUbic() throws Exception {
        // Initialize the database
        cutcUtzUbicRepository.saveAndFlush(cutcUtzUbic);

        // Get the cutcUtzUbic
        restCutcUtzUbicMockMvc.perform(get("/api/cutc-utz-ubics/{id}", cutcUtzUbic.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(cutcUtzUbic.getId().intValue()))
            .andExpect(jsonPath("$.dbCdUtz").value(DEFAULT_DB_CD_UTZ.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingCutcUtzUbic() throws Exception {
        // Get the cutcUtzUbic
        restCutcUtzUbicMockMvc.perform(get("/api/cutc-utz-ubics/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCutcUtzUbic() throws Exception {
        // Initialize the database
        cutcUtzUbicService.save(cutcUtzUbic);

        int databaseSizeBeforeUpdate = cutcUtzUbicRepository.findAll().size();

        // Update the cutcUtzUbic
        CutcUtzUbic updatedCutcUtzUbic = cutcUtzUbicRepository.findById(cutcUtzUbic.getId()).get();
        // Disconnect from session so that the updates on updatedCutcUtzUbic are not directly saved in db
        em.detach(updatedCutcUtzUbic);
        updatedCutcUtzUbic
            .dbCdUtz(UPDATED_DB_CD_UTZ);

        restCutcUtzUbicMockMvc.perform(put("/api/cutc-utz-ubics")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedCutcUtzUbic)))
            .andExpect(status().isOk());

        // Validate the CutcUtzUbic in the database
        List<CutcUtzUbic> cutcUtzUbicList = cutcUtzUbicRepository.findAll();
        assertThat(cutcUtzUbicList).hasSize(databaseSizeBeforeUpdate);
        CutcUtzUbic testCutcUtzUbic = cutcUtzUbicList.get(cutcUtzUbicList.size() - 1);
        assertThat(testCutcUtzUbic.getDbCdUtz()).isEqualTo(UPDATED_DB_CD_UTZ);
    }

    @Test
    @Transactional
    public void updateNonExistingCutcUtzUbic() throws Exception {
        int databaseSizeBeforeUpdate = cutcUtzUbicRepository.findAll().size();

        // Create the CutcUtzUbic

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restCutcUtzUbicMockMvc.perform(put("/api/cutc-utz-ubics")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cutcUtzUbic)))
            .andExpect(status().isBadRequest());

        // Validate the CutcUtzUbic in the database
        List<CutcUtzUbic> cutcUtzUbicList = cutcUtzUbicRepository.findAll();
        assertThat(cutcUtzUbicList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCutcUtzUbic() throws Exception {
        // Initialize the database
        cutcUtzUbicService.save(cutcUtzUbic);

        int databaseSizeBeforeDelete = cutcUtzUbicRepository.findAll().size();

        // Get the cutcUtzUbic
        restCutcUtzUbicMockMvc.perform(delete("/api/cutc-utz-ubics/{id}", cutcUtzUbic.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<CutcUtzUbic> cutcUtzUbicList = cutcUtzUbicRepository.findAll();
        assertThat(cutcUtzUbicList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CutcUtzUbic.class);
        CutcUtzUbic cutcUtzUbic1 = new CutcUtzUbic();
        cutcUtzUbic1.setId(1L);
        CutcUtzUbic cutcUtzUbic2 = new CutcUtzUbic();
        cutcUtzUbic2.setId(cutcUtzUbic1.getId());
        assertThat(cutcUtzUbic1).isEqualTo(cutcUtzUbic2);
        cutcUtzUbic2.setId(2L);
        assertThat(cutcUtzUbic1).isNotEqualTo(cutcUtzUbic2);
        cutcUtzUbic1.setId(null);
        assertThat(cutcUtzUbic1).isNotEqualTo(cutcUtzUbic2);
    }
}
