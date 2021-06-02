/*
Navicat MySQL Data Transfer

Source Server         : oyid
Source Server Version : 50151
Source Host           : localhost:3306
Source Database       : jianyi

Target Server Type    : MYSQL
Target Server Version : 50151
File Encoding         : 65001

Date: 2018-02-06 10:19:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_order
-- ----------------------------
DROP TABLE IF EXISTS `user_order`;
CREATE TABLE `user_order` (
  `goods_length` double DEFAULT NULL COMMENT '货物长度',
  `goods_width` double DEFAULT NULL COMMENT '货物宽度',
  `goods_height` double DEFAULT NULL COMMENT '货物高度',
  `actual_weight` double DEFAULT NULL COMMENT '实际重量',
  `banlance_weight` double DEFAULT NULL COMMENT '结算重量',
  `volume` varchar(255) DEFAULT NULL COMMENT '体积',
  `max_length` double DEFAULT NULL COMMENT '最大长度',
  `packing_type` char(1) DEFAULT NULL COMMENT '包装类型',
  `num` int(11) DEFAULT NULL COMMENT '件数',
  `distribution_way` varchar(255) DEFAULT NULL COMMENT '分拨方式',
  `item_name` varchar(255) DEFAULT NULL COMMENT '物品名称',
  `receipt` char(1) DEFAULT NULL COMMENT '回单',
  `over_length` char(1) DEFAULT NULL COMMENT '超长件',
  `over_weight` char(1) DEFAULT NULL COMMENT '超重件',
  `over_weight_num` int(11) DEFAULT NULL COMMENT '超重数量',
  `goods_type` char(1) DEFAULT NULL COMMENT '货物类型',
  `declared_value` varchar(255) DEFAULT NULL COMMENT '声明价值',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `mailing_user_id` int(11) DEFAULT NULL COMMENT '寄件人id',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `packing_num` int(11) DEFAULT NULL COMMENT '包装件数',
  `order_num` varchar(50) DEFAULT NULL COMMENT '运单号码',
  `mailing_time` datetime DEFAULT NULL COMMENT '寄件时间',
  `mailing_state` varchar(255) DEFAULT NULL COMMENT '寄件网点',
  `destination` varchar(255) DEFAULT NULL COMMENT '目的地',
  `receiving_clerk` varchar(255) DEFAULT NULL COMMENT '收件业务员',
  `shiping_type` char(1) DEFAULT NULL COMMENT '运输方式',
  `service_type` char(1) DEFAULT NULL,
  `next_station` varchar(255) DEFAULT NULL COMMENT '直发下一站',
  `record_msg` varchar(255) DEFAULT NULL COMMENT '录单发短信',
  `sign_msg` varchar(255) DEFAULT NULL COMMENT '签收发短信',
  `delivery` char(1) DEFAULT NULL COMMENT '派送',
  `since` char(1) DEFAULT NULL COMMENT '自提',
  `coll_user_id` int(11) DEFAULT NULL COMMENT '收件人id',
  `receipt2` varchar(255) DEFAULT NULL COMMENT '回单2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
