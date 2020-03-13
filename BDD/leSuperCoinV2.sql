
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

	SELECT * FROM critere WHERE critere.idCategorie = idCategorie;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listValeursCriteres` (`idAnnonce` INTEGER)  BEGIN

	SELECT * FROM valeurCritere  
    INNER JOIN critere ON valeurCritere.critere_idCritere = critere.idCritere
    WHERE valeurCritere.annonce_idAnnonce = idAnnonce;

END$$

DELIMITER ;

--
-- Déchargement des données de la table `annonce`
--

INSERT INTO `annonce` (`idAnnonce`, `statut`, `description`, `idCategorie`, `idUser`) VALUES
(5, 1, 'active', 48, 3),
(6, 0, 'inactive', 2, 3);

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

--
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
    
    DELETE FROM critere WHERE idCategorie = OLD.idCategorie;

END
$$
DELIMITER ;

--
--
-- Déchargement des données de la table `critere`
--

INSERT INTO `critere` (`idCritere`, `nomCritere`, `type`, `idCategorie`) VALUES
(1, 'Prix', 'Float', NULL),
(2, 'Localisation', 'Enum', NULL),
(6, 'critereAmeublement', 'input', 48),
(7, 'critereAmeublement2', 'input', 48);

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

INSERT INTO `photo` (`idPhoto`, `photo`, `idAnnonce`) VALUES
(2, 'test', 5);

-- --------------------------------------------------------

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
-- Déchargement des données de la table `valeurCritere`
--

INSERT INTO `valeurCritere` (`annonce_idAnnonce`, `critere_idCritere`, `value`) VALUES
(5, 1, '56'),
(5, 2, '57');

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

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vueglobale`  AS  select `annonce`.`idAnnonce` AS `idAnnonce`,`annonce`.`statut` AS `statut`,`annonce`.`description` AS `description`,`categorie`.`idCategorie` AS `idCategorie`,`user`.`idUser` AS `idUser`,`photo`.`idPhoto` AS `idPhoto`,`photo`.`photo` AS `photo`,`user`.`nom` AS `nom`,`user`.`prenom` AS `prenom`,`user`.`login` AS `login`,`valeurcritere`.`value` AS `value`,`categorie`.`nomCategorie` AS `nomCategorie`,`surcategorie`.`idSurCategorie` AS `idSurCategorie`,`critere`.`idCritere` AS `idCritere`,`critere`.`nomCritere` AS `nomCritere`,`critere`.`type` AS `type` from ((((((`annonce` join `photo` on((`annonce`.`idAnnonce` = `photo`.`idAnnonce`))) join `user` on((`annonce`.`idUser` = `user`.`idUser`))) join `valeurcritere` on((`annonce`.`idAnnonce` = `valeurcritere`.`annonce_idAnnonce`))) join `categorie`) join `surcategorie`) join `critere`) where ((`annonce`.`idAnnonce` = `valeurcritere`.`annonce_idAnnonce`) and (`critere`.`idCritere` = `valeurcritere`.`critere_idCritere`) and (`categorie`.`idSurCategorie` = `surcategorie`.`idSurCategorie`) and (`critere`.`idCategorie` = `categorie`.`idCategorie`)) ;
