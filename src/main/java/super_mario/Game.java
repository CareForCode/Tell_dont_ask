package super_mario;

public class Game {

    public void gameLoop(Mario mario) {
        if (wasHit(mario)) {
            if (mario.getState() == State.BIG) {
                mario.setState(State.SMALL);
            } else if (mario.getState() == State.SMALL) {
                mario.setState(State.DEFEATED);
            }
        }
        if (mario.getState() == State.DEFEATED) {
            int lifeCount = mario.getLifeCount();
            if (lifeCount > 1) {
                mario.setLifeCount(--lifeCount);
                startAgain();
            } else {
                quitGame();
            }
        }
    }

    private void startAgain() {

    }

    private void quitGame() {

    }

    private boolean wasHit(Mario mario) {
        return false;
    }

}
