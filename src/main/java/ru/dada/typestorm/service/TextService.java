package ru.dada.typestorm.service;

import org.springframework.stereotype.Component;
import ru.dada.typestorm.model.DictionaryType;
import ru.dada.typestorm.model.Word;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class TextService {

    private final WordService service;

    public TextService(WordService service) {
        this.service = service;
    }

    public String getRandomStringSequenceFromTopDictionary(int limit, int count, DictionaryType dictionaryType) {
        List<Word> words = service.getTopWordsFromDictionary(dictionaryType, limit);
        List<Word> randomWords = this.selectRandomWords(words, count);
        return this.joinWords(randomWords);
    }

    public String getRandomStringSequenceFromDictionary(int count, DictionaryType dictionaryType) {
        List<Word> words = service.getAllWordsFromDictionary(dictionaryType);
        List<Word> randomWords = this.selectRandomWords(words, count);
        return this.joinWords(randomWords);
    }

    private List<Word> selectRandomWords(List<Word> words, int count) {
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
