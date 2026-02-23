# Result for Winning Candidate
# *Kết quả cho bài toán Ứng cử viên Chiến thắng*

## Description
## *Mô tả*

**SQL Schema**

Table: `Candidate`
```
+-------------+----------+
| Column Name | Type     |
+-------------+----------+
| id          | int      |
| name        | varchar  |
+-------------+----------+
id is the primary key column for this table.
Each row of this table contains information about the id and the name of a candidate.
```

Table: `Vote`
```
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| candidateId | int  |
+-------------+------+
id is an auto-increment primary key.
candidateId is a foreign key to id from the Candidate table.
Each row of this table contains information about the candidate id who received a vote.
```

Write an SQL query to report the name of the **winning candidate** (i.e., the candidate who received the most votes).
*Viết một truy vấn SQL để báo cáo tên của **ứng cử viên chiến thắng** (tức là ứng cử viên nhận được nhiều phiếu bầu nhất).*

The test cases are generated so that **exactly one** candidate wins the elections.
*Các trường hợp kiểm thử được tạo ra sao cho **chính xác một** ứng cử viên thắng cử.*

The query result format is in the following example.
*Định dạng kết quả truy vấn theo ví dụ sau.*

## Example 1:
## *Ví dụ 1:*

**Input:** 
Candidate table:
```
+----+------+
| id | name |
+----+------+
| 1  | A    |
| 2  | B    |
| 3  | C    |
| 4  | D    |
| 5  | E    |
+----+------+
```
Vote table:
```
+----+-------------+
| id | candidateId |
+----+-------------+
| 1  | 2           |
| 2  | 4           |
| 3  | 3           |
| 4  | 2           |
| 5  | 5           |
+----+-------------+
```
**Output:** 
```
+------+
| name |
+------+
| B    |
+------+
```
**Explanation:** 
Candidate B has 2 votes. Candidates C, D, and E have 1 vote each. The winner is candidate B.
*Giải thích: Ứng cử viên B có 2 phiếu bầu. Các ứng cử viên C, D và E mỗi người có 1 phiếu bầu. Người chiến thắng là ứng cử viên B.*

## Constraints:
## *Ràng buộc:*

*   The candidate who wins the election exists.
