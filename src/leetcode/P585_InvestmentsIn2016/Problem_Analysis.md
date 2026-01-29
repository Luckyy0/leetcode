# 585. Investments in 2016 / Đầu Tư Vào Năm 2016

## Problem Description / Mô tả bài toán
Write an SQL query to report the sum of all total investment values in 2016 (`tiv_2016`), for all policyholders who:
Viết một truy vấn SQL để báo cáo tổng của tất cả các giá trị đầu tư trong năm 2016 (`tiv_2016`), cho tất cả các chủ hợp đồng mà:

- Have the same `tiv_2015` value as one or more other policyholders. / Có cùng giá trị `tiv_2015` như một hoặc nhiều chủ hợp đồng khác.
- Are not located in the same city as any other policyholder (i.e., the (`lat`, `lon`) attribute pairs must be unique). / Không nằm cùng thành phố với bất kỳ chủ hợp đồng nào khác (tức là các cặp thuộc tính (`lat`, `lon`) phải là duy nhất).

Round `tiv_2016` to two decimal places.
Làm tròn `tiv_2016` đến hai chữ số thập phân.

Table: `Insurance`
```
+-----+----------+----------+-----+-----+
| pid | tiv_2015 | tiv_2016 | lat | lon |
+-----+----------+----------+-----+-----+
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Subqueries / Window Functions / Truy Vấn Con / Hàm Cửa Sổ
Condition 1: `tiv_2015` count > 1.
Condition 2: `(lat, lon)` count == 1.

Query using Window Functions:
```sql
WITH Stats AS (
    SELECT tiv_2016,
           COUNT(*) OVER (PARTITION BY tiv_2015) as cnt_2015,
           COUNT(*) OVER (PARTITION BY lat, lon) as cnt_loc
    FROM Insurance
)
SELECT ROUND(SUM(tiv_2016), 2) as tiv_2016
FROM Stats
WHERE cnt_2015 > 1 AND cnt_loc = 1
```

### Complexity / Độ phức tạp
- **Time**: Depends on DB (usually sort-merge join).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Filtered Aggregation

**Algorithm**:
1.  Identify TIV_2015 frequencies.
2.  Identify Location frequencies.
3.  Sum TIV_2016 for rows meeting criteria (Freq_2015 > 1 AND Freq_Loc = 1).
4.  Round result.

---
