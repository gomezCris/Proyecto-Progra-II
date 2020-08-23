-- MySQL dump 10.17  Distrib 10.3.22-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: dnzmakers.com    Database: gearsgtc_java_hospital
-- ------------------------------------------------------
-- Server version	5.6.41-84.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hl_Employees`
--

DROP TABLE IF EXISTS `hl_Employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hl_Employees` (
  `employees_id` int(11) NOT NULL AUTO_INCREMENT,
  `employees_startdate` date NOT NULL,
  `employees_salary` float NOT NULL,
  `employees_positionTitle` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `employees_username` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `employees_password` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `employees_stopdate` date DEFAULT NULL,
  `employees_active` tinyint(1) DEFAULT '1',
  `user_id` int(11) NOT NULL,
  `speciality_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `employees_register` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`employees_id`),
  KEY `fk_employeuser` (`user_id`),
  KEY `fk_employerole` (`role_id`),
  KEY `fk_employespeciality` (`speciality_id`),
  CONSTRAINT `fk_employerole` FOREIGN KEY (`role_id`) REFERENCES `hl_Roles` (`role_id`),
  CONSTRAINT `fk_employespeciality` FOREIGN KEY (`speciality_id`) REFERENCES `hl_Specialitys` (`speciality_id`),
  CONSTRAINT `fk_employeuser` FOREIGN KEY (`user_id`) REFERENCES `hl_Users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hl_Employees`
--

LOCK TABLES `hl_Employees` WRITE;
/*!40000 ALTER TABLE `hl_Employees` DISABLE KEYS */;
/*!40000 ALTER TABLE `hl_Employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hl_Modules`
--

DROP TABLE IF EXISTS `hl_Modules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hl_Modules` (
  `module_id` int(11) NOT NULL,
  `module_name` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `module_description` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hl_Modules`
--

LOCK TABLES `hl_Modules` WRITE;
/*!40000 ALTER TABLE `hl_Modules` DISABLE KEYS */;
/*!40000 ALTER TABLE `hl_Modules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hl_Patients`
--

DROP TABLE IF EXISTS `hl_Patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hl_Patients` (
  `patient_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_startdate` date NOT NULL,
  `patient_username` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `patient_password` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `patient_stopdate` date DEFAULT NULL,
  `patient_active` tinyint(1) DEFAULT '1',
  `user_id` int(11) NOT NULL,
  `patient_register` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`patient_id`),
  KEY `fk_patientuser` (`user_id`),
  CONSTRAINT `fk_patientuser` FOREIGN KEY (`user_id`) REFERENCES `hl_Users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hl_Patients`
--

LOCK TABLES `hl_Patients` WRITE;
/*!40000 ALTER TABLE `hl_Patients` DISABLE KEYS */;
/*!40000 ALTER TABLE `hl_Patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hl_Permissions`
--

DROP TABLE IF EXISTS `hl_Permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hl_Permissions` (
  `role_id` int(11) NOT NULL,
  `module_id` int(11) NOT NULL,
  `permission_create` tinyint(1) DEFAULT '0',
  `permission_read` tinyint(1) DEFAULT '0',
  `permission_update` tinyint(1) DEFAULT '0',
  `permission_delete` tinyint(1) DEFAULT '0',
  KEY `fk_permissionrole` (`role_id`),
  KEY `fk_permissionmodule` (`module_id`),
  CONSTRAINT `fk_permissionmodule` FOREIGN KEY (`module_id`) REFERENCES `hl_Modules` (`module_id`),
  CONSTRAINT `fk_permissionrole` FOREIGN KEY (`role_id`) REFERENCES `hl_Roles` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hl_Permissions`
--

LOCK TABLES `hl_Permissions` WRITE;
/*!40000 ALTER TABLE `hl_Permissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `hl_Permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hl_Roles`
--

DROP TABLE IF EXISTS `hl_Roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hl_Roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `role_description` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role_active` tinyint(1) DEFAULT '1',
  `role_register` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hl_Roles`
--

LOCK TABLES `hl_Roles` WRITE;
/*!40000 ALTER TABLE `hl_Roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `hl_Roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hl_Specialitys`
--

DROP TABLE IF EXISTS `hl_Specialitys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hl_Specialitys` (
  `speciality_id` int(11) NOT NULL AUTO_INCREMENT,
  `speciality_name` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `speciality_description` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`speciality_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hl_Specialitys`
--

LOCK TABLES `hl_Specialitys` WRITE;
/*!40000 ALTER TABLE `hl_Specialitys` DISABLE KEYS */;
/*!40000 ALTER TABLE `hl_Specialitys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hl_Users`
--

DROP TABLE IF EXISTS `hl_Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hl_Users` (
  `user_id` int(11) NOT NULL,
  `user_firstname` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `user_lastname` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `user_email` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `user_phonenumber` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_birthdate` date NOT NULL,
  `user_address` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_active` tinyint(1) DEFAULT '1',
  `user_register` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hl_Users`
--

LOCK TABLES `hl_Users` WRITE;
/*!40000 ALTER TABLE `hl_Users` DISABLE KEYS */;
/*!40000 ALTER TABLE `hl_Users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-22 23:13:32
