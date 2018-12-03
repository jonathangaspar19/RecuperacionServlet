create table IF NOT EXISTS ACTOR(
	codActorr INT IDENTITY,
	name varchar(25),
	surname varchar(25),
	PRIMARY KEY (codActor)
);

create table IF NOT EXISTS PELICULA(
	peliculaName varchar(25),
	codActor INT,
	PRIMARY KEY (peliculaName),
	FOREIGN KEY (codactor) REFERENCES OWNER(codActor)
);