/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : xksystem

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 10/01/2022 21:50:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `course_no` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `credit` int(0) NULL DEFAULT NULL,
  `exchange_no` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `course_no`(`course_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1481, 'PTSS001', 'Basic Principle of Marxism', 6, NULL);
INSERT INTO `course` VALUES (1482, 'PTSS002', 'Mao Zedong Thought', 8, NULL);
INSERT INTO `course` VALUES (1483, 'FORE001', 'College English 1', 2, NULL);
INSERT INTO `course` VALUES (1484, 'FORE002', 'College English 2', 2, NULL);
INSERT INTO `course` VALUES (1485, 'FORE003', 'College English 3', 2, NULL);
INSERT INTO `course` VALUES (1486, 'MATH001', 'Advanced Mathematics A', 4, NULL);
INSERT INTO `course` VALUES (1487, 'MATH002', 'Advanced Mathematics B', 4, NULL);
INSERT INTO `course` VALUES (1488, 'MATH003', 'Advanced Mathematics C', 4, NULL);
INSERT INTO `course` VALUES (1489, 'MATH004', 'Linear Algebra', 3, NULL);
INSERT INTO `course` VALUES (1490, 'MATH005', 'Probability Theory', 4, NULL);
INSERT INTO `course` VALUES (1491, 'PHYS001', 'College Physics A', 4, NULL);
INSERT INTO `course` VALUES (1492, 'PHYS002', 'College Physics B', 4, NULL);
INSERT INTO `course` VALUES (1493, 'PHYS003', 'College Physics C', 4, NULL);
INSERT INTO `course` VALUES (1494, 'COMP001', 'Data Structure', 3, NULL);
INSERT INTO `course` VALUES (1495, 'COMP002', 'Machine Learning', 3, NULL);
INSERT INTO `course` VALUES (1496, 'COMP003', 'C Programming', 3, NULL);
INSERT INTO `course` VALUES (1497, 'COMP004', 'C++ Programming', 3, NULL);
INSERT INTO `course` VALUES (1498, 'COMP005', 'Python Programming', 3, NULL);
INSERT INTO `course` VALUES (1499, 'COMP006', 'Java Programming', 3, NULL);
INSERT INTO `course` VALUES (1500, 'COMP007', 'Computer Network', 3, NULL);
INSERT INTO `course` VALUES (1501, 'COMP008', 'Computer Virus and Defense', 3, NULL);
INSERT INTO `course` VALUES (1502, 'COMP009', 'Operating System', 3, NULL);
INSERT INTO `course` VALUES (1503, 'CHIN010', 'Dream of the Red Chamber', 2, NULL);
INSERT INTO `course` VALUES (1504, 'CHIN011', 'Water Margin', 2, NULL);
INSERT INTO `course` VALUES (1505, 'CHIN012', 'Journey to the West', 2, NULL);
INSERT INTO `course` VALUES (1506, 'ECON010', 'Economy and Society', 2, NULL);
INSERT INTO `course` VALUES (1507, 'LAWS010', 'History of constitutional civilization', 2, NULL);
INSERT INTO `course` VALUES (1508, 'LAWS011', 'Law and Society', 2, NULL);
INSERT INTO `course` VALUES (1509, 'COMP010', 'Go Programming', 2, NULL);
INSERT INTO `course` VALUES (1510, 'COMP011', 'JavaScript Programming', 2, NULL);
INSERT INTO `course` VALUES (1511, 'COMP012', 'C# Programming', 2, NULL);
INSERT INTO `course` VALUES (1512, 'COMP013', 'Pascal Programming', 2, NULL);
INSERT INTO `course` VALUES (1513, 'COMP014', 'PHP Programming', 2, NULL);
INSERT INTO `course` VALUES (1514, 'COMP015', 'Deep Learning', 2, NULL);
INSERT INTO `course` VALUES (1515, 'COMP016', 'Reinforcement Learning', 2, NULL);
INSERT INTO `course` VALUES (1516, 'COMP017', 'Big Data', 2, NULL);
INSERT INTO `course` VALUES (1517, 'COMP018', 'Computer Vision', 2, NULL);
INSERT INTO `course` VALUES (1518, 'COMP019', 'How to be A Hacker', 2, NULL);
INSERT INTO `course` VALUES (1519, 'COMP020', 'How to be A Hacker: Advanced', 2, NULL);
INSERT INTO `course` VALUES (1520, 'COMP021', 'How to be A Hacker: Master', 2, NULL);
INSERT INTO `course` VALUES (1521, 'COMP022', 'TCP/IP', 2, NULL);

-- ----------------------------
-- Table structure for course_category
-- ----------------------------
DROP TABLE IF EXISTS `course_category`;
CREATE TABLE `course_category`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `plan_section_id` int(0) NOT NULL,
  `course_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_category
-- ----------------------------
INSERT INTO `course_category` VALUES (1297, 517, 'PTSS001');
INSERT INTO `course_category` VALUES (1298, 517, 'PTSS002');
INSERT INTO `course_category` VALUES (1299, 517, 'FORE003');
INSERT INTO `course_category` VALUES (1300, 517, 'MATH003');
INSERT INTO `course_category` VALUES (1301, 517, 'MATH004');
INSERT INTO `course_category` VALUES (1302, 517, 'MATH005');
INSERT INTO `course_category` VALUES (1303, 517, 'PHYS003');
INSERT INTO `course_category` VALUES (1304, 518, 'COMP001');
INSERT INTO `course_category` VALUES (1305, 518, 'COMP003');
INSERT INTO `course_category` VALUES (1306, 518, 'COMP006');
INSERT INTO `course_category` VALUES (1307, 518, 'COMP007');
INSERT INTO `course_category` VALUES (1308, 518, 'COMP008');
INSERT INTO `course_category` VALUES (1309, 518, 'COMP009');
INSERT INTO `course_category` VALUES (1310, 519, 'COMP011');
INSERT INTO `course_category` VALUES (1311, 519, 'COMP012');
INSERT INTO `course_category` VALUES (1312, 519, 'COMP019');
INSERT INTO `course_category` VALUES (1313, 519, 'COMP020');
INSERT INTO `course_category` VALUES (1314, 519, 'COMP021');
INSERT INTO `course_category` VALUES (1315, 519, 'COMP022');
INSERT INTO `course_category` VALUES (1316, 520, 'CHIN010');
INSERT INTO `course_category` VALUES (1317, 520, 'CHIN011');
INSERT INTO `course_category` VALUES (1318, 520, 'CHIN012');
INSERT INTO `course_category` VALUES (1319, 521, 'ECON010');
INSERT INTO `course_category` VALUES (1320, 521, 'LAWS010');
INSERT INTO `course_category` VALUES (1321, 521, 'LAWS011');
INSERT INTO `course_category` VALUES (1322, 523, 'PTSS001');
INSERT INTO `course_category` VALUES (1323, 523, 'PTSS002');
INSERT INTO `course_category` VALUES (1324, 523, 'FORE002');
INSERT INTO `course_category` VALUES (1325, 523, 'MATH002');
INSERT INTO `course_category` VALUES (1326, 523, 'MATH004');
INSERT INTO `course_category` VALUES (1327, 523, 'MATH005');
INSERT INTO `course_category` VALUES (1328, 523, 'PHYS002');
INSERT INTO `course_category` VALUES (1329, 524, 'COMP001');
INSERT INTO `course_category` VALUES (1330, 524, 'COMP003');
INSERT INTO `course_category` VALUES (1331, 524, 'COMP004');
INSERT INTO `course_category` VALUES (1332, 524, 'COMP005');
INSERT INTO `course_category` VALUES (1333, 524, 'COMP006');
INSERT INTO `course_category` VALUES (1334, 525, 'COMP009');
INSERT INTO `course_category` VALUES (1335, 525, 'COMP010');
INSERT INTO `course_category` VALUES (1336, 525, 'COMP011');
INSERT INTO `course_category` VALUES (1337, 525, 'COMP012');
INSERT INTO `course_category` VALUES (1338, 525, 'COMP013');
INSERT INTO `course_category` VALUES (1339, 525, 'COMP014');
INSERT INTO `course_category` VALUES (1340, 525, 'COMP018');
INSERT INTO `course_category` VALUES (1341, 526, 'CHIN010');
INSERT INTO `course_category` VALUES (1342, 526, 'CHIN011');
INSERT INTO `course_category` VALUES (1343, 526, 'CHIN012');
INSERT INTO `course_category` VALUES (1344, 527, 'ECON010');
INSERT INTO `course_category` VALUES (1345, 527, 'LAWS010');
INSERT INTO `course_category` VALUES (1346, 527, 'LAWS011');
INSERT INTO `course_category` VALUES (1347, 529, 'PTSS001');
INSERT INTO `course_category` VALUES (1348, 529, 'PTSS002');
INSERT INTO `course_category` VALUES (1349, 529, 'FORE001');
INSERT INTO `course_category` VALUES (1350, 529, 'MATH001');
INSERT INTO `course_category` VALUES (1351, 529, 'MATH004');
INSERT INTO `course_category` VALUES (1352, 529, 'MATH005');
INSERT INTO `course_category` VALUES (1353, 529, 'PHYS001');
INSERT INTO `course_category` VALUES (1354, 530, 'COMP001');
INSERT INTO `course_category` VALUES (1355, 530, 'COMP002');
INSERT INTO `course_category` VALUES (1356, 530, 'COMP003');
INSERT INTO `course_category` VALUES (1357, 530, 'COMP004');
INSERT INTO `course_category` VALUES (1358, 530, 'COMP009');
INSERT INTO `course_category` VALUES (1359, 531, 'COMP015');
INSERT INTO `course_category` VALUES (1360, 531, 'COMP016');
INSERT INTO `course_category` VALUES (1361, 531, 'COMP017');
INSERT INTO `course_category` VALUES (1362, 531, 'COMP018');
INSERT INTO `course_category` VALUES (1363, 532, 'CHIN010');
INSERT INTO `course_category` VALUES (1364, 532, 'CHIN011');
INSERT INTO `course_category` VALUES (1365, 532, 'CHIN012');
INSERT INTO `course_category` VALUES (1366, 533, 'ECON010');
INSERT INTO `course_category` VALUES (1367, 533, 'LAWS010');
INSERT INTO `course_category` VALUES (1368, 533, 'LAWS011');

-- ----------------------------
-- Table structure for plan
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `major` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `direction` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plan
-- ----------------------------
INSERT INTO `plan` VALUES (94, 'Network Engineering', NULL);
INSERT INTO `plan` VALUES (95, 'Software Engineering', NULL);
INSERT INTO `plan` VALUES (96, 'Computer Science', NULL);

-- ----------------------------
-- Table structure for plan_section
-- ----------------------------
DROP TABLE IF EXISTS `plan_section`;
CREATE TABLE `plan_section`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `plan_id` int(0) NULL DEFAULT NULL,
  `plan_section_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `plan_threshold` int(0) NULL DEFAULT NULL,
  `unit` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plan_section
-- ----------------------------
INSERT INTO `plan_section` VALUES (517, 94, 'Basic Compulsory', 31, 0);
INSERT INTO `plan_section` VALUES (518, 94, 'Major Compulsory', 18, 0);
INSERT INTO `plan_section` VALUES (519, 94, 'Major Elective', 6, 0);
INSERT INTO `plan_section` VALUES (520, 94, 'Module 1', 1, 1);
INSERT INTO `plan_section` VALUES (521, 94, 'Module 2', 1, 1);
INSERT INTO `plan_section` VALUES (522, 94, 'Other Elective', 2, 0);
INSERT INTO `plan_section` VALUES (523, 95, 'Basic Compulsory', 31, 0);
INSERT INTO `plan_section` VALUES (524, 95, 'Major Compulsory', 15, 0);
INSERT INTO `plan_section` VALUES (525, 95, 'Major Elective', 6, 0);
INSERT INTO `plan_section` VALUES (526, 95, 'Module 1', 1, 1);
INSERT INTO `plan_section` VALUES (527, 95, 'Module 2', 1, 1);
INSERT INTO `plan_section` VALUES (528, 95, 'Other Elective', 2, 0);
INSERT INTO `plan_section` VALUES (529, 96, 'Basic Compulsory', 31, 0);
INSERT INTO `plan_section` VALUES (530, 96, 'Major Compulsory', 15, 0);
INSERT INTO `plan_section` VALUES (531, 96, 'Major Elective', 6, 0);
INSERT INTO `plan_section` VALUES (532, 96, 'Module 1', 1, 1);
INSERT INTO `plan_section` VALUES (533, 96, 'Module 2', 1, 1);
INSERT INTO `plan_section` VALUES (534, 96, 'Other Elective', 2, 0);

-- ----------------------------
-- Table structure for progress_report
-- ----------------------------
DROP TABLE IF EXISTS `progress_report`;
CREATE TABLE `progress_report`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `student_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `plan_id` int(0) NULL DEFAULT NULL,
  `plan_section_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `plan_threshold` int(0) NULL DEFAULT NULL,
  `actualCredit` int(0) NULL DEFAULT NULL,
  `actualNumber` int(0) NULL DEFAULT NULL,
  `unit` int(0) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of progress_report
-- ----------------------------
INSERT INTO `progress_report` VALUES (3, '18302010993', 54, 'Basic Compulsory', 31, 0, 0, 0, '0.0');

INSERT INTO `progress_report` VALUES (9, '18302010993', 72, 'Basic Compulsory', 31, 0, 0, 0, '0.0');
INSERT INTO `progress_report` VALUES (10, '18302010993', 75, 'Basic Compulsory', 31, 11, 0, 0, '0.0');
INSERT INTO `progress_report` VALUES (11, '18302010993', 78, 'Basic Compulsory', 31, 11, 0, 0, '0.0');
INSERT INTO `progress_report` VALUES (12, '18302010993', 81, 'Basic Compulsory', 31, 11, 0, 0, '0.3548387096774194');
INSERT INTO `progress_report` VALUES (13, '18302010993', 84, 'Basic Compulsory', 31, 0, 0, 0, '0.00');
INSERT INTO `progress_report` VALUES (14, '18302010993', 87, 'Basic Compulsory', 31, 11, 0, 0, '0.35');
INSERT INTO `progress_report` VALUES (15, '18302010993', 90, 'Basic Compulsory', 31, 11, 0, 0, '0.35');
INSERT INTO `progress_report` VALUES (16, '18302010993', 93, 'Basic Compulsory', 31, 11, 0, 0, '0.35');
INSERT INTO `progress_report` VALUES (17, '18302010993', 93, 'Major Compulsory', 15, 9, 0, 0, '0.60');
INSERT INTO `progress_report` VALUES (18, '18302010993', 93, 'Major Elective', 6, 2, 0, 0, '0.33');
INSERT INTO `progress_report` VALUES (19, '18302010993', 93, 'Module 1', 1, 2, 0, 1, '2.00');
INSERT INTO `progress_report` VALUES (20, '18302010993', 93, 'Module 2', 1, 1, 0, 1, '1.00');
INSERT INTO `progress_report` VALUES (21, '18302010993', 93, 'Other Elective', 2, 0, 0, 0, '0.00');
INSERT INTO `progress_report` VALUES (22, '18302010993', 96, 'Basic Compulsory', 31, 11, 3, 0, '0.35');
INSERT INTO `progress_report` VALUES (23, '18302010993', 96, 'Major Compulsory', 15, 9, 3, 0, '0.60');
INSERT INTO `progress_report` VALUES (24, '18302010993', 96, 'Major Elective', 6, 2, 1, 0, '0.33');
INSERT INTO `progress_report` VALUES (25, '18302010993', 96, 'Module 1', 1, 4, 2, 1, '2.00');
INSERT INTO `progress_report` VALUES (26, '18302010993', 96, 'Module 2', 1, 2, 1, 1, '1.00');
INSERT INTO `progress_report` VALUES (27, '18302010993', 96, 'Other Elective', 2, 0, 0, 0, '0.00');

-- ----------------------------
-- Table structure for progress_report_detail
-- ----------------------------
DROP TABLE IF EXISTS `progress_report_detail`;
CREATE TABLE `progress_report_detail`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `student_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `plan_section_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `course_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `report_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of progress_report_detail
-- ----------------------------
INSERT INTO `progress_report_detail` VALUES (1, '18302010993', 'Basic Compulsory', 'PTSS001', '', 9);
INSERT INTO `progress_report_detail` VALUES (2, '18302010993', 'Basic Compulsory', 'FORE001', '', 9);
INSERT INTO `progress_report_detail` VALUES (3, '18302010993', 'Basic Compulsory', 'MATH004', '', 9);
INSERT INTO `progress_report_detail` VALUES (4, '18302010993', 'Basic Compulsory', 'COMP001', '', 9);
INSERT INTO `progress_report_detail` VALUES (5, '18302010993', 'Basic Compulsory', 'COMP003', '', 9);
INSERT INTO `progress_report_detail` VALUES (6, '18302010993', 'Basic Compulsory', 'COMP009', '', 9);
INSERT INTO `progress_report_detail` VALUES (7, '18302010993', 'Basic Compulsory', 'COMP017', '', 9);
INSERT INTO `progress_report_detail` VALUES (8, '18302010993', 'Basic Compulsory', 'CHIN011', '', 9);
INSERT INTO `progress_report_detail` VALUES (9, '18302010993', 'Basic Compulsory', 'CHIN012', '', 9);
INSERT INTO `progress_report_detail` VALUES (10, '18302010993', 'Basic Compulsory', 'ECON010', '', 9);
INSERT INTO `progress_report_detail` VALUES (11, '18302010993', 'Basic Compulsory', 'PTSS001', '', 10);
INSERT INTO `progress_report_detail` VALUES (12, '18302010993', 'Basic Compulsory', 'FORE001', '', 10);
INSERT INTO `progress_report_detail` VALUES (13, '18302010993', 'Basic Compulsory', 'MATH004', '', 10);
INSERT INTO `progress_report_detail` VALUES (14, '18302010993', 'Basic Compulsory', 'PTSS001', '', 11);
INSERT INTO `progress_report_detail` VALUES (15, '18302010993', 'Basic Compulsory', 'FORE001', '', 11);
INSERT INTO `progress_report_detail` VALUES (16, '18302010993', 'Basic Compulsory', 'MATH004', '', 11);
INSERT INTO `progress_report_detail` VALUES (17, '18302010993', 'Basic Compulsory', 'PTSS001', '', 12);
INSERT INTO `progress_report_detail` VALUES (18, '18302010993', 'Basic Compulsory', 'FORE001', '', 12);
INSERT INTO `progress_report_detail` VALUES (19, '18302010993', 'Basic Compulsory', 'MATH004', '', 12);
INSERT INTO `progress_report_detail` VALUES (20, '18302010993', 'Basic Compulsory', 'PTSS001', '', 13);
INSERT INTO `progress_report_detail` VALUES (21, '18302010993', 'Basic Compulsory', 'FORE001', '', 13);
INSERT INTO `progress_report_detail` VALUES (22, '18302010993', 'Basic Compulsory', 'MATH004', '', 13);
INSERT INTO `progress_report_detail` VALUES (23, '18302010993', 'Basic Compulsory', 'COMP001', '', 13);
INSERT INTO `progress_report_detail` VALUES (24, '18302010993', 'Basic Compulsory', 'COMP003', '', 13);
INSERT INTO `progress_report_detail` VALUES (25, '18302010993', 'Basic Compulsory', 'COMP009', '', 13);
INSERT INTO `progress_report_detail` VALUES (26, '18302010993', 'Basic Compulsory', 'COMP017', '', 13);
INSERT INTO `progress_report_detail` VALUES (27, '18302010993', 'Basic Compulsory', 'CHIN011', '', 13);
INSERT INTO `progress_report_detail` VALUES (28, '18302010993', 'Basic Compulsory', 'CHIN012', '', 13);
INSERT INTO `progress_report_detail` VALUES (29, '18302010993', 'Basic Compulsory', 'ECON010', '', 13);
INSERT INTO `progress_report_detail` VALUES (30, '18302010993', 'Basic Compulsory', 'PTSS001', '', 14);
INSERT INTO `progress_report_detail` VALUES (31, '18302010993', 'Basic Compulsory', 'FORE001', '', 14);
INSERT INTO `progress_report_detail` VALUES (32, '18302010993', 'Basic Compulsory', 'MATH004', '', 14);
INSERT INTO `progress_report_detail` VALUES (33, '18302010993', 'Basic Compulsory', 'PTSS001', '', 15);
INSERT INTO `progress_report_detail` VALUES (34, '18302010993', 'Basic Compulsory', 'FORE001', '', 15);
INSERT INTO `progress_report_detail` VALUES (35, '18302010993', 'Basic Compulsory', 'MATH004', '', 15);
INSERT INTO `progress_report_detail` VALUES (36, '18302010993', 'Basic Compulsory', 'PTSS001', '', 16);
INSERT INTO `progress_report_detail` VALUES (37, '18302010993', 'Basic Compulsory', 'FORE001', '', 16);
INSERT INTO `progress_report_detail` VALUES (38, '18302010993', 'Basic Compulsory', 'MATH004', '', 16);
INSERT INTO `progress_report_detail` VALUES (39, '18302010993', 'Major Compulsory', 'COMP001', '', 17);
INSERT INTO `progress_report_detail` VALUES (40, '18302010993', 'Major Compulsory', 'COMP003', '', 17);
INSERT INTO `progress_report_detail` VALUES (41, '18302010993', 'Major Compulsory', 'COMP009', '', 17);
INSERT INTO `progress_report_detail` VALUES (42, '18302010993', 'Major Elective', 'COMP017', '', 18);
INSERT INTO `progress_report_detail` VALUES (43, '18302010993', 'Module 1', 'CHIN011', '', 19);
INSERT INTO `progress_report_detail` VALUES (44, '18302010993', 'Module 1', 'CHIN012', '', 19);
INSERT INTO `progress_report_detail` VALUES (45, '18302010993', 'Module 2', 'ECON010', '', 20);
INSERT INTO `progress_report_detail` VALUES (46, '18302010993', 'Basic Compulsory', 'PTSS001', '', 22);
INSERT INTO `progress_report_detail` VALUES (47, '18302010993', 'Basic Compulsory', 'FORE001', '', 22);
INSERT INTO `progress_report_detail` VALUES (48, '18302010993', 'Basic Compulsory', 'MATH004', '', 22);
INSERT INTO `progress_report_detail` VALUES (49, '18302010993', 'Major Compulsory', 'COMP001', '', 23);
INSERT INTO `progress_report_detail` VALUES (50, '18302010993', 'Major Compulsory', 'COMP003', '', 23);
INSERT INTO `progress_report_detail` VALUES (51, '18302010993', 'Major Compulsory', 'COMP009', '', 23);
INSERT INTO `progress_report_detail` VALUES (52, '18302010993', 'Major Elective', 'COMP017', '', 24);
INSERT INTO `progress_report_detail` VALUES (53, '18302010993', 'Module 1', 'CHIN011', '', 25);
INSERT INTO `progress_report_detail` VALUES (54, '18302010993', 'Module 1', 'CHIN012', '', 25);
INSERT INTO `progress_report_detail` VALUES (55, '18302010993', 'Module 2', 'ECON010', '', 26);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `student_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `major` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `student_no`(`student_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (89, '18302010993', 'San Zhang', 'Computer Science');
INSERT INTO `student` VALUES (90, '18302010996', 'Si Li', 'Computer Science');

-- ----------------------------
-- Table structure for student_course
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `course_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_course
-- ----------------------------
INSERT INTO `student_course` VALUES (1024, 'PTSS001', '18302010993', '2018-09');
INSERT INTO `student_course` VALUES (1025, 'FORE001', '18302010993', '2018-09');
INSERT INTO `student_course` VALUES (1026, 'MATH002', '18302010993', '2018-09');
INSERT INTO `student_course` VALUES (1027, 'MATH004', '18302010993', '2018-09');
INSERT INTO `student_course` VALUES (1028, 'PHYS003', '18302010993', '2018-09');
INSERT INTO `student_course` VALUES (1029, 'COMP001', '18302010993', '2018-09');
INSERT INTO `student_course` VALUES (1030, 'COMP003', '18302010993', '2018-09');
INSERT INTO `student_course` VALUES (1031, 'COMP005', '18302010993', '2018-09');
INSERT INTO `student_course` VALUES (1032, 'COMP007', '18302010993', '2018-09');
INSERT INTO `student_course` VALUES (1033, 'COMP009', '18302010993', '2018-09');
INSERT INTO `student_course` VALUES (1034, 'CHIN011', '18302010993', '2018-09');
INSERT INTO `student_course` VALUES (1035, 'CHIN012', '18302010993', '2018-09');
INSERT INTO `student_course` VALUES (1036, 'ECON010', '18302010993', '2018-09');
INSERT INTO `student_course` VALUES (1037, 'COMP011', '18302010993', '2018-09');
INSERT INTO `student_course` VALUES (1038, 'COMP014', '18302010993', '2018-09');
INSERT INTO `student_course` VALUES (1039, 'COMP017', '18302010993', '2018-09');
INSERT INTO `student_course` VALUES (1040, 'COMP020', '18302010993', '2018-09');
INSERT INTO `student_course` VALUES (1041, 'PTSS002', '18302010996', '2018-09');
INSERT INTO `student_course` VALUES (1042, 'FORE002', '18302010996', '2018-09');
INSERT INTO `student_course` VALUES (1043, 'MATH003', '18302010996', '2018-09');
INSERT INTO `student_course` VALUES (1044, 'MATH005', '18302010996', '2018-09');
INSERT INTO `student_course` VALUES (1045, 'PHYS001', '18302010996', '2018-09');
INSERT INTO `student_course` VALUES (1046, 'COMP002', '18302010996', '2018-09');
INSERT INTO `student_course` VALUES (1047, 'COMP004', '18302010996', '2018-09');
INSERT INTO `student_course` VALUES (1048, 'COMP006', '18302010996', '2018-09');
INSERT INTO `student_course` VALUES (1049, 'COMP008', '18302010996', '2018-09');
INSERT INTO `student_course` VALUES (1050, 'LAWS011', '18302010996', '2018-09');
INSERT INTO `student_course` VALUES (1051, 'COMP011', '18302010996', '2018-09');
INSERT INTO `student_course` VALUES (1052, 'COMP013', '18302010996', '2018-09');
INSERT INTO `student_course` VALUES (1053, 'COMP016', '18302010996', '2018-09');
INSERT INTO `student_course` VALUES (1054, 'COMP019', '18302010996', '2018-09');
INSERT INTO `student_course` VALUES (1055, 'COMP021', '18302010996', '2018-09');
INSERT INTO `student_course` VALUES (1056, 'COMP022', '18302010996', '2018-09');

SET FOREIGN_KEY_CHECKS = 1;
