-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le :  lun. 10 fév. 2020 à 21:48
-- Version du serveur :  5.7.21
-- Version de PHP :  7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `lesupercoin`
--

-- --------------------------------------------------------

--
-- Structure de la table `photo`
--

CREATE TABLE `photo` (
  `idPhoto` int(11) NOT NULL,
  `photo` text NOT NULL,
  `idAnnonce` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `photo`
--

INSERT INTO `photo` (`idPhoto`, `photo`, `idAnnonce`) VALUES
(2, 'test', 5);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `photo`
--
ALTER TABLE `photo`
  ADD PRIMARY KEY (`idPhoto`),
  ADD KEY `annonce_idx` (`idAnnonce`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `photo`
--
ALTER TABLE `photo`
  MODIFY `idPhoto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `photo`
--
ALTER TABLE `photo`
  ADD CONSTRAINT `annonce` FOREIGN KEY (`idAnnonce`) REFERENCES `annonce` (`idAnnonce`) ON DELETE NO ACTION ON UPDATE NO ACTION;
