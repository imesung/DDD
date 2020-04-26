package io.github.wotjd243.pokemon.trainer.domain;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
//다른 엔티티에 포함될 수 있다라는 어노테이션 
public class PokemonCaught {
    private int number;
    private String nickName;

    protected PokemonCaught() {}

    public PokemonCaught(int number, String nickName) {
        this.number = number;
        this.nickName = nickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonCaught that = (PokemonCaught) o;
        return number == that.number &&
                Objects.equals(nickName, that.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, nickName);
    }
}
