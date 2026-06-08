package ru.dada.typestorm.model;

import java.time.LocalDateTime;

public class Session {
    private final String originalText;
    private String enteredText;
    private final LocalDateTime startTime;
    private LocalDateTime endTime;

    public Session(String originalText) {
        this.originalText = originalText;
        this.enteredText = "";
        this.startTime = LocalDateTime.now();
        this.endTime = null;
    }

    public String getOriginalText() {
        return this.originalText;
    }

    public String getEnteredText() {
        return this.enteredText;
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

    public boolean isFinished() {
        return endTime != null;
    }

    @Override
    public String toString() {
        return new StringBuilder("Session:\n")
                .append("originalText: '").append(originalText).append("'\n")
                .append("enteredText: '").append(enteredText).append("'\n")
                .append("startTime: ").append(startTime).append("'\n")
                .append("endTime: ").append(endTime).append("'\n")
                .append("finished: ").append(isFinished()).append("'\n")
                .toString();
    }
}