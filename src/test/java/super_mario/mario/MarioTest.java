package super_mario.mario;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

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
                Arguments.of(State.SMALL, State.KNOCKED_OUT),
                Arguments.of(State.KNOCKED_OUT, State.KNOCKED_OUT)
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
    @CsvSource(value = {"1,true", "0,false", "-1,false"})
    void isAlive_Parameterized(int lifeCount, boolean expectedResult) {
        Mario mario = new Mario(State.BIG, lifeCount);

        assertEquals(expectedResult, mario.isAlive());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 20, -1, Integer.MAX_VALUE, Integer.MIN_VALUE})
    void reduceLifeCount_Parameterized(int lifeCount) {
        Mario mario = new Mario(State.BIG, lifeCount);

        mario.reduceLifeCount();

        assertEquals(lifeCount-1, mario.getLifeCount());
    }

    @Test
    void isKnockedOut_StateKnockedOut_IsTrue() {
        Mario mario = new Mario(State.KNOCKED_OUT, 1);
        assertTrue(mario.isKnockedOut());
    }

    @Test
    void isKnockedOut_StateBig_IsFalse() {
        Mario mario = new Mario(State.BIG, 1);
        assertFalse(mario.isKnockedOut());
    }

}
