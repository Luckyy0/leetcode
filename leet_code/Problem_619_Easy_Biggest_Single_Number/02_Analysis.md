# Analysis for Biggest Single Number
# *Phân tích cho bài toán Số Duy nhất Lớn nhất*

## 1. Problem Essence & Uniqueness Filter
## *1. Bản chất vấn đề & Bộ lọc Tính Duy nhất*

### The Challenge
### *Thách thức*
We need to find the maximum value among numbers that appear exactly once in a table. If no such numbers exist, we must return `NULL`.
*Chúng ta cần tìm giá trị lớn nhất trong số các số xuất hiện đúng một lần trong một bảng. Nếu không có số nào như vậy tồn tại, chúng ta phải trả về `NULL`.*

The key is to first identify the "single numbers" and then apply a `MAX` function.
*Chìa khóa là trước tiên xác định các "số duy nhất" và sau đó áp dụng hàm `MAX`.*

---

## 2. Strategy: Grouping and Subqueries
## *2. Chiến lược: Phân nhóm và Truy vấn con*

We use `GROUP BY` and `HAVING` to find numbers with a frequency of 1.
*Chúng ta sử dụng `GROUP BY` và `HAVING` để tìm các số có tần suất bằng 1.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Find Single Numbers:** 
    * **Tìm các Số duy nhất:** *
    - `SELECT num FROM MyNumbers GROUP BY num HAVING COUNT(*) = 1`
    - This query returns all numbers that are unique in the table.
    - *Truy vấn này trả về tất cả các số duy nhất trong bảng.*

2.  **Find Maximum:** Wrap the previous query in a subquery and select the `MAX(num)`.
    * **Tìm giá trị Lớn nhất:** Bao bọc truy vấn trước đó trong một truy vấn con và chọn `MAX(num)`.*
    - `SELECT MAX(num) AS num FROM (Subquery) AS t`

3.  **Handling NULL:** The `MAX()` function on an empty set (if no single numbers were found) naturally returns `NULL`, which perfectly matches the requirement.
    * **Xử lý NULL:** Hàm `MAX()` trên một tập hợp rỗng (nếu không tìm thấy số duy nhất nào) sẽ tự động trả về `NULL`, điều này hoàn toàn phù hợp với yêu cầu.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Subquery Alias:** Always remember to alias subqueries in the `FROM` clause in MySQL (e.g., `AS t`).
    * **Bí danh Truy vấn con:** Luôn nhớ đặt bí danh cho các truy vấn con trong mệnh đề `FROM` trong MySQL (ví dụ: `AS t`).*
*   **Logical Simplicity:** This approach is declarative and easy to verify, clearly separating the identification of single numbers from the selection of the biggest one.
    * **Sự đơn giản về Logic:** Cách tiếp cận này mang tính khai báo và dễ dàng xác minh, tách biệt rõ ràng việc xác định các số duy nhất khỏi việc lựa chọn số lớn nhất.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ or $O(N)$, depending on the sorting/hashing method used for `GROUP BY`. $N$ is the number of rows in the table.
    * **Độ phức tạp thời gian:** $O(N \log N)$ hoặc $O(N)$, tùy thuộc vào phương pháp sắp xếp/băm được sử dụng cho `GROUP BY`. $N$ là số hàng trong bảng.*
*   **Space Complexity:** $O(U)$ where $U$ is the number of unique numbers in the table, to store the grouped counts.
    * **Độ phức tạp không gian:** $O(U)$ trong đó $U$ là số lượng các số duy nhất trong bảng, để lưu trữ các bộ đếm đã nhóm.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** [8, 8, 3, 3, 1, 4, 5, 6]
1. Grouping:
   - 8: Count 2
   - 3: Count 2
   - 1: Count 1
   - 4: Count 1
   - 5: Count 1
   - 6: Count 1
2. Filter (Count=1): [1, 4, 5, 6]
3. Max: 6.
**Result:** 6.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For problems requiring the maximum of a filtered set (especially when the filter involves aggregation like frequency), use a two-step query structure: filter first in a subquery, then aggregate in the outer layer.
*Đối với các bài toán yêu cầu giá trị lớn nhất của một tập hợp đã lọc (đặc biệt khi bộ lọc liên quan đến tổng hợp như tần suất), hãy sử dụng cấu trúc truy vấn hai bước: lọc trước trong một truy vấn con, sau đó tổng hợp ở lớp bên ngoài.*
---
*Sự quý hiếm (Uniqueness) tạo nên giá trị, nhưng sự vượt trội (Maximum) định nghĩa đỉnh cao. Trong một tập hợp đầy những sự lặp lại (Duplicates), những gì duy nhất (Single numbers) luôn thu hút sự chú ý. Dữ liệu dạy ta cách bóc tách những tạp âm để tìm thấy những viên ngọc sáng nhất (Biggest single number).*
Uniqueness (Uniqueness) creates value, but superiority (Maximum) defines the peak. In a set full of repetitions (Duplicates), what is unique (Single numbers) always attracts attention. Data teaches us how to peel away the noise to find the brightest gems (Biggest single number).
