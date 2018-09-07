/*
Target Server Type    : ORACLE
Author: SunKuan
Date: 2018-05-13 23:32:31
*/

---------------------------------------------------------------------------
-- ----------------------------
-- Table structure for e_address
-- ----------------------------
CREATE SEQUENCE seq_eaddressid;
CREATE TABLE e_address (
id NUMBER(10) NOT NULL PRIMARY KEY ,
userid NUMBER(10) NOT NULL ,
name VARCHAR2(40) NOT NULL ,
phone VARCHAR2(20) NOT NULL ,
info VARCHAR2(255) NOT NULL 
);

COMMENT ON COLUMN e_address.id IS '地址编号';
COMMENT ON COLUMN e_address.userid IS '用户编号';
COMMENT ON COLUMN e_address.name IS '收货人姓名';
COMMENT ON COLUMN e_address.phone IS '收货人电话';
COMMENT ON COLUMN e_address.info IS '收货人详细地址信息';

-- ----------------------------
-- Records of e_address
-- ----------------------------
---------------------------------------------------------------------------
-- ----------------------------
-- Table structure for e_book
-- ----------------------------
CREATE SEQUENCE seq_ebookid;
CREATE TABLE e_book (
id NUMBER(10) NOT NULL PRIMARY KEY ,
categoryid NUMBER(10) NOT NULL ,
name VARCHAR2(40) NOT NULL ,
price NUMBER(10,2) NOT NULL ,
state NUMBER(1) DEFAULT 0  NOT NULL 
);
COMMENT ON COLUMN e_book.id IS '书籍编号';
COMMENT ON COLUMN e_book.categoryid IS '分类编号';
COMMENT ON COLUMN e_book.name IS '书籍名称';
COMMENT ON COLUMN e_book.price IS '书籍价格';
COMMENT ON COLUMN e_book.state IS '是否为推荐书籍。0为否，1为是';

-- ----------------------------
-- Records of e_book
-- ----------------------------
---------------------------------------------------------------------------
-- ----------------------------
-- Table structure for e_category
-- ----------------------------
CREATE SEQUENCE seq_ecategoryid;
CREATE TABLE e_category (
id NUMBER(10) NOT NULL PRIMARY KEY ,
name VARCHAR2(40) NOT NULL ,
info VARCHAR2(255) NULL 
);
COMMENT ON COLUMN e_category.id IS '类型编号';
COMMENT ON COLUMN e_category.name IS '类别名称';
COMMENT ON COLUMN e_category.info IS '类别描述';

-- ----------------------------
-- Records of e_category
-- ----------------------------
---------------------------------------------------------------------------
-- ----------------------------
-- Table structure for e_order
-- ----------------------------
CREATE SEQUENCE seq_eorderid;
CREATE TABLE e_order (
id NUMBER(10) NOT NULL PRIMARY KEY ,
userid NUMBER(10) NOT NULL ,
addressid NUMBER(10) NOT NULL ,
total NUMBER(10,2) NOT NULL ,
odate DATE NOT NULL ,
state NUMBER(1) DEFAULT 1  NOT NULL 
);
COMMENT ON COLUMN e_order.id IS '订单编号';
COMMENT ON COLUMN e_order.userid IS '用户编号';
COMMENT ON COLUMN e_order.addressid IS '地址编号';
COMMENT ON COLUMN e_order.total IS '订单总金额';
COMMENT ON COLUMN e_order.odate IS '订单创建时间';
COMMENT ON COLUMN e_order.state IS '订单状态（1代表未发货，2代表已发货，0代表废单）';

-- ----------------------------
-- Records of e_order
-- ----------------------------
---------------------------------------------------------------------------
-- ----------------------------
-- Table structure for e_orderline
-- ----------------------------
CREATE SEQUENCE seq_eorderlineid;
CREATE TABLE e_orderline (
id NUMBER(10) NOT NULL PRIMARY KEY ,
bookid NUMBER(10) NOT NULL ,
orderid NUMBER(10) NOT NULL ,
onumber NUMBER(10) NOT NULL 
);
COMMENT ON COLUMN e_orderline.id IS '订单行编号';
COMMENT ON COLUMN e_orderline.bookid IS '书籍编号';
COMMENT ON COLUMN e_orderline.orderid IS '订单编号';
COMMENT ON COLUMN e_orderline.onumber IS '书籍数量';

-- ----------------------------
-- Records of e_orderline
-- ----------------------------
---------------------------------------------------------------------------
-- ----------------------------
-- Table structure for e_user
-- ----------------------------
CREATE SEQUENCE seq_euserid;
CREATE TABLE e_user (
id NUMBER(10) NOT NULL PRIMARY KEY ,
username VARCHAR2(40) NOT NULL ,
password VARCHAR2(40) NOT NULL ,
zip VARCHAR2(10) NULL ,
phone VARCHAR2(20) NULL ,
email VARCHAR2(40) NULL ,
udate DATE NOT NULL ,
state NUMBER(1) DEFAULT 1  NOT NULL 
);
COMMENT ON COLUMN e_user.id IS '用户编号';
COMMENT ON COLUMN e_user.username IS '用户名';
COMMENT ON COLUMN e_user.password IS '密码';
COMMENT ON COLUMN e_user.zip IS '邮编';
COMMENT ON COLUMN e_user.phone IS '电话';
COMMENT ON COLUMN e_user.email IS '电子邮箱';
COMMENT ON COLUMN e_user.udate IS '注册时间';
COMMENT ON COLUMN e_user.state IS '状态。1代表正常，2代表限制';

-- ----------------------------
-- Records of e_user
-- ----------------------------
---------------------------------------------------------------------------

INSERT INTO E_ADDRESS VALUES ('1', '1', '张三', '12345678901', '我的地址是。。。。。。');
INSERT INTO E_ADDRESS VALUES ('2', '1', '李四', '10987654321', '北京市北京市西城区');

INSERT INTO E_BOOK VALUES ('1', '3', 'java从入门到精通', '12.32', '1');
INSERT INTO E_BOOK VALUES ('2', '3', 'java核心技术卷一', '43.23', '1');
INSERT INTO E_BOOK VALUES ('3', '3', 'java核心技术卷二', '65.32', '0');
INSERT INTO E_BOOK VALUES ('4', '3', 'java编程思想', '23.40', '1');
INSERT INTO E_BOOK VALUES ('5', '1', '大家读大家', '23.40', '0');
INSERT INTO E_BOOK VALUES ('6', '1', '文学或者音乐', '23.42', '1');
INSERT INTO E_BOOK VALUES ('7', '1', '我们的荆轲', '53.13', '1');
INSERT INTO E_BOOK VALUES ('8', '2', '陶行知文集', '51.53', '1');
INSERT INTO E_BOOK VALUES ('9', '2', '新教育之梦', '94.12', '1');
INSERT INTO E_BOOK VALUES ('10', '2', '中国古代教育论著选读', '53.13', '1');
INSERT INTO E_BOOK VALUES ('11', '4', '绿野仙踪', '42.13', '1');
INSERT INTO E_BOOK VALUES ('12', '4', '长腿叔叔', '12.42', '1');
INSERT INTO E_BOOK VALUES ('13', '4', '小木屋', '91', '1');
INSERT INTO E_BOOK VALUES ('14', '4', '木偶奇遇记', '12.42', '0');
INSERT INTO E_BOOK VALUES ('15', '5', '父与子', '12.80', '1');
INSERT INTO E_BOOK VALUES ('16', '5', '奥特曼', '14.21', '1');
INSERT INTO E_BOOK VALUES ('17', '5', '死亡笔记', '10.31', '0');
INSERT INTO E_BOOK VALUES ('18', '6', '西式面点技术', '19.12', '1');
INSERT INTO E_BOOK VALUES ('19', '6', '烘焙宝典', '54.23', '1');
INSERT INTO E_BOOK VALUES ('20', '7', '价值与资本', '53.13', '1');
INSERT INTO E_BOOK VALUES ('21', '7', '找寻逝去的自我', '12.42', '1');

INSERT INTO E_CATEGORY VALUES ('1', '文学类', '文学的一个类别这是关于文学的一个类别这是关于文学的一个类别这是关于文学的一个类别');
INSERT INTO E_CATEGORY VALUES ('2', '教育类', '这是关于教育的一个类别');
INSERT INTO E_CATEGORY VALUES ('3', '计算机类', '这是关于计算机的一个类别');
INSERT INTO E_CATEGORY VALUES ('4', '儿童类', '这是关于儿童的一个类别');
INSERT INTO E_CATEGORY VALUES ('5', '漫画类', '这是关于漫画的一个类别');
INSERT INTO E_CATEGORY VALUES ('6', '工具类', '这是关于工具的一个类别');
INSERT INTO E_CATEGORY VALUES ('7', '期刊类', '这是关于期刊的一个类别');

INSERT INTO E_ORDER VALUES ('21', '1', '1', '192.52', TO_DATE('2018-05-21 17:01:57', 'YYYY-MM-DD HH24:MI:SS'), '1');

INSERT INTO E_ORDERLINE VALUES ('23', '10', '21', '2');
INSERT INTO E_ORDERLINE VALUES ('21', '4', '21', '1');
INSERT INTO E_ORDERLINE VALUES ('22', '21', '21', '3');
INSERT INTO E_ORDERLINE VALUES ('24', '15', '21', '2');

INSERT INTO E_USER VALUES ('1', 'zhangsan', '123456', '111111', '12345678901', '123@qq.com', TO_DATE('2018-05-17 10:24:07', 'YYYY-MM-DD HH24:MI:SS'), '1');
INSERT INTO E_USER VALUES ('2', 'lisi', '123456', '123456', '10987654321', '456@qq.com', TO_DATE('2018-05-20 16:32:42', 'YYYY-MM-DD HH24:MI:SS'), '1');

