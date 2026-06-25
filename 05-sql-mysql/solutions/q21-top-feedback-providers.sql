-- Q21. Top Feedback Providers
-- Top 5 users by number of feedback entries submitted.
SELECT u.user_id, u.full_name, COUNT(f.feedback_id) AS feedback_count
FROM   users u
JOIN   feedback f ON f.user_id = u.user_id
GROUP  BY u.user_id, u.full_name
ORDER  BY feedback_count DESC
LIMIT  5;
