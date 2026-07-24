package ru.dada.typestorm.service;

import org.springframework.stereotype.Service;
import ru.dada.typestorm.model.DictionaryType;
import ru.dada.typestorm.model.Word;
import ru.dada.typestorm.repository.WordRepository;

import java.util.List;

/**
 * Сервис работы со словами
 */
@Service
public class WordService {

    private final WordRepository repository;

    /**
     * Создаёт новый объект WordService с заданным repository
     * @param repository репозиторий работы с БД
     */
    public WordService(WordRepository repository) {
        this.repository = repository;
    }

    /**
     * Получить топ слов по частоте из заданного словаря
     * @param dictionaryType тип словаря
     * @param limit ограничение частоты (топ-100, топ-500 и т.д.)
     * @return список слов с заданной частотой
     */
    public List<Word> getTopWordsFromDictionary(DictionaryType dictionaryType, int limit) {
        return repository.findByDictionaryTypeAndFrequencyRankLessThanEqual(
                dictionaryType, limit);
    }

    /**
     * Получить все слова из заданного словаря. Используется в основном для словарей,
     * где нет необходимости сортировать слова по частоте.
     * @param dictionaryType тип словаря
     * @return список всех слов
     */
    public List<Word> getAllWordsFromDictionary(DictionaryType dictionaryType) {
        return repository.findByDictionaryType(dictionaryType);
    }
}
