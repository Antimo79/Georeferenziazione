package it.datamanagement.akropolis.contabilita.repository;

import it.datamanagement.akropolis.contabilita.domain.CutcUtzUbic;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the CutcUtzUbic entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CutcUtzUbicRepository extends JpaRepository<CutcUtzUbic, Long> {

}
