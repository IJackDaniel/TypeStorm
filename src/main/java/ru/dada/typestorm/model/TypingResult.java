package ru.dada.typestorm.model;

/**
 * Класс - результат сессии, со всеми замерами
 */
public class TypingResult {

    private final TypingSession typingSession;
    private final double wpm;
    private final double accuracy;
    private final int durationSeconds;

    public TypingResult(TypingSession typingSession, double wpm, double accuracy, int durationSeconds) {
        this.typingSession = typingSession;
        this.wpm = wpm;
        this.accuracy = accuracy;
        this.durationSeconds = durationSeconds;
    }

    public TypingSession getSession() {
        return this.typingSession;
    }

    public double getWpm() {
        return this.wpm;
    }

    public double getAccuracy() {
        return this.accuracy;
    }

    public int getDurationSeconds() {
        return this.durationSeconds;
    }

    public String getFormattedWpm() {
        return String.format("%.1f", this.wpm);
    }

    public String getFormattedAccuracy() {
        return String.format("%.1f%%", this.accuracy);
    }

    @Override
    public String toString() {
        return new StringBuilder(this.typingSession.toString())
                .append("Result of the session:\n")
                .append("words per minute: ").append(this.wpm).append("'\n")
                .append("accuracy: ").append(this.accuracy).append("'\n")
                .append("duration: ").append(this.durationSeconds).append("'")
                .toString();
    }
}
