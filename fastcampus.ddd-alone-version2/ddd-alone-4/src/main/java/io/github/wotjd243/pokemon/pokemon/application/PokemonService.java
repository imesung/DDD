package io.github.wotjd243.pokemon.pokemon.application;

import io.github.wotjd243.pokemon.pokemon.domain.CaptureService;
import io.github.wotjd243.pokemon.pokemon.domain.NationalPokedexNumber;
import io.github.wotjd243.pokemon.pokemon.domain.Pokemon;
import io.github.wotjd243.pokemon.pokemon.domain.PokemonRepository;
import io.github.wotjd243.pokemon.trainer.domain.Trainer;
import io.github.wotjd243.pokemon.trainer.domain.TrainerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//인프라스트럭션 레이어
@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;
    private final TrainerRepository trainerRepository;
    private final CaptureService captureService;

    public PokemonService(final PokemonRepository pokemonRepository, TrainerRepository trainerRepository, CaptureService captureService) {
        this.pokemonRepository = pokemonRepository;
        this.trainerRepository = trainerRepository;
        this.captureService = captureService;
    }

    public Pokemon find(final int number) {
        return getById(number);
    }

    //포켓몬 잡기 
    @Transactional
    public void capture(final String userId, final int number) {
        final Pokemon pokemon = pokemonRepository.findById(NationalPokedexNumber.valueOf(number));
        final Trainer trainer = trainerRepository.findById(userId).get();
        captureService.capture(pokemon, trainer);
    }
    
    private Pokemon getById(int number) {
        return pokemonRepository.findById(NationalPokedexNumber.valueOf(number));
    }
}
