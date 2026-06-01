package ru.dada.typestorm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dada.typestorm.model.EnglishWord;
import ru.dada.typestorm.repository.EnglishWordRepository;

@Service
public class EnglishWordService extends WordService<EnglishWord> {

    @Autowired
    public EnglishWordService(EnglishWordRepository repository) {
        super(repository);
    }
}
