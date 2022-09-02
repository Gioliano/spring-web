package br.edu.infnet.springweb.controller;

import br.edu.infnet.springweb.entity.Persona;
import br.edu.infnet.springweb.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/")
    public ResponseEntity<Persona> getPersonas() {
        Persona persona = apiService.getAllPersona();
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

}
