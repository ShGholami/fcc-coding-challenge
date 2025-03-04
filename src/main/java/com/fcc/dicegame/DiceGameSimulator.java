package com.fcc.dicegame;

public class DiceGameSimulator {
    private static final int NUM_SIMULATIONS = 10000;
    private static final int NUM_DICE = 5;

    public static void main(String[] args) {
        Game diceGame = new DiceGame(NUM_DICE);
        GameStatistics statistics = new GameStatistics();

        long startTime = System.nanoTime();

        for (int i = 0; i < NUM_SIMULATIONS; i++) {
            int score = diceGame.play();
            statistics.recordScore(score);
        }

        long endTime = System.nanoTime();
        statistics.displayResults(NUM_SIMULATIONS, (endTime - startTime) / 1e9);
    }
}
