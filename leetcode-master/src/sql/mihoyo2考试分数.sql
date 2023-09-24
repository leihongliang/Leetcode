/*
请你写一个sql
表结构为
drop table if exists grade;
drop table if exists language;
CREATE TABLE `grade` (
`id` int(4) NOT NULL,
`language_id` int(4) NOT NULL,
`score` int(4) NOT NULL,
PRIMARY KEY (`id`));

CREATE TABLE `language` (
`id` int(4) NOT NULL,
`name` varchar(32) NOT NULL,
PRIMARY KEY (`id`));

INSERT INTO grade VALUES
(1,1,12000),
(2,1,13000),
(3,2,11000),
(4,2,10000),
(5,3,11000),
(6,1,11000),
(7,2,11000);

INSERT INTO language VALUES
(1,'C++'),
(2,'JAVA'),
(3,'Python');

请你写一个sql，找出每个language.id grade.score等于最大前两位的所有grade.id，得到的结果先按照language.name升序排序，再按照grade.score降序排序，最后按照grade.id升序排序
输出为
2|C++|13000
1|C++|12000
3|JAVA|11000
7|JAVA|11000
4|JAVA|10000
5|Python|11000
 */

drop table if exists grade;
drop table if exists language;
CREATE TABLE `grade` (
                         `id` int(4) NOT NULL,
                         `language_id` int(4) NOT NULL,
                         `score` int(4) NOT NULL,
                         PRIMARY KEY (`id`))    ;

CREATE TABLE `language` (
                            `id` int(4) NOT NULL,
                            `name` varchar(32) NOT NULL,
                            PRIMARY KEY (`id`));

INSERT INTO grade VALUES
                      (1,1,12000),
                      (2,1,13000),
                      (3,2,11000),
                      (4,2,10000),
                      (5,3,11000),
                      (6,1,11000),
                      (7,2,11000);

INSERT INTO language VALUES
                         (1,'C++'),
                         (2,'JAVA'),
                         (3,'Python');


-- 使用窗口函数row_number()按照language_id和score分组排序，得到每个用户的排名
WITH rank_table AS (
    SELECT
        g.id,
        g.language_id,
        g.score,
        l.name,
        ROW_NUMBER() OVER (PARTITION BY g.language_id ORDER BY g.score DESC) AS score_rank
    FROM grade g JOIN language l ON g.language_id = l.id
    )
-- 从rank_table中筛选出排名前2名的用户，并按照要求的顺序排序
SELECT id, name, score FROM rank_table
WHERE score_rank <= 2
ORDER BY name ASC, score DESC, id ASC;





