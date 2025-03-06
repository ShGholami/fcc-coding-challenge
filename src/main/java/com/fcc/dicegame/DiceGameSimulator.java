package com.fcc.dicegame;

public class DiceGameSimulator {
    private final int numSimulations;
    private final Game game;
    private final GameStatistics statistics;


    public DiceGameSimulator(int numSimulations, Game game, GameStatistics statistics) {
        this.numSimulations = numSimulations;
        this.game = game;
        this.statistics = statistics;
    }

    public void runSimulation(){
        long startTime = System.nanoTime();

        for (int i = 0; i < numSimulations; i++) {
            int score = game.play();
            statistics.recordScore(score);
        }

        long endTime = System.nanoTime();
        statistics.displayResults(numSimulations, (endTime - startTime) / 1e9);
    }

    public static void main(String[] args) {
        int numSimulations = 10_000;
        int numDice = 5;

        Game game = new DiceGame(numDice);
        GameStatistics statistics = new GameStatistics();
        DiceGameSimulator simulator = new DiceGameSimulator(numSimulations, game, statistics);

        simulator.runSimulation();
    }
}
