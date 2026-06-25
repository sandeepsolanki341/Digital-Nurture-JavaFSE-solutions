-- Q4. Peak Session Hours
-- Count sessions scheduled to start between 10:00 and 12:00 (inclusive) per event.
SELECT e.event_id, e.title,
       COUNT(*) AS sessions_10_to_12
FROM   sessions s
JOIN   events e ON e.event_id = s.event_id
WHERE  TIME(s.start_time) BETWEEN '10:00:00' AND '12:00:00'
GROUP  BY e.event_id, e.title
ORDER  BY sessions_10_to_12 DESC;
