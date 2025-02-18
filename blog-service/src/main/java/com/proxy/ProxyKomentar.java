package com.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dto.AzKomentariDTO;
import com.dto.AzTemaDTO;
import com.dto.KomentarRequest;




@FeignClient(name="komentar-service",url="localhost:8007")
public interface ProxyKomentar {

	 @GetMapping("/komentari/teme")
	    public List<AzTemaDTO> getAllAzTema();
	  
	 @GetMapping("/komentari/svikomentari")
	    public List<AzKomentariDTO> getAllAzKomentari();
	    
	    @GetMapping("/komentari/svikomentarinatemu/{temaId}")
	    public List<AzKomentariDTO> getAzKomentariByTemaId(@PathVariable int temaId);
	    
	    @GetMapping("/komentari/mojikomentari")
	    public List<AzKomentariDTO> getAzKomentarById(@CookieValue("Korisnik-Id") int korisnikId);
	    
	    @PostMapping("/komentari/dodajkomentar")
	    public AzKomentariDTO addNewKomentar(@RequestBody KomentarRequest request, @CookieValue("Korisnik-Id") int korisnikId);
	    
	
}
