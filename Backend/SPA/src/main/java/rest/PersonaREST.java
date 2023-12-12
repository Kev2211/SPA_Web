package rest;


import model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PersonaService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/persona/")
public class PersonaREST {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    private ResponseEntity<List<Persona>> getAllPersona() {
        return ResponseEntity.ok(personaService.findAll());
    }

    @PostMapping
    private ResponseEntity<Persona> savePersona(@RequestBody Persona persona) throws URISyntaxException {

        try {
            Persona personaGuardada = personaService.save(persona);
            return ResponseEntity.created(new URI("/persona/" + persona.getId()))
                    .body(personaGuardada);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping(value = "delete/{id}")
    private ResponseEntity<Boolean> deletePersona(@PathVariable ("id") Long id){
        personaService.deleteById(id);
        return ResponseEntity.ok(!(personaService.findById(id)!=null));
    }


}