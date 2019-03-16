/*
SQLyog Professional v12.09 (64 bit)
MySQL - 8.0.11 : Database - answer_frame
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`answer_frame` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `answer_frame`;

/*Table structure for table `t_admin` */

DROP TABLE IF EXISTS `t_admin`;

CREATE TABLE `t_admin` (
  `a_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) DEFAULT NULL,
  `admin_pd` varchar(255) DEFAULT NULL,
  `academy` varchar(255) DEFAULT NULL,
  `is_vip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `t_admin` */

insert  into `t_admin`(`a_id`,`admin_name`,`admin_pd`,`academy`,`is_vip`) values (2,'xiewanting','123','鹦鹉学院','是'),(20,'yunteng','123','信息科学','是');

/*Table structure for table `t_timu` */

DROP TABLE IF EXISTS `t_timu`;

CREATE TABLE `t_timu` (
  `t_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `t_name` varchar(255) DEFAULT NULL,
  `a_id` int(11) DEFAULT NULL,
  `t_creat_date` date DEFAULT NULL,
  `t_num` int(11) DEFAULT NULL,
  `is_time_limit` varchar(255) DEFAULT NULL,
  `time_limit` int(11) DEFAULT NULL,
  `t_count` int(11) DEFAULT NULL,
  `is_publish` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '未发布'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_timu` */

insert  into `t_timu`(`t_id`,`t_name`,`a_id`,`t_creat_date`,`t_num`,`is_time_limit`,`time_limit`,`t_count`,`is_publish`) values ('10','第三次考试',18,'2019-01-23',5,'0',NULL,NULL,NULL),('11','第四次考试',18,'2019-01-23',3,'0',NULL,NULL,NULL),('12','第五次次考试',18,'2019-01-23',5,'0',NULL,NULL,NULL),('124d106e-8f8b-498f-82c2-fac9b40e29e0','',18,'2019-01-23',6,'0',NULL,NULL,NULL),('13','第六次考试',18,'2019-01-23',5,'0',NULL,NULL,NULL),('14','',18,'2019-01-23',5,'0',NULL,NULL,NULL),('15','',18,'2019-01-23',6,'0',NULL,NULL,NULL),('16','',18,'2019-01-24',6,'0',NULL,NULL,NULL),('17','第qi次次考试',18,'2019-01-23',5,'0',NULL,NULL,NULL),('18','第四次考试f',18,'2019-01-23',5,'0',NULL,NULL,NULL),('2','第一学期java测试',1,'2019-01-22',50,'30',41,41,NULL),('3','132456',1,'2019-01-22',14,'1',41,41,NULL),('4','',1,'2019-01-23',NULL,'0',NULL,NULL,NULL),('5','',1,'2019-01-23',NULL,'0',NULL,NULL,NULL),('6','',1,'2019-01-23',NULL,'0',NULL,NULL,NULL),('7','第二次考试',1,'2019-01-23',NULL,'0',NULL,NULL,NULL),('7c596be9-6814-4ee5-8957-d01142c7e9b6','',18,'2019-01-23',2,'0',NULL,NULL,NULL),('90ce56ff-5c0c-4477-bd98-93c795b86631','afaf',18,'2019-01-23',5,'0',NULL,NULL,NULL),('aa689206-d447-4146-b67c-af145158a8af','',18,'2019-01-23',NULL,'0',NULL,NULL,NULL),('b56113cd-0d21-4b0f-8b74-3cffa7ea9f92','',18,'2019-01-23',NULL,'0',NULL,NULL,NULL),('fa1dd030-274d-4c56-8652-df7105703a95','',18,'2019-01-23',2,'0',NULL,NULL,NULL),('be5819c0-2586-4c57-9140-ff966cfe2c86','第一次考试',18,'2019-01-23',5,'0',NULL,NULL,NULL),('d3daecae-aed7-4745-b8d4-71b97fa67c6e','第四次考试',18,'2019-01-23',5,'0',NULL,NULL,NULL),('fee9da36-3166-4505-a52b-63891dc60cc6','test',18,'2019-01-23',5,'0',NULL,NULL,NULL),('dbb3e4aa-ccbe-4ed5-9a9e-0ce82297f339','y',18,'2019-01-23',3,'0',0,0,NULL),('c68e321d-e8b7-4433-9d91-59112806f2b8','第五次次考试',18,'2019-01-24',3,'0',NULL,NULL,NULL),('1c51c773-d04d-4d32-947f-66c1a312d784','3333',18,'2019-01-24',3,'0',NULL,NULL,NULL),('69d7b19b-4849-42f6-a1d2-3d3cbbd1c364','12313',18,'2019-01-24',2,'0',NULL,NULL,NULL),('4ece28e5-c5eb-43ea-b429-d9eb09960f92','23',18,'2019-01-24',2,'0',NULL,NULL,NULL),('12a6342c-1bf4-4766-8cf2-f6295a3f2639','第四次考试',18,'2019-01-24',1,'0',NULL,NULL,NULL),('61241ea7-9120-4df3-9c64-ccee1cdad587','第四次考试',18,'2019-01-24',1,'0',NULL,NULL,NULL),('69e32d96-61f0-4b32-a0be-a7d15339b59a','第四次考试',18,'2019-01-24',1,'0',NULL,NULL,NULL),('f7ba0310-24a8-4a33-b196-23e3184fd771','第四次考试',18,'2019-01-24',1,'0',NULL,NULL,NULL),('2cb3b781-eb2e-49f4-9ee4-82fe05f79421','第四次考试',18,'2019-01-24',1,'0',NULL,NULL,NULL),('79df33a6-3fd8-47af-93d8-395fee82b58f','第四次考试',18,'2019-01-24',1,'0',NULL,NULL,NULL),('b3db9749-82a9-40f5-8fab-ae73810674a5','第四次考试',18,'2019-01-24',1,'0',NULL,NULL,NULL),('39caa044-4e1b-40e1-ad5f-07a506c1a2cc','第四次考试',18,'2019-01-24',1,'0',NULL,NULL,NULL),('c658176b-1ef5-43bd-9776-39e298a989f8','第四次考试',18,'2019-01-24',2,'0',NULL,NULL,NULL),('589b8387-7823-49a9-bd10-e8c4a71f9887','第我次考试',18,'2019-01-24',1,'0',NULL,NULL,NULL),('34a6f51e-749a-4c90-92fb-4265c176e36f','第四次考试',18,'2019-01-24',2,'0',NULL,NULL,NULL),('7905763d-aca0-4832-8018-28b07c2d2b36','132456',18,'2019-01-24',2,'0',NULL,NULL,NULL),('f295e07c-d597-4099-8b4e-62f8b68267c6','3',18,'2019-01-24',2,'0',NULL,NULL,NULL),('16731a66-aa49-426c-bef1-3452321381f5','第四次考试',18,'2019-01-24',2,'0',NULL,NULL,NULL),('b5bf2051-f632-4988-b110-8b7d220ed3bb','回复',18,'2019-01-24',3,'0',NULL,NULL,NULL),('dfb637af-8157-490d-b335-ec2a973dd988','第四次考试',2,'2019-01-25',1,'0',1,1,'已发布'),('bd7b6883-22c3-4357-8b3d-3dc082065c47','1',2,'2019-01-25',1,'0',1,1,'已发布'),('1e2fcfcf-d2dd-42d6-931e-a48c7495b2b1','第一次在微信端测试',2,'2019-01-25',3,'0',41,1,'已发布'),('9ec8fb51-e9d3-4a55-b69d-edd899d045c8','test0220',20,'2019-02-20',3,'0',2,1,'已发布');

/*Table structure for table `t_timuitem` */

DROP TABLE IF EXISTS `t_timuitem`;

CREATE TABLE `t_timuitem` (
  `ti_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_id` varchar(255) DEFAULT NULL,
  `ti_name` varchar(255) DEFAULT NULL,
  `ti_a` varchar(255) DEFAULT NULL,
  `ti_b` varchar(255) DEFAULT NULL,
  `ti_c` varchar(255) DEFAULT NULL,
  `ti_d` varchar(255) DEFAULT NULL,
  `ti_right` varchar(255) DEFAULT NULL,
  `a_count` int(11) DEFAULT '0',
  `b_count` int(11) DEFAULT '0',
  `c_count` int(11) DEFAULT '0',
  `d_count` int(11) DEFAULT '0',
  PRIMARY KEY (`ti_id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;

/*Data for the table `t_timuitem` */

insert  into `t_timuitem`(`ti_id`,`t_id`,`ti_name`,`ti_a`,`ti_b`,`ti_c`,`ti_d`,`ti_right`,`a_count`,`b_count`,`c_count`,`d_count`) values (32,'d3daecae-aed7-4745-b8d4-71b97fa67c6e','','','','','','',NULL,NULL,NULL,NULL),(33,'d3daecae-aed7-4745-b8d4-71b97fa67c6e','','','','','','',NULL,NULL,NULL,NULL),(34,'d3daecae-aed7-4745-b8d4-71b97fa67c6e','','','','','','',NULL,NULL,NULL,NULL),(35,'d3daecae-aed7-4745-b8d4-71b97fa67c6e','','','','','','',NULL,NULL,NULL,NULL),(36,'fee9da36-3166-4505-a52b-63891dc60cc6','test1','test1','test1','test1','test1','test1',NULL,NULL,NULL,NULL),(37,'fee9da36-3166-4505-a52b-63891dc60cc6','t2','t2','t2','t2','t2','t2',NULL,NULL,NULL,NULL),(38,'fee9da36-3166-4505-a52b-63891dc60cc6','t3','t3','t3','t3','t3','t3',NULL,NULL,NULL,NULL),(39,'fee9da36-3166-4505-a52b-63891dc60cc6','t4','t4','t4','t4','t4','t4',NULL,NULL,NULL,NULL),(40,'dbb3e4aa-ccbe-4ed5-9a9e-0ce82297f339','01','01','01','01','01','01',NULL,NULL,NULL,NULL),(41,'dbb3e4aa-ccbe-4ed5-9a9e-0ce82297f339','02','02','02','02','02','02',NULL,NULL,NULL,NULL),(42,'dbb3e4aa-ccbe-4ed5-9a9e-0ce82297f339','03','03','03','03','03','03',NULL,NULL,NULL,NULL),(43,'1c51c773-d04d-4d32-947f-66c1a312d784','今天天气怎么样？','很好','一般','很差','很不好',NULL,NULL,NULL,NULL,NULL),(44,'69d7b19b-4849-42f6-a1d2-3d3cbbd1c364','dsfsd','dsfdsf','sdfsdf','sdfsdf','sdfsdf',NULL,NULL,NULL,NULL,NULL),(45,'69d7b19b-4849-42f6-a1d2-3d3cbbd1c364','dsfsd','dsfdsf','sdfsdf','sdfsdf','sdfsdf',NULL,NULL,NULL,NULL,NULL),(46,'4ece28e5-c5eb-43ea-b429-d9eb09960f92','cvdfasd','sdfasd','asdfasdf','asdfasdf','sdafas',NULL,NULL,NULL,NULL,NULL),(47,'12a6342c-1bf4-4766-8cf2-f6295a3f2639','asf答复','阿顺帆','阿顺帆','阿斯蒂芬','阿斯蒂芬',NULL,NULL,NULL,NULL,NULL),(48,'61241ea7-9120-4df3-9c64-ccee1cdad587','1233','132','','','',NULL,NULL,NULL,NULL,NULL),(49,'69e32d96-61f0-4b32-a0be-a7d15339b59a','','','','','','123456',NULL,NULL,NULL,NULL),(50,'f7ba0310-24a8-4a33-b196-23e3184fd771','阿斯蒂芬','士大夫','仿','士大夫','根深蒂固','123456',NULL,NULL,NULL,NULL),(51,'2cb3b781-eb2e-49f4-9ee4-82fe05f79421','道德风尚','第三个','电饭锅','电饭锅','电饭锅',NULL,NULL,NULL,NULL,NULL),(52,'79df33a6-3fd8-47af-93d8-395fee82b58f','士大夫','阿斯蒂芬','士大夫','阿斯蒂芬','发的',NULL,NULL,NULL,NULL,NULL),(53,'b3db9749-82a9-40f5-8fab-ae73810674a5','广泛的','收到','阿萨德','答复','仿','收到',NULL,NULL,NULL,NULL),(54,'39caa044-4e1b-40e1-ad5f-07a506c1a2cc','您的性格？','内敛','开放','活泼','','内敛',NULL,NULL,NULL,NULL),(55,'c658176b-1ef5-43bd-9776-39e298a989f8','士大夫','士大夫士大夫','士大夫g','广泛的','多个','士大夫g',NULL,NULL,NULL,NULL),(56,'c658176b-1ef5-43bd-9776-39e298a989f8','但是更多是','等等','死神','给对方','第三个','第三个',NULL,NULL,NULL,NULL),(57,'589b8387-7823-49a9-bd10-e8c4a71f9887','阿顺帆','仿','仿','','','',NULL,NULL,NULL,NULL),(58,'f295e07c-d597-4099-8b4e-62f8b68267c6','1','f','','','','f',NULL,NULL,NULL,NULL),(59,'f295e07c-d597-4099-8b4e-62f8b68267c6','是否','','示范点','','','示范点',NULL,NULL,NULL,NULL),(60,'f65a9294-0f41-4ea3-94cc-7cc6c13551b9','asdf ','','','','','',NULL,NULL,NULL,NULL),(61,'f65a9294-0f41-4ea3-94cc-7cc6c13551b9','dsf','','','','','',NULL,NULL,NULL,NULL),(62,'3356db3b-5ee5-46b1-a7e6-6925d6602b0c','士大夫','腐蚀毒粉','sdfsdf','佛挡杀佛','腐蚀毒粉','sdfsdf',NULL,NULL,NULL,NULL),(63,'3356db3b-5ee5-46b1-a7e6-6925d6602b0c','送达方式','第三方','三大','阿斯蒂芬d','阿斯蒂芬','阿斯蒂芬',NULL,NULL,NULL,NULL),(64,'3356db3b-5ee5-46b1-a7e6-6925d6602b0c','asf','saf','asdf','asdfasdf','发生颠覆','asdfasdf',NULL,NULL,NULL,NULL),(65,'bef650bb-29f3-4f53-bd54-89af9ec51d4b','阿飞','撒旦法','大幅释放','阿斯蒂芬 ','是否收到','阿斯蒂芬 ',NULL,NULL,NULL,NULL),(66,'bef650bb-29f3-4f53-bd54-89af9ec51d4b','大师傅','大概','俺是个','阿顺帆','格式','俺是个',NULL,NULL,NULL,NULL),(67,'bef650bb-29f3-4f53-bd54-89af9ec51d4b','阿骨打','幅度更大缩放都是跟风','阿萨德嘎','二万人','勾搭帅哥','勾搭帅哥',NULL,NULL,NULL,NULL),(68,'dfb637af-8157-490d-b335-ec2a973dd988','1','42','242','42','4242','42',NULL,NULL,NULL,NULL),(69,'bd7b6883-22c3-4357-8b3d-3dc082065c47','1','1','1','1','1','1',NULL,NULL,NULL,NULL),(70,'1e2fcfcf-d2dd-42d6-931e-a48c7495b2b1','第一题','a','b','c','d','d',NULL,NULL,NULL,NULL),(71,'1e2fcfcf-d2dd-42d6-931e-a48c7495b2b1','第二题','a','b','c','d','b',NULL,NULL,NULL,NULL),(72,'1e2fcfcf-d2dd-42d6-931e-a48c7495b2b1','第三题','a','b','c','d','c',NULL,NULL,NULL,NULL),(73,'b6c3c6d9-1ff4-47b2-857e-d78e34607927','暗示法','阿斯蒂芬','阿顺帆发送发f','士大夫的是','撒旦法','士大夫的是',4,7,15,7),(74,'b6c3c6d9-1ff4-47b2-857e-d78e34607927','海关法号','好','回复','凤凰','覆盖','好',2,4,5,1),(75,'b6c3c6d9-1ff4-47b2-857e-d78e34607927','很关键','根据','根据','规范监管方法','鼓风机','根据',1,1,0,0),(76,'b6c3c6d9-1ff4-47b2-857e-d78e34607927','刚放寒假','房管局','放假','房管局','发给积分','房管局',1,0,1,0),(77,'b6c3c6d9-1ff4-47b2-857e-d78e34607927','据法国海军','据法国海军','很关键','回家','刚放寒假','回家',4,5,2,0),(78,'b2df6f67-084f-48a3-b09f-c7fdbf1ea111','第一题','ad','g ','dg ','dg ','dg ',7,5,1,1),(79,'b2df6f67-084f-48a3-b09f-c7fdbf1ea111','dgd ','dg ','dg','dgdg','dgdg','dgdg',0,0,0,1),(80,'b2df6f67-084f-48a3-b09f-c7fdbf1ea111','dgdg','dgdg','dgdg','hdh','hhd','hdh',0,0,1,4),(81,'9ec8fb51-e9d3-4a55-b69d-edd899d045c8','1','a','b','c','d','a',1,1,3,2),(82,'9ec8fb51-e9d3-4a55-b69d-edd899d045c8','2','a','b','c','d','b',0,1,0,0),(83,'9ec8fb51-e9d3-4a55-b69d-edd899d045c8','3','a','b','c','d','c',0,0,1,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
