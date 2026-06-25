-- Q8. Sessions per Upcoming Event
-- Each upcoming event with its session count (including events with zero sessions).
SELECT e.event_id, e.title,
       COUNT(s.session_id) AS session_count
FROM   events e
LEFT   JOIN sessions s ON s.event_id = e.event_id
WHERE  e.status = 'upcoming'
GROUP  BY e.event_id, e.title
ORDER  BY session_count DESC;
