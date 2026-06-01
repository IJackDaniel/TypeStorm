package ru.dada.typestorm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dada.typestorm.model.AbstractWord;
import ru.dada.typestorm.repository.AbstractWordRepository;

import java.util.List;

@Service
public class WordService<T extends AbstractWord> {

    private final AbstractWordRepository<T> repository;

    @Autowired
    public WordService(AbstractWordRepository<T> repository) {
        this.repository = repository;
    }

    public List<T> getTopWords(int limit) {
        return repository.findByFrequencyRankLessThanEqual(limit);
    }
}
