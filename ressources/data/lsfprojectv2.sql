-- MySQL Script generated by MySQL Workbench
-- Thu Mar  4 16:24:50 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema lsfproject
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema lsfproject
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lsfproject` ;
USE `lsfproject` ;

-- -----------------------------------------------------
-- Table `lsfproject`.`video`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lsfproject`.`video` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(155) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idvideo_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `url_UNIQUE` (`url` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lsfproject`.`genre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lsfproject`.`genre` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lsfproject`.`nombre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lsfproject`.`nombre` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lsfproject`.`catGram`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lsfproject`.`catGram` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lsfproject`.`mot`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lsfproject`.`mot` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ortho` VARCHAR(75) NOT NULL,
  `lemme` VARCHAR(75) NOT NULL,
  `infover` VARCHAR(75) NULL,
  `nblettres` INT NULL,
  `nbsyll` INT NULL,
  `orthrenv` VARCHAR(45) NOT NULL,
  `video_id` INT NOT NULL,
  `genre_id` INT NOT NULL,
  `nombre_id` INT NOT NULL,
  `catGram_id` INT NOT NULL,
  PRIMARY KEY (`id`, `video_id`, `genre_id`, `nombre_id`, `catGram_id`),
  UNIQUE INDEX `idword_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_mot_video1_idx` (`video_id` ASC) VISIBLE,
  INDEX `fk_mot_genre1_idx` (`genre_id` ASC) VISIBLE,
  INDEX `fk_mot_nombre1_idx` (`nombre_id` ASC) VISIBLE,
  INDEX `fk_mot_catGram1_idx` (`catGram_id` ASC) VISIBLE,
  UNIQUE INDEX `video_id_UNIQUE` (`video_id` ASC) VISIBLE,
  UNIQUE INDEX `genre_id_UNIQUE` (`genre_id` ASC) VISIBLE,
  UNIQUE INDEX `nombre_id_UNIQUE` (`nombre_id` ASC) VISIBLE,
  UNIQUE INDEX `catGram_id_UNIQUE` (`catGram_id` ASC) VISIBLE,
  CONSTRAINT `fk_mot_video1`
    FOREIGN KEY (`video_id`)
    REFERENCES `lsfproject`.`video` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_mot_genre1`
    FOREIGN KEY (`genre_id`)
    REFERENCES `lsfproject`.`genre` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_mot_nombre1`
    FOREIGN KEY (`nombre_id`)
    REFERENCES `lsfproject`.`nombre` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_mot_catGram1`
    FOREIGN KEY (`catGram_id`)
    REFERENCES `lsfproject`.`catGram` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lsfproject`.`theme`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lsfproject`.`theme` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idtheme_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lsfproject`.`mot_has_theme`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lsfproject`.`mot_has_theme` (
  `mot_id` INT NOT NULL,
  `theme_id` INT NOT NULL,
  PRIMARY KEY (`mot_id`, `theme_id`),
  INDEX `fk_word_has_theme_theme1_idx` (`theme_id` ASC) VISIBLE,
  INDEX `fk_word_has_theme_word_idx` (`mot_id` ASC) VISIBLE,
  CONSTRAINT `fk_word_has_theme_word`
    FOREIGN KEY (`mot_id`)
    REFERENCES `lsfproject`.`mot` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_word_has_theme_theme1`
    FOREIGN KEY (`theme_id`)
    REFERENCES `lsfproject`.`theme` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lsfproject`.`signe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lsfproject`.`signe` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `img` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idsigne_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `img_UNIQUE` (`img` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lsfproject`.`letter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lsfproject`.`letter` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `letter` VARCHAR(5) NOT NULL,
  `signe_id` INT NOT NULL,
  PRIMARY KEY (`id`, `signe_id`),
  UNIQUE INDEX `idletter_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `letter_UNIQUE` (`letter` ASC) VISIBLE,
  INDEX `fk_letter_signe1_idx` (`signe_id` ASC) VISIBLE,
  CONSTRAINT `fk_letter_signe1`
    FOREIGN KEY (`signe_id`)
    REFERENCES `lsfproject`.`signe` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
