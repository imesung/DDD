package io.github.wotjd243.pokemon.pokemon.application;

import io.github.wotjd243.pokemon.pokemon.domain.NationalPokedexNumber;
import io.github.wotjd243.pokemon.pokemon.domain.Pokemon;
import io.github.wotjd243.pokemon.pokemon.domain.PokemonRepository;
import org.springframework.stereotype.Service;

//인프라스트럭션 레이어
@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    public PokemonService(final PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Pokemon find(final int number) {
        return getById(number);
    }

    private Pokemon getById(int number) {
        return pokemonRepository.findById(NationalPokedexNumber.valueOf(number));
    }
}
