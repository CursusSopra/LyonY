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
	sexe                 bool  NOT NULL,
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
-- AJOUT DES FOREIN KEYS

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