package fr.gino.lsftranslate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="video", schema="lsfproject")
@Getter
@Setter
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="url", nullable = true)
    private String url;
/*
    @OneToOne(mappedBy = "video")
    private Mot mot;

 */
}
