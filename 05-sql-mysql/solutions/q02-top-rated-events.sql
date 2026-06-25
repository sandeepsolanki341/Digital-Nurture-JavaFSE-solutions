-- Q2. Top Rated Events
-- Events with the highest average rating, counting only those with >= 10 feedback rows.
-- NOTE: seed data has far fewer than 10 feedbacks per event, so this returns no rows
--       against the sample set. The query is written correctly to the requirement.
SELECT e.event_id, e.title,
       ROUND(AVG(f.rating), 2) AS avg_rating,
       COUNT(*)                AS feedback_count
FROM   feedback f
JOIN   events e ON e.event_id = f.event_id
GROUP  BY e.event_id, e.title
HAVING COUNT(*) >= 10
ORDER  BY avg_rating DESC;
