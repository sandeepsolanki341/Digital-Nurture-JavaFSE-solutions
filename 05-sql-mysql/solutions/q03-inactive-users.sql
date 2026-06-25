-- Q3. Inactive Users
-- Users who have NOT registered for any event in the last 90 days.
SELECT u.user_id, u.full_name, u.email, u.city
FROM   users u
WHERE  u.user_id NOT IN (
           SELECT r.user_id
           FROM   registrations r
           WHERE  r.registration_date >= CURDATE() - INTERVAL 90 DAY
       )
ORDER  BY u.user_id;
