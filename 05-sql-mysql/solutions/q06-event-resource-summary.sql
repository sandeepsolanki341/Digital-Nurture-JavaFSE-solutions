-- Q6. Event Resource Summary
-- Number of resources of each type (pdf, image, link) uploaded per event.
SELECT e.event_id, e.title,
       SUM(r.resource_type = 'pdf')   AS pdf_count,
       SUM(r.resource_type = 'image') AS image_count,
       SUM(r.resource_type = 'link')  AS link_count,
       COUNT(*)                       AS total_resources
FROM   events e
JOIN   resources r ON r.event_id = e.event_id
GROUP  BY e.event_id, e.title
ORDER  BY e.event_id;
