package io.github.wotjd243.pokemon.pokemon.domain;

//이것으로 인해 구현으로 부터 해방된 레이어가 만들어진 것.
public interface PokemonRepository {
    Pokemon findById(NationalPokedexNumber number);
}
