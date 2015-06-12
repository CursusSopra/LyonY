------------------------------------------------------------------------------
-- SUPPRESSION DES TABLES

DROP TABLE IF EXISTS utilisateurs CASCADE;

DROP TABLE IF EXISTS avis CASCADE;

DROP TABLE IF EXISTS liens CASCADE;

DROP TABLE IF EXISTS lieux CASCADE;

DROP TABLE IF EXISTS photos CASCADE;

DROP TABLE IF EXISTS quartiers CASCADE;

DROP TABLE IF EXISTS adresses CASCADE;

DROP TABLE IF EXISTS visites CASCADE;

DROP TABLE IF EXISTS typevisites CASCADE;

DROP TABLE IF EXISTS monuments CASCADE;

DROP TABLE IF EXISTS placeetparcs CASCADE;

DROP TABLE IF EXISTS sorties CASCADE;

DROP TABLE IF EXISTS horaires CASCADE;

DROP TABLE IF EXISTS plagehoraires CASCADE;

DROP TABLE IF EXISTS ouvertures CASCADE;

DROP TABLE IF EXISTS ambiances CASCADE;

DROP TABLE IF EXISTS bars CASCADE;

DROP TABLE IF EXISTS nightclubs CASCADE;

DROP TABLE IF EXISTS restaurants CASCADE;

------------------------------------------------------------------------------
-- CREATION DES TABLES

CREATE TABLE utilisateurs ( 
	idutilisateur        serial  NOT NULL,
	pseudo               varchar(20)  NOT NULL,
	datenaissance        date  NOT NULL,
	sexe                 char(1)  NOT NULL,
	email                varchar(30)  NOT NULL,
	avatar               varchar(30)  ,
	idadresse            integer  NOT NULL,
	motdepasse           varchar(30)  NOT NULL,
	CONSTRAINT pk_utilisateurs PRIMARY KEY ( idutilisateur ),
	CONSTRAINT ct_unique_pseudo UNIQUE ( pseudo )  
 );

CREATE TABLE avis ( 
	idavis               serial  NOT NULL,
	idlieu               integer  NOT NULL,
	note                 integer  NOT NULL,
	message              text  ,
	idutilisateur        serial  NOT NULL,
	CONSTRAINT pk_avis PRIMARY KEY ( idavis )   
 );

CREATE TABLE liens ( 
	idlien               serial  NOT NULL,
	liblien              varchar(20)  ,
	idlieu               integer  NOT NULL,
	url                  varchar(30)  NOT NULL,
	CONSTRAINT pk_liens PRIMARY KEY ( idlien )
 );

CREATE TABLE lieux ( 
	idlieu               serial  NOT NULL,
	nom                  varchar(40) NOT NULL ,
	idadresse            integer  NOT NULL ,
	description          text  ,
	accessibilite        text  ,
	CONSTRAINT pk_lieux PRIMARY KEY ( idlieu ) 
 );

CREATE TABLE photos ( 
	idphoto              serial  NOT NULL,
	libphoto             varchar(20) NOT NULL ,
	idlieu               integer  NOT NULL,
	CONSTRAINT pk_photos PRIMARY KEY ( idphoto )
 );

CREATE TABLE quartiers ( 
	idquartier           serial  NOT NULL,
	nom                  varchar(30)  NOT NULL,
	budgetmoyen          integer  ,
	distancecentreville  integer  ,
	CONSTRAINT pk_quartiers PRIMARY KEY ( idquartier )
 );

CREATE TABLE adresses ( 
	idadresse            serial  NOT NULL,
	numero               integer  ,
	voie                 varchar(30)  ,
	codepostal           char(5)  NOT NULL,
	ville                varchar(30)  NOT NULL,
	idquartier           integer  NOT NULL,
	CONSTRAINT pk_adresses PRIMARY KEY ( idadresse )  
 );

CREATE TABLE visites ( 
	idvisite             serial  NOT NULL,
	idlieu               integer  NOT NULL,
	idtypevisite         integer ,
	CONSTRAINT pk_visites PRIMARY KEY ( idvisite ) 
 );

CREATE TABLE typevisites ( 
	idtypevisite         serial  NOT NULL,
	libtypevisite        varchar(20)  NOT NULL,
	typev                char(1)  NOT NULL,
	CONSTRAINT pk_typevisites PRIMARY KEY ( idtypevisite )
 );

CREATE TABLE monuments ( 
	idmonument           serial  NOT NULL,
	idvisite             integer  NOT NULL,
	anneeconstruction    integer  ,
	anneefinconstruction integer  ,
	CONSTRAINT pk_monuments PRIMARY KEY ( idmonument )    
 );

CREATE TABLE placeetparcs ( 
	idplaceetparc        serial  NOT NULL,
	idvisite             integer  NOT NULL,
	CONSTRAINT pk_placeetparcs PRIMARY KEY ( idplaceetparc )   
 );

CREATE TABLE sorties ( 
	idsortie             serial  NOT NULL,
	idlieu               integer  NOT NULL,
	prixmax              integer  ,
	prixmin              integer  ,
	idambiance           integer  ,
	CONSTRAINT pk_sorties PRIMARY KEY ( idsortie ) 
 );

CREATE TABLE horaires ( 
	idhoraire            serial  NOT NULL,
	jour                 varchar(10)  NOT NULL,
	idplagehoraire       integer  ,
	CONSTRAINT pk_horaires PRIMARY KEY ( idhoraire )   
 );

CREATE TABLE plagehoraires ( 
	idplagehoraire       serial  NOT NULL,
	heuredebut           time  NOT NULL,
	heurefin             time  NOT NULL,
	CONSTRAINT pk_plagehoraires PRIMARY KEY ( idplagehoraire )
 );

CREATE TABLE ouvertures ( 
	idhoraire            integer  NOT NULL,
	idsortie             integer  NOT NULL,
	CONSTRAINT idx_ouvertures PRIMARY KEY ( idsortie, idhoraire )  
 );

CREATE TABLE ambiances ( 
	idambiance           serial  NOT NULL,
	libambiance          varchar(20)  NOT NULL,
	types                char(1)  NOT NULL,
	CONSTRAINT pk_ambiances PRIMARY KEY ( idambiance )
 );

CREATE TABLE bars ( 
	idbar                serial  NOT NULL,
	idsortie             integer  NOT NULL ,
	happyhour            integer  ,
	CONSTRAINT pk_bars PRIMARY KEY ( idbar )  
 );

CREATE TABLE nightclubs ( 
	idnightclub          serial  NOT NULL,
	idsortie             integer  NOT NULL,
	CONSTRAINT pk_nightclubs PRIMARY KEY ( idnightclub )
 );

CREATE TABLE restaurants ( 
	idrestaurant         serial  NOT NULL,
	idsortie             integer  NOT NULL,
	reservation          bool  ,
	aemporter            bool  ,
	CONSTRAINT pk_restaurants PRIMARY KEY ( idrestaurant ) 
 );

------------------------------------------------------------------------------
-- AJOUT DES FOREIGN KEYS

ALTER TABLE utilisateurs
	ADD CONSTRAINT fk_utilisateurs_adresses FOREIGN KEY ( idadresse ) REFERENCES adresses( idadresse ) ;

ALTER TABLE avis
	ADD CONSTRAINT fk_avis_lieux FOREIGN KEY ( idlieu ) REFERENCES lieux( idlieu ) ,
	ADD CONSTRAINT fk_avis_utilisateurs FOREIGN KEY ( idutilisateur ) REFERENCES utilisateurs( idutilisateur ) ;

ALTER TABLE lieux
	ADD CONSTRAINT fk_lieux_adresses FOREIGN KEY ( idadresse ) REFERENCES adresses( idadresse ) ;

ALTER TABLE liens
	ADD CONSTRAINT fk_liens_lieux FOREIGN KEY ( idlieu ) REFERENCES lieux( idlieu ) ;

ALTER TABLE photos
	ADD CONSTRAINT fk_photos_lieux FOREIGN KEY ( idlieu ) REFERENCES lieux( idlieu ) ;

ALTER TABLE adresses
	ADD CONSTRAINT fk_adresses_quartiers FOREIGN KEY ( idquartier ) REFERENCES quartiers( idquartier ) ;

ALTER TABLE monuments
	ADD CONSTRAINT fk_monuments_visites FOREIGN KEY ( idvisite ) REFERENCES visites( idvisite ) ;

ALTER TABLE placeetparcs
	ADD CONSTRAINT fk_placeetparcs_visites FOREIGN KEY ( idvisite ) REFERENCES visites( idvisite ) ;

ALTER TABLE visites
	ADD CONSTRAINT fk_visites_lieux FOREIGN KEY ( idlieu ) REFERENCES lieux( idlieu )  ,
	ADD CONSTRAINT fk_visites_typevisites FOREIGN KEY ( idtypevisite ) REFERENCES typevisites( idtypevisite ) ;
	
ALTER TABLE sorties
	ADD CONSTRAINT fk_sorties_lieux FOREIGN KEY ( idlieu ) REFERENCES lieux( idlieu )  ,
	ADD CONSTRAINT fk_sorties_ambiances FOREIGN KEY ( idambiance ) REFERENCES ambiances( idambiance ) ;

ALTER TABLE horaires
	ADD CONSTRAINT fk_horaires_plagehoraires FOREIGN KEY ( idplagehoraire ) REFERENCES plagehoraires( idplagehoraire ) ;

ALTER TABLE ouvertures
	ADD CONSTRAINT fk_ouvertures_horaires FOREIGN KEY ( idhoraire ) REFERENCES horaires( idhoraire ) ,
	ADD CONSTRAINT fk_ouvertures_sorties FOREIGN KEY ( idsortie ) REFERENCES sorties( idsortie ) ; 

ALTER TABLE bars
	ADD CONSTRAINT fk_bars_sorties FOREIGN KEY ( idsortie ) REFERENCES sorties( idsortie ) ,
	ADD CONSTRAINT fk_bars_plagehoraires FOREIGN KEY ( happyhour ) REFERENCES plagehoraires( idplagehoraire ) ;

ALTER TABLE nightclubs
	ADD CONSTRAINT fk_nightclubs_sorties FOREIGN KEY ( idsortie ) REFERENCES sorties( idsortie ) ;

ALTER TABLE restaurants
	ADD CONSTRAINT fk_restaurants_sorties FOREIGN KEY ( idsortie ) REFERENCES sorties( idsortie ) ;

------------------------------------------------------------------------------
-- VALORISATION DES TABLES

INSERT INTO quartiers
	( nom ) 
	VALUES 
	( 'Terreaux' ), 
	( 'Croix-Rousse' ), 
	( 'Confluence' ), 
	( 'Bellecour' ), 
	( 'Vieux Lyon' ), 
	( 'Cordeliers' ), 
	( 'Brotteaux' ),
	( 'Perrache' ), 
	( 'Pentes de la Croix-Rousse' );

INSERT INTO adresses
	( numero, voie, codepostal, ville, idquartier) 
	VALUES 
	( 20, 'place des Terreaux', 69001, 'Lyon', 1 ), 
	( 86, 'Quai Perrache', 69002, 'Lyon', 3 ), 
	( 1, 'place Saint-Nizier', 69002, 'Lyon', 6 ), 
	( 3, 'cours de Verdun Gensoul', 69002, 'Lyon', 8 ), 
	( 3, 'rue d''Austerlitz', 69004, 'Lyon', 2 ), 
	( 30, 'cours de Verdun Perrache', 69002, 'Lyon', 8 ), 
	( 13, 'rue Neuve', 69002, 'Lyon', 6 ), 
	( 21, 'place Gabriel Rambaud', 69001, 'Lyon', 1 ), 
	( 7, 'rue Terme', 69001, 'Lyon', 9 ),
	( 15, 'rue des Chartreux', 69001, 'Lyon', 2),
	( 37, 'rue René Lénon', 69001, 'Lyon', 9);

INSERT INTO adresses
	( codepostal, ville, idquartier) 
	VALUES
	( 69002, 'Lyon', 4 ),
	( 69005, 'Lyon', 5 ),
	( 69006, 'Lyon', 7 );

INSERT INTO lieux
	( nom, idadresse, description, accessibilite )
	VALUES
	( 'Musée des Beaux Arts', 1, 'Description lalalalala', 'Accessibilité lalalalali'), 
	( 'Musée des Confluences', 2, 'Description lalalalala', 'Accessibilité lalalalali'), 
	( 'Eglise Saint-Nizier', 3, 'Description lalalalala', 'Accessibilité lalalalali'),
	( 'Calle Latino', 4, 'Description lalalalala', 'Accessibilité lalalalali'),
	( 'Dikkenek Café', 5, 'Description lalalalala', 'Accessibilité lalalalali'),
	( 'Brasserie Georges', 6, 'Description lalalalala', 'Accessibilité lalalalali'),
	( 'La Hugonnière', 7, 'Description lalalalala', 'Accessibilité lalalalali'),
	( 'La Maison Mère', 8, 'Description lalalalala', 'Accessibilité lalalalali'),
	( 'L''Opéra Rock', 9, 'Description lalalalala', 'Accessibilité lalalalali'), 
	( 'Place Bellecour', 12, 'Description lalalalala', 'Accessibilité lalalalali'),
	( 'Place Saint-Jean', 13, 'Description lalalalala', 'Accessibilité lalalalali'),
	( 'Parc de la Tête d''Or', 14, 'Description lalalalala', 'Accessibilité lalalalali');

INSERT INTO typevisites
	(typev, libtypevisite)
	VALUES
	( 'M', 'Musée'),
	( 'M', 'Lieu de culte'),
	( 'P', 'Place'),
	( 'P', 'Parc');

INSERT INTO visites
	(idlieu, idtypevisite)
	VALUES
	(1, 1),
	(2, 1),
	(3, 2),
	(10, 3),
	(11, 3),
	(12, 4);

INSERT INTO monuments
	(anneeconstruction, anneefinconstruction, idvisite)
	VALUES
	(1801, 1801, 1),
	(2003, 2014, 2),
	(200, 1492, 3);

INSERT INTO placeetparcs
	(idvisite)
	VALUES
	(4),
	(5),
	(6);

INSERT INTO ambiances
	(types, libambiance)
	VALUES
	('N', 'Electro'),
	('N', 'Karaoké'),
	('B', 'Bar à bière'),
	('B', 'Bar latino'),
	('R', 'Brasserie'),
	('R', 'Bouchon');

INSERT INTO sorties
	(idlieu, prixmax, prixmin, idambiance)
	VALUES
	(4, 10, 5, 4),
	(5, 15, 3, 3),
	(6, 30, 20, 5),
	(7, 25, 15, 6),
	(8, 20, 10, 1),
	(9, 20, 10, 2);

INSERT INTO bars
	(idsortie)
	VALUES
	(1),
	(2);

INSERT INTO restaurants
	(idsortie, reservation, aemporter)
	VALUES
	(3, TRUE, FALSE),
	(4, FALSE, FALSE);

INSERT INTO nightclubs
	(idsortie)
	VALUES
	(5),
	(6);

INSERT INTO plagehoraires 
	(heuredebut,heurefin) 
	VALUES 
	('10:00', '20:00'),
	('09:00', '20:00'),
	('10:00', '22:00'),
	('08:00', '23:00'),
	('07:00', '19:00'),
	('09:00', '21:00'),
	('08:00', '21:00');

INSERT INTO horaires 
	(jour,idplagehoraire) 
	VALUES 
	('lundi', 1),
	('mardi', 2),
	('mercredi', 3),
	('jeudi', 4),
	('vendredi', 5),
	('samedi', 6),
	('dimanche', 7);

INSERT INTO ouvertures 
	(idhoraire, idsortie) 
	VALUES 
	(1, 1),
	(2, 1),
	(3, 1),
	(4, 1),
	(5, 1),
	(6, 1),
	(7, 1);

INSERT INTO utilisateurs
	(pseudo, datenaissance, sexe, email, idadresse, motdepasse)
	VALUES
	( 'JeanMitoufle', '1989-07-14', 'M', 'jean.mitoufle@yahoo.com', 10, 'JaimelesSchtroumpfs'),
	( 'MadeleineDeMouton', '1989-11-16', 'F', 'madeleine.de-mouton@yahoo.com', 11, 'JaimeGargamel');

INSERT INTO avis
	(idlieu, note, message, idutilisateur)
	VALUES
	(9, 5, 'Super karaoké !', 1),
	(12, 4, 'Jolie statue !', 1),
	(4, 5, 'Mojitos que te llevan al paraiso!', 2);