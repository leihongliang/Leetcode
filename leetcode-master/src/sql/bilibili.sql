CREATE TABLE uploader_video_record (
                                       video_id BIGINT PRIMARY KEY,
                                       uploader_id BIGINT,
                                       video_duration INT
);
INSERT INTO uploader_video_record (video_id, uploader_id, video_duration)
VALUES
    (1, 101, 60),
    (2, 102, 600),
    (3, 103, 310),
    (4, 101, 120),
    (5, 104, 3200),
    (6, 102, 330),
    (7, 103, 290),
    (8, 105, 290),
    (9, 101, 180),
    (10, 103, 320);

-- 选择video_duration平均时长大于300秒的uploader_id，并计算video_duration平均
WITH avg_duration AS (
    SELECT uploader_id, AVG(video_duration) AS avg_dur
    FROM uploader_video_record
    GROUP BY uploader_id
    HAVING AVG(video_duration) > 300
)
SELECT video_id, avg_dur
FROM uploader_video_record AS uvr
         JOIN avg_duration AS ad ON uvr.uploader_id = ad.uploader_id
ORDER BY ad.avg_dur DESC, uvr.video_id ASC
LIMIT 4 OFFSET 2;