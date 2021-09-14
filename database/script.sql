DROP TABLE IF EXISTS `Achat`;
DROP TABLE IF EXISTS `User`;
DROP TABLE IF EXISTS `Client`;
DROP TABLE IF EXISTS `Produit`;

CREATE TABLE IF NOT EXISTS `User`(
 id INT NOT NULL AUTO_INCREMENT,
 nom VARCHAR(255) NOT NULL,
 prenom VARCHAR(255) NOT NULL,
 password VARCHAR (255) NOT NULL,
 email VARCHAR(255) NOT NULL,
 PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `Client`(
 id_cli INT NOT NULL AUTO_INCREMENT,
 nom VARCHAR(255) NOT NULL,
 prenom VARCHAR(255) NOT NULL,
 adresse VARCHAR (255) NOT NULL,
 PRIMARY KEY (`id_cli`));

 CREATE TABLE IF NOT EXISTS `Produit`(
 id_prod INT NOT NULL AUTO_INCREMENT,
 libelle VARCHAR(255) NOT NULL,
 prix INT NOT NULL,
 quantite INT NOT NULL,
 PRIMARY KEY (`id_prod`));

CREATE TABLE IF NOT EXISTS `Achat`(
 id_cli INT NOT NULL,
 id_prod INT NOT NULL,
 quantite INT NOT NULL,
 FOREIGN KEY (id_cli) REFERENCES Client(id_cli) ON DELETE CASCADE ON UPDATE CASCADE,
 FOREIGN KEY (id_prod) REFERENCES Produit(id_prod) ON DELETE CASCADE ON UPDATE CASCADE);

INSERT INTO User (nom, prenom, password, email) VALUES
("EL ASSOURI"    , "Mohammed"     , "password" , "m.elassouri@gmail.com");

INSERT INTO Client (nom, prenom, adresse) VALUES
("Jean"    , "Neymare"  , "44 Rue des Nerveux"),
("Oussama" , "Lairebon" , "55 Rue des Crevards"),
("Laurant" , "Outan"    , "36 Rue des Singes"),
("Alain"   , "Terieur"  , "27 Rue des Casaniers"),
("Jade"    , "Or"       , "12 Rue des Riches"),
("Paul"    , "Emploi"   , "123 Rue des Chômeurs"),
("John"    , "Deuf"     , "3 Rue des Poules");

INSERT INTO Produit (libelle, prix, quantite) VALUES
("Crayon"     , 3   , 99),
("Agrapheuse" , 51  , 99),
("Ballon"     , 11  , 99),
("Pommes"     , 44  , 99),
("Bijoux"     , 88  , 99),
("Nike"       , 54  , 99),
("Adidas"     , 25  , 99);

INSERT INTO Achat (id_cli, id_prod, quantite) VALUES
( 1 , 7  , 1),
( 2 , 6  , 1),
( 3 , 5  , 1),
( 4 , 4  , 1),
( 5 , 3  , 1),
( 6 , 2  , 1),
( 7 , 1  , 1);

CREATE TRIGGER updateQuantiteProdAfterInsert
AFTER INSERT ON Achat FOR EACH ROW UPDATE Produit set quantite = (quantite - NEW.quantite) where id_prod = NEW.id_prod;

CREATE TRIGGER updateQuantiteProdBeforeUpdate
BEFORE UPDATE ON Achat FOR EACH ROW UPDATE Produit set quantite = (quantite - NEW.quantite + OLD.quantite) where id_prod = NEW.id_prod;

CREATE TRIGGER updateQuantiteProdAfterDelete
AFTER DELETE ON Achat FOR EACH ROW UPDATE Produit set quantite = (quantite + OLD.quantite) where id_prod = OLD.id_prod;

/*DROP TRIGGER IF EXISTS updateQuantiteProdAfterUpdate;

DELIMITER $$
CREATE TRIGGER updateQuantiteProdAfterUpdate
AFTER UPDATE ON Achat FOR EACH ROW
BEGIN
    DECLARE quantiteProd INT;
	SELECT quantite INTO quantiteProd FROM Produit WHERE Produit.id_prod = NEW.id_prod;
    IF NEW.quantite > quantiteProd THEN
		UPDATE Produit SET quantite = OLD.quantite WHERE id_prod = OLD.id_prod;
    END IF;
END$$
DELIMITER ;*/