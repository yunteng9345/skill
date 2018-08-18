/*
 Navicat MySQL Data Transfer

 Source Server         : project1
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : fingerprint

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 10/08/2018 12:01:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for u_check
-- ----------------------------
DROP TABLE IF EXISTS `u_check`;
CREATE TABLE `u_check`  (
  `fid` varchar(20) CHARACTER SET utf8 COLLATE utf8mb4_unicode_ci  NOT NULL,
  `clock_in_1` datetime(6) NULL DEFAULT NULL,
  `clock_in_2` datetime(6) NULL DEFAULT NULL,
  `flag` char(1) CHARACTER SET utf8 COLLATE utf8mb4_unicode_ci  NULL DEFAULT '0' COMMENT '标志位',
  `cno` int(11) NOT NULL AUTO_INCREMENT,
  `befor` varchar(5) CHARACTER SET utf8 COLLATE utf8mb4_unicode_ci  NULL DEFAULT NULL,
  `late` varchar(5) CHARACTER SET utf8 COLLATE utf8mb4_unicode_ci  NULL DEFAULT NULL,
  PRIMARY KEY (`cno`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of u_check
-- ----------------------------
INSERT INTO `u_check` VALUES ('f01', '2018-08-10 09:25:02.000000', '2018-07-27 09:25:11.000000', '2', 15, NULL, NULL);
INSERT INTO `u_check` VALUES ('f0009', '2018-08-10 12:06:19.000000', '2018-07-27 23:06:23.000000', '2', 16, '0', '1');
INSERT INTO `u_check` VALUES ('f0002', '2018-08-10 12:45:02.000000', '2018-07-27 19:45:04.000000', '2', 18, '0', '1');
INSERT INTO `u_check` VALUES ('f0003', '2018-08-10 12:45:10.000000', '2018-08-10 21:45:12.000000', '2', 19, '0', '1');
INSERT INTO `u_check` VALUES ('f0004', '2018-07-27 08:45:18.000000', '2018-08-10 13:45:19.000000', '2', 20, '1', '0');
INSERT INTO `u_check` VALUES ('f0001', '2018-07-27 05:33:32.000000', '2018-07-27 19:33:35.000000', '2', 21, '0', '0');
INSERT INTO `u_check` VALUES ('f02', '2018-07-27 10:44:33.208000', '2018-07-27 10:44:36.878000', '2', 22, '1', '1');
INSERT INTO `u_check` VALUES ('f6666', '2018-08-10 10:32:52.468000', '2018-08-10 10:32:54.918000', '2', 23, '1', '1');
INSERT INTO `u_check` VALUES ('251', '2018-08-10 06:59:07.000000', '2018-08-10 10:59:20.947000', '2', 24, '1', '0');

-- ----------------------------
-- Table structure for u_user
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user`  (
  `uid` varchar(20) CHARACTER SET utf8 COLLATE utf8mb4_unicode_ci  NULL DEFAULT NULL COMMENT '用户学号',
  `ufingerid` varchar(20) CHARACTER SET utf8 COLLATE utf8mb4_unicode_ci  NULL DEFAULT NULL COMMENT '用户指纹id',
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8mb4_unicode_ci  NULL DEFAULT NULL COMMENT '用户姓名',
  `usex` varchar(255) CHARACTER SET utf8 COLLATE utf8mb4_unicode_ci  NULL DEFAULT NULL COMMENT '用户性别',
  `uage` int(255) NULL DEFAULT NULL COMMENT '用户年龄',
  `uclass` varchar(255) CHARACTER SET utf8 COLLATE utf8mb4_unicode_ci  NULL DEFAULT NULL COMMENT '用户班级',
  `uacademy` varchar(255) CHARACTER SET utf8 COLLATE utf8mb4_unicode_ci  NULL DEFAULT NULL COMMENT '用户院系',
  `urtime` datetime(0) NULL DEFAULT NULL COMMENT '用户注册时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES ('20154042056', 'f0001', '云腾', '男', 23, '计算机科学与技术', '信息科学与工程学院', '2018-07-20 17:16:37');
INSERT INTO `u_user` VALUES ('20154042057', 'f0002', '谢婉婷', '女', 22, '计算机科学与技术', '信息科学与工程学院', '2018-07-20 17:36:49');
INSERT INTO `u_user` VALUES ('20154042002', 'f0004', '李维', '女', 21, 'xxx班级', 'xxxx学院', '2018-07-22 18:44:37');
INSERT INTO `u_user` VALUES ('20154042003', 'f0003', '滕峰', '男', 20, 'xxx班级', 'xxxx学院', '2018-07-23 11:49:05');
INSERT INTO `u_user` VALUES ('20154042004', 'f0007', '廖欢', '男', 22, 'xxx班级', 'xxxx学院', '2018-07-23 12:07:55');
INSERT INTO `u_user` VALUES ('20154042005', 'f0009', '王唐', '男', 22, 'xxx班级', 'xxxx学院', '2018-07-23 12:32:29');
INSERT INTO `u_user` VALUES ('20154042006', 'f0010', '黄梦玉', '女', 20, 'xxx班级', 'xxxx学院', '2018-07-23 12:48:24');
INSERT INTO `u_user` VALUES ('201540420566', 'f6666', '云腾', '男', 23, 'xxx班级', 'xxxx学院', '2018-08-10 10:32:49');
INSERT INTO `u_user` VALUES ('0001', '251', '1', '男', 1, 'xxx班级', 'xxxx学院', '2018-08-10 10:58:36');

-- ----------------------------
-- Procedure structure for GetUser
-- ----------------------------
DROP PROCEDURE IF EXISTS `GetUser`;
delimiter ;;
CREATE PROCEDURE `GetUser`()
BEGIN
SELECT * from u_user;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
