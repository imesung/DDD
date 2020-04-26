package io.github.wotjd243.pokemon.pokemon.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {
    @DisplayName("`Pokemon`은 PokedexNumber, 닉네임을 가진다.")
    @Test
    void createPokemon() {
        new Pokemon(new PokedexNumber(1), "이상해씨");
    }


}