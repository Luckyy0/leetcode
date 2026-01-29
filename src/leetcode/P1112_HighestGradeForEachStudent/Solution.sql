/* Write your T-SQL query statement below */
WITH RankedGrades AS (
    SELECT student_id, course_id, grade,
           ROW_NUMBER() OVER (PARTITION BY student_id ORDER BY grade DESC, course_id ASC) as rn
    FROM Enrollments
)
SELECT student_id, course_id, grade
FROM RankedGrades
WHERE rn = 1
ORDER BY student_id;
