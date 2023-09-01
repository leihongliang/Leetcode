####################
######【Like】#######
####################
# 1. 查询「李」姓老师的数量 【Like】
SELECT COUNT(*) FROM teacher
WHERE t_name LIKE '李%';
# 2. 查询名字中含有「风」字的学生信息【Like】
SELECT * FROM student WHERE s_name LIKE '%李%';


####################
#####【聚合函数】#####
####################
# 3. 查询男生、女生人数
SELECT s_sex, COUNT(*)
FROM student GROUP BY s_sex;

# 4. 查询课程编号为02的总成绩
SELECT SUM(s_score) FROM score GROUP BY c_id HAVING c_id = '02';
SELECT SUM(s_score) FROM score WHERE c_id = '02' ;

# 5. 查询每门课程的平均成绩，结果按平均成绩降序排列，平均成绩相同时，按课程编号升序排列
SELECT c_id, AVG(s_score) as avg FROM score GROUP BY c_id ORDER BY avg DESC;

# 6. 求每门课程的学生人数
SELECT c_id, COUNT(*) as c_num FROM score GROUP BY c_id;

# 7. 统计每门课程的学生选修人数（超过 5 人的课程才统计）
SELECT c_id, COUNT(*) as s_num FROM score GROUP BY c_id HAVING s_num > 5;

# 8. 检索至少选修两门课程的学生学号
SELECT c_id FROM score GROUP BY c_id HAVING COUNT(c_id) > 1;


####################
######【子查询】######
####################
# 9. 查询在score表存在成绩的学生信息
SELECT * FROM student WHERE s_id IN (SELECT s_id FROM score);

# 10. 查询不存在" 01 "课程但存在" 02 "课程的学生信息
SELECT * FROM student WHERE s_id NOT IN (SELECT s_id FROM score WHERE c_id = '01')
        AND s_id IN (SELECT s_id FROM score WHERE c_id = '02');

# 11. 查询同时存在" 01 "课程和" 02 "课程的情况
SELECT * FROM student WHERE s_id IN (SELECT s_id FROM score WHERE c_id = '01')
                        AND s_id IN (SELECT s_id FROM score WHERE c_id = '02');
SELECT * FROM  student s
    JOIN
    (SELECT * FROM score WHERE c_id = 01) a on s.s_id = a.s_id
    JOIN
    (SELECT * FROM score WHERE c_id = 02) b on s.s_id = b.s_id;

# 12. 查询出只选修两门课程的学生学号和姓名
SELECT s_id, s_name FROM student WHERE s_id IN (SELECT s_id FROM score GROUP BY s_id HAVING COUNT(c_id) = 2);
# 13. 查询没有学全所有课程的同学的信息
SELECT * FROM student WHERE s_id NOT IN (SELECT s_id FROM score GROUP BY s_id HAVING COUNT(c_id) = 3);
# 14. 查询选修了全部课程的学生信息
SELECT * FROM student WHERE s_id IN (SELECT s_id FROM score GROUP BY s_id HAVING COUNT(c_id) = 3);
# 15. 查询所有课程成绩均小于60分的学号、姓名
SELECT s_id, s_name FROM student WHERE s_id NOT IN (SELECT DISTINCT s_id FROM score WHERE s_score >= 60)
                                   AND s_id IN (SELECT s_id FROM score);
# 16. 查询课程编号为 01 且课程成绩在 80 分以上的学生的学号和姓名
SELECT s_id, s_name FROM student WHERE s_id IN (SELECT s_id FROM score WHERE s_score > 80 AND c_id = 01);

# 17. 查询学过「张三」老师授课的同学的信息
SELECT DISTINCT student.* FROM student , score , course , teacher
WHERE
    student.s_id = score.s_id
AND score.c_id = course.c_id
AND course.t_id = teacher.t_id
AND teacher.t_name = '张三';

SELECT st.*
FROM student st
JOIN score s ON st.s_id =s.s_id
JOIN course c on s.c_id = c.c_id
JOIN teacher t on c.t_id = t.t_id
WHERE t.t_name = '张三';


# 18. 查询没学过"张三"老师讲授的任一门课程的学生姓名
SELECT s_name FROM student
WHERE s_id NOT IN (SELECT s_id FROM score,course,teacher
                               WHERE score.c_id = course.c_id
                                 AND course.t_id = teacher.t_id
                                 AND teacher.t_name = '张三');
SELECT s_name FROM student s
WHERE NOT EXISTS (
    SELECT 1
    FROM score sc
             JOIN course c ON sc.c_id = c.c_id
             JOIN teacher t ON c.t_id = t.t_id
    WHERE t.t_name = '张三' AND s.s_id = sc.s_id
);

SELECT s.s_name
FROM student s
LEFT JOIN (
    SELECT sc.s_id
    FROM score sc
             JOIN course c ON sc.c_id = c.c_id
             JOIN teacher t ON c.t_id = t.t_id
    WHERE t.t_name = '张三'
) sub ON s.s_id = sub.s_id
WHERE sub.s_id IS NULL;

# 19. 查询至少有一门课与学号为" 01 "的同学所学相同的同学的信息

# 20. 查询和" 01 "号的同学学习的课程完全相同的其他同学的信息
# 21. 查询不同课程成绩相同的学生的学生编号、课程编号、学生成绩

####################
#######【联结】#######
####################
# 22. 检索" 01 "课程分数小于 60，按分数降序排列的学生信息【inner join】
SELECT st.*
FROM student AS st INNER JOIN score sc
ON st.s_id = sc.s_id
WHERE sc.c_id = '01' AND sc.s_score < 60
ORDER BY sc.s_score DESC;
# 23. 查询不及格的课程及学生名，学号，按课程号从大到小排列【inner join】
SELECT  sc.s_id, st.s_name, st.s_id
FROM student st INNER JOIN score sc on st.s_id = sc.s_id
WHERE sc.s_score < 60 ORDER BY sc.s_id DESC;
# 24. 查询课程名称为「数学」，且分数低于 60 的学生姓名和分数【inner join】
SELECT  s_score, s.s_name
FROM score sc INNER JOIN student s on sc.s_id = s.s_id
WHERE sc.s_score < 60 AND sc.c_id IN (SELECT c_id FROM course WHERE c_name = '数学');

# 25. 查询平均成绩大于等于 85 的所有学生的学号、姓名和平均成绩【inner join】
SELECT st.s_id, st.s_name, AVG(s.s_score)
FROM student st INNER JOIN score s on st.s_id = s.s_id
GROUP BY s.s_id HAVING AVG(s.s_score) >= 85;
# 26. 查询不同老师所教不同课程平均分从高到低显示【inner join】
SELECT s.c_id, c.t_id, AVG(s.s_score)
FROM score s INNER JOIN course c on s.c_id = c.c_id
GROUP BY c.c_id
ORDER BY AVG(s.s_score) DESC ;
# 27. 查询平均成绩大于等于 60 分的同学的学生编号和学生姓名和平均成绩【inner join】
SELECT st.s_id, st.s_name, AVG(s.s_score)
FROM student st INNER JOIN score s on st.s_id = s.s_id
GROUP BY s.s_id HAVING AVG(s.s_score >= 60);

# 28.查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩【inner join】
SELECT st.s_id, st.s_name, AVG(s.s_score)
FROM score s INNER JOIN student st on st.s_id = s.s_id
WHERE s.s_score < 60 GROUP BY s.s_id HAVING COUNT(s.s_score >= 2);

# 29. 查询同名同性学生名单，并统计同名同性人数【inner join】
# 30. 查询所有学生的课程及分数情况（存在学生没成绩，没选课的情况）【outer join】
SELECT st.s_id, s.c_id, s.s_score
FROM student st LEFT OUTER JOIN score s on st.s_id = s.s_id;

# 31. 查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩。(没成绩的显示为 null )【outer join】
SELECT st.s_id, st.s_name, COUNT(s.c_id), SUM(s.s_score)
FROM student st LEFT OUTER JOIN score s on st.s_id = s.s_id
GROUP BY st.s_id;

# 32. 查询存在" 01 "课程但可能不存在" 02 "课程的情况(不存在时显示为 null )
SELECT *
FROM (SELECT * FROM score WHERE s_id = '01') AS s1
LEFT JOIN (SELECT * FROM score WHERE s_id = '02') AS s2 ON s1.s_id = s2.s_id;

# 33. 查询任何一门课程成绩在 70 分以上的姓名、课程名称和分数【三表联结】
SELECT st.s_name, c.c_name, s.s_score
FROM student st, course c, score s
WHERE st.s_id = s.s_id AND c.c_id = s.c_id
AND s_score > 70;

# 34. 查询" 01 "课程比" 02 "课程成绩高的学生的信息及课程分数【三表联结】
SELECT st.*
FROM student st, score s
INNER JOIN (SELECT * FROM score WHERE c_id = '01') AS s1 ON s1.s_id = st.s_id
INNER JOIN (SELECT * FROM score WHERE c_id = '02') AS s2 ON s2.s_id = st.s_id
AND s1.s_score > s2.s_score;

SELECT st.*
FROM student st
INNER JOIN score s1 ON s1.s_id = st.s_id AND s1.c_id = '01'
INNER JOIN score s2 ON s2.s_id = st.s_id AND s2.c_id = '02'
WHERE s1.s_score > s2.s_score;
# 35. 成绩不重复，查询选修「张三」老师所授课程的学生中，成绩最高的学生信息及其成绩【limit】
SELECT st.*, s.s_score
FROM score s
INNER JOIN course c on c.c_id = s.c_id
INNER JOIN teacher t on c.t_id = t.t_id
INNER JOIN student st on st.s_id = s.s_id
WHERE t.t_name = '张三'
ORDER BY s.s_score DESC LIMIT 1;

# 36. 成绩有重复的情况下，查询选修「张三」老师所授课程的学生中，成绩最高的学生信息及其成绩【limit】

####################
#####【窗口函数】#####
####################
# 1.第几名是DENSE_RANK(), 前几名是RANK()
# 37. 按各科成绩进行排序，并显示排名，Score 重复时保留名次空缺【窗口函数】
SELECT *, RANK() OVER (PARTITION BY c_id ORDER BY s_score DESC) AS ranking
FROM score;
# 38. 按各科成绩进行排序，并显示排名，Score 重复时合并名次【窗口函数】
SELECT *, DENSE_RANK() OVER (PARTITION BY c_id ORDER BY s_score DESC) AS ranking
FROM score;
# 40. 查询学生的总成绩，并进行排名，总分重复时不保留名次空缺【窗口函数】
SELECT s.s_id, SUM(s_score),
       DENSE_RANK() OVER (ORDER BY SUM(s_score) DESC) AS ranking
FROM score s GROUP BY s.s_id;
# 41. 查询每门功成绩最好的前两名【窗口函数】
SELECT *
FROM (
    SELECT *, DENSE_RANK() over (PARTITION BY s.c_id ORDER BY s.s_score DESC) AS ranking
    FROM score s
) AS a
WHERE ranking <= 2;
# 42. 查询各科成绩前三名的记录【窗口函数】
SELECT *
FROM (
         SELECT *, RANK() over (PARTITION BY s.c_id ORDER BY s.s_score DESC) AS ranking
         FROM score s
     ) AS a
WHERE ranking <= 3;
# 43. 查询所有课程成绩第2名到第3名的学生信息及该课程成绩【窗口函数】
SELECT st.*, b.c_id,b.s_score
FROM student st JOIN
    (SELECT *, DENSE_RANK() over (PARTITION BY c_id ORDER BY s_score DESC) ranking FROM score ) b
on st.s_id = b.s_id
WHERE ranking IN (2,3);
# 44.按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩【case】
SELECT st.s_id, s.`01`, s.`02`, s.`03`, s.avg
FROM (SELECT s_id, AVG(s_score) avg,
    MAX(CASE WHEN c_id='01' THEN s_score ELSE NULL END) AS '01',
    MAX(CASE WHEN c_id='02' THEN s_score ELSE NULL END) AS '02',
    MAX(CASE WHEN c_id='03' THEN s_score ELSE NULL END) AS '03'
      FROM score
      GROUP BY s_id
    ) AS s
RIGHT JOIN student st on st.s_id = s.s_id
ORDER BY s.avg DESC;
# 45. 使用分段[100-85]，[85-70]，[70-60]，[<60]来统计各科成绩，分别统计各分数段人数：课程ID和课程名称【case】
SELECT s.c_id, c.c_name,
    SUM(CASE WHEN s.s_score>=85 THEN 1 ELSE 0 END )AS '[100-85]',
    SUM(CASE WHEN s.s_score>=70 AND s.s_score < 85 THEN 1 ELSE 0 END )AS '[85-70]',
    SUM(CASE WHEN s.s_score>=60 AND s.s_score < 70 THEN 1 ELSE 0 END )AS '[70-60]',
    SUM(CASE WHEN s.s_score < 60 THEN 1 ELSE 0 END )AS '[<60]'
FROM score s
JOIN course c on s.c_id = c.c_id
GROUP BY s.c_id;

# 46. 查询各科成绩最高分、最低分和平均分：以如下形式显示：课程 ID ，课程 name ，最高分，最低分，平均分，及格率，中等率，优良率，优秀率。及格为>=60，中等为：70-80，优良为：80-90，优秀为：>=90 【case】
SELECT s.c_id, c.c_name,
       MAX(CASE WHEN s.s_score THEN s.s_score ELSE NULL END) AS 'max',
       MIN(CASE WHEN s.s_score THEN s.s_score ELSE NULL END) AS 'min',
       AVG(CASE WHEN s.s_score THEN s.s_score ELSE NULL END) AS 'avg',
       SUM(CASE WHEN s.s_score>=60 THEN 1 ELSE 0 END)/count(s_score) AS 'd_rate',
       SUM(CASE WHEN s.s_score>=70 AND s.s_score < 80 THEN 1 ELSE 0 END)/count(s_score) AS 'c_rate',
       SUM(CASE WHEN s.s_score>=80 AND s.s_score < 90 THEN 1 ELSE 0 END)/count(s_score) AS 'b_rate',
       SUM(CASE WHEN s.s_score>=90 THEN 1 ELSE 0 END)/count(s_score) AS 'a_rate'
FROM score s
JOIN course c on s.c_id = c.c_id
GROUP BY s.c_id;
# 47. 统计各科成绩各分数段人数：课程编号，课程名称，[100-85]，[85-70]，[70-60]，[60-0] 及所占百分比【case】
SELECT s.c_id, c.c_name,
    SUM(CASE WHEN s.s_score>=85 THEN 1 ELSE 0 END )AS '[100-85]',
    SUM(CASE WHEN s.s_score>=85 THEN 1 ELSE 0 END )/count(s_score) AS '[100-85]rate',
    SUM(CASE WHEN s.s_score>=70 AND s.s_score < 85 THEN 1 ELSE 0 END )AS '[85-70]',
    SUM(CASE WHEN s.s_score>=70 AND s.s_score < 85 THEN 1 ELSE 0 END )/count(s_score) AS '[85-70]rate',
    SUM(CASE WHEN s.s_score>=60 AND s.s_score < 70 THEN 1 ELSE 0 END )AS '[70-60]',
    SUM(CASE WHEN s.s_score>=60 AND s.s_score < 70 THEN 1 ELSE 0 END )/count(s_score) AS '[70-60]rate',
    SUM(CASE WHEN s.s_score < 60 THEN 1 ELSE 0 END )AS '[<60]',
    SUM(CASE WHEN s.s_score < 60 THEN 1 ELSE 0 END )/count(s_score) AS '[<60]rate'
FROM score s
JOIN course c on s.c_id = c.c_id
GROUP BY s.c_id;

####################
#####【时间函数】#####
####################
# 48. 查询各学生的年龄，只按年份来算【时间函数】
# 49. 按照出生日期来算，当前月日 < 出生年月的月日则，年龄减一【时间函数】
# 50. 查询本月过生日的学生【时间函数】
# 51. 查询下z月过生日的学生【时间函数】
# 52. 查询本周过生日的学生【时间函数】*
# 53. 查询下周过生日的学生【时间函数】*



select  stu_name,count(num) num from
    (
        select stu_name,date(createtime)-row_number() over(partition by stu_name ORDER BY createtime) num from
            (
                -- 1、去重，每天多次登录，只保留一条
                select distinct stu_name,DATE_FORMAT(createtime,'%Y-%m-%d')createtime  from login_log
            ) t1
    )t2 GROUP BY  stu_name  HAVING(count(1))>7