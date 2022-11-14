-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: tpjava_gimnasio
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `actividades`
--

DROP TABLE IF EXISTS `actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actividades` (
  `idActividad` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `descripcion` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin,
  `add_date` datetime DEFAULT NULL,
  `add_user` int DEFAULT NULL,
  `edit_date` datetime DEFAULT NULL,
  `edit_user` int DEFAULT NULL,
  `kill_date` datetime DEFAULT NULL,
  `kill_user` int DEFAULT NULL,
  `eliminado` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idActividad`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividades`
--

LOCK TABLES `actividades` WRITE;
/*!40000 ALTER TABLE `actividades` DISABLE KEYS */;
INSERT INTO `actividades` VALUES (1,'Gimnasio','nulldsadsaasd',NULL,NULL,NULL,NULL,NULL,NULL,0),(2,'Muai Thai','asdasdasdasd',NULL,NULL,NULL,NULL,NULL,NULL,0),(3,'Judo',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(4,'Boxeo','null',NULL,NULL,NULL,NULL,NULL,NULL,0),(5,'Kickboxing',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(6,'JiuJutsu','',NULL,NULL,NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `actividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes_cuotas`
--

DROP TABLE IF EXISTS `clientes_cuotas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes_cuotas` (
  `idCuotaCliente` int NOT NULL AUTO_INCREMENT,
  `idCuota` int DEFAULT NULL,
  `idUsuario` int DEFAULT NULL,
  `fechaPago` datetime DEFAULT NULL,
  `montoAbonado` float DEFAULT NULL,
  PRIMARY KEY (`idCuotaCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes_cuotas`
--

LOCK TABLES `clientes_cuotas` WRITE;
/*!40000 ALTER TABLE `clientes_cuotas` DISABLE KEYS */;
INSERT INTO `clientes_cuotas` VALUES (1,1,7,'2022-11-03 10:00:00',1000),(2,2,7,'2022-11-03 10:00:00',1233),(3,3,7,'2022-11-03 10:00:00',1323),(4,1,3,'2022-11-11 11:11:51',1000),(5,2,3,'2022-11-11 11:12:44',1000),(6,3,3,'2022-11-11 11:12:50',1500),(7,4,3,'2022-11-11 11:14:32',2000),(8,5,3,'2022-11-11 11:14:46',2000),(9,6,3,'2022-11-11 11:18:01',2000),(10,7,3,'2022-11-11 11:18:04',2500),(11,8,3,'2022-11-11 11:30:07',3000),(12,6,7,'2022-11-11 11:48:37',2000);
/*!40000 ALTER TABLE `clientes_cuotas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuotas`
--

DROP TABLE IF EXISTS `cuotas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuotas` (
  `idCuota` int NOT NULL AUTO_INCREMENT,
  `mes` int NOT NULL,
  `nombreMes` varchar(45) COLLATE utf8mb4_bin NOT NULL,
  `año` int NOT NULL,
  `monto` int DEFAULT NULL,
  PRIMARY KEY (`idCuota`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuotas`
--

LOCK TABLES `cuotas` WRITE;
/*!40000 ALTER TABLE `cuotas` DISABLE KEYS */;
INSERT INTO `cuotas` VALUES (1,1,'Enero',2022,1000),(2,2,'Febrero',2022,1000),(3,3,'Marzo',2022,1500),(4,4,'Abril',2022,2000),(5,5,'Mayo',2022,2000),(6,6,'Junio',2022,2000),(7,7,'Julio',2022,2500),(8,8,'Agosto',2022,3000),(9,9,'Septiembre',2022,3000),(10,10,'Octubre',2022,3000),(11,11,'Noviembre',2022,3500),(12,12,'Diciembre',2022,4000),(13,1,'Enero',2023,5000),(14,2,'Febrero',2023,6000),(15,3,'Marzo',2023,7000),(16,4,'Abril',2023,NULL),(17,5,'Mayo',2023,NULL),(20,6,'Junio',2023,NULL),(21,7,'Julio',2023,NULL),(22,8,'Agosto',2023,NULL),(23,9,'Septiembre',2023,NULL),(24,10,'Octubre',2023,NULL),(25,11,'Noviembre',2023,NULL),(26,12,'Diciembre',2023,NULL);
/*!40000 ALTER TABLE `cuotas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ha_clientes`
--

DROP TABLE IF EXISTS `ha_clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ha_clientes` (
  `idHAC` int NOT NULL AUTO_INCREMENT,
  `idHA` int NOT NULL,
  `idUsuario` int NOT NULL,
  `fechaRegistro` datetime NOT NULL,
  `fechaBaja` datetime DEFAULT NULL,
  `eliminado` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idHAC`),
  KEY `idUsuario_hac_idx` (`idUsuario`),
  KEY `idHA_hac_idx` (`idHA`),
  CONSTRAINT `idHA_hac` FOREIGN KEY (`idHA`) REFERENCES `horariosactividades` (`idHA`),
  CONSTRAINT `idUsuario_hac` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ha_clientes`
--

LOCK TABLES `ha_clientes` WRITE;
/*!40000 ALTER TABLE `ha_clientes` DISABLE KEYS */;
INSERT INTO `ha_clientes` VALUES (1,1,7,'2020-04-04 20:00:00','2022-11-11 12:03:09',0),(2,2,7,'2020-04-04 20:00:00',NULL,0),(3,3,8,'2020-04-04 20:00:00',NULL,0),(4,4,14,'2020-04-04 20:00:00',NULL,0),(5,5,14,'2020-04-04 20:00:00',NULL,0),(16,2,3,'2022-10-31 13:55:52',NULL,0),(17,6,3,'2022-10-31 11:12:17',NULL,0),(18,18,7,'2022-11-12 16:24:36',NULL,0),(19,1,3,'2022-11-12 16:28:17',NULL,0),(20,8,7,'2022-11-12 16:28:30',NULL,0);
/*!40000 ALTER TABLE `ha_clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historialvisitas`
--

DROP TABLE IF EXISTS `historialvisitas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historialvisitas` (
  `idHV` int NOT NULL AUTO_INCREMENT,
  `idUsuario` int DEFAULT NULL,
  `fechaIngreso` datetime DEFAULT NULL,
  `fechaEgreso` datetime DEFAULT NULL,
  PRIMARY KEY (`idHV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historialvisitas`
--

LOCK TABLES `historialvisitas` WRITE;
/*!40000 ALTER TABLE `historialvisitas` DISABLE KEYS */;
/*!40000 ALTER TABLE `historialvisitas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horariosactividades`
--

DROP TABLE IF EXISTS `horariosactividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horariosactividades` (
  `idHA` int NOT NULL AUTO_INCREMENT,
  `idActividad` int NOT NULL,
  `idUsuario` int NOT NULL,
  `dia` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `horaComienzo` time NOT NULL,
  `horaFin` time NOT NULL,
  `cuposDisponibles` int NOT NULL,
  `add_date` datetime DEFAULT NULL,
  `add_user` int DEFAULT NULL,
  `edit_date` datetime DEFAULT NULL,
  `edit_user` int DEFAULT NULL,
  `kill_date` datetime DEFAULT NULL,
  `kill_user` int DEFAULT NULL,
  `eliminado` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idHA`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horariosactividades`
--

LOCK TABLES `horariosactividades` WRITE;
/*!40000 ALTER TABLE `horariosactividades` DISABLE KEYS */;
INSERT INTO `horariosactividades` VALUES (1,2,4,'Jueves','15:00:00','23:13:00',10,NULL,NULL,NULL,NULL,NULL,NULL,0),(2,1,4,'Miercoles','20:00:00','22:00:00',10,NULL,NULL,NULL,NULL,NULL,NULL,0),(3,1,4,'Viernes','20:00:00','22:00:00',10,NULL,NULL,NULL,NULL,NULL,NULL,0),(4,4,4,'Viernes','23:00:00','01:00:00',10,NULL,NULL,NULL,NULL,NULL,NULL,0),(5,5,5,'Lunes','23:00:00','01:00:00',10,NULL,NULL,NULL,NULL,NULL,NULL,0),(6,3,6,'Lunes','23:00:00','01:00:00',10,NULL,NULL,NULL,NULL,NULL,NULL,0),(7,3,6,'Martes','18:30:00','19:45:00',10,NULL,NULL,NULL,NULL,NULL,NULL,0),(8,3,6,'Miercoles','18:30:00','19:45:00',10,NULL,NULL,NULL,NULL,NULL,NULL,0),(9,3,6,'Jueves','18:30:00','19:45:00',10,NULL,NULL,NULL,NULL,NULL,NULL,0),(10,3,6,'Lunes','18:30:00','19:45:00',10,NULL,NULL,NULL,NULL,NULL,NULL,0),(11,3,6,'Viernes','18:30:00','19:45:00',10,NULL,NULL,NULL,NULL,NULL,NULL,0),(12,4,5,'Sabado','10:00:00','12:00:00',10,NULL,NULL,NULL,NULL,NULL,NULL,0),(13,5,4,'Lunes','12:15:00','14:15:00',10,NULL,NULL,NULL,NULL,NULL,NULL,0),(14,5,4,'Martes','12:15:00','14:15:00',10,NULL,NULL,NULL,NULL,NULL,NULL,0),(15,5,4,'Miercoles','12:15:00','14:15:00',10,NULL,NULL,NULL,NULL,NULL,NULL,0),(18,1,4,'Sabado','15:53:00','17:53:00',15,NULL,NULL,NULL,NULL,NULL,NULL,0),(19,4,4,'Martes','12:03:00','04:05:00',14,NULL,NULL,NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `horariosactividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `tipoUsuario` enum('Admin','Administrativo','Profesor','Cliente') COLLATE utf8mb4_bin DEFAULT NULL,
  `nombre` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `apellido` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `dni` int DEFAULT NULL,
  `sexo` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `domicilio` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `email` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `telefono` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `habilitado` tinyint(1) DEFAULT '1',
  `eliminado` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Admin','Renzo','Fascendini','1996-08-28',1234,'M','Chassaing 7736','1234','renzo.jrr10@gmail.com','3413092900',1,0),(2,'Administrativo','Ignacio','Martinez','1999-07-22',12345,'M','Zeballos 1300','1234','imartinez@gmail.com','3411234567',1,0),(3,'Cliente','Juan Roman','Riquelme','2000-05-20',123456,'M','Santa Fe 1200','1234','jrriquelme@gmail.com','3413202020',1,0),(4,'Profesor','Lucas Alberto','Langoni','2001-10-10',12345678,'M','asdasdasdasd','1234','renzo.jrr10@gmail.com','123123',1,0),(5,'Profesor','Alejo','Hernadez','2001-10-10',123,'M','Sarmiento 1000','1234','hola@gmail.com','121212',1,0),(6,'Profesor','Leonardo','Fernandez','2001-10-10',2222,'M','Pasco 200','1234','argentina@gmail.com','3464556677',1,0),(7,'Cliente','Pablo','Reinward','2001-10-10',3333,'M','Mitre 900','1234','asdassadasd@gmail.com','3415556677',1,0),(8,'Cliente','Ricardo asdasdasd asd asd','Santolari','2001-10-10',4444,'M','Paraguay 2000','1234','asdassadasd2323@gmail.com','3412556677',1,1),(14,'Cliente','Prueba dsasdsadwe','Prueba',NULL,123123,'M','Prueba','123123123','riquicardo@gmail.com','123123123',1,0);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-14  9:51:50
