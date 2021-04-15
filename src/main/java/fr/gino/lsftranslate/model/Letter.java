package fr.gino.lsftranslate.model;

import javax.persistence.*;

@Entity
@Table(name= "letter", schema= "lsfproject")
public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="letter")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "sign_id", referencedColumnName = "id")
    private Sign sign;

    public Letter() {
    }

    public Letter(Integer id, String name, Sign sign) {
        this.id = id;
        this.name = name;
        this.sign = sign;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sign getSign() {
        return sign;
    }

    public void setSign(Sign sign) {
        this.sign = sign;
    }
}
