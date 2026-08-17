package ru.dada.typestorm.metrics;

import ru.dada.typestorm.model.TypingResult;
import ru.dada.typestorm.model.TypingSession;

import java.time.Duration;

/**
 * Класс обработки сессии
 */
public class SessionCalculator {
    private final WpmCalculator wpmCalculator;
    private final AccuracyCalculator accuracyCalculator;

    private final double DEFAULT_WPM = 0.0;
    private final double DEFAULT_ACCURACY = 100.0;
    private final int DEFAULT_DURATION = 0;

    public SessionCalculator(WpmCalculator wpmCalculator, AccuracyCalculator accuracyCalculator) {
        this.wpmCalculator = wpmCalculator;
        this.accuracyCalculator = accuracyCalculator;
    }

    /**
     * Функция обработки сессии
     * @param session одна тренировка печати
     * @return класс, содержащий подсчитанные результаты сессии
     */
    public TypingResult calculate(TypingSession session) {
        if (!session.isFinished()) {
            throw new IllegalArgumentException("Session is not finished");
        }

        int duration = this.calculateDuration(session);
        if (duration == 0) {
            return new TypingResult(session, this.DEFAULT_WPM, this.DEFAULT_ACCURACY, this.DEFAULT_DURATION);
        }
        double accuracy = calculateAccuracy(session);
        double wpm = calculateWpm(session, duration);

        return new TypingResult(session, wpm, accuracy, duration);
    }

    /**
     * Подсчёт длительности сессии
     * @param session сессия
     * @return длительность сессии
     */
    private int calculateDuration(TypingSession session) {
        Duration duration = Duration.between(session.getStartTime(), session.getEndTime());
        return (int) duration.getSeconds();
    }

    /**
     * Подсчёт точности печати в сессии
     * @param session сессия
     * @return точность
     */
    private double calculateAccuracy(TypingSession session) {
        return this.accuracyCalculator.calculateAccuracy(session.getOriginalText(), session.getEnteredText());
    }

    /**
     * Подсчёт скорости печати в сессии
     * @param session сессия
     * @param duration длительность сессии
     * @return скорость печати (WPM - слов в минуту)
     */
    private double calculateWpm(TypingSession session, int duration) {
        int symbolsCount = session.getEnteredText().length();
        return this.wpmCalculator.calculateWpm(duration, symbolsCount);
    }
}
