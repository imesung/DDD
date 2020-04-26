package io.github.wotjd243.pokemon.pokemon.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PokedexNumber {
    //번호 확장 시 포멧몬 클래스를 수정하는 것이 아니라 도감 클래스에서 수정을 하는 것이다. 즉, 역할과 책임을 나눈 것이다.
    private static final int MAX_NUMBER = 151;
    private static final int MIN_NUMBER = 1;

    //포멧몬 번호가 가변일 시 Map형식으로 만들 수도 있음.
    private static final Map<Integer, PokedexNumber> cached = new HashMap<>();

    private final int number;

    public PokedexNumber(final int number) {
        if(number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }

        this.number = number;
    }

    public static PokedexNumber of(final int number) {
        return cached.putIfAbsent(number, new PokedexNumber(number));
    }

    //Object의 equals를 판단하는 것이 아니라 해당 객체에 있는 equals를 가지고 비교를 진행하게 되므로 주소가 다르더라도 동일하게 인식한다.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokedexNumber that = (PokedexNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
