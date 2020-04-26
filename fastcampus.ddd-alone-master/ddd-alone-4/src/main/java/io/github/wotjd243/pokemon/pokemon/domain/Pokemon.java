package io.github.wotjd243.pokemon.pokemon.domain;

import javax.validation.constraints.Max;

public class Pokemon {

    private final PokedexNumber pokedexNumber;
    private final String name;
    private int captureRate;

    public Pokemon(final int pokedexNumber, String name, int captureRate) {
        this(new PokedexNumber(pokedexNumber), name);
    }

    //주생성자
    public Pokemon(final PokedexNumber pokedexNumber, final String name) {
        this.pokedexNumber = pokedexNumber;
        this.name = name;
    }
}
