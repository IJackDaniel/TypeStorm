package ru.dada.typestorm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dada.typestorm.model.DictionaryType;
import ru.dada.typestorm.model.Word;

import java.util.*;

@Component
public class TextService {
    @Autowired
    WordService service;

    public String getRandomStringSequenceFromTopDictionary(int limit, int count, DictionaryType dictionaryType) {
        List<Word> words = service.getTopWordsFromDictionary(dictionaryType, limit);
        List<Word> randomWords = this.getRandomValuesWithCountLimit(words, count);
        return this.WordsAsString(randomWords);
    }

    public String getRandomStringSequenceFromDictionary(int count, DictionaryType dictionaryType) {
        List<Word> words = service.getAllWordsFromDictionary(dictionaryType);
        List<Word> randomWords = this.getRandomValuesWithCountLimit(words, count);
        return this.WordsAsString(randomWords);
    }

    private List<Word> getRandomValuesWithCountLimit(List<Word> words, int count) {
        Random random = new Random();
        List<Word> randomWords = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            randomWords.add(words.get(random.nextInt(words.size())));
        }

        return randomWords;
    }

    private String WordsAsString(List<Word> words) {
        StringBuilder builder = new StringBuilder();

        for (Word word : words) {
            builder.append(word.getWord()).append(" ");
        }

        return builder.toString().trim();
    }
}
