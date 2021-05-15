INSERT INTO lsfproject.gender (name)
VALUES ('m'),('f');


INSERT INTO lsfproject.number (name)
VALUES  ('s'),('p');

INSERT INTO lsfproject.catGram (name)
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

INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ('a', '1');
INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ('b', '2');
INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ('c', '3');
INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ('d', '4');
INSERT INTO `lsfproject2`.`letter` ( `letter`, `signe_id`) VALUES ( 'e', '5');
INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ('f', '6');
INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ('g', '7');
INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ('h', '8');
INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ('i', '9');
INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ('j', '10');
INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ('k', '11');
INSERT INTO `lsfproject2`.`letter` ( `letter`, `signe_id`) VALUES ( 'l', '12');
INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ('m', '13');
INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ('n', '14');
INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ('o', '15');
INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ('p', '16');
INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ('q', '17');
INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ( 'r', '18');
INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ( 's', '19');
INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ('t', '20');
INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ('u', '21');
INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ('v', '22');
INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ('w', '23');
INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ('x', '24');
INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ('y', '25');
INSERT INTO `lsfproject2`.`letter` (`letter`, `signe_id`) VALUES ('z', '26');



/* transforme les noms de la catégorie grammatical
  dans la table word par id associé dans la table catgram */
UPDATE word
    INNER JOIN catgram
ON word.catgram = catgram.nom
    SET word.catgram = catgram.id
WHERE catgram.id IS NOT NULL;
/* transforme les noms des genres
  dans la table word par id associé dans la table gender */
UPDATE word
    INNER JOIN gender
ON word.gender = gender.nom
    SET word.gender = gender.id
WHERE gender.id IS NOT NULL;
/* transforme les noms de nombre
  dans la table word par id associé dans la table number */
UPDATE word
    INNER JOIN nombre
ON word.nombre = nombre.nom
    SET word.nombre = nombre.id
WHERE nombre.id IS NOT NULL;

/* affiche tout les éléments de la table word dont l'attribut catgram=15 (=préposition)
  avec la correspondence de l'id de la table catgram*/
SELECT * FROM lsfproject.word
INNER JOIN catgram ON word.catgram= catgram.id
WHERE word.catgram=15;


/*ajout foreign key entre la table word et gender*/
ALTER TABLE `lsfproject`.`word`
    ADD CONSTRAINT `id_genre`
        FOREIGN KEY (`gender`)
            REFERENCES `lsfproject`.`gender` (`id`);


# correctif column video reset à null (soucis coté front quand valeur défini)
UPDATE `lsfproject`.`word` SET `video` = NULL WHERE (`id` = '1');