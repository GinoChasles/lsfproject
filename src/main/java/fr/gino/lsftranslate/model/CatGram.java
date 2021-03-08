package fr.gino.lsftranslate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="catgram", schema="lsfproject")
public class CatGram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nom", nullable = false)
    private String nom;

    @OneToMany(mappedBy = "catgram")
    private Set<Mot> mot;

}
