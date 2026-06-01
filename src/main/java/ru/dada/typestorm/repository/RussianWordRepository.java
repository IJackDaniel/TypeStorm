package ru.dada.typestorm.repository;

import org.springframework.stereotype.Repository;
import ru.dada.typestorm.model.RussianWord;

@Repository
public interface RussianWordRepository extends AbstractWordRepository<RussianWord> {
}
