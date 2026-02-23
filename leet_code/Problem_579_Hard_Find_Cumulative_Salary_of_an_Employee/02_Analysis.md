# Analysis for Find Cumulative Salary of an Employee
# *Phân tích cho bài toán Tìm Lương Tích lũy của một Nhân viên*

## 1. Problem Essence & The Moving Window
## *1. Bản chất vấn đề & Cửa sổ Di động*

### The Challenge
### *Thách thức*
We need to calculate a 3-month rolling sum of salaries for each employee, while excluding their very last recorded month.
*Chúng ta cần tính toán tổng lương lũy kế trong 3 tháng cho mỗi nhân viên, đồng thời loại trừ tháng được ghi nhận cuối cùng của họ.*

The exclusion of the "most recent month" adds a layer of complexity on top of the typical cumulative sum.
*Việc loại trừ "tháng gần nhất" tạo thêm một lớp phức tạp bên trên phép tính tổng tích lũy thông thường.*

---

## 2. Strategy: Window Functions with Frames and Filtering
## *2. Chiến lược: Hàm cửa sổ với Khung và Bộ lọc*

Modern SQL provides window functions that can calculate sums over a specific "frame" or range of rows.
*SQL hiện đại cung cấp các hàm cửa sổ có thể tính tổng trên một "khung" (frame) hoặc dải hàng cụ thể.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Exclude the Most Recent Month:** First, identify the maximum month for each employee and filter it out. This can be done using `MAX() OVER(PARTITION BY id)`.
    * **Loại trừ Tháng Gần nhất:** Đầu tiên, xác định tháng lớn nhất cho mỗi nhân viên và lọc bỏ tháng đó. Việc này có thể thực hiện bằng `MAX() OVER(PARTITION BY id)`.*

2.  **Calculate 3-Month Cumulative Sum:** For the remaining months, use the `SUM()` window function with an auxiliary range specification.
    * **Tính Tổng Tích lũy 3 tháng:** Đối với các tháng còn lại, hãy sử dụng hàm cửa sổ `SUM()` với một chỉ định phạm vi bổ trợ.*
    `SUM(salary) OVER(PARTITION BY id ORDER BY month ROWS BETWEEN 2 PRECEDING AND CURRENT ROW)`
    - `2 PRECEDING AND CURRENT ROW` ensures we capture the current month and the two months before it (total 3).
    - *`2 PRECEDING AND CURRENT ROW` đảm bảo chúng ta lấy được tháng hiện tại và hai tháng trước đó (tổng cộng 3).*

3.  **Final Order:** Sort the result by `id` ascending and `month` descending.
    * **Sắp xếp Cuối cùng:** Sắp xếp kết quả theo `id` tăng dần và `month` giảm dần.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Frame Precision:** Using `ROWS BETWEEN` is more precise for rolling sums than trying to self-join the table three times, which would be extremely inefficient and hard to read.
    * **Độ chính xác của Khung:** Sử dụng `ROWS BETWEEN` chính xác hơn cho các tổng tích lũy so với việc cố gắng tự nối (self-join) bảng ba lần, điều này sẽ cực kỳ kém hiệu quả và khó đọc.*
*   **Decoupled Logic:** Identifying the max month in a Common Table Expression (CTE) or subquery allows the main summation logic to be clean and focused.
    * **Tách biệt Logic:** Xác định tháng lớn nhất trong một Biểu thức bảng chung (CTE) hoặc truy vấn con cho phép logic tính tổng chính trở nên sạch sẽ và tập trung.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$, where $N$ is the number of rows in the `Employee` table. The sorting required for partitioning and ordering the window functions dominant.
    * **Độ phức tạp thời gian:** $O(N \log N)$, trong đó $N$ là số hàng trong bảng `Employee`. Thao tác sắp xếp cần thiết cho việc phân vùng và thứ tự của các hàm cửa sổ chiếm ưu thế.*
*   **Space Complexity:** $O(N)$ for the result of the window operations and temporary sorting states.
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Employee 1:** M1(20), M2(30), M3(40), M4(60).
1. **Exclude Max:** Max is M4. Remaining: M1, M2, M3.
2. **Window Processing:**
   - M1: sum=20 (only 1 row).
   - M2: sum=20+30=50 (2 rows).
   - M3: sum=20+30+40=90 (3 rows).
3. **Filter result:** `(1, 1, 20), (1, 2, 50), (1, 3, 90)`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Use the `ROWS BETWEEN` clause in window functions to handle rolling windows, and use `PARTITION BY` with `MAX()` to identify lifecycle boundaries (like the most recent month).
*Sử dụng mệnh đề `ROWS BETWEEN` trong các hàm cửa sổ để xử lý các cửa sổ di động, và sử dụng `PARTITION BY` với `MAX()` để xác định ranh giới vòng đời (như tháng gần nhất).*
---
*Tiền lương tích lũy (Cumulative Salary) phản ánh sự bồi đắp của công sức qua thời gian. Bằng cách nhìn lại quá khứ (PRECEDING) trong một khoảng thời gian nhất định (3 months), ta thấy được bức tranh toàn cảnh về sự cống hiến. Tuy nhiên, trong phân tích, đôi khi ta phải tạm gạt bỏ những gì mới nhất (Exclude Max Month) để có một cái nhìn khách quan và ổn định nhất.*
Cumulative Salary (Cumulative Salary) reflects the accumulation of effort over time. By looking back at the past (PRECEDING) in a certain period (3 months), we see the overall picture of dedication. However, in analysis, sometimes we have to temporarily set aside the latest (Exclude Max Month) to have the most objective and stable view.
