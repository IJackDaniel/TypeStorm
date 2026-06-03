package ru.dada.typestorm.model;

import java.time.LocalDateTime;
import java.time.Duration;

public class Session {
    private final String originalText;
    private String enteredText;
    private final LocalDateTime startTime;
    private LocalDateTime endTime;

    public Session(String originalText) {
        if (originalText == null || originalText.trim().isEmpty()) {
            throw new IllegalArgumentException("Original text cannot be null or empty");
        }
        this.originalText = originalText;
        this.enteredText = "";
        this.startTime = LocalDateTime.now();
        this.endTime = null;
    }

    public String getOriginalText() {
        return originalText;
    }

    public String getEnteredText() {
        return enteredText;
    }

    public void updateEnteredText(String newEnteredText) {
        if (newEnteredText == null) {
            throw new IllegalArgumentException("Entered text cannot be null");
        }
        this.enteredText = newEnteredText;
    }

    public void finishSession() {
        if (this.endTime != null) {
            throw new IllegalStateException("Session is already finished");
        }
        this.endTime = LocalDateTime.now();
    }

    public int getSessionTime() {
        LocalDateTime end = (this.endTime != null) ? this.endTime : LocalDateTime.now();
        Duration duration = Duration.between(startTime, end);
        return (int) duration.getSeconds();
    }

    public boolean isFinished() {
        return endTime != null;
    }

    // Метод, который возвращает готовый результат сессии
    public SessionResult getResult() {
        if (!isFinished()) {
            throw new IllegalStateException("Cannot get result of unfinished session. Call finishSession() first.");
        }

        int durationSec = getSessionTime();

        // Защита от деления на ноль
        if (durationSec <= 0) {
            return new SessionResult(0, 0, 0, originalText.length());
        }

        int errorCount = calculateErrors();
        double accuracy = calculateAccuracy(errorCount);
        double wpm = calculateWPM(durationSec);

        return new SessionResult(wpm, accuracy, durationSec, errorCount);
    }

    // Приватные вспомогательные методы
    private int calculateErrors() {
        int minLength = Math.min(originalText.length(), enteredText.length());
        int errors = 0;

        for (int i = 0; i < minLength; i++) {
            if (originalText.charAt(i) != enteredText.charAt(i)) {
                errors++;
            }
        }

        errors += Math.max(0, enteredText.length() - originalText.length());
        return errors;
    }

    private double calculateAccuracy(int errorCount) {
        int totalChars = originalText.length();
        if (totalChars == 0) return 100.0;

        int correctChars = totalChars - Math.min(errorCount, totalChars);
        return (correctChars / (double) totalChars) * 100.0;
    }

    private double calculateWPM(int durationSeconds) {
        if (durationSeconds == 0) return 0;

        String[] words = enteredText.trim().split("\\s+");
        int wordCount = (enteredText.trim().isEmpty()) ? 0 : words.length;

        double minutes = durationSeconds / 60.0;
        return wordCount / minutes;
    }

    @Override
    public String toString() {
        return String.format("Session[original: %s..., entered: %s..., time: %ds, finished: %b]",
                originalText.length() > 20 ? originalText.substring(0, 20) : originalText,
                enteredText.length() > 20 ? enteredText.substring(0, 20) : enteredText,
                getSessionTime(),
                isFinished());
    }
}