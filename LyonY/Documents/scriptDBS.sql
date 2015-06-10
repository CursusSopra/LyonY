------------------------------------------------------------------------------
-- SUPPRESSION DES TABLES

DROP TABLE IF EXISTS utilisateur CASCADE;

DROP TABLE IF EXISTS avis CASCADE;

DROP TABLE IF EXISTS lien CASCADE;

DROP TABLE IF EXISTS lieu CASCADE;

DROP TABLE IF EXISTS quartier CASCADE;

DROP TABLE IF EXISTS adresse CASCADE;

DROP TABLE IF EXISTS monument CASCADE;

DROP TABLE IF EXISTS placeetparc CASCADE;

DROP TABLE IF EXISTS sortie CASCADE;

DROP TABLE IF EXISTS horaire CASCADE;

DROP TABLE IF EXISTS plagehoraire CASCADE;

DROP TABLE IF EXISTS ouverture CASCADE;

DROP TABLE IF EXISTS ambiance CASCADE;

DROP TABLE IF EXISTS bar CASCADE;

DROP TABLE IF EXISTS nightclub CASCADE;

DROP TABLE IF EXISTS restaurant CASCADE;

------------------------------------------------------------------------------
-- CREATION DES TABLES

CREATE TABLE utilisateur ( 
	idutilisateur        serial  NOT NULL,
	pseudo               varchar(20)  NOT NULL,
	datenaissance        date  NOT NULL,
	sexe                 bool  NOT NULL,
	email                varchar(30)  NOT NULL,
	avatar               varchar(30)  ,
	idadresse            integer  NOT NULL,
	motdepasse           varchar(30)  NOT NULL,
	CONSTRAINT pk_utilisateur PRIMARY KEY ( idutilisateur ),
	CONSTRAINT ct_unique_pseudo UNIQUE ( pseudo )  
 );

CREATE TABLE avis ( 
	idavis               serial  NOT NULL,
	idlieu               integer  NOT NULL,
	note                 integer  NOT NULL,
	message              varchar(200)  ,
	idutilisateur        serial  NOT NULL,
	CONSTRAINT pk_avis PRIMARY KEY ( idavis )   
 );

CREATE TABLE lien ( 
	idlien               serial  NOT NULL,
	liblien              varchar(20)  ,
	url                  varchar(30)  NOT NULL,
	CONSTRAINT pk_liens PRIMARY KEY ( idlien )
 );

CREATE TABLE lieu ( 
	idlieu               serial  NOT NULL,
	nom                  varchar(40)  ,
	idadresse            integer  NOT NULL,
	idlien               integer  ,
	description          text  ,
	accessibilite        text  ,
	CONSTRAINT pk_lieu PRIMARY KEY ( idlieu ) 
 );

CREATE TABLE quartier ( 
	idquartier           serial  NOT NULL,
	nom                  varchar(30)  NOT NULL,
	budgetmoyen          integer  ,
	distancecentreville  integer  ,
	CONSTRAINT pk_quartier PRIMARY KEY ( idquartier )
 );

CREATE TABLE adresse ( 
	idadresse            serial  NOT NULL,
	numero               integer  ,
	voie                 varchar(30)  ,
	codepostal           char(5)  NOT NULL,
	ville                varchar(30)  NOT NULL,
	idquartier           integer  NOT NULL,
	CONSTRAINT pk_adresse PRIMARY KEY ( idadresse )  
 );

CREATE TABLE monument ( 
	idmonument           serial  NOT NULL,
	idlieu               integer  NOT NULL,
	anneeconstruction    integer  ,
	anneefinconstruction integer  ,
	typem                varchar(20)  ,
	CONSTRAINT pk_monument PRIMARY KEY ( idmonument )    
 );

CREATE TABLE placeetparc ( 
	idplaceetparc        serial  NOT NULL,
	idlieu               integer  NOT NULL,
	typepp               char(3)  ,
	CONSTRAINT pk_place PRIMARY KEY ( idplaceetparc )   
 );

CREATE TABLE sortie ( 
	idsortie             serial  NOT NULL,
	idlieu               integer  NOT NULL,
	types                varchar(20)  NOT NULL,
	prixmax              integer  ,
	prixmin              integer  ,
	CONSTRAINT pk_commerce PRIMARY KEY ( idsortie ) 
 );

CREATE TABLE horaire ( 
	idhoraire            serial  NOT NULL,
	jour                 date  NOT NULL,
	idplagehoraire       integer  ,
	CONSTRAINT pk_horaire PRIMARY KEY ( idhoraire )   
 );

CREATE TABLE plagehoraire ( 
	idplagehoraire       serial  NOT NULL,
	heuredebut           time  NOT NULL,
	heurefin             time  NOT NULL,
	CONSTRAINT pk_plagehoraire PRIMARY KEY ( idplagehoraire )
 );

CREATE TABLE ouverture ( 
	idhoraire            integer  NOT NULL,
	idsortie             integer  NOT NULL,
	CONSTRAINT idx_ouverture PRIMARY KEY ( idsortie, idhoraire )  
 );

CREATE TABLE ambiance ( 
	idambiance           serial  NOT NULL,
	typea                varchar(20)  NOT NULL,
	CONSTRAINT pk_ambiance PRIMARY KEY ( idambiance )
 );

CREATE TABLE bar ( 
	idbar                serial  NOT NULL,
	idsortie             integer  ,
	happyhour            integer  ,
	idambiance           integer  ,
	typeb                varchar(20)  ,
	CONSTRAINT pk_bar PRIMARY KEY ( idbar )  
 );

CREATE TABLE nightclub ( 
	idnightclub          serial  NOT NULL,
	idsortie             integer  NOT NULL,
	idambiance           integer  ,
	CONSTRAINT pk_nightclub PRIMARY KEY ( idnightclub )
 );

CREATE TABLE restaurant ( 
	idrestaurant         serial  NOT NULL,
	idsortie             integer  NOT NULL,
	typer                varchar(20)  ,
	idambiance           integer  ,
	reservation          bool  ,
	aemporter            bool  ,
	CONSTRAINT pk_restaurant PRIMARY KEY ( idrestaurant ) 
 );

------------------------------------------------------------------------------
-- AJOUT DES FOREIN KEYS

ALTER TABLE utilisateur
	ADD CONSTRAINT fk_utilisateur_adresse FOREIGN KEY ( idadresse ) REFERENCES adresse( idadresse ) ;

ALTER TABLE avis
	ADD CONSTRAINT fk_avis_lieu FOREIGN KEY ( idlieu ) REFERENCES lieu( idlieu ) ,
	ADD CONSTRAINT fk_avis_utilisateur FOREIGN KEY ( idutilisateur ) REFERENCES utilisateur( idutilisateur ) ;

ALTER TABLE lieu
	ADD CONSTRAINT fk_lieu_adresse FOREIGN KEY ( idadresse ) REFERENCES adresse( idadresse ) ,
	ADD CONSTRAINT fk_lieu_lien FOREIGN KEY ( idlien ) REFERENCES lien( idlien ) ;

ALTER TABLE adresse
	ADD CONSTRAINT fk_adresse_quartier FOREIGN KEY ( idquartier ) REFERENCES quartier( idquartier ) ;

ALTER TABLE monument
	ADD CONSTRAINT fk_monument_lieu FOREIGN KEY ( idlieu ) REFERENCES lieu( idlieu ) ;

ALTER TABLE placeetparc
	ADD CONSTRAINT fk_place_lieu FOREIGN KEY ( idlieu ) REFERENCES lieu( idlieu ) ;

ALTER TABLE sortie
	ADD CONSTRAINT fk_commerce_lieu FOREIGN KEY ( idlieu ) REFERENCES lieu( idlieu ) ;

ALTER TABLE horaire
	ADD CONSTRAINT fk_horaire_plagehoraire FOREIGN KEY ( idplagehoraire ) REFERENCES plagehoraire( idplagehoraire ) ;

ALTER TABLE ouverture
	ADD CONSTRAINT fk_ouverture_horaire FOREIGN KEY ( idhoraire ) REFERENCES horaire( idhoraire ) ,
	ADD CONSTRAINT fk_ouverture_sortie FOREIGN KEY ( idsortie ) REFERENCES sortie( idsortie ) ; 

ALTER TABLE bar
	ADD CONSTRAINT fk_bar_commerce FOREIGN KEY ( idsortie ) REFERENCES sortie( idsortie ) ,
	ADD CONSTRAINT fk_bar_plagehoraire FOREIGN KEY ( happyhour ) REFERENCES plagehoraire( idplagehoraire ) ,
	ADD CONSTRAINT fk_bar_ambiance FOREIGN KEY ( idambiance ) REFERENCES ambiance( idambiance ) ;

ALTER TABLE nightclub
	ADD CONSTRAINT fk_nightclub_commerce FOREIGN KEY ( idsortie ) REFERENCES sortie( idsortie ) ,
	ADD CONSTRAINT fk_nightclub_ambiance FOREIGN KEY ( idambiance ) REFERENCES ambiance( idambiance ) ;

ALTER TABLE restaurant
	ADD CONSTRAINT fk_restaurant_commerce FOREIGN KEY ( idsortie ) REFERENCES sortie( idsortie ) , 
	ADD CONSTRAINT fk_restaurant_ambiance FOREIGN KEY ( idambiance ) REFERENCES ambiance( idambiance ) ;