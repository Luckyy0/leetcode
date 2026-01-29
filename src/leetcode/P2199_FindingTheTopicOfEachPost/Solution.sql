-- SQL Solution for P2199
WITH PostTopics AS (
    SELECT DISTINCT
        p.post_id,
        k.topic_id
    FROM Posts p
    JOIN Keywords k 
    ON CONCAT(' ', LOWER(p.content), ' ') LIKE CONCAT('% ', LOWER(k.word), ' %')
)
SELECT 
    p.post_id,
    COALESCE(GROUP_CONCAT(pt.topic_id ORDER BY pt.topic_id), 'Ambiguous!') AS topic
FROM Posts p
LEFT JOIN PostTopics pt ON p.post_id = pt.post_id
GROUP BY p.post_id;
