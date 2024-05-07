-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: baltimorecountygis
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `developmentplan`
--

DROP TABLE IF EXISTS `developmentplan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `developmentplan` (
  `ConveyanceID` int NOT NULL,
  `HyperLink` varchar(45) DEFAULT NULL,
  `DateAdded` varchar(45) DEFAULT NULL,
  `Editor` varchar(45) DEFAULT NULL,
  `GISID` int DEFAULT NULL,
  PRIMARY KEY (`ConveyanceID`),
  KEY `gisid_idx` (`GISID`),
  CONSTRAINT `convid` FOREIGN KEY (`ConveyanceID`) REFERENCES `sources` (`ConveyanceID`),
  CONSTRAINT `gisid` FOREIGN KEY (`GISID`) REFERENCES `planlayer` (`GISID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `developmentplan`
--

LOCK TABLES `developmentplan` WRITE;
/*!40000 ALTER TABLE `developmentplan` DISABLE KEYS */;
INSERT INTO `developmentplan` VALUES (183,'echo.com','06/24/2023','Emma',11),(235,'phoenix.com','08/01/2022','David',22),(327,'quantum.com','06/23/2023','Ava',33),(419,'luna.com','01/02/2022','Noah',44),(594,'stellar.com','05/08/2022','Emma',55),(652,'nova.com','02/02/2022','David',66),(876,'azure.com','03/03/2022','Ava',77);
/*!40000 ALTER TABLE `developmentplan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `editor`
--

DROP TABLE IF EXISTS `editor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `editor` (
  `StaffID` int NOT NULL,
  PRIMARY KEY (`StaffID`),
  CONSTRAINT `EditorID` FOREIGN KEY (`StaffID`) REFERENCES `member` (`StaffID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editor`
--

LOCK TABLES `editor` WRITE;
/*!40000 ALTER TABLE `editor` DISABLE KEYS */;
INSERT INTO `editor` VALUES (0),(1),(2),(3),(4),(5),(6);
/*!40000 ALTER TABLE `editor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `it`
--

DROP TABLE IF EXISTS `it`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `it` (
  `StaffID` int NOT NULL,
  PRIMARY KEY (`StaffID`),
  CONSTRAINT `staff` FOREIGN KEY (`StaffID`) REFERENCES `member` (`StaffID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `it`
--

LOCK TABLES `it` WRITE;
/*!40000 ALTER TABLE `it` DISABLE KEYS */;
INSERT INTO `it` VALUES (2),(5);
/*!40000 ALTER TABLE `it` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `limitedexception`
--

DROP TABLE IF EXISTS `limitedexception`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `limitedexception` (
  `ConveyanceID` int NOT NULL,
  `MPNumber` int NOT NULL,
  PRIMARY KEY (`ConveyanceID`,`MPNumber`),
  CONSTRAINT `conveyance` FOREIGN KEY (`ConveyanceID`) REFERENCES `developmentplan` (`ConveyanceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `limitedexception`
--

LOCK TABLES `limitedexception` WRITE;
/*!40000 ALTER TABLE `limitedexception` DISABLE KEYS */;
INSERT INTO `limitedexception` VALUES (183,1222),(235,1666),(327,8888),(419,1444),(594,9999),(652,1555),(876,1333);
/*!40000 ALTER TABLE `limitedexception` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `majortype`
--

DROP TABLE IF EXISTS `majortype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `majortype` (
  `ConveyanceID` int NOT NULL,
  PRIMARY KEY (`ConveyanceID`),
  CONSTRAINT `ciD` FOREIGN KEY (`ConveyanceID`) REFERENCES `developmentplan` (`ConveyanceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `majortype`
--

LOCK TABLES `majortype` WRITE;
/*!40000 ALTER TABLE `majortype` DISABLE KEYS */;
INSERT INTO `majortype` VALUES (183),(235),(327),(419),(594),(652),(876);
/*!40000 ALTER TABLE `majortype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `StaffID` int NOT NULL,
  `Fname` varchar(45) DEFAULT NULL,
  `Lname` varchar(45) DEFAULT NULL,
  `PhoneNumber` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `JobType` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`StaffID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (0,'Emma','Johnson','555-123-4567','emma@gmail.com','Editor'),(1,'David','Smith','555-987-6543','david@gmail.com','Editor'),(2,'Sophia','Williams','555-555-1212','sophia@gmail.com','IT'),(3,'Ethan','Brown','555-888-9999','ethan@gmail.com','Program Manager'),(4,'Ava','Garcia','555-369-8521','ava@gmail.com','Editor'),(5,'Olivia','Martinez','555-777-8888','olivia@gmail.com','IT'),(6,'Noah','Taylor','555-431-1098','noah@gmail.com','Editor');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `minortype`
--

DROP TABLE IF EXISTS `minortype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `minortype` (
  `ConveyanceID` int NOT NULL,
  `MPNumber` int NOT NULL,
  PRIMARY KEY (`ConveyanceID`,`MPNumber`),
  CONSTRAINT `conv` FOREIGN KEY (`ConveyanceID`) REFERENCES `developmentplan` (`ConveyanceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `minortype`
--

LOCK TABLES `minortype` WRITE;
/*!40000 ALTER TABLE `minortype` DISABLE KEYS */;
INSERT INTO `minortype` VALUES (183,3333),(235,7777),(327,1111),(419,5555),(594,2222),(652,6666),(876,4444);
/*!40000 ALTER TABLE `minortype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planlayer`
--

DROP TABLE IF EXISTS `planlayer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `planlayer` (
  `GISID` int NOT NULL,
  `DateMapped` varchar(45) DEFAULT NULL,
  `Editor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`GISID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planlayer`
--

LOCK TABLES `planlayer` WRITE;
/*!40000 ALTER TABLE `planlayer` DISABLE KEYS */;
INSERT INTO `planlayer` VALUES (11,'02/03/2022','David'),(22,'01/04/2022','Emma'),(33,'03/03/2022','Noah'),(44,'07/08/2022','Ava'),(55,'03/02/2022','David'),(66,'01/29/2022','Emma'),(77,'07/08/2022','Noah');
/*!40000 ALTER TABLE `planlayer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plat`
--

DROP TABLE IF EXISTS `plat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plat` (
  `ConveyanceID` int NOT NULL,
  `Book` varchar(45) DEFAULT NULL,
  `Page` varchar(45) DEFAULT NULL,
  `GISID` int DEFAULT NULL,
  `isRevised` int DEFAULT NULL,
  PRIMARY KEY (`ConveyanceID`),
  KEY `gID_idx` (`GISID`),
  CONSTRAINT `convID__` FOREIGN KEY (`ConveyanceID`) REFERENCES `sources` (`ConveyanceID`),
  CONSTRAINT `gID` FOREIGN KEY (`GISID`) REFERENCES `platlayer` (`GISID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plat`
--

LOCK TABLES `plat` WRITE;
/*!40000 ALTER TABLE `plat` DISABLE KEYS */;
INSERT INTO `plat` VALUES (183,'Catalyst','23',11,1),(235,'Serendipity','14',22,1),(327,'Echoes','45',33,0),(419,'Wanderlust','87',44,1),(594,'Mirage','48',55,0),(652,'Luminary','32',66,0),(876,'Elysium','68',77,1);
/*!40000 ALTER TABLE `plat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platlayer`
--

DROP TABLE IF EXISTS `platlayer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `platlayer` (
  `GISID` int NOT NULL,
  `DateIntegrated` varchar(45) DEFAULT NULL,
  `EditorName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`GISID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platlayer`
--

LOCK TABLES `platlayer` WRITE;
/*!40000 ALTER TABLE `platlayer` DISABLE KEYS */;
INSERT INTO `platlayer` VALUES (11,'02/02/2022','David'),(22,'03/04/2022','Ava'),(33,'08/08/2022','Noah'),(44,'04/04/2022','Emma'),(55,'02/23/2022','David'),(66,'03/14/2022','Ava'),(77,'04/18/2022','Noah');
/*!40000 ALTER TABLE `platlayer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `programmanager`
--

DROP TABLE IF EXISTS `programmanager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `programmanager` (
  `StaffID` int NOT NULL,
  PRIMARY KEY (`StaffID`),
  CONSTRAINT `s` FOREIGN KEY (`StaffID`) REFERENCES `member` (`StaffID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programmanager`
--

LOCK TABLES `programmanager` WRITE;
/*!40000 ALTER TABLE `programmanager` DISABLE KEYS */;
INSERT INTO `programmanager` VALUES (3);
/*!40000 ALTER TABLE `programmanager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sources`
--

DROP TABLE IF EXISTS `sources`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sources` (
  `ConveyanceID` int NOT NULL,
  `DateRecieved` varchar(45) DEFAULT NULL,
  `ProjectStatus` varchar(45) DEFAULT NULL,
  `ProjectName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ConveyanceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sources`
--

LOCK TABLES `sources` WRITE;
/*!40000 ALTER TABLE `sources` DISABLE KEYS */;
INSERT INTO `sources` VALUES (183,'04/08/2023','Incomplete','Echo'),(235,'03/29/2022','Complete','Phoenix'),(327,'01/01/2023','Complete','Quantum'),(419,'12/08/2022','Complete','Luna'),(594,'01/02/2023','Incomplete','Stellar'),(652,'02/17/2022','Incomplete','Nova'),(876,'09/23/2023','Complete','Azure');
/*!40000 ALTER TABLE `sources` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `works_on`
--

DROP TABLE IF EXISTS `works_on`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `works_on` (
  `StaffID` int NOT NULL,
  `ConveyanceID` int NOT NULL,
  PRIMARY KEY (`StaffID`,`ConveyanceID`),
  KEY `conveyanceid_idx` (`ConveyanceID`),
  CONSTRAINT `conveyanceid` FOREIGN KEY (`ConveyanceID`) REFERENCES `sources` (`ConveyanceID`),
  CONSTRAINT `staffid` FOREIGN KEY (`StaffID`) REFERENCES `editor` (`StaffID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `works_on`
--

LOCK TABLES `works_on` WRITE;
/*!40000 ALTER TABLE `works_on` DISABLE KEYS */;
INSERT INTO `works_on` VALUES (2,183),(6,235),(0,327),(4,419),(1,594),(5,652),(3,876);
/*!40000 ALTER TABLE `works_on` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-07 10:56:21
