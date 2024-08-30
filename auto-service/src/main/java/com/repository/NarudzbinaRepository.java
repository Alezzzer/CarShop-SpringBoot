package com.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.AzNarudzbina;

@Repository
public interface NarudzbinaRepository extends JpaRepository<AzNarudzbina, Integer> {
    List<AzNarudzbina> findByAzKorisnici_KorisnikId(int korisnikId);

}
