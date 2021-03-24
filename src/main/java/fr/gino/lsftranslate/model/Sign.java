package fr.gino.lsftranslate.model;

import javax.persistence.*;

@Entity
@Table(name="Sign", schema = "lsfproject")
public class Sign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="img")
    private String url;

    @OneToOne(mappedBy = "sign")
    private Letter letter;

    public Sign() {}

    public Sign(Integer id, String url, Letter letter) {
        this.id = id;
        this.url = url;
        this.letter = letter;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
