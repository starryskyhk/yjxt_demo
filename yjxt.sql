/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : yjxt

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2020-09-25 11:22:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `class_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '班级id',
  `name` varchar(50) NOT NULL COMMENT '班级名称',
  `college_id` int(9) NOT NULL COMMENT '学院id',
  `major_id` int(9) NOT NULL COMMENT '专业id',
  `year` int(4) NOT NULL COMMENT '班级开设年度',
  PRIMARY KEY (`class_id`),
  KEY `fk_college_class` (`college_id`) USING BTREE,
  KEY `fk_major_class` (`major_id`) USING BTREE,
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`college_id`) REFERENCES `college` (`college_id`),
  CONSTRAINT `class_ibfk_2` FOREIGN KEY (`major_id`) REFERENCES `major` (`major_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='班级表';

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `college_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '学院Id',
  `name` varchar(50) NOT NULL COMMENT '学院名',
  PRIMARY KEY (`college_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='学院表';

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '课程编号',
  `name` varchar(50) NOT NULL COMMENT '课程名称',
  `credit` int(10) DEFAULT NULL COMMENT '课程学分',
  `college_id` int(9) NOT NULL COMMENT '开设学院id',
  PRIMARY KEY (`course_id`),
  KEY `fk_college_course` (`college_id`) USING BTREE,
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`college_id`) REFERENCES `college` (`college_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='课程表';

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `major_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '专业id',
  `name` varchar(50) NOT NULL COMMENT '专业名称',
  `college_id` int(9) NOT NULL COMMENT '学院id',
  PRIMARY KEY (`major_id`),
  KEY `fk_college_major` (`college_id`) USING BTREE,
  CONSTRAINT `major_ibfk_1` FOREIGN KEY (`college_id`) REFERENCES `college` (`college_id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `notice_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '公告id',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `content` longtext COMMENT '正文',
  `view_num` int(5) DEFAULT '0' COMMENT '浏览次数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `author` varchar(50) DEFAULT NULL COMMENT '发布者名称',
  PRIMARY KEY (`notice_id`),
  KEY `role_id` (`author`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='公告表';

-- ----------------------------
-- Table structure for notice_file
-- ----------------------------
DROP TABLE IF EXISTS `notice_file`;
CREATE TABLE `notice_file` (
  `notice_file_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '附件id',
  `file` varchar(200) DEFAULT NULL COMMENT '附件路径',
  `download_num` int(5) DEFAULT '0' COMMENT '下载次数',
  `notice_id` int(9) DEFAULT NULL COMMENT '公告id',
  PRIMARY KEY (`notice_file_id`),
  KEY `notice_id` (`notice_id`) USING BTREE,
  CONSTRAINT `notice_file_ibfk_1` FOREIGN KEY (`notice_id`) REFERENCES `notice` (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='公告附件表';

-- ----------------------------
-- Table structure for offset
-- ----------------------------
DROP TABLE IF EXISTS `offset`;
CREATE TABLE `offset` (
  `offset_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '抵消表主键',
  `score_id` int(9) DEFAULT NULL COMMENT '成绩表id',
  `verify_id` int(9) DEFAULT NULL COMMENT '审核表id',
  PRIMARY KEY (`offset_id`),
  KEY `score_id` (`score_id`) USING BTREE,
  KEY `verify_id` (`verify_id`) USING BTREE,
  CONSTRAINT `offset_ibfk_1` FOREIGN KEY (`score_id`) REFERENCES `score` (`score_id`),
  CONSTRAINT `offset_ibfk_2` FOREIGN KEY (`verify_id`) REFERENCES `verify` (`verify_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1168 DEFAULT CHARSET=utf8 COMMENT='抵消表，证书审核与成绩的抵消';

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `score_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '成绩表主键',
  `grade` decimal(10,2) unsigned DEFAULT NULL COMMENT '成绩',
  `start_year` varchar(5) NOT NULL COMMENT '开课学年',
  `start_semester` varchar(3) NOT NULL COMMENT '开课学期',
  `remark` varchar(20) NOT NULL COMMENT '备注',
  `course_id` int(9) NOT NULL COMMENT '课程id',
  `user_id` int(9) NOT NULL COMMENT '用户id',
  `status` int(1) DEFAULT '0' COMMENT '是否被抵消，0没有，1有',
  PRIMARY KEY (`score_id`),
  KEY `fk_course_source` (`course_id`) USING BTREE,
  KEY `fk_user_source` (`user_id`) USING BTREE,
  CONSTRAINT `score_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `score_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='成绩表';

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
  `file_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `file_name` varchar(255) NOT NULL COMMENT '文件名',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
  `up_user` int(9) DEFAULT NULL COMMENT '上传用户角色',
  `up_locate` int(9) DEFAULT NULL COMMENT '上传位置',
  `file_type` varchar(10) NOT NULL COMMENT '文件类型',
  `file_size` varchar(10) NOT NULL COMMENT '文件大小',
  `file_down_num` int(9) NOT NULL DEFAULT '0' COMMENT '文件下载次数',
  `file_state` int(1) NOT NULL DEFAULT '1' COMMENT '文件状态',
  `file_path` varchar(100) DEFAULT NULL COMMENT '文件存储路径',
  PRIMARY KEY (`file_id`),
  KEY `fk_locate_role` (`up_locate`) USING BTREE,
  KEY `fk_user_role` (`up_user`) USING BTREE,
  CONSTRAINT `sys_file_ibfk_1` FOREIGN KEY (`up_locate`) REFERENCES `sys_role` (`role_id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `sys_file_ibfk_2` FOREIGN KEY (`up_user`) REFERENCES `sys_role` (`role_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `log_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `ip` varchar(50) DEFAULT NULL COMMENT '用户Ip',
  `username` varchar(20) DEFAULT NULL COMMENT '姓名',
  `class_name` varchar(100) DEFAULT NULL COMMENT '类名',
  `method_name` varchar(50) DEFAULT NULL COMMENT '方法名',
  `module` varchar(10) DEFAULT NULL COMMENT '模块名',
  `discription` varchar(50) DEFAULT NULL COMMENT '详情',
  `time` int(9) DEFAULT NULL COMMENT '持续时间',
  `status` text COMMENT '操作状态',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  `user_id` int(9) NOT NULL COMMENT '用户信息',
  PRIMARY KEY (`log_id`),
  KEY `fk_user_log` (`user_id`) USING BTREE,
  CONSTRAINT `sys_log_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1368 DEFAULT CHARSET=utf8 COMMENT='操作日志表';

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `resource_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '资源Id',
  `parent_id` int(9) NOT NULL COMMENT '父资源id',
  `name` varchar(50) NOT NULL COMMENT '资源名称',
  `path` varchar(100) DEFAULT NULL COMMENT '资源树路径',
  `url` varchar(100) DEFAULT NULL COMMENT '资源路径',
  `permission` varchar(200) DEFAULT NULL COMMENT '授权（用,隔开）',
  `type` varchar(11) NOT NULL COMMENT '资源类型（-1根目录，0目录，1菜单，2按钮）',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `order_num` int(3) DEFAULT NULL COMMENT '排序',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(1) NOT NULL COMMENT '资源状态 0开启，1关闭',
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(20) NOT NULL COMMENT '角色名',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更改时间',
  `order_num` int(4) NOT NULL COMMENT '排序',
  `status` int(1) NOT NULL COMMENT '角色状态0代表正常 1代表不启用',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='角色表\r\n';

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(9) NOT NULL COMMENT '角色id',
  `resource_id` int(9) NOT NULL COMMENT '资源id',
  PRIMARY KEY (`id`),
  KEY `fk_role_rr` (`role_id`) USING BTREE,
  KEY `fk_resource_rr` (`resource_id`) USING BTREE,
  CONSTRAINT `sys_role_resource_ibfk_1` FOREIGN KEY (`resource_id`) REFERENCES `sys_resource` (`resource_id`),
  CONSTRAINT `sys_role_resource_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2616 DEFAULT CHARSET=utf8 COMMENT='角色资源表\r\n描述角色与资源之间的关系';

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(9) NOT NULL COMMENT '学号/工号',
  `username` varchar(50) NOT NULL COMMENT '姓名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `salt` varchar(32) NOT NULL COMMENT '盐，用于加密',
  `sex` int(1) NOT NULL COMMENT '性别，1为男，2为女',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更改时间',
  `college_id` int(9) DEFAULT NULL COMMENT '学院id',
  `major_id` int(9) DEFAULT NULL COMMENT '专业id',
  `class_id` int(9) DEFAULT NULL COMMENT '班级id',
  `isfirst` int(1) DEFAULT '1' COMMENT '1 首次登陆 0 已修改初始密码',
  `parent_phone` varchar(20) DEFAULT NULL COMMENT '父母电话',
  PRIMARY KEY (`user_id`),
  KEY `fk_class_user` (`class_id`) USING BTREE,
  KEY `fk_role_user` (`college_id`) USING BTREE,
  KEY `fk_major_user` (`major_id`) USING BTREE,
  KEY `college_id` (`college_id`,`major_id`,`class_id`) USING BTREE,
  CONSTRAINT `sys_user_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`),
  CONSTRAINT `sys_user_ibfk_2` FOREIGN KEY (`major_id`) REFERENCES `major` (`major_id`),
  CONSTRAINT `sys_user_ibfk_3` FOREIGN KEY (`college_id`) REFERENCES `college` (`college_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for sys_use_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_use_role`;
CREATE TABLE `sys_use_role` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(9) DEFAULT NULL COMMENT '用户id',
  `role_id` int(9) DEFAULT '17' COMMENT '角色id',
  PRIMARY KEY (`id`),
  KEY `fk_user_ur` (`user_id`) USING BTREE,
  KEY `fk_role_ur` (`role_id`) USING BTREE,
  CONSTRAINT `sys_use_role_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`),
  CONSTRAINT `sys_use_role_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=457 DEFAULT CHARSET=utf8 COMMENT='用户角色表\r\n描述用户和角色之间的关系';

-- ----------------------------
-- Table structure for verify
-- ----------------------------
DROP TABLE IF EXISTS `verify`;
CREATE TABLE `verify` (
  `verify_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '审核编号',
  `name` varchar(50) DEFAULT NULL COMMENT '证书名称',
  `img_url` varchar(100) DEFAULT NULL COMMENT '图片路径',
  `apply_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
  `check_time` datetime DEFAULT NULL COMMENT '审核时间',
  `status` int(2) DEFAULT '0' COMMENT '审核状态 0：待审核，1：审核通过，2驳回，3：管理员审核错误撤销，4：学生自己撤销,5:教务处通过.6:教务处驳回',
  `des` varchar(400) DEFAULT NULL COMMENT '申请理由',
  `remark` varchar(100) DEFAULT NULL COMMENT '审核驳回备注',
  `apply_user` int(9) DEFAULT NULL COMMENT '申请人id',
  `check_user` int(9) DEFAULT NULL COMMENT '审核人id',
  PRIMARY KEY (`verify_id`),
  KEY `verify_ibfk_1` (`apply_user`) USING BTREE,
  KEY `verify_ibfk_2` (`check_user`) USING BTREE,
  CONSTRAINT `verify_ibfk_1` FOREIGN KEY (`apply_user`) REFERENCES `sys_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `verify_ibfk_2` FOREIGN KEY (`check_user`) REFERENCES `sys_user` (`user_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8 COMMENT='证书抵消审核表';

-- ----------------------------
-- Table structure for warning_condition
-- ----------------------------
DROP TABLE IF EXISTS `warning_condition`;
CREATE TABLE `warning_condition` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(30) DEFAULT NULL COMMENT '机构名',
  `x_semester` int(5) DEFAULT NULL COMMENT '学业预警学期挂科数目',
  `x_total` int(5) DEFAULT NULL COMMENT '学业预警累计挂科数目',
  `l_academic_year` int(5) DEFAULT NULL COMMENT '留级预警学年挂科数目',
  `l_total` int(5) DEFAULT NULL COMMENT '留级预警累计挂科数目',
  `t_academic_year` int(5) DEFAULT NULL COMMENT '退学预警学年挂科数目',
  `t_total` int(5) DEFAULT NULL COMMENT '退学预警累计挂科数目',
  `status` int(1) DEFAULT '1' COMMENT '是否允许学院修改,0允许,1不允许',
  `college_id` int(9) DEFAULT NULL COMMENT '学院id',
  PRIMARY KEY (`id`),
  KEY `college_id` (`college_id`) USING BTREE,
  CONSTRAINT `warning_condition_ibfk_1` FOREIGN KEY (`college_id`) REFERENCES `college` (`college_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='预警条件表';

-- ----------------------------
-- Table structure for warning_info
-- ----------------------------
DROP TABLE IF EXISTS `warning_info`;
CREATE TABLE `warning_info` (
  `user_id` int(9) NOT NULL COMMENT '预警学生id',
  `type` int(2) NOT NULL DEFAULT '0' COMMENT '预警类型，0未预警,1学业预警，2留级预警，3退学预警',
  `cause` varchar(100) DEFAULT NULL COMMENT '预警原因',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `academic` int(5) DEFAULT NULL COMMENT '预警学年',
  `semester` int(5) DEFAULT NULL COMMENT '预警学期',
  `flag` int(2) DEFAULT '1' COMMENT '打对勾的类型,',
  PRIMARY KEY (`user_id`),
  KEY `fk_user_wi` (`user_id`) USING BTREE,
  CONSTRAINT `warning_info_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预警信息表';
