-- Q12. Event with Maximum Sessions
-- Event(s) having the highest number of sessions (ties included).
SELECT e.event_id, e.title, COUNT(s.session_id) AS session_count
FROM   events e
JOIN   sessions s ON s.event_id = e.event_id
GROUP  BY e.event_id, e.title
HAVING COUNT(s.session_id) = (
           SELECT MAX(cnt) FROM (
               SELECT COUNT(*) AS cnt
               FROM   sessions
               GROUP  BY event_id
           ) t
       );
