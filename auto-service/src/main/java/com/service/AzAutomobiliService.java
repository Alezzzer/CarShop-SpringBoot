package com.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.AzAutomobili;
import com.model.AzKorisnici;
import com.model.AzNarudzbina;
import com.model.AzNarudzbinaAutomobili;
import com.model.AzNarudzbinaAutomobiliPK;
import com.model.AzPlacanja;
import com.repository.AzAutomobiliRepository;
import com.repository.AzPlacanjaRepository;
import com.repository.NarudzbinaAutomobiliRepository;
import com.repository.NarudzbinaRepository;

@Service
public class AzAutomobiliService {

    @Autowired
    private AzPlacanjaRepository placanjaRepository;
    

    @Autowired
    private AzAutomobiliRepository azAutomobiliRepository;

    @Autowired
    private NarudzbinaRepository narudzbinaRepository;

    @Autowired
    private NarudzbinaAutomobiliRepository narudzbinaAutomobiliRepository;

    public AzAutomobiliService(AzAutomobiliRepository azAutomobiliRepository) {
        this.azAutomobiliRepository = azAutomobiliRepository;
    }

    public List<AzAutomobili> findAll() {
        return azAutomobiliRepository.findAll();
    }
    public List<AzAutomobili> findByTipAutomobila(String nazivTipa) {
        return azAutomobiliRepository.findByAzTipAutomobila_NazivTipa(nazivTipa);
    }
    public List<AzAutomobili> getAutomobiliByKilometrazaLessThan(int kilometraza) {
        List<AzAutomobili> automobili = azAutomobiliRepository.findByKilometrazaLessThanEqual(kilometraza);
        return automobili;
    }

    public List<AzAutomobili> getAutomobiliByCenaLessThan(int cena) {
        List<AzAutomobili> automobili = azAutomobiliRepository.findByCenaLessThanEqual(cena);
        return automobili;
    }

    public List<AzAutomobili> getAutomobiliByCenaGreaterThan(int cena) {
        List<AzAutomobili> automobili = azAutomobiliRepository.findByCenaGreaterThanEqual(cena);
        return automobili;
    }

    public List<AzAutomobili> getAutomobiliByKilometrazaGreaterThan(int kilometraza) {
        List<AzAutomobili> automobili = azAutomobiliRepository.findByKilometrazaGreaterThanEqual(kilometraza);
        return automobili;
    }

    public List<AzAutomobili> getAutomobiliByMarka(String marka) {
        List<AzAutomobili> automobili = azAutomobiliRepository.findByMarka(marka);
        return automobili;
    }
    
    public List<AzAutomobili> getAutomobiliByGodineGreaterThan(int godina){
    	List<AzAutomobili>automobili=azAutomobiliRepository.findByGodinaProizvodnjeGreaterThanEqual(godina);
    	return automobili;
    }
    
    public List<AzAutomobili> getAutomobiliByGodineLessThan(int godina){
    	List<AzAutomobili>automobili=azAutomobiliRepository.findByGodinaProizvodnjeLessThanEqual(godina);
    	return automobili;
    }
    
    public void poveziKorisnikaSaAutomobilom(int korisnikId, int automobilId) {
        Optional<AzAutomobili> automobilOptional = azAutomobiliRepository.findById(automobilId);

        if (automobilOptional.isPresent()) {
            AzAutomobili automobil = automobilOptional.get();

            
            AzNarudzbina narudzbina = new AzNarudzbina();
            narudzbina.setDatumNarudzbe(new Date());
            narudzbina.setStatus("NA ČEKANJU");
            narudzbina.setUkupnaCena(automobil.getCena());
            AzKorisnici korisnik = new AzKorisnici();
            korisnik.setKorisnikId(korisnikId);
            narudzbina.setAzKorisnici(korisnik);

           
            narudzbinaRepository.save(narudzbina);

            
            AzNarudzbinaAutomobiliPK narudzbinaAutomobiliPK = new AzNarudzbinaAutomobiliPK();
            narudzbinaAutomobiliPK.setNarudzbaId(narudzbina.getNarudzbaId());
            narudzbinaAutomobiliPK.setAutomobilId(automobil.getAutomobilId());

           
            AzNarudzbinaAutomobili narudzbinaAutomobili = new AzNarudzbinaAutomobili();
            narudzbinaAutomobili.setId(narudzbinaAutomobiliPK);
            narudzbinaAutomobili.setAzAutomobili(automobil);
            narudzbinaAutomobili.setAzNarudzbina(narudzbina);
            narudzbinaAutomobili.setKolicina(1);

            
            narudzbinaAutomobiliRepository.save(narudzbinaAutomobili);
        } else {
            throw new RuntimeException("Automobil sa ID " + automobilId + " nije pronađen.");
        }
    }
    
    public List<AzNarudzbina> findNarudzbineByKorisnikId(int korisnikId) {
        return narudzbinaRepository.findByAzKorisnici_KorisnikId(korisnikId);
    }

    
    public AzPlacanja createPlacanje(int narudzbaId, String nacinPlacanja) {
    	 AzNarudzbina narudzbina = narudzbinaRepository.findById(narudzbaId)
                 .orElseThrow(() -> new IllegalArgumentException("Narudzbina sa ID " + narudzbaId + " nije pronađena."));

         
         int iznos = narudzbina.getUkupnaCena();

         narudzbina.setStatus("PLACENO");
         AzPlacanja placanje = new AzPlacanja();
         placanje.setDatumPlacanja(new Date());
         placanje.setNacinPlacanja(nacinPlacanja);
         placanje.setIznos(iznos);
         placanje.setAzNarudzbina(narudzbina);

        return placanjaRepository.save(placanje);
    }
}
