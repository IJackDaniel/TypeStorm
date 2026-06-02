package ru.dada.typestorm.service;

import org.springframework.stereotype.Component;
import ru.dada.typestorm.model.DictionaryType;
import ru.dada.typestorm.model.Word;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class TextService {

    private final WordService wordService;

    public TextService(WordService wordService) {
        this.wordService = wordService;
    }

    // Параметров может стать больше, поэтому в будущем можно создать класс TypingSettings
    public String getRandomStringSequenceFromTopDictionary(int limit, int count, DictionaryType dictionaryType) {
        List<Word> words = wordService.getTopWordsFromDictionary(dictionaryType, limit);
        List<Word> randomWords = selectRandomWords(words, count);
        return this.joinWords(randomWords);
    }

    public String getRandomStringSequenceFromDictionary(int count, DictionaryType dictionaryType) {
        List<Word> words = wordService.getAllWordsFromDictionary(dictionaryType);
        List<Word> randomWords = selectRandomWords(words, count);
        return this.joinWords(randomWords);
    }

    private List<Word> selectRandomWords(List<Word> words, int count) {
        if (words == null || words.isEmpty()) {
            throw new IllegalArgumentException("Word list must not be null or empty");
        }

        ThreadLocalRandom random = ThreadLocalRandom.current();
        List<Word> randomWords = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            randomWords.add(words.get(random.nextInt(words.size())));
        }

        return randomWords;
    }

    private String joinWords(List<Word> words) {
        StringBuilder builder = new StringBuilder();

        for (Word word : words) {
            builder.append(word.getWord()).append(" ");
        }

        return builder.toString().trim();
    }
}
