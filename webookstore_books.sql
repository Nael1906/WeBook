-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: webookstore
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.27-MariaDB

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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `is_borrowed` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'The subtle art of not giving a fuck','1234','This is an example description.',1),(2,'1984','N1984','Dystopian fiction by George Orwell',0),(3,'The Great Gatsby','TGG002','Classic by F. Scott Fitzgerald',0),(4,'The Catcher in the Rye','TCITR003','Novel by J.D. Salinger',1),(5,'Harry Potter and the Sorcerer\'s Stone','HP001','Fantasy by J.K. Rowling',1),(6,'The Hobbit','TH001','Fantasy novel by J.R.R. Tolkien',0),(7,'To the Lighthouse','TTL004','Modernist novel by Virginia Woolf',0),(8,'The Hunger Games','THG005','Dystopian novel by Suzanne Collins',0),(9,'Pride and Prejudice','PAP006','Classic by Jane Austen',0),(10,'The Da Vinci Code','TDVC007','Mystery thriller by Dan Brown',0),(11,'The Lord of the Rings','LOTR008','Fantasy trilogy by J.R.R. Tolkien. Follow the quest to destroy the One Ring and defeat Dark Lord Sauron. Epic with rich mythology, diverse characters, and themes of friendship.',0),(12,'Jane Eyre','JE009','Classic novel by Charlotte Brontë. Follows the life of orphaned and mistreated Jane Eyre. Explores themes of love, morality, and social class.',0),(13,'The Chronicles of Narnia','NARNIA010','Fantasy series by C.S. Lewis. Adventures in the magical land of Narnia unfold in seven books, exploring themes of courage, destiny, and the battle between good and evil.',0),(14,'Brave New World','BNW011','Dystopian novel by Aldous Huxley. Set in a futuristic society where people are genetically engineered. Explores the consequences of a highly controlled and pleasure-driven world.',0),(15,'The Hitchhiker\'s Guide to the Galaxy','HGTTG012','Comedic science fiction series by Douglas Adams. Follows the misadventures of Earthling Arthur Dent and his alien friend Ford Prefect. Satirizes various aspects of human existence and the universe.',0);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-23  6:11:28
