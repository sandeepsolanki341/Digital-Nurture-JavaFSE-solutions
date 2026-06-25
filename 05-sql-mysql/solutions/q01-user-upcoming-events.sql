-- Q1. User Upcoming Events
-- Show all upcoming events a given user is registered for in their city, sorted by date.
-- Parameter: change @uid to the target user.
SET @uid = 1;

SELECT e.event_id, e.title, e.city, e.start_date, e.status
FROM   registrations r
JOIN   events e ON e.event_id = r.event_id
JOIN   users  u ON u.user_id  = r.user_id
WHERE  r.user_id = @uid
  AND  e.status  = 'upcoming'
  AND  e.city    = u.city          -- event held in the user's own city
ORDER  BY e.start_date;
