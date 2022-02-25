package super_mario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {

    @ParameterizedTest
    @EnumSource(State.class)
    void gameLoop_With0Lives_isGameOver(State state) {
        Game game = new Game(false);
        Mario mario = new Mario(state,0);

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

    private void assertGameOver(Game game) {
        assertTrue(game.isGameOver());
        assertFalse(game.isStartAgain());
    }
}
