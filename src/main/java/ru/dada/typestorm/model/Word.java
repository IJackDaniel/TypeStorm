package ru.dada.typestorm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "words")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "word", nullable = false, length = 100)
    private String word;

    @Column(name = "frequency_rank", nullable = false)
    private Long frequencyRank;

    @Enumerated(EnumType.STRING)
    @Column(name = "dictionary_type", nullable = false)
    private DictionaryType dictionaryType;

    public String getWord() {
        return word;
    }

    public Long getFrequencyRank() {
        return frequencyRank;
    }

    public void setFrequencyRank(Long frequencyRank) {
        this.frequencyRank = frequencyRank;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
