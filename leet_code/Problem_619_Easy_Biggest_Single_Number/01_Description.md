# Result for Biggest Single Number
# *Kết quả cho bài toán Số Duy nhất Lớn nhất*

## Description
## *Mô tả*

**SQL Schema**

Table: `MyNumbers`
```
+-------------+------+
| Column Name | Type |
+-------------+------+
| num         | int  |
+-------------+------+
There is no primary key for this table. It may contain duplicates.
Each row of this table contains an integer.
```

A **single number** is a number that appeared only once in the `MyNumbers` table.
* **Số duy nhất** là một số chỉ xuất hiện đúng một lần trong bảng `MyNumbers`.*

Write an SQL query to report the largest **single number**. If there is no such number, report `null`.
*Viết một truy vấn SQL để báo cáo **số duy nhất** lớn nhất. Nếu không có số nào như vậy, hãy báo cáo `null`.*

The query result format is in the following example.
*Định dạng kết quả truy vấn theo ví dụ sau.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** 
MyNumbers table:
```
+-----+
| num |
+-----+
| 8   |
| 8   |
| 3   |
| 3   |
| 1   |
| 4   |
| 5   |
| 6   |
+-----+
```
**Output:** 
```
+-----+
| num |
+-----+
| 6   |
+-----+
```
**Explanation:** The single numbers are 1, 4, 5, and 6. Since 6 is the largest single number, we return it.

## Example 2:
## *Ví dụ 2:*

**Input:** 
MyNumbers table:
```
+-----+
| num |
+-----+
| 8   |
| 8   |
| 7   |
| 7   |
| 3   |
| 3   |
| 3   |
+-----+
```
**Output:** 
```
+------+
| num  |
+------+
| null |
+------+
```
**Explanation:** There are no single numbers in the input table so we return null.

## Constraints:
## *Ràng buộc:*

*   There are no specific constraints.
