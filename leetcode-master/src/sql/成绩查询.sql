-- Drop tables if they exist
DROP TABLE IF EXISTS grade_tb;
DROP TABLE IF EXISTS reexamine_tb;

-- Create the grade_tb table
CREATE TABLE grade_tb (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          sid INT NOT NULL COMMENT '学生ID',
                          cid VARCHAR(4) NOT NULL COMMENT '课程ID',
                          score TINYINT COMMENT '考试分数'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Insert data into grade_tb
INSERT INTO grade_tb (sid, cid, score) VALUES
                                           (1001, 'c02', 50),
                                           (1001, 'c01', 59),
                                           (1001, 'c03', 40);

-- Create the reexamine_tb table
CREATE TABLE reexamine_tb (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              sid INT NOT NULL COMMENT '学生ID',
                              cid VARCHAR(4) NOT NULL COMMENT '课程ID',
                              score TINYINT COMMENT '考试分数',
                              idx TINYINT COMMENT '补考次序'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Insert data into reexamine_tb
INSERT INTO reexamine_tb (sid, cid, score, idx) VALUES
                                                    (1001, 'c01', 56, 1),
                                                    (1001, 'c02', 69, 1),
                                                    (1001, 'c03', 59, 1),
                                                    (1001, 'c03', 69, 2);

# 输出字段为
# 1001 l c01 | 59-56
# 1001 | c02 | 50-69
# 1001 | c03 | 40-59-69


SELECT
    g.sid AS sid,
    g.cid AS cid,
    CONCAT_WS('-', g.score, r1.score, r2.score) AS score
FROM
    grade_tb g
        LEFT JOIN
    reexamine_tb r1 ON g.sid = r1.sid AND g.cid = r1.cid AND r1.idx = 1
        LEFT JOIN
    reexamine_tb r2 ON g.sid = r2.sid AND g.cid = r2.cid AND r2.idx = 2
WHERE
        g.score < 60 OR r1.score IS NOT NULL
ORDER BY
    g.sid, g.cid;
