create database xiaoniu_estate;
use xiaoniu_estate;

DROP TABLE IF EXISTS `tb_activity`;

CREATE TABLE `tb_activity` (
                               `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '活动ID',
                               `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
                               `community_id` int(11) DEFAULT NULL COMMENT '所属小区ID',
                               `title` varchar(100) DEFAULT NULL COMMENT '活动标题',
                               `address` varchar(200) DEFAULT NULL COMMENT '活动地点',
                               `organizer` varchar(100) DEFAULT NULL COMMENT '举办单位',
                               `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                               `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '活动开始时间',
                               `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '活动截止时间',
                               `status` char(1) DEFAULT '0' COMMENT '状态:0-活动未开始（默认），1-活动进行中，2-活动已结束',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动表';

/*Data for the table `tb_activity` */

/*Table structure for table `tb_building` */

DROP TABLE IF EXISTS `tb_building`;

CREATE TABLE `tb_building` (
                               `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '楼栋ID',
                               `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
                               `community_id` int(11) DEFAULT NULL COMMENT '所属小区ID',
                               `name` varchar(50) DEFAULT NULL COMMENT '栋数名称',
                               `total_households` int(11) DEFAULT NULL COMMENT '总户数',
                               `description` varchar(500) DEFAULT NULL COMMENT '描述',
                               `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='楼栋表';

/*Data for the table `tb_building` */

/*Table structure for table `tb_car` */

DROP TABLE IF EXISTS `tb_car`;

CREATE TABLE `tb_car` (
                          `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '车辆ID',
                          `picture` varchar(100) DEFAULT NULL COMMENT '车辆照片',
                          `owner_id` int(11) DEFAULT NULL COMMENT '所属成员（业主）',
                          `color` varchar(10) DEFAULT NULL COMMENT '车辆颜色',
                          `car_number` varchar(20) DEFAULT NULL COMMENT '车牌号',
                          `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                          `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆表';

/*Data for the table `tb_car` */

/*Table structure for table `tb_charge_detail` */

DROP TABLE IF EXISTS `tb_charge_detail`;

CREATE TABLE `tb_charge_detail` (
                                    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收费明细ID',
                                    `community_id` int(11) DEFAULT NULL COMMENT '所属小区ID',
                                    `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
                                    `charge_item_id` int(11) DEFAULT NULL COMMENT '收费项目ID',
                                    `charge_item_name` varchar(50) DEFAULT NULL COMMENT '收费项目名称',
                                    `contractor` varchar(50) DEFAULT NULL COMMENT '承办人名称',
                                    `telephone` int(20) DEFAULT NULL COMMENT '承办人联系电话',
                                    `pay_money` int(11) DEFAULT NULL COMMENT '应收金额(￥)，单位分',
                                    `actual_money` int(11) DEFAULT NULL COMMENT '实收金额(￥)，单位分',
                                    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
                                    `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                                    `pay_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '缴费时间',
                                    `status` char(1) DEFAULT '0' COMMENT '状态：0-生效中（默认），1-已过期',
                                    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收费名细表';

/*Data for the table `tb_charge_detail` */

/*Table structure for table `tb_charge_item` */

DROP TABLE IF EXISTS `tb_charge_item`;

CREATE TABLE `tb_charge_item` (
                                  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收费项目ID',
                                  `community_id` int(11) DEFAULT NULL COMMENT '所属小区ID',
                                  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
                                  `code` varchar(20) DEFAULT NULL COMMENT '收费编号',
                                  `name` varchar(50) DEFAULT NULL COMMENT '项目名称',
                                  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                                  `money` int(11) DEFAULT NULL COMMENT '项目收费金额（年），单位分',
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收费项目表';

/*Data for the table `tb_charge_item` */

/*Table structure for table `tb_community` */

DROP TABLE IF EXISTS `tb_community`;

CREATE TABLE `tb_community` (
                                `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '小区id',
                                `code` varchar(20) NOT NULL COMMENT '小区编号',
                                `name` varchar(50) NOT NULL COMMENT '小区名称',
                                `address` varchar(200) DEFAULT NULL COMMENT '坐落地址',
                                `area` double DEFAULT NULL COMMENT '占地面积（m2）',
                                `total_buildings` int(11) DEFAULT NULL COMMENT '总栋数',
                                `total_households` int(11) DEFAULT NULL COMMENT '总户数',
                                `greening_rate` int(11) DEFAULT NULL COMMENT '绿化率（%）',
                                `thumbnail` varchar(200) DEFAULT NULL COMMENT '缩略图',
                                `developer` varchar(100) DEFAULT NULL COMMENT '开发商名称',
                                `estate_company` varchar(100) DEFAULT NULL COMMENT '物业公司名称',
                                `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                                `status` char(1) DEFAULT '0' COMMENT '状态:0-启用（默认），1-不启用',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5  DEFAULT CHARSET=utf8 COMMENT='小区表';

/*Data for the table `tb_community` */

insert  into `tb_community`(`id`,`code`,`name`,`address`,`area`,`total_buildings`,`total_households`,`greening_rate`,`thumbnail`,`developer`,`estate_company`,`create_time`,`update_time`,`status`) values (1,'HX19960101001','化纤小区','历城区花园路5号',22000,66,2432,30,'/fileupload/d2cea885-a986-463a-97da-7073c9e6fbf6.jpg','济南齐鲁化纤集团有限责任公司','上海新长宁集团新华物业有限公司','2020-12-13 09:12:04','2020-12-13 09:26:12','0');
insert  into `tb_community`(`id`,`code`,`name`,`address`,`area`,`total_buildings`,`total_households`,`greening_rate`,`thumbnail`,`developer`,`estate_company`,`create_time`,`update_time`,`status`) values (2,'DH19960101002','东风小区','历城区花园路6号',33000,50,2222,40,'/images/dongfeng.jpg','济南齐鲁化纤集团有限责任公司','上海新长宁集团新华物业有限公司','2020-12-13 09:24:42','2020-12-13 09:26:14','0');
insert  into `tb_community`(`id`,`code`,`name`,`address`,`area`,`total_buildings`,`total_households`,`greening_rate`,`thumbnail`,`developer`,`estate_company`,`create_time`,`update_time`,`status`) values (3,'BH19960101003','百花小区','历城区花园路7号',44444,88,3000,50,'/fileupload/e6daae7d-17f6-4053-9e44-81cf5a4c5d82.jpg','济南齐鲁化纤集团有限责任公司','上海新长宁集团新华物业有限公司','2020-12-13 09:24:42','2020-12-13 09:24:42','0');
insert  into `tb_community`(`id`,`code`,`name`,`address`,`area`,`total_buildings`,`total_households`,`greening_rate`,`thumbnail`,`developer`,`estate_company`,`create_time`,`update_time`,`status`) values (4,'JYHF20160101001','金域华府','齐鲁软件园',66666,66,2195,35,'/fileupload/ec760e4a-1e1e-479a-9d5d-8c8671069a58.jpg','万达地产集团','万科物业','2020-12-14 19:29:48',NULL,'0');

/*Table structure for table `tb_complaint` */

DROP TABLE IF EXISTS `tb_complaint`;

CREATE TABLE `tb_complaint` (
                                `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '投诉ID',
                                `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
                                `community_id` int(11) DEFAULT NULL COMMENT '所属小区ID',
                                `owner_id` int(11) DEFAULT NULL COMMENT '投诉人员（业主）ID',
                                `owner_name` varchar(40) DEFAULT NULL COMMENT '投诉人员（业主）名称',
                                `description` varchar(500) DEFAULT NULL COMMENT '投诉具体描述',
                                `reason` varchar(100) DEFAULT NULL COMMENT '投诉事由',
                                `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
                                `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                                `status` char(1) DEFAULT '0' COMMENT '状态：0-未受理，1-已受理（默认），2-已处理完毕',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投诉表';

/*Data for the table `tb_complaint` */

/*Table structure for table `tb_device` */

DROP TABLE IF EXISTS `tb_device`;

CREATE TABLE `tb_device` (
                             `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备ID',
                             `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
                             `community_id` int(11) DEFAULT NULL COMMENT '所属小区ID',
                             `code` varchar(20) DEFAULT NULL COMMENT '设备编号',
                             `name` varchar(50) DEFAULT NULL COMMENT '设备名称',
                             `brand` varchar(40) DEFAULT NULL COMMENT '设备品牌',
                             `unit_price` int(11) DEFAULT NULL COMMENT '购买单价(￥)，单位分',
                             `num` int(11) DEFAULT NULL COMMENT '购买数量',
                             `expected_useful_life` int(11) DEFAULT NULL COMMENT '预计使用年限(年)',
                             `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
                             `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                             `purchase_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '购买日期',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备表';

/*Data for the table `tb_device` */

/*Table structure for table `tb_estate_manager` */

DROP TABLE IF EXISTS `tb_estate_manager`;

CREATE TABLE `tb_estate_manager` (
                                     `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '物业管理人员ID',
                                     `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
                                     `community_id` int(11) DEFAULT NULL COMMENT '所属小区ID',
                                     `login_name` varchar(20) DEFAULT NULL COMMENT '登录名:登录时使用的名称',
                                     `name` varchar(50) DEFAULT NULL COMMENT '真实名称',
                                     `password` varchar(60) DEFAULT NULL COMMENT '密码',
                                     `telephone` int(20) DEFAULT NULL COMMENT '手机',
                                     `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
                                     `role_id` int(11) DEFAULT '0' COMMENT '角色ID：0-普通用户（默认0），1-管理员用户',
                                     `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                     `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                                     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='物业管理人员表';

/*Data for the table `tb_estate_manager` */

insert  into `tb_estate_manager`(`id`,`community_name`,`community_id`,`login_name`,`name`,`password`,`telephone`,`email`,`role_id`,`create_time`,`update_time`) values (1,'化纤小区',1,'15900000000','张三','123456',2147483647,'123@163.com',0,'2020-12-14 10:17:49','2020-12-14 10:17:49');
insert  into `tb_estate_manager`(`id`,`community_name`,`community_id`,`login_name`,`name`,`password`,`telephone`,`email`,`role_id`,`create_time`,`update_time`) values (2,'百花小区',3,'15911111111','李四','123456',2147483647,'456@163.com',0,'2020-12-14 10:17:55','2020-12-14 10:17:55');
insert  into `tb_estate_manager`(`id`,`community_name`,`community_id`,`login_name`,`name`,`password`,`telephone`,`email`,`role_id`,`create_time`,`update_time`) values (3,'东风小区',2,'15922222222','王五','123456',2147483647,'789@163.com',0,'2020-12-14 10:18:03','2020-12-14 10:18:03');

/*Table structure for table `tb_house` */

DROP TABLE IF EXISTS `tb_house`;

CREATE TABLE `tb_house` (
                            `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房屋ID',
                            `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
                            `community_id` int(11) DEFAULT NULL COMMENT '所属小区ID',
                            `building_name` varchar(50) DEFAULT NULL COMMENT '所属栋数名称',
                            `building_id` int(11) DEFAULT NULL COMMENT '所属栋数ID',
                            `code` varchar(50) DEFAULT NULL COMMENT '房产编码',
                            `name` varchar(100) DEFAULT NULL COMMENT '房产名称',
                            `owner_id` int(11) DEFAULT NULL COMMENT '户主（业主）ID',
                            `owner_name` varchar(50) DEFAULT NULL COMMENT '户主（业主）名称',
                            `telephone` int(20) DEFAULT NULL COMMENT '联系方式',
                            `room_num` int(11) DEFAULT NULL COMMENT '房间数',
                            `unit` int(2) DEFAULT NULL COMMENT '单元',
                            `floor` int(3) DEFAULT NULL COMMENT '楼层',
                            `description` varchar(500) DEFAULT NULL COMMENT '描述',
                            `live_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入住时间',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房屋表';

/*Data for the table `tb_house` */

/*Table structure for table `tb_letter` */

DROP TABLE IF EXISTS `tb_letter`;

CREATE TABLE `tb_letter` (
                             `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '信件ID',
                             `community_id` int(11) DEFAULT NULL COMMENT '所属小区ID',
                             `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
                             `owner_id` int(11) DEFAULT NULL COMMENT '信件发送者（业主）ID',
                             `owner_name` varchar(50) DEFAULT NULL COMMENT '信件发送者（业主）名称',
                             `origin` char(1) DEFAULT '0' COMMENT '信件来源：0-信箱（默认），1-邮件，2-微信，3-公众号，4-app,5-pc',
                             `title` varchar(100) DEFAULT NULL COMMENT '信件标题',
                             `content` varchar(2000) DEFAULT NULL COMMENT '信箱内容',
                             `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                             `status` char(1) DEFAULT '0' COMMENT '状态:0-未读（默认），1-已读',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='信件表';

/*Data for the table `tb_letter` */

/*Table structure for table `tb_owner` */

DROP TABLE IF EXISTS `tb_owner`;

CREATE TABLE `tb_owner` (
                            `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '业主ID',
                            `community_id` int(11) DEFAULT NULL COMMENT '所属小区',
                            `house_id` int(11) DEFAULT NULL COMMENT '所属房产',
                            `name` varchar(50) DEFAULT NULL COMMENT '成员名称',
                            `picture` varchar(100) DEFAULT NULL COMMENT '成员照片',
                            `idcard` varchar(18) DEFAULT NULL COMMENT '身份证号',
                            `telephone` int(20) DEFAULT NULL COMMENT '联系方式',
                            `profession` varchar(20) DEFAULT NULL COMMENT '职业',
                            `sex` char(1) DEFAULT '0' COMMENT '性别:0-男（默认），1-女',
                            `type` char(1) DEFAULT '0' COMMENT '类型:0-房主（默认），1-租客',
                            `remark` varchar(200) DEFAULT '无' COMMENT '备注（默认无）',
                            `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                            `birthday` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '出生日期',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业主表';

/*Data for the table `tb_owner` */

/*Table structure for table `tb_parking` */

DROP TABLE IF EXISTS `tb_parking`;

CREATE TABLE `tb_parking` (
                              `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '车位ID',
                              `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
                              `community_id` int(11) DEFAULT NULL COMMENT '所属小区ID',
                              `picture` varchar(100) DEFAULT NULL COMMENT '车位图片',
                              `code` varchar(20) DEFAULT NULL COMMENT '车位编号',
                              `name` varchar(50) DEFAULT NULL COMMENT '车位名称',
                              `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车位表';

/*Data for the table `tb_parking` */

/*Table structure for table `tb_parking_use` */

DROP TABLE IF EXISTS `tb_parking_use`;

CREATE TABLE `tb_parking_use` (
                                  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '车位使用ID',
                                  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
                                  `community_id` int(11) DEFAULT NULL COMMENT '所属小区ID',
                                  `code` varchar(20) DEFAULT NULL COMMENT '车位编号',
                                  `car_number` varchar(20) DEFAULT NULL COMMENT '车牌号码',
                                  `picture` varchar(100) DEFAULT NULL COMMENT '车辆牌照（照片）',
                                  `owner_name` varchar(50) DEFAULT NULL COMMENT '车辆所有人（业主）名称',
                                  `owner_id` int(11) DEFAULT NULL COMMENT '车辆所有人（业主）ID',
                                  `telephone` int(20) DEFAULT NULL COMMENT '联系方式',
                                  `use_type` char(1) DEFAULT '0' COMMENT '使用性质：0-购买(默认)，1-月租，2-年租',
                                  `total_fee` int(11) DEFAULT NULL COMMENT '总费用(￥)，以分为单位',
                                  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                                  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '（使用）开始时间',
                                  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '（使用）结束时间',
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车位使用表';

/*Data for the table `tb_parking_use` */

/*Table structure for table `tb_pet` */

DROP TABLE IF EXISTS `tb_pet`;

CREATE TABLE `tb_pet` (
                          `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '宠物ID',
                          `picture` varchar(100) DEFAULT NULL COMMENT '宠物照片',
                          `owner_name` varchar(50) DEFAULT NULL COMMENT '所属成员（业主）名称',
                          `owner_id` int(11) DEFAULT NULL COMMENT '所属成员（业主）ID',
                          `name` varchar(50) DEFAULT NULL COMMENT '宠物名称',
                          `color` varchar(10) DEFAULT NULL COMMENT '宠物颜色',
                          `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                          `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                          `adopt_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '收养时间',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='宠物表';

/*Data for the table `tb_pet` */

/*Table structure for table `tb_repair` */

DROP TABLE IF EXISTS `tb_repair`;

CREATE TABLE `tb_repair` (
                             `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '维修ID',
                             `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
                             `community_id` int(11) DEFAULT NULL COMMENT '所属小区ID',
                             `building_name` varchar(50) DEFAULT NULL COMMENT '所属楼栋名称',
                             `building_id` int(11) DEFAULT NULL COMMENT '所属楼栋ID',
                             `owner_name` varchar(50) DEFAULT NULL COMMENT '报修人员（业主）名称',
                             `owner_id` int(11) DEFAULT NULL COMMENT '报修人员（业主）ID',
                             `device_name` varchar(50) DEFAULT NULL COMMENT '设备名称',
                             `device_id` int(11) DEFAULT NULL COMMENT '设备编号ID',
                             `description` varchar(500) DEFAULT NULL COMMENT '报修描述',
                             `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
                             `status` char(1) DEFAULT '0' COMMENT '状态：0-待受理，1-已受理，2-修理完毕',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='维修表';

/*Data for the table `tb_repair` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;




INSERT INTO `xiaoniu_estate`.`tb_building`(`id`, `community_name`, `community_id`, `name`, `total_households`, `description`, `create_time`, `update_time`) VALUES (1, '化纤小区', 1, 'A16', 50, '环境美好', '2022-02-07 18:54:26', '2022-02-07 18:54:26');
INSERT INTO `xiaoniu_estate`.`tb_building`(`id`, `community_name`, `community_id`, `name`, `total_households`, `description`, `create_time`, `update_time`) VALUES (2, '百花小区', 3, 'A17', 50, '绿化很好', '2022-02-07 18:54:27', '2022-02-07 18:54:27');
INSERT INTO `xiaoniu_estate`.`tb_building`(`id`, `community_name`, `community_id`, `name`, `total_households`, `description`, `create_time`, `update_time`) VALUES (3, '百花小区', 3, 'A18', 51, '绿化很好', '2022-02-07 18:54:28', '2022-02-07 18:54:28');
INSERT INTO `xiaoniu_estate`.`tb_building`(`id`, `community_name`, `community_id`, `name`, `total_households`, `description`, `create_time`, `update_time`) VALUES (4, '百花小区', 3, 'A19', 51, '环境良好', '2022-02-07 18:54:28', '2022-02-07 18:54:28');
INSERT INTO `xiaoniu_estate`.`tb_building`(`id`, `community_name`, `community_id`, `name`, `total_households`, `description`, `create_time`, `update_time`) VALUES (5, '百花小区', 3, 'A20', 53, '卫生不错', '2022-02-07 18:54:28', '2022-02-07 18:54:28');
INSERT INTO `xiaoniu_estate`.`tb_building`(`id`, `community_name`, `community_id`, `name`, `total_households`, `description`, `create_time`, `update_time`) VALUES (6, '百花小区', 3, 'A21', 62, '文明', '2022-02-07 18:54:28', '2022-02-07 18:54:28');
INSERT INTO `xiaoniu_estate`.`tb_building`(`id`, `community_name`, `community_id`, `name`, `total_households`, `description`, `create_time`, `update_time`) VALUES (7, '百花小区', 3, 'A22', 100, '风景美好', '2022-02-07 18:54:28', '2022-02-07 18:54:28');
SELECT * FROM `tb_building`

    -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (1, '化纤小区', 1, 'A16', 1, 'HM20191213002', '金华小区A栋', 1, '张三', 1234567890, 4, 3, 22, '化纤小区欢迎您', '2022-02-07 21:25:12');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`,
                                        `floor`, `description`, `live_time`) VALUES (2, '百花小区', 3, 'A17', 2, 'HM20191213002', '金华小区A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (3, '百花小区', 3, 'A17', 2, 'HM20191213002', '金华小区A栋', 2, '李四', 166666666, 4, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:14');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (4, '百花小区', 3, 'A17', 2, 'HM20191213002', '金华小区A栋', 2, '李四', 166666666, 4, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:15');
SELECT * FROM `tb_house`;

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO `xiaoniu_estate`.`tb_owner`(`id`, `community_id`, `house_id`, `name`, `picture`, `idcard`, `telephone`, `profession`, `sex`, `type`, `remark`, `create_time`, `update_time`, `birthday`) VALUES (1, 1, 1, '张三', '/images/taa.jpg', '6100252256325625', 1234567890, '律师', '0', '0', '无', '2022-02-08 00:01:03', '2022-02-24 00:04:05', '2016-06-01 00:04:08');


INSERT INTO `xiaoniu_estate`.`tb_owner`(`id`, `community_id`, `house_id`, `name`, `picture`, `idcard`, `telephone`, `profession`, `sex`, `type`, `remark`, `create_time`, `update_time`, `birthday`) VALUES (2, 1, 2, '李四', '/images/tbb.jpg', '4114552561166446', 166666666, 'java工程师', '0', '0', '无', '2022-02-08 00:01:04', '2022-02-24 00:04:06', '2016-06-01 00:04:09');


INSERT INTO `xiaoniu_estate`.`tb_owner`(`id`, `community_id`, `house_id`, `name`, `picture`, `idcard`, `telephone`, `profession`, `sex`, `type`, `remark`, `create_time`, `update_time`, `birthday`) VALUES (3, 2, 3, '阳菜', '/fileupload/671a227c-3e16-436d-9a38-9aa7114a8767.jpg', '3566422154454548', 155555555, '画师', '1', '1', '无', '2022-02-08 00:01:05', '2022-02-24 00:04:06', '2019-10-01 00:00:08');
SELECT * FROM tb_owner;
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO `xiaoniu_estate`.`tb_car`(`id`, `picture`, `owner_id`, `color`, `car_number`, `remark`, `create_time`, `update_time`) VALUES (2, 'imags/tcc.jpg', 2, '橙色', '浙AAAAA', '666', '2022-02-08 16:23:42', '2022-02-08 16:24:55');
-----------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO `xiaoniu_estate`.`tb_pet`(`id`, `picture`, `owner_name`, `owner_id`, `name`, `color`, `remark`, `create_time`, `update_time`, `adopt_time`) VALUES (1, 'images/tdd.jpg', '张三', 1, '开开', '黄色', '可爱精灵鬼', '2022-02-09 18:50:58', '2022-02-16 18:51:01', '2022-02-23 18:51:03');

INSERT INTO `xiaoniu_estate`.`tb_pet`(`id`, `picture`, `owner_name`, `owner_id`, `name`, `color`, `remark`, `create_time`, `update_time`, `adopt_time`) VALUES (2, 'images/tee.jpg', '张三', 1, '米拉', '白色', '调皮', '2022-02-09 18:50:59', '2021-02-16 18:51:01', '2011-02-23 18:51:03');

INSERT INTO `xiaoniu_estate`.`tb_pet`(`id`, `picture`, `owner_name`, `owner_id`, `name`, `color`, `remark`, `create_time`, `update_time`, `adopt_time`) VALUES (3, 'images/trr.jpg', '李四', 2, '佩奇', '白黄', '调皮可爱', '2022-01-09 18:50:59', '2021-01-16 18:51:01', '2011-01-23 18:51:03');
------------------------------------------------------------------------------------------------------------------

INSERT INTO `xiaoniu_estate`.`tb_parking`(`id`, `community_name`, `community_id`, `code`, `name`, `create_time`, `update_time`, `status`) VALUES (1, '化纤小区', 1, 'XY20200103002', '一号车位', '2022-02-16 23:28:35', '2022-02-08 23:28:37', '1');


INSERT INTO `xiaoniu_estate`.`tb_parking`(`id`, `community_name`, `community_id`, `code`, `name`, `create_time`, `update_time`, `status`) VALUES (2, '东风小区', 2, 'XY20200103003', '二号车位', '2022-02-16 23:28:36', '2022-02-08 23:28:36', '0');

INSERT INTO `xiaoniu_estate`.`tb_parking`(`id`, `community_name`, `community_id`, `code`, `name`, `create_time`, `update_time`, `status`) VALUES (3, '百花小区', 3, 'XY20200103981', '三号车位', '2022-02-16 23:28:36', '2022-02-08 23:28:6', '1');


------------------------------------------------------------------------------------------------------------------

INSERT INTO `xiaoniu_estate`.`tb_parking_use`(`id`, `community_name`, `community_id`, `code`, `car_number`, `picture`, `owner_name`, `owner_id`, `telephone`, `use_type`, `total_fee`, `create_time`, `update_time`, `start_time`, `end_time`) VALUES (1, '化纤小区', 1, 'XY20200103002', '浙A3524D', NULL, '张三', 1, 1234567890, '0', 30000, '2022-02-09 03:22:01', '2022-02-25 03:20:48', '2022-02-24 03:20:43', '2022-02-16 03:20:51');


INSERT INTO `xiaoniu_estate`.`tb_parking_use`(`id`, `community_name`, `community_id`, `code`, `car_number`, `picture`, `owner_name`, `owner_id`, `telephone`, `use_type`, `total_fee`, `create_time`, `update_time`, `start_time`, `end_time`) VALUES (2, '化纤小区', 1, 'XY20200103001', '浙A2546', NULL, '李四', 2, 166666666, '1', 100, '2022-02-09 03:22:01', '2022-02-25 03:20:48', '2022-02-24 03:20:43', '2022-02-16 03:20:51');


INSERT INTO `xiaoniu_estate`.`tb_parking_use`(`id`, `community_name`, `community_id`, `code`, `car_number`, `picture`, `owner_name`, `owner_id`, `telephone`, `use_type`, `total_fee`, `create_time`, `update_time`, `start_time`, `end_time`) VALUES (3, '东风小区', 2, 'XY20200102111', '浙AAAAB', NULL, '李四', 2, 166666666, '2', 3000, '2022-02-09 03:22:01', '2022-02-25 03:20:48', '2022-02-24 03:20:43', '2022-02-16 03:20:51');

------------------------------------------------------------------------------------------------------------------
INSERT INTO `xiaoniu_estate`.`tb_activity`(`id`, `community_name`, `community_id`, `title`, `address`, `organizer`, `create_time`, `update_time`, `start_time`, `end_time`, `status`) VALUES (1, '东湖小区', 6, '元旦晚会', '东湖一号', '	东湖物业', '2022-02-09 04:18:07', '2022-02-09 04:17:59', '2022-02-10 04:18:02', '2022-02-09 04:18:05', '0');

INSERT INTO `xiaoniu_estate`.`tb_activity`(`id`, `community_name`, `community_id`, `title`, `address`, `organizer`, `create_time`, `update_time`, `start_time`, `end_time`, `status`) VALUES (2, '化纤小区', 1, '春节晚会', '化纤一号', '	化纤物业', '2022-02-09 04:18:07', '2022-02-09 04:17:59', '2022-02-10 04:18:02', '2022-02-09 04:18:05', '0');

INSERT INTO `xiaoniu_estate`.`tb_activity`(`id`, `community_name`, `community_id`, `title`, `address`, `organizer`, `create_time`, `update_time`, `start_time`, `end_time`, `status`) VALUES (3, '化纤小区', 1, '歌剧会', '化纤一号', '	化纤物业', '2022-02-09 04:18:07', '2022-02-09 04:17:59', '2022-02-10 04:18:02', '2022-02-09 04:18:05', '0');


INSERT INTO `xiaoniu_estate`.`tb_activity`(`id`, `community_name`, `community_id`, `title`, `address`, `organizer`, `create_time`, `update_time`, `start_time`, `end_time`, `status`) VALUES (4, '化纤小区', 1, '演唱会', '化纤一号', '	化纤物业', '2022-02-09 04:18:07', '2022-02-09 04:17:59', '2022-02-10 04:18:02', '2022-02-09 04:18:05', '0');

INSERT INTO `xiaoniu_estate`.`tb_activity`(`id`, `community_name`, `community_id`, `title`, `address`, `organizer`, `create_time`, `update_time`, `start_time`, `end_time`, `status`) VALUES (5, '东风小区', 2, '邻里才技擂台赛', '东风一号', '	东风物业', '2022-02-09 04:28:07', '2022-02-09 04:27:59', '2022-02-20 04:28:02', '2022-02-09 04:28:05', '0');

INSERT INTO `xiaoniu_estate`.`tb_activity`(`id`, `community_name`, `community_id`, `title`, `address`, `organizer`, `create_time`, `update_time`, `start_time`, `end_time`, `status`) VALUES (6, '东风小区', 2, '广场邻里情', '东风一号', '	东风物业', '2022-02-09 04:28:07', '2022-02-09 04:27:59', '2022-02-20 04:28:02', '2022-02-09 04:28:05', '0');


INSERT INTO `xiaoniu_estate`.`tb_activity`(`id`, `community_name`, `community_id`, `title`, `address`, `organizer`, `create_time`, `update_time`, `start_time`, `end_time`, `status`) VALUES (7, '东风小区', 2, '悦动金秋', '东风一号', '	东风物业', '2022-02-09 04:28:07', '2022-02-09 04:27:59', '2022-02-20 04:28:02', '2022-02-09 04:28:05', '0');


INSERT INTO `xiaoniu_estate`.`tb_repair`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `owner_name`, `owner_id`, `device_name`, `device_id`, `description`, `create_time`, `update_time`, `status`) VALUES (1, '化纤小区', 1, 'A16', 1, '张三', 1, '垃圾桶', 1, '垃圾桶更换', '2022-02-09 18:05:23', '0000-00-00 00:00:00', '0');

INSERT INTO `xiaoniu_estate`.`tb_repair`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `owner_name`, `owner_id`, `device_name`, `device_id`, `description`, `create_time`, `update_time`, `status`) VALUES (2, '百花小区',3, 'A17', 2, '李四', 2, '摄像头', 2, '摄像头维修', '2022-02-09 18:05:23', '2022-02-09 18:07:36', '1');
INSERT INTO `xiaoniu_estate`.`tb_repair`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `owner_name`, `owner_id`, `device_name`, `device_id`, `description`, `create_time`, `update_time`, `status`) VALUES (3, '百花小区',3, 'A18', 3, '阳菜', 3, '摄像头', 3, '摄像头维修', '2022-02-09 18:05:23', '2022-02-09 18:07:36', '0');

INSERT INTO `xiaoniu_estate`.`tb_complaint`(`id`, `community_name`, `community_id`, `owner_id`, `owner_name`, `description`, `reason`, `create_time`, `update_time`, `status`) VALUES (1, '化纤小区', 1, 1, '张三', '垃圾桶', '垃圾桶爆满', '2022-02-09 18:54:22', '2022-02-09 18:54:20', '0');

INSERT INTO `xiaoniu_estate`.`tb_complaint`(`id`, `community_name`, `community_id`, `owner_id`, `owner_name`, `description`, `reason`, `create_time`, `update_time`, `status`) VALUES (2, '化纤小区', 1, 1, '张三', '监控器有问题', '监控损坏', '2022-02-09 18:54:22', '2022-02-09 18:54:20', '0');


INSERT INTO `xiaoniu_estate`.`tb_complaint`(`id`, `community_name`, `community_id`, `owner_id`, `owner_name`, `description`, `reason`, `create_time`, `update_time`, `status`) VALUES (3, '化纤小区', 1, 1, '张三', '排水问题', '排水系统故障', '2022-02-09 18:54:22', '2022-02-09 18:54:20', '0');

INSERT INTO `xiaoniu_estate`.`tb_letter`(`id`, `community_id`, `community_name`, `owner_id`, `owner_name`, `origin`, `title`, `content`, `create_time`, `update_time`, `status`) VALUES (1, 1, '化纤小区', 1, '张三', '0', '垃圾箱炸了', '垃圾箱爆炸了速度修', '2022-02-09 19:20:27', '2022-02-10 19:21:33', '0');

INSERT INTO `xiaoniu_estate`.`tb_letter`(`id`, `community_id`, `community_name`, `owner_id`, `owner_name`, `origin`, `title`, `content`, `create_time`, `update_time`, `status`) VALUES (2, 1, '化纤小区', 1, '张三', '1', '**垃圾箱********', '垃圾箱爆********速度修', '2022-02-09 19:20:27', '2022-02-10 19:21:33', '1');

INSERT INTO `xiaoniu_estate`.`tb_letter`(`id`, `community_id`, `community_name`, `owner_id`, `owner_name`, `origin`, `title`, `content`, `create_time`, `update_time`, `status`) VALUES (3, 1, '化纤小区', 1, '张三', '2', '摄像头坏了', '摄像头有点问题', '2022-02-09 19:20:27', '2022-02-10 19:21:33', '1');


INSERT INTO `xiaoniu_estate`.`tb_letter`(`id`, `community_id`, `community_name`, `owner_id`, `owner_name`, `origin`, `title`, `content`, `create_time`, `update_time`, `status`) VALUES (4, 1, '化纤小区', 1, '张三', '3', '停车场漏水', '停车场漏大水', '2022-02-09 19:20:27', '2022-02-10 19:21:33', '1');


INSERT INTO `xiaoniu_estate`.`tb_letter`(`id`, `community_id`, `community_name`, `owner_id`, `owner_name`, `origin`, `title`, `content`, `create_time`, `update_time`, `status`) VALUES (5, 1, '化纤小区', 1, '张三', '4', '帮忙灯坏了', 'A17楼灯坏了', '2022-02-09 19:20:27', '2022-02-10 19:21:33', '1');


INSERT INTO `xiaoniu_estate`.`tb_device`(`id`, `community_name`, `community_id`, `code`, `name`, `brand`, `unit_price`, `num`, `expected_useful_life`, `create_time`, `update_time`, `purchase_date`) VALUES (1, '化纤小区', 1, 'CJ20200105002', '大疆无人机', '大疆', 1000, 1, 5, '2022-02-09 19:58:37', '2022-02-16 19:58:30', '2020-01-05 00:00:00');

INSERT INTO `xiaoniu_estate`.`tb_device`(`id`, `community_name`, `community_id`, `code`, `name`, `brand`, `unit_price`, `num`, `expected_useful_life`, `create_time`, `update_time`, `purchase_date`) VALUES (2, '化纤小区', 1, 'AX20200105002', '海尔空调', '海尔', 2000, 1, 10, '2022-02-09 19:58:37', '2022-02-16 19:58:30', '2020-01-05 00:00:00');

INSERT INTO `xiaoniu_estate`.`tb_device`(`id`, `community_name`, `community_id`, `code`, `name`, `brand`, `unit_price`, `num`, `expected_useful_life`, `create_time`, `update_time`, `purchase_date`) VALUES (3, '东风小区', 2, 'AJ20200105002', '汉斯顿净水机', '汉斯顿', 1500, 2, 4, '2022-02-09 19:58:37', '2022-02-16 19:58:30', '2020-01-05 00:00:00');

INSERT INTO `xiaoniu_estate`.`tb_device`(`id`, `community_name`, `community_id`, `code`, `name`, `brand`, `unit_price`, `num`, `expected_useful_life`, `create_time`, `update_time`, `purchase_date`) VALUES (4, '东风小区', 2, 'BJ20200105002', '格力净水机', '格力', 3000, 1, 2, '2022-02-09 19:58:37', '2022-02-16 19:58:30', '2020-01-05 00:00:00');

INSERT INTO `xiaoniu_estate`.`tb_charge_item`(`id`, `community_id`, `community_name`, `code`, `name`, `create_time`, `update_time`, `money`) VALUES (1, 1, '化纤小区', 'EP20200105002', '电梯广告位', '2022-02-09 20:30:23', '2022-03-04 20:31:16', 2000);

INSERT INTO `xiaoniu_estate`.`tb_charge_item`(`id`, `community_id`, `community_name`, `code`, `name`, `create_time`, `update_time`, `money`) VALUES (2, 1, '化纤小区', 'EP20200105001', '停车位', '2022-02-09 20:30:23', '2022-03-04 20:31:16', 2000);

INSERT INTO `xiaoniu_estate`.`tb_charge_item`(`id`, `community_id`, `community_name`, `code`, `name`, `create_time`, `update_time`, `money`) VALUES (3, 1, '化纤小区', 'EP20200105003', '楼梯', '2022-02-09 20:30:23', '2022-03-04 20:31:16', 2000);

INSERT INTO `xiaoniu_estate`.`tb_charge_item`(`id`, `community_id`, `community_name`, `code`, `name`, `create_time`, `update_time`, `money`) VALUES (4, 1, '化纤小区', 'EP20200105004', '门卫', '2022-02-09 20:30:23', '2022-03-04 20:31:16', 2000);

INSERT INTO `xiaoniu_estate`.`tb_charge_item`(`id`, `community_id`, `community_name`, `code`, `name`, `create_time`, `update_time`, `money`) VALUES (5, 1, '化纤小区', 'EP20200105005', '小区门口', '2022-02-09 20:30:23', '2022-03-04 20:31:16', 2000);

INSERT INTO `xiaoniu_estate`.`tb_charge_detail`(`id`, `community_id`, `community_name`, `charge_item_id`, `charge_item_name`, `contractor`, `telephone`, `pay_money`, `actual_money`, `create_time`, `update_time`, `pay_time`, `status`) VALUES (2, 1, '化纤小区', 2, '停车位', '六子', 154345434, 500, 200, '2022-02-09 20:55:49', '2022-01-31 20:55:17', '2022-02-01', '0');

INSERT INTO `xiaoniu_estate`.`tb_charge_detail`(`id`, `community_id`, `community_name`, `charge_item_id`, `charge_item_name`, `contractor`, `telephone`, `pay_money`, `actual_money`, `create_time`, `update_time`, `pay_time`, `status`) VALUES (3, 1, '化纤小区', 3, '楼梯广告位', '六子', 154345434, 600, 100, '2022-02-09 20:55:49', '2022-01-31 20:55:17', '2022-02-10', '0');

CREATE table tb_estate_manager_power(id int ,power_rule varchar(200),power_name varchar(200),rank1 VARCHAR(200),time TIMESTAMP,status VARCHAR(200));
INSERT INTO `xiaoniu_estate`.`tb_estate_manager_power`(`id`, `power_rule`, `power_name`, `rank1`, `time`, `status`) VALUES (1, 'System/lst', '系统设置', '1级', '2019-08-30 21:32:53', '0');
INSERT INTO `xiaoniu_estate`.`tb_estate_manager_power`(`id`, `power_rule`, `power_name`, `rank1`, `time`, `status`) VALUES (2, 'System/lst', '系统设置', '1级', '2019-08-30 21:32:53', '0');
INSERT INTO `xiaoniu_estate`.`tb_estate_manager_power`(`id`, `power_rule`, `power_name`, `rank1`, `time`, `status`) VALUES (3, 'System/edit', '基础设置操作', '1级', '2019-08-30 21:32:53', '0');
INSERT INTO `xiaoniu_estate`.`tb_estate_manager_power`(`id`, `power_rule`, `power_name`, `rank1`, `time`, `status`) VALUES (4, 'Link/add', '友情链接添加修改	', '1级', '2019-08-30 21:32:53', '0');
INSERT INTO `xiaoniu_estate`.`tb_estate_manager_power`(`id`, `power_rule`, `power_name`, `rank1`, `time`, `status`) VALUES (5, 'Link/link_del', '友情链接删除', '3级', '2019-08-30 21:32:53', '0');
INSERT INTO `xiaoniu_estate`.`tb_estate_manager_power`(`id`, `power_rule`, `power_name`, `rank1`, `time`, `status`) VALUES (6, 'Link/add', '友情链接添加修改	', '5级', '2019-08-30 21:32:53', '0');
INSERT INTO `xiaoniu_estate`.`tb_estate_manager_power`(`id`, `power_rule`, `power_name`, `rank1`, `time`, `status`) VALUES (7, 'Link/start', '友情链接审核', '4级', '2019-08-30 21:32:53', '1');
INSERT INTO `xiaoniu_estate`.`tb_estate_manager_power`(`id`, `power_rule`, `power_name`, `rank1`, `time`, `status`) VALUES (8, 'Link/state', '友情链接状态操作', '1级', '2019-08-30 21:32:53', '0');
INSERT INTO `xiaoniu_estate`.`tb_estate_manager_power`(`id`, `power_rule`, `power_name`, `rank1`, `time`, `status`) VALUES (9, 'Admin/lst', '管理员管理', '1级', '2019-08-30 21:32:53', '1');
INSERT INTO `xiaoniu_estate`.`tb_estate_manager_power`(`id`, `power_rule`, `power_name`, `rank1`, `time`, `status`) VALUES (10, 'Admin/add', '管理员添加修改', '2级', '2019-08-30 21:32:53', '0');
INSERT INTO `xiaoniu_estate`.`tb_estate_manager_power`(`id`, `power_rule`, `power_name`, `rank1`, `time`, `status`) VALUES (11, 'Admin/del', '管理员删除', '3级', '2019-08-30 21:32:53', '1');


INSERT INTO `xiaoniu_estate`.`tb_building`(`id`, `community_name`, `community_id`, `name`, `total_households`, `description`, `create_time`, `update_time`) VALUES (9, '东风小区', 2, '24栋', 60, '这边人都素质很好', '2022-02-10 05:13:07', '2022-02-25 05:13:55');
INSERT INTO `xiaoniu_estate`.`tb_building`(`id`, `community_name`, `community_id`, `name`, `total_households`, `description`, `create_time`, `update_time`) VALUES (10, '东风小区', 2, '25栋', 52, '这边人都素质很好', '2022-02-10 05:13:07', '2022-02-25 05:13:55');

INSERT INTO `xiaoniu_estate`.`tb_building`(`id`, `community_name`, `community_id`, `name`, `total_households`, `description`, `create_time`, `update_time`) VALUES (11, '东风小区', 2, '26栋', 60, '这边人都素质很好', '2022-02-10 05:13:07', '2022-02-25 05:13:55');

INSERT INTO `xiaoniu_estate`.`tb_building`(`id`, `community_name`, `community_id`, `name`, `total_households`, `description`, `create_time`, `update_time`) VALUES (12, '东风小区', 2, '27栋', 60, '这边人都素质很好', '2022-02-10 05:13:07', '2022-02-25 05:13:55');

INSERT INTO `xiaoniu_estate`.`tb_building`(`id`, `community_name`, `community_id`, `name`, `total_households`, `description`, `create_time`, `update_time`) VALUES (13, '东风小区', 2, '28栋', 60, '这边人都素质很好', '2022-02-10 05:13:07', '2022-02-25 05:13:55');

INSERT INTO `xiaoniu_estate`.`tb_building`(`id`, `community_name`, `community_id`, `name`, `total_households`, `description`, `create_time`, `update_time`) VALUES (14, '东风小区', 2, '29栋', 60, '这边人都素质很好', '2022-02-10 05:13:07', '2022-02-25 05:13:55');

INSERT INTO `xiaoniu_estate`.`tb_building`(`id`, `community_name`, `community_id`, `name`, `total_households`, `description`, `create_time`, `update_time`) VALUES (15, '东风小区', 2, '30栋', 60, '这边人都素质很好', '2022-02-10 05:13:07', '2022-02-25 05:13:55');
INSERT INTO `xiaoniu_estate`.`tb_building`(`id`, `community_name`, `community_id`, `name`, `total_households`, `description`, `create_time`, `update_time`) VALUES (16, '东风小区', 2, '31栋', 60, '这边人都素质很好', '2022-02-10 05:13:07', '2022-02-25 05:13:55');
INSERT INTO `xiaoniu_estate`.`tb_building`(`id`, `community_name`, `community_id`, `name`, `total_households`, `description`, `create_time`, `update_time`) VALUES (17, '东风小区', 2, '32栋', 60, '这边人都素质很好', '2022-02-10 05:13:07', '2022-02-25 05:13:55');
INSERT INTO `xiaoniu_estate`.`tb_building`(`id`, `community_name`, `community_id`, `name`, `total_households`, `description`, `create_time`, `update_time`) VALUES (18, '东风小区', 2, '33栋', 60, '这边人都素质很好', '2022-02-10 05:13:07', '2022-02-25 05:13:55');

INSERT INTO `xiaoniu_estate`.`tb_building`(`id`, `community_name`, `community_id`, `name`, `total_households`, `description`, `create_time`, `update_time`) VALUES (19, '东风小区', 2, '34栋', 60, '这边人都素质很好', '2022-02-10 05:13:07', '2022-02-25 05:13:55');

INSERT INTO `xiaoniu_estate`.`tb_building`(`id`, `community_name`, `community_id`, `name`, `total_households`, `description`, `create_time`, `update_time`) VALUES (20, '东风小区', 2, '35栋', 60, '这边人都素质很好', '2022-02-10 05:13:07', '2022-02-25 05:13:55');
INSERT INTO `xiaoniu_estate`.`tb_building`(`id`, `community_name`, `community_id`, `name`, `total_households`, `description`, `create_time`, `update_time`) VALUES (21, '东风小区', 2, '36栋', 60, '这边人都素质很好', '2022-02-10 05:13:07', '2022-02-25 05:13:55');
INSERT INTO `xiaoniu_estate`.`tb_building`(`id`, `community_name`, `community_id`, `name`, `total_households`, `description`, `create_time`, `update_time`) VALUES (22, '东风小区', 2, '37栋', 60, '这边人都素质很好', '2022-02-10 05:13:07', '2022-02-25 05:13:55');




INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (5, '百花小区', 3, 'B19', 2, 'HM20191213002', 'B栋', 2, '李四', 166666666, 4, 6, 22, '百花小区欢迎您', '2022-02-07 21:25:15');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (6, '百花小区', 3, 'B19', 2, 'HM20191213002', 'B栋', 2, '李四', 166666666, 4, 6, 22, '百花小区欢迎您', '2022-02-07 21:25:15');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (7, '百花小区', 3, 'B19', 2, 'HM20191213002', 'B栋', 2, '李四', 166666666, 4, 6, 22, '百花小区欢迎您', '2022-02-07 21:25:15');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (8, '百花小区', 3, 'B19', 2, 'HM20191213002', 'B栋', 2, '李四', 166666666, 4, 6, 22, '百花小区欢迎您', '2022-02-07 21:25:15');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (9, '百花小区', 3, 'B19', 2, 'HM20191213002', 'B栋', 2, '李四', 166666666, 4, 6, 22, '百花小区欢迎您', '2022-02-07 21:25:15');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (10, '百花小区', 3, 'B19', 2, 'HM20191213002', 'B栋', 2, '李四', 166666666, 4, 6, 22, '百花小区欢迎您', '2022-02-07 21:25:15');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (11, '百花小区', 3, 'B19', 2, 'HM20191213002', 'B栋', 2, '李四', 166666666, 4, 6, 22, '百花小区欢迎您', '2022-02-07 21:25:15');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (12, '百花小区', 3, 'B19', 2, 'HM20191213002', 'B栋', 2, '李四', 166666666, 4, 6, 22, '百花小区欢迎您', '2022-02-07 21:25:15');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (13, '百花小区', 3, 'B19', 2, 'HM20191213002', 'B栋', 2, '李四', 166666666, 4, 6, 22, '百花小区欢迎您', '2022-02-07 21:25:15');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (14, '百花小区', 3, 'B19', 2, 'HM20191213002', 'B栋', 2, '李四', 166666666, 4, 6, 22, '百花小区欢迎您', '2022-02-07 21:25:15');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (15, '百花小区', 3, 'B19', 2, 'HM20191213002', 'B栋', 2, '李四', 166666666, 4, 6, 22, '百花小区欢迎您', '2022-02-07 21:25:15');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (16, '百花小区', 3, 'B19', 2, 'HM20191213002', 'B栋', 2, '李四', 166666666, 4, 6, 22, '百花小区欢迎您', '2022-02-07 21:25:15');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (17, '百花小区', 3, 'B19', 2, 'HM20191213002', 'B栋', 2, '李四', 166666666, 4, 6, 22, '百花小区欢迎您', '2022-02-07 21:25:15');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (18, '百花小区', 3, 'B19', 2, 'HM20191213002', 'B栋', 2, '李四', 166666666, 4, 6, 22, '百花小区欢迎您', '2022-02-07 21:25:15');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (19, '百花小区', 3, 'B19', 2, 'HM20191213002', 'B栋', 2, '李四', 166666666, 4, 6, 22, '百花小区欢迎您', '2022-02-07 21:25:15');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (20, '百花小区', 3, 'B19', 2, 'HM20191213002', 'B栋', 2, '李四', 166666666, 4, 6, 22, '百花小区欢迎您', '2022-02-07 21:25:15');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (21, '百花小区', 3, 'B19', 2, 'HM20191213002', 'B栋', 2, '李四', 166666666, 4, 6, 22, '百花小区欢迎您', '2022-02-07 21:25:15');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (22, '百花小区', 3, 'B19', 2, 'HM20191213002', 'B栋', 2, '李四', 166666666, 4, 6, 22, '百花小区欢迎您', '2022-02-07 21:25:15');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (23, '百花小区', 3, 'B19', 2, 'HM20191213002', 'B栋', 2, '李四', 166666666, 4, 6, 22, '百花小区欢迎您', '2022-02-07 21:25:15');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (24, '百花小区', 3, 'B19', 2, 'HM20191213002', 'B栋', 2, '李四', 166666666, 4, 6, 22, '百花小区欢迎您', '2022-02-07 21:25:15');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (26, '百花小区', 3, 'B19', 2, 'HM20191213002', 'B栋', 2, '李四', 166666666, 4, 6, 22, '百花小区欢迎您', '2022-02-07 21:25:15');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (27, '百花小区', 3, 'B19', 2, 'HM20191213002', 'B栋', 2, '李四', 166666666, 4, 6, 22, '百花小区欢迎您', '2022-02-07 21:25:15');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (28, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (29, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (30, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (31, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (32, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (33, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (34, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (35, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (36, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (37, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (38, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (39, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (40, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (41, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (42, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (43, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (44, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (45, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (46, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (47, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (48, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (49, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (50, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (51, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (52, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (53, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (54, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (55, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (56, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (57, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (58, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (59, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (60, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (61, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (62, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (63, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (64, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (65, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (66, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (67, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (68, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (69, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (70, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (71, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');
INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (72, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');

INSERT INTO `xiaoniu_estate`.`tb_house`(`id`, `community_name`, `community_id`, `building_name`, `building_id`, `code`, `name`, `owner_id`, `owner_name`, `telephone`, `room_num`, `unit`, `floor`, `description`, `live_time`) VALUES (73, '百花小区', 3, 'A17', 2, 'HM20191213002', 'A栋', 1, '张三', 1234567890, 5, 3, 22, '百花小区欢迎您', '2022-02-07 21:25:13');


INSERT INTO `xiaoniu_estate`.`tb_owner`( `community_id`, `house_id`, `name`, `picture`, `idcard`, `telephone`, `profession`, `sex`, `type`, `remark`, `create_time`, `update_time`, `birthday`, `community_name`, `total_households`, `description`, `house_name`) VALUES ( 1, 1, '张三', '/images/taa.jpg', '6100252256325625', 1234567890, '律师', '0', '0', '无', '2022-02-08 00:01:03', '2022-02-24 00:04:05', '2016-06-01 00:04:08', '化纤小区', 66, '你犯法了知道不', 'A栋');



INSERT INTO `xiaoniu_estate`.`tb_owner`( `community_id`, `house_id`, `name`, `picture`, `idcard`, `telephone`, `profession`, `sex`, `type`, `remark`, `create_time`, `update_time`, `birthday`, `community_name`, `total_households`, `description`, `house_name`) VALUES ( 1, 1, '张三', '/images/taa.jpg', '6100252256325625', 1234567890, '律师', '0', '0', '无', '2022-02-08 00:01:03', '2022-02-24 00:04:05', '2016-06-01 00:04:08', '化纤小区', 66, '你犯法了知道不', 'A栋');
INSERT INTO `xiaoniu_estate`.`tb_owner`( `community_id`, `house_id`, `name`, `picture`, `idcard`, `telephone`, `profession`, `sex`, `type`, `remark`, `create_time`, `update_time`, `birthday`, `community_name`, `total_households`, `description`, `house_name`) VALUES ( 1, 1, '张三', '/images/taa.jpg', '6100252256325625', 1234567890, '律师', '0', '0', '无', '2022-02-08 00:01:03', '2022-02-24 00:04:05', '2016-06-01 00:04:08', '化纤小区', 66, '你犯法了知道不', 'A栋');
INSERT INTO `xiaoniu_estate`.`tb_owner`( `community_id`, `house_id`, `name`, `picture`, `idcard`, `telephone`, `profession`, `sex`, `type`, `remark`, `create_time`, `update_time`, `birthday`, `community_name`, `total_households`, `description`, `house_name`) VALUES ( 1, 1, '张三', '/images/taa.jpg', '6100252256325625', 1234567890, '律师', '0', '0', '无', '2022-02-08 00:01:03', '2022-02-24 00:04:05', '2016-06-01 00:04:08', '化纤小区', 66, '你犯法了知道不', 'A栋');
INSERT INTO `xiaoniu_estate`.`tb_owner`( `community_id`, `house_id`, `name`, `picture`, `idcard`, `telephone`, `profession`, `sex`, `type`, `remark`, `create_time`, `update_time`, `birthday`, `community_name`, `total_households`, `description`, `house_name`) VALUES ( 1, 1, '张三', '/images/taa.jpg', '6100252256325625', 1234567890, '律师', '0', '0', '无', '2022-02-08 00:01:03', '2022-02-24 00:04:05', '2016-06-01 00:04:08', '化纤小区', 66, '你犯法了知道不', 'A栋');
INSERT INTO `xiaoniu_estate`.`tb_owner`( `community_id`, `house_id`, `name`, `picture`, `idcard`, `telephone`, `profession`, `sex`, `type`, `remark`, `create_time`, `update_time`, `birthday`, `community_name`, `total_households`, `description`, `house_name`) VALUES ( 1, 1, '张三', '/images/taa.jpg', '6100252256325625', 1234567890, '律师', '0', '0', '无', '2022-02-08 00:01:03', '2022-02-24 00:04:05', '2016-06-01 00:04:08', '化纤小区', 66, '你犯法了知道不', 'A栋');
INSERT INTO `xiaoniu_estate`.`tb_owner`( `community_id`, `house_id`, `name`, `picture`, `idcard`, `telephone`, `profession`, `sex`, `type`, `remark`, `create_time`, `update_time`, `birthday`, `community_name`, `total_households`, `description`, `house_name`) VALUES ( 1, 1, '张三', '/images/taa.jpg', '6100252256325625', 1234567890, '律师', '0', '0', '无', '2022-02-08 00:01:03', '2022-02-24 00:04:05', '2016-06-01 00:04:08', '化纤小区', 66, '你犯法了知道不', 'A栋');
INSERT INTO `xiaoniu_estate`.`tb_owner`( `community_id`, `house_id`, `name`, `picture`, `idcard`, `telephone`, `profession`, `sex`, `type`, `remark`, `create_time`, `update_time`, `birthday`, `community_name`, `total_households`, `description`, `house_name`) VALUES ( 1, 1, '张三', '/images/taa.jpg', '6100252256325625', 1234567890, '律师', '0', '0', '无', '2022-02-08 00:01:03', '2022-02-24 00:04:05', '2016-06-01 00:04:08', '化纤小区', 66, '你犯法了知道不', 'A栋');
INSERT INTO `xiaoniu_estate`.`tb_owner`( `community_id`, `house_id`, `name`, `picture`, `idcard`, `telephone`, `profession`, `sex`, `type`, `remark`, `create_time`, `update_time`, `birthday`, `community_name`, `total_households`, `description`, `house_name`) VALUES ( 1, 1, '张三', '/images/taa.jpg', '6100252256325625', 1234567890, '律师', '0', '0', '无', '2022-02-08 00:01:03', '2022-02-24 00:04:05', '2016-06-01 00:04:08', '化纤小区', 66, '你犯法了知道不', 'A栋');
INSERT INTO `xiaoniu_estate`.`tb_owner`( `community_id`, `house_id`, `name`, `picture`, `idcard`, `telephone`, `profession`, `sex`, `type`, `remark`, `create_time`, `update_time`, `birthday`, `community_name`, `total_households`, `description`, `house_name`) VALUES ( 1, 1, '张三', '/images/taa.jpg', '6100252256325625', 1234567890, '律师', '0', '0', '无', '2022-02-08 00:01:03', '2022-02-24 00:04:05', '2016-06-01 00:04:08', '化纤小区', 66, '你犯法了知道不', 'A栋');




INSERT INTO `xiaoniu_estate`.`tb_repair`( `community_name`, `community_id`, `building_name`, `building_id`, `owner_name`, `owner_id`, `device_name`, `device_id`, `description`, `create_time`, `update_time`, `status`) VALUES ('百花小区', 3, 'A19', 3, '阳菜', 3, '墙壁', 3, '定期清洗外墙', '2022-02-14 05:04:33', '2022-03-12 18:07:36', '2');

INSERT INTO `xiaoniu_estate`.`tb_repair`( `community_name`, `community_id`, `building_name`, `building_id`, `owner_name`, `owner_id`, `device_name`, `device_id`, `description`, `create_time`, `update_time`, `status`) VALUES ('百花小区', 3, 'A19', 3, '阳菜', 3, '水源', 3, '水箱盖上锁并定期清洗消毒，确保水质合格', '2022-02-14 05:04:33', '2022-03-12 18:07:36', '2');

INSERT INTO `xiaoniu_estate`.`tb_repair`( `community_name`, `community_id`, `building_name`, `building_id`, `owner_name`, `owner_id`, `device_name`, `device_id`, `description`, `create_time`, `update_time`, `status`) VALUES ('百花小区', 3, 'A19', 3, '阳菜', 3, '电梯', 3, '电梯养护、运行、维护', '2022-02-14 05:04:33', '2022-03-12 18:07:36', '2');


INSERT INTO `xiaoniu_estate`.`tb_repair`( `community_name`, `community_id`, `building_name`, `building_id`, `owner_name`, `owner_id`, `device_name`, `device_id`, `description`, `create_time`, `update_time`, `status`) VALUES ('百花小区', 3, 'A20', 3, '阳菜', 3, '健身器材', 3, '健身器材维修', '2022-02-14 05:04:33', '2022-03-12 18:07:36', '2');


INSERT INTO `xiaoniu_estate`.`tb_repair`( `community_name`, `community_id`, `building_name`, `building_id`, `owner_name`, `owner_id`, `device_name`, `device_id`, `description`, `create_time`, `update_time`, `status`) VALUES ('百花小区', 3, 'A20', 3, '阳菜', 3, '椅子', 3, '椅子维修', '2022-02-14 05:04:33', '2022-03-12 18:07:36', '2');




INSERT INTO `xiaoniu_estate`.`tb_repair`( `community_name`, `community_id`, `building_name`, `building_id`, `owner_name`, `owner_id`, `device_name`, `device_id`, `description`, `create_time`, `update_time`, `status`) VALUES ('百花小区', 3, 'A20', 3, '阳菜', 3, '绿化', 3, '绿化养护', '2022-02-14 05:04:33', '2019-03-12 18:07:36', '2');






