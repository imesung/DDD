package io.github.wotjd243.pokemon.pokemon.ui;

import io.github.wotjd243.pokemon.pokemon.application.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {
    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/api/pokemons/{number}")
    public void find(@PathVariable final int number) {
        ResponseEntity.ok()
                .body(pokemonService.find(number));
    }
}
