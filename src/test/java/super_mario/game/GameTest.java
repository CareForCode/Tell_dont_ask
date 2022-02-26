package super_mario.game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import super_mario.game.Game;
import super_mario.mario.Mario;
import super_mario.mario.State;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @ParameterizedTest
    @EnumSource(value = State.class, names = {"SMALL", "BIG"})
    void gameLoop_With0Lives_isGameOver(State state) {
        int lifeCount = 0;
        Game game = new Game(false);
        Mario mario = new Mario(state, lifeCount);

        game.gameLoop(mario);

        assertGameOver(game);
    }

    @Test
    void gameLoop_With1LifeIsHitAsSmall_isGameOver() {
        Game game = new Game(true);
        Mario mario = new Mario(State.SMALL,1);

        game.gameLoop(mario);

        assertGameOver(game);
    }

    @Test
    void gameLoop_With1LifeIsHitAsBig_isStartAgain() {
        Game game = new Game(true);
        Mario mario = new Mario(State.BIG,1);

        game.gameLoop(mario);

        assertStartAgain(game);
    }

    private void assertStartAgain(Game game) {
        assertTrue(game.isStartAgain());
        assertFalse(game.isGameOver());
    }

    private void assertGameOver(Game game) {
        assertTrue(game.isGameOver());
        assertFalse(game.isStartAgain());
    }
}
