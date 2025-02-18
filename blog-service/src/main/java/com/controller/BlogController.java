package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.AzKomentariDTO;
import com.dto.AzTemaDTO;
import com.dto.KomentarRequest;
import com.service.BlogService;

@RestController
@RequestMapping("/blog")
public class BlogController {
	
	@Autowired
	BlogService service;
	
	 @GetMapping("/teme")
	    public List<AzTemaDTO> getAllAzTema() {
	        return service.vratiTeme();
	    }
	 
	 @GetMapping("/svikomentari")
	    public List<AzKomentariDTO> getAllAzKomentari() {
	        return service.vratiKomentare();
	    }
	 
	 @GetMapping("/svikomentarinatemu/{temaId}")
	    public List<AzKomentariDTO> getAllAzKomentariNaTemu(@PathVariable int temaId) {
	        return service.vratiKomentareNaTemu(temaId);
	    }
	 
	 @GetMapping("/mojikomentari")
	    public List<AzKomentariDTO> getAllAzKomentariByMe(@CookieValue("Korisnik-Id") int korisnikId) {
	        return service.vratiMojeKomentare(korisnikId);
	    }
	 
	 
	 @PostMapping("/dodajkomentar")
	    public AzKomentariDTO addKomentar(@RequestBody KomentarRequest request, @CookieValue("Korisnik-Id") int korisnikId) {
	        return service.dodajKomentar(request,korisnikId);
	    }
	 
	 
}
