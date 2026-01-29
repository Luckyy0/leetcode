-- SQL Solution for P2026
SELECT problem_id
FROM Problems
WHERE (likes / (likes + dislikes)) < 0.6
ORDER BY problem_id;
