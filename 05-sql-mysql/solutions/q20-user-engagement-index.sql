-- Q20. User Engagement Index
-- For each user: how many events they registered for and how many feedbacks they submitted.
SELECT u.user_id, u.full_name,
       COUNT(DISTINCT r.registration_id) AS events_registered,
       COUNT(DISTINCT f.feedback_id)     AS feedbacks_submitted
FROM   users u
LEFT   JOIN registrations r ON r.user_id = u.user_id
LEFT   JOIN feedback      f ON f.user_id = u.user_id
GROUP  BY u.user_id, u.full_name
ORDER  BY events_registered DESC, feedbacks_submitted DESC;
