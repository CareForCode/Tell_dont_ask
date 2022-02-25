package super_mario;

public class Game {


    private boolean isGameOver = false;
    private boolean isStartAgain = false;
    private final boolean wasHit;

    public Game(boolean wasHit) {
        this.wasHit = wasHit;
    }

    public void gameLoop(Mario mario) {
        if (wasHit(mario)) {
            if (mario.getState() == State.BIG) {
                mario.setState(State.SMALL);
            } else if (mario.getState() == State.SMALL) {
                mario.setState(State.DEFEATED);
            }
        }
        if (mario.getState() == State.DEFEATED) {
            mario.setLifeCount(mario.getLifeCount()-1);
        }
        if (mario.getLifeCount() <= 1) {
            quitGame();
        } else {
            startAgain();
        }
    }

    private void startAgain() {
        isStartAgain = true;
    }

    private void quitGame() {
        isGameOver = true;
    }

    private boolean wasHit(Mario mario) {
        return wasHit;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public boolean isStartAgain() {
        return isStartAgain;
    }

}
