-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              8.0.23 - MySQL Community Server - GPL
-- S.O. server:                  Win64
-- HeidiSQL Versione:            11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dump della struttura del database demojpaannotation
CREATE DATABASE IF NOT EXISTS `demojpaannotation` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `demojpaannotation`;

-- Dump della struttura di tabella demojpaannotation.corsodilaurea
CREATE TABLE IF NOT EXISTS `corsodilaurea` (
  `id` int NOT NULL AUTO_INCREMENT,
  `anno` int DEFAULT NULL,
  `facolta` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella demojpaannotation.indirizzo
CREATE TABLE IF NOT EXISTS `indirizzo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `via` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `civico` varchar(50) DEFAULT NULL,
  `cap` varchar(50) DEFAULT NULL,
  `citta` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella demojpaannotation.materia
CREATE TABLE IF NOT EXISTS `materia` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella demojpaannotation.materie_sostenute
CREATE TABLE IF NOT EXISTS `materie_sostenute` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_materia` int DEFAULT NULL,
  `id_studente` int DEFAULT NULL,
  `voto` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__materia` (`id_materia`),
  KEY `FK__studente` (`id_studente`),
  CONSTRAINT `FK__materia` FOREIGN KEY (`id_materia`) REFERENCES `materia` (`id`),
  CONSTRAINT `FK__studente` FOREIGN KEY (`id_studente`) REFERENCES `studente` (`matricola`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella demojpaannotation.studente
CREATE TABLE IF NOT EXISTS `studente` (
  `matricola` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `cognome` varchar(50) DEFAULT NULL,
  `id_indirizzo` int DEFAULT NULL,
  `id_corso_laurea` int DEFAULT NULL,
  PRIMARY KEY (`matricola`),
  KEY `FK_studente_indirizzo` (`id_indirizzo`),
  KEY `FK_studente_corsodilaurea` (`id_corso_laurea`),
  CONSTRAINT `FK_studente_corsodilaurea` FOREIGN KEY (`id_corso_laurea`) REFERENCES `corsodilaurea` (`id`),
  CONSTRAINT `FK_studente_indirizzo` FOREIGN KEY (`id_indirizzo`) REFERENCES `indirizzo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- L’esportazione dei dati non era selezionata.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
