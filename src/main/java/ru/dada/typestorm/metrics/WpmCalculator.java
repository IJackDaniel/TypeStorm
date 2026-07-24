package ru.dada.typestorm.metrics;

/**
 * Класс подсчёта скорости печати (WPM - words per minute)
 */
public class WpmCalculator {

    private static final int SECONDS_IN_MINUTE = 60;
    private static final int SYMBOLS_IN_WORD = 5;

    /**
     * Подсчёт скорости печати WPM - Words Per Minute
     * @param sessionDuration длительность сессии (должна быть >0)
     * @param symbolsCount количество набранных символов
     * @return скорость печати (слов в минуту)
     * @throws IllegalArgumentException если длительность сессии <= 0
     */
    public double calculateWpm(int sessionDuration, int symbolsCount) {
        if (sessionDuration <= 0) {
            throw new IllegalArgumentException("Длительность сессии должна быть > 0");
        }
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
