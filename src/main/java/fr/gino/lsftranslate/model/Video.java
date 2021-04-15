package fr.gino.lsftranslate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="video", schema="lsfproject")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="url", nullable = true)
    private String url;

    @OneToOne(mappedBy = "video")
    @JsonBackReference
    private Word word;

    public Video() {
    }

    public Video(Integer id, String url, Word word) {
        this.id = id;
        this.url = url;
        this.word = word;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }
}
