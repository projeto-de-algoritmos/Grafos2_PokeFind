package br.com.pokegraph.controller;

import br.com.pokegraph.exception.EmptyListPokemonException;
import br.com.pokegraph.service.AreaService;
import br.com.pokegraph.service.PokemonService;
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

    @GetMapping(path = "/areas/{PokemonId}/{AreaId}")
    public ResponseEntity<?> findClosestArea(@PathVariable Long PokemonId,@PathVariable Long AreaId){
        try {
            return ResponseEntity.ok(service.findClosestArea(PokemonId, AreaId));
        } catch (EmptyListPokemonException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
