# Result for Get Highest Answer Rate Question
# *Kết quả cho bài toán Lấy Câu hỏi có Tỷ lệ Trả lời Cao nhất*

## Description
## *Mô tả*

**SQL Schema**

Table: `SurveyLog`
```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| action      | ENUM    |
| question_id | int     |
| answer_id   | int     |
| q_num       | int     |
| timestamp   | int     |
+-------------+---------+
id is the primary key column for this table.
action is an ENUM of the type: 'show', 'answer', or 'skip'.
Each row of this table indicates the action that a user took for a question with a specific id and at a specific timestamp.
answer_id will be null if the action is 'show' or 'skip'.
```

The **answer rate** is the number of times a question was answered divided by the number of times the question was shown.
* **Tỷ lệ trả lời** là số lần một câu hỏi được trả lời chia cho số lần câu hỏi đó được hiển thị.*

Write an SQL query to report the `question_id` with the highest **answer rate**. If multiple questions have the same maximum **answer rate**, report the one with the smallest `question_id`.
*Viết một truy vấn SQL để báo cáo `question_id` có **tỷ lệ trả lời** cao nhất. Nếu có nhiều câu hỏi có cùng tỷ lệ trả lời tối đa, hãy báo cáo câu hỏi có `question_id` nhỏ nhất.*

The query result format is in the following example.
*Định dạng kết quả truy vấn theo ví dụ sau.*

## Example 1:
## *Ví dụ 1:*

**Input:** 
SurveyLog table:
```
+----+--------+-------------+-----------+-------+-----------+
| id | action | question_id | answer_id | q_num | timestamp |
+----+--------+-------------+-----------+-------+-----------+
| 5  | show   | 285         | null      | 1     | 123       |
| 5  | answer | 285         | 124124    | 1     | 124       |
| 5  | show   | 369         | null      | 2     | 125       |
| 5  | skip   | 369         | null      | 2     | 126       |
+----+--------+-------------+-----------+-------+-----------+
```
**Output:** 
```
+------------+
| survey_log |
+------------+
| 285        |
+------------+
```
**Explanation:** 
question 285 was shown 1 time and answered 1 time. The answer rate of question 285 is 1.0.
question 369 was shown 1 time and answered 0 times. The answer rate of question 369 is 0.0.
question 285 has the highest answer rate.
*Giải thích: Câu hỏi 285 được hiển thị 1 lần và trả lời 1 lần. Tỷ lệ trả lời của câu hỏi 285 là 1.0. Câu hỏi 369 được hiển thị 1 lần và trả lời 0 lần. Tỷ lệ trả lời của câu hỏi 369 là 0.0. Câu hỏi 285 có tỷ lệ trả lời cao nhất.*

## Constraints:
## *Ràng buộc:*

*   The `answer_id` is unique and only exists for 'answer' action.
