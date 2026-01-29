# 569. Median Employee Salary / Lương Trung Bình Của Nhân Viên

## Problem Description / Mô tả bài toán
Write an SQL query to find the median salary of each company. Bonus points if you can solve it without using any built-in SQL functions.
Viết một truy vấn SQL để tìm lương trung vị của mỗi công ty. Điểm thưởng nếu bạn có thể giải quyết nó mà không sử dụng bất kỳ hàm SQL tích hợp nào.

Table: `Employee`
```
+-----+------------+--------+
|Id   | Company    | Salary |
+-----+------------+--------+
|1    | A          | 2341   |
|2    | A          | 341    |
|3    | A          | 15     |
|4    | A          | 15314  |
|5    | A          | 451    |
|6    | A          | 513    |
|7    | B          | 15     |
|8    | B          | 13     |
|9    | B          | 1154   |
|10   | B          | 1345   |
|11   | B          | 1221   |
|12   | B          | 234    |
|13   | C          | 2345   |
|14   | C          | 2645   |
|15   | C          | 2645   |
|16   | C          | 2652   |
|17   | C          | 65     |
+-----+------------+--------+
```

Output:
```
+-----+------------+--------+
|Id   | Company    | Salary |
+-----+------------+--------+
|5    | A          | 451    |
|6    | A          | 513    |
|12   | B          | 234    |
|9    | B          | 1154   |
|14   | C          | 2645   |
+-----+------------+--------+
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Subquery Ranking / Xếp Hạng Truy Vấn Con
The median is the middle element in a sorted list.
For a count `N`, the median indices are:
- `(N+1)/2` (if N odd)
- `N/2` and `N/2 + 1` (if N even)
Basically, the rank `r` such that `N/2 <= r <= N/2 + 1` (integer division approx). Or more precise: `abs(rank - (N+1)/2) < 1`? No.
The condition is usually: `Rank` is between `N/2` and `N/2 + 1` (for 0-based?) or similar range.
Specifically, `Rank` should be within `Total_Count / 2` and `Total_Count / 2 + 1` roughly.

Common SQL approach without window functions:
`WHERE ABS(Rank_Asc - Rank_Desc) <= 1`? No.
Another way:
`WHERE row_number BETWEEN total_count / 2.0 AND total_count / 2.0 + 1`.

Query using Window Functions (easier):
```sql
WITH Ranked AS (
  SELECT *,
         ROW_NUMBER() OVER (PARTITION BY Company ORDER BY Salary) as rn,
         COUNT(*) OVER (PARTITION BY Company) as cnt
  FROM Employee
)
SELECT Id, Company, Salary
FROM Ranked
WHERE rn >= cnt / 2.0 AND rn <= cnt / 2.0 + 1
```

### Complexity / Độ phức tạp
- **Time**: O(N log N) for sorting.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Window Function Filters

**Algorithm**:
1.  Rank employees by salary within each company.
2.  Count total employees per company.
3.  Select rows where rank falls in the median range `[cnt/2, cnt/2 + 1]`.

---
