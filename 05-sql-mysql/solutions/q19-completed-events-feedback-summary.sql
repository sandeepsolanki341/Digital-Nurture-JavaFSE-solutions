-- Q19. Completed Events with Feedback Summary
-- For completed events: total registrations and average feedback rating.
SELECT e.event_id, e.title,
       COUNT(DISTINCT r.registration_id) AS total_registrations,
       ROUND(AVG(f.rating), 2)           AS avg_rating
FROM   events e
LEFT   JOIN registrations r ON r.event_id = e.event_id
LEFT   JOIN feedback      f ON f.event_id = e.event_id
WHERE  e.status = 'completed'
GROUP  BY e.event_id, e.title
ORDER  BY e.event_id;
