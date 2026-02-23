# Analysis for Investments in 2016
# *Phân tích cho bài toán Các khoản Đầu tư năm 2016*

## 1. Problem Essence & The Filtering Criteria
## *1. Bản chất vấn đề & Các Tiêu chí Lọc*

### The Challenge
### *Thách thức*
We need to sum `tiv_2016` values for a specific subset of policyholders defined by two distinct conditions:
*Chúng ta cần tính tổng giá trị `tiv_2016` cho một tập hợp con cụ thể những người mua bảo hiểm được định nghĩa bởi hai điều kiện riêng biệt:*

1.  **Shared Investment History:** Their `tiv_2015` must not be unique (at least one other person has the same value).
    * **Lịch sử Đầu tư Chung:** `tiv_2015` của họ không được là duy nhất (ít nhất một người khác có cùng giá trị).*
2.  **Unique Location:** Their `(lat, lon)` combination must be unique (no one else is in the same spot).
    * **Vị trí Duy nhất:** Tổ hợp `(lat, lon)` của họ phải là duy nhất (không có ai khác ở cùng một vị trí).*

---

## 2. Strategy: Window Functions for Occurrence Counting
## *2. Chiến lược: Hàm cửa sổ để đếm số lần xuất hiện*

The most efficient way to check for uniqueness or duplication across multiple records without multiple self-joins is to use the `COUNT(*) OVER(...)` window function.
*Cách hiệu quả nhất để kiểm tra tính duy nhất hoặc trùng lặp qua nhiều bản ghi mà không cần nhiều phép tự nối (self-join) là sử dụng hàm cửa sổ `COUNT(*) OVER(...)`.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Count by Value (`tiv_2015`):** Record how many times each `tiv_2015` value appears.
    * **Đếm theo Giá trị (`tiv_2015`):** Ghi lại số lần mỗi giá trị `tiv_2015` xuất hiện.*
    `COUNT(*) OVER(PARTITION BY tiv_2015) as count_val`

2.  **Count by Location (`lat, lon`):** Record how many times each position `(lat, lon)` appears.
    * **Đếm theo Vị trí (`lat, lon`):** Ghi lại số lần mỗi vị trí `(lat, lon)` xuất hiện.*
    `COUNT(*) OVER(PARTITION BY lat, lon) as count_loc`

3.  **Filter and Sum:** In the outer query, filter the rows based on the rules:
    * **Lọc và Tính tổng:** Trong truy vấn bên ngoài, hãy lọc các hàng dựa trên các quy tắc:*
    - `count_val > 1` (Not unique in 2015).
    - `count_loc = 1` (Unique in location).
    - Sum the identified `tiv_2016` values and round to 2 decimal places.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Window Function Power:** This approach processes the table in a single pass (plus sorting/hashing for partitions), which is much faster than using multiple `IN (SELECT ...)` subqueries.
    * **Sức mạnh của hàm cửa sổ:** Cách tiếp cận này xử lý bảng trong một lượt duy nhất (cộng với việc sắp xếp/băm cho các phân vùng), nhanh hơn nhiều so với việc sử dụng nhiều truy vấn con `IN (SELECT ...)`. *
*   **Precision:** Using `ROUND(..., 2)` ensures compliance with the formatting requirement.
    * **Độ chính xác:** Sử dụng `ROUND(..., 2)` đảm bảo tuân thủ yêu cầu về định dạng.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ where $N$ is the number of rows in the `Insurance` table. This is dominated by the sorting/partitioning of the window functions.
    * **Độ phức tạp thời gian:** $O(N \log N)$, trong đó $N$ là số hàng trong bảng `Insurance`. Điều này bị chiếm ưu thế bởi việc sắp xếp/phân vùng của các hàm cửa sổ.*
*   **Space Complexity:** $O(N)$ for the database to store the partitioned counts during execution.
    * **Độ phức tạp không gian:** $O(N)$ để cơ sở dữ liệu lưu trữ các bộ đếm phân vùng trong quá trình thực thi.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:**
- P1: tiv15=10, loc=(10,10) -> count_val=3, count_loc=1. **MATCH**.
- P2: tiv15=20, loc=(20,20) -> count_val=1, count_loc=2. FAIL (unique tiv15).
- P3: tiv15=10, loc=(20,20) -> count_val=3, count_loc=2. FAIL (loc not unique).
- P4: tiv15=10, loc=(40,40) -> count_val=3, count_loc=1. **MATCH**.
**Result:** Sum(P1.tiv16, P4.tiv16) = 5 + 40 = 45.00.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Use `COUNT(*) OVER(PARTITION BY ...)` for filtering criteria involving frequencies or uniqueness across different dimensions.
*Sử dụng `COUNT(*) OVER(PARTITION BY ...)` cho các tiêu chí lọc liên quan đến tần suất hoặc tính duy nhất qua các khía cạnh khác nhau.*
---
*Giá trị thực sự của một cá nhân (Insurance record) nằm ở chỗ họ vừa mang dấu ấn của cộng đồng (Shared tiv_2015) vừa giữ trọn vẹn bản sắc riêng tư (Unique location). Trong sự giao thoa giữa cái chung và cái riêng, ta tìm thấy những điểm dữ liệu xứng đáng để đầu tư (Investments).*
The true value of an individual (Insurance record) lies in the fact that they both carry the mark of the community (Shared tiv_2015) and fully maintain their own private identity (Unique location). In the intersection between the common and the private, we find data points worthy of investment (Investments).
