CREATE DATABASE  IF NOT EXISTS `ifm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ifm`;
-- MySQL dump 10.13  Distrib 5.6.10, for Win64 (x86_64)
--
-- Host: localhost    Database: ifm
-- ------------------------------------------------------
-- Server version	5.6.10

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
-- Table structure for table `temp_profile`
--

DROP TABLE IF EXISTS `temp_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `temp_profile` (
  `Name` varchar(100) NOT NULL,
  `ContactNumber` varchar(100) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Student/Faculty/Staff` varchar(100) NOT NULL,
  `RollNumber/Emp_ID` varchar(100) NOT NULL,
  `Stream/Department` varchar(100) DEFAULT NULL,
  `City` varchar(100) NOT NULL,
  `Designation` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Email`),
  UNIQUE KEY `Email_UNIQUE` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temp_profile`
--

LOCK TABLES `temp_profile` WRITE;
/*!40000 ALTER TABLE `temp_profile` DISABLE KEYS */;
INSERT INTO `temp_profile` VALUES ('Mayank Garg','7834342355','okhla phase-2','mayank11065@iiitd.ac.in','student','11065','cse','delhi',NULL),('Nishant Sharma','8588242432','okhla phase-4','nishant11070@iiitd.ac.in','student','11070','cse','delhi',NULL),('Priyam Kumar','7838859432','okhla phase-1','priyam11083@iiitd.ac.in','student','11083','cse','delhi',NULL),('Rishav Jain','8588343412','okhla phase-2','rishav11088@iiitd.ac.in','student','11088','cse','delhi',NULL),('Sourabh Arya','8450341232','okhla phase-2','saurabh11100@iiitd.ac.in','student','11100','cse','delhi',NULL);
/*!40000 ALTER TABLE `temp_profile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-09-17 18:31:49
