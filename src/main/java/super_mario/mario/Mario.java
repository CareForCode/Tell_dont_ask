package super_mario.mario;

public class Mario {
    private State state;
    private int lifeCount;

    public Mario(State state, int lifeCount) {
        this.state = state;
        this.lifeCount = lifeCount;
    }

    boolean hasNoMoreLives() {
        return lifeCount <= 0;
    }

    void reduceLifeCount() {
        lifeCount--;
    }

    boolean isDefeated() {
        return state == State.DEFEATED;
    }

    void reduceState() {
        if (state == State.BIG) {
            state = State.SMALL;
        } else if (state == State.SMALL) {
            state = State.DEFEATED;
        }
    }

    State getState() {
        return state;
    }

    int getLifeCount() {
        return lifeCount;
    }
}
