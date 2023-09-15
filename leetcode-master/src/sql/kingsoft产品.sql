DROP TABLE IF EXISTS project;
CREATE TABLE project (
    id INT PRIMARY KEY,
    name VARCHAR(50)
);
DROP TABLE IF EXISTS bug;
CREATE TABLE bug (
    id INT PRIMARY KEY,
    title VARCHAR(50),
    description VARCHAR(50),
    project_id INT,
    version DECIMAL(8,1),
    level VARCHAR(50),
    status VARCHAR(50),
    date DATETIME
);


INSERT INTO project (id, name) VALUES
    (1, 'wps'),
    (2, 'wpp'),
    (3, 'et');
#
INSERT INTO bug (id, title,description,project_id,version,level, status, date) VALUES
    (1, 'xxxxx', 'xxxxx',1, 1.1, 'A', 'open', '2023-08-08 10:00:05'),
    (2, 'xxxxx', 'xxxxx',1, 1.1, 'A', 'open', '2023-08-08 10:00:05'),
    (3, 'xxxxx', 'xxxxx',3, 1.2, 'B', 'open', '2023-08-08 10:00:05'),
    (4, 'xxxxx', 'xxxxx',2, 1.2, 'B', 'open', '2023-08-08 10:00:05'),
    (5, 'xxxxx', 'xxxxx',3, 1.2, 'B', 'open', '2023-08-08 10:00:05'),
    (6, 'xxxxx', 'xxxxx',2, 1.3, 'A', 'open', '2023-08-08 10:00:05'),
    (7, 'xxxxx', 'xxxxx',3, 1.3, 'A', 'open', '2023-08-08 10:00:05'),
    (8, 'xxxxx', 'xxxxx',2, 1.3, 'A', 'open', '2023-08-08 10:00:05'),
    (9, 'xxxxx', 'xxxxx',3, 1.3, 'C', 'open', '2023-08-08 10:00:05');

# 请编写一条SQL统计出2023年8月份level为A，status为open的bug数量。
SELECT COUNT(*) AS bug_count
FROM bug
WHERE YEAR(date) = 2023
  AND MONTH(date) = 8
  AND level = 'A'
  AND status = 'open';

# 请编写一条SQL查询出project name为et，version大于1.1的bug，
SELECT p.name AS project_name, b.title, b.description, b.version, b.level, b.status
FROM project p
         INNER JOIN bug b ON p.id = b.project_id
WHERE p.name = 'et'
  AND b.version > 1.1;




