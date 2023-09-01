CREATE TABLE visit_log2 (
                           uid VARCHAR(25),
                           tm DATETIME
);

INSERT INTO visit_log2 (uid, tm) VALUES
                                    ('u1', '2023-08-08 10:00:05'),
                                    ('u1', '2023-08-08 10:00:10'),
                                    ('u1', '2023-08-08 10:00:15'),
                                    ('u1', '2023-08-08 10:20:00'),
                                    ('u2', '2023-08-08 10:31:00'),
                                    ('u2', '2023-08-08 10:32:00');
# 停留时长统计，超过2mim算不在线
# u1,10
# u2,60


SELECT uid,
       MAX(period) AS period
FROM (
         SELECT a.uid,
                TIMESTAMPDIFF(SECOND, a.tm, b.tm) AS period
         FROM visit_log2 a
                  JOIN visit_log2 b ON a.uid = b.uid AND a.tm < b.tm
     ) AS subquery
WHERE period < 120
GROUP BY uid;


