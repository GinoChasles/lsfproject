package fr.gino.lsftranslate.model;


import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name= "Word", schema= "lsfproject")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Integer id;

    @NotBlank(message="spelling is necessary")
    @Pattern(regexp = "([a-z]+)", message = "spelling only has minuscules letters")
    @Column(name= "spelling", nullable = false)
    private String spelling;

    @NotBlank(message = "lemma is necessary")
    @Column(name="lemma", nullable = false)
    private String lemma;

    @Column(name="infover")
    private String infover;

    @Positive
    @Column(name="nbletters", nullable = false)
    private int nbletters;

    @Positive
    @Column(name="nbsyll", nullable = false)
    private int nbsyll;

    @NotBlank(message = "reverspel is necessary")
    @Column(name="reverspel", nullable = false)
    private String reverspel;



    @ManyToOne
    @JoinColumn(name="catgram", nullable = false)
    private CatGram catgram;

    @ManyToOne
    @JoinColumn(name="gender", nullable = true)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name="number", nullable = true)
    private Number number;

    @OneToOne
    @JoinColumn(name="video", referencedColumnName = "id")
    private Video video;

    public Word(Integer id, String spelling, String lemma, String infover, int nbletters, int nbsyll, String reverspel, CatGram catgram, Gender gender, Number number, Video video) {
        this.id = id;
        this.spelling = spelling;
        this.lemma = lemma;
        this.infover = infover;
        this.nbletters = nbletters;
        this.nbsyll = nbsyll;
        this.reverspel = reverspel;
        this.catgram = catgram;
        this.gender = gender;
        this.number = number;
        this.video = video;
    }

    public Word() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }

    public String getLemma() {
        return lemma;
    }

    public void setLemma(String lemma) {
        this.lemma = lemma;
    }

    public String getInfover() {
        return infover;
    }

    public void setInfover(String infover) {
        this.infover = infover;
    }

    public int getNbletters() {
        return nbletters;
    }

    public void setNbletters(int nbletters) {
        this.nbletters = nbletters;
    }

    public int getNbsyll() {
        return nbsyll;
    }

    public void setNbsyll(int nbsyll) {
        this.nbsyll = nbsyll;
    }

    public String getReverspel() {
        return reverspel;
    }

    public void setReverspel(String reverspel) {
        this.reverspel = reverspel;
    }

    public CatGram getCatgram() {
        return catgram;
    }

    public void setCatgram(CatGram catgram) {
        this.catgram = catgram;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}
