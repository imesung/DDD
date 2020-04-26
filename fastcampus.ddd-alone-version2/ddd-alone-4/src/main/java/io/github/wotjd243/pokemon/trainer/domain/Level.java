package io.github.wotjd243.pokemon.trainer.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Level {
    private static final int MIN_LEVEL = 1;
    private static final int MAX_LEVEL = 30;

    //트레이너가 무수히 많아지므로 레벨 1이라는 객체를 미리 설정 -> 가능한 이유는 불변이기 때문이다.
    static final Level ONE = new Level(1);

    private int level;

    protected Level() {
    }

    public Level(int level) {
        if(level < MIN_LEVEL || level > MAX_LEVEL) {
            throw new IllegalArgumentException();
        }
        this.level = level;
    }

    public Level up() {
        if(level >= MAX_LEVEL) {
            //값 객체이므로 this로 리턴하면 된다. 더 이상 레벨이 올라가지 않는다.
            return this;
        }
        return new Level(level + 1);
    }
    
    
}
