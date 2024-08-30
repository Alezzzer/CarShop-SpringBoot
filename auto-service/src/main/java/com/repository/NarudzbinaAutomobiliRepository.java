package com.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.AzNarudzbinaAutomobili;
import com.model.AzNarudzbinaAutomobiliPK;

@Repository
public interface NarudzbinaAutomobiliRepository extends JpaRepository<AzNarudzbinaAutomobili, AzNarudzbinaAutomobiliPK> {
   
}
