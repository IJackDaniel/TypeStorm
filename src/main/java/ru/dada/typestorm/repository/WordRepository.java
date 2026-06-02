package ru.dada.typestorm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.dada.typestorm.model.Word;

import java.util.List;

@NoRepositoryBean
public interface AbstractWordRepository<T extends Word> extends JpaRepository<T, Long> {

    List<T> findByFrequencyRankLessThanEqual(Integer maxRank);

}
