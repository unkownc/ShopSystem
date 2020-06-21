-- 创建数据库
drop database if exists shopping;
create database shopping charset utf8;
use shopping;

-- 创建表
create table t_product (
    id int primary key auto_increment,
    name varchar(50) not null,
    price double
)charset utf8;

create table t_user(
    id int primary key auto_increment,
    username varchar(50) unique not null,
    password varchar(200),
    phone varchar(50),
    address varchar(200),
    status int
)charset utf8;

create table t_order(
    id int primary key auto_increment,
    user_id int,
    no varchar(50) unique not null,
    price double,
    createdate date,
    foreign key(user_id) references t_user(id)
)charset utf8;

create table t_item(
    id int primary key auto_increment,
    product_id int,
    num int,
    price double,
    order_id int,
    foreign key(product_id) references t_product(id),
    foreign key (order_id) references  t_order(id)
)charset utf8;

-- 插入测试数据
insert into t_product(name,price)value('面包',4.5),
    ('牛奶',5.2),
    ('方便面',5),
    ('巧克力',2),
    ('矿泉水',9),
    ('口香糖',25.5),
    ('薯片',8),
    ('可了',4.5);