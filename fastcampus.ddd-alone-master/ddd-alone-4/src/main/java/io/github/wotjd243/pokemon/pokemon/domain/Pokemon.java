package io.github.wotjd243.pokemon.pokemon.domain;

import javax.validation.constraints.Max;

public class Pokemon {

    private static final int MAX_NUMBER = 151;
    private static final int MIN_NUMBER = 1;

    private final int pokedexNumber;
    private final String name;

    public Pokemon(final int pokedexNumber, final String name) {
        if(pokedexNumber < MIN_NUMBER || pokedexNumber > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }

        this.pokedexNumber = pokedexNumber;
        this.name = name;
    }
}
