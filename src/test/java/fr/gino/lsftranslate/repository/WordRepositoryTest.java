package fr.gino.lsftranslate.repository;

import fr.gino.lsftranslate.model.CatGram;
import fr.gino.lsftranslate.model.Word;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WordRepositoryTest {
@Autowired
private TestEntityManager testEntityManager;
@Autowired
private WordRepository repository;

    @DisplayName("find all word by pageable")
    @Test
    void findAll(Pageable pageable){

        //given
        Pageable wordPage = PageRequest.of(0,20);
        CatGram catGramWord1 = new CatGram(1, "ver");

        ArrayList<Word> words = new ArrayList<Word>();

    for(int i = 0; i<20 ; i++) {
        Word word = new Word(i,"tester"+i, "test",null,6,2,"retset",  catGramWord1,null,null,null);
        words.add(word);
    }
    testEntityManager.persist(words);
    testEntityManager.persist(catGramWord1);
    testEntityManager.persist(wordPage);

    //when
        Page<Word> wordList = repository.findAll(wordPage);

        //then
//        Mockito.when(this.repository.findAll(wordPage)).thenReturn(wordList);
        assertEquals(words, wordList);
    }

    @Test
    void findAllWordsBySpellingOrLemma() {
    }
}