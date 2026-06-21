package ru.dada.typestorm.model;

import java.time.LocalDateTime;

public class TypingSession {
    private final String originalText;
    private String enteredText;
    private final LocalDateTime startTime;
    private LocalDateTime endTime;
    private final int mistakesCount;

    public TypingSession(String originalText) {
        this.originalText = originalText;
        this.enteredText = "";
        this.startTime = LocalDateTime.now();
        this.endTime = null;
        this.mistakesCount = 0;
    }

    public String getOriginalText() {
        return this.originalText;
    }

    public String getEnteredText() {
        return this.enteredText;
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public void setEnteredText(String enteredText) {
        this.enteredText = enteredText;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getMistakesCount() {
        return this.mistakesCount;
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
        return this.endTime != null;
    }

    @Override
    public String toString() {
        return new StringBuilder("Typing session:\n")
                .append("original text: '").append(this.originalText).append("'\n")
                .append("entered text: '").append(this.enteredText).append("'\n")
                .append("start time: ").append(this.startTime).append("'\n")
                .append("end time: ").append(this.endTime).append("'\n")
                .append("finished: ").append(this.isFinished()).append("'\n")
                .append("mistakes count: ").append(this.mistakesCount).append("\n")
                .toString();
    }
}