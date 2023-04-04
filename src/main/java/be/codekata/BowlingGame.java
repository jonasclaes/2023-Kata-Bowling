package be.codekata;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    public static final int STRIKE_BASE_SCORE = 10;
    public static final int SPARE_BASE_SCORE = 10;
    public static final int STRIKE_FRAME_OFFSET = 1;
    public static final int SPARE_FRAME_OFFSET = 2;
    public static final int REGULAR_FRAME_OFFSET = 2;
    public static final int AMOUNT_OF_FRAMES = 10;
    private final List<Integer> rolls;

    public BowlingGame() {
        this.rolls = new ArrayList<>();
    }

    public Integer calculateScore() {
        int score = 0;
        int index = 0;

        if (rolls.size() == 0) {
            return 0;
        }

        for (int i = 0; i < AMOUNT_OF_FRAMES; i++) {
            if (isStrike(index)) {
                score += STRIKE_BASE_SCORE;
                score += calculateStrikeBonus(index);

                index += STRIKE_FRAME_OFFSET;
            } else if (isSpare(index)) {
                score += SPARE_BASE_SCORE;
                score += calculateSpareBonus(index);

                index += SPARE_FRAME_OFFSET;
            } else {
                score += calculateFrameScore(index);

                index += REGULAR_FRAME_OFFSET;
            }
        }

        return score;
    }

    private int calculateFrameScore(int index) {
        Integer score = rolls.get(index);
        score += rolls.get(index + 1);
        return score;
    }

    private static int getScore() {
        return 10;
    }

    private int calculateSpareBonus(int index) {
        return rolls.get(index + 2);
    }

    private int calculateStrikeBonus(int index) {
        Integer firstNextRoll = rolls.get(index + 1);
        Integer secondNextRoll = calculateSpareBonus(index);
        return firstNextRoll + secondNextRoll;
    }

    private boolean isStrike(Integer index) {
        return rolls.get(index) == 10;
    }

    private boolean isSpare(Integer index) {
        Integer roll1 = rolls.get(index);
        Integer roll2 = rolls.get(index + 1);
        return roll1 + roll2 == 10;
    }

    public void roll(int i) {
        this.rolls.add(i);
    }
}
