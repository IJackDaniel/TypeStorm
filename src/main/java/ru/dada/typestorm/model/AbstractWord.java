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
}
