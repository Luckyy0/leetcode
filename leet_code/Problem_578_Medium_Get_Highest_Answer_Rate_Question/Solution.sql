/*
Problem: 578. Get Highest Answer Rate Question
Difficulty: Medium
Description: Find question_id with max (answer_count / show_count).
Approach: Use conditional SUM for answers and shows, then sort and limit 1.
*/

SELECT 
    question_id as survey_log
FROM 
    SurveyLog
GROUP BY 
    question_id
ORDER BY 
    -- Ratio = answers / shows
    -- We can use SUM(CASE...) or simply COUNT(answer_id) if it's only present for answers
    (SUM(CASE WHEN action = 'answer' THEN 1 ELSE 0 END) / 
     SUM(CASE WHEN action = 'show' THEN 1 ELSE 0 END)) DESC, 
    question_id ASC
LIMIT 1;
