package com.fcc.dicegame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DiceGame implements Game {
    private List<Integer> dice;
    private final Random random = new Random();
    private final int diceCount;

    public DiceGame(int diceCount) {
        this.diceCount = diceCount;
    }

    @Override
    public int play() {
        dice = rollDice(diceCount);
        int totalScore = 0;

        while (!dice.isEmpty()) {
            if (dice.contains(3)) {
                dice.removeIf(die -> die == 3);  // Remove all 3's
            } else {
                int minDie = Collections.min(dice);
                totalScore += minDie;
                dice.remove(Integer.valueOf(minDie));
            }
            dice = rollDice(dice.size());  // Re-throw remaining dice
        }
        return totalScore;
    }

    private List<Integer> rollDice(int diceCount) {
        List<Integer> newRoll = new ArrayList<>();
        for (int i = 0; i < diceCount; i++) {
            newRoll.add(random.nextInt(6) + 1);
        }
        return newRoll;
    }
}
