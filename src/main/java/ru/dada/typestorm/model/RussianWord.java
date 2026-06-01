package ru.dada.typestorm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "words_ru")
public class RussianWord extends AbstractWord{
}
