package it.datamanagement.akropolis.contabilita.repository;

import it.datamanagement.akropolis.contabilita.domain.BbbaGeo01;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the BbbaGeo01 entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BbbaGeo01Repository extends JpaRepository<BbbaGeo01, Long> {

}
