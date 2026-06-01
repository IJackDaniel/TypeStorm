package ru.dada.typestorm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dada.typestorm.model.RussianWord;
import ru.dada.typestorm.repository.RussianWordRepository;

@Service
public class RussianWordService extends WordService<RussianWord> {

    @Autowired
    public RussianWordService(RussianWordRepository repository) {
        super(repository);
    }
}
