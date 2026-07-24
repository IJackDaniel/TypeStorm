package ru.dada.typestorm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dada.typestorm.model.DictionaryType;
import ru.dada.typestorm.model.Word;

import java.util.List;

/**
 * Репозиторий работы с БД (таблица words)
 */
@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

    /**
     * Получение топа слов по частоте из определённого словаря
     * @param dictionaryType тип словаря
     * @param maxRank частота
     * @return топ maxRank слов из словаря dictionaryTyoe
     */
    List<Word> findByDictionaryTypeAndFrequencyRankLessThanEqual(
            DictionaryType dictionaryType,
            Integer maxRank);

    /**
     * Получение всех слов из словаря
     * @param dictionaryType тип словаря
     * @return все слова одного словаря
     */
    List<Word> findByDictionaryType(DictionaryType dictionaryType);
}
