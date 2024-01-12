BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Drzava" (
	"ID"	INTEGER,
	"Naziv"	TEXT,
	"GlavniGrad"	INTEGER,
	FOREIGN KEY("GlavniGrad") REFERENCES "Grad"("ID"),
	PRIMARY KEY("ID")
);
CREATE TABLE IF NOT EXISTS "Grad" (
	"ID"	INTEGER,
	"Naziv"	TEXT,
	"BrojStanovnika"	INTEGER,
	"Drzava"	INTEGER,
	FOREIGN KEY("Drzava") REFERENCES "Drzava"("ID"),
	PRIMARY KEY("ID")
);
COMMIT;
