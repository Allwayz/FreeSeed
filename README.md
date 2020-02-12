# FreeSeed



>   FreeSeed是一款现代化的，独立的，学生管理系统。

<p align="center">
    <a href = "https://docs.oracle.com/javase/8/docs/"><img src="https://badgen.net/badge/JDK/1.8/yellow"></a>
    <a href = "https://github.com/Allwayz/FreeSeed"><img src="https://badgen.net/github/forks/Allwayz/FreeSeed"></a>
    <a href = "https://github.com/Allwayz/FreeSeed/issues"><img src="https://badgen.net/github/issues/Allwayz/FreeSeed"></a>
	<a href = "https://github.com/Allwayz/FreeSeed/releases"><img src="https://badgen.net/github/release/Allwayz/FreeSeed"></a>
    <a href = "https://github.com/Allwayz/FreeSeed/tags"><img src="https://badgen.net/github/tag/Allwayz/FreeSeed"></a>
    <a href = "https://github.com/Allwayz/FreeSeed"><img src="https://badgen.net/github/commits/Allwayz/FreeSeed"></a>
    <img src="https://badgen.net/github/last-commit/Allwayz/FreeSeed/master">
</p>

------

## 简介

**FreeSeed是一款现代化的，独立的，学生管理系统。**

>   [官网](https://allwayz.github.io/) | 社区 | [Email](2584491610@qq.com) | Telegram

数据库文件！本地 `mysql` 

```sql
/*
 Navicat Premium Data Transfer

 Source Server         : ALLWAYZ
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : FreeSeed

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 11/02/2020 14:22:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for city_dtl
-- ----------------------------
DROP TABLE IF EXISTS `city_dtl`;
CREATE TABLE `city_dtl` (
  `city_dtl_id` int NOT NULL AUTO_INCREMENT,
  `city_dtl_name` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_delete` tinyint DEFAULT '0',
  `province_dtl_id` int DEFAULT NULL,
  PRIMARY KEY (`city_dtl_id`),
  KEY `province_dtl_id` (`province_dtl_id`),
  CONSTRAINT `province_dtl_id` FOREIGN KEY (`province_dtl_id`) REFERENCES `province_dtl` (`province_dtl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for classroom
-- ----------------------------
DROP TABLE IF EXISTS `classroom`;
CREATE TABLE `classroom` (
  `classroom_id` int NOT NULL AUTO_INCREMENT,
  `classroom_floor` varchar(255) DEFAULT NULL,
  `classroom_name` varchar(255) DEFAULT NULL,
  `classroom_capacity` int DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_delete` tinyint DEFAULT '0',
  PRIMARY KEY (`classroom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for enrollment
-- ----------------------------
DROP TABLE IF EXISTS `enrollment`;
CREATE TABLE `enrollment` (
  `enrollment_id` int NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_delete` tinyint DEFAULT '0',
  `user_id` int DEFAULT NULL,
  `major_dtl_id` int DEFAULT NULL,
  PRIMARY KEY (`enrollment_id`),
  KEY `user_id` (`user_id`),
  KEY `major_dtl_id` (`major_dtl_id`),
  CONSTRAINT `major_dtl_id` FOREIGN KEY (`major_dtl_id`) REFERENCES `major_dtl` (`major_dtl_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `major_id` int NOT NULL AUTO_INCREMENT,
  `major_code` varchar(255) DEFAULT NULL,
  `major_name` varchar(255) DEFAULT NULL,
  `major_status` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_delete` tinyint DEFAULT '0',
  PRIMARY KEY (`major_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for major_dtl
-- ----------------------------
DROP TABLE IF EXISTS `major_dtl`;
CREATE TABLE `major_dtl` (
  `major_dtl_id` int NOT NULL AUTO_INCREMENT,
  `semester` varchar(255) DEFAULT NULL,
  `semester_year` int DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_delete` tinyint DEFAULT '0',
  `major_id` int DEFAULT NULL,
  `classroom_id` int DEFAULT NULL,
  PRIMARY KEY (`major_dtl_id`),
  KEY `major_id` (`major_id`),
  KEY `classroom_id` (`classroom_id`),
  CONSTRAINT `classroom_id` FOREIGN KEY (`classroom_id`) REFERENCES `classroom` (`classroom_id`),
  CONSTRAINT `major_id` FOREIGN KEY (`major_id`) REFERENCES `major` (`major_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for national_dtl
-- ----------------------------
DROP TABLE IF EXISTS `national_dtl`;
CREATE TABLE `national_dtl` (
  `national_dtl_id` int NOT NULL AUTO_INCREMENT,
  `national_dtl_name` varchar(255) DEFAULT NULL,
  `national_dtl_code` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_delete` tinyint DEFAULT '0',
  PRIMARY KEY (`national_dtl_id`)
) ENGINE=InnoDB AUTO_INCREMENT=194 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of national_dtl
-- ----------------------------
BEGIN;
INSERT INTO `national_dtl` VALUES (1, 'China', 'CN', '2020-02-08 15:46:52', '2020-02-08 15:46:52', 0);
INSERT INTO `national_dtl` VALUES (2, 'Andorra', 'AD', '2020-02-08 17:29:02', '2020-02-08 17:29:02', 0);
INSERT INTO `national_dtl` VALUES (3, 'United Arab Emirates', 'AE', '2020-02-08 17:29:02', '2020-02-08 17:29:02', 0);
INSERT INTO `national_dtl` VALUES (4, 'Afghanistan', 'AF', '2020-02-08 17:29:02', '2020-02-08 17:29:02', 0);
INSERT INTO `national_dtl` VALUES (5, 'Antigua and Barbuda', 'AG', '2020-02-08 17:58:00', '2020-02-08 17:58:00', 0);
INSERT INTO `national_dtl` VALUES (6, 'Anguilla', 'AI', '2020-02-08 17:58:00', '2020-02-08 17:58:00', 0);
INSERT INTO `national_dtl` VALUES (7, 'Albania', 'AL', '2020-02-08 17:58:00', '2020-02-08 17:58:00', 0);
INSERT INTO `national_dtl` VALUES (8, 'Armenia', 'AM', '2020-02-08 17:58:00', '2020-02-08 17:58:00', 0);
INSERT INTO `national_dtl` VALUES (9, 'Ascension', 'null', '2020-02-08 17:58:00', '2020-02-08 17:58:00', 0);
INSERT INTO `national_dtl` VALUES (10, 'Angola', 'AO', '2020-02-08 17:58:00', '2020-02-08 17:58:00', 0);
INSERT INTO `national_dtl` VALUES (11, 'Argentina', 'AR', '2020-02-08 17:58:00', '2020-02-08 17:58:00', 0);
INSERT INTO `national_dtl` VALUES (12, 'Austria', 'AT', '2020-02-08 17:58:00', '2020-02-08 17:58:00', 0);
INSERT INTO `national_dtl` VALUES (13, 'Australia', 'AU', '2020-02-08 17:58:00', '2020-02-08 17:58:00', 0);
INSERT INTO `national_dtl` VALUES (14, 'Azerbaijan', 'AZ', '2020-02-08 18:00:23', '2020-02-08 18:00:23', 0);
INSERT INTO `national_dtl` VALUES (15, 'Barbados', 'BB', '2020-02-08 18:10:56', '2020-02-08 18:10:56', 0);
INSERT INTO `national_dtl` VALUES (16, 'Bangladesh', 'BD', '2020-02-08 18:10:56', '2020-02-08 18:10:56', 0);
INSERT INTO `national_dtl` VALUES (17, 'Belgium', 'BE', '2020-02-08 18:10:56', '2020-02-08 18:10:56', 0);
INSERT INTO `national_dtl` VALUES (18, 'Burkina-faso', 'BF', '2020-02-08 18:10:56', '2020-02-08 18:10:56', 0);
INSERT INTO `national_dtl` VALUES (19, 'Bulgaria', 'BG', '2020-02-08 18:10:56', '2020-02-08 18:10:56', 0);
INSERT INTO `national_dtl` VALUES (20, 'Bahrain', 'BH', '2020-02-08 18:10:56', '2020-02-08 18:10:56', 0);
INSERT INTO `national_dtl` VALUES (21, 'Burundi', 'BI', '2020-02-08 18:10:56', '2020-02-08 18:10:56', 0);
INSERT INTO `national_dtl` VALUES (22, 'Benin', 'BJ', '2020-02-08 18:10:56', '2020-02-08 18:10:56', 0);
INSERT INTO `national_dtl` VALUES (23, 'Palestine', 'BL', '2020-02-08 18:10:56', '2020-02-08 18:10:56', 0);
INSERT INTO `national_dtl` VALUES (24, 'Bermuda Is.', 'BM', '2020-02-08 18:10:56', '2020-02-08 18:10:56', 0);
INSERT INTO `national_dtl` VALUES (25, 'Brunei', 'BN', '2020-02-08 18:10:56', '2020-02-08 18:10:56', 0);
INSERT INTO `national_dtl` VALUES (26, 'Bolivia', 'BO', '2020-02-08 18:10:56', '2020-02-08 18:10:56', 0);
INSERT INTO `national_dtl` VALUES (27, 'Brazil', 'BR', '2020-02-08 18:10:56', '2020-02-08 18:10:56', 0);
INSERT INTO `national_dtl` VALUES (28, 'Bahamas', 'BS', '2020-02-08 18:10:56', '2020-02-08 18:10:56', 0);
INSERT INTO `national_dtl` VALUES (29, 'Botswana', 'BW', '2020-02-08 18:10:56', '2020-02-08 18:10:56', 0);
INSERT INTO `national_dtl` VALUES (30, 'Belarus', 'BY', '2020-02-08 18:10:56', '2020-02-08 18:10:56', 0);
INSERT INTO `national_dtl` VALUES (31, 'Belize', 'BZ', '2020-02-08 18:10:56', '2020-02-08 18:10:56', 0);
INSERT INTO `national_dtl` VALUES (32, 'Canada', 'CA', '2020-02-08 18:28:00', '2020-02-08 18:28:00', 0);
INSERT INTO `national_dtl` VALUES (33, 'Cayman Is.', 'null', '2020-02-08 18:28:00', '2020-02-08 18:28:00', 0);
INSERT INTO `national_dtl` VALUES (34, 'Central African Republic', 'CF', '2020-02-08 18:28:00', '2020-02-08 18:28:00', 0);
INSERT INTO `national_dtl` VALUES (35, 'Congo', 'CG', '2020-02-08 18:28:00', '2020-02-08 18:28:00', 0);
INSERT INTO `national_dtl` VALUES (36, 'Switzerland', 'CH', '2020-02-08 18:28:00', '2020-02-08 18:28:00', 0);
INSERT INTO `national_dtl` VALUES (37, 'Cook Is.', 'CK', '2020-02-08 18:28:00', '2020-02-08 18:28:00', 0);
INSERT INTO `national_dtl` VALUES (38, 'Chile', 'CL', '2020-02-08 18:28:00', '2020-02-08 18:28:00', 0);
INSERT INTO `national_dtl` VALUES (39, 'Cameroon', 'CM', '2020-02-08 18:28:00', '2020-02-08 18:28:00', 0);
INSERT INTO `national_dtl` VALUES (40, 'Colombia', 'CO', '2020-02-08 18:28:00', '2020-02-08 18:28:00', 0);
INSERT INTO `national_dtl` VALUES (41, 'Costa Rica', 'CR', '2020-02-08 18:28:00', '2020-02-08 18:28:00', 0);
INSERT INTO `national_dtl` VALUES (42, 'Czech', 'CS', '2020-02-08 18:28:00', '2020-02-08 18:28:00', 0);
INSERT INTO `national_dtl` VALUES (43, 'Cuba', 'CU', '2020-02-08 18:28:00', '2020-02-08 18:28:00', 0);
INSERT INTO `national_dtl` VALUES (44, 'Cyprus', 'CY', '2020-02-08 18:28:00', '2020-02-08 18:28:00', 0);
INSERT INTO `national_dtl` VALUES (45, 'Czech Republic', 'CZ', '2020-02-08 18:28:00', '2020-02-08 18:28:00', 0);
INSERT INTO `national_dtl` VALUES (46, 'Germany', 'DE', '2020-02-08 18:34:32', '2020-02-08 18:34:32', 0);
INSERT INTO `national_dtl` VALUES (47, 'Djibouti', 'DJ', '2020-02-08 18:34:32', '2020-02-08 18:34:32', 0);
INSERT INTO `national_dtl` VALUES (48, 'Denmark', 'DK', '2020-02-08 18:34:32', '2020-02-08 18:34:32', 0);
INSERT INTO `national_dtl` VALUES (49, 'Dominica Rep.', 'DO', '2020-02-08 18:34:32', '2020-02-08 18:34:32', 0);
INSERT INTO `national_dtl` VALUES (50, 'Algeria', 'DZ', '2020-02-08 18:34:32', '2020-02-08 18:34:32', 0);
INSERT INTO `national_dtl` VALUES (51, 'Ecuador', 'EC', '2020-02-08 18:34:32', '2020-02-08 18:34:32', 0);
INSERT INTO `national_dtl` VALUES (52, 'Estonia', 'EE', '2020-02-08 18:34:32', '2020-02-08 18:34:32', 0);
INSERT INTO `national_dtl` VALUES (53, 'Egypt', 'EG', '2020-02-08 18:34:32', '2020-02-08 18:34:32', 0);
INSERT INTO `national_dtl` VALUES (54, 'Spain', 'ES', '2020-02-08 18:34:32', '2020-02-08 18:34:32', 0);
INSERT INTO `national_dtl` VALUES (55, 'Ethiopia', 'ET', '2020-02-08 18:34:32', '2020-02-08 18:34:32', 0);
INSERT INTO `national_dtl` VALUES (56, 'Finland', 'FI', '2020-02-08 18:34:32', '2020-02-08 18:34:32', 0);
INSERT INTO `national_dtl` VALUES (57, 'Fiji', 'FJ', '2020-02-08 18:34:32', '2020-02-08 18:34:32', 0);
INSERT INTO `national_dtl` VALUES (58, 'France', 'FR', '2020-02-08 18:34:32', '2020-02-08 18:34:32', 0);
INSERT INTO `national_dtl` VALUES (59, 'Gabon', 'GA', '2020-02-09 17:08:49', '2020-02-09 17:08:49', 0);
INSERT INTO `national_dtl` VALUES (60, 'United Kingdom', 'GB', '2020-02-09 17:08:49', '2020-02-09 17:08:49', 0);
INSERT INTO `national_dtl` VALUES (61, 'Grenada', 'GD', '2020-02-09 17:08:49', '2020-02-09 17:08:49', 0);
INSERT INTO `national_dtl` VALUES (62, 'Georgia', 'GE', '2020-02-09 17:08:49', '2020-02-09 17:08:49', 0);
INSERT INTO `national_dtl` VALUES (63, 'French Guiana', 'GF', '2020-02-09 17:08:49', '2020-02-09 17:08:49', 0);
INSERT INTO `national_dtl` VALUES (64, 'Ghana', 'GH', '2020-02-09 17:08:49', '2020-02-09 17:08:49', 0);
INSERT INTO `national_dtl` VALUES (65, 'Gibraltar', 'GI', '2020-02-09 17:08:49', '2020-02-09 17:08:49', 0);
INSERT INTO `national_dtl` VALUES (66, 'Gambia', 'GM', '2020-02-09 17:08:49', '2020-02-09 17:08:49', 0);
INSERT INTO `national_dtl` VALUES (67, 'Guinea', 'GN', '2020-02-09 17:08:49', '2020-02-09 17:08:49', 0);
INSERT INTO `national_dtl` VALUES (68, 'Greece', 'GR', '2020-02-09 17:08:49', '2020-02-09 17:08:49', 0);
INSERT INTO `national_dtl` VALUES (69, 'Guatemala', 'GT', '2020-02-09 17:08:49', '2020-02-09 17:08:49', 0);
INSERT INTO `national_dtl` VALUES (70, 'Guam', 'GU', '2020-02-09 17:08:49', '2020-02-09 17:08:49', 0);
INSERT INTO `national_dtl` VALUES (71, 'Guyana', 'GY', '2020-02-09 17:08:49', '2020-02-09 17:08:49', 0);
INSERT INTO `national_dtl` VALUES (72, 'Hongkong', 'HK', '2020-02-09 17:13:30', '2020-02-09 17:13:30', 0);
INSERT INTO `national_dtl` VALUES (73, 'Honduras', 'HN', '2020-02-09 17:13:30', '2020-02-09 17:13:30', 0);
INSERT INTO `national_dtl` VALUES (74, 'Haiti', 'HT', '2020-02-09 17:13:30', '2020-02-09 17:13:30', 0);
INSERT INTO `national_dtl` VALUES (75, 'Hungary', 'HU', '2020-02-09 17:13:30', '2020-02-09 17:13:30', 0);
INSERT INTO `national_dtl` VALUES (76, 'Indonesia', 'ID', '2020-02-09 17:13:30', '2020-02-09 17:13:30', 0);
INSERT INTO `national_dtl` VALUES (77, 'Ireland', 'IE', '2020-02-09 17:13:30', '2020-02-09 17:13:30', 0);
INSERT INTO `national_dtl` VALUES (78, 'Israel', 'IL', '2020-02-09 17:13:30', '2020-02-09 17:13:30', 0);
INSERT INTO `national_dtl` VALUES (79, 'India', 'IN', '2020-02-09 17:13:30', '2020-02-09 17:13:30', 0);
INSERT INTO `national_dtl` VALUES (80, 'Iraq', 'IQ', '2020-02-09 17:13:30', '2020-02-09 17:13:30', 0);
INSERT INTO `national_dtl` VALUES (81, 'Iran', 'IR', '2020-02-09 17:13:30', '2020-02-09 17:13:30', 0);
INSERT INTO `national_dtl` VALUES (82, 'Iceland', 'IS', '2020-02-09 17:13:30', '2020-02-09 17:13:30', 0);
INSERT INTO `national_dtl` VALUES (83, 'Italy', 'IT', '2020-02-09 17:13:30', '2020-02-09 17:13:30', 0);
INSERT INTO `national_dtl` VALUES (84, 'Ivory Coast', 'null', '2020-02-09 17:13:30', '2020-02-09 17:13:30', 0);
INSERT INTO `national_dtl` VALUES (85, 'Jamaica', 'JM', '2020-02-09 17:20:52', '2020-02-09 17:20:52', 0);
INSERT INTO `national_dtl` VALUES (86, 'Jordan', 'JO', '2020-02-09 17:20:52', '2020-02-09 17:20:52', 0);
INSERT INTO `national_dtl` VALUES (87, 'Japan', 'JP', '2020-02-09 17:20:52', '2020-02-09 17:20:52', 0);
INSERT INTO `national_dtl` VALUES (88, 'Kenya', 'KE', '2020-02-09 17:20:52', '2020-02-09 17:20:52', 0);
INSERT INTO `national_dtl` VALUES (89, 'Kyrgyzstan', 'KG', '2020-02-09 17:20:52', '2020-02-09 17:20:52', 0);
INSERT INTO `national_dtl` VALUES (90, 'Kampuchea (Cambodia)', 'KH', '2020-02-09 17:20:52', '2020-02-09 17:20:52', 0);
INSERT INTO `national_dtl` VALUES (91, 'North Korea', 'KP', '2020-02-09 17:20:52', '2020-02-09 17:20:52', 0);
INSERT INTO `national_dtl` VALUES (92, 'Korea', 'KR', '2020-02-09 17:20:52', '2020-02-09 17:20:52', 0);
INSERT INTO `national_dtl` VALUES (93, 'Republic of Ivory Coast', 'KT', '2020-02-09 17:20:52', '2020-02-09 17:20:52', 0);
INSERT INTO `national_dtl` VALUES (94, 'Kuwait', 'KW', '2020-02-09 17:20:52', '2020-02-09 17:20:52', 0);
INSERT INTO `national_dtl` VALUES (95, 'Kazakhstan', 'KZ', '2020-02-09 17:20:52', '2020-02-09 17:20:52', 0);
INSERT INTO `national_dtl` VALUES (96, 'Laos', 'LA', '2020-02-09 17:20:52', '2020-02-09 17:20:52', 0);
INSERT INTO `national_dtl` VALUES (97, 'Lebanon', 'LB', '2020-02-09 17:20:52', '2020-02-09 17:20:52', 0);
INSERT INTO `national_dtl` VALUES (98, 'St.Lucia', 'LC', '2020-02-09 17:20:52', '2020-02-09 17:20:52', 0);
INSERT INTO `national_dtl` VALUES (99, 'Liechtenstein', 'LI', '2020-02-09 17:20:52', '2020-02-09 17:20:52', 0);
INSERT INTO `national_dtl` VALUES (100, 'Sri Lanka', 'LK', '2020-02-09 17:20:52', '2020-02-09 17:20:52', 0);
INSERT INTO `national_dtl` VALUES (101, 'Liberia', 'LR', '2020-02-09 17:20:52', '2020-02-09 17:20:52', 0);
INSERT INTO `national_dtl` VALUES (102, 'Lesotho', 'LS', '2020-02-09 17:20:52', '2020-02-09 17:20:52', 0);
INSERT INTO `national_dtl` VALUES (103, 'Lithuania', 'LT', '2020-02-09 17:20:52', '2020-02-09 17:20:52', 0);
INSERT INTO `national_dtl` VALUES (104, 'Luxembourg', 'LU', '2020-02-09 17:20:52', '2020-02-09 17:20:52', 0);
INSERT INTO `national_dtl` VALUES (105, 'Latvia', 'LV', '2020-02-09 17:20:52', '2020-02-09 17:20:52', 0);
INSERT INTO `national_dtl` VALUES (106, 'Libya', 'LY', '2020-02-09 17:20:52', '2020-02-09 17:20:52', 0);
INSERT INTO `national_dtl` VALUES (107, 'Morocco', 'MA', '2020-02-09 17:26:34', '2020-02-09 17:26:34', 0);
INSERT INTO `national_dtl` VALUES (108, 'Monaco', 'MC', '2020-02-09 17:26:34', '2020-02-09 17:26:34', 0);
INSERT INTO `national_dtl` VALUES (109, 'Moldova', 'MD', '2020-02-09 17:26:34', '2020-02-09 17:26:34', 0);
INSERT INTO `national_dtl` VALUES (110, 'Madagascar', 'MG', '2020-02-09 17:26:34', '2020-02-09 17:26:34', 0);
INSERT INTO `national_dtl` VALUES (111, 'Mali', 'ML', '2020-02-09 17:26:34', '2020-02-09 17:26:34', 0);
INSERT INTO `national_dtl` VALUES (112, 'Burma', 'MM', '2020-02-09 17:26:34', '2020-02-09 17:26:34', 0);
INSERT INTO `national_dtl` VALUES (113, 'Mongolia', 'MN', '2020-02-09 17:26:34', '2020-02-09 17:26:34', 0);
INSERT INTO `national_dtl` VALUES (114, 'Macao', 'MO', '2020-02-09 17:26:34', '2020-02-09 17:26:34', 0);
INSERT INTO `national_dtl` VALUES (115, 'Montserrat Is', 'MS', '2020-02-09 17:26:34', '2020-02-09 17:26:34', 0);
INSERT INTO `national_dtl` VALUES (116, 'Malta', 'MT', '2020-02-09 17:26:34', '2020-02-09 17:26:34', 0);
INSERT INTO `national_dtl` VALUES (117, 'Mariana Is', 'null', '2020-02-09 17:26:34', '2020-02-09 17:26:34', 0);
INSERT INTO `national_dtl` VALUES (118, 'Martinique', 'null', '2020-02-09 17:26:34', '2020-02-09 17:26:34', 0);
INSERT INTO `national_dtl` VALUES (119, 'Mauritius', 'MU', '2020-02-09 17:26:34', '2020-02-09 17:26:34', 0);
INSERT INTO `national_dtl` VALUES (120, 'Maldives', 'MV', '2020-02-09 17:26:34', '2020-02-09 17:26:34', 0);
INSERT INTO `national_dtl` VALUES (121, 'Malawi', 'MW', '2020-02-09 17:26:34', '2020-02-09 17:26:34', 0);
INSERT INTO `national_dtl` VALUES (122, 'Mexico', 'MX', '2020-02-09 17:26:34', '2020-02-09 17:26:34', 0);
INSERT INTO `national_dtl` VALUES (123, 'Malaysia', 'MY', '2020-02-09 17:26:34', '2020-02-09 17:26:34', 0);
INSERT INTO `national_dtl` VALUES (124, 'Mozambique', 'MZ', '2020-02-09 17:26:34', '2020-02-09 17:26:34', 0);
INSERT INTO `national_dtl` VALUES (125, 'Namibia', 'NA', '2020-02-09 17:32:38', '2020-02-09 17:32:38', 0);
INSERT INTO `national_dtl` VALUES (126, 'Niger', 'NE', '2020-02-09 17:32:38', '2020-02-09 17:32:38', 0);
INSERT INTO `national_dtl` VALUES (127, 'Nigeria', 'NG', '2020-02-09 17:32:38', '2020-02-09 17:32:38', 0);
INSERT INTO `national_dtl` VALUES (128, 'Nicaragua', 'NI', '2020-02-09 17:32:38', '2020-02-09 17:32:38', 0);
INSERT INTO `national_dtl` VALUES (129, 'Netherlands', 'NL', '2020-02-09 17:32:38', '2020-02-09 17:32:38', 0);
INSERT INTO `national_dtl` VALUES (130, 'Norway', 'NO', '2020-02-09 17:32:38', '2020-02-09 17:32:38', 0);
INSERT INTO `national_dtl` VALUES (131, 'Nepal', 'NP', '2020-02-09 17:32:38', '2020-02-09 17:32:38', 0);
INSERT INTO `national_dtl` VALUES (132, 'Netherlands Antilles', 'null', '2020-02-09 17:32:38', '2020-02-09 17:32:38', 0);
INSERT INTO `national_dtl` VALUES (133, 'Nauru', 'NR', '2020-02-09 17:32:38', '2020-02-09 17:32:38', 0);
INSERT INTO `national_dtl` VALUES (134, 'New Zealand', 'NZ', '2020-02-09 17:32:38', '2020-02-09 17:32:38', 0);
INSERT INTO `national_dtl` VALUES (135, 'Oman', 'OM', '2020-02-09 17:32:38', '2020-02-09 17:32:38', 0);
INSERT INTO `national_dtl` VALUES (136, 'Panama', 'PA', '2020-02-09 17:32:38', '2020-02-09 17:32:38', 0);
INSERT INTO `national_dtl` VALUES (137, 'Peru', 'PE', '2020-02-09 17:32:38', '2020-02-09 17:32:38', 0);
INSERT INTO `national_dtl` VALUES (138, 'French Polynesia', 'PF', '2020-02-09 17:32:38', '2020-02-09 17:32:38', 0);
INSERT INTO `national_dtl` VALUES (139, 'Papua New Cuinea', 'PG', '2020-02-09 17:32:38', '2020-02-09 17:32:38', 0);
INSERT INTO `national_dtl` VALUES (140, 'Philippines', 'PH', '2020-02-09 17:32:38', '2020-02-09 17:32:38', 0);
INSERT INTO `national_dtl` VALUES (141, 'Pakistan', 'PK', '2020-02-09 17:32:38', '2020-02-09 17:32:38', 0);
INSERT INTO `national_dtl` VALUES (142, 'Poland', 'PL', '2020-02-09 17:32:38', '2020-02-09 17:32:38', 0);
INSERT INTO `national_dtl` VALUES (143, 'Puerto Rico', 'PR', '2020-02-09 17:32:38', '2020-02-09 17:32:38', 0);
INSERT INTO `national_dtl` VALUES (144, 'Portugal', 'PT', '2020-02-09 17:32:38', '2020-02-09 17:32:38', 0);
INSERT INTO `national_dtl` VALUES (145, 'Paraguay', 'PY', '2020-02-09 17:32:38', '2020-02-09 17:32:38', 0);
INSERT INTO `national_dtl` VALUES (146, 'Qatar', 'QA', '2020-02-09 17:41:41', '2020-02-09 17:41:41', 0);
INSERT INTO `national_dtl` VALUES (147, 'Reunion', 'null', '2020-02-09 17:41:41', '2020-02-09 17:41:41', 0);
INSERT INTO `national_dtl` VALUES (148, 'Romania', 'RO', '2020-02-09 17:41:41', '2020-02-09 17:41:41', 0);
INSERT INTO `national_dtl` VALUES (149, 'Russia', 'RU', '2020-02-09 17:41:41', '2020-02-09 17:41:41', 0);
INSERT INTO `national_dtl` VALUES (150, 'Saudi Arabia', 'SA', '2020-02-09 17:41:41', '2020-02-09 17:41:41', 0);
INSERT INTO `national_dtl` VALUES (151, 'Solomon Is', 'SB', '2020-02-09 17:41:41', '2020-02-09 17:41:41', 0);
INSERT INTO `national_dtl` VALUES (152, 'Seychelles', 'SC', '2020-02-09 17:41:41', '2020-02-09 17:41:41', 0);
INSERT INTO `national_dtl` VALUES (153, 'Sudan', 'SD', '2020-02-09 17:41:41', '2020-02-09 17:41:41', 0);
INSERT INTO `national_dtl` VALUES (154, 'Sweden', 'SE', '2020-02-09 17:41:41', '2020-02-09 17:41:41', 0);
INSERT INTO `national_dtl` VALUES (155, 'Singapore', 'SG', '2020-02-09 17:41:41', '2020-02-09 17:41:41', 0);
INSERT INTO `national_dtl` VALUES (156, 'Slovenia', 'SI', '2020-02-09 17:41:41', '2020-02-09 17:41:41', 0);
INSERT INTO `national_dtl` VALUES (157, 'Slovakia', 'SK', '2020-02-09 17:41:41', '2020-02-09 17:41:41', 0);
INSERT INTO `national_dtl` VALUES (158, 'Sierra Leone', 'SL', '2020-02-09 17:41:41', '2020-02-09 17:41:41', 0);
INSERT INTO `national_dtl` VALUES (159, 'San Marion', 'SM', '2020-02-09 17:41:41', '2020-02-09 17:41:41', 0);
INSERT INTO `national_dtl` VALUES (160, 'Samoa Eastern', 'null', '2020-02-09 17:41:41', '2020-02-09 17:41:41', 0);
INSERT INTO `national_dtl` VALUES (161, 'San Marion', 'null', '2020-02-09 17:41:41', '2020-02-09 17:41:41', 0);
INSERT INTO `national_dtl` VALUES (162, 'Senegal', 'SN', '2020-02-09 17:41:41', '2020-02-09 17:41:41', 0);
INSERT INTO `national_dtl` VALUES (163, 'Somali', 'SO', '2020-02-09 17:41:41', '2020-02-09 17:41:41', 0);
INSERT INTO `national_dtl` VALUES (164, 'Suriname', 'SR', '2020-02-09 17:41:41', '2020-02-09 17:41:41', 0);
INSERT INTO `national_dtl` VALUES (165, 'Sao Tome and Principe', 'ST', '2020-02-09 17:41:41', '2020-02-09 17:41:41', 0);
INSERT INTO `national_dtl` VALUES (166, 'EI Salvador', 'SV', '2020-02-09 17:41:41', '2020-02-09 17:41:41', 0);
INSERT INTO `national_dtl` VALUES (167, 'Syria', 'SY', '2020-02-09 17:41:41', '2020-02-09 17:41:41', 0);
INSERT INTO `national_dtl` VALUES (168, 'Swaziland', 'SZ', '2020-02-09 17:41:41', '2020-02-09 17:41:41', 0);
INSERT INTO `national_dtl` VALUES (169, 'Chad', 'TD', '2020-02-09 17:47:40', '2020-02-09 17:47:40', 0);
INSERT INTO `national_dtl` VALUES (170, 'Togo', 'TG', '2020-02-09 17:47:40', '2020-02-09 17:47:40', 0);
INSERT INTO `national_dtl` VALUES (171, 'Thailand', 'TH', '2020-02-09 17:47:40', '2020-02-09 17:47:40', 0);
INSERT INTO `national_dtl` VALUES (172, 'Tajikistan', 'TJ', '2020-02-09 17:47:40', '2020-02-09 17:47:40', 0);
INSERT INTO `national_dtl` VALUES (173, 'Turkmenistan', 'TM', '2020-02-09 17:47:40', '2020-02-09 17:47:40', 0);
INSERT INTO `national_dtl` VALUES (174, 'Tunisia', 'TN', '2020-02-09 17:47:40', '2020-02-09 17:47:40', 0);
INSERT INTO `national_dtl` VALUES (175, 'Tonga', 'TO', '2020-02-09 17:47:40', '2020-02-09 17:47:40', 0);
INSERT INTO `national_dtl` VALUES (176, 'Turkey', 'TR', '2020-02-09 17:47:40', '2020-02-09 17:47:40', 0);
INSERT INTO `national_dtl` VALUES (177, 'Trinidad and Tobago', 'TT', '2020-02-09 17:47:40', '2020-02-09 17:47:40', 0);
INSERT INTO `national_dtl` VALUES (178, 'Taiwan', 'TW', '2020-02-09 17:47:40', '2020-02-09 17:47:40', 0);
INSERT INTO `national_dtl` VALUES (179, 'Tanzania', 'TZ', '2020-02-09 17:47:40', '2020-02-09 17:47:40', 0);
INSERT INTO `national_dtl` VALUES (180, 'Ukraine', 'UA', '2020-02-09 17:47:40', '2020-02-09 17:47:40', 0);
INSERT INTO `national_dtl` VALUES (181, 'Uganda', 'UG', '2020-02-09 17:47:40', '2020-02-09 17:47:40', 0);
INSERT INTO `national_dtl` VALUES (182, 'United States of America', 'US', '2020-02-09 17:47:40', '2020-02-09 17:47:40', 0);
INSERT INTO `national_dtl` VALUES (183, 'Uruguay', 'UY', '2020-02-09 17:47:40', '2020-02-09 17:47:40', 0);
INSERT INTO `national_dtl` VALUES (184, 'Uzbekistan', 'UZ', '2020-02-09 17:47:40', '2020-02-09 17:47:40', 0);
INSERT INTO `national_dtl` VALUES (185, 'Saint Vincent', 'VC', '2020-02-09 17:50:08', '2020-02-09 17:50:08', 0);
INSERT INTO `national_dtl` VALUES (186, 'Venezuela', 'VE', '2020-02-09 17:50:08', '2020-02-09 17:50:08', 0);
INSERT INTO `national_dtl` VALUES (187, 'Vietnam', 'VN', '2020-02-09 17:50:08', '2020-02-09 17:50:08', 0);
INSERT INTO `national_dtl` VALUES (188, 'Yemen', 'YE', '2020-02-09 17:50:08', '2020-02-09 17:50:08', 0);
INSERT INTO `national_dtl` VALUES (189, 'Yugoslavia', 'YU', '2020-02-09 17:50:08', '2020-02-09 17:50:08', 0);
INSERT INTO `national_dtl` VALUES (190, 'South Africa', 'ZA', '2020-02-09 17:50:08', '2020-02-09 17:50:08', 0);
INSERT INTO `national_dtl` VALUES (191, 'Zambia', 'ZM', '2020-02-09 17:50:08', '2020-02-09 17:50:08', 0);
INSERT INTO `national_dtl` VALUES (192, 'Zaire', 'ZR', '2020-02-09 17:50:08', '2020-02-09 17:50:08', 0);
INSERT INTO `national_dtl` VALUES (193, 'Zimbabwe', 'ZW', '2020-02-09 17:50:08', '2020-02-09 17:50:08', 0);
COMMIT;

-- ----------------------------
-- Table structure for province_dtl
-- ----------------------------
DROP TABLE IF EXISTS `province_dtl`;
CREATE TABLE `province_dtl` (
  `province_dtl_id` int NOT NULL AUTO_INCREMENT,
  `province_dtl_name` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_delete` tinyint DEFAULT '0',
  `national_dtl_id` int DEFAULT NULL,
  PRIMARY KEY (`province_dtl_id`),
  KEY `national_dtl_id` (`national_dtl_id`),
  CONSTRAINT `national_dtl_id` FOREIGN KEY (`national_dtl_id`) REFERENCES `national_dtl` (`national_dtl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_desc` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_delete` tinyint DEFAULT '0',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (1, 'admin', '2020-02-05 10:32:01', '2020-02-05 10:32:01', 0);
INSERT INTO `role` VALUES (2, 'Student', '2020-02-09 16:47:52', '2020-02-09 16:47:52', 0);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_password` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_delete` tinyint DEFAULT '0',
  `role_id` int DEFAULT NULL,
  `user_dtl_id` int DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  KEY `role_id` (`role_id`),
  KEY `user_dtl_id` (`user_dtl_id`),
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `user_dtl_id` FOREIGN KEY (`user_dtl_id`) REFERENCES `user_dtl` (`user_dtl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for user_dtl
-- ----------------------------
DROP TABLE IF EXISTS `user_dtl`;
CREATE TABLE `user_dtl` (
  `user_dtl_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_delete` tinyint DEFAULT '0',
  `user_id` int DEFAULT NULL,
  `city_dtl_id` int DEFAULT NULL,
  PRIMARY KEY (`user_dtl_id`),
  KEY `user_id` (`user_id`),
  KEY `city_dtl_id` (`city_dtl_id`),
  CONSTRAINT `city_dtl_id` FOREIGN KEY (`city_dtl_id`) REFERENCES `city_dtl` (`city_dtl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;

```

