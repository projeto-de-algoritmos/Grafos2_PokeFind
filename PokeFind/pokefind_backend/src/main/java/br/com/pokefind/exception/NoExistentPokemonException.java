package br.com.pokefind.exception;

import lombok.Getter;

@Getter
public class NoExistentPokemonException extends RuntimeException {
    private final String message;

    public NoExistentPokemonException(String message){
        super(message);
        this.message = message;
    }
}
