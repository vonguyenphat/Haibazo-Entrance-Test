-- MySQL dump 10.13  Distrib 8.0.33, for macos13 (arm64)
--
-- Host: localhost    Database: haibazo_entrance_test
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `attribute_value`
--

DROP TABLE IF EXISTS `attribute_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attribute_value` (
  `id` bigint NOT NULL,
  `attributes_id` bigint DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `attributes_id` (`attributes_id`),
  CONSTRAINT `attribute_value_ibfk_1` FOREIGN KEY (`attributes_id`) REFERENCES `attributes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attribute_value`
--

LOCK TABLES `attribute_value` WRITE;
/*!40000 ALTER TABLE `attribute_value` DISABLE KEYS */;
INSERT INTO `attribute_value` VALUES (1,2005,'Moder'),(2,2005,'Streetwear'),(3,2005,'Vintage'),(4,2005,'Colorfull'),(5,2005,'Pathword'),(6,2005,'Bohemian'),(7,2006,'Apple');
/*!40000 ALTER TABLE `attribute_value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attributes`
--

DROP TABLE IF EXISTS `attributes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attributes` (
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attributes`
--

LOCK TABLES `attributes` WRITE;
/*!40000 ALTER TABLE `attributes` DISABLE KEYS */;
INSERT INTO `attributes` VALUES (2005),(2006);
/*!40000 ALTER TABLE `attributes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `slug` varchar(255) DEFAULT NULL,
  `status` int NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Clothing','clothing',1,'Clothing category',_binary '\0','2024-10-09 09:51:10.000000','2024-10-09 09:51:10.000000'),(2,'Electronics','electronics',1,'Electronics category',_binary '\0','2024-10-09 09:51:10.000000','2024-10-09 09:51:10.000000'),(3,'Accessories','accessories',1,'Accessories category',_binary '\0','2024-10-09 09:51:10.000000','2024-10-09 09:51:10.000000'),(4,'Outdoor','outdoor',1,'Outdoor category',_binary '\0','2024-10-09 09:51:10.000000','2024-10-09 09:51:10.000000'),(5,'Home & decor','home-&-decor',1,'Home & decor category',_binary '\0','2024-10-09 09:51:10.000000','2024-10-09 09:51:10.000000');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discount` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `discount_value` double DEFAULT NULL,
  `discount_type` varchar(255) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `images`
--

DROP TABLE IF EXISTS `images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `images` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_id` bigint DEFAULT NULL,
  `src` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `images_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `images`
--

LOCK TABLES `images` WRITE;
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
INSERT INTO `images` VALUES (1,1,'tshirt-front.jpg','2024-10-09 09:51:38.274000','2024-10-09 09:51:38.274000'),(2,1,'tshirt-back.jpg','2024-10-09 09:51:38.276000','2024-10-09 09:51:38.276000'),(3,2,'hoodie-front.jpg','2024-10-09 09:51:49.442000','2024-10-09 09:51:49.442000'),(4,2,'hoodie-back.jpg','2024-10-09 09:51:49.443000','2024-10-09 09:51:49.443000'),(5,3,'jacket-front.jpg','2024-10-09 09:51:58.649000','2024-10-09 09:51:58.649000'),(6,3,'jacket-back.jpg','2024-10-09 09:51:58.652000','2024-10-09 09:51:58.652000'),(7,4,'IPhone-front.jpg','2024-10-09 09:52:07.578000','2024-10-09 09:52:07.578000'),(8,4,'IPhone-back.jpg','2024-10-09 09:52:07.580000','2024-10-09 09:52:07.580000'),(9,5,'tshirt-front.jpg','2024-10-09 09:52:47.356000','2024-10-09 09:52:47.356000'),(10,5,'tshirt-back.jpg','2024-10-09 09:52:47.358000','2024-10-09 09:52:47.358000'),(11,6,'hoodie-front.jpg','2024-10-09 09:53:08.925000','2024-10-09 09:53:08.925000'),(12,6,'hoodie-back.jpg','2024-10-09 09:53:08.927000','2024-10-09 09:53:08.927000');
/*!40000 ALTER TABLE `images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `attribute_value_id` bigint DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `slug` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `thumb` varchar(255) DEFAULT NULL,
  `is_draft` bit(1) DEFAULT NULL,
  `is_published` bit(1) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `attribute_value_id` (`attribute_value_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`attribute_value_id`) REFERENCES `attribute_value` (`id`),
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,1,1,'T-shirt','tshirt','Basic white T-shirt',4,'tshirt.jpg',_binary '\0',_binary '',_binary '\0','2024-10-09 09:51:38.253000','2024-10-09 09:51:38.310000'),(2,2,1,'Hoodie','hoodie','Warm winter hoodie',4.8,'hoodie.jpg',_binary '\0',_binary '',_binary '\0','2024-10-09 09:51:49.436000','2024-10-09 09:51:49.469000'),(3,4,1,'Jacket','jacket','Leather jacket',4.6,'jacket.jpg',_binary '\0',_binary '',_binary '\0','2024-10-09 09:51:58.641000','2024-10-09 09:51:58.683000'),(4,7,2,'IPhone 14','IPhone','IPhone',4.6,'IPhone.jpg',_binary '\0',_binary '',_binary '\0','2024-10-09 09:52:07.570000','2024-10-09 09:52:07.601000'),(5,1,1,'T-shirt OWN Number 1','tshirt','Basic white T-shirt',4,'tshirt.jpg',_binary '\0',_binary '',_binary '\0','2024-10-09 09:52:47.352000','2024-10-09 09:52:47.385000'),(6,2,1,'Hoodie Boxxy','hoodie','Warm winter hoodie',4.8,'hoodie.jpg',_binary '\0',_binary '',_binary '\0','2024-10-09 09:53:08.920000','2024-10-09 09:53:08.956000');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_variation_options`
--

DROP TABLE IF EXISTS `product_variation_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_variation_options` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_variations_id` bigint DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_variations_id` (`product_variations_id`),
  CONSTRAINT `product_variation_options_ibfk_1` FOREIGN KEY (`product_variations_id`) REFERENCES `product_variations` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_variation_options`
--

LOCK TABLES `product_variation_options` WRITE;
/*!40000 ALTER TABLE `product_variation_options` DISABLE KEYS */;
INSERT INTO `product_variation_options` VALUES (1,1,'S'),(2,1,'M'),(3,2,'White'),(4,2,'Black'),(5,3,'S'),(6,3,'L'),(7,4,'Gray'),(8,4,'Black'),(9,5,'M'),(10,5,'L'),(11,6,'Brown'),(12,6,'Black'),(13,7,'Blue titanium'),(14,7,'White titanium'),(15,7,'Natural titanium'),(16,8,'S'),(17,8,'M'),(18,9,'White'),(19,9,'Black'),(20,10,'S'),(21,10,'L'),(22,11,'Gray'),(23,11,'Black');
/*!40000 ALTER TABLE `product_variation_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_variations`
--

DROP TABLE IF EXISTS `product_variations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_variations` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_id` bigint DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `product_variations_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_variations`
--

LOCK TABLES `product_variations` WRITE;
/*!40000 ALTER TABLE `product_variations` DISABLE KEYS */;
INSERT INTO `product_variations` VALUES (1,1,'Size'),(2,1,'Color'),(3,2,'Size'),(4,2,'Color'),(5,3,'Size'),(6,3,'Color'),(7,4,'Color'),(8,5,'Size'),(9,5,'Color'),(10,6,'Size'),(11,6,'Color');
/*!40000 ALTER TABLE `product_variations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skus`
--

DROP TABLE IF EXISTS `skus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skus` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_id` bigint DEFAULT NULL,
  `discount_id` bigint DEFAULT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `slug` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `final_price` double DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `sku_tier_idx` json NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  KEY `discount_id` (`discount_id`),
  CONSTRAINT `skus_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `skus_ibfk_2` FOREIGN KEY (`discount_id`) REFERENCES `discount` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skus`
--

LOCK TABLES `skus` WRITE;
/*!40000 ALTER TABLE `skus` DISABLE KEYS */;
INSERT INTO `skus` VALUES (1,1,NULL,'1.5.4448381043326715E11','TSHIRT-SMALL-WHITE.1.5.4448381043326715E11',19.99,NULL,100,_binary '\0','[0, 0]','2024-10-09 09:51:38.304000','2024-10-09 09:51:38.304000'),(2,1,NULL,'1.1.6326805424294458E11','TSHIRT-MEDIUM-WHITE.1.1.6326805424294458E11',24.99,NULL,80,_binary '\0','[1, 0]','2024-10-09 09:51:38.306000','2024-10-09 09:51:38.306000'),(3,1,NULL,'1.8.955348978648484E11','TSHIRT-MEDIUM-BLACK.1.8.955348978648484E11',24.99,NULL,60,_binary '\0','[1, 1]','2024-10-09 09:51:38.307000','2024-10-09 09:51:38.307000'),(4,1,NULL,'1.7.085375740271415E11','TSHIRT-SMALL-BLACK.1.7.085375740271415E11',19.99,NULL,120,_binary '\0','[0, 1]','2024-10-09 09:51:38.308000','2024-10-09 09:51:38.308000'),(5,2,NULL,'2.7.060688045680802E11','HOODIE-SMALL-GRAY.2.7.060688045680802E11',49.99,NULL,40,_binary '\0','[0, 0]','2024-10-09 09:51:49.464000','2024-10-09 09:51:49.464000'),(6,2,NULL,'2.3.494693648465048E11','HOODIE-LARGE-GRAY.2.3.494693648465048E11',59.99,NULL,30,_binary '\0','[1, 0]','2024-10-09 09:51:49.466000','2024-10-09 09:51:49.466000'),(7,2,NULL,'2.8.165913522848688E11','HOODIE-LARGE-BLACK.2.8.165913522848688E11',59.99,NULL,20,_binary '\0','[1, 1]','2024-10-09 09:51:49.467000','2024-10-09 09:51:49.467000'),(8,2,NULL,'2.3.4275874099043175E10','HOODIE-SMALL-BLACK.2.3.4275874099043175E10',49.99,NULL,50,_binary '\0','[0, 1]','2024-10-09 09:51:49.468000','2024-10-09 09:51:49.468000'),(9,3,NULL,'3.3.9235462919661127E11','JACKET-MEDIUM-BROWN.3.3.9235462919661127E11',99.99,NULL,30,_binary '\0','[0, 0]','2024-10-09 09:51:58.679000','2024-10-09 09:51:58.679000'),(10,3,NULL,'3.2.1633568268151817E10','JACKET-LARGE-BROWN.3.2.1633568268151817E10',109.99,NULL,20,_binary '\0','[1, 0]','2024-10-09 09:51:58.680000','2024-10-09 09:51:58.680000'),(11,3,NULL,'3.3.4109486157798637E10','JACKET-LARGE-BLACK.3.3.4109486157798637E10',109.99,NULL,25,_binary '\0','[1, 1]','2024-10-09 09:51:58.681000','2024-10-09 09:51:58.681000'),(12,3,NULL,'3.6.288845654495651E11','JACKET-MEDIUM-BLACK.3.6.288845654495651E11',99.99,NULL,35,_binary '\0','[0, 1]','2024-10-09 09:51:58.682000','2024-10-09 09:51:58.682000'),(13,4,NULL,'4.7.948032175253137E11','Blue-titanium.4.7.948032175253137E11',99.99,NULL,30,_binary '\0','[0]','2024-10-09 09:52:07.597000','2024-10-09 09:52:07.597000'),(14,4,NULL,'4.3.9617175695580817E11','White-titanium.4.3.9617175695580817E11',109.99,NULL,20,_binary '\0','[1]','2024-10-09 09:52:07.598000','2024-10-09 09:52:07.598000'),(15,4,NULL,'4.6.100223366007191E11','Natural-titanium.4.6.100223366007191E11',109.99,NULL,25,_binary '\0','[2]','2024-10-09 09:52:07.599000','2024-10-09 09:52:07.599000'),(16,5,NULL,'5.7.900052485388033E9','TSHIRT-SMALL-WHITE.5.7.900052485388033E9',19.99,NULL,100,_binary '\0','[0, 0]','2024-10-09 09:52:47.381000','2024-10-09 09:52:47.381000'),(17,5,NULL,'5.1.2972061120652719E11','TSHIRT-MEDIUM-WHITE.5.1.2972061120652719E11',24.99,NULL,80,_binary '\0','[1, 0]','2024-10-09 09:52:47.382000','2024-10-09 09:52:47.382000'),(18,5,NULL,'5.2.519354073687813E11','TSHIRT-MEDIUM-BLACK.5.2.519354073687813E11',24.99,NULL,60,_binary '\0','[1, 1]','2024-10-09 09:52:47.383000','2024-10-09 09:52:47.383000'),(19,5,NULL,'5.3.624603693540439E11','TSHIRT-SMALL-BLACK.5.3.624603693540439E11',19.99,NULL,120,_binary '\0','[0, 1]','2024-10-09 09:52:47.384000','2024-10-09 09:52:47.384000'),(20,6,NULL,'6.4.3632499324419696E11','HOODIE-SMALL-GRAY.6.4.3632499324419696E11',49.99,NULL,40,_binary '\0','[0, 0]','2024-10-09 09:53:08.952000','2024-10-09 09:53:08.952000'),(21,6,NULL,'6.4.243016789725526E11','HOODIE-LARGE-GRAY.6.4.243016789725526E11',59.99,NULL,30,_binary '\0','[1, 0]','2024-10-09 09:53:08.953000','2024-10-09 09:53:08.953000'),(22,6,NULL,'6.3.779000952108696E11','HOODIE-LARGE-BLACK.6.3.779000952108696E11',59.99,NULL,20,_binary '\0','[1, 1]','2024-10-09 09:53:08.954000','2024-10-09 09:53:08.954000'),(23,6,NULL,'6.3.251375418815854E11','HOODIE-SMALL-BLACK.6.3.251375418815854E11',49.99,NULL,50,_binary '\0','[0, 1]','2024-10-09 09:53:08.955000','2024-10-09 09:53:08.955000');
/*!40000 ALTER TABLE `skus` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-09  9:54:22
