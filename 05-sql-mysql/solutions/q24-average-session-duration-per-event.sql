-- Q24. Average Session Duration per Event
-- Average session length in minutes for each event.
SELECT e.event_id, e.title,
       ROUND(AVG(TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time)), 1) AS avg_duration_minutes
FROM   events e
JOIN   sessions s ON s.event_id = e.event_id
GROUP  BY e.event_id, e.title
ORDER  BY avg_duration_minutes DESC;
