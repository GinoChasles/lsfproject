package fr.gino.lsftranslate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="genre", schema="lsfproject")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nom")
    private String nom;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Mot> mots;
}
