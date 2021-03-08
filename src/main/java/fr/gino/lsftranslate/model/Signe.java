package fr.gino.lsftranslate.model;

import javax.persistence.*;

@Entity
@Table(name="Signe", schema = "lsfproject")
public class Signe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="img")
    private String url;

    @OneToOne(mappedBy = "signe")
    private Lettre lettre;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
