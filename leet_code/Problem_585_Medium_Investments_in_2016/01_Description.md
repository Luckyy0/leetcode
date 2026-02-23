# Result for Investments in 2016
# *Kết quả cho bài toán Các khoản Đầu tư năm 2016*

## Description
## *Mô tả*

**SQL Schema**

Table: `Insurance`
```
+-------------+-------+
| Column Name | Type  |
+-------------+-------+
| pid         | int   |
| tiv_2015    | float |
| tiv_2016    | float |
| lat         | float |
| lon         | float |
+-------------+-------+
pid is the primary key column for this table.
Each row of this table contains information about one policy where:
pid is the policyholder's policy ID.
tiv_2015 is the total investment value in 2015 and tiv_2016 is the total investment value in 2016.
lat is the latitude of the policy holder's city. It's guaranteed that lat is not NULL.
lon is the longitude of the policy holder's city. It's guaranteed that lon is not NULL.
```

Write an SQL query to report the sum of all total investment values in 2016 `tiv_2016`, for all policyholders who:
*Viết một truy vấn SQL để báo cáo tổng của tất cả các giá trị đầu tư năm 2016 `tiv_2016`, cho tất cả những người mua bảo hiểm mà:*

1.  Have the same `tiv_2015` value as one or more other policyholders.
    *   *Có cùng giá trị `tiv_2015` với một hoặc nhiều người mua bảo hiểm khác.*
2.  Are not located in the same city as any other policyholder (i.e., the (lat, lon) attribute pair must be unique).
    *   *Không ở cùng một thành phố với bất kỳ người mua bảo hiểm nào khác (tức là cặp thuộc tính (lat, lon) phải là duy nhất).*

Round `tiv_2016` to **two decimal places**.
*Làm tròn `tiv_2016` đến **hai chữ số thập phân**.*

The query result format is in the following example.
*Định dạng kết quả truy vấn theo ví dụ sau.*

## Example 1:
## *Ví dụ 1:*

**Input:** 
Insurance table:
```
+-----+----------+----------+-----+-----+
| pid | tiv_2015 | tiv_2016 | lat | lon |
+-----+----------+----------+-----+-----+
| 1   | 10       | 5        | 10  | 10  |
| 2   | 20       | 20       | 20  | 20  |
| 3   | 10       | 30       | 20  | 20  |
| 4   | 10       | 40       | 40  | 40  |
+-----+----------+----------+-----+-----+
```
**Output:** 
```
+----------+
| tiv_2016 |
+----------+
| 45.00    |
+----------+
```
**Explanation:** 
- The first record in the table, with pid 1, has the same tiv_2015 as pid 3 and 4. And its (lat, lon) values are unique.
- The second record with pid 2 has a unique tiv_2015 value.
- The third record with pid 3 has the same tiv_2015 as pid 1 and 4, but its (lat, lon) is not unique - it is the same as pid 2.
- The fourth record with pid 4 has the same tiv_2015 as pid 1 and 3, and its (lat, lon) values are unique.
So, we sum tiv_2016 of pid 1 and 4, which is 5 + 40 = 45.

## Constraints:
## *Ràng buộc:*

*   There are no specific constraints.
Steps: 7301-7303
