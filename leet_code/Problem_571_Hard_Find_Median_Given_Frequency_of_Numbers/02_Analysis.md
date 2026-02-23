# Analysis for Find Median Given Frequency of Numbers
# *Phân tích cho bài toán Tìm Trung vị dựa trên Tần suất của các Con số*

## 1. Problem Essence & The Continuous Median
## *1. Bản chất vấn đề & Trung vị Liên tục*

### The Challenge
### *Thách thức*
In this problem, the data is compacted (number + frequency). Calculating the median requires us to find which number occupies the middle position(s) if all numbers were expanded into a full list.
*Trong bài toán này, dữ liệu được nén lại (số + tần suất). Việc tính toán trung vị yêu cầu chúng ta tìm xem con số nào chiếm (các) vị trí ở giữa nếu tất cả các con số được mở rộng thành một danh sách đầy đủ.*

Total elements $N = \sum \text{frequency}$. The median position is roughly $N/2$.
*Tổng số phần tử $N = \sum \text{tần suất}$. Vị trí trung vị xấp xỉ là $N/2$.*

---

## 2. Strategy: Running Totals and Range Matching
## *2. Chiến lược: Tổng bổng dồn và Khớp phạm vi*

We can use window functions to calculate the cumulative frequency (running total) from both directions (ascending and descending).
*Chúng ta có thể sử dụng các hàm cửa sổ để tính tần suất tích lũy (tổng dồn) từ cả hai hướng (tăng dần và giảm dần).*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Calculate Cumulative Sums:** For each number $X$:
    * **Tính Tổng tích lũy:** Đối với mỗi số $X$:*
    - `sum_asc`: The total numbers $\le X$.
    - *`sum_asc`: Tổng số các số $\le X$.*
    - `sum_desc`: The total numbers $\ge X$.
    - *`sum_desc`: Tổng số các số $\ge X$.*
    - `total_count`: The total count of all elements in the table.
    - *`total_count`: Tổng số lượng của tất cả các phần tử trong bảng.*

2.  **The Median Condition:** A number $X$ is part of the median calculation if it "covers" the center of the list from both ends.
    * **Điều kiện Trung vị:** Một con số $X$ là một phần của phép tính trung vị nếu nó "bao phủ" phần trung tâm của danh sách từ cả hai đầu.*
    Mathematically: `sum_asc >= total_count / 2.0` AND `sum_desc >= total_count / 2.0`.
    - This works because if a number spans across the halfway point of the sorted sequence, it must satisfy this condition in both running totals.
    - *Điều này hiệu quả vì nếu một con số trải dài qua điểm giữa của chuỗi đã sắp xếp, nó phải thỏa mãn điều kiện này trong cả hai tổng dồn.*

3.  **Final Result:** Return the average of the numbers that satisfy this condition, rounded to 1 decimal place.
    * **Kết quả cuối cùng:** Trả về giá trị trung bình của các con số thỏa mãn điều kiện này, làm tròn đến 1 chữ số thập phân.*

---

## 3. Structural Advantages & Efficiency
## *3. Ưu điểm Cấu trúc & Hiệu quả*

*   **Window Functions:** Using `SUM() OVER(ORDER BY ...)` is highly efficient and avoids expensive self-joins with inequality conditions.
    * **Hàm cửa sổ:** Sử dụng `SUM() OVER(ORDER BY ...)` cực kỳ hiệu quả và tránh được các phép tự nối (self-join) tốn kém với các điều kiện bất đẳng thức.*
*   **Dual-Direction Approach:** By checking from both ends, we elegantly handle both even and odd total counts without complex branches.
    * **Cách tiếp cận Hai hướng:** Bằng cách kiểm tra từ cả hai đầu, chúng ta xử lý một cách lịch lãm cả tổng số lượng chẵn và lẻ mà không cần các nhánh rẽ phức tạp.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ where $N$ is the number of distinct values (`num`). Sorting is required for the window function.
    * **Độ phức tạp thời gian:** $O(N \log N)$ với $N$ là số lượng các giá trị riêng biệt (`num`). Việc sắp xếp là cần thiết cho hàm cửa sổ.*
*   **Space Complexity:** $O(N)$ for the result of the window calculations.
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** {0: 7, 1: 1, 2: 3, 3: 1}. `total_count = 12`. Target = 6.0.
- `num 0`: sum_asc=7, sum_desc=12. (7 >= 6 and 12 >= 6). **Match!**
- `num 1`: sum_asc=8, sum_desc=5. (5 < 6). Fail.
- `num 2`: sum_asc=11, sum_desc=4. Fail.
- `num 3`: sum_asc=12, sum_desc=1. Fail.
- Matches: {0}. Result: Average(0) = 0.0.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Always use cumulative sums from both directions to find rank-based partition points in a distributed frequency dataset.
*Luôn sử dụng tổng tích lũy từ cả hai hướng để tìm các điểm phân chia dựa trên thứ hạng trong một tập dữ liệu tần suất phân tán.*
---
*Trung vị (Median) là linh hồn của sự tập trung. Trong một biển dữ liệu (Total count), ta tìm thấy nó tại nơi mà dòng chảy từ quá khứ (sum_asc) và dòng chảy từ tương lai (sum_desc) cùng hội tụ tại điểm cân bằng tuyệt đối.*
The median (Median) is the soul of focus. In a sea of data (Total count), we find it at the place where the flow from the past (sum_asc) and the flow from the future (sum_desc) converge at the absolute point of balance.
