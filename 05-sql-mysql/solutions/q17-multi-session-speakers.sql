-- Q17. Multi-Session Speakers
-- Speakers handling more than one session across all events.
SELECT speaker_name, COUNT(*) AS session_count
FROM   sessions
GROUP  BY speaker_name
HAVING COUNT(*) > 1
ORDER  BY session_count DESC;
