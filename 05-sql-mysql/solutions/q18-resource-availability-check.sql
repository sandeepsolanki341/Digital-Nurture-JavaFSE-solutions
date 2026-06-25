-- Q18. Resource Availability Check
-- Events that have NO resources uploaded.
SELECT e.event_id, e.title
FROM   events e
LEFT   JOIN resources r ON r.event_id = e.event_id
WHERE  r.resource_id IS NULL
ORDER  BY e.event_id;
