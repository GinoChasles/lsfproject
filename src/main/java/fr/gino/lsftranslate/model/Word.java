package fr.gino.lsftranslate.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "Word", schema= "lsfproject")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Integer id;

    @NotBlank(message="spelling is necessary")
    @Pattern(regexp = "([a-z]+)", message = "spelling only has minuscules letters")
    @Column(name= "spelling", nullable = false)
    private String spelling;

    @NotBlank(message = "lemma is necessary")
    @Column(name="lemma", nullable = false)
    private String lemma;

    @Column(name="infover")
    private String infover;

    @Positive
    @Column(name="nbletters", nullable = false)
    private int nbletters;

    @Positive
    @Column(name="nbsyll", nullable = false)
    private int nbsyll;

    @NotBlank(message = "reverspel is necessary")
    @Column(name="reverspel", nullable = false)
    private String reverspel;

    @ManyToOne
    @JoinColumn(name="catgram", nullable = false)
    private CatGram catgram;

    @ManyToOne
    @JoinColumn(name="gender", nullable = true)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name="number", nullable = true)
    private Number number;

    @OneToOne
    @JoinColumn(name="video", referencedColumnName = "id")
    private Video video;

}
