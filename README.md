# FreeSeed



>   FreeSeed是一款现代化的，独立的，学生管理系统。

<p align="center">
    <a href = "https://docs.oracle.com/javase/8/docs/"><img src="https://badgen.net/badge/JDK/1.8/yellow"></a>
    <a href = "https://github.com/Allwayz/FreeSeed"><img src="https://badgen.net/github/forks/Allwayz/FreeSeed"></a>
    <a href = "https://github.com/Allwayz/FreeSeed/issues"><img src="https://badgen.net/github/issues/Allwayz/FreeSeed"></a>
	<a href = "https://github.com/Allwayz/FreeSeed/releases"><img src="https://badgen.net/github/release/Allwayz/FreeSeed"></a>
    <a href = "https://github.com/Allwayz/FreeSeed"><img src="https://badgen.net/github/commits/Allwayz/FreeSeed"></a>
    <img src="https://badgen.net/github/last-commit/Allwayz/FreeSeed/master">
	<img src="https://badgen.net/github/license/Allwayz/FreeSeed">
</p>
------

[TOC]

### 简介

**FreeSeed是一款现代化的，独立的，学生管理系统。**
[websiteDemo](https://allwayz.github.io/FreeSeedDemo)

>   [官网](https://allwayz.github.io/) | 社区 | [Email](2584491610@qq.com) | Telegram




### FreeSeed Request Method
| 实验功能                             | 请求URI | 请求方式 |
| ------------------------------------ | ------- | -------- |
| Select ALL                       | emps    | GET      |
| Select One(pass to Edit Page)           | emp/1   | GET      |
| pass to add Page                         | emp     | GET      |
| Add                              | emp     | POST     |
| pass to Edit Page | emp/1   | GET      |
| update                             | emp     | PUT      |
| delete                             | emp/1   | DELETE   |

### 接口文档
|web interface | Param | Return | Method|
|--------------|-------|-------|--------|
|roleList|null|JSON|get|
|cityList|null|JSON|get|
|addRole|role_desc|void|post|
|addUser|email,password,role|void|post|



------

### 数据库文件！本地 `mysql` 

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

 Date: 16/02/2020 04:59:15
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
) ENGINE=InnoDB AUTO_INCREMENT=435 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of city_dtl
-- ----------------------------
BEGIN;
INSERT INTO `city_dtl` VALUES (1, '东城区', '2020-02-13 13:22:23', '2020-02-13 13:22:23', 0, 1);
INSERT INTO `city_dtl` VALUES (2, '西城区', '2020-02-13 13:22:23', '2020-02-13 13:22:23', 0, 1);
INSERT INTO `city_dtl` VALUES (3, '朝阳区', '2020-02-13 13:22:23', '2020-02-13 13:22:23', 0, 1);
INSERT INTO `city_dtl` VALUES (4, '丰台区', '2020-02-13 13:22:23', '2020-02-13 13:22:23', 0, 1);
INSERT INTO `city_dtl` VALUES (5, '石景山区', '2020-02-13 13:22:23', '2020-02-13 13:22:23', 0, 1);
INSERT INTO `city_dtl` VALUES (6, '海淀区', '2020-02-13 13:22:23', '2020-02-13 13:22:23', 0, 1);
INSERT INTO `city_dtl` VALUES (7, '门头沟区', '2020-02-13 13:22:23', '2020-02-13 13:22:23', 0, 1);
INSERT INTO `city_dtl` VALUES (8, '房山区', '2020-02-13 13:22:23', '2020-02-13 13:22:23', 0, 1);
INSERT INTO `city_dtl` VALUES (9, '通州区', '2020-02-13 13:22:23', '2020-02-13 13:22:23', 0, 1);
INSERT INTO `city_dtl` VALUES (10, '顺义区', '2020-02-13 13:22:23', '2020-02-13 13:22:23', 0, 1);
INSERT INTO `city_dtl` VALUES (11, '昌平区', '2020-02-13 13:22:23', '2020-02-13 13:22:23', 0, 1);
INSERT INTO `city_dtl` VALUES (12, '大兴区', '2020-02-13 13:22:23', '2020-02-13 13:22:23', 0, 1);
INSERT INTO `city_dtl` VALUES (13, '怀柔区', '2020-02-13 13:22:23', '2020-02-13 13:22:23', 0, 1);
INSERT INTO `city_dtl` VALUES (14, '平谷区', '2020-02-13 13:22:23', '2020-02-13 13:22:23', 0, 1);
INSERT INTO `city_dtl` VALUES (15, '密云区', '2020-02-13 13:22:23', '2020-02-13 13:22:23', 0, 1);
INSERT INTO `city_dtl` VALUES (16, '延庆区', '2020-02-13 13:22:23', '2020-02-13 13:22:23', 0, 1);
INSERT INTO `city_dtl` VALUES (17, '和平区', '2020-02-13 13:24:55', '2020-02-13 13:24:55', 0, 2);
INSERT INTO `city_dtl` VALUES (18, '河东区', '2020-02-13 13:24:55', '2020-02-13 13:24:55', 0, 2);
INSERT INTO `city_dtl` VALUES (19, '河西区', '2020-02-13 13:24:55', '2020-02-13 13:24:55', 0, 2);
INSERT INTO `city_dtl` VALUES (20, '南开区', '2020-02-13 13:24:55', '2020-02-13 13:24:55', 0, 2);
INSERT INTO `city_dtl` VALUES (21, '河北区', '2020-02-13 13:24:55', '2020-02-13 13:24:55', 0, 2);
INSERT INTO `city_dtl` VALUES (22, '红桥区', '2020-02-13 13:24:55', '2020-02-13 13:24:55', 0, 2);
INSERT INTO `city_dtl` VALUES (23, '东丽区', '2020-02-13 13:24:55', '2020-02-13 13:24:55', 0, 2);
INSERT INTO `city_dtl` VALUES (24, '西青区', '2020-02-13 13:24:55', '2020-02-13 13:24:55', 0, 2);
INSERT INTO `city_dtl` VALUES (25, '津南区', '2020-02-13 13:24:55', '2020-02-13 13:24:55', 0, 2);
INSERT INTO `city_dtl` VALUES (26, '北辰区', '2020-02-13 13:24:55', '2020-02-13 13:24:55', 0, 2);
INSERT INTO `city_dtl` VALUES (27, '武清区', '2020-02-13 13:24:55', '2020-02-13 13:24:55', 0, 2);
INSERT INTO `city_dtl` VALUES (28, '宝坻区', '2020-02-13 13:24:55', '2020-02-13 13:24:55', 0, 2);
INSERT INTO `city_dtl` VALUES (29, '滨海新区', '2020-02-13 13:24:55', '2020-02-13 13:24:55', 0, 2);
INSERT INTO `city_dtl` VALUES (30, '宁河区', '2020-02-13 13:24:55', '2020-02-13 13:24:55', 0, 2);
INSERT INTO `city_dtl` VALUES (31, '静海区', '2020-02-13 13:24:55', '2020-02-13 13:24:55', 0, 2);
INSERT INTO `city_dtl` VALUES (32, '蓟州区', '2020-02-13 13:24:55', '2020-02-13 13:24:55', 0, 2);
INSERT INTO `city_dtl` VALUES (33, '石家庄', '2020-02-13 13:26:27', '2020-02-13 13:26:27', 0, 3);
INSERT INTO `city_dtl` VALUES (34, '唐山', '2020-02-13 13:26:27', '2020-02-13 13:26:27', 0, 3);
INSERT INTO `city_dtl` VALUES (35, '秦皇岛', '2020-02-13 13:26:27', '2020-02-13 13:26:27', 0, 3);
INSERT INTO `city_dtl` VALUES (36, '邯郸', '2020-02-13 13:26:27', '2020-02-13 13:26:27', 0, 3);
INSERT INTO `city_dtl` VALUES (37, '邢台', '2020-02-13 13:26:27', '2020-02-13 13:26:27', 0, 3);
INSERT INTO `city_dtl` VALUES (38, '保定', '2020-02-13 13:26:27', '2020-02-13 13:26:27', 0, 3);
INSERT INTO `city_dtl` VALUES (39, '张家口', '2020-02-13 13:26:27', '2020-02-13 13:26:27', 0, 3);
INSERT INTO `city_dtl` VALUES (40, '承德', '2020-02-13 13:26:27', '2020-02-13 13:26:27', 0, 3);
INSERT INTO `city_dtl` VALUES (41, '沧州', '2020-02-13 13:26:27', '2020-02-13 13:26:27', 0, 3);
INSERT INTO `city_dtl` VALUES (42, '廊坊', '2020-02-13 13:26:27', '2020-02-13 13:26:27', 0, 3);
INSERT INTO `city_dtl` VALUES (43, '衡水', '2020-02-13 13:26:27', '2020-02-13 13:26:27', 0, 3);
INSERT INTO `city_dtl` VALUES (44, '太原', '2020-02-13 13:28:14', '2020-02-13 13:28:14', 0, 4);
INSERT INTO `city_dtl` VALUES (45, '大同', '2020-02-13 13:28:14', '2020-02-13 13:28:14', 0, 4);
INSERT INTO `city_dtl` VALUES (46, '阳泉', '2020-02-13 13:28:14', '2020-02-13 13:28:14', 0, 4);
INSERT INTO `city_dtl` VALUES (47, '长治', '2020-02-13 13:28:14', '2020-02-13 13:28:14', 0, 4);
INSERT INTO `city_dtl` VALUES (48, '晋城', '2020-02-13 13:28:14', '2020-02-13 13:28:14', 0, 4);
INSERT INTO `city_dtl` VALUES (49, '朔州', '2020-02-13 13:28:14', '2020-02-13 13:28:14', 0, 4);
INSERT INTO `city_dtl` VALUES (50, '晋中', '2020-02-13 13:28:14', '2020-02-13 13:28:14', 0, 4);
INSERT INTO `city_dtl` VALUES (51, '运城', '2020-02-13 13:28:14', '2020-02-13 13:28:14', 0, 4);
INSERT INTO `city_dtl` VALUES (52, '忻州', '2020-02-13 13:28:14', '2020-02-13 13:28:14', 0, 4);
INSERT INTO `city_dtl` VALUES (53, '临汾', '2020-02-13 13:28:14', '2020-02-13 13:28:14', 0, 4);
INSERT INTO `city_dtl` VALUES (54, '吕梁', '2020-02-13 13:28:14', '2020-02-13 13:28:14', 0, 4);
INSERT INTO `city_dtl` VALUES (55, '呼和浩特', '2020-02-13 13:30:09', '2020-02-13 13:30:09', 0, 5);
INSERT INTO `city_dtl` VALUES (56, '包头', '2020-02-13 13:30:09', '2020-02-13 13:30:09', 0, 5);
INSERT INTO `city_dtl` VALUES (57, '乌海', '2020-02-13 13:30:09', '2020-02-13 13:30:09', 0, 5);
INSERT INTO `city_dtl` VALUES (58, '赤峰', '2020-02-13 13:30:09', '2020-02-13 13:30:09', 0, 5);
INSERT INTO `city_dtl` VALUES (59, '通辽', '2020-02-13 13:30:09', '2020-02-13 13:30:09', 0, 5);
INSERT INTO `city_dtl` VALUES (60, '鄂尔多斯', '2020-02-13 13:30:09', '2020-02-13 13:30:09', 0, 5);
INSERT INTO `city_dtl` VALUES (61, '呼伦贝尔', '2020-02-13 13:30:09', '2020-02-13 13:30:09', 0, 5);
INSERT INTO `city_dtl` VALUES (62, '巴彦淖尔', '2020-02-13 13:30:09', '2020-02-13 13:30:09', 0, 5);
INSERT INTO `city_dtl` VALUES (63, '乌兰察布', '2020-02-13 13:30:09', '2020-02-13 13:30:09', 0, 5);
INSERT INTO `city_dtl` VALUES (64, '兴安盟', '2020-02-13 13:30:09', '2020-02-13 13:30:09', 0, 5);
INSERT INTO `city_dtl` VALUES (65, '锡林郭勒盟', '2020-02-13 13:30:09', '2020-02-13 13:30:09', 0, 5);
INSERT INTO `city_dtl` VALUES (66, '阿拉善盟', '2020-02-13 13:30:09', '2020-02-13 13:30:09', 0, 5);
INSERT INTO `city_dtl` VALUES (67, '沈阳', '2020-02-13 13:31:38', '2020-02-13 13:31:38', 0, 6);
INSERT INTO `city_dtl` VALUES (68, '大连', '2020-02-13 13:31:38', '2020-02-13 13:31:38', 0, 6);
INSERT INTO `city_dtl` VALUES (69, '鞍山', '2020-02-13 13:31:38', '2020-02-13 13:31:38', 0, 6);
INSERT INTO `city_dtl` VALUES (70, '抚顺', '2020-02-13 13:31:38', '2020-02-13 13:31:38', 0, 6);
INSERT INTO `city_dtl` VALUES (71, '本溪', '2020-02-13 13:31:38', '2020-02-13 13:31:38', 0, 6);
INSERT INTO `city_dtl` VALUES (72, '丹东', '2020-02-13 13:31:38', '2020-02-13 13:31:38', 0, 6);
INSERT INTO `city_dtl` VALUES (73, '锦州', '2020-02-13 13:31:38', '2020-02-13 13:31:38', 0, 6);
INSERT INTO `city_dtl` VALUES (74, '营口', '2020-02-13 13:31:38', '2020-02-13 13:31:38', 0, 6);
INSERT INTO `city_dtl` VALUES (75, '阜新', '2020-02-13 13:31:38', '2020-02-13 13:31:38', 0, 6);
INSERT INTO `city_dtl` VALUES (76, '盘锦', '2020-02-13 13:31:38', '2020-02-13 13:31:38', 0, 6);
INSERT INTO `city_dtl` VALUES (77, '铁岭', '2020-02-13 13:31:38', '2020-02-13 13:31:38', 0, 6);
INSERT INTO `city_dtl` VALUES (78, '朝阳', '2020-02-13 13:31:38', '2020-02-13 13:31:38', 0, 6);
INSERT INTO `city_dtl` VALUES (79, '葫芦岛', '2020-02-13 13:31:38', '2020-02-13 13:31:38', 0, 6);
INSERT INTO `city_dtl` VALUES (80, '长春', '2020-02-13 13:32:37', '2020-02-13 13:32:37', 0, 7);
INSERT INTO `city_dtl` VALUES (81, '吉林', '2020-02-13 13:32:37', '2020-02-13 13:32:37', 0, 7);
INSERT INTO `city_dtl` VALUES (82, '四平', '2020-02-13 13:32:37', '2020-02-13 13:32:37', 0, 7);
INSERT INTO `city_dtl` VALUES (83, '辽源', '2020-02-13 13:32:37', '2020-02-13 13:32:37', 0, 7);
INSERT INTO `city_dtl` VALUES (84, '通化', '2020-02-13 13:32:37', '2020-02-13 13:32:37', 0, 7);
INSERT INTO `city_dtl` VALUES (85, '白山', '2020-02-13 13:32:37', '2020-02-13 13:32:37', 0, 7);
INSERT INTO `city_dtl` VALUES (86, '松原', '2020-02-13 13:32:37', '2020-02-13 13:32:37', 0, 7);
INSERT INTO `city_dtl` VALUES (87, '白城', '2020-02-13 13:32:37', '2020-02-13 13:32:37', 0, 7);
INSERT INTO `city_dtl` VALUES (88, '延边朝鲜自自治州', '2020-02-13 13:32:37', '2020-02-13 13:32:37', 0, 7);
INSERT INTO `city_dtl` VALUES (89, '哈尔滨', '2020-02-13 13:34:04', '2020-02-13 13:34:04', 0, 8);
INSERT INTO `city_dtl` VALUES (90, '齐齐哈尔', '2020-02-13 13:34:04', '2020-02-13 13:34:04', 0, 8);
INSERT INTO `city_dtl` VALUES (91, '鸡西', '2020-02-13 13:34:04', '2020-02-13 13:34:04', 0, 8);
INSERT INTO `city_dtl` VALUES (92, '鹤岗', '2020-02-13 13:34:04', '2020-02-13 13:34:04', 0, 8);
INSERT INTO `city_dtl` VALUES (93, '双鸭山', '2020-02-13 13:34:04', '2020-02-13 13:34:04', 0, 8);
INSERT INTO `city_dtl` VALUES (94, '大庆', '2020-02-13 13:34:04', '2020-02-13 13:34:04', 0, 8);
INSERT INTO `city_dtl` VALUES (95, '尹春', '2020-02-13 13:34:04', '2020-02-13 13:34:04', 0, 8);
INSERT INTO `city_dtl` VALUES (96, '佳木斯', '2020-02-13 13:34:04', '2020-02-13 13:34:04', 0, 8);
INSERT INTO `city_dtl` VALUES (97, '七台河', '2020-02-13 13:34:04', '2020-02-13 13:34:04', 0, 8);
INSERT INTO `city_dtl` VALUES (98, '牡丹江', '2020-02-13 13:34:04', '2020-02-13 13:34:04', 0, 8);
INSERT INTO `city_dtl` VALUES (99, '黑河', '2020-02-13 13:34:04', '2020-02-13 13:34:04', 0, 8);
INSERT INTO `city_dtl` VALUES (100, '绥化', '2020-02-13 13:34:04', '2020-02-13 13:34:04', 0, 8);
INSERT INTO `city_dtl` VALUES (101, '大兴安岭地区', '2020-02-13 13:34:04', '2020-02-13 13:34:04', 0, 8);
INSERT INTO `city_dtl` VALUES (102, '黄浦区', '2020-02-13 13:35:40', '2020-02-13 13:35:40', 0, 9);
INSERT INTO `city_dtl` VALUES (103, '徐汇区', '2020-02-13 13:35:40', '2020-02-13 13:35:40', 0, 9);
INSERT INTO `city_dtl` VALUES (104, '长宁区', '2020-02-13 13:35:40', '2020-02-13 13:35:40', 0, 9);
INSERT INTO `city_dtl` VALUES (105, '静安区', '2020-02-13 13:35:40', '2020-02-13 13:35:40', 0, 9);
INSERT INTO `city_dtl` VALUES (106, '普陀区', '2020-02-13 13:35:40', '2020-02-13 13:35:40', 0, 9);
INSERT INTO `city_dtl` VALUES (107, '虹口区', '2020-02-13 13:35:40', '2020-02-13 13:35:40', 0, 9);
INSERT INTO `city_dtl` VALUES (108, '杨浦区', '2020-02-13 13:35:40', '2020-02-13 13:35:40', 0, 9);
INSERT INTO `city_dtl` VALUES (109, '闵行区', '2020-02-13 13:35:40', '2020-02-13 13:35:40', 0, 9);
INSERT INTO `city_dtl` VALUES (110, '宝山区', '2020-02-13 13:35:40', '2020-02-13 13:35:40', 0, 9);
INSERT INTO `city_dtl` VALUES (111, '嘉定区', '2020-02-13 13:35:40', '2020-02-13 13:35:40', 0, 9);
INSERT INTO `city_dtl` VALUES (112, '浦东新区', '2020-02-13 13:35:40', '2020-02-13 13:35:40', 0, 9);
INSERT INTO `city_dtl` VALUES (113, '金山区', '2020-02-13 13:35:40', '2020-02-13 13:35:40', 0, 9);
INSERT INTO `city_dtl` VALUES (114, '松江区', '2020-02-13 13:35:40', '2020-02-13 13:35:40', 0, 9);
INSERT INTO `city_dtl` VALUES (115, '青浦区', '2020-02-13 13:35:40', '2020-02-13 13:35:40', 0, 9);
INSERT INTO `city_dtl` VALUES (116, '奉贤区', '2020-02-13 13:35:40', '2020-02-13 13:35:40', 0, 9);
INSERT INTO `city_dtl` VALUES (117, '崇明区', '2020-02-13 13:35:40', '2020-02-13 13:35:40', 0, 9);
INSERT INTO `city_dtl` VALUES (118, '南京', '2020-02-13 13:37:01', '2020-02-13 13:37:01', 0, 10);
INSERT INTO `city_dtl` VALUES (119, '无锡', '2020-02-13 13:37:01', '2020-02-13 13:37:01', 0, 10);
INSERT INTO `city_dtl` VALUES (120, '徐州', '2020-02-13 13:37:01', '2020-02-13 13:37:01', 0, 10);
INSERT INTO `city_dtl` VALUES (121, '常州', '2020-02-13 13:37:01', '2020-02-13 13:37:01', 0, 10);
INSERT INTO `city_dtl` VALUES (122, '苏州', '2020-02-13 13:37:01', '2020-02-13 13:37:01', 0, 10);
INSERT INTO `city_dtl` VALUES (123, '南通', '2020-02-13 13:37:01', '2020-02-13 13:37:01', 0, 10);
INSERT INTO `city_dtl` VALUES (124, '连云港', '2020-02-13 13:37:01', '2020-02-13 13:37:01', 0, 10);
INSERT INTO `city_dtl` VALUES (125, '淮安', '2020-02-13 13:37:01', '2020-02-13 13:37:01', 0, 10);
INSERT INTO `city_dtl` VALUES (126, '盐城', '2020-02-13 13:37:01', '2020-02-13 13:37:01', 0, 10);
INSERT INTO `city_dtl` VALUES (127, '扬州', '2020-02-13 13:37:01', '2020-02-13 13:37:01', 0, 10);
INSERT INTO `city_dtl` VALUES (128, '镇江', '2020-02-13 13:37:01', '2020-02-13 13:37:01', 0, 10);
INSERT INTO `city_dtl` VALUES (129, '泰州', '2020-02-13 13:37:01', '2020-02-13 13:37:01', 0, 10);
INSERT INTO `city_dtl` VALUES (130, '宿迁', '2020-02-13 13:37:01', '2020-02-13 13:37:01', 0, 10);
INSERT INTO `city_dtl` VALUES (131, '杭州', '2020-02-13 13:37:52', '2020-02-13 13:37:52', 0, 11);
INSERT INTO `city_dtl` VALUES (132, '宁波', '2020-02-13 13:37:52', '2020-02-13 13:37:52', 0, 11);
INSERT INTO `city_dtl` VALUES (133, '温州', '2020-02-13 13:37:52', '2020-02-13 13:37:52', 0, 11);
INSERT INTO `city_dtl` VALUES (134, '嘉兴', '2020-02-13 13:37:52', '2020-02-13 13:37:52', 0, 11);
INSERT INTO `city_dtl` VALUES (135, '湖州', '2020-02-13 13:37:52', '2020-02-13 13:37:52', 0, 11);
INSERT INTO `city_dtl` VALUES (136, '绍兴', '2020-02-13 13:37:52', '2020-02-13 13:37:52', 0, 11);
INSERT INTO `city_dtl` VALUES (137, '金华', '2020-02-13 13:37:52', '2020-02-13 13:37:52', 0, 11);
INSERT INTO `city_dtl` VALUES (138, '衢州', '2020-02-13 13:37:52', '2020-02-13 13:37:52', 0, 11);
INSERT INTO `city_dtl` VALUES (139, '舟山', '2020-02-13 13:37:52', '2020-02-13 13:37:52', 0, 11);
INSERT INTO `city_dtl` VALUES (140, '台州', '2020-02-13 13:37:52', '2020-02-13 13:37:52', 0, 11);
INSERT INTO `city_dtl` VALUES (141, '丽水', '2020-02-13 13:37:52', '2020-02-13 13:37:52', 0, 11);
INSERT INTO `city_dtl` VALUES (142, '合肥', '2020-02-13 13:39:50', '2020-02-13 13:39:50', 0, 12);
INSERT INTO `city_dtl` VALUES (143, '芜湖', '2020-02-13 13:39:50', '2020-02-13 13:39:50', 0, 12);
INSERT INTO `city_dtl` VALUES (144, '蚌埠', '2020-02-13 13:39:50', '2020-02-13 13:39:50', 0, 12);
INSERT INTO `city_dtl` VALUES (145, '淮南', '2020-02-13 13:39:50', '2020-02-13 13:39:50', 0, 12);
INSERT INTO `city_dtl` VALUES (146, '马鞍山', '2020-02-13 13:39:50', '2020-02-13 13:39:50', 0, 12);
INSERT INTO `city_dtl` VALUES (147, '淮北', '2020-02-13 13:39:50', '2020-02-13 13:39:50', 0, 12);
INSERT INTO `city_dtl` VALUES (148, '铜陵', '2020-02-13 13:39:50', '2020-02-13 13:39:50', 0, 12);
INSERT INTO `city_dtl` VALUES (149, '安庆', '2020-02-13 13:39:50', '2020-02-13 13:39:50', 0, 12);
INSERT INTO `city_dtl` VALUES (150, '黄山', '2020-02-13 13:39:50', '2020-02-13 13:39:50', 0, 12);
INSERT INTO `city_dtl` VALUES (151, '滁州', '2020-02-13 13:39:50', '2020-02-13 13:39:50', 0, 12);
INSERT INTO `city_dtl` VALUES (152, '阜阳', '2020-02-13 13:39:50', '2020-02-13 13:39:50', 0, 12);
INSERT INTO `city_dtl` VALUES (153, '六安', '2020-02-13 13:39:50', '2020-02-13 13:39:50', 0, 12);
INSERT INTO `city_dtl` VALUES (154, '濠州', '2020-02-13 13:39:50', '2020-02-13 13:39:50', 0, 12);
INSERT INTO `city_dtl` VALUES (155, '池州', '2020-02-13 13:39:50', '2020-02-13 13:39:50', 0, 12);
INSERT INTO `city_dtl` VALUES (156, '宣城', '2020-02-13 13:39:50', '2020-02-13 13:39:50', 0, 12);
INSERT INTO `city_dtl` VALUES (157, '福州', '2020-02-13 13:41:02', '2020-02-13 13:41:02', 0, 13);
INSERT INTO `city_dtl` VALUES (158, '厦门', '2020-02-13 13:41:02', '2020-02-13 13:41:02', 0, 13);
INSERT INTO `city_dtl` VALUES (159, '莆田', '2020-02-13 13:41:02', '2020-02-13 13:41:02', 0, 13);
INSERT INTO `city_dtl` VALUES (160, '三明', '2020-02-13 13:41:02', '2020-02-13 13:41:02', 0, 13);
INSERT INTO `city_dtl` VALUES (161, '泉州', '2020-02-13 13:41:02', '2020-02-13 13:41:02', 0, 13);
INSERT INTO `city_dtl` VALUES (162, '漳州', '2020-02-13 13:41:02', '2020-02-13 13:41:02', 0, 13);
INSERT INTO `city_dtl` VALUES (163, '南平', '2020-02-13 13:41:02', '2020-02-13 13:41:02', 0, 13);
INSERT INTO `city_dtl` VALUES (164, '龙岩', '2020-02-13 13:41:02', '2020-02-13 13:41:02', 0, 13);
INSERT INTO `city_dtl` VALUES (165, '宁德', '2020-02-13 13:41:02', '2020-02-13 13:41:02', 0, 13);
INSERT INTO `city_dtl` VALUES (166, '南昌', '2020-02-13 13:42:57', '2020-02-13 13:42:57', 0, 14);
INSERT INTO `city_dtl` VALUES (167, '景德镇', '2020-02-13 13:42:57', '2020-02-13 13:42:57', 0, 14);
INSERT INTO `city_dtl` VALUES (168, '萍乡', '2020-02-13 13:42:57', '2020-02-13 13:42:57', 0, 14);
INSERT INTO `city_dtl` VALUES (169, '九江', '2020-02-13 13:42:57', '2020-02-13 13:42:57', 0, 14);
INSERT INTO `city_dtl` VALUES (170, '新余', '2020-02-13 13:42:57', '2020-02-13 13:42:57', 0, 14);
INSERT INTO `city_dtl` VALUES (171, '鹰潭', '2020-02-13 13:42:57', '2020-02-13 13:42:57', 0, 14);
INSERT INTO `city_dtl` VALUES (172, '赣州', '2020-02-13 13:42:57', '2020-02-13 13:42:57', 0, 14);
INSERT INTO `city_dtl` VALUES (173, '吉安', '2020-02-13 13:42:57', '2020-02-13 13:42:57', 0, 14);
INSERT INTO `city_dtl` VALUES (174, '宜春', '2020-02-13 13:42:57', '2020-02-13 13:42:57', 0, 14);
INSERT INTO `city_dtl` VALUES (175, '芜州', '2020-02-13 13:42:57', '2020-02-13 13:42:57', 0, 14);
INSERT INTO `city_dtl` VALUES (176, '上饶', '2020-02-13 13:42:57', '2020-02-13 13:42:57', 0, 14);
INSERT INTO `city_dtl` VALUES (177, '济南', '2020-02-13 13:44:35', '2020-02-13 13:44:35', 0, 15);
INSERT INTO `city_dtl` VALUES (178, '青岛', '2020-02-13 13:44:35', '2020-02-13 13:44:35', 0, 15);
INSERT INTO `city_dtl` VALUES (179, '淄博', '2020-02-13 13:44:35', '2020-02-13 13:44:35', 0, 15);
INSERT INTO `city_dtl` VALUES (180, '枣庄', '2020-02-13 13:44:35', '2020-02-13 13:44:35', 0, 15);
INSERT INTO `city_dtl` VALUES (181, '东营', '2020-02-13 13:44:35', '2020-02-13 13:44:35', 0, 15);
INSERT INTO `city_dtl` VALUES (182, '烟台', '2020-02-13 13:44:35', '2020-02-13 13:44:35', 0, 15);
INSERT INTO `city_dtl` VALUES (183, '潍坊', '2020-02-13 13:44:35', '2020-02-13 13:44:35', 0, 15);
INSERT INTO `city_dtl` VALUES (184, '济宁', '2020-02-13 13:44:35', '2020-02-13 13:44:35', 0, 15);
INSERT INTO `city_dtl` VALUES (185, '泰安', '2020-02-13 13:44:35', '2020-02-13 13:44:35', 0, 15);
INSERT INTO `city_dtl` VALUES (186, '威海', '2020-02-13 13:44:35', '2020-02-13 13:44:35', 0, 15);
INSERT INTO `city_dtl` VALUES (187, '日照', '2020-02-13 13:44:35', '2020-02-13 13:44:35', 0, 15);
INSERT INTO `city_dtl` VALUES (188, '莱芜', '2020-02-13 13:44:35', '2020-02-13 13:44:35', 0, 15);
INSERT INTO `city_dtl` VALUES (189, '临沂', '2020-02-13 13:44:35', '2020-02-13 13:44:35', 0, 15);
INSERT INTO `city_dtl` VALUES (190, '德州', '2020-02-13 13:44:35', '2020-02-13 13:44:35', 0, 15);
INSERT INTO `city_dtl` VALUES (191, '聊城', '2020-02-13 13:44:35', '2020-02-13 13:44:35', 0, 15);
INSERT INTO `city_dtl` VALUES (192, '滨州', '2020-02-13 13:44:35', '2020-02-13 13:44:35', 0, 15);
INSERT INTO `city_dtl` VALUES (193, '菏泽', '2020-02-13 13:44:35', '2020-02-13 13:44:35', 0, 15);
INSERT INTO `city_dtl` VALUES (194, '郑州', '2020-02-13 13:46:41', '2020-02-13 13:46:41', 0, 16);
INSERT INTO `city_dtl` VALUES (195, '开封', '2020-02-13 13:46:41', '2020-02-13 13:46:41', 0, 16);
INSERT INTO `city_dtl` VALUES (196, '洛阳', '2020-02-13 13:46:41', '2020-02-13 13:46:41', 0, 16);
INSERT INTO `city_dtl` VALUES (197, '平等山', '2020-02-13 13:46:41', '2020-02-13 13:46:41', 0, 16);
INSERT INTO `city_dtl` VALUES (198, '安阳', '2020-02-13 13:46:41', '2020-02-13 13:46:41', 0, 16);
INSERT INTO `city_dtl` VALUES (199, '鹤壁', '2020-02-13 13:46:41', '2020-02-13 13:46:41', 0, 16);
INSERT INTO `city_dtl` VALUES (200, '新乡', '2020-02-13 13:46:41', '2020-02-13 13:46:41', 0, 16);
INSERT INTO `city_dtl` VALUES (201, '焦作', '2020-02-13 13:46:41', '2020-02-13 13:46:41', 0, 16);
INSERT INTO `city_dtl` VALUES (202, '濮阳', '2020-02-13 13:46:41', '2020-02-13 13:46:41', 0, 16);
INSERT INTO `city_dtl` VALUES (203, '许昌', '2020-02-13 13:46:41', '2020-02-13 13:46:41', 0, 16);
INSERT INTO `city_dtl` VALUES (204, '漯河', '2020-02-13 13:46:41', '2020-02-13 13:46:41', 0, 16);
INSERT INTO `city_dtl` VALUES (205, '三门峡', '2020-02-13 13:46:41', '2020-02-13 13:46:41', 0, 16);
INSERT INTO `city_dtl` VALUES (206, '南阳', '2020-02-13 13:46:41', '2020-02-13 13:46:41', 0, 16);
INSERT INTO `city_dtl` VALUES (207, '商丘', '2020-02-13 13:46:41', '2020-02-13 13:46:41', 0, 16);
INSERT INTO `city_dtl` VALUES (208, '信阳', '2020-02-13 13:46:41', '2020-02-13 13:46:41', 0, 16);
INSERT INTO `city_dtl` VALUES (209, '周口', '2020-02-13 13:46:41', '2020-02-13 13:46:41', 0, 16);
INSERT INTO `city_dtl` VALUES (210, '驻马店', '2020-02-13 13:46:41', '2020-02-13 13:46:41', 0, 16);
INSERT INTO `city_dtl` VALUES (211, '济源', '2020-02-13 13:46:41', '2020-02-13 13:46:41', 0, 16);
INSERT INTO `city_dtl` VALUES (212, '武汉', '2020-02-13 14:01:27', '2020-02-13 14:01:27', 0, 17);
INSERT INTO `city_dtl` VALUES (213, '黄石', '2020-02-13 14:01:27', '2020-02-13 14:01:27', 0, 17);
INSERT INTO `city_dtl` VALUES (214, '十堰', '2020-02-13 14:01:27', '2020-02-13 14:01:27', 0, 17);
INSERT INTO `city_dtl` VALUES (215, '宜昌', '2020-02-13 14:01:27', '2020-02-13 14:01:27', 0, 17);
INSERT INTO `city_dtl` VALUES (216, '襄阳', '2020-02-13 14:01:27', '2020-02-13 14:01:27', 0, 17);
INSERT INTO `city_dtl` VALUES (217, '鄂州', '2020-02-13 14:01:27', '2020-02-13 14:01:27', 0, 17);
INSERT INTO `city_dtl` VALUES (218, '孝感', '2020-02-13 14:01:27', '2020-02-13 14:01:27', 0, 17);
INSERT INTO `city_dtl` VALUES (219, '荆州', '2020-02-13 14:01:27', '2020-02-13 14:01:27', 0, 17);
INSERT INTO `city_dtl` VALUES (220, '黄冈', '2020-02-13 14:01:27', '2020-02-13 14:01:27', 0, 17);
INSERT INTO `city_dtl` VALUES (221, '咸宁', '2020-02-13 14:01:27', '2020-02-13 14:01:27', 0, 17);
INSERT INTO `city_dtl` VALUES (222, '随州', '2020-02-13 14:01:27', '2020-02-13 14:01:27', 0, 17);
INSERT INTO `city_dtl` VALUES (223, '恩施土家族苗族自治州', '2020-02-13 14:01:27', '2020-02-13 14:01:27', 0, 17);
INSERT INTO `city_dtl` VALUES (224, '仙桃', '2020-02-13 14:01:27', '2020-02-13 14:01:27', 0, 17);
INSERT INTO `city_dtl` VALUES (225, '潜江', '2020-02-13 14:01:27', '2020-02-13 14:01:27', 0, 17);
INSERT INTO `city_dtl` VALUES (226, '天门', '2020-02-13 14:01:27', '2020-02-13 14:01:27', 0, 17);
INSERT INTO `city_dtl` VALUES (227, '神农架林区', '2020-02-13 14:01:27', '2020-02-13 14:01:27', 0, 17);
INSERT INTO `city_dtl` VALUES (228, '长沙', '2020-02-13 14:03:20', '2020-02-13 14:03:20', 0, 18);
INSERT INTO `city_dtl` VALUES (229, '株洲', '2020-02-13 14:03:20', '2020-02-13 14:03:20', 0, 18);
INSERT INTO `city_dtl` VALUES (230, '湘潭', '2020-02-13 14:03:20', '2020-02-13 14:03:20', 0, 18);
INSERT INTO `city_dtl` VALUES (231, '衡阳', '2020-02-13 14:03:20', '2020-02-13 14:03:20', 0, 18);
INSERT INTO `city_dtl` VALUES (232, '邵阳', '2020-02-13 14:03:20', '2020-02-13 14:03:20', 0, 18);
INSERT INTO `city_dtl` VALUES (233, '岳阳', '2020-02-13 14:03:20', '2020-02-13 14:03:20', 0, 18);
INSERT INTO `city_dtl` VALUES (234, '常德', '2020-02-13 14:03:20', '2020-02-13 14:03:20', 0, 18);
INSERT INTO `city_dtl` VALUES (235, '张家界', '2020-02-13 14:03:20', '2020-02-13 14:03:20', 0, 18);
INSERT INTO `city_dtl` VALUES (236, '益阳', '2020-02-13 14:03:20', '2020-02-13 14:03:20', 0, 18);
INSERT INTO `city_dtl` VALUES (237, '郴州', '2020-02-13 14:03:20', '2020-02-13 14:03:20', 0, 18);
INSERT INTO `city_dtl` VALUES (238, '永州', '2020-02-13 14:03:20', '2020-02-13 14:03:20', 0, 18);
INSERT INTO `city_dtl` VALUES (239, '怀化', '2020-02-13 14:03:20', '2020-02-13 14:03:20', 0, 18);
INSERT INTO `city_dtl` VALUES (240, '娄底', '2020-02-13 14:03:20', '2020-02-13 14:03:20', 0, 18);
INSERT INTO `city_dtl` VALUES (241, '湘西土家族苗族自治州', '2020-02-13 14:03:20', '2020-02-13 14:03:20', 0, 18);
INSERT INTO `city_dtl` VALUES (242, '广州', '2020-02-13 14:05:11', '2020-02-13 14:05:11', 0, 19);
INSERT INTO `city_dtl` VALUES (243, '韶关', '2020-02-13 14:05:11', '2020-02-13 14:05:11', 0, 19);
INSERT INTO `city_dtl` VALUES (244, '深圳', '2020-02-13 14:05:11', '2020-02-13 14:05:11', 0, 19);
INSERT INTO `city_dtl` VALUES (245, '珠海', '2020-02-13 14:05:11', '2020-02-13 14:05:11', 0, 19);
INSERT INTO `city_dtl` VALUES (246, '汕头', '2020-02-13 14:05:11', '2020-02-13 14:05:11', 0, 19);
INSERT INTO `city_dtl` VALUES (247, '佛山', '2020-02-13 14:05:11', '2020-02-13 14:05:11', 0, 19);
INSERT INTO `city_dtl` VALUES (248, '江门', '2020-02-13 14:05:11', '2020-02-13 14:05:11', 0, 19);
INSERT INTO `city_dtl` VALUES (249, '湛江', '2020-02-13 14:05:11', '2020-02-13 14:05:11', 0, 19);
INSERT INTO `city_dtl` VALUES (250, '茂名', '2020-02-13 14:05:11', '2020-02-13 14:05:11', 0, 19);
INSERT INTO `city_dtl` VALUES (251, '肇庆', '2020-02-13 14:05:11', '2020-02-13 14:05:11', 0, 19);
INSERT INTO `city_dtl` VALUES (252, '惠州', '2020-02-13 14:05:11', '2020-02-13 14:05:11', 0, 19);
INSERT INTO `city_dtl` VALUES (253, '梅州', '2020-02-13 14:05:11', '2020-02-13 14:05:11', 0, 19);
INSERT INTO `city_dtl` VALUES (254, '汕尾', '2020-02-13 14:05:11', '2020-02-13 14:05:11', 0, 19);
INSERT INTO `city_dtl` VALUES (255, '河源', '2020-02-13 14:05:11', '2020-02-13 14:05:11', 0, 19);
INSERT INTO `city_dtl` VALUES (256, '阳江', '2020-02-13 14:05:11', '2020-02-13 14:05:11', 0, 19);
INSERT INTO `city_dtl` VALUES (257, '清远', '2020-02-13 14:05:11', '2020-02-13 14:05:11', 0, 19);
INSERT INTO `city_dtl` VALUES (258, '东莞', '2020-02-13 14:05:11', '2020-02-13 14:05:11', 0, 19);
INSERT INTO `city_dtl` VALUES (259, '中山', '2020-02-13 14:05:11', '2020-02-13 14:05:11', 0, 19);
INSERT INTO `city_dtl` VALUES (260, '潮州', '2020-02-13 14:05:11', '2020-02-13 14:05:11', 0, 19);
INSERT INTO `city_dtl` VALUES (261, '揭阳', '2020-02-13 14:05:11', '2020-02-13 14:05:11', 0, 19);
INSERT INTO `city_dtl` VALUES (262, '云浮', '2020-02-13 14:05:11', '2020-02-13 14:05:11', 0, 19);
INSERT INTO `city_dtl` VALUES (263, '南宁', '2020-02-13 14:06:33', '2020-02-13 14:06:33', 0, 20);
INSERT INTO `city_dtl` VALUES (264, '柳州', '2020-02-13 14:06:33', '2020-02-13 14:06:33', 0, 20);
INSERT INTO `city_dtl` VALUES (265, '桂林', '2020-02-13 14:06:33', '2020-02-13 14:06:33', 0, 20);
INSERT INTO `city_dtl` VALUES (266, '梧州', '2020-02-13 14:06:33', '2020-02-13 14:06:33', 0, 20);
INSERT INTO `city_dtl` VALUES (267, '北海', '2020-02-13 14:06:33', '2020-02-13 14:06:33', 0, 20);
INSERT INTO `city_dtl` VALUES (268, '防城港', '2020-02-13 14:06:33', '2020-02-13 14:06:33', 0, 20);
INSERT INTO `city_dtl` VALUES (269, '钦州', '2020-02-13 14:06:33', '2020-02-13 14:06:33', 0, 20);
INSERT INTO `city_dtl` VALUES (270, '贵港', '2020-02-13 14:06:33', '2020-02-13 14:06:33', 0, 20);
INSERT INTO `city_dtl` VALUES (271, '玉林', '2020-02-13 14:06:33', '2020-02-13 14:06:33', 0, 20);
INSERT INTO `city_dtl` VALUES (272, '百色', '2020-02-13 14:06:33', '2020-02-13 14:06:33', 0, 20);
INSERT INTO `city_dtl` VALUES (273, '贺州', '2020-02-13 14:06:33', '2020-02-13 14:06:33', 0, 20);
INSERT INTO `city_dtl` VALUES (274, '河池', '2020-02-13 14:06:33', '2020-02-13 14:06:33', 0, 20);
INSERT INTO `city_dtl` VALUES (275, '来宾', '2020-02-13 14:06:33', '2020-02-13 14:06:33', 0, 20);
INSERT INTO `city_dtl` VALUES (276, '崇左', '2020-02-13 14:06:33', '2020-02-13 14:06:33', 0, 20);
INSERT INTO `city_dtl` VALUES (277, '海口', '2020-02-13 14:08:37', '2020-02-13 14:08:37', 0, 21);
INSERT INTO `city_dtl` VALUES (278, '三亚', '2020-02-13 14:08:37', '2020-02-13 14:08:37', 0, 21);
INSERT INTO `city_dtl` VALUES (279, '三沙', '2020-02-13 14:08:37', '2020-02-13 14:08:37', 0, 21);
INSERT INTO `city_dtl` VALUES (280, '儋州', '2020-02-13 14:08:37', '2020-02-13 14:08:37', 0, 21);
INSERT INTO `city_dtl` VALUES (281, '五指山', '2020-02-13 14:08:37', '2020-02-13 14:08:37', 0, 21);
INSERT INTO `city_dtl` VALUES (282, '琼海', '2020-02-13 14:08:37', '2020-02-13 14:08:37', 0, 21);
INSERT INTO `city_dtl` VALUES (283, '文昌', '2020-02-13 14:08:37', '2020-02-13 14:08:37', 0, 21);
INSERT INTO `city_dtl` VALUES (284, '万宁', '2020-02-13 14:08:37', '2020-02-13 14:08:37', 0, 21);
INSERT INTO `city_dtl` VALUES (285, '东方', '2020-02-13 14:08:37', '2020-02-13 14:08:37', 0, 21);
INSERT INTO `city_dtl` VALUES (286, '安定县', '2020-02-13 14:08:37', '2020-02-13 14:08:37', 0, 21);
INSERT INTO `city_dtl` VALUES (287, '屯昌县', '2020-02-13 14:08:37', '2020-02-13 14:08:37', 0, 21);
INSERT INTO `city_dtl` VALUES (288, '澄迈县', '2020-02-13 14:08:37', '2020-02-13 14:08:37', 0, 21);
INSERT INTO `city_dtl` VALUES (289, '临高县', '2020-02-13 14:08:37', '2020-02-13 14:08:37', 0, 21);
INSERT INTO `city_dtl` VALUES (290, '白沙黎族自治县', '2020-02-13 14:08:37', '2020-02-13 14:08:37', 0, 21);
INSERT INTO `city_dtl` VALUES (291, '陵水黎族自治县', '2020-02-13 14:08:37', '2020-02-13 14:08:37', 0, 21);
INSERT INTO `city_dtl` VALUES (292, '保亭黎族苗族自治县', '2020-02-13 14:08:37', '2020-02-13 14:08:37', 0, 21);
INSERT INTO `city_dtl` VALUES (293, '琼中黎族苗族自治县', '2020-02-13 14:08:37', '2020-02-13 14:08:37', 0, 21);
INSERT INTO `city_dtl` VALUES (294, '万州区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (295, '涪陵区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (296, '渝中区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (297, '大渡口区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (298, '江北区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (299, '沙坪坝区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (300, '九龙坡区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (301, '南岸区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (302, '北碚区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (303, '綦江区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (304, '大足区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (305, '渝北区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (306, '巴南区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (307, '黔江区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (308, '长寿区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (309, '江津区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (310, '合川区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (311, '永川区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (312, '璧山区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (313, '铜梁区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (314, '潼南区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (315, '荣昌区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (316, '开州区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (317, '梁平区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (318, '武隆区', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (319, '城口县', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (320, '丰都县', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (321, '垫江县', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (322, '忠县', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (323, '奉节县', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (324, '巫山县', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (325, '巫溪县', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (326, '石柱土家族苗族自治县', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (327, '秀山土家族苗族自治县', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (328, '酉阳土家族苗族自治县', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (329, '彭水苗族土家族自治县', '2020-02-13 14:14:03', '2020-02-13 14:14:03', 0, 22);
INSERT INTO `city_dtl` VALUES (330, '成都', '2020-02-13 14:18:28', '2020-02-13 14:18:28', 0, 23);
INSERT INTO `city_dtl` VALUES (331, '自贡', '2020-02-13 14:18:28', '2020-02-13 14:18:28', 0, 23);
INSERT INTO `city_dtl` VALUES (332, '攀枝花', '2020-02-13 14:18:28', '2020-02-13 14:18:28', 0, 23);
INSERT INTO `city_dtl` VALUES (333, '泸州', '2020-02-13 14:18:28', '2020-02-13 14:18:28', 0, 23);
INSERT INTO `city_dtl` VALUES (334, '德阳', '2020-02-13 14:18:28', '2020-02-13 14:18:28', 0, 23);
INSERT INTO `city_dtl` VALUES (335, '绵阳', '2020-02-13 14:18:29', '2020-02-13 14:18:29', 0, 23);
INSERT INTO `city_dtl` VALUES (336, '广元', '2020-02-13 14:18:29', '2020-02-13 14:18:29', 0, 23);
INSERT INTO `city_dtl` VALUES (337, '遂宁', '2020-02-13 14:18:29', '2020-02-13 14:18:29', 0, 23);
INSERT INTO `city_dtl` VALUES (338, '内江', '2020-02-13 14:18:29', '2020-02-13 14:18:29', 0, 23);
INSERT INTO `city_dtl` VALUES (339, '乐山', '2020-02-13 14:18:29', '2020-02-13 14:18:29', 0, 23);
INSERT INTO `city_dtl` VALUES (340, '南充', '2020-02-13 14:18:29', '2020-02-13 14:18:29', 0, 23);
INSERT INTO `city_dtl` VALUES (341, '眉山', '2020-02-13 14:18:29', '2020-02-13 14:18:29', 0, 23);
INSERT INTO `city_dtl` VALUES (342, '宜宾', '2020-02-13 14:18:29', '2020-02-13 14:18:29', 0, 23);
INSERT INTO `city_dtl` VALUES (343, '广安', '2020-02-13 14:18:29', '2020-02-13 14:18:29', 0, 23);
INSERT INTO `city_dtl` VALUES (344, '达州', '2020-02-13 14:18:29', '2020-02-13 14:18:29', 0, 23);
INSERT INTO `city_dtl` VALUES (345, '雅安', '2020-02-13 14:18:29', '2020-02-13 14:18:29', 0, 23);
INSERT INTO `city_dtl` VALUES (346, '巴中', '2020-02-13 14:18:29', '2020-02-13 14:18:29', 0, 23);
INSERT INTO `city_dtl` VALUES (347, '资阳', '2020-02-13 14:18:29', '2020-02-13 14:18:29', 0, 23);
INSERT INTO `city_dtl` VALUES (348, '阿坝藏族羌族自治州', '2020-02-13 14:18:29', '2020-02-13 14:18:29', 0, 23);
INSERT INTO `city_dtl` VALUES (349, '甘孜藏族自治州', '2020-02-13 14:18:29', '2020-02-13 14:18:29', 0, 23);
INSERT INTO `city_dtl` VALUES (350, '凉山彝族自治州', '2020-02-13 14:18:29', '2020-02-13 14:18:29', 0, 23);
INSERT INTO `city_dtl` VALUES (351, '贵阳', '2020-02-13 14:19:39', '2020-02-13 14:19:39', 0, 24);
INSERT INTO `city_dtl` VALUES (352, '六盘水', '2020-02-13 14:19:39', '2020-02-13 14:19:39', 0, 24);
INSERT INTO `city_dtl` VALUES (353, '遵义', '2020-02-13 14:19:39', '2020-02-13 14:19:39', 0, 24);
INSERT INTO `city_dtl` VALUES (354, '安顺', '2020-02-13 14:19:39', '2020-02-13 14:19:39', 0, 24);
INSERT INTO `city_dtl` VALUES (355, '毕节', '2020-02-13 14:19:39', '2020-02-13 14:19:39', 0, 24);
INSERT INTO `city_dtl` VALUES (356, '铜仁', '2020-02-13 14:19:39', '2020-02-13 14:19:39', 0, 24);
INSERT INTO `city_dtl` VALUES (357, '黔西南布依族苗族自治州', '2020-02-13 14:19:39', '2020-02-13 14:19:39', 0, 24);
INSERT INTO `city_dtl` VALUES (358, '黔东南苗族侗族自治州', '2020-02-13 14:19:39', '2020-02-13 14:19:39', 0, 24);
INSERT INTO `city_dtl` VALUES (359, '黔南布依族苗族自治州', '2020-02-13 14:19:39', '2020-02-13 14:19:39', 0, 24);
INSERT INTO `city_dtl` VALUES (360, '昆明', '2020-02-13 14:21:54', '2020-02-13 14:21:54', 0, 25);
INSERT INTO `city_dtl` VALUES (361, '曲靖', '2020-02-13 14:21:54', '2020-02-13 14:21:54', 0, 25);
INSERT INTO `city_dtl` VALUES (362, '玉溪', '2020-02-13 14:21:54', '2020-02-13 14:21:54', 0, 25);
INSERT INTO `city_dtl` VALUES (363, '保山', '2020-02-13 14:21:54', '2020-02-13 14:21:54', 0, 25);
INSERT INTO `city_dtl` VALUES (364, '昭通', '2020-02-13 14:21:54', '2020-02-13 14:21:54', 0, 25);
INSERT INTO `city_dtl` VALUES (365, '丽江', '2020-02-13 14:21:54', '2020-02-13 14:21:54', 0, 25);
INSERT INTO `city_dtl` VALUES (366, '普洱', '2020-02-13 14:21:54', '2020-02-13 14:21:54', 0, 25);
INSERT INTO `city_dtl` VALUES (367, '临沧', '2020-02-13 14:21:54', '2020-02-13 14:21:54', 0, 25);
INSERT INTO `city_dtl` VALUES (368, '楚雄彝族自治州', '2020-02-13 14:21:54', '2020-02-13 14:21:54', 0, 25);
INSERT INTO `city_dtl` VALUES (369, '红河哈尼族彝族自治州', '2020-02-13 14:21:54', '2020-02-13 14:21:54', 0, 25);
INSERT INTO `city_dtl` VALUES (370, '文山壮族苗族自治州', '2020-02-13 14:21:54', '2020-02-13 14:21:54', 0, 25);
INSERT INTO `city_dtl` VALUES (371, '西双版纳傣族自治州', '2020-02-13 14:21:54', '2020-02-13 14:21:54', 0, 25);
INSERT INTO `city_dtl` VALUES (372, '大理白族自治州', '2020-02-13 14:21:54', '2020-02-13 14:21:54', 0, 25);
INSERT INTO `city_dtl` VALUES (373, '德宏傣族景颇族自治州', '2020-02-13 14:21:54', '2020-02-13 14:21:54', 0, 25);
INSERT INTO `city_dtl` VALUES (374, '怒江傈僳族自治州', '2020-02-13 14:21:54', '2020-02-13 14:21:54', 0, 25);
INSERT INTO `city_dtl` VALUES (375, '迪庆藏族自治州', '2020-02-13 14:21:54', '2020-02-13 14:21:54', 0, 25);
INSERT INTO `city_dtl` VALUES (376, '拉萨', '2020-02-13 14:23:39', '2020-02-13 14:23:39', 0, 26);
INSERT INTO `city_dtl` VALUES (377, '日喀则', '2020-02-13 14:23:39', '2020-02-13 14:23:39', 0, 26);
INSERT INTO `city_dtl` VALUES (378, '昌都', '2020-02-13 14:23:39', '2020-02-13 14:23:39', 0, 26);
INSERT INTO `city_dtl` VALUES (379, '林芝', '2020-02-13 14:23:39', '2020-02-13 14:23:39', 0, 26);
INSERT INTO `city_dtl` VALUES (380, '山南', '2020-02-13 14:23:39', '2020-02-13 14:23:39', 0, 26);
INSERT INTO `city_dtl` VALUES (381, '那曲', '2020-02-13 14:23:39', '2020-02-13 14:23:39', 0, 26);
INSERT INTO `city_dtl` VALUES (382, '阿里地区', '2020-02-13 14:23:39', '2020-02-13 14:23:39', 0, 26);
INSERT INTO `city_dtl` VALUES (383, '西安', '2020-02-13 14:24:39', '2020-02-13 14:24:39', 0, 27);
INSERT INTO `city_dtl` VALUES (384, '铜川', '2020-02-13 14:24:39', '2020-02-13 14:24:39', 0, 27);
INSERT INTO `city_dtl` VALUES (385, '宝鸡', '2020-02-13 14:24:39', '2020-02-13 14:24:39', 0, 27);
INSERT INTO `city_dtl` VALUES (386, '咸阳', '2020-02-13 14:24:39', '2020-02-13 14:24:39', 0, 27);
INSERT INTO `city_dtl` VALUES (387, '渭南', '2020-02-13 14:24:39', '2020-02-13 14:24:39', 0, 27);
INSERT INTO `city_dtl` VALUES (388, '延安', '2020-02-13 14:24:39', '2020-02-13 14:24:39', 0, 27);
INSERT INTO `city_dtl` VALUES (389, '汉中', '2020-02-13 14:24:39', '2020-02-13 14:24:39', 0, 27);
INSERT INTO `city_dtl` VALUES (390, '榆林', '2020-02-13 14:24:39', '2020-02-13 14:24:39', 0, 27);
INSERT INTO `city_dtl` VALUES (391, '安康', '2020-02-13 14:24:39', '2020-02-13 14:24:39', 0, 27);
INSERT INTO `city_dtl` VALUES (392, '商洛', '2020-02-13 14:24:39', '2020-02-13 14:24:39', 0, 27);
INSERT INTO `city_dtl` VALUES (393, '兰州', '2020-02-13 14:26:05', '2020-02-13 14:26:05', 0, 28);
INSERT INTO `city_dtl` VALUES (394, '嘉峪关', '2020-02-13 14:26:05', '2020-02-13 14:26:05', 0, 28);
INSERT INTO `city_dtl` VALUES (395, '金昌', '2020-02-13 14:26:05', '2020-02-13 14:26:05', 0, 28);
INSERT INTO `city_dtl` VALUES (396, '白银', '2020-02-13 14:26:05', '2020-02-13 14:26:05', 0, 28);
INSERT INTO `city_dtl` VALUES (397, '天水', '2020-02-13 14:26:05', '2020-02-13 14:26:05', 0, 28);
INSERT INTO `city_dtl` VALUES (398, '武威', '2020-02-13 14:26:05', '2020-02-13 14:26:05', 0, 28);
INSERT INTO `city_dtl` VALUES (399, '张掖', '2020-02-13 14:26:05', '2020-02-13 14:26:05', 0, 28);
INSERT INTO `city_dtl` VALUES (400, '平凉', '2020-02-13 14:26:05', '2020-02-13 14:26:05', 0, 28);
INSERT INTO `city_dtl` VALUES (401, '酒泉', '2020-02-13 14:26:05', '2020-02-13 14:26:05', 0, 28);
INSERT INTO `city_dtl` VALUES (402, '庆阳', '2020-02-13 14:26:05', '2020-02-13 14:26:05', 0, 28);
INSERT INTO `city_dtl` VALUES (403, '定西', '2020-02-13 14:26:05', '2020-02-13 14:26:05', 0, 28);
INSERT INTO `city_dtl` VALUES (404, '陇南', '2020-02-13 14:26:05', '2020-02-13 14:26:05', 0, 28);
INSERT INTO `city_dtl` VALUES (405, '临夏回族自治州', '2020-02-13 14:26:05', '2020-02-13 14:26:05', 0, 28);
INSERT INTO `city_dtl` VALUES (406, '甘南藏族自治州', '2020-02-13 14:26:05', '2020-02-13 14:26:05', 0, 28);
INSERT INTO `city_dtl` VALUES (407, '西宁', '2020-02-13 14:27:23', '2020-02-13 14:27:23', 0, 29);
INSERT INTO `city_dtl` VALUES (408, '海东', '2020-02-13 14:27:23', '2020-02-13 14:27:23', 0, 29);
INSERT INTO `city_dtl` VALUES (409, '海北藏族自治州', '2020-02-13 14:27:23', '2020-02-13 14:27:23', 0, 29);
INSERT INTO `city_dtl` VALUES (410, '黄南藏族自治州', '2020-02-13 14:27:23', '2020-02-13 14:27:23', 0, 29);
INSERT INTO `city_dtl` VALUES (411, '海南藏族自治州', '2020-02-13 14:27:23', '2020-02-13 14:27:23', 0, 29);
INSERT INTO `city_dtl` VALUES (412, '果洛藏族自治州', '2020-02-13 14:27:23', '2020-02-13 14:27:23', 0, 29);
INSERT INTO `city_dtl` VALUES (413, '玉树藏族自治州', '2020-02-13 14:27:23', '2020-02-13 14:27:23', 0, 29);
INSERT INTO `city_dtl` VALUES (414, '海西蒙古族藏族自治州', '2020-02-13 14:27:23', '2020-02-13 14:27:23', 0, 29);
INSERT INTO `city_dtl` VALUES (415, '银川', '2020-02-13 14:27:52', '2020-02-13 14:27:52', 0, 30);
INSERT INTO `city_dtl` VALUES (416, '石嘴山', '2020-02-13 14:27:52', '2020-02-13 14:27:52', 0, 30);
INSERT INTO `city_dtl` VALUES (417, '吴忠', '2020-02-13 14:27:52', '2020-02-13 14:27:52', 0, 30);
INSERT INTO `city_dtl` VALUES (418, '固原', '2020-02-13 14:27:52', '2020-02-13 14:27:52', 0, 30);
INSERT INTO `city_dtl` VALUES (419, '中卫', '2020-02-13 14:27:52', '2020-02-13 14:27:52', 0, 30);
INSERT INTO `city_dtl` VALUES (420, '乌鲁木齐', '2020-02-13 14:30:39', '2020-02-13 14:30:39', 0, 31);
INSERT INTO `city_dtl` VALUES (421, '克拉玛依', '2020-02-13 14:30:39', '2020-02-13 14:30:39', 0, 31);
INSERT INTO `city_dtl` VALUES (422, '吐鲁番', '2020-02-13 14:30:39', '2020-02-13 14:30:39', 0, 31);
INSERT INTO `city_dtl` VALUES (423, '哈密', '2020-02-13 14:30:39', '2020-02-13 14:30:39', 0, 31);
INSERT INTO `city_dtl` VALUES (424, '昌吉回族自治州', '2020-02-13 14:30:39', '2020-02-13 14:30:39', 0, 31);
INSERT INTO `city_dtl` VALUES (425, '博尔塔拉蒙古自治州', '2020-02-13 14:30:39', '2020-02-13 14:30:39', 0, 31);
INSERT INTO `city_dtl` VALUES (426, '巴音郭楞蒙古自治州', '2020-02-13 14:30:39', '2020-02-13 14:30:39', 0, 31);
INSERT INTO `city_dtl` VALUES (427, '阿克苏地区', '2020-02-13 14:30:39', '2020-02-13 14:30:39', 0, 31);
INSERT INTO `city_dtl` VALUES (428, '克孜勒苏柯尔克孜自治州', '2020-02-13 14:30:39', '2020-02-13 14:30:39', 0, 31);
INSERT INTO `city_dtl` VALUES (429, '喀什地区', '2020-02-13 14:30:39', '2020-02-13 14:30:39', 0, 31);
INSERT INTO `city_dtl` VALUES (430, '和田地区', '2020-02-13 14:30:39', '2020-02-13 14:30:39', 0, 31);
INSERT INTO `city_dtl` VALUES (431, '伊犁哈萨克自治州', '2020-02-13 14:30:39', '2020-02-13 14:30:39', 0, 31);
INSERT INTO `city_dtl` VALUES (432, '塔城地区', '2020-02-13 14:30:39', '2020-02-13 14:30:39', 0, 31);
INSERT INTO `city_dtl` VALUES (433, '阿勒泰地区', '2020-02-13 14:30:39', '2020-02-13 14:30:39', 0, 31);
INSERT INTO `city_dtl` VALUES (434, '其他地区', '2020-02-13 14:30:39', '2020-02-13 14:30:39', 0, 31);
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of classroom
-- ----------------------------
BEGIN;
INSERT INTO `classroom` VALUES (1, 'First', 'SE-101', 30, '2020-02-14 13:06:18', '2020-02-14 13:06:18', 0);
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of major
-- ----------------------------
BEGIN;
INSERT INTO `major` VALUES (1, 'MC_50601', 'History of Architecture', NULL, '2020-02-14 15:00:21', '2020-02-14 15:00:21', 0);
INSERT INTO `major` VALUES (2, 'MC_51001', 'Anatomy: The Life of a Cell', NULL, '2020-02-14 15:02:46', '2020-02-14 15:02:46', 0);
INSERT INTO `major` VALUES (3, 'MC_50101', 'Introduction to Psychology', NULL, '2020-02-14 15:05:09', '2020-02-14 15:05:09', 0);
INSERT INTO `major` VALUES (4, 'MC_50201', 'Public Economics', NULL, '2020-02-14 15:20:34', '2020-02-14 15:20:34', 0);
INSERT INTO `major` VALUES (5, 'MC_50202', 'Game Theory', NULL, '2020-02-14 15:21:19', '2020-02-14 15:21:19', 0);
INSERT INTO `major` VALUES (6, 'MC_50102', 'Introduction to Philosophy', NULL, '2020-02-14 15:27:07', '2020-02-14 15:27:07', 0);
INSERT INTO `major` VALUES (7, 'MC_50103', 'Philosophy and Science of Human Nature', NULL, '2020-02-14 15:27:32', '2020-02-14 15:27:32', 0);
INSERT INTO `major` VALUES (8, 'MC_50602', 'International System in the 20th Century', NULL, '2020-02-14 15:30:00', '2020-02-14 15:30:00', 0);
INSERT INTO `major` VALUES (9, 'MC_50603', 'Ancient Greece:Myth,Art,War', NULL, '2020-02-14 15:32:37', '2020-02-14 15:32:37', 0);
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of major_dtl
-- ----------------------------
BEGIN;
INSERT INTO `major_dtl` VALUES (1, 'SS', 2021, '2020-02-14 17:19:39', '2020-02-14 17:19:39', 0, 1, 1);
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of province_dtl
-- ----------------------------
BEGIN;
INSERT INTO `province_dtl` VALUES (1, '北京市', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (2, '天津市', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (3, '河北省', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (4, '山西省', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (5, '内蒙古自治区', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (6, '辽宁省', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (7, '吉林省', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (8, '黑龙江省', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (9, '上海市', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (10, '江苏省', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (11, '浙江省', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (12, '安徽省', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (13, '福建省', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (14, '江西省', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (15, '山东省', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (16, '河南省', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (17, '湖北省', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (18, '湖南省', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (19, '广东省', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (20, '广西壮族自治区', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (21, '海南省', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (22, '重庆市', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (23, '四川省', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (24, '贵州省', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (25, '云南省', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (26, '西藏自治区', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (27, '陕西省', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (28, '甘肃省', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (29, '青岛省', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (30, '宁夏回族自治区', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
INSERT INTO `province_dtl` VALUES (31, '新疆维吾尔自治区', '2020-02-13 13:11:09', '2020-02-13 13:11:09', 0, 1);
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (1, 'admin', '2020-02-05 10:32:01', '2020-02-05 10:32:01', 0);
INSERT INTO `role` VALUES (2, 'Student', '2020-02-09 16:47:52', '2020-02-09 16:47:52', 0);
INSERT INTO `role` VALUES (3, 'teacher', '2020-02-16 04:27:28', '2020-02-16 04:27:28', 0);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '666666', 'allwayzio@126.com', '2020-02-13 11:50:32', '2020-02-13 11:50:32', 0, 1, 1);
INSERT INTO `user` VALUES (2, '123456', 'allwayzx@126.com', '2020-02-13 12:11:01', '2020-02-13 12:11:01', 0, 1, NULL);
INSERT INTO `user` VALUES (3, '123456', '2584491610@qq.com', '2020-02-13 12:14:10', '2020-02-13 12:14:10', 0, 1, NULL);
INSERT INTO `user` VALUES (4, '123456', '2584491610x@qq.com', '2020-02-13 12:13:45', '2020-02-13 12:13:45', 0, 1, NULL);
INSERT INTO `user` VALUES (5, '123456', 'allwayzioxx@126.com', '2020-02-13 12:14:34', '2020-02-13 12:14:34', 0, 1, NULL);
INSERT INTO `user` VALUES (6, '123456', '374615181@qq.com', '2020-02-16 04:37:28', '2020-02-16 04:37:28', 0, 1, NULL);
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_dtl
-- ----------------------------
BEGIN;
INSERT INTO `user_dtl` VALUES (1, 'Allwayz', 'Liu', '1999-03-12', '12345678901', NULL, '2020-02-14 17:44:57', '2020-02-14 17:44:57', 0, 1, 122);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

```


