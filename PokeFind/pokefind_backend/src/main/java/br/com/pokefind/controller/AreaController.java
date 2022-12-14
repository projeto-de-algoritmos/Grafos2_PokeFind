package br.com.pokefind.controller;

import br.com.pokefind.exception.EmptyListPokemonException;
import br.com.pokefind.exception.PokemonNotFoundOnAreaException;
import br.com.pokefind.service.AreaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("area")
public class AreaController {
    private final AreaService service;

    public AreaController(AreaService service) {
        this.service = service;
    }

    @GetMapping(path = "/areas/{PokemonId}")
    public ResponseEntity<?> listAllAreasByPokemon(@PathVariable Long PokemonId){
        try {
            return ResponseEntity.ok(service.findAllByPokemon(PokemonId));
        } catch (EmptyListPokemonException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping(path = "/areas/{PokemonId}/{AreaId}")
    public ResponseEntity<?> findClosestArea(@PathVariable Long PokemonId,@PathVariable Long AreaId){
        try {
            return ResponseEntity.ok(service.findClosestArea(PokemonId, AreaId));
        } catch (PokemonNotFoundOnAreaException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping(path = "/areas")
    public ResponseEntity<?> listAllAreas(){
        try {
            return ResponseEntity.ok(service.findAll());
        } catch (EmptyListPokemonException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
