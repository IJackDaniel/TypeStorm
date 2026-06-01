package ru.dada.typestorm.model;

import jakarta.persistence.*;

@MappedSuperclass
public class AbstractWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "word", nullable = false, length = 100)
    private String word;

    @Column(name = "frequency_rank", nullable = false)
    private Long frequencyRank;
    
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
