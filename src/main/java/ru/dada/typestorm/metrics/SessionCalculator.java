package ru.dada.typestorm.metrics;

import ru.dada.typestorm.model.TypingResult;
import ru.dada.typestorm.model.TypingSession;

import java.time.Duration;

public class SessionCalculator {
    private WpmCalculator wpmCalculator;
    private AccuracyCalculator accuracyCalculator;

    public SessionCalculator(WpmCalculator wpmCalculator, AccuracyCalculator accuracyCalculator) {
        this.wpmCalculator = wpmCalculator;
        this.accuracyCalculator = accuracyCalculator;
    }

    public TypingResult calculate(TypingSession session) {
        if (!session.isFinished()) {
            throw new IllegalArgumentException("Session is not finished");
        }

        int duration = calculateDuration(session);
        if (duration == 0) {
            return new TypingResult(session, 0.0, 0.0, 0);
        }
        double accuracy = calculateAccuracy(session);
        double wpm = calculateWpm(session);

        return new TypingResult(session, wpm, accuracy, duration);
    }

    public int calculateDuration(TypingSession session) {
        Duration duration = Duration.between(session.getStartTime(), session.getEndTime());
        return (int) duration.getSeconds();
    }

    public double calculateAccuracy(TypingSession session) {
        return this.accuracyCalculator.calculateAccuracy(session.getOriginalText(), session.getEnteredText());
    }

    public double calculateWpm(TypingSession session) {
        int symbolsCount = session.getEnteredText().length();
        return this.wpmCalculator.calculateWpm(this.calculateDuration(session), symbolsCount);
    }
}
