package com.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.LoginRequestDTO;
import com.model.AzKorisnici;
import com.service.KorisnikService;

@RestController
@RequestMapping("/korisnici")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody AzKorisnici korisnik) {
        korisnikService.registerUser(korisnik);
        return ResponseEntity.ok("Korisnik je uspesno registrovan!");
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        AzKorisnici korisnik = korisnikService.loginUser(loginRequest.getEmail(), loginRequest.getLozinka());
        if (korisnik != null) {
            ResponseCookie cookie = ResponseCookie.from("Korisnik-Id", String.valueOf(korisnik.getKorisnikId()))
                                                   .path("/")
                                                   .httpOnly(true)
                                                   .build();
            return ResponseEntity.ok()
                                 .header(HttpHeaders.SET_COOKIE, cookie.toString())
                                 .body("Korisnik je uspesno ulogovan");
        } else {
            return new ResponseEntity<>("Korisnik nije uspesno ulogovan", HttpStatus.UNAUTHORIZED);
        }
    }


}
