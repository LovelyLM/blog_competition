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

 Date: 30/08/2019 15:26:55
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
) ENGINE = MyISAM AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES (13, 0, '### 大三', 'default.jpg', '2019-08-30 15:17', NULL, NULL, '导语2', '标题2', 0, NULL);
INSERT INTO `blog` VALUES (12, 0, '# 正文', 'default.jpg', '2019-08-30 15:16', NULL, NULL, '导语', '标题', 0, NULL);

-- ----------------------------
-- Table structure for blog_catalog
-- ----------------------------
DROP TABLE IF EXISTS `blog_catalog`;
CREATE TABLE `blog_catalog`  (
  `blog_id` bigint(20) NOT NULL,
  `catalog_id` bigint(20) NOT NULL,
  INDEX `FKfo32rwtsnmv0bccmx8hl62rym`(`catalog_id`) USING BTREE,
  INDEX `FKikb6hat2wa3gsf09mpjjvdsfw`(`blog_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of blog_catalog
-- ----------------------------
INSERT INTO `blog_catalog` VALUES (13, 1);
INSERT INTO `blog_catalog` VALUES (12, 20);

-- ----------------------------
-- Table structure for catalog
-- ----------------------------
DROP TABLE IF EXISTS `catalog`;
CREATE TABLE `catalog`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `catalog` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of catalog
-- ----------------------------
INSERT INTO `catalog` VALUES (1, 'java');
INSERT INTO `catalog` VALUES (20, '分类');

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
