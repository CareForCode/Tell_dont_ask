package super_mario.mario;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.*;

import static org.junit.jupiter.api.Assertions.*;

public class MarioTest {

    @Test
    void initialization() {
        State initState = State.SMALL;
        int initLifeCount = 30;

        Mario mario = new Mario(initState, initLifeCount);

        assertEquals(initState, mario.getState());
    }

    private static Stream<Arguments> reduceStateArguments() {
        return Stream.of(
                Arguments.of(State.BIG, State.SMALL),
                Arguments.of(State.SMALL, State.DEFEATED),
                Arguments.of(State.DEFEATED, State.DEFEATED)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "reduceStateArguments")
    void reduceState_Parameterized(State initialState, State expectedState) {
        Mario mario = new Mario(initialState, 1);

        mario.reduceState();

        assertEquals(expectedState, mario.getState());
    }

    @ParameterizedTest
    @CsvSource(value = {"1,false", "0,true", "-1,true"})
    void hasNoMoreLives_Parameterized(int lifeCount, boolean expectedResult) {
        Mario mario = new Mario(State.BIG, lifeCount);

        assertEquals(expectedResult, mario.hasNoMoreLives());
    }

}
