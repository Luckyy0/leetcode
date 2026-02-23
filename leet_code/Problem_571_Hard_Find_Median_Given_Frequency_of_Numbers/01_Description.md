# Result for Find Median Given Frequency of Numbers
# *Kết quả cho bài toán Tìm Trung vị dựa trên Tần suất của các Con số*

## Description
## *Mô tả*

**SQL Schema**

Table: `Numbers`
```
+-------------+------+
| Column Name | Type |
+-------------+------+
| num         | int  |
| frequency   | int  |
+-------------+------+
num is the primary key for this table.
Each row of this table shows the frequency of a number.
```

The **median** is the value separating the higher half from the lower half of a data sample.
* **Trung vị** là giá trị phân chia nửa trên và nửa dưới của một mẫu dữ liệu.*

Write an SQL query to report the **median** of all the numbers in the `Numbers` table. Round the median to **one decimal point**.
*Viết một truy vấn SQL để báo cáo **trung vị** của tất cả các con số trong bảng `Numbers`. Làm tròn trung vị đến **một chữ số thập phân**.*

The query result format is in the following example.
*Định dạng kết quả truy vấn theo ví dụ sau.*

## Example 1:
## *Ví dụ 1:*

**Input:** 
Numbers table:
```
+-----+-----------+
| num | frequency |
+-----+-----------+
| 0   | 7         |
| 1   | 1         |
| 2   | 3         |
| 3   | 1         |
+-----+-----------+
```
**Output:** 
```
+--------+
| median |
+--------+
| 0.0    |
+--------+
```
**Explanation:** 
If we write down all the numbers: 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 3.
The length of the list is 12, so there are two middle numbers: the sixth and the seventh.
Both are 0, so the median is 0.
*Giải thích: Nếu chúng ta viết ra tất cả các con số: 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 3. Độ dài của danh sách là 12, vì vậy có hai số ở giữa: số thứ sáu và số thứ bảy. Cả hai đều là 0, vì vậy trung vị là 0.*

## Constraints:
## *Ràng buộc:*

*   The frequency of each number is at least 1.
*   The total number of rows in the table is at most 10^5.
