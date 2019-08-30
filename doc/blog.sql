/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 30/08/2019 13:27:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment_number` bigint(20) NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `little_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `little_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `view_number` bigint(20) NULL DEFAULT NULL,
  `mood_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKnwck5t6ye777cw5njohwcjlh9`(`mood_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES (1, NULL, '# 大萨达撒大啥大所\n~~大萨达撒大啥奥多所大所多~~', NULL, '2019-08-30 00:08', '20190830000811965.png', NULL, NULL, 'java', NULL, NULL);
INSERT INTO `blog` VALUES (2, 0, '# 正文', NULL, '2019-08-30 10:41', NULL, NULL, '大沙发上', '标题', 0, NULL);
INSERT INTO `blog` VALUES (3, 0, '# dsa', NULL, '2019-08-30 10:49', NULL, NULL, '发达', '标题', 0, NULL);
INSERT INTO `blog` VALUES (4, 0, '#### 大萨达撒', 'default.jpg', '2019-08-30 10:51', NULL, NULL, 'fasdas', '大萨达', 0, NULL);

-- ----------------------------
-- Table structure for blog_catalog
-- ----------------------------
DROP TABLE IF EXISTS `blog_catalog`;
CREATE TABLE `blog_catalog`  (
  `blog_id` bigint(20) NOT NULL,
  `catelog_id` bigint(20) NOT NULL,
  `catalog_id` bigint(20) NOT NULL,
  PRIMARY KEY (`blog_id`, `catelog_id`) USING BTREE,
  INDEX `FK327ueiuu3xyx8o4rggivge2if`(`catelog_id`) USING BTREE,
  INDEX `FKfo32rwtsnmv0bccmx8hl62rym`(`catalog_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for blog_catalogs
-- ----------------------------
DROP TABLE IF EXISTS `blog_catalogs`;
CREATE TABLE `blog_catalogs`  (
  `blogs_id` bigint(20) NOT NULL,
  `catalogs_id` bigint(20) NOT NULL,
  PRIMARY KEY (`blogs_id`, `catalogs_id`) USING BTREE,
  INDEX `FKlfgfpm37ktlouex9n1yixf85q`(`catalogs_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for catalog
-- ----------------------------
DROP TABLE IF EXISTS `catalog`;
CREATE TABLE `catalog`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `catalog` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of catalog
-- ----------------------------
INSERT INTO `catalog` VALUES (1, 'java');
INSERT INTO `catalog` VALUES (2, 'python');
INSERT INTO `catalog` VALUES (6, 'c++');
INSERT INTO `catalog` VALUES (7, 'c#');
INSERT INTO `catalog` VALUES (8, 'mysql');

-- ----------------------------
-- Table structure for mood
-- ----------------------------
DROP TABLE IF EXISTS `mood`;
CREATE TABLE `mood`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `creat_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK650gbgeldymqxf4wmj7ldqkyl`(`user_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mood
-- ----------------------------
INSERT INTO `mood` VALUES (12, '后天就要上学了 呜呜呜', '2019-08-29 22:58', '20190829225821720.gif', '不好', 1);
INSERT INTO `mood` VALUES (13, '(＾－＾)V', '2019-08-29 23:47', '20190829234719905.gif', '我是你哥哥', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(22) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `personal_sign` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `username` varchar(22) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image_original` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '20190828192156748.jpg', '123', '大萨达撒', 'dsa打', NULL, '20190828174336098.png');

-- ----------------------------
-- Table structure for user_moods
-- ----------------------------
DROP TABLE IF EXISTS `user_moods`;
CREATE TABLE `user_moods`  (
  `user_id` bigint(20) NOT NULL,
  `moods_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`, `moods_id`) USING BTREE,
  UNIQUE INDEX `UK_h9dui383vg8lwnpq9ai0j4vjv`(`moods_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Fixed;

SET FOREIGN_KEY_CHECKS = 1;
