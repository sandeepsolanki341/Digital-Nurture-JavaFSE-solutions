-- Q22. Duplicate Registrations Check
-- Detect (user, event) pairs registered more than once.
SELECT user_id, event_id, COUNT(*) AS times_registered
FROM   registrations
GROUP  BY user_id, event_id
HAVING COUNT(*) > 1
ORDER  BY times_registered DESC;
