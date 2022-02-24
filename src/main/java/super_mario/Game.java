package super_mario;

public class Game {

    public void gameLoop(Mario mario) {
        if (wasHit(mario)) {
            if (mario.getStatus() == Status.BIG) {
                mario.setStatus(Status.SMALL);
            } else if (mario.getStatus() == Status.SMALL) {
                mario.setStatus(Status.DEFEATED);
            }
        }
        if (mario.getStatus() == Status.DEFEATED) {
            int lifeCount = mario.getLifeCount();
            if (lifeCount < 2) {
                quitGame();
            } else {
                mario.setLifeCount(--lifeCount);
                startAgain();
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
