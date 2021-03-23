package fr.gino.lsftranslate.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name= "mot", schema= "lsfproject")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Integer id;

    @NotBlank(message="ortho is necessary")
    @Pattern(regexp = "([a-z]+)", message = "ortho only has minuscules letters")
    @Column(name= "ortho", nullable = false)
    private String ortho;

    @NotBlank(message = "lemme is necessary")
    @Column(name="lemme", nullable = false)
    private String lemme;

    @Column(name="infover")
    private String infover;

    @Positive
    @Column(name="nblettres", nullable = false)
    private int nblettres;

    @Positive
    @Column(name="nbsyll", nullable = false)
    private int nbsyll;

    @NotBlank(message = "orthrenv is necessary")
    @Column(name="orthrenv", nullable = false)
    private String orthrenv;



    @OneToOne
    @JoinColumn(name="video", referencedColumnName = "id")
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
