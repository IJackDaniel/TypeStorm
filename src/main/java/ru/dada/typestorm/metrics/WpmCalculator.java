package ru.dada.typestorm.metrics;

public class WpmCalculator {

    private static final int SECONDS_IN_MINUTE = 60;
    private static final int SYMBOLS_IN_WORD = 5;

    public double calculateWpm(int sessionDuration, int symbolsCount) {
        /*
        sps - symbols per second
        spm - symbols per minute
        wpm - words per minute
         */
        double sps = (double) symbolsCount / sessionDuration;
        double spm = sps * SECONDS_IN_MINUTE;
        return spm / SYMBOLS_IN_WORD;
    }
}
