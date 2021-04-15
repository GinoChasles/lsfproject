package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.model.CatGram;
import fr.gino.lsftranslate.model.Word;
import fr.gino.lsftranslate.repository.WordRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WordServiceImplTest {
    @Mock
    WordRepository repository;

    @InjectMocks
    WordService service = new WordServiceImpl();

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById() {
    }


    @Test
    void findWordByGenderId() {
    }

    @Test
    void findAll(Pageable pageable) {
        CatGram catGramWord1 = new CatGram(1, "ver");
        List<Word> wordList = new ArrayList<>();
        wordList.add(new Word(1,"tester", "test",null,6,2,"retset",  catGramWord1,null,null,null));
        wordList.add(new Word(2,"tester", "test",null,6,2,"retset",  catGramWord1,null,null,null));
        wordList.add(new Word(3,"tester", "test",null,6,2,"retset",  catGramWord1,null,null,null));
        Page<Word> wordPage = new PageImpl<>(wordList);
    when(repository.findAll((Pageable) Matchers.any(Pageable.class))).thenReturn(wordPage);
//        when(repository.findAll(pageable)).thenReturn(wordPage);
    Page<Word> outputWords = service.findAll(pageable);
    assertThat(outputWords.getSize()).isEqualTo(3);
    }

    @Test
    void findAllWordsBySpellingOrLemma() {
    }
}