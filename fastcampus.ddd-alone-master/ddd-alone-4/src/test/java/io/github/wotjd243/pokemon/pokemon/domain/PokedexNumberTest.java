package io.github.wotjd243.pokemon.pokemon.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PokedexNumberTest {
    @Test
    void 동등성보장() {
        final PokedexNumber actual = new PokedexNumber(1);
        assertThat(actual).isEqualTo(new PokedexNumber(1));
    }

    @DisplayName("`PokedexNumber`는 1부터 151까지이다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 152})   //number 자리에 -1, 0, 152를 순서대로 넣어준다.
    void createPokedexNumber(final int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Pokemon(number, "치코리타", 2));
    }
}