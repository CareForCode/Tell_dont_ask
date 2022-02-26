package super_mario.mario;

public class Mario {
    private State state;
    private int lifeCount;

    Mario(int lifeCount) {
        this.state = State.BIG;
        this.lifeCount = lifeCount;
    }

    Mario(State state) {
        this.state = state;
        this.lifeCount = 1;
    }

    public Mario(State state, int lifeCount) {
        this.state = state;
        this.lifeCount = lifeCount;
    }

    public boolean isAlive() {
        return lifeCount > 0;
    }

    public void reduceLifeCount() {
        lifeCount--;
    }

    public boolean isKnockedOut() {
        return state == State.KNOCKED_OUT;
    }

    public void reduceState() {
        state = State.values()[Math.max(0, state.ordinal() -1)];
    }

    State getState() {
        return state;
    }

    int getLifeCount() {
        return lifeCount;
    }

    public boolean isDefeated() {
        return !isAlive();
    }
}
