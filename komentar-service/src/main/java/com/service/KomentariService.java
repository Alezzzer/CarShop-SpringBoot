package com.service;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.KomentarRequest;
import com.model.AzKomentari;
import com.model.AzKorisnici;
import com.model.AzTema;
import com.repository.AzKomentariRepository;
import com.repository.AzKorisniciRepository;
import com.repository.AzTemaRepository;

@Service
public class KomentariService {

    @Autowired
    private AzTemaRepository azTemaRepository;

    @Autowired
    private AzKomentariRepository azKomentariRepository;
    
    @Autowired
    private AzKorisniciRepository azKorisniciRepository;

    public List<AzTema> getAllAzTema() {
        return azTemaRepository.findAll();
    }

    public List<AzKomentari> getAllAzKomentari() {
        return azKomentariRepository.findAll();
    }

    public List<AzKomentari> getAzKomentariByTemaId(int temaId) {
        return azKomentariRepository.findByAzTema_TemaId(temaId);
    }
    
    public List<AzKomentari>getAzKomentarById(int korisnikId){
    	return azKomentariRepository.findByAzKorisnici_KorisnikId(korisnikId);
    }

    public AzKomentari addNewKomentar(KomentarRequest request, int korisnikId) {
        
        AzTema tema = azTemaRepository.findById(request.getTemaId())
                        .orElseThrow(() -> new RuntimeException("Tema nije pronadjena"));
        
       
        AzKorisnici korisnik = azKorisniciRepository.findById(korisnikId)
                        .orElseThrow(() -> new RuntimeException("Korisnik nije pronadjen"));

        
        AzKomentari komentar = new AzKomentari();
        komentar.setTekst(request.getTekst());
        komentar.setDatum(new Date());
        komentar.setAzKorisnici(korisnik);  
        komentar.setAzTema(tema);           

        
        return azKomentariRepository.save(komentar);
    }
}
