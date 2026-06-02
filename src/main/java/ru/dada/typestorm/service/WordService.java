package ru.dada.typestorm.service;

import org.springframework.stereotype.Service;
import ru.dada.typestorm.model.DictionaryType;
import ru.dada.typestorm.model.Word;
import ru.dada.typestorm.repository.WordRepository;

import java.util.List;

@Service
public class WordService {

    private final WordRepository repository;

    protected WordService(WordRepository repository) {
        this.repository = repository;
    }

    public List<Word> getTopWordsFromDictionary(DictionaryType dictionaryType, int limit) {
        return repository.findByDictionaryTypeAndFrequencyRankLessThanEqual(
                dictionaryType, limit);
    }

    public List<Word> getAllWordsFromDictionary(DictionaryType dictionaryType) {
        return repository.findByDictionaryType(dictionaryType);
    }
}
