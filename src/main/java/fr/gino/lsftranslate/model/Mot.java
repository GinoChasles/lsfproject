package fr.gino.lsftranslate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name= "mot", schema= "lsfproject")
@Getter
@Setter
public class Mot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Integer id;

    @Column(name= "ortho", nullable = false)
    private String ortho;

    @Column(name="lemme", nullable = false)
    private String lemme;

    @Column(name="infover")
    private String infover;

    @Column(name="nblettres", nullable = false)
    private int nblettres;

    @Column(name="nbsyll", nullable = false)
    private int nbsyll;

    @Column(name="orthrenv", nullable = false)
    private String orthrenv;



    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="video", referencedColumnName = "url")
    private Video video;

    @ManyToOne
    @JoinColumn(name="catgram", nullable = false)
    private CatGram catgram;

    @ManyToOne
    @JoinColumn(name="genre", nullable = true)
    private Genre genre;

    @ManyToOne
    @JoinColumn(name="nombre", nullable = true)
    private Nombre nombre;


}
