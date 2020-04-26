package io.github.wotjd243.pokemon.trainer.domain;


import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Trainer {
    @Id
    private String id;
    
    @Embedded
    private Level level;

    @ElementCollection
    private List<PokemonCaught> party = new ArrayList<>();

    public Trainer() {}

    public Trainer(String id) {
        this(id, Level.ONE, new ArrayList<>());
    }

    public Trainer(final String id, final Level level, List<PokemonCaught> party) {
        this.id = id;
        this.level = level;
        this.party = party;
    }

    public void addPokemon(final int number, final String name) {
        addPokemon(new PokemonCaught(number, name));
    }
    
    //외부에 노출하지 않기 위해 노출하는 addPokemon을 따로 만든다. 
    private void addPokemon(final PokemonCaught pokemonCaught) {
        party.add(pokemonCaught);
        levelUp();
    }
    
    private void levelUp() {
        this.level = level.up();
    }

    public String getId() {
        return id;
    }

    public Level getLevel() {
        return level;
    }

    public List<PokemonCaught> getParty() {
        return party;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return Objects.equals(id, trainer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
