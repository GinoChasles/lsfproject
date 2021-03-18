-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: lsfproject
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `catgram`
--

DROP TABLE IF EXISTS `catgram`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catgram` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `UK_h00uggauyd2mxnevj2jhf4atx` (`nom`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genre` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lettre`
--

DROP TABLE IF EXISTS `letter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lettre` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lettre` varchar(255) DEFAULT NULL,
  `signe_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8rjkpikeepo02e7hujbkyig9n` (`signe_id`),
  CONSTRAINT `FK8rjkpikeepo02e7hujbkyig9n` FOREIGN KEY (`signe_id`) REFERENCES `signe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
--
-- Table structure for table `mot`
--

DROP TABLE IF EXISTS `mot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mot` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ortho` varchar(75) NOT NULL,
  `lemme` varchar(75) NOT NULL,
  `catgram` int DEFAULT NULL,
  `genre` int DEFAULT NULL,
  `nombre` int DEFAULT NULL,
  `infover` varchar(75) DEFAULT NULL,
  `nblettres` int DEFAULT NULL,
  `nbsyll` int DEFAULT NULL,
  `orthrenv` varchar(45) NOT NULL,
  `video` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idword_UNIQUE` (`id`),
  KEY `id_genre_idx` (`genre`),
  KEY `FKr5rcvo8fk8xwekgymjfnykxtq` (`catgram`),
  KEY `FKf5w3p120310e0r8n4cou8y7s9` (`video`),
  KEY `FKr9ngjw2smakfww37gmmktxjfu` (`nombre`),
  CONSTRAINT `FKex8n6wf33bevigy8qlf3leuyn` FOREIGN KEY (`nombre`) REFERENCES `genre` (`id`),
  CONSTRAINT `FKf5w3p120310e0r8n4cou8y7s9` FOREIGN KEY (`video`) REFERENCES `video` (`id`),
  CONSTRAINT `FKr5rcvo8fk8xwekgymjfnykxtq` FOREIGN KEY (`catgram`) REFERENCES `catgram` (`id`),
  CONSTRAINT `FKr9ngjw2smakfww37gmmktxjfu` FOREIGN KEY (`nombre`) REFERENCES `nombre` (`id`),
  CONSTRAINT `id_genre` FOREIGN KEY (`genre`) REFERENCES `genre` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=142695 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `nombre`
--

DROP TABLE IF EXISTS `nombre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nombre` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `signe`
--

DROP TABLE IF EXISTS `signe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `signe` (
  `id` int NOT NULL AUTO_INCREMENT,
  `img` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idsigne_UNIQUE` (`id`),
  UNIQUE KEY `img_UNIQUE` (`img`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `video` (
  `id` int NOT NULL AUTO_INCREMENT,
  `url` varchar(155) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idvideo_UNIQUE` (`id`),
  UNIQUE KEY `url_UNIQUE` (`url`),
  UNIQUE KEY `UK_qklbb3pxuduaylyd0g1m7wujx` (`url`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-18 11:04:10
