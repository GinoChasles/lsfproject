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

INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ('a', '1');
INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ('b', '2');
INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ('c', '3');
INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ('d', '4');
INSERT INTO `lsfproject2`.`lettre` ( `lettre`, `signe_id`) VALUES ( 'e', '5');
INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ('f', '6');
INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ('g', '7');
INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ('h', '8');
INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ('i', '9');
INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ('j', '10');
INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ('k', '11');
INSERT INTO `lsfproject2`.`lettre` ( `lettre`, `signe_id`) VALUES ( 'l', '12');
INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ('m', '13');
INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ('n', '14');
INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ('o', '15');
INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ('p', '16');
INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ('q', '17');
INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ( 'r', '18');
INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ( 's', '19');
INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ('t', '20');
INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ('u', '21');
INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ('v', '22');
INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ('w', '23');
INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ('x', '24');
INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ('y', '25');
INSERT INTO `lsfproject2`.`lettre` (`lettre`, `signe_id`) VALUES ('z', '26');



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
# correctif column video reset à null (soucis coté front quand valeur défini)
UPDATE `lsfproject`.`mot` SET `video` = NULL WHERE (`id` = '1');