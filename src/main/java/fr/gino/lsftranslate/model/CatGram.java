package fr.gino.lsftranslate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="catgram", schema="lsfproject")
public class CatGram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nom", nullable = false)
    private String nom;

    @OneToMany(mappedBy = "catgram", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Mot> mots;
}
