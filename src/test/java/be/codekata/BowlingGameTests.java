package be.codekata;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class BowlingGameTests {

    @Test
    void shouldReturnZeroIfNoRollsPresent() {
        BowlingGame bowlingGame = new BowlingGame();
        Integer result = bowlingGame.calculateScore();
        assertThat(result, equalTo(0));
    }

    @Test
    void shouldReturnZeroForGutterGame() {
        BowlingGame bowlingGame = new BowlingGame();
        
        rollManyTimesPins(20, 0, bowlingGame);

        Integer result = bowlingGame.calculateScore();
        assertThat(result, equalTo(0));
    }

    @Test
    void shouldReturn20ForAllOneGame() {
        BowlingGame bowlingGame = new BowlingGame();

        rollManyTimesPins(20, 1, bowlingGame);

        Integer result = bowlingGame.calculateScore();
        assertThat(result, equalTo(20));
    }

    @Test
    void shouldReturn16ForASpareFollowedByA3() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll(0);
        bowlingGame.roll(10);
        bowlingGame.roll(3);

        rollManyTimesPins(17, 0, bowlingGame);

        Integer result = bowlingGame.calculateScore();
        assertThat(result, equalTo(16));
    }

    @Test
    void shouldReturn24ForAStrikeFollowedByA3And4() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll(10);
        bowlingGame.roll(3);
        bowlingGame.roll(4);

        rollManyTimesPins(16,0,bowlingGame);

        Integer result = bowlingGame.calculateScore();
        assertThat(result,equalTo(24));
    }

    @Test
    void shouldReturn300ForPerfectGame() {
        BowlingGame bowlingGame = new BowlingGame();

        rollManyTimesPins(12, 10, bowlingGame);

        Integer result = bowlingGame.calculateScore();
        assertThat(result, equalTo(300));
    }

    @Test
    void shouldReturn133ForExampleGame() {
        BowlingGame bowlingGame = new BowlingGame();

        bowlingGame.roll(1);
        bowlingGame.roll(4);

        bowlingGame.roll(4);
        bowlingGame.roll(5);

        bowlingGame.roll(6);
        bowlingGame.roll(4);

        bowlingGame.roll(5);
        bowlingGame.roll(5);

        bowlingGame.roll(10);

        bowlingGame.roll(0);
        bowlingGame.roll(1);

        bowlingGame.roll(7);
        bowlingGame.roll(3);

        bowlingGame.roll(6);
        bowlingGame.roll(4);

        bowlingGame.roll(10);

        bowlingGame.roll(2);
        bowlingGame.roll(8);
        bowlingGame.roll(6);

        Integer result = bowlingGame.calculateScore();
        assertThat(result, equalTo(133));
    }

    private void rollManyTimesPins(int rolls, int pins, BowlingGame bowlingGame) {
        for (int j = 0; j < rolls; j++) {
            bowlingGame.roll(pins);
        }
    }
}
