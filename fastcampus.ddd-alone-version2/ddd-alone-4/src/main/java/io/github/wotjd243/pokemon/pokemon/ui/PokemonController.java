package io.github.wotjd243.pokemon.pokemon.ui;

import io.github.wotjd243.pokemon.pokemon.application.PokemonService;
import io.github.wotjd243.pokemon.pokemon.domain.Pokemon;
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
    public ResponseEntity<Pokemon> find(@PathVariable final int number) {
        return ResponseEntity.ok()
                .body(pokemonService.find(number));
    }

    @GetMapping("/api/pokemons/{number}/capture-by/{id}")
    public void findpokemon(@PathVariable final int number, @PathVariable final String id) {
        pokemonService.capture(id, number);
    }
}
