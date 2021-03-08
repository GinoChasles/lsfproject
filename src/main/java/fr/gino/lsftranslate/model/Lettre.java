package fr.gino.lsftranslate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name= "letter", schema= "lsfproject")
@Getter
@Setter
public class Lettre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="letter")
    private String nom;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "signe_id", referencedColumnName = "id")
    private Signe signe;
}
