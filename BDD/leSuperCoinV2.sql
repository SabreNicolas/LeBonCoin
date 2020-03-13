-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le :  ven. 13 mars 2020 à 14:37
-- Version du serveur :  5.7.21
-- Version de PHP :  7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `lesupercoin`
--

DELIMITER $$
--
-- Procédures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `listAnnoncesActive` (`idUser` INTEGER)  BEGIN

	SELECT * FROM annonce WHERE annonce.idUser = idUser AND statut = 1;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listAnnoncesInactive` (`idUser` INTEGER)  BEGIN

	SELECT * FROM annonce WHERE annonce.idUser = idUser AND statut = 0;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listCategories` (`idSurCategorie` INTEGER)  BEGIN

	SELECT * FROM categorie WHERE categorie.idSurCategorie = idSurCategorie;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listCriteres` (`idCategorie` INTEGER)  BEGIN

	SELECT * FROM critere WHERE critere.idSurCategorie = idCategorie;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listPhotos` (`idAnnonce` INTEGER)  BEGIN

	SELECT * FROM photo WHERE photo.idAnnonce = idAnnonce; 

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listValeursCriteres` (`idAnnonce` INTEGER)  BEGIN

	SELECT * FROM valeurCritere  
    INNER JOIN critere ON valeurCritere.critere_idCritere = critere.idCritere
    WHERE valeurCritere.annonce_idAnnonce = idAnnonce;

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `annonce`
--

CREATE TABLE `annonce` (
  `idAnnonce` int(11) NOT NULL,
  `statut` tinyint(4) NOT NULL,
  `description` varchar(255) NOT NULL,
  `idCategorie` int(11) NOT NULL,
  `idUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déclencheurs `annonce`
--
DELIMITER $$
CREATE TRIGGER `annonce_BEFORE_DELETE` BEFORE DELETE ON `annonce` FOR EACH ROW BEGIN

	DELETE FROM photo WHERE idAnnonce = OLD.idAnnonce;
    DELETE FROM valeurCritere WHERE annonce_idAnnonce = OLD.idAnnonce;

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `idCategorie` int(11) NOT NULL,
  `nomCategorie` varchar(45) NOT NULL,
  `idSurCategorie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `categorie`
--

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

--
-- Déclencheurs `categorie`
--
DELIMITER $$
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

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `critere`
--

CREATE TABLE `critere` (
  `idCritere` int(11) NOT NULL,
  `nomCritere` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `idSurCategorie` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `critere`
--

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
(36, 'Restauration sur place', 'checkbox', 6),
(37, 'Nombre d\'étoiles', 'checkbox', 6);

--
-- Déclencheurs `critere`
--
DELIMITER $$
CREATE TRIGGER `critere_BEFORE_DELETE` BEFORE DELETE ON `critere` FOR EACH ROW BEGIN
	DECLARE nbCritere INTEGER;
    DECLARE message CONDITION FOR SQLSTATE '45000';
    
	SET nbCritere = 0;
    
    SELECT COUNT(*) INTO nbCritere FROM `valeurCritere` WHERE critere_idCritere = OLD.idCritere;
    
    IF nbCritere <> 0 THEN
    SIGNAL message
	SET MESSAGE_TEXT = 'Impossible de supprimer le critere car ce critère est utilisé dans une annonce';
    END IF;

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `photo`
--

CREATE TABLE `photo` (
  `idPhoto` int(11) NOT NULL,
  `photo` text NOT NULL,
  `idAnnonce` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `surCategorie`
--

CREATE TABLE `surCategorie` (
  `idSurCategorie` int(11) NOT NULL,
  `nomSurCategorie` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `surCategorie`
--

INSERT INTO `surCategorie` (`idSurCategorie`, `nomSurCategorie`) VALUES
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

--
-- Déclencheurs `surCategorie`
--
DELIMITER $$
CREATE TRIGGER `surCategorie_BEFORE_DELETE` BEFORE DELETE ON `surCategorie` FOR EACH ROW BEGIN

	DELETE FROM categorie WHERE idSurCategorie = OLD.idSurCategorie;
    
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `idUser` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `mdp` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`idUser`, `nom`, `prenom`, `login`, `mail`, `mdp`) VALUES
(3, 'sabre', 'nicolas', 'nico', 'nico', 'nico');

--
-- Déclencheurs `user`
--
DELIMITER $$
CREATE TRIGGER `user_BEFORE_DELETE` BEFORE DELETE ON `user` FOR EACH ROW BEGIN

	DELETE FROM annonce  WHERE idUser = OLD.idUser;

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `valeurCritere`
--

CREATE TABLE `valeurCritere` (
  `annonce_idAnnonce` int(11) NOT NULL,
  `critere_idCritere` int(11) NOT NULL,
  `value` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `vueglobale`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `vueglobale` (
`idAnnonce` int(11)
,`statut` tinyint(4)
,`description` varchar(255)
,`idCategorie` int(11)
,`idUser` int(11)
,`idPhoto` int(11)
,`photo` text
,`nom` varchar(45)
,`prenom` varchar(45)
,`login` varchar(45)
,`value` varchar(45)
,`nomCategorie` varchar(45)
,`idSurCategorie` int(11)
,`idCritere` int(11)
,`nomCritere` varchar(45)
,`type` varchar(45)
);

-- --------------------------------------------------------

--
-- Structure de la vue `vueglobale`
--
DROP TABLE IF EXISTS `vueglobale`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vueglobale`  AS  select `annonce`.`idAnnonce` AS `idAnnonce`,`annonce`.`statut` AS `statut`,`annonce`.`description` AS `description`,`categorie`.`idCategorie` AS `idCategorie`,`user`.`idUser` AS `idUser`,`photo`.`idPhoto` AS `idPhoto`,`photo`.`photo` AS `photo`,`user`.`nom` AS `nom`,`user`.`prenom` AS `prenom`,`user`.`login` AS `login`,`valeurcritere`.`value` AS `value`,`categorie`.`nomCategorie` AS `nomCategorie`,`surcategorie`.`idSurCategorie` AS `idSurCategorie`,`critere`.`idCritere` AS `idCritere`,`critere`.`nomCritere` AS `nomCritere`,`critere`.`type` AS `type` from ((((((`annonce` join `photo` on((`annonce`.`idAnnonce` = `photo`.`idAnnonce`))) join `user` on((`annonce`.`idUser` = `user`.`idUser`))) join `valeurcritere` on((`annonce`.`idAnnonce` = `valeurcritere`.`annonce_idAnnonce`))) join `categorie`) join `surcategorie`) join `critere`) where ((`annonce`.`idAnnonce` = `valeurcritere`.`annonce_idAnnonce`) and (`critere`.`idCritere` = `valeurcritere`.`critere_idCritere`) and (`categorie`.`idSurCategorie` = `surcategorie`.`idSurCategorie`) and (`critere`.`idSurCategorie` = `categorie`.`idSurCategorie`)) ;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD PRIMARY KEY (`idAnnonce`),
  ADD KEY `categorie_idx` (`idCategorie`),
  ADD KEY `user_idx` (`idUser`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`idCategorie`),
  ADD KEY `surcategorie_idx` (`idSurCategorie`);

--
-- Index pour la table `critere`
--
ALTER TABLE `critere`
  ADD PRIMARY KEY (`idCritere`),
  ADD KEY `categorie_idx` (`idSurCategorie`);

--
-- Index pour la table `photo`
--
ALTER TABLE `photo`
  ADD PRIMARY KEY (`idPhoto`),
  ADD KEY `annonce_idx` (`idAnnonce`);

--
-- Index pour la table `surCategorie`
--
ALTER TABLE `surCategorie`
  ADD PRIMARY KEY (`idSurCategorie`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- Index pour la table `valeurCritere`
--
ALTER TABLE `valeurCritere`
  ADD PRIMARY KEY (`annonce_idAnnonce`,`critere_idCritere`),
  ADD KEY `fk_annonce_has_critere_critere1_idx` (`critere_idCritere`),
  ADD KEY `fk_annonce_has_critere_annonce1_idx` (`annonce_idAnnonce`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `annonce`
--
ALTER TABLE `annonce`
  MODIFY `idAnnonce` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `idCategorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT pour la table `critere`
--
ALTER TABLE `critere`
  MODIFY `idCritere` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT pour la table `photo`
--
ALTER TABLE `photo`
  MODIFY `idPhoto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `surCategorie`
--
ALTER TABLE `surCategorie`
  MODIFY `idSurCategorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD CONSTRAINT `categorie` FOREIGN KEY (`idCategorie`) REFERENCES `categorie` (`idCategorie`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `user` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD CONSTRAINT `surcategorie` FOREIGN KEY (`idSurCategorie`) REFERENCES `surCategorie` (`idSurCategorie`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `critere`
--
ALTER TABLE `critere`
  ADD CONSTRAINT `cat` FOREIGN KEY (`idSurCategorie`) REFERENCES `surCategorie` (`idSurCategorie`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `photo`
--
ALTER TABLE `photo`
  ADD CONSTRAINT `annonce` FOREIGN KEY (`idAnnonce`) REFERENCES `annonce` (`idAnnonce`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `valeurCritere`
--
ALTER TABLE `valeurCritere`
  ADD CONSTRAINT `fk_annonce_has_critere_annonce1` FOREIGN KEY (`annonce_idAnnonce`) REFERENCES `annonce` (`idAnnonce`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_annonce_has_critere_critere1` FOREIGN KEY (`critere_idCritere`) REFERENCES `critere` (`idCritere`) ON DELETE NO ACTION ON UPDATE NO ACTION;
