# Analysis for Median Employee Salary
# *Phân tích cho bài toán Lương Nhân viên Trung vị*

## 1. Problem Essence & The Selection of Centroids
## *1. Bản chất vấn đề & Sự lựa chọn các Điểm trọng tâm*

### The Challenge
### *Thách thức*
We need to find the "median" salary for each company. Unlike a standard average, the median is the middle value in a sorted list.
*Chúng ta cần tìm mức lương "trung vị" cho mỗi công ty. Không giống như giá trị trung bình tiêu chuẩn, trung vị là giá trị nằm ở giữa trong một danh sách đã được sắp xếp.*

If a company has an odd number of employees, there is one median. If it has an even number, there are two (by common definition in SQL problems that ask for full rows).
*Nếu một công ty có số lượng nhân viên lẻ, sẽ có một giá trị trung vị. Nếu có số lượng chẵn, sẽ có hai (theo định nghĩa thông thường trong các bài toán SQL yêu cầu trả về toàn bộ hàng).*

---

## 2. Strategy: Rank vs Total Count (Window Functions)
## *2. Chiến lược: Thứ hạng so với Tổng số (Hàm cửa sổ)*

The most robust way to find a median in SQL without a native `MEDIAN()` function is to use ranking and compare it against the total count of elements.
*Cách mạnh mẽ nhất để tìm trung vị trong SQL mà không có hàm `MEDIAN()` bản địa là sử dụng xếp hạng và so sánh nó với tổng số phần tử.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Assign Row Numbers:** Within each company, sort employees by their salary (and `id` as a tie-breaker) and assign a unique rank.
    * **Gán số hàng:** Trong mỗi công ty, hãy sắp xếp nhân viên theo lương của họ (và `id` làm yếu tố phá vỡ sự cân bằng) và gán một thứ hạng duy nhất.*
    `r = ROW_NUMBER() OVER(PARTITION BY company ORDER BY salary, id)`

2.  **Calculate Total Count:** For each row, also get the total number of employees in that company.
    * **Tính tổng số lượng:** Đối với mỗi hàng, bạn cũng cần lấy tổng số nhân viên trong công ty đó.*
    `n = COUNT(*) OVER(PARTITION BY company)`

3.  **The Median Condition:** A row is a median if its rank `r` satisfies the condition:
    * **Điều kiện Trung vị:** Một hàng là trung vị nếu thứ hạng `r` của nó thỏa mãn điều kiện:*
    $r \ge n/2$ AND $r \le n/2 + 1$
    - For $n=5$ (Odd): $r \ge 2.5$ and $r \le 3.5$. Only $r=3$ matches.
    - *Đối với $n=5$ (Lẻ): $r \ge 2.5$ và $r \le 3.5$. Chỉ có $r=3$ là khớp.*
    - For $n=6$ (Even): $r \ge 3$ and $r \le 4$. $r=3, 4$ match.
    - *Đối với $n=6$ (Chẵn): $r \ge 3$ và $r \le 4$. $r=3, 4$ là khớp.*

---

## 3. Structural Advantages & Modern SQL Patterns
## *3. Ưu điểm Cấu trúc & Các mô hình SQL hiện đại*

*   **Window Function Efficiency:** Using `OVER(PARTITION BY...)` allows us to perform aggregation and individual ranking in the same pass, avoiding multiple expensive joins.
    * **Hiệu quả của hàm cửa sổ:** Sử dụng `OVER(PARTITION BY...)` cho phép chúng ta thực hiện tổng hợp và xếp hạng cá nhân trong cùng một lượt, tránh được nhiều phép nối (join) tốn kém.*
*   **Tie-Breaking:** Including `id` in the `ORDER BY` ensures that `ROW_NUMBER()` is deterministic and unique, preventing missing rows if salaries are identical.
    * **Phá vỡ sự cân bằng:** Việc đưa `id` vào `ORDER BY` đảm bảo rằng `ROW_NUMBER()` là xác định và duy nhất, ngăn chặn việc thiếu hàng nếu mức lương giống hệt nhau.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$, where $N$ is the total number of employees. This is due to the sorting required for the window functions.
    * **Độ phức tạp thời gian:** $O(N \log N)$, trong đó $N$ là tổng số nhân viên. Điều này là do thao tác sắp xếp cần thiết cho các hàm cửa sổ.*
*   **Space Complexity:** $O(N)$ for the database to manage the partitioned states and ranking results in memory before filtering.
    * **Độ phức tạp không gian:** $O(N)$ để cơ sở dữ liệu quản lý các trạng thái phân vùng và kết quả xếp hạng trong bộ nhớ trước khi lọc.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Company A Salaries:** `[341, 451, 513, 2341, 15314]` (Sorted)
- n = 5.
- r=1 (341): No.
- r=2 (451): No.
- r=3 (513): **Yes**. (3 is between 2.5 and 3.5).
- r=4, 5: No.
**Company B Salaries:** `[13, 15, 234, 1154, 1221, 1345]` (Sorted)
- n = 6.
- r=1, 2: No.
- r=3 (234): **Yes**. (3 is between 3 and 4).
- r=4 (1154): **Yes**. (4 is between 3 and 4).
- r=5, 6: No.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Use window functions `ROW_NUMBER()` and `COUNT()` for a clean, performant way to extract rank-based statistical measures in SQL.
*Sử dụng các hàm cửa sổ `ROW_NUMBER()` và `COUNT()` để có cách trích xuất các phép đo thống kê dựa trên thứ hạng trong SQL một cách sạch sẽ và hiệu quả.*
---
*Trung vị (Median) là đại diện công bằng nhất cho sự cân bằng, không bị ảnh hưởng bởi những giá trị cực đoan (Outliers). Bằng cách xếp hạng các cá nhân (Rank) và so chiếu với tổng thể (Count), ta tìm thấy những người đứng ở tâm điểm của giá trị, nơi sự hài hòa được xác lập.*
The median (Median) is the fairest representation of balance, not influenced by extreme values (Outliers). By ranking individuals (Rank) and comparing with the whole (Count), we find those standing at the center of value, where harmony is established.
