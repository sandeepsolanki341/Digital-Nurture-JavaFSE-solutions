-- Q5. Most Active Cities
-- Top 5 cities by number of DISTINCT users who have registered for events.
SELECT u.city,
       COUNT(DISTINCT r.user_id) AS distinct_registered_users
FROM   registrations r
JOIN   users u ON u.user_id = r.user_id
GROUP  BY u.city
ORDER  BY distinct_registered_users DESC
LIMIT  5;
