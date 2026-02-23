# Analysis for Human Traffic of Stadium
# *Phân tích cho bài toán Lưu lượng Người tại Sân vận động*

## 1. Problem Essence & Consecutive Sequences
## *1. Bản chất vấn đề & Các Chuỗi liên tiếp*

### The Challenge
### *Thách thức*
We need to find groups of 3 or more rows where:
*Chúng ta cần tìm các nhóm gồm 3 hàng trở lên trong đó:*
1.  Each row has `people >= 100`.
    *Mỗi hàng có `people >= 100`.*
2.  The IDs are strictly consecutive.
    *Các ID phải liên tiếp nhau.*

The difficulty lies in identifying islands of data (consecutive IDs) that satisfy a condition and filtering them based on the size of the island.
*Khó khăn nằm ở việc xác định các "đảo" dữ liệu (các ID liên tiếp) thỏa mãn một điều kiện và lọc chúng dựa trên kích thước của hòn đảo đó.*

---

## 2. Strategy: Grouping by Difference
## *2. Chiến lược: Nhóm theo Hiệu số*

A powerful technique in SQL for finding consecutive sequences is the **`ID - ROW_NUMBER()`** method.
*Một kỹ thuật mạnh mẽ trong SQL để tìm các chuỗi liên tiếp là phương pháp **`ID - ROW_NUMBER()`**.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Filtering:** First, filter the table to keep only rows where `people >= 100`.
    * **Lọc:** Đầu tiên, lọc bảng để chỉ giữ lại các hàng có `people >= 100`.*

2.  **Ranking:** Within this filtered set, use `ROW_NUMBER()` ordered by `id`.
    * **Xếp hạng:** Trong tập hợp đã lọc này, sử dụng `ROW_NUMBER()` được sắp xếp theo `id`.*

3.  **Group Identifier:** Calculate `id - row_number`.
    * **Định danh Nhóm:** Tính `id - row_number`.*
    - For consecutive IDs, both values increase at the same rate, so their difference remains constant.
    - *Đối với các ID liên tiếp, cả hai giá trị đều tăng với cùng một tốc độ, vì vậy hiệu số của chúng không đổi.*
    - Example: IDs {5, 6, 7} with row numbers {1, 2, 3} all yield $5-1=4$, $6-2=4$, $7-3=4$.
    - *Ví dụ: Các ID {5, 6, 7} với số hàng {1, 2, 3} đều cho ra kết quả hiệu số là 4.*

4.  **Count and Filter:** Use a window function `COUNT(*) OVER(PARTITION BY diff)` to see how many rows are in each consecutive group.
    * **Đếm và Lọc:** Sử dụng hàm cửa sổ `COUNT(*) OVER(PARTITION BY diff)` để xem có bao nhiêu hàng trong mỗi nhóm liên tiếp.*
    - Select only those rows where the count is $\ge 3$.
    - *Chỉ chọn những hàng mà số lượng $\ge 3$.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Window Functions Efficiency:** This approach avoids complex self-joins or multiple subqueries, making it much more readable and generally faster on modern SQL engines.
    * **Hiệu quả của Hàm cửa sổ:** Cách tiếp cận này tránh các phép tự nối phức tạp hoặc nhiều truy vấn con, giúp nó dễ đọc hơn và thường nhanh hơn trên các công cụ SQL hiện đại.*
*   **Sequential Logic:** The logic relies on the fact that `id` values are surrogate keys that increase monotonically with the date.
    * **Logic Tuần tự:** Logic này dựa trên thực tế là các giá trị `id` là các khóa đại diện tăng đơn điệu theo ngày.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ where $N$ is the number of rows in the `Stadium` table. This is mainly due to the sorting required for `ROW_NUMBER()`.
    * **Độ phức tạp thời gian:** $O(N \log N)$ trong đó $N$ là số hàng trong bảng `Stadium`. Điều này chủ yếu là do việc sắp xếp cần thiết cho `ROW_NUMBER()`.*
*   **Space Complexity:** $O(N)$ for the database to store intermediate results during sorting and partition counting.
    * **Độ phức tạp không gian:** $O(N)$ để cơ sở dữ liệu lưu trữ các kết quả trung gian trong quá trình sắp xếp và đếm phân vùng.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input (People >= 100):**
- ID: 2, 3, 5, 6, 7, 8
- RowNum: 1, 2, 3, 4, 5, 6
- Diff (ID - RN):
  - 2-1 = 1
  - 3-2 = 1 (Count for Diff 1 is 2) -> **Discard**
  - 5-3 = 2
  - 6-4 = 2
  - 7-5 = 2
  - 8-6 = 2 (Count for Diff 2 is 4) -> **Keep**

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For "islands and gaps" problems in SQL, the `ID - ROW_NUMBER()` technique is a must-know. It elegantly transforms a "consecutive" problem into a "grouping" problem.
*Đối với các bài toán "đảo và khoảng trống" trong SQL, kỹ thuật `ID - ROW_NUMBER()` là một kiến thức bắt buộc phải biết. Nó biến đổi một bài toán "liên tiếp" thành một bài toán "phân nhóm" một cách thanh lịch.*
---
*Sự liên tục (Continuity) không chỉ là sự tồn tại đơn thuần, mà là sự gắn kết bền bỉ qua thời gian. Một chuỗi sự kiện (Consecutive sequence) chỉ trở nên ý nghĩa khi nó đạt được một quy mô đủ lớn (Threshold) để tạo nên một xu hướng. Trong dữ liệu, sự hội tụ là minh chứng cho sức mạnh của tập thể.*
Continuity (Continuity) is not just mere existence, but persistent cohesion over time. A sequence of events (Consecutive sequence) only becomes meaningful when it reaches a large enough scale (Threshold) to create a trend. In data, convergence is a testament to the power of the collective.
