package com.fcc.dicegame;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class GameStatistics {
    private final Map<Integer, Integer> scoreFrequency = new HashMap<>();

    public void recordScore(int score) {
        scoreFrequency.put(score, scoreFrequency.getOrDefault(score, 0) + 1);
    }

    public void displayResults(int simulationCount, double duration) {
        System.out.println("Number of simulations: " + simulationCount);

        scoreFrequency.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(entry -> {
                    double probability = (double) entry.getValue() / simulationCount;
                    System.out.printf("Total %d occurs %.2f occurred %.1f times.%n",
                            entry.getKey(), probability, (double) entry.getValue());
                });

        System.out.printf("Total simulation took %.2f seconds.%n", duration);
    }
}
