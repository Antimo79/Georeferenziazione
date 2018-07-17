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

    private static final String DEFAULT_ID_TI_UTZ = "AAAAAAAAAA";
    private static final String UPDATED_ID_TI_UTZ = "BBBBBBBBBB";

    private static final String DEFAULT_CDTI_UTZ = "AAAAAAAAAA";
    private static final String UPDATED_CDTI_UTZ = "BBBBBBBBBB";

    private static final String DEFAULT_DB_TI_UTZ = "AAAAAAAAAA";
    private static final String UPDATED_DB_TI_UTZ = "BBBBBBBBBB";

    private static final String DEFAULT_ID_BAS_11 = "AAAAAAAAAA";
    private static final String UPDATED_ID_BAS_11 = "BBBBBBBBBB";

    private static final String DEFAULT_CD_STRD = "AAAAAAAAAA";
    private static final String UPDATED_CD_STRD = "BBBBBBBBBB";

    private static final String DEFAULT_DB_POSTA = "AAAAAAAAAA";
    private static final String UPDATED_DB_POSTA = "BBBBBBBBBB";

    private static final String DEFAULT_DB_ALFAB = "AAAAAAAAAA";
    private static final String UPDATED_DB_ALFAB = "BBBBBBBBBB";

    private static final String DEFAULT_DB_PERC_INI = "AAAAAAAAAA";
    private static final String UPDATED_DB_PERC_INI = "BBBBBBBBBB";

    private static final String DEFAULT_DB_PERC_FINAL = "AAAAAAAAAA";
    private static final String UPDATED_DB_PERC_FINAL = "BBBBBBBBBB";

    private static final String DEFAULT_DT_CANC = "AAAAAAAAAA";
    private static final String UPDATED_DT_CANC = "BBBBBBBBBB";

    private static final Integer DEFAULT_NI_CIV = 1;
    private static final Integer UPDATED_NI_CIV = 2;

    private static final String DEFAULT_DB_LETTE_CIV = "AAAAAAAAAA";
    private static final String UPDATED_DB_LETTE_CIV = "BBBBBBBBBB";

    private static final String DEFAULT_TI_COLORE_CIV = "AAAAAAAAAA";
    private static final String UPDATED_TI_COLORE_CIV = "BBBBBBBBBB";

    private static final String DEFAULT_CD_UNI_URB = "AAAAAAAAAA";
    private static final String UPDATED_CD_UNI_URB = "BBBBBBBBBB";

    private static final String DEFAULT_DB_UNI_URB = "AAAAAAAAAA";
    private static final String UPDATED_DB_UNI_URB = "BBBBBBBBBB";

    private static final String DEFAULT_CD_CIRCS = "AAAAAAAAAA";
    private static final String UPDATED_CD_CIRCS = "BBBBBBBBBB";

    private static final String DEFAULT_DB_CIRCS = "AAAAAAAAAA";
    private static final String UPDATED_DB_CIRCS = "BBBBBBBBBB";

    private static final String DEFAULT_CD_CAP = "AAAAAAAAAA";
    private static final String UPDATED_CD_CAP = "BBBBBBBBBB";

    private static final String DEFAULT_CD_SEZ_VIG = "AAAAAAAAAA";
    private static final String UPDATED_CD_SEZ_VIG = "BBBBBBBBBB";

    private static final String DEFAULT_DB_SEZ_VIG = "AAAAAAAAAA";
    private static final String UPDATED_DB_SEZ_VIG = "BBBBBBBBBB";

    private static final Integer DEFAULT_NI_INTERNO = 1;
    private static final Integer UPDATED_NI_INTERNO = 2;

    private static final String DEFAULT_DB_LETTE_INTERNO = "AAAAAAAAAA";
    private static final String UPDATED_DB_LETTE_INTERNO = "BBBBBBBBBB";

    private static final String DEFAULT_DB_INTERNO_SCALA = "AAAAAAAAAA";
    private static final String UPDATED_DB_INTERNO_SCALA = "BBBBBBBBBB";

    private static final String DEFAULT_FL_ALLIN = "AAAAAAAAAA";
    private static final String UPDATED_FL_ALLIN = "BBBBBBBBBB";

    private static final String DEFAULT_ID_ENTE = "AAAAAAAAAA";
    private static final String UPDATED_ID_ENTE = "BBBBBBBBBB";

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
            .dbCdUtz(DEFAULT_DB_CD_UTZ)
            .idTiUtz(DEFAULT_ID_TI_UTZ)
            .cdtiUtz(DEFAULT_CDTI_UTZ)
            .dbTiUtz(DEFAULT_DB_TI_UTZ)
            .idBas11(DEFAULT_ID_BAS_11)
            .cdStrd(DEFAULT_CD_STRD)
            .dbPosta(DEFAULT_DB_POSTA)
            .dbAlfab(DEFAULT_DB_ALFAB)
            .dbPercIni(DEFAULT_DB_PERC_INI)
            .dbPercFinal(DEFAULT_DB_PERC_FINAL)
            .dtCanc(DEFAULT_DT_CANC)
            .niCiv(DEFAULT_NI_CIV)
            .dbLetteCiv(DEFAULT_DB_LETTE_CIV)
            .tiColoreCiv(DEFAULT_TI_COLORE_CIV)
            .cdUniUrb(DEFAULT_CD_UNI_URB)
            .dbUniUrb(DEFAULT_DB_UNI_URB)
            .cdCircs(DEFAULT_CD_CIRCS)
            .dbCircs(DEFAULT_DB_CIRCS)
            .cdCap(DEFAULT_CD_CAP)
            .cdSezVig(DEFAULT_CD_SEZ_VIG)
            .dbSezVig(DEFAULT_DB_SEZ_VIG)
            .niInterno(DEFAULT_NI_INTERNO)
            .dbLetteInterno(DEFAULT_DB_LETTE_INTERNO)
            .dbInternoScala(DEFAULT_DB_INTERNO_SCALA)
            .flAllin(DEFAULT_FL_ALLIN)
            .idEnte(DEFAULT_ID_ENTE);
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
        assertThat(testCutcUtzUbic.getIdTiUtz()).isEqualTo(DEFAULT_ID_TI_UTZ);
        assertThat(testCutcUtzUbic.getCdtiUtz()).isEqualTo(DEFAULT_CDTI_UTZ);
        assertThat(testCutcUtzUbic.getDbTiUtz()).isEqualTo(DEFAULT_DB_TI_UTZ);
        assertThat(testCutcUtzUbic.getIdBas11()).isEqualTo(DEFAULT_ID_BAS_11);
        assertThat(testCutcUtzUbic.getCdStrd()).isEqualTo(DEFAULT_CD_STRD);
        assertThat(testCutcUtzUbic.getDbPosta()).isEqualTo(DEFAULT_DB_POSTA);
        assertThat(testCutcUtzUbic.getDbAlfab()).isEqualTo(DEFAULT_DB_ALFAB);
        assertThat(testCutcUtzUbic.getDbPercIni()).isEqualTo(DEFAULT_DB_PERC_INI);
        assertThat(testCutcUtzUbic.getDbPercFinal()).isEqualTo(DEFAULT_DB_PERC_FINAL);
        assertThat(testCutcUtzUbic.getDtCanc()).isEqualTo(DEFAULT_DT_CANC);
        assertThat(testCutcUtzUbic.getNiCiv()).isEqualTo(DEFAULT_NI_CIV);
        assertThat(testCutcUtzUbic.getDbLetteCiv()).isEqualTo(DEFAULT_DB_LETTE_CIV);
        assertThat(testCutcUtzUbic.getTiColoreCiv()).isEqualTo(DEFAULT_TI_COLORE_CIV);
        assertThat(testCutcUtzUbic.getCdUniUrb()).isEqualTo(DEFAULT_CD_UNI_URB);
        assertThat(testCutcUtzUbic.getDbUniUrb()).isEqualTo(DEFAULT_DB_UNI_URB);
        assertThat(testCutcUtzUbic.getCdCircs()).isEqualTo(DEFAULT_CD_CIRCS);
        assertThat(testCutcUtzUbic.getDbCircs()).isEqualTo(DEFAULT_DB_CIRCS);
        assertThat(testCutcUtzUbic.getCdCap()).isEqualTo(DEFAULT_CD_CAP);
        assertThat(testCutcUtzUbic.getCdSezVig()).isEqualTo(DEFAULT_CD_SEZ_VIG);
        assertThat(testCutcUtzUbic.getDbSezVig()).isEqualTo(DEFAULT_DB_SEZ_VIG);
        assertThat(testCutcUtzUbic.getNiInterno()).isEqualTo(DEFAULT_NI_INTERNO);
        assertThat(testCutcUtzUbic.getDbLetteInterno()).isEqualTo(DEFAULT_DB_LETTE_INTERNO);
        assertThat(testCutcUtzUbic.getDbInternoScala()).isEqualTo(DEFAULT_DB_INTERNO_SCALA);
        assertThat(testCutcUtzUbic.getFlAllin()).isEqualTo(DEFAULT_FL_ALLIN);
        assertThat(testCutcUtzUbic.getIdEnte()).isEqualTo(DEFAULT_ID_ENTE);
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
            .andExpect(jsonPath("$.[*].dbCdUtz").value(hasItem(DEFAULT_DB_CD_UTZ.toString())))
            .andExpect(jsonPath("$.[*].idTiUtz").value(hasItem(DEFAULT_ID_TI_UTZ.toString())))
            .andExpect(jsonPath("$.[*].cdtiUtz").value(hasItem(DEFAULT_CDTI_UTZ.toString())))
            .andExpect(jsonPath("$.[*].dbTiUtz").value(hasItem(DEFAULT_DB_TI_UTZ.toString())))
            .andExpect(jsonPath("$.[*].idBas11").value(hasItem(DEFAULT_ID_BAS_11.toString())))
            .andExpect(jsonPath("$.[*].cdStrd").value(hasItem(DEFAULT_CD_STRD.toString())))
            .andExpect(jsonPath("$.[*].dbPosta").value(hasItem(DEFAULT_DB_POSTA.toString())))
            .andExpect(jsonPath("$.[*].dbAlfab").value(hasItem(DEFAULT_DB_ALFAB.toString())))
            .andExpect(jsonPath("$.[*].dbPercIni").value(hasItem(DEFAULT_DB_PERC_INI.toString())))
            .andExpect(jsonPath("$.[*].dbPercFinal").value(hasItem(DEFAULT_DB_PERC_FINAL.toString())))
            .andExpect(jsonPath("$.[*].dtCanc").value(hasItem(DEFAULT_DT_CANC.toString())))
            .andExpect(jsonPath("$.[*].niCiv").value(hasItem(DEFAULT_NI_CIV)))
            .andExpect(jsonPath("$.[*].dbLetteCiv").value(hasItem(DEFAULT_DB_LETTE_CIV.toString())))
            .andExpect(jsonPath("$.[*].tiColoreCiv").value(hasItem(DEFAULT_TI_COLORE_CIV.toString())))
            .andExpect(jsonPath("$.[*].cdUniUrb").value(hasItem(DEFAULT_CD_UNI_URB.toString())))
            .andExpect(jsonPath("$.[*].dbUniUrb").value(hasItem(DEFAULT_DB_UNI_URB.toString())))
            .andExpect(jsonPath("$.[*].cdCircs").value(hasItem(DEFAULT_CD_CIRCS.toString())))
            .andExpect(jsonPath("$.[*].dbCircs").value(hasItem(DEFAULT_DB_CIRCS.toString())))
            .andExpect(jsonPath("$.[*].cdCap").value(hasItem(DEFAULT_CD_CAP.toString())))
            .andExpect(jsonPath("$.[*].cdSezVig").value(hasItem(DEFAULT_CD_SEZ_VIG.toString())))
            .andExpect(jsonPath("$.[*].dbSezVig").value(hasItem(DEFAULT_DB_SEZ_VIG.toString())))
            .andExpect(jsonPath("$.[*].niInterno").value(hasItem(DEFAULT_NI_INTERNO)))
            .andExpect(jsonPath("$.[*].dbLetteInterno").value(hasItem(DEFAULT_DB_LETTE_INTERNO.toString())))
            .andExpect(jsonPath("$.[*].dbInternoScala").value(hasItem(DEFAULT_DB_INTERNO_SCALA.toString())))
            .andExpect(jsonPath("$.[*].flAllin").value(hasItem(DEFAULT_FL_ALLIN.toString())))
            .andExpect(jsonPath("$.[*].idEnte").value(hasItem(DEFAULT_ID_ENTE.toString())));
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
            .andExpect(jsonPath("$.dbCdUtz").value(DEFAULT_DB_CD_UTZ.toString()))
            .andExpect(jsonPath("$.idTiUtz").value(DEFAULT_ID_TI_UTZ.toString()))
            .andExpect(jsonPath("$.cdtiUtz").value(DEFAULT_CDTI_UTZ.toString()))
            .andExpect(jsonPath("$.dbTiUtz").value(DEFAULT_DB_TI_UTZ.toString()))
            .andExpect(jsonPath("$.idBas11").value(DEFAULT_ID_BAS_11.toString()))
            .andExpect(jsonPath("$.cdStrd").value(DEFAULT_CD_STRD.toString()))
            .andExpect(jsonPath("$.dbPosta").value(DEFAULT_DB_POSTA.toString()))
            .andExpect(jsonPath("$.dbAlfab").value(DEFAULT_DB_ALFAB.toString()))
            .andExpect(jsonPath("$.dbPercIni").value(DEFAULT_DB_PERC_INI.toString()))
            .andExpect(jsonPath("$.dbPercFinal").value(DEFAULT_DB_PERC_FINAL.toString()))
            .andExpect(jsonPath("$.dtCanc").value(DEFAULT_DT_CANC.toString()))
            .andExpect(jsonPath("$.niCiv").value(DEFAULT_NI_CIV))
            .andExpect(jsonPath("$.dbLetteCiv").value(DEFAULT_DB_LETTE_CIV.toString()))
            .andExpect(jsonPath("$.tiColoreCiv").value(DEFAULT_TI_COLORE_CIV.toString()))
            .andExpect(jsonPath("$.cdUniUrb").value(DEFAULT_CD_UNI_URB.toString()))
            .andExpect(jsonPath("$.dbUniUrb").value(DEFAULT_DB_UNI_URB.toString()))
            .andExpect(jsonPath("$.cdCircs").value(DEFAULT_CD_CIRCS.toString()))
            .andExpect(jsonPath("$.dbCircs").value(DEFAULT_DB_CIRCS.toString()))
            .andExpect(jsonPath("$.cdCap").value(DEFAULT_CD_CAP.toString()))
            .andExpect(jsonPath("$.cdSezVig").value(DEFAULT_CD_SEZ_VIG.toString()))
            .andExpect(jsonPath("$.dbSezVig").value(DEFAULT_DB_SEZ_VIG.toString()))
            .andExpect(jsonPath("$.niInterno").value(DEFAULT_NI_INTERNO))
            .andExpect(jsonPath("$.dbLetteInterno").value(DEFAULT_DB_LETTE_INTERNO.toString()))
            .andExpect(jsonPath("$.dbInternoScala").value(DEFAULT_DB_INTERNO_SCALA.toString()))
            .andExpect(jsonPath("$.flAllin").value(DEFAULT_FL_ALLIN.toString()))
            .andExpect(jsonPath("$.idEnte").value(DEFAULT_ID_ENTE.toString()));
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
            .dbCdUtz(UPDATED_DB_CD_UTZ)
            .idTiUtz(UPDATED_ID_TI_UTZ)
            .cdtiUtz(UPDATED_CDTI_UTZ)
            .dbTiUtz(UPDATED_DB_TI_UTZ)
            .idBas11(UPDATED_ID_BAS_11)
            .cdStrd(UPDATED_CD_STRD)
            .dbPosta(UPDATED_DB_POSTA)
            .dbAlfab(UPDATED_DB_ALFAB)
            .dbPercIni(UPDATED_DB_PERC_INI)
            .dbPercFinal(UPDATED_DB_PERC_FINAL)
            .dtCanc(UPDATED_DT_CANC)
            .niCiv(UPDATED_NI_CIV)
            .dbLetteCiv(UPDATED_DB_LETTE_CIV)
            .tiColoreCiv(UPDATED_TI_COLORE_CIV)
            .cdUniUrb(UPDATED_CD_UNI_URB)
            .dbUniUrb(UPDATED_DB_UNI_URB)
            .cdCircs(UPDATED_CD_CIRCS)
            .dbCircs(UPDATED_DB_CIRCS)
            .cdCap(UPDATED_CD_CAP)
            .cdSezVig(UPDATED_CD_SEZ_VIG)
            .dbSezVig(UPDATED_DB_SEZ_VIG)
            .niInterno(UPDATED_NI_INTERNO)
            .dbLetteInterno(UPDATED_DB_LETTE_INTERNO)
            .dbInternoScala(UPDATED_DB_INTERNO_SCALA)
            .flAllin(UPDATED_FL_ALLIN)
            .idEnte(UPDATED_ID_ENTE);

        restCutcUtzUbicMockMvc.perform(put("/api/cutc-utz-ubics")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedCutcUtzUbic)))
            .andExpect(status().isOk());

        // Validate the CutcUtzUbic in the database
        List<CutcUtzUbic> cutcUtzUbicList = cutcUtzUbicRepository.findAll();
        assertThat(cutcUtzUbicList).hasSize(databaseSizeBeforeUpdate);
        CutcUtzUbic testCutcUtzUbic = cutcUtzUbicList.get(cutcUtzUbicList.size() - 1);
        assertThat(testCutcUtzUbic.getDbCdUtz()).isEqualTo(UPDATED_DB_CD_UTZ);
        assertThat(testCutcUtzUbic.getIdTiUtz()).isEqualTo(UPDATED_ID_TI_UTZ);
        assertThat(testCutcUtzUbic.getCdtiUtz()).isEqualTo(UPDATED_CDTI_UTZ);
        assertThat(testCutcUtzUbic.getDbTiUtz()).isEqualTo(UPDATED_DB_TI_UTZ);
        assertThat(testCutcUtzUbic.getIdBas11()).isEqualTo(UPDATED_ID_BAS_11);
        assertThat(testCutcUtzUbic.getCdStrd()).isEqualTo(UPDATED_CD_STRD);
        assertThat(testCutcUtzUbic.getDbPosta()).isEqualTo(UPDATED_DB_POSTA);
        assertThat(testCutcUtzUbic.getDbAlfab()).isEqualTo(UPDATED_DB_ALFAB);
        assertThat(testCutcUtzUbic.getDbPercIni()).isEqualTo(UPDATED_DB_PERC_INI);
        assertThat(testCutcUtzUbic.getDbPercFinal()).isEqualTo(UPDATED_DB_PERC_FINAL);
        assertThat(testCutcUtzUbic.getDtCanc()).isEqualTo(UPDATED_DT_CANC);
        assertThat(testCutcUtzUbic.getNiCiv()).isEqualTo(UPDATED_NI_CIV);
        assertThat(testCutcUtzUbic.getDbLetteCiv()).isEqualTo(UPDATED_DB_LETTE_CIV);
        assertThat(testCutcUtzUbic.getTiColoreCiv()).isEqualTo(UPDATED_TI_COLORE_CIV);
        assertThat(testCutcUtzUbic.getCdUniUrb()).isEqualTo(UPDATED_CD_UNI_URB);
        assertThat(testCutcUtzUbic.getDbUniUrb()).isEqualTo(UPDATED_DB_UNI_URB);
        assertThat(testCutcUtzUbic.getCdCircs()).isEqualTo(UPDATED_CD_CIRCS);
        assertThat(testCutcUtzUbic.getDbCircs()).isEqualTo(UPDATED_DB_CIRCS);
        assertThat(testCutcUtzUbic.getCdCap()).isEqualTo(UPDATED_CD_CAP);
        assertThat(testCutcUtzUbic.getCdSezVig()).isEqualTo(UPDATED_CD_SEZ_VIG);
        assertThat(testCutcUtzUbic.getDbSezVig()).isEqualTo(UPDATED_DB_SEZ_VIG);
        assertThat(testCutcUtzUbic.getNiInterno()).isEqualTo(UPDATED_NI_INTERNO);
        assertThat(testCutcUtzUbic.getDbLetteInterno()).isEqualTo(UPDATED_DB_LETTE_INTERNO);
        assertThat(testCutcUtzUbic.getDbInternoScala()).isEqualTo(UPDATED_DB_INTERNO_SCALA);
        assertThat(testCutcUtzUbic.getFlAllin()).isEqualTo(UPDATED_FL_ALLIN);
        assertThat(testCutcUtzUbic.getIdEnte()).isEqualTo(UPDATED_ID_ENTE);
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
