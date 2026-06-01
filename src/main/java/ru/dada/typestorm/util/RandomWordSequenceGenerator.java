package ru.dada.typestorm.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dada.typestorm.model.AbstractWord;
import ru.dada.typestorm.service.WordService;

import java.util.*;

@Component
public class RandomWordSequenceGenerator<T extends AbstractWord> {
    @Autowired
    WordService<T> service;

    public String getRandomStringSequenceFromTop(int limit, int count) {
        List<T> words = service.getTopWords(limit);
        List<T> randomWords = this.getRandomValuesWithCountLimit(words, count);
        return this.WordsAsString(randomWords);
    }

    private List<T> getRandomValuesWithCountLimit(List<T> words, int count) {
        Random random = new Random();
        List<T> randomWords = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            randomWords.add(words.get(random.nextInt(words.size())));
        }

        return randomWords;
    }

    private String WordsAsString(List<T> words) {
        StringBuilder builder = new StringBuilder();

        for (T word : words) {
            builder.append(word.getWord()).append(" ");
        }

        return builder.toString().trim();
    }
}
