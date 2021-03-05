INSERT INTO genre (nom)
VALUES (NULL,'m'),('f');


INSERT INTO nombre (nom)
VALUES (NULL, 'p'),('s');

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
('ART:inf'),
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



/*transforme les noms de la catégorie gramaticale dans la table mot2 en id associé dans la table catgram */

UPDATE mot2
    INNER JOIN catgram
ON mot2.catgram = catgram.nom
    SET mot2.catgram = catgram.id
WHERE catgram.id IS NOT NULL;

UPDATE mot2
    INNER JOIN genre
ON mot2.genre = genre.nom
    SET mot2.genre = genre.id
WHERE genre.id IS NOT NULL;

UPDATE mot2
    INNER JOIN nombre
ON mot2.nombre = nombre.nom
    SET mot2.nombre = nombre.id
WHERE nombre.id IS NOT NULL;


