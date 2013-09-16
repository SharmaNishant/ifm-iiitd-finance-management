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
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profile` (
  `Name` varchar(100) NOT NULL,
  `ContactNumber` varchar(100) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Student/Faculty/Staff` varchar(100) NOT NULL,
  `RollNumber/Emp_ID` varchar(100) NOT NULL,
  `Stream/Department` varchar(100) DEFAULT NULL,
  `City` varchar(100) DEFAULT NULL,
  `Designation` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Email`),
  UNIQUE KEY `Email_UNIQUE` (`Email`),
  UNIQUE KEY `ContactNumber_UNIQUE` (`ContactNumber`),
  UNIQUE KEY `RollNumber/Emp_ID_UNIQUE` (`RollNumber/Emp_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile`
--

LOCK TABLES `profile` WRITE;
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
INSERT INTO `profile` VALUES ('Albert Einstien','000000132','slovakia chek zuru road','alben@mc2.com','faculty','342422','','germany','scientist'),('CarlJohnson','123458349','sanandreas street','cj@sa.com','faculty','e12323',NULL,'san francisco',NULL),('Mayank','8934348933','123,red fort lal quila','mayank@iiitd.ac.in','student','11070','cse','ghaziabad',NULL),('Nishant Sharma','34458783434','421,ononfof','nishant@iiitd.ac.in','student','11069','cse','delhi',''),('Priyam kumar','7838859446','1306,kanchanjunga tower kaushambi ','priyam11083@iiitd.a.cin','student','11083','cse','ghaziabad',''),('Rishav','34934900343','421,chandni chowk chhavri bazaar','rishav@iiitd.ac.in','student','11089','cse','delhi',NULL),('Shinchan','3423234454','chun guana street bolkare','shin@chan.com','student','11081','cse','china',''),('Honey Singh','2343253580','shivpuri road ','singh@honey.com','student','12120','cse','punjab',NULL),('Eminem','349231241','rapper street','slimshady@google.com','student','11090','cse','chicago','singer'),('sourabh arya','09093543434','123,cp road ','souarbh@iiitd.ac.in','faculty','e13440',NULL,'delhi',NULL),('gdfsdf','334324','fdsfdsfds','t@y.com','staff','e133','cse','gs','s'),('tommy','4534534632','balton street ','tom@yahoo.com','staff','e45134',NULL,'new york','servant');
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-09-16 20:38:55
