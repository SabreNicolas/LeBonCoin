-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.5.3-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for lesupercoin
DROP DATABASE IF EXISTS `lesupercoin`;
CREATE DATABASE IF NOT EXISTS `lesupercoin` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `lesupercoin`;

-- Dumping structure for table lesupercoin.annonce
CREATE TABLE IF NOT EXISTS `annonce` (
  `idAnnonce` int(11) NOT NULL AUTO_INCREMENT,
  `statut` tinyint(4) NOT NULL,
  `description` varchar(255) NOT NULL,
  `idCategorie` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`idAnnonce`),
  KEY `categorie_idx` (`idCategorie`),
  KEY `user_idx` (`idUser`),
  CONSTRAINT `categorie` FOREIGN KEY (`idCategorie`) REFERENCES `categorie` (`idCategorie`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- Dumping data for table lesupercoin.annonce: ~0 rows (approximately)
DELETE FROM `annonce`;
/*!40000 ALTER TABLE `annonce` DISABLE KEYS */;
INSERT INTO `annonce` (`idAnnonce`, `statut`, `description`, `idCategorie`, `idUser`) VALUES
	(17, 1, 'Un véhicule raisonnablement utilisable', 13, 3),
	(18, 1, 'Une maison plutôt décente', 22, 3);
/*!40000 ALTER TABLE `annonce` ENABLE KEYS */;

-- Dumping structure for table lesupercoin.categorie
CREATE TABLE IF NOT EXISTS `categorie` (
  `idCategorie` int(11) NOT NULL AUTO_INCREMENT,
  `nomCategorie` varchar(45) NOT NULL,
  `idSurCategorie` int(11) NOT NULL,
  PRIMARY KEY (`idCategorie`),
  KEY `surcategorie_idx` (`idSurCategorie`),
  CONSTRAINT `surcategorie` FOREIGN KEY (`idSurCategorie`) REFERENCES `surcategorie` (`idSurCategorie`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- Dumping data for table lesupercoin.categorie: ~47 rows (approximately)
DELETE FROM `categorie`;
/*!40000 ALTER TABLE `categorie` DISABLE KEYS */;
INSERT INTO `categorie` (`idCategorie`, `nomCategorie`, `idSurCategorie`) VALUES
	(2, 'Autres', 13),
	(3, 'Offres d\'emploi', 3),
	(4, 'Formations professionnelles', 3),
	(13, 'Voitures', 4),
	(14, 'Motos', 4),
	(15, 'Caravaning', 4),
	(16, 'Utilitaires', 4),
	(17, 'Camions', 4),
	(18, 'Nautisme', 4),
	(19, 'Equipement auto', 4),
	(20, 'Equipement moto', 4),
	(21, 'Ventes immobilières', 5),
	(22, 'Immobilier neuf', 5),
	(23, 'Locations', 5),
	(24, 'Colocations', 5),
	(25, 'Bureaux & commerces', 5),
	(26, 'Chambres d\'hôtes', 6),
	(27, 'Campings', 6),
	(28, 'Hôtels', 6),
	(29, 'CD/DVD', 7),
	(30, 'Livres', 7),
	(31, 'Animaux', 7),
	(32, 'Vélos', 7),
	(33, 'Sports & hobbies', 7),
	(34, 'Musique', 7),
	(35, 'Jeux et jouets', 7),
	(36, 'Vêtements', 8),
	(37, 'Chaussures', 8),
	(38, 'Montres & bijoux', 8),
	(39, 'Vêtements bébé', 8),
	(40, 'Informatique', 9),
	(41, 'Consoles & jeux vidéos', 9),
	(42, 'Image & son', 9),
	(43, 'Téléphonie', 9),
	(44, 'BilletTerie', 10),
	(45, 'Événements', 10),
	(46, 'Cours particuliers', 10),
	(47, 'Covoiturage', 10),
	(48, 'Ameublement', 11),
	(49, 'Electroménager', 11),
	(50, 'Décoration', 11),
	(51, 'Linge de maison', 11),
	(52, 'Matériel agricole', 12),
	(53, 'Transport - manutention', 12),
	(54, 'BTP', 12),
	(55, 'Outillage', 12),
	(56, 'Matériel médical', 12);
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;

-- Dumping structure for table lesupercoin.critere
CREATE TABLE IF NOT EXISTS `critere` (
  `idCritere` int(11) NOT NULL AUTO_INCREMENT,
  `nomCritere` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `idSurCategorie` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCritere`),
  KEY `categorie_idx` (`idSurCategorie`),
  CONSTRAINT `cat` FOREIGN KEY (`idSurCategorie`) REFERENCES `surcategorie` (`idSurCategorie`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- Dumping data for table lesupercoin.critere: ~21 rows (approximately)
DELETE FROM `critere`;
/*!40000 ALTER TABLE `critere` DISABLE KEYS */;
INSERT INTO `critere` (`idCritere`, `nomCritere`, `type`, `idSurCategorie`) VALUES
	(1, 'Prix', 'Float', NULL),
	(2, 'Localisation', 'Enum', NULL),
	(18, 'Etat', 'Select', NULL),
	(20, 'Marque', 'Select', 4),
	(21, 'Première immatriculation', 'Date', 4),
	(22, 'Kilométrage', 'Float', 4),
	(23, 'Equipement', 'String', 13),
	(24, 'Type de contrat', 'Checkbox', 3),
	(25, 'Rémunération', 'Float', 3),
	(26, 'Intitulé du poste', 'String', 3),
	(27, 'Superficie', 'Float', 5),
	(28, 'Charges', 'Float', 5),
	(29, 'Sport', 'Checkbox', 7),
	(30, 'Gadget', 'String', 11),
	(31, 'Marque', 'Select', 12),
	(32, 'Marque', 'Select', 8),
	(33, 'Taille', 'String', 8),
	(34, 'Marque', 'Select', 9),
	(35, 'Date d\'achat', 'Date', 9),
	(36, 'Restauration sur place', 'Checkbox', 6),
	(37, 'Nombre d\'étoiles', 'Checkbox', 6),
	(38, 'Titre', 'String', NULL);
/*!40000 ALTER TABLE `critere` ENABLE KEYS */;

-- Dumping structure for procedure lesupercoin.listAnnoncesActive
DELIMITER //
CREATE PROCEDURE `listAnnoncesActive`(`idUser` INTEGER)
BEGIN

	SELECT * FROM annonce WHERE annonce.idUser = idUser AND statut = 1;

END//
DELIMITER ;

-- Dumping structure for procedure lesupercoin.listAnnoncesInactive
DELIMITER //
CREATE PROCEDURE `listAnnoncesInactive`(`idUser` INTEGER)
BEGIN

	SELECT * FROM annonce WHERE annonce.idUser = idUser AND statut = 0;

END//
DELIMITER ;

-- Dumping structure for procedure lesupercoin.listCategories
DELIMITER //
CREATE PROCEDURE `listCategories`(`idSurCategorie` INTEGER)
BEGIN

	SELECT * FROM categorie WHERE categorie.idSurCategorie = idSurCategorie;

END//
DELIMITER ;

-- Dumping structure for procedure lesupercoin.listCriteres
DELIMITER //
CREATE PROCEDURE `listCriteres`(`idCategorie` INTEGER)
BEGIN

	SELECT * FROM critere WHERE critere.idSurCategorie = idCategorie;

END//
DELIMITER ;

-- Dumping structure for procedure lesupercoin.listPhotos
DELIMITER //
CREATE PROCEDURE `listPhotos`(`idAnnonce` INTEGER)
BEGIN

	SELECT * FROM photo WHERE photo.idAnnonce = idAnnonce; 

END//
DELIMITER ;

-- Dumping structure for procedure lesupercoin.listValeursCriteres
DELIMITER //
CREATE PROCEDURE `listValeursCriteres`(`idAnnonce` INTEGER)
BEGIN

	SELECT * FROM valeurCritere  
    INNER JOIN critere ON valeurCritere.critere_idCritere = critere.idCritere
    WHERE valeurCritere.annonce_idAnnonce = idAnnonce;

END//
DELIMITER ;

-- Dumping structure for table lesupercoin.photo
CREATE TABLE IF NOT EXISTS `photo` (
  `idPhoto` int(11) NOT NULL AUTO_INCREMENT,
  `photo` text NOT NULL,
  `idAnnonce` int(11) NOT NULL,
  PRIMARY KEY (`idPhoto`),
  KEY `annonce_idx` (`idAnnonce`),
  CONSTRAINT `annonce` FOREIGN KEY (`idAnnonce`) REFERENCES `annonce` (`idAnnonce`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table lesupercoin.photo: ~0 rows (approximately)
DELETE FROM `photo`;
/*!40000 ALTER TABLE `photo` DISABLE KEYS */;
/*!40000 ALTER TABLE `photo` ENABLE KEYS */;

-- Dumping structure for table lesupercoin.surcategorie
CREATE TABLE IF NOT EXISTS `surcategorie` (
  `idSurCategorie` int(11) NOT NULL AUTO_INCREMENT,
  `nomSurCategorie` varchar(45) NOT NULL,
  PRIMARY KEY (`idSurCategorie`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- Dumping data for table lesupercoin.surcategorie: ~11 rows (approximately)
DELETE FROM `surcategorie`;
/*!40000 ALTER TABLE `surcategorie` DISABLE KEYS */;
INSERT INTO `surcategorie` (`idSurCategorie`, `nomSurCategorie`) VALUES
	(3, 'Emploi'),
	(4, 'Véhicules'),
	(5, 'Immobilier'),
	(6, 'Vacances'),
	(7, 'Loisirs'),
	(8, 'Mode'),
	(9, 'Multimédia'),
	(10, 'Services'),
	(11, 'Maison'),
	(12, 'Matériel professionnel'),
	(13, 'Divers');
/*!40000 ALTER TABLE `surcategorie` ENABLE KEYS */;

-- Dumping structure for table lesupercoin.user
CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `mdp` varchar(45) NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table lesupercoin.user: ~0 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`idUser`, `nom`, `prenom`, `login`, `mail`, `mdp`) VALUES
	(3, 'sabre', 'nicolas', 'nico', 'nico', 'nico');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table lesupercoin.valeurcritere
CREATE TABLE IF NOT EXISTS `valeurcritere` (
  `annonce_idAnnonce` int(11) NOT NULL,
  `critere_idCritere` int(11) NOT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`annonce_idAnnonce`,`critere_idCritere`),
  KEY `fk_annonce_has_critere_critere1_idx` (`critere_idCritere`),
  KEY `fk_annonce_has_critere_annonce1_idx` (`annonce_idAnnonce`),
  CONSTRAINT `fk_annonce_has_critere_annonce1` FOREIGN KEY (`annonce_idAnnonce`) REFERENCES `annonce` (`idAnnonce`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_annonce_has_critere_critere1` FOREIGN KEY (`critere_idCritere`) REFERENCES `critere` (`idCritere`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table lesupercoin.valeurcritere: ~0 rows (approximately)
DELETE FROM `valeurcritere`;
/*!40000 ALTER TABLE `valeurcritere` DISABLE KEYS */;
INSERT INTO `valeurcritere` (`annonce_idAnnonce`, `critere_idCritere`, `value`) VALUES
	(17, 1, '1200'),
	(17, 2, 'Lens'),
	(17, 18, 'Comme neuf'),
	(17, 20, 'Renault Clio 2'),
	(17, 21, '2001'),
	(17, 22, '208000'),
	(17, 38, 'Clio de Kévin'),
	(18, 1, '4000000'),
	(18, 2, 'Lille'),
	(18, 18, 'Un poil usée'),
	(18, 27, '12 hectares habitables'),
	(18, 28, '4€/an'),
	(18, 38, 'Maison');
/*!40000 ALTER TABLE `valeurcritere` ENABLE KEYS */;

-- Dumping structure for view lesupercoin.vueglobale
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `vueglobale` (
	`idAnnonce` INT(11) NOT NULL,
	`statut` TINYINT(4) NOT NULL,
	`description` VARCHAR(255) NOT NULL COLLATE 'utf8_general_ci',
	`idCategorie` INT(11) NOT NULL,
	`idUser` INT(11) NOT NULL,
	`idPhoto` INT(11) NOT NULL,
	`photo` TEXT(65535) NOT NULL COLLATE 'utf8_general_ci',
	`nom` VARCHAR(45) NOT NULL COLLATE 'utf8_general_ci',
	`prenom` VARCHAR(45) NOT NULL COLLATE 'utf8_general_ci',
	`login` VARCHAR(45) NOT NULL COLLATE 'utf8_general_ci',
	`value` VARCHAR(45) NOT NULL COLLATE 'utf8_general_ci',
	`nomCategorie` VARCHAR(45) NOT NULL COLLATE 'utf8_general_ci',
	`idSurCategorie` INT(11) NOT NULL,
	`idCritere` INT(11) NOT NULL,
	`nomCritere` VARCHAR(45) NOT NULL COLLATE 'utf8_general_ci',
	`type` VARCHAR(45) NOT NULL COLLATE 'utf8_general_ci'
) ENGINE=MyISAM;

-- Dumping structure for trigger lesupercoin.annonce_BEFORE_DELETE
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';
DELIMITER //
CREATE TRIGGER `annonce_BEFORE_DELETE` BEFORE DELETE ON `annonce` FOR EACH ROW BEGIN

	DELETE FROM photo WHERE idAnnonce = OLD.idAnnonce;
    DELETE FROM valeurCritere WHERE annonce_idAnnonce = OLD.idAnnonce;

END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dumping structure for trigger lesupercoin.categorie_BEFORE_DELETE
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';
DELIMITER //
CREATE TRIGGER `categorie_BEFORE_DELETE` BEFORE DELETE ON `categorie` FOR EACH ROW BEGIN

	DECLARE nbAnnonce INTEGER;
    DECLARE message CONDITION FOR SQLSTATE '45000';
    
	SET nbAnnonce = 0;
    
    SELECT COUNT(*) INTO nbAnnonce FROM `annonce` WHERE idCategorie = OLD.idCategorie;
    
    IF nbAnnonce <> 0 THEN
    SIGNAL message
	SET MESSAGE_TEXT = 'Impossible de supprimer la catégorie car il existe des annonces pour cette catégorie';
    END IF;
    
    DELETE FROM critere WHERE idSurCategorie = OLD.idSurCategorie;

END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dumping structure for trigger lesupercoin.critere_BEFORE_DELETE
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';
DELIMITER //
CREATE TRIGGER `critere_BEFORE_DELETE` BEFORE DELETE ON `critere` FOR EACH ROW BEGIN
	DECLARE nbCritere INTEGER;
    DECLARE message CONDITION FOR SQLSTATE '45000';
    
	SET nbCritere = 0;
    
    SELECT COUNT(*) INTO nbCritere FROM `valeurCritere` WHERE critere_idCritere = OLD.idCritere;
    
    IF nbCritere <> 0 THEN
    SIGNAL message
	SET MESSAGE_TEXT = 'Impossible de supprimer le critere car ce critère est utilisé dans une annonce';
    END IF;

END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dumping structure for trigger lesupercoin.surCategorie_BEFORE_DELETE
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';
DELIMITER //
CREATE TRIGGER `surCategorie_BEFORE_DELETE` BEFORE DELETE ON `surCategorie` FOR EACH ROW BEGIN

	DELETE FROM categorie WHERE idSurCategorie = OLD.idSurCategorie;
    
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dumping structure for trigger lesupercoin.user_BEFORE_DELETE
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';
DELIMITER //
CREATE TRIGGER `user_BEFORE_DELETE` BEFORE DELETE ON `user` FOR EACH ROW BEGIN

	DELETE FROM annonce  WHERE idUser = OLD.idUser;

END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dumping structure for view lesupercoin.vueglobale
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `vueglobale`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `vueglobale` AS select `annonce`.`idAnnonce` AS `idAnnonce`,`annonce`.`statut` AS `statut`,`annonce`.`description` AS `description`,`categorie`.`idCategorie` AS `idCategorie`,`user`.`idUser` AS `idUser`,`photo`.`idPhoto` AS `idPhoto`,`photo`.`photo` AS `photo`,`user`.`nom` AS `nom`,`user`.`prenom` AS `prenom`,`user`.`login` AS `login`,`valeurcritere`.`value` AS `value`,`categorie`.`nomCategorie` AS `nomCategorie`,`surcategorie`.`idSurCategorie` AS `idSurCategorie`,`critere`.`idCritere` AS `idCritere`,`critere`.`nomCritere` AS `nomCritere`,`critere`.`type` AS `type` from ((((((`annonce` join `photo` on((`annonce`.`idAnnonce` = `photo`.`idAnnonce`))) join `user` on((`annonce`.`idUser` = `user`.`idUser`))) join `valeurcritere` on((`annonce`.`idAnnonce` = `valeurcritere`.`annonce_idAnnonce`))) join `categorie`) join `surcategorie`) join `critere`) where ((`annonce`.`idAnnonce` = `valeurcritere`.`annonce_idAnnonce`) and (`critere`.`idCritere` = `valeurcritere`.`critere_idCritere`) and (`categorie`.`idSurCategorie` = `surcategorie`.`idSurCategorie`) and (`critere`.`idSurCategorie` = `categorie`.`idSurCategorie`)) ;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
