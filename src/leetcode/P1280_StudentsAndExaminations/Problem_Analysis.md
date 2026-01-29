# 1280. Students and Examinations / Sinh viên và Các kỳ thi

## Problem Description / Mô tả bài toán
Tables: `Students` (student_id, student_name), `Subjects` (subject_name), `Examinations` (student_id, subject_name).
Find number of times each student attended each exam.
Result: `student_id`, `student_name`, `subject_name`, `attended_exams`.
Order by `student_id`, `subject_name`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Cross Join and Left Join
1. Generate all combinations of (Student, Subject): `Students CROSS JOIN Subjects`.
2. Left Join with `Examinations` aggregated.
   - Or Left Join with `Examinations` then Group By.
   - `COUNT(e.subject_name)` usually works if join condition matches.

Query:
`SELECT s.student_id, s.student_name, sub.subject_name, COUNT(e.subject_name)`
`FROM Students s CROSS JOIN Subjects sub`
`LEFT JOIN Examinations e ON s.student_id = e.student_id AND sub.subject_name = e.subject_name`
`GROUP BY s.student_id, sub.subject_name`.
Caution: Group by student_name too if strict mode, or rely on id.
Order by `student_id`, `subject_name`.

---
