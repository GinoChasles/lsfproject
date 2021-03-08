package fr.gino.lsftranslate.repository;

import fr.gino.lsftranslate.model.CatGram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatGramRepository extends JpaRepository<CatGram, Integer> {
}
