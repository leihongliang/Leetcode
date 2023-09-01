DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`
(
    `id`         int(0)                                                 NOT NULL AUTO_INCREMENT,
    `name`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `dt` datetime(6)                                            NULL DEFAULT CURRENT_TIMESTAMP(6),
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 20
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;
INSERT INTO `login_log` VALUES (1, 'zhangsan', '2021-03-07 09:58:29.438123');
INSERT INTO `login_log` VALUES (2, 'zhangsan', '2021-03-03 09:58:29.438123');
INSERT INTO `login_log` VALUES (3, 'zhangsan', '2021-03-05 09:58:29.438123');
INSERT INTO `login_log` VALUES (4, 'zhangsan', '2021-03-01 09:58:29.438123');
INSERT INTO `login_log` VALUES (5, 'lisi', '2021-02-04 09:58:29.438123');
INSERT INTO `login_log` VALUES (6, 'lisi', '2021-02-03 09:58:29.438123');
INSERT INTO `login_log` VALUES (7, 'lisi', '2021-02-02 09:58:29.438123');
INSERT INTO `login_log` VALUES (8, 'lisi', '2021-02-01 09:58:29.438123');
INSERT INTO `login_log` VALUES (9, 'lisi', '2021-02-05 09:58:29.438123');
INSERT INTO `login_log` VALUES (10, 'lisi', '2021-02-06 09:58:29.438123');
INSERT INTO `login_log` VALUES (11, 'lisi', '2021-02-07 09:58:29.438123');
INSERT INTO `login_log` VALUES (12, 'lisi', '2021-02-08 09:58:29.438123');
INSERT INTO `login_log` VALUES (13, 'xiaowang', '2021-02-05 09:58:29.438123');
INSERT INTO `login_log` VALUES (14, 'xiaoli', '2021-02-06 09:58:29.438123');
INSERT INTO `login_log` VALUES (15, 'xiaoli', '2021-02-07 09:58:29.438123');
INSERT INTO `login_log` VALUES (16, 'xiaozhao', '2021-02-08 09:58:29.438123');
INSERT INTO `login_log` VALUES (17, 'lisi', '2021-02-05 09:58:29.438123');
INSERT INTO `login_log` VALUES (18, 'xiaozhao', '2021-02-06 09:58:29.438123');
INSERT INTO `login_log` VALUES (19, 'lisi', '2021-02-07 09:58:29.438123');
SET FOREIGN_KEY_CHECKS = 1;

# 找出连续登录7天的用户数
select count(distinct name) num
from (select name, base_dt, count(1)
         from (select *, DATE_SUB(dt,INTERVAL rn DAY) as base_dt
                 from ( select *, row_number() over(partition by a.name order by a.dt) as rn
                         from( select name, date(dt) as dt from login_log group by name, date(dt)) a
                         ) b
                 ) c
group by name,base_dt
HAVING COUNT(1)>=7 ) d;

# 找出连续登录7天的用户
select name,
       count(1)
from ( select *, DATE_SUB(dt,INTERVAL rn DAY) as base_dt
        from ( select *, row_number() over(partition by a.name order by a.dt) as rn
                from ( select name, date(dt) as dt from login_log group by name, date(dt)) a
                ) b
        ) c
group by name, base_dt
HAVING COUNT(1)>=7;

# 步骤一去重
select name,
       date(dt) as dt
from login_log group by name, date(dt);

#步骤二 登录日期进行排序
select *,
       row_number() over(partition by a.name order by a.dt) as rn
from ( select name,
              date(dt) as dt
       from login_log group by name, date(dt)) a;


#步骤二 登录日期进行排序，并按照连续分组
select *, DATE_SUB(dt,INTERVAL rn DAY) as base_dt
from ( select *,
              row_number() over(partition by a.name order by a.dt) as rn
       from ( select name,
                     date(dt) as dt
              from login_log group by name, date(dt)) a
     ) b;