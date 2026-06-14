package ru.dada.typestorm.model;

import java.time.LocalDateTime;

public class Session {
    private final String originalText;
    private String enteredText;
    private final LocalDateTime startTime;
    private LocalDateTime endTime;
    private final int errorCount;

    public Session(String originalText) {
        this.originalText = originalText;
        this.enteredText = "";
        this.startTime = LocalDateTime.now();
        this.endTime = null;
        this.errorCount = 0;
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
                .append("original text: '").append(originalText).append("'\n")
                .append("entered text: '").append(enteredText).append("'\n")
                .append("start time: ").append(startTime).append("'\n")
                .append("end time: ").append(endTime).append("'\n")
                .append("finished: ").append(isFinished()).append("'\n")
                .append("error count: ").append(errorCount).append("\n")
                .toString();
    }
}