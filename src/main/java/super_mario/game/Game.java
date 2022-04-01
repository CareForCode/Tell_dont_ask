package super_mario.game;

import super_mario.mario.Mario;
import super_mario.mario.State;

public class Game {

    public void gameLoop(Mario mario) {
        if (wasHit(mario)) {
            if (mario.getState() == State.BIG) {
                mario.setState(State.SMALL);
            } else if (mario.getState() == State.SMALL) {
                mario.setState(State.KNOCKED_OUT);
            }
        }
        if (mario.getState() == State.KNOCKED_OUT) {
            mario.setLifeCount(mario.getLifeCount()-1);
            if (mario.getLifeCount() > 0) {
                restartLevel();
            }
        }
        if (mario.getLifeCount() <= 0) {
            gameOver();
        }
    }

    /********************* dummy implementation *********************************/

    private boolean isGameOver = false;
    private boolean isStartAgain = false;

    private final boolean wasHit;

    public Game(boolean wasHit) {
        this.wasHit = wasHit;
    }

    private void restartLevel() {
        isStartAgain = true;
    }

    private void gameOver() {
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
