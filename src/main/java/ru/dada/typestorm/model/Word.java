package ru.dada.typestorm.model;

import jakarta.persistence.*;

/**
 * Entity класс для одного слова
 */
@Entity
@Table(name = "words")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "word", nullable = false, length = 100)
    private String word;

    @Column(name = "frequency_rank", nullable = false)
    private Integer frequencyRank;

    @Enumerated(EnumType.STRING)
    @Column(name = "dictionary_type", nullable = false)
    private DictionaryType dictionaryType;

    public String getWord() {
        return word;
    }

    public Integer getFrequencyRank() {
        return frequencyRank;
    }

    public void setFrequencyRank(Integer frequencyRank) {
        this.frequencyRank = frequencyRank;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
