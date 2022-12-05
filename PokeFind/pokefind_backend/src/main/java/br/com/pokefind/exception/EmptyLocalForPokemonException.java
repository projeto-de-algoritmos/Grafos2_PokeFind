package br.com.pokefind.exception;

import lombok.Getter;

@Getter
public class EmptyLocalForPokemonException extends RuntimeException{
    private final String message;

    public EmptyLocalForPokemonException (String message){
        super(message);
        this.message = message;
    }
}
