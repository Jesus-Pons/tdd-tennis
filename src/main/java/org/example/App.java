package org.example;

import p3dev.MatchSimulator;
import p3dev.PointProvider;
import p3dev.RandomPointProvider;
import p3dev.ScoreTranslator;

public class App {
    public static void main(String[] args) {
        ScoreTranslator translator = new ScoreTranslator();
        PointProvider randomProvider = new RandomPointProvider();

        MatchSimulator simulator = new MatchSimulator(translator, randomProvider);

        simulator.playMatch();
    }
}