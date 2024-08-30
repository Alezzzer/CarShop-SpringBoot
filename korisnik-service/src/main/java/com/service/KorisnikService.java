package com.service;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.AzKorisnici;
import com.repository.KorisniciRepository;

@Service
public class KorisnikService {



    @Autowired KorisniciRepository korisniciRepository;

    public AzKorisnici registerUser(AzKorisnici korisnik) {
      
        return korisniciRepository.save(korisnik);
    }

    public AzKorisnici loginUser(String email, String lozinka) {
       
        return korisniciRepository.findByEmailAndLozinka(email, lozinka);
    }
    
}
