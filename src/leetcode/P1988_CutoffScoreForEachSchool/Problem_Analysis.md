# Problem Analysis: Cutoff Score for Each School

## Problem Description
Table `Schools` (school_id, capacity).
Table `Exam` (score, student_count).
"Cutoff score is the minimum score... such that the number of students... fits in the capacity."
Actually: "Find the minimum score such that the number of students with score >= min_score is <= capacity"?
Usually simpler logic:
"Cutoff Score for Each School".
Select `score` from Exam such that `student_count <= capacity`.
Pick min score? Or max score? Or specific?
Problem logic: "Return school_id, score. If no score found, -1."
Actually, standard problem logic:
For each school, match with Exam scores where `student_count <= capacity`.
Pick the MIN score among valid ones? Or MAX?
Usually maximizing enrollment means picking lowest valid score?
Wait, if `student_count` in Exam table represents students achieving *exactly* `score`? Or *at least*?
If `student_count` is "number of students who applied with that score", filtering by capacity usually means checking total?
Let's check P1988 specific:
"Report the school_id and the score such that `count` <= `capacity`. If multiple scores satisfy, choose the minimum score. If no score satisfies, result -1."
Wait. Does `Exam` have cumulative counts? No.
Maybe matching any exam row?
Let's assume:
`Schools` (school_id, capacity). `Exam` (score, student_count).
Join condition: `Exam.student_count <= Schools.capacity`.
Group by `school_id`.
Select `MIN(score)`.
If no match, score -1.
Need `LEFT JOIN`.

## Implementation Details
-   Left join.
-   Group by.
-   `COALESCE(MIN(score), -1)`.
