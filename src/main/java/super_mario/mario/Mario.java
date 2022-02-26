package super_mario.mario;

public class Mario {
    private State state;
    private int lifeCount;

    public Mario(State state, int lifeCount) {
        this.state = state;
        this.lifeCount = lifeCount;
    }

    public boolean hasNoMoreLives() {
        return lifeCount <= 0;
    }

    public void reduceLifeCount() {
        lifeCount--;
    }

    public boolean isDefeated() {
        return state == State.DEFEATED;
    }

    public void reduceState() {
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
