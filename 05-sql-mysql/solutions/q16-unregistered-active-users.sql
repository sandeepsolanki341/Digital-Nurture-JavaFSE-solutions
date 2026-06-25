-- Q16. Unregistered Active Users
-- Users who created an account in the last 30 days but never registered for an event.
SELECT u.user_id, u.full_name, u.email, u.registration_date
FROM   users u
WHERE  u.registration_date >= CURDATE() - INTERVAL 30 DAY
  AND  NOT EXISTS (
           SELECT 1 FROM registrations r WHERE r.user_id = u.user_id
       )
ORDER  BY u.registration_date DESC;
