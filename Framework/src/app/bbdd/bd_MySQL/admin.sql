-- MySQL dump 10.13  Distrib 5.7.9, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: admin
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.9-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `dni` varchar(10) CHARACTER SET latin1 NOT NULL,
  `name` varchar(50) CHARACTER SET latin1 NOT NULL,
  `subname` varchar(100) CHARACTER SET latin1 NOT NULL,
  `mobile` varchar(20) CHARACTER SET latin1 NOT NULL,
  `email` varchar(50) CHARACTER SET latin1 NOT NULL,
  `date_birthday` varchar(20) CHARACTER SET latin1 NOT NULL,
  `age` int(11) NOT NULL,
  `user` varchar(45) CHARACTER SET latin1 NOT NULL,
  `pass` varchar(45) CHARACTER SET latin1 NOT NULL,
  `avatar` varchar(200) CHARACTER SET latin1 NOT NULL,
  `state` varchar(20) CHARACTER SET latin1 NOT NULL,
  `hiring_date` varchar(20) CHARACTER SET latin1 NOT NULL,
  `years_service` int(11) NOT NULL,
  `salary` float NOT NULL,
  `activity` int(11) NOT NULL,
  PRIMARY KEY (`dni`),
  UNIQUE KEY `user` (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('00000000T','Pepe','Sellés','650123478','ejemplo@ej.com','08/03/1972',44,'Nombre de usuario','jPasswordField1','image.jpg','Online','06/03/2013',3,234.123,234),('11111111H','Juana','Martínez','123456789','asd@asd.asd','16/04/1986',30,'user','1234','image.jpg','Online','06/04/2016',0,123.123,123),('12345678Z','Nana','Sellés','650123478','ejemplo@ej.coma','13/03/1981',35,'NanananaBa','holacarabola','image.jpg','Offline','01/03/2016',0,123.234,2134),('33333333P','Marcos','Sánches','654635345','asd@gmail.com','18/04/1990',26,'ussser:D','345','image.jpg','Online','11/04/2013',3,213,123),('44444444A','Fernando','Ape Llido','12323132','dsfjijdsf@gmail.com','10/04/1992',24,'Fer','hdkjfsh','image.jpg','Online','04/04/2014',2,423,23),('55555555K','Juan','sad asd','12312213','sad@asd.asd','01/04/1988',28,'nipaasdasd','sad','image.jpg','Online','01/04/2016',0,213.189,123),('87654321X','Lucía','Algo','666666666','asd2@asd.as','03/04/1987',29,'Meh','234º','image.jpg','Online','01/04/2016',0,12.123,123123);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'admin'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-28 17:41:58
