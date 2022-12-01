package br.com.pokegraph.dto.repository;

import br.com.pokegraph.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

}
