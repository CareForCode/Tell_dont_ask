package super_mario.game;

import super_mario.mario.Mario;

public class Game {


    private boolean isGameOver = false;
    private boolean isStartAgain = false;
    private final boolean wasHit;

    public Game(boolean wasHit) {
        this.wasHit = wasHit;
    }

    public void gameLoop(Mario mario) {
        if (wasHit(mario)) {
            mario.reduceState();
        }
        if (mario.isKnockedOut()) {
            mario.reduceLifeCount();
            if (mario.isAlive()) {
                restartLevel();
            }
        }
        if (mario.isDefeated()) {
            gameOver();
        }
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
