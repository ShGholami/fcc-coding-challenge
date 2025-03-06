package com.fcc.dicegame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DiceGame implements Game {
    private final Random random = new Random();
    private final int diceCount;

    public DiceGame(int diceCount) {
        this.diceCount = diceCount;
    }

    @Override
    public int play() {
        List<Integer> dice = new ArrayList<>();
        rollDice(dice, diceCount);
        int totalScore = 0;

        while (!dice.isEmpty()) {
            if (dice.contains(3)) {
                dice.removeIf(die -> die == 3);  // Remove all 3's
            } else {
                int minDie = Collections.min(dice);
                totalScore += minDie;
                dice.remove(Integer.valueOf(minDie));
            }
            rollDice(dice, dice.size());  // Re-throw remaining dice
        }
        return totalScore;
    }

    private void rollDice(List<Integer> dice, int diceCount) {
        dice.clear();
        for (int i = 0; i < diceCount; i++) {
            dice.add(random.nextInt(6) + 1);
        }
    }
}
