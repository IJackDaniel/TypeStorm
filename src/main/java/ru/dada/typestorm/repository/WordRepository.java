package ru.dada.typestorm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dada.typestorm.model.DictionaryType;
import ru.dada.typestorm.model.Word;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

    List<Word> findByDictionaryTypeAndFrequencyRankLessThanEqual(
            DictionaryType dictionaryType,
            Integer maxRank);

    List<Word> findByDictionaryType(DictionaryType dictionaryType);
}
