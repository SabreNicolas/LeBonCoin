-- -----------------------------------------------------
-- Schema lesupercoin
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lesupercoin` DEFAULT CHARACTER SET utf8 ;
USE `lesupercoin` ;

-- -----------------------------------------------------
-- Table `lesupercoin`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lesupercoin`.`user` ;

CREATE TABLE IF NOT EXISTS `lesupercoin`.`user` (
  `idUser` INT NOT NULL,
  `nom` VARCHAR(45) NOT NULL,
  `prenom` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `mail` VARCHAR(45) NOT NULL,
  `mdp` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lesupercoin`.`surCategorie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lesupercoin`.`surCategorie` ;

CREATE TABLE IF NOT EXISTS `lesupercoin`.`surCategorie` (
  `idSurCategorie` INT NOT NULL,
  `nomSurCategorie` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idSurCategorie`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lesupercoin`.`categorie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lesupercoin`.`categorie` ;

CREATE TABLE IF NOT EXISTS `lesupercoin`.`categorie` (
  `idCategorie` INT NOT NULL,
  `nomCategorie` VARCHAR(45) NOT NULL,
  `idSurCategorie` INT NOT NULL,
  PRIMARY KEY (`idCategorie`),
  INDEX `surcategorie_idx` (`idSurCategorie` ASC) ,
  CONSTRAINT `surcategorie`
    FOREIGN KEY (`idSurCategorie`)
    REFERENCES `lesupercoin`.`surCategorie` (`idSurCategorie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lesupercoin`.`annonce`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lesupercoin`.`annonce` ;

CREATE TABLE IF NOT EXISTS `lesupercoin`.`annonce` (
  `idAnnonce` INT NOT NULL,
  `statut` TINYINT NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `idCategorie` INT NOT NULL,
  `idUser` INT NOT NULL,
  PRIMARY KEY (`idAnnonce`),
  INDEX `categorie_idx` (`idCategorie` ASC) ,
  INDEX `user_idx` (`idUser` ASC) ,
  CONSTRAINT `categorie`
    FOREIGN KEY (`idCategorie`)
    REFERENCES `lesupercoin`.`categorie` (`idCategorie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user`
    FOREIGN KEY (`idUser`)
    REFERENCES `lesupercoin`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lesupercoin`.`photo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lesupercoin`.`photo` ;

CREATE TABLE IF NOT EXISTS `lesupercoin`.`photo` (
  `idPhoto` INT NOT NULL,
  `photo` TEXT NOT NULL,
  `idAnnonce` INT NOT NULL,
  PRIMARY KEY (`idPhoto`),
  INDEX `annonce_idx` (`idAnnonce` ASC) ,
  CONSTRAINT `annonce`
    FOREIGN KEY (`idAnnonce`)
    REFERENCES `lesupercoin`.`annonce` (`idAnnonce`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lesupercoin`.`critere`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lesupercoin`.`critere` ;

CREATE TABLE IF NOT EXISTS `lesupercoin`.`critere` (
  `idCritere` INT NOT NULL,
  `nomCritere` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `idCategorie` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idCritere`),
  INDEX `categorie_idx` (`idCategorie` ASC) ,
  CONSTRAINT `categorie`
    FOREIGN KEY (`idCategorie`)
    REFERENCES `lesupercoin`.`categorie` (`idCategorie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lesupercoin`.`valeurCritere`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lesupercoin`.`valeurCritere` ;

CREATE TABLE IF NOT EXISTS `lesupercoin`.`valeurCritere` (
  `idValeurCritere` INT NOT NULL,
  `valeur` VARCHAR(45) NOT NULL,
  `idAnnonce` INT NOT NULL,
  `idCritere` INT NOT NULL,
  PRIMARY KEY (`idValeurCritere`),
  INDEX `annonce_idx` (`idAnnonce` ASC) ,
  INDEX `critere_idx` (`idCritere` ASC) ,
  CONSTRAINT `annonce`
    FOREIGN KEY (`idAnnonce`)
    REFERENCES `lesupercoin`.`annonce` (`idAnnonce`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `critere`
    FOREIGN KEY (`idCritere`)
    REFERENCES `lesupercoin`.`critere` (`idCritere`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
