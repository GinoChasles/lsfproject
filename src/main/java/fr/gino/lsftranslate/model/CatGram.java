package fr.gino.lsftranslate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="catgram", schema="lsfproject")
public class CatGram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "catgram", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Word> words;

    public CatGram(Integer id, String name, List<Word> words) {
        this.id = id;
        this.name = name;
        this.words = words;
    }

    public CatGram(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CatGram() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
