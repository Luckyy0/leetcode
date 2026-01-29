# 578. Get Highest Answer Rate Question / Lấy Câu Hỏi Có Tỷ Lệ Trả Lời Cao Nhất

## Problem Description / Mô tả bài toán
Write an SQL query to report the question with the highest answer rate.
Viết một truy vấn SQL để báo cáo câu hỏi có tỷ lệ trả lời cao nhất.

The answer rate for a question is the number of times that question was answered divided by the number of times it was shown.
Tỷ lệ trả lời cho một câu hỏi là số lần câu hỏi đó được trả lời chia cho số lần nó được hiển thị.

Table: `SurveyLog`
```
+----+-----------+-------------+-----------+-------+
| id | action    | question_id | answer_id | q_num |
+----+-----------+-------------+-----------+-------+
| 5  | show      | 285         | null      | 1     |
| 5  | answer    | 285         | 124124    | 1     |
| 5  | show      | 369         | null      | 2     |
| 5  | skip      | 369         | null      | 2     |
+----+-----------+-------------+-----------+-------+
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Conditional Aggregation / Tổng Hợp Có Điều Kiện
We need `Count(action='answer') / Count(action='show')` for each `question_id`.
Note: "show" usually appears for every interaction?
Actually, `action` column has values 'show', 'answer', 'skip'.
Rate = `SUM(CASE WHEN action = 'answer' THEN 1 ELSE 0 END) / SUM(CASE WHEN action = 'show' THEN 1 ELSE 0 END)`.

Query:
1. Group by `question_id`.
2. Compute rate.
3. Order by rate DESC, then question_id ASC (if tie-breaking needed).
4. Limit 1.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Ratio Calculation with Group By

**Algorithm**:
1.  Group logs by `question_id`.
2.  Count 'answer' actions.
3.  Count 'show' actions.
4.  Calculate ratio.
5.  Sort descending and pick top.

---
