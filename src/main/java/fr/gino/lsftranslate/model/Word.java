package fr.gino.lsftranslate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String ortho;

    private String lemme;

    private String catgram;

    private String genre;

    private String nombre;

    private String infover;

    private int nblettres;

    private int nbsyll;

    private String orthrenv;

}
