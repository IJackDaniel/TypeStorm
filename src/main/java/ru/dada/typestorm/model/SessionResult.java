package ru.dada.typestorm.model;

public class SessionResult {
    private final double wpm;
    private final double accuracy;
    private final int durationSeconds;
    private final int errorCount;

    public SessionResult(double wpm, double accuracy, int durationSeconds, int errorCount) {
        if (wpm < 0) throw new IllegalArgumentException("WPM cannot be negative");
        if (accuracy < 0 || accuracy > 100) {
            throw new IllegalArgumentException("Accuracy must be between 0 and 100");
        }
        if (durationSeconds < 0) throw new IllegalArgumentException("Duration cannot be negative");
        if (errorCount < 0) throw new IllegalArgumentException("Error count cannot be negative");

        this.wpm = wpm;
        this.accuracy = accuracy;
        this.durationSeconds = durationSeconds;
        this.errorCount = errorCount;
    }

    public double getWpm() {
        return wpm;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public String getFormattedWpm() {
        return String.format("%.1f", wpm);
    }

    public String getFormattedAccuracy() {
        return String.format("%.1f%%", accuracy);
    }

    @Override
    public String toString() {
        return String.format("SessionResult{WPM=%.1f, accuracy=%.1f%%, duration=%ds, errors=%d}",
                wpm, accuracy, durationSeconds, errorCount);
    }
}