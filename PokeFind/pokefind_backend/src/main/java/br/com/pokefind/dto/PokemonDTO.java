package br.com.pokefind.dto;

import br.com.pokefind.model.Pokemon;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PokemonDTO {
    private Long id;
    private String name;
    private String url;

    public PokemonDTO(Pokemon pokemon){
        this.id = pokemon.getId();
        this.name = pokemon.getName();
        this.url = pokemon.getUrl();
    }
}

