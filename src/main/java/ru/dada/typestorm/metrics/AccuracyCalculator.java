package ru.dada.typestorm.metrics;

public class AccuracyCalculator {

    public double calculateAccuracy(String originalText, String typedText) {
        if (originalText.length() > typedText.length()) {
            originalText = originalText.substring(0, typedText.length());
        }

        int textLength = originalText.length();
        int mistakesCount = 0;
        for (int i = 0; i < textLength; i++) {
            if (originalText.charAt(i) != typedText.charAt(i)) {
                mistakesCount++;
            }
        }

        double accuracy = (double) (textLength - mistakesCount) / textLength;

        return (double) Math.round(accuracy * 100) /100;
    }

}
