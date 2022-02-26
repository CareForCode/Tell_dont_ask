package super_mario.game;

import org.junit.jupiter.api.Test;
import super_mario.mario.Mario;
import super_mario.mario.State;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    void gameLoop_With1LifeIsHitAsSmall_isGameOver() {
        Game game = new Game(true);
        Mario mario = new Mario(State.SMALL,1);

        game.gameLoop(mario);

        assertGameOver(game);
        assertMario(mario, State.KNOCKED_OUT, 0);
    }

    @Test
    void gameLoop_With2LivesIsHitAsSmall_isStartAgain() {
        Game game = new Game(true);
        Mario mario = new Mario(State.SMALL,2);

        game.gameLoop(mario);

        assertStartAgain(game);
        assertMario(mario, State.KNOCKED_OUT, 1);
    }

    @Test
    void gameLoop_With1LifeIsHitAsBig_isContinue() {
        Game game = new Game(true);
        Mario mario = new Mario(State.BIG,1);

        game.gameLoop(mario);

        assertContinue(game);
        assertMario(mario, State.SMALL, 1);
    }

    @Test
    void gameLoop_With1LifeIsNotHitAsSmall_isContinue() {
        Game game = new Game(false);
        Mario mario = new Mario(State.SMALL,1);

        game.gameLoop(mario);

        assertContinue(game);
        assertMario(mario, State.SMALL, 1);
    }

    @Test
    void gameLoop_With0LivesIsNotHit_isGameOver() {
        Game game = new Game(false);
        Mario mario = new Mario(State.SMALL,0);

        game.gameLoop(mario);

        assertGameOver(game);
        assertMario(mario, State.SMALL, 0);
    }

    @Test
    void gameLoop_With1LifeIsNotHitIsKnockedOut_isGameOver() {
        Game game = new Game(false);
        Mario mario = new Mario(State.KNOCKED_OUT,1);

        game.gameLoop(mario);

        assertGameOver(game);
        assertMario(mario, State.KNOCKED_OUT, 0);
    }

    @Test
    void gameLoop_With2LivesIsNotHitIsKnockedOut_isStartAgain() {
        Game game = new Game(false);
        Mario mario = new Mario(State.KNOCKED_OUT,2);

        game.gameLoop(mario);

        assertStartAgain(game);
        assertMario(mario, State.KNOCKED_OUT, 1);
    }

    private void assertContinue(Game game) {
        assertFalse(game.isStartAgain());
        assertFalse(game.isGameOver());
    }

    private void assertStartAgain(Game game) {
        assertTrue(game.isStartAgain());
        assertFalse(game.isGameOver());
    }

    private void assertMario(Mario mario, State expectedState, int expectedLifeCount) {
        assertEquals(expectedState, mario.getState());
        assertEquals(expectedLifeCount, mario.getLifeCount());
    }

    private void assertGameOver(Game game) {
        assertTrue(game.isGameOver());
        assertFalse(game.isStartAgain());
    }
}
