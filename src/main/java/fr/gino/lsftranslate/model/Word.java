package fr.gino.lsftranslate.model;

import javax.persistence.*;

@Entity
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String ortho;

    private String lemme;

    private String gram;

    private String genre;

    private String nombre;

    private String infover;

    private int nblettres;

    private int nbsyll;

    private String orthrenv;

}
