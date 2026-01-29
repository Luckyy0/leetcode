# 1112. Highest Grade For Each Student / Điểm Cao nhất Cho Mỗi Học sinh

## Problem Description / Mô tả bài toán
Table `Enrollments`: `student_id`, `course_id`, `grade`.
Write a SQL query to find the highest grade with its corresponding course for each student. In case of a tie, you should find the course with the smallest `course_id`.
Viết một truy vấn SQL để tìm điểm cao nhất với khóa học tương ứng cho mỗi học sinh. Trong trường hợp hòa, bạn nên tìm khóa học có `course_id` nhỏ nhất.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Window Functions (Row Number) / Hàm Cửa sổ SQL (Số dòng)
Rank courses for each student by grade DESC, then course_id ASC.
Pick rank 1.

Query:
`SELECT student_id, course_id, grade FROM (SELECT *, ROW_NUMBER() OVER (PARTITION BY student_id ORDER BY grade DESC, course_id ASC) as rn FROM Enrollments) t WHERE rn = 1`.

---
