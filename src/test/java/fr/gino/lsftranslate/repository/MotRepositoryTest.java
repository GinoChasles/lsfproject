//package fr.gino.lsftranslate.repository;
//
//import fr.gino.lsftranslate.model.Mot;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//@ExtendWith(SpringExtension.class)
//@DataJpaTest
//
//public class MotRepositoryTest {
//
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private MotRepository repository;
//
//
//    @DisplayName("find mot by searchText")
//    @Test
//
//    public void findAll(Pageable pageable, String searchText) {
//
//        //GIVEN
//        searchText = "testable";
//
//        Mot mot1 = new Mot(1, "test", "tester", null, 4, 1, "tset", null, null, null, null);
//        entityManager.persist(mot1);
//
//        Mot mot2 = new Mot(2, "testable", "tester", null, 8, 3, "elbatset", null, null, null, null);
//        entityManager.persist(mot2);
//
//        //WHEN
//        Page<Mot> motsSelect = repository.findMotsByOrthoOrLemme(pageable, searchText);
//
//        //THEN
//        assertThat(motsSelect.getNumberOfElements()).isEqualTo(2);
//    }
//}
