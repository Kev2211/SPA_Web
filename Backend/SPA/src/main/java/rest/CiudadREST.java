package rest;

import model.Ciudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CiudadService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/ciudad/")
public class CiudadREST {

    @Autowired
    private CiudadService ciudadService;

    @GetMapping
    private ResponseEntity<List<Ciudad>> getAllciudades()
    {
        return ResponseEntity.ok(ciudadService.findAll());
    }

    @PostMapping
    private ResponseEntity<Ciudad> saveCiudad(@RequestBody Ciudad ciudad) throws URISyntaxException {

        try {
            Ciudad ciudadGuardada = ciudadService.save(ciudad);
            return ResponseEntity.created(new URI("/ciudad/" + ciudad.getId()))
                    .body(ciudadGuardada);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}

/*
@GetMapping
    private ResponseEntity<List<Ciudad>> getAllciudades()
    {
        return ResponseEntity.ok(ciudadService.findAll());
    }

    @PostMapping
    private ResponseEntity<Ciudad> saveCiudad(@RequestBody Ciudad ciudad) throws URISyntaxException {

        try {
            Ciudad ciudadGuardada = ciudadService.save(ciudad);
            return ResponseEntity.created(new URI("/ciudad/" + ciudad.getId()))
                    .body(ciudadGuardada);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
 */