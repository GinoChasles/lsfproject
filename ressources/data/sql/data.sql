INSERT INTO lsfproject.genre (nom)
VALUES ('m'),('f');


INSERT INTO nombre (nom)
VALUES  ('s'),('p');

INSERT INTO catGram (nom)
VALUES
('ADJ'),
('ADJ:dem'),
('ADJ:ind'),
('ADJ:int'),
('ADJ:num'),
('ADJ:pos'),
('ADV'),
('ART:def'),
('ART:ind'),
('AUX'),
('CON'),
('LIA'),
('NOM'),
('ONO'),
('PRE'),
('PRO:dem'),
('PRO:ind'),
('PRO:int'),
('PRO:per'),
('PRO:pos'),
('PRO:rel'),
('VER');

INSERT INTO signe (img)
VALUES ('../img/test/bidon'),('../img/test/bidon2');

INSERT INTO letter (letter, signe_id) VALUES ('a',1), ('b',2);


/*transforme les noms de la catégorie gramaticale dans la table mot en id associé dans la table catgram */

UPDATE mot
    INNER JOIN catgram
ON mot.catgram = catgram.nom
    SET mot.catgram = catgram.id
WHERE catgram.id IS NOT NULL;

UPDATE mot
    INNER JOIN genre
ON mot.genre = genre.nom
    SET mot.genre = genre.id
WHERE genre.id IS NOT NULL;

UPDATE mot
    INNER JOIN nombre
ON mot.nombre = nombre.nom
    SET mot.nombre = nombre.id
WHERE nombre.id IS NOT NULL;




/*ajout foreign key entre la table mot et genre*/
ALTER TABLE `lsfproject`.`mot`
    ADD CONSTRAINT `id_genre`
        FOREIGN KEY (`genre`)
            REFERENCES `lsfproject`.`genre` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

/*affiche les éléments de mot avec la correspondance de l'id de catgram*/
SELECT * FROM lsfproject.mot
                  INNER JOIN catgram ON mot.catgram= catgram.id;

