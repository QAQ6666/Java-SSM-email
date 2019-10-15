/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : lzhemail

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 10/09/2019 14:31:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for emailuser
-- ----------------------------
DROP TABLE IF EXISTS `emailuser`;
CREATE TABLE `emailuser`  (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `emailstr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `euname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`eid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 61 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emailuser
-- ----------------------------
INSERT INTO `emailuser` VALUES (60, '2606292175@qq.com', 'QAQlzh');
INSERT INTO `emailuser` VALUES (2, '3426246609@qq.com', 'qweqwe');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (1);

-- ----------------------------
-- Table structure for recordingemail
-- ----------------------------
DROP TABLE IF EXISTS `recordingemail`;
CREATE TABLE `recordingemail`  (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rdate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rtext` varchar(9100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rtheme` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rminfilename` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rminfile` mediumblob NOT NULL,
  `rbigfile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `eid` int(11) NOT NULL,
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of recordingemail
-- ----------------------------
INSERT INTO `recordingemail` VALUES (1, '2019-04-03 10:28:18', 'Welcome to the Six apples mailboxqweqweeqwe', 'qweqweqwe', '', '', '', 60);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` bigint(20) NOT NULL,
  `eid` bigint(20) NOT NULL,
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `upwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `UK_jtqc53gern129gvqam7tel77n`(`eid`) USING BTREE,
  UNIQUE INDEX `UK_33usp01rahy3w7nv0g62b3s8s`(`uname`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for userdraft
-- ----------------------------
DROP TABLE IF EXISTS `userdraft`;
CREATE TABLE `userdraft`  (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `drecipient` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dtheme` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dcon` varchar(9100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `deid` int(11) NOT NULL,
  `ddata` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`did`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userdraft
-- ----------------------------
INSERT INTO `userdraft` VALUES (1, '', '', 'Welcome to the Six apples mailbox', 60, '2019-04-13 21:09:07');

SET FOREIGN_KEY_CHECKS = 1;
