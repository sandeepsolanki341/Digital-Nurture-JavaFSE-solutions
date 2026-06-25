-- Q11. Daily New User Count
-- Number of users who registered (account creation) each day in the last 7 days.
SELECT registration_date, COUNT(*) AS new_users
FROM   users
WHERE  registration_date >= CURDATE() - INTERVAL 7 DAY
GROUP  BY registration_date
ORDER  BY registration_date;
