-- Q9. Organizer Event Summary
-- For each organizer, count events by current status.
SELECT u.user_id AS organizer_id, u.full_name AS organizer_name,
       COUNT(*)                                   AS total_events,
       SUM(e.status = 'upcoming')                 AS upcoming_events,
       SUM(e.status = 'completed')                AS completed_events,
       SUM(e.status = 'cancelled')                AS cancelled_events
FROM   events e
JOIN   users  u ON u.user_id = e.organizer_id
GROUP  BY u.user_id, u.full_name
ORDER  BY total_events DESC;
