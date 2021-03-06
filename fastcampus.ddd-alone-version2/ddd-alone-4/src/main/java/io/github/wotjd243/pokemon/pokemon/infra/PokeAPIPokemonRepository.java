package io.github.wotjd243.pokemon.pokemon.infra;

import io.github.wotjd243.pokemon.pokemon.domain.NationalPokedexNumber;
import io.github.wotjd243.pokemon.pokemon.domain.Pokemon;
import io.github.wotjd243.pokemon.pokemon.domain.PokemonRepository;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.PokemonSpecies;
import org.springframework.stereotype.Repository;

@Repository
public class PokeAPIPokemonRepository implements PokemonRepository {
    @Override
    public Pokemon findById(NationalPokedexNumber number) {
        final PokeApiClient pokeApiClient = new PokeApiClient();
        final PokemonSpecies pokemonSpecies = pokeApiClient.getPokemonSpecies(number.toInt());
        return new Pokemon(pokemonSpecies.getId(), pokemonSpecies.getName(), pokemonSpecies.getCaptureRate());
    }
}
