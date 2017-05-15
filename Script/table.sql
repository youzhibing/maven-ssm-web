/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2017-05-15 20:14:11
*/

SET FOREIGN_KEY_CHECKS=0;

USE mybatis;

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(8) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  `age` tinyint(3) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', 'Bruce lee', '25');
INSERT INTO `person` VALUES ('2', '李小龙', '1');

-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(8) NOT NULL auto_increment,
  `country` varchar(50) NOT NULL,
  `province` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `town` varchar(50) NOT NULL,
  `village` varchar(50) NOT NULL,
  `street` varchar(50) NOT NULL,
  `houseNumber` int(3) NOT NULL,
  `personId` int(8) NOT NULL UNIQUE,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (1, '中国', '广东省', '深圳市', '龙岗区', '吉祥花园新村', '坂雪岗大道' ,47604, 1);
INSERT INTO `address` VALUES (2, 'America', '广东省', '深圳市', '龙岗区', '吉祥花园新村', '坂雪岗大道' ,47604, 2);

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(8) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  `price` char(6) NOT NULL,
  `publisher` varchar(50) NOT NULL,
  `personId` int(8) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '计算机原理', '67.00', '中国清华大学出版社', 1);
INSERT INTO `book` VALUES (2, '重构 改善既有代码的设计', '69.00', '人民邮电出版社', 1);
INSERT INTO `book` VALUES (3, '深入理解java虚拟机', '79.00', '机械工业出版社', 2);
INSERT INTO `book` VALUES (4, '计算机原理', '69.00', '人民邮电出版社', 2);
