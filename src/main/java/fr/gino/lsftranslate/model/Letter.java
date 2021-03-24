package fr.gino.lsftranslate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name= "letter", schema= "lsfproject")
@Getter
@Setter
public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="letter")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "sign_id", referencedColumnName = "id")
    private Sign sign;
}
