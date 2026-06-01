package ru.dada.typestorm.repository;

import org.springframework.stereotype.Repository;
import ru.dada.typestorm.model.EnglishWord;

@Repository
public interface EnglishWordRepository extends AbstractWordRepository<EnglishWord> {
}
