package it.datamanagement.akropolis.contabilita.repository;

import it.datamanagement.akropolis.contabilita.domain.BbaGeo01;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the BbaGeo01 entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BbaGeo01Repository extends JpaRepository<BbaGeo01, Long> {

}
