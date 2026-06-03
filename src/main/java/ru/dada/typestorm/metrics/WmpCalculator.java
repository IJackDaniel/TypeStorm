package ru.dada.typestorm.metrics;

public class WmpCalculator {

    private final static int SECONDS_IN_MINUTE = 60;
    private final static int SYMBOLS_IN_WORD = 5;

    public WmpCalculator() {
        // Пустой public конструктор, на случай если в будущем будут передаваться параметры вычисления wpm
    }

    public double getWmp(TypingSession typingSession) {
        int sessionDuration = typingSession.getSessionTime();
        String typedText = typingSession.getTypedText();
        int textLength = typedText.length();

        return calculateWmp(sessionDuration, textLength);
    }

    private double calculateWmp(int sessionDuration, int symbolsCount) {
        /*
        sps - symbols per second
        spm - symbols per minute
        wmp - words per minute
         */
        double sps = (double) symbolsCount / sessionDuration;
        double spm = sps * SECONDS_IN_MINUTE;
        return spm / SYMBOLS_IN_WORD;
    }
}
