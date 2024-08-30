package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.AzKorisnici;

@Repository
public interface AzKorisniciRepository extends JpaRepository<AzKorisnici, Integer>{
	
}