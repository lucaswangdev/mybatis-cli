/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : mybatis-cli

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 18/08/2024 11:38:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `user_name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `sex` varchar(1) DEFAULT NULL COMMENT '性别',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (2, '2024-08-18 11:18:18', '2024-08-18 11:18:18', 'xxxName', '1', 'Updated Address');
INSERT INTO `user` VALUES (3, '2024-08-18 00:00:42', '2024-08-18 00:00:42', 'SelectiveUser', NULL, NULL);
INSERT INTO `user` VALUES (4, '2024-08-18 00:21:06', '2024-08-18 00:21:06', 'SelectiveUser', NULL, NULL);
INSERT INTO `user` VALUES (5, '2024-08-18 00:41:30', '2024-08-18 00:41:30', 'SelectiveUser', NULL, NULL);
INSERT INTO `user` VALUES (6, '2024-08-18 00:51:57', '2024-08-18 00:51:57', 'SelectiveUser', NULL, NULL);
INSERT INTO `user` VALUES (7, '2024-08-18 10:22:58', '2024-08-18 10:22:58', 'SelectiveUser', NULL, NULL);
INSERT INTO `user` VALUES (8, '2024-08-18 10:42:09', '2024-08-18 10:42:09', 'Lucas1', 'M', 'Address1');
INSERT INTO `user` VALUES (9, '2024-08-18 10:42:09', '2024-08-18 10:42:09', 'Lucas2', 'M', 'Address2');
INSERT INTO `user` VALUES (10, '2024-08-18 10:42:09', '2024-08-18 10:42:09', 'SelectiveUser', NULL, NULL);
INSERT INTO `user` VALUES (11, '2024-08-18 10:54:41', '2024-08-18 10:54:41', 'Lucas1', 'M', 'Address1');
INSERT INTO `user` VALUES (12, '2024-08-18 10:54:41', '2024-08-18 10:54:41', 'Lucas2', 'M', 'Address2');
INSERT INTO `user` VALUES (13, '2024-08-18 10:54:41', '2024-08-18 10:54:41', 'SelectiveUser', NULL, NULL);
INSERT INTO `user` VALUES (14, '2024-08-18 11:13:19', '2024-08-18 11:13:19', 'Lucas1', 'M', 'Address1');
INSERT INTO `user` VALUES (15, '2024-08-18 11:13:19', '2024-08-18 11:13:19', 'Lucas2', 'M', 'Address2');
INSERT INTO `user` VALUES (16, '2024-08-18 11:13:19', '2024-08-18 11:13:19', 'SelectiveUser', NULL, NULL);
INSERT INTO `user` VALUES (17, '2024-08-18 11:18:18', '2024-08-18 11:18:18', 'Lucas1', 'M', 'Address1');
INSERT INTO `user` VALUES (18, '2024-08-18 11:18:18', '2024-08-18 11:18:18', 'Lucas2', 'M', 'Address2');
INSERT INTO `user` VALUES (19, '2024-08-18 11:18:18', '2024-08-18 11:18:18', 'SelectiveUser', NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
