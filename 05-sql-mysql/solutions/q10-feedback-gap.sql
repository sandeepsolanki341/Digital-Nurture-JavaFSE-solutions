-- Q10. Feedback Gap
-- Events that had at least one registration but received no feedback at all.
SELECT DISTINCT e.event_id, e.title
FROM   events e
JOIN   registrations r ON r.event_id = e.event_id
WHERE  e.event_id NOT IN (SELECT event_id FROM feedback)
ORDER  BY e.event_id;
