# 1412. Find the Quiet Students in All Exams / Tìm Sinh viên Trầm tính trong Tất cả các Kỳ thi

## Problem Description / Mô tả bài toán
Tables `Student` (student_id, student_name), `Exam` (exam_id, student_id, score).
Quiet student:
- Took at least one exam.
- Didn't calculate min or max score in ANY exam they took.
Return list ordered by id.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Window Functions (Min/Max)
1. Determine min/max score per exam. (CTE or Window `MIN() OVER (PARTITION BY exam_id)`).
2. Flag students who got min or max in ANY exam.
3. Select students who took exams AND are NOT in the flagged list.

---
