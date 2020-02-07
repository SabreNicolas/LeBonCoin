-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le :  ven. 07 fév. 2020 à 12:20
-- Version du serveur :  5.7.21
-- Version de PHP :  7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `lesupercoin`
--
create database lesupercoin;

use lesupercoin;
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

-- --------------------------------------------------------

--
-- Structure de la table `critere`
--

CREATE TABLE `critere` (
  `idCritere` int(11) NOT NULL,
  `nomCritere` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `idCategorie` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `critere`
--

INSERT INTO `critere` (`idCritere`, `nomCritere`, `type`, `idCategorie`) VALUES
(1, 'Prix', 'Float', NULL),
(2, 'Localisation', 'Enum', NULL);

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

-- --------------------------------------------------------

--
-- Structure de la table `valeurCritere`
--

CREATE TABLE `valeurCritere` (
  `idValeurCritere` int(11) NOT NULL,
  `valeur` varchar(45) NOT NULL,
  `idAnnonce` int(11) NOT NULL,
  `idCritere` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  ADD KEY `categorie_idx` (`idCategorie`);

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
  ADD PRIMARY KEY (`idValeurCritere`),
  ADD KEY `annonce_idx` (`idAnnonce`),
  ADD KEY `critere_idx` (`idCritere`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `annonce`
--
ALTER TABLE `annonce`
  MODIFY `idAnnonce` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `idCategorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT pour la table `critere`
--
ALTER TABLE `critere`
  MODIFY `idCritere` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `photo`
--
ALTER TABLE `photo`
  MODIFY `idPhoto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `surCategorie`
--
ALTER TABLE `surCategorie`
  MODIFY `idSurCategorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `valeurCritere`
--
ALTER TABLE `valeurCritere`
  MODIFY `idValeurCritere` int(11) NOT NULL AUTO_INCREMENT;

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
  ADD CONSTRAINT `FK_categorie` FOREIGN KEY (`idCategorie`) REFERENCES `categorie` (`idCategorie`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `photo`
--
ALTER TABLE `photo`
  ADD CONSTRAINT `annonce` FOREIGN KEY (`idAnnonce`) REFERENCES `annonce` (`idAnnonce`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `valeurCritere`
--
ALTER TABLE `valeurCritere`
  ADD CONSTRAINT `FK_annonce` FOREIGN KEY (`idAnnonce`) REFERENCES `annonce` (`idAnnonce`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_critere` FOREIGN KEY (`idCritere`) REFERENCES `critere` (`idCritere`) ON DELETE NO ACTION ON UPDATE NO ACTION;
