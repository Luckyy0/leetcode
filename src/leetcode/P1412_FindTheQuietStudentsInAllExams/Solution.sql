/* Write your T-SQL query statement below */
WITH ExamStats AS (
    SELECT 
        exam_id,
        MIN(score) as min_score,
        MAX(score) as max_score
    FROM Exam
    GROUP BY exam_id
),
LoudStudents AS (
    SELECT DISTINCT e.student_id
    FROM Exam e
    JOIN ExamStats es ON e.exam_id = es.exam_id
    WHERE e.score = es.min_score OR e.score = es.max_score
)
SELECT DISTINCT s.student_id, s.student_name
FROM Student s
JOIN Exam e ON s.student_id = e.student_id
WHERE s.student_id NOT IN (SELECT student_id FROM LoudStudents)
ORDER BY s.student_id;
