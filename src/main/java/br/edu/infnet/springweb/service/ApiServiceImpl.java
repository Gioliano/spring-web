package br.edu.infnet.springweb.service;

import br.edu.infnet.springweb.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    //URL_BASE = "https://rickandmortyapi.com/api"

    private static final String PERSONA_API = "https://rickandmortyapi.com/api/character";

    @Override
    public Persona getAllPersona() {
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Persona> response = restTemplate.exchange(PERSONA_API, HttpMethod.GET, entity, Persona.class);

        return response.getBody();
    }
}
