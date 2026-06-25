-- Q13. Average Rating per City
-- Average feedback rating of events grouped by the city the event was held in.
SELECT e.city,
       ROUND(AVG(f.rating), 2) AS avg_rating,
       COUNT(f.feedback_id)    AS feedback_count
FROM   feedback f
JOIN   events e ON e.event_id = f.event_id
GROUP  BY e.city
ORDER  BY avg_rating DESC;
