-- Q15. Event Session Time Conflict
-- Overlapping sessions within the same event (start/end times that intersect).
-- Two sessions overlap when a.start < b.end AND a.end > b.start.
SELECT s1.event_id,
       s1.session_id AS session_a, s1.title AS title_a,
       s1.start_time AS start_a,  s1.end_time AS end_a,
       s2.session_id AS session_b, s2.title AS title_b,
       s2.start_time AS start_b,  s2.end_time AS end_b
FROM   sessions s1
JOIN   sessions s2
       ON  s1.event_id   = s2.event_id
       AND s1.session_id < s2.session_id          -- avoid self & mirror pairs
       AND s1.start_time < s2.end_time
       AND s1.end_time   > s2.start_time
ORDER  BY s1.event_id, s1.start_time;
