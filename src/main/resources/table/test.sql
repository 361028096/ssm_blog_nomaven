# Host: localhost  (Version: 5.6.21-log)
# Date: 2017-11-12 20:08:15
# Generator: MySQL-Front 5.3  (Build 4.13)

/*!40101 SET NAMES utf8 */;

#
# Source for table "access_log"
#

DROP TABLE IF EXISTS `access_log`;
CREATE TABLE `access_log` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `site_id` int(11) NOT NULL DEFAULT '0' COMMENT '网站id',
  `count` int(11) NOT NULL DEFAULT '0' COMMENT '访问次数',
  `date` date NOT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#
# Data for table "access_log"
#

INSERT INTO `access_log` VALUES (1,1,45,'2016-05-10'),(2,3,100,'2016-05-13'),(3,1,230,'2016-05-14'),(4,2,10,'2016-05-14'),(5,5,205,'2016-05-14'),(6,4,13,'2016-05-15'),(7,3,220,'2016-05-15'),(8,5,545,'2016-05-16'),(9,3,201,'2016-05-17');

#
# Source for table "apps"
#

DROP TABLE IF EXISTS `apps`;
CREATE TABLE `apps` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_name` char(20) NOT NULL DEFAULT '' COMMENT '站点名称',
  `url` varchar(255) NOT NULL DEFAULT '',
  `country` char(10) NOT NULL DEFAULT '' COMMENT '国家',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "apps"
#

INSERT INTO `apps` VALUES (1,'QQ APP','http://im.qq.com/','CN'),(2,'微博 APP','http://weibo.com/','CN'),(3,'淘宝 APP','https://www.taobao.com/','CN');

#
# Source for table "examstudent"
#

DROP TABLE IF EXISTS `examstudent`;
CREATE TABLE `examstudent` (
  `FlowID` int(11) NOT NULL DEFAULT '0',
  `Type` int(11) DEFAULT NULL,
  `IDCard` varchar(18) DEFAULT NULL,
  `ExamCard` varchar(15) DEFAULT NULL,
  `StudentName` varchar(20) DEFAULT NULL,
  `Location` varchar(20) DEFAULT NULL,
  `Grade` int(11) DEFAULT NULL,
  PRIMARY KEY (`FlowID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "examstudent"
#

INSERT INTO `examstudent` VALUES (1,4,'101','1001','å¼ é”‹','éƒ‘å·ž',85),(2,4,'102','1002','åŠ±å¿—','å¤§è¿ž',100),(3,6,'103','1003','çŽ‹æ¯','æ²ˆé˜³',89),(4,4,'104','1004','zhang','Beijing',93),(5,4,'105','1005','lizhang','Shanghai',99),(6,6,'106','1006','feng','dalian',0),(7,4,'107','1007','mei','Tianjing',99);

#
# Source for table "students"
#

DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `age` int(5) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#
# Data for table "students"
#

INSERT INTO `students` VALUES (1,'1232',21,'2017-08-26'),(2,'å¼ ä¸‰',20,'1998-12-12'),(3,'æŽå››',20,'1998-12-12'),(4,'HW',3,'2016-05-24'),(5,'å•Š',22,'2017-08-26'),(6,'hz',23,'2017-08-26'),(7,'cyz',34,'2017-08-26'),(8,'wt',NULL,NULL),(9,'hw',NULL,NULL),(10,'ç™½',NULL,NULL);

#
# Source for table "test"
#

DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "test"
#

INSERT INTO `test` VALUES ('24','贺炜'),('a','哈哈哈啊哈'),('24','贺炜');

#
# Source for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES ('å¼ ä¸‰','222'),('Tom','123456');

#
# Source for table "websites"
#

DROP TABLE IF EXISTS `websites`;
CREATE TABLE `websites` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL DEFAULT '' COMMENT '站点名称',
  `url` varchar(255) NOT NULL DEFAULT '',
  `alexa` int(11) NOT NULL DEFAULT '0' COMMENT 'Alexa 排名',
  `country` char(10) NOT NULL DEFAULT '' COMMENT '国家',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

#
# Data for table "websites"
#

INSERT INTO `websites` VALUES (1,'Google','https://www.google.cm/',1,'USA'),(2,'淘宝','https://www.taobao.com/',13,'CN'),(3,'菜鸟教程','http://www.runoob.com/',5000,'USA'),(4,'微博','http://weibo.com/',20,'CN'),(5,'Facebook','https://www.facebook.com/',3,'USA'),(7,'stackoverflow','http://stackoverflow.com',0,'IND'),(8,'QQ APP','',0,'CN'),(9,'微博 APP','',0,'CN'),(10,'淘宝 APP','',0,'CN'),(11,'QQ APP','',0,'CN');

#
# Source for table "websitesbackup2016"
#

DROP TABLE IF EXISTS `websitesbackup2016`;
CREATE TABLE `websitesbackup2016` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` char(20) NOT NULL DEFAULT '' COMMENT '站点名称',
  `url` varchar(255) NOT NULL DEFAULT '',
  `alexa` int(11) NOT NULL DEFAULT '0' COMMENT 'Alexa 排名',
  `country` char(10) NOT NULL DEFAULT '' COMMENT '国家'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "websitesbackup2016"
#

INSERT INTO `websitesbackup2016` VALUES (1,'Google','https://www.google.cm/',1,'USA'),(2,'淘宝','https://www.taobao.com/',13,'CN'),(3,'菜鸟教程','http://www.runoob.com/',5000,'USA'),(4,'微博','http://weibo.com/',20,'CN'),(5,'Facebook','https://www.facebook.com/',3,'USA'),(7,'stackoverflow','http://stackoverflow.com',0,'IND');
