-- Q23. Registration Trends
-- Month-wise registration count over the past 12 months.
SELECT DATE_FORMAT(registration_date, '%Y-%m') AS month,
       COUNT(*)                                AS registrations
FROM   registrations
WHERE  registration_date >= CURDATE() - INTERVAL 12 MONTH
GROUP  BY DATE_FORMAT(registration_date, '%Y-%m')
ORDER  BY month;
