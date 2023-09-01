CREATE TABLE visit_log (
                           uid VARCHAR(25),
                           play_time INT
);

INSERT INTO visit_log (uid, play_time) VALUES
                                           ('u1', 5),
                                           ('u2', 3),
                                           ('u3', 10),
                                           ('u4', 15),
                                           ('u5', 7);
# uid | play_time | rnk | inc_tm
# u4 | 15 | 1 | 15
# u3 | 10 | 2 | 25
# u5 | 7 | 3 | 32
# u1 | 5 | 4 | 37
# u2 | 3 | 5 | 40


SELECT UID,
       play_time,
       rnk,
       SUM(play_time) OVER (ORDER BY rnk ASC ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) AS inc_tm
FROM
    (SELECT uid,
            play_time,
            ROW_NUMBER() OVER (ORDER BY play_time DESC) AS rnk
     FROM visit_log) a

