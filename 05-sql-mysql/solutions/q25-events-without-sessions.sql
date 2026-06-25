-- Q25. Events Without Sessions
-- Events that currently have no sessions scheduled.
SELECT e.event_id, e.title, e.status
FROM   events e
LEFT   JOIN sessions s ON s.event_id = e.event_id
WHERE  s.session_id IS NULL
ORDER  BY e.event_id;
