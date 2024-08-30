package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.AzKorisnici;





@Repository
public interface KorisniciRepository extends JpaRepository<AzKorisnici, Integer> {
   
    AzKorisnici findByEmailAndLozinka(String email, String lozinka);
}
