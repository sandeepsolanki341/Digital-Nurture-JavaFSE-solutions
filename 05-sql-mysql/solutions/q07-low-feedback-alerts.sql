-- Q7. Low Feedback Alerts
-- All users who gave a rating < 3, with their comments and the event name.
SELECT u.user_id, u.full_name, e.title AS event_name,
       f.rating, f.comments, f.feedback_date
FROM   feedback f
JOIN   users  u ON u.user_id  = f.user_id
JOIN   events e ON e.event_id = f.event_id
WHERE  f.rating < 3
ORDER  BY f.rating, f.feedback_date;
