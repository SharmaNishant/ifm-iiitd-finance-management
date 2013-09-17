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
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `PaidBy` varchar(100) NOT NULL,
  `User_Paid` varchar(100) NOT NULL,
  `User_Received` varchar(100) NOT NULL,
  `Amount` varchar(100) NOT NULL,
  `Date` date NOT NULL,
  `Description` varchar(200) NOT NULL,
  `ReceivedBy` varchar(100) NOT NULL,
  `Serial_No` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Serial_No`),
  UNIQUE KEY `Serial_No_UNIQUE` (`Serial_No`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES ('11083','Priyam Kumar','Nishant Sharma','142383','2013-12-03','Demo','11070',1),('11070','Nishant Sharma','Rishav Jain','342342','2013-10-04','Demo','11088',2),('11088','Rishav Jain','Mayank Garg','3412312','2013-10-02','Demo','11065',3),('11065','Mayank Garg','Saurabh Arya','131231','2013-10-03','Demo','11100',4),('11100','Saurabh Arya','Priyam Kumar','343241','2013-09-09','Demo','11083',5),('11083','Priyam Kumar','Nishant Sharma','312312','2013-09-09','Demo','11070',6),('11065','Mayank Garg','Priyam Kumar','123132','2013-10-08','Demo','11083',7),('11070','Nishant Sharma','Mayank Garg','123211','2013-10-12','Demo','11065',8),('11100','Saurabh Arya','Nishant Sharma','34312','2013-04-03','Demo','11070',9),('11070','Nishant Sharma','Priyam Kumar','341231','2013-11-05','Demo','11083',10),('11088','Rishav Jain','Saurabh Arya','23218','2013-08-04','Demo','11100',11),('11100','Saurabh Arya','Mayank Garg','2131241','2013-11-04','Demo','11065',12),('11083','Priyam Kumar','Rishav jain','131231','2013-08-08','Demo','11088',13),('11088','Rishav Jain','Nishant Sharma','341231','2013-04-03','Demo','11070',14),('11065','Mayank Garg','Nishant Sharma','343122','2013-09-10','Demo','11070',15);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
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
