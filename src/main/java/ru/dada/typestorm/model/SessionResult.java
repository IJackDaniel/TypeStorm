package ru.dada.typestorm.model;

public class SessionResult {
    private final Session session;
    private final double wpm;
    private final double accuracy;
    private final int durationSeconds;
    private final int errorCount;

    public SessionResult(Session session, double wpm, double accuracy, int durationSeconds, int errorCount) {
        this.session = session;
        this.wpm = wpm;
        this.accuracy = accuracy;
        this.durationSeconds = durationSeconds;
        this.errorCount = errorCount;
    }

    public Session getSession() {
        return this.session;
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

    public int getErrorCount() {
        return this.errorCount;
    }

    public String getFormattedWpm() {
        return String.format("%.1f", this.wpm);
    }

    public String getFormattedAccuracy() {
        return String.format("%.1f%%", this.accuracy);
    }

    @Override
    public String toString() {
        return new StringBuilder(this.session.toString())
                .append("Result of the session:\n")
                .append("words per minute: ").append(this.wpm).append("'\n")
                .append("accuracy: ").append(this.accuracy).append("'\n")
                .append("duration (in seconds): ").append(this.durationSeconds).append("'\n")
                .append("error count: ").append(this.errorCount).append("'")
                .toString();
    }
}