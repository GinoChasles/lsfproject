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
    private long id;

    @Column(name= "ortho", nullable = false)
    private String ortho;

    @Column(name="lemme", nullable = false)
    private String lemme;

    private String catgram;

    private String genre;

    private String nombre;

    @Column(name="infover")
    private String infover;

    @Column(name="nblettres", nullable = false)
    private int nblettres;

    @Column(name="nbsyll", nullable = false)
    private int nbsyll;

    @Column(name="orthrenv", nullable = false)
    private String orthrenv;

}
