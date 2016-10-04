-- MySQL dump 10.13  Distrib 5.7.9, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: DocManagerSystem
-- ------------------------------------------------------
-- Server version	5.5.50-0ubuntu0.14.04.1

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
-- Table structure for table `resource`
--

DROP TABLE IF EXISTS `resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resource` (
  `resourceId` int(11) NOT NULL AUTO_INCREMENT,
  `resourceTypeId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `description` varchar(50) CHARACTER SET utf8 NOT NULL,
  `formName` varchar(50) CHARACTER SET utf8 NOT NULL,
  `contain` longblob,
  `swf` longblob,
  `originalfilename` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `size` double DEFAULT '0',
  `time` date DEFAULT NULL,
  `readNum` int(11) DEFAULT '0',
  `downloadNum` int(11) DEFAULT '0',
  PRIMARY KEY (`resourceId`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource`
--

LOCK TABLES `resource` WRITE;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resourceType`
--

DROP TABLE IF EXISTS `resourceType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resourceType` (
  `resourceTypeId` int(11) NOT NULL,
  `resourceTypeDescribe` varchar(20) CHARACTER SET utf8 NOT NULL,
  `resourceManagerId` int(11) NOT NULL,
  PRIMARY KEY (`resourceTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resourceType`
--

LOCK TABLES `resourceType` WRITE;
/*!40000 ALTER TABLE `resourceType` DISABLE KEYS */;
INSERT INTO `resourceType` VALUES (1,'开发文档',2013),(2,'会议记录',2015),(3,'财务开单',2016);
/*!40000 ALTER TABLE `resourceType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `roleId` int(11) NOT NULL,
  `describe` varchar(20) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'普通用户'),(2,'资料管理员'),(3,'公司领导'),(4,'系统管理员');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_menu`
--

DROP TABLE IF EXISTS `role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_menu` (
  `roleId` int(11) NOT NULL,
  `menu` varchar(45) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_menu`
--

LOCK TABLES `role_menu` WRITE;
/*!40000 ALTER TABLE `role_menu` DISABLE KEYS */;
INSERT INTO `role_menu` VALUES (1,'个人信息'),(2,'个人信息'),(3,'个人信息'),(4,'个人信息'),(1,'历史记录'),(2,'历史记录'),(3,'历史记录'),(4,'历史记录'),(1,'我的文档'),(2,'我的文档'),(3,'我的文档'),(4,'我的文档'),(1,'查看文档'),(2,'查看文档'),(3,'查看文档'),(4,'查看文档'),(3,'统计报表'),(4,'权限管理'),(2,'资源管理');
/*!40000 ALTER TABLE `role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_systemAuthority`
--

DROP TABLE IF EXISTS `role_systemAuthority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_systemAuthority` (
  `SystemAuthirityId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`SystemAuthirityId`,`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_systemAuthority`
--

LOCK TABLES `role_systemAuthority` WRITE;
/*!40000 ALTER TABLE `role_systemAuthority` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_systemAuthority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section`
--

DROP TABLE IF EXISTS `section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `section` (
  `sectionId` int(11) NOT NULL,
  `sectionCascadeId` varchar(50) CHARACTER SET utf8 NOT NULL,
  `sectionDescribe` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`sectionId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section`
--

LOCK TABLES `section` WRITE;
/*!40000 ALTER TABLE `section` DISABLE KEYS */;
INSERT INTO `section` VALUES (1,'001','开发部'),(2,'001A01','基础架构部'),(3,'001A02','应用研发部'),(4,'002','运营部');
/*!40000 ALTER TABLE `section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section_userauthority_resourcetype`
--

DROP TABLE IF EXISTS `section_userauthority_resourcetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `section_userauthority_resourcetype` (
  `resourceTypeId` int(11) NOT NULL,
  `sectionId` int(11) NOT NULL,
  `userAuthorityId` int(11) NOT NULL,
  `sectionCascadeId` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`resourceTypeId`,`sectionId`,`userAuthorityId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section_userauthority_resourcetype`
--

LOCK TABLES `section_userauthority_resourcetype` WRITE;
/*!40000 ALTER TABLE `section_userauthority_resourcetype` DISABLE KEYS */;
INSERT INTO `section_userauthority_resourcetype` VALUES (1,1,1,'001'),(1,1,2,'001'),(1,2,1,'001A01'),(1,2,2,'001A01'),(1,3,1,'001A02'),(1,3,2,'001A02'),(1,4,1,'002'),(2,1,1,'001'),(2,1,2,'001'),(2,2,1,'001A01'),(2,2,2,'001A01'),(2,3,1,'001A02'),(2,3,2,'001A02'),(2,4,1,'002'),(3,1,1,'001'),(3,2,1,'001A01'),(3,3,1,'001A02'),(3,4,1,'002');
/*!40000 ALTER TABLE `section_userauthority_resourcetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `systemAuthority`
--

DROP TABLE IF EXISTS `systemAuthority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `systemAuthority` (
  `SystemAuthirityId` int(11) NOT NULL,
  `systemAuthorityDescribe` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`SystemAuthirityId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `systemAuthority`
--

LOCK TABLES `systemAuthority` WRITE;
/*!40000 ALTER TABLE `systemAuthority` DISABLE KEYS */;
/*!40000 ALTER TABLE `systemAuthority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL,
  `password` char(32) CHARACTER SET utf8 DEFAULT NULL,
  `uname` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `uid` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `position` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `sectionId` int(11) DEFAULT NULL,
  `salt` char(4) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2013,'13d3f8735b667dd751bd2b67a103ef85','高雨轩','4127213123321','技术总监',1,'qwer'),(2014,'ea3c9ecae2559f3184611359772478a1','任皓','4127213123322',NULL,2,'123'),(2015,'c7588f1b24b3167e03fe8df474a3fd16','胡子祥','4127213123323',NULL,3,'456'),(2016,'8e8fa43234de4e324f9167d992532ffc','张亚辉','4127213123324',NULL,4,'789');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userAuthority`
--

DROP TABLE IF EXISTS `userAuthority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userAuthority` (
  `userAuthorityId` int(11) NOT NULL,
  `userAuthorityDescribe` varchar(20) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`userAuthorityId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userAuthority`
--

LOCK TABLES `userAuthority` WRITE;
/*!40000 ALTER TABLE `userAuthority` DISABLE KEYS */;
INSERT INTO `userAuthority` VALUES (1,'查看'),(2,'下载');
/*!40000 ALTER TABLE `userAuthority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_resource_log`
--

DROP TABLE IF EXISTS `user_resource_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_resource_log` (
  `userId` int(11) DEFAULT NULL,
  `resourceId` int(11) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `operation` varchar(20) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_resource_log`
--

LOCK TABLES `user_resource_log` WRITE;
/*!40000 ALTER TABLE `user_resource_log` DISABLE KEYS */;
INSERT INTO `user_resource_log` VALUES (2013,1,NULL,'上传'),(2013,2,NULL,'上传'),(2013,2,NULL,'查看'),(2013,3,'2016-09-06','上传'),(2013,3,'2016-09-06','查看'),(2013,1,'2016-09-06','查看'),(2013,2,'2016-09-06','查看'),(2013,4,'2016-09-06','上传'),(2013,4,'2016-09-06','查看'),(2013,5,'2016-09-06','上传'),(2013,5,'2016-09-06','查看'),(2013,6,'2016-09-06','上传'),(2013,6,'2016-09-06','查看'),(2013,7,'2016-09-06','上传'),(2013,7,'2016-09-06','查看'),(2013,8,'2016-09-06','上传'),(2013,8,'2016-09-06','查看'),(2013,9,'2016-09-06','上传'),(2013,7,'2016-09-06','查看'),(2013,9,'2016-09-06','查看'),(2013,6,'2016-09-06','查看'),(2013,8,'2016-09-06','查看'),(2013,10,'2016-09-06','上传'),(2013,11,'2016-09-06','上传'),(2013,12,'2016-09-06','上传'),(2013,12,'2016-09-06','查看'),(2013,13,'2016-09-06','上传'),(2013,14,'2016-09-06','上传'),(2013,15,'2016-09-06','上传'),(2013,16,'2016-09-06','上传'),(2013,16,'2016-09-06','查看'),(2013,16,'2016-09-06','查看'),(2013,16,'2016-09-06','查看'),(2013,16,'2016-09-06','查看'),(2013,16,'2016-09-06','查看'),(2013,16,'2016-09-06','查看'),(2013,16,'2016-09-06','查看'),(2013,16,'2016-09-06','查看'),(2013,16,'2016-09-06','查看'),(2013,16,'2016-09-06','查看'),(2013,17,'2016-09-07','上传'),(2013,17,'2016-09-07','查看'),(2013,18,'2016-09-07','上传'),(2013,18,'2016-09-07','查看'),(2013,18,'2016-09-07','查看'),(2013,19,'2016-09-07','上传'),(2013,19,'2016-09-07','查看'),(2013,20,'2016-09-17','上传'),(2013,21,'2016-09-17','上传'),(2013,21,'2016-09-17','查看'),(2013,22,'2016-09-17','上传'),(2013,22,'2016-09-17','查看'),(2013,23,'2016-09-17','上传'),(2013,23,'2016-09-17','查看'),(2013,23,'2016-09-17','查看'),(2013,24,'2016-09-17','上传'),(2013,24,'2016-09-17','查看'),(2013,24,'2016-09-17','查看'),(2013,25,'2016-09-18','上传'),(2013,25,'2016-09-18','查看'),(2013,25,'2016-09-18','查看'),(2013,26,'2016-09-18','上传'),(2013,25,'2016-09-18','查看'),(2013,27,'2016-09-18','上传'),(2013,27,'2016-09-18','查看'),(2013,28,'2016-09-18','上传'),(2013,29,'2016-09-18','上传'),(2013,30,'2016-09-18','上传'),(2013,28,'2016-09-18','查看'),(2013,29,'2016-09-18','查看'),(2013,30,'2016-09-18','查看'),(2014,31,'2016-09-18','上传'),(2014,31,'2016-09-18','查看'),(2014,32,'2016-09-18','上传'),(2014,32,'2016-09-18','查看'),(2013,33,'2016-09-18','上传'),(2013,33,'2016-09-18','查看'),(2014,34,'2016-09-18','上传'),(2014,34,'2016-09-18','查看'),(2014,34,'2016-09-18','查看'),(2014,35,'2016-09-18','上传'),(2014,35,'2016-09-18','查看'),(2014,29,'2016-09-18','查看'),(2014,30,'2016-09-18','查看'),(2014,36,'2016-09-18','上传'),(2014,36,'2016-09-18','查看'),(2014,32,'2016-09-18','查看'),(2014,29,'2016-09-18','查看'),(2013,36,'2016-09-27','查看'),(2013,30,'2016-09-27','查看'),(2013,32,'2016-09-27','查看'),(2013,34,'2016-09-27','查看'),(2013,29,'2016-09-27','查看'),(2015,37,'2016-09-27','上传'),(2015,37,'2016-09-27','查看'),(2013,30,'2016-09-27','查看'),(2013,37,'2016-09-27','查看'),(2013,37,'2016-09-27','下载'),(2013,36,'2016-09-27','查看'),(2013,33,'2016-09-27','查看'),(2013,32,'2016-09-27','查看'),(2013,34,'2016-09-27','查看'),(2013,36,'2016-09-27','查看'),(2013,32,'2016-09-27','查看'),(2013,33,'2016-09-27','查看'),(2013,37,'2016-09-27','查看'),(2013,28,'2016-09-27','查看'),(2016,38,'2016-09-27','上传'),(2016,36,'2016-09-27','查看'),(2016,30,'2016-09-27','查看'),(2016,32,'2016-09-27','查看'),(2016,29,'2016-09-27','查看'),(2013,36,'2016-09-27','查看'),(2013,36,'2016-09-27','下载'),(2013,36,'2016-09-27','查看'),(2013,36,'2016-09-27','查看'),(2013,30,'2016-09-27','查看'),(2013,32,'2016-09-27','查看'),(2013,29,'2016-09-27','查看'),(2013,39,'2016-09-27','上传'),(2013,39,'2016-09-27','查看'),(2013,40,'2016-09-27','上传'),(2013,40,'2016-09-27','查看'),(2013,40,'2016-09-27','查看'),(2013,40,'2016-09-27','查看'),(2013,38,'2016-09-27','查看'),(2013,36,'2016-09-27','查看'),(2013,36,'2016-09-27','查看'),(2013,36,'2016-09-27','下载'),(2013,41,'2016-09-27','上传'),(2013,41,'2016-09-27','查看'),(2013,42,'2016-09-28','上传'),(2013,42,'2016-09-28','查看'),(2013,39,'2016-09-28','上传'),(2013,40,'2016-09-28','上传'),(2013,40,'2016-09-28','查看'),(2013,36,'2016-09-28','查看'),(2013,41,'2016-09-28','上传'),(2013,30,'2016-09-28','查看'),(2013,36,'2016-09-28','查看'),(2013,36,'2016-09-28','查看'),(2013,30,'2016-09-28','查看'),(2013,36,'2016-09-28','查看'),(2013,32,'2016-09-28','查看'),(2013,29,'2016-09-28','查看'),(2013,36,'2016-09-28','查看'),(2013,36,'2016-09-28','下载'),(2013,42,'2016-09-28','上传'),(2013,42,'2016-09-28','查看'),(2013,36,'2016-09-28','查看'),(2013,32,'2016-09-28','查看'),(2013,36,'2016-09-28','查看'),(2013,29,'2016-09-28','查看'),(2013,36,'2016-09-28','查看'),(2013,30,'2016-09-28','查看'),(2013,37,'2016-09-28','查看');
/*!40000 ALTER TABLE `user_resource_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (2013,4),(2013,3),(2013,1),(2013,2),(2014,1),(2015,1),(2016,1),(2014,4),(2015,3),(2016,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'DocManagerSystem'
--
/*!50003 DROP PROCEDURE IF EXISTS `findAllSubSectionsById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `findAllSubSectionsById`(l_sectionId int)
BEGIN
DECLARE l_sectionCascadeId varchar(50);
	select sectionCascadeId  INTO  l_sectionCascadeId
	from section
	where sectionId = l_sectionId;
    
	select *
	from section
    where locate(l_sectionCascadeId,sectionCascadeId) > 0 and sectionId <> l_sectionId;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `new_procedure` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `new_procedure`()
BEGIN
	select *
	from section;
    
    select *
	from role;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-04 10:23:18
