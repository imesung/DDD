package io.github.wotjd243.pokemon.pokemon.domain;

import io.github.wotjd243.pokemon.trainer.domain.Trainer;
import org.springframework.stereotype.Component;

@Component
public class CaptureService {
    public void capture(final Pokemon pokemon, final Trainer trainer) {
        if(pokemon.getCaptureRate() < trainer.getLevel() + 100) {
            trainer.addPokemon(pokemon.getNumber(), "hello");
        }
    }
}
