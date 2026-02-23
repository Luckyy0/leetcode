# Analysis for Split Array with Equal Sum
# *Phân tích cho bài toán Chia Mảng với Tổng bằng nhau*

## 1. Problem Essence & The Search for Symmetry
## *1. Bản chất vấn đề & Sự tìm kiếm sự Đối xứng*

### The Challenge
### *Thách thức*
We are asked to find three indices $(i, j, k)$ that carve out four equal-sum subarrays.
*Chúng ta được yêu cầu tìm ba chỉ số $(i, j, k)$ để chia mảng thành bốn mảng con có tổng bằng nhau.*

The constraint $0 < i, i + 1 < j, j + 1 < k < n - 1$ implies that the four subarrays are separated by single elements at indices $i, j, k$, which are excluded from the sums.
*Ràng buộc $0 < i, i + 1 < j, j + 1 < k < n - 1$ ngụ ý rằng bốn mảng con được ngăn cách bởi các phần tử đơn lẻ tại các chỉ số $i, j, k$, vốn không được tính vào các tổng.*

A naive $O(N^3)$ search for all $(i, j, k)$ combinations would result in $2000^3 = 8 \times 10^9$ operations, which exceeds the typical time limit for a 1-2 second execution.
*Việc tìm kiếm $O(N^3)$ lỗi thời cho tất cả các tổ hợp $(i, j, k)$ sẽ dẫn đến $2000^3 = 8 \times 10^9$ phép tính, vượt quá giới hạn thời gian thông thường cho một lần thực thi kéo dài 1-2 giây.*

---

## 2. Strategy: Meet-in-the-Middle (The "Pivot" Method)
## *2. Chiến lược: Meet-in-the-Middle (Phương pháp "Điểm xoay")*

To optimize, we can fix the middle index $j$ and transform the $O(N^3)$ problem into an $O(N^2)$ problem using a HashSet.
*Để tối ưu hóa, chúng ta có thể cố định chỉ số ở giữa $j$ và biến bài toán $O(N^3)$ thành bài toán $O(N^2)$ bằng cách sử dụng HashSet.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Prefix Sums:** Precompute a prefix sum array `P` where `P[x]` is the sum of `nums[0...x]`. This allows $O(1)$ calculation of any subarray sum.
    * **Tổng tiền tố:** Tính toán trước mảng tổng tiền tố `P` trong đó `P[x]` là tổng của `nums[0...x]`. Điều này cho phép tính toán tổng của bất kỳ mảng con nào trong $O(1)$.*

2.  **Fix $j$ (The Middle Pivot):** Iterate through all possible values of $j$. Notice that $j$ must have at least 3 elements to its left (for $i$) and 3 elements to its right (for $k$).
    * **Cố định $j$ (Điểm xoay giữa):** Lặp qua tất cả các giá trị khả dĩ của $j$. Lưu ý rằng $j$ phải có ít nhất 3 phần tử ở bên trái (cho $i$) và 3 phần tử ở bên phải (cho $k$).*

3.  **Search Left Part (Find $i$):** For a fixed $j$, iterate through all $i$ ($1 \le i < j-1$).
    * **Tìm kiếm phần bên trái (Tìm $i$):** Với một $j$ cố định, lặp qua tất cả $i$ ($1 \le i < j-1$).*
    - Calculate `sum1 = sum(0, i-1)` and `sum2 = sum(i+1, j-1)`.
    - *Tính `sum1 = sum(0, i-1)` và `sum2 = sum(i+1, j-1)`.*
    - If `sum1 == sum2`, store this sum in a `HashSet`. This represents a potential target sum for the four parts.
    - *Nếu `sum1 == sum2`, hãy lưu tổng này vào một `HashSet`. Điều này đại diện cho một tổng mục tiêu tiềm năng cho cả bốn phần.*

4.  **Search Right Part (Find $k$):** For the same fixed $j$, iterate through all $k$ ($j+1 < k < n-1$).
    * **Tìm kiếm phần bên phải (Tìm $k$):** Đối với cùng một $j$ cố định đó, lặp qua tất cả $k$ ($j+1 < k < n-1$).*
    - Calculate `sum3 = sum(j+1, k-1)` and `sum4 = sum(k+1, n-1)`.
    - *Tính `sum3 = sum(j+1, k-1)` và `sum4 = sum(k+1, n-1)`.*
    - If `sum3 == sum4` AND `sum3` exists in the `HashSet`, it means we have found a valid $(i, j, k)$ triplet.
    - *Nếu `sum3 == sum4` VÀ `sum3` tồn tại trong `HashSet`, điều đó có nghĩa là chúng ta đã tìm thấy bộ ba $(i, j, k)$ hợp lệ.*

5.  **Termination:** Return `true` immediately upon finding a match.
    * **Kết thúc:** Trả về `true` ngay khi tìm thấy một sự trùng khớp.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Symmetry Breaking:** By fixing the center $j$, we decouple the left search $(i)$ from the right search $(k)$, effectively square-rooting the complexity of the nested relationship.
    * **Phá vỡ tính đối xứng:** Bằng cách cố định trung tâm $j$, chúng ta tách biệt việc tìm kiếm bên trái $(i)$ khỏi việc tìm kiếm bên phải $(k)$, giúp giảm đáng kể độ phức tạp của mối quan hệ lồng nhau.*
*   **Zero Sum Handling:** The HashSet naturally handles cases where subarray sums are zero, which is important given the range of input values.
    * **Xử lý Tổng bằng không:** HashSet xử lý một cách tự nhiên các trường hợp tổng mảng con bằng không, điều này rất quan trọng dựa trên phạm vi giá trị đầu vào.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$. Since for each of $N$ possible $j$, we perform two separate $O(N)$ scans for $i$ and $k$.
    * **Độ phức tạp thời gian:** $O(N^2)$. Vì đối với mỗi $j$ trong số $N$ giá trị khả dĩ, chúng ta thực hiện hai lần quét $O(N)$ riêng biệt cho $i$ và $k$.*
*   **Space Complexity:** $O(N)$. Required for the prefix sum array and the HashSet (which stores at most $N$ sums for each $j$).
    * **Độ phức tạp không gian:** $O(N)$. Cần thiết cho mảng tổng tiền tố và HashSet (lưu trữ tối đa $N$ tổng cho mỗi $j$).*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `[1, 2, 1, 2, 1, 2, 1]`
- Prefix Sums: `[1, 3, 4, 6, 7, 9, 10]`
- Fix $j=3$ (value 2 at index 3):
  - Left ($i$): Try $i=1$. `sum(0,0)=1`, `sum(2,2)=1`. Match! `HashSet = {1}`.
  - Right ($k$): Try $k=5$. `sum(4,4)=1`, `sum(6,6)=1`. Match!
  - Check `HashSet`: `HashSet` contains 1. Return `true`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

The "Middle-Pivot" approach is the most efficient $O(N^2)$ solution.
*Hướng tiếp cận "Điểm xoay giữa" là giải pháp $O(N^2)$ hiệu quả nhất.*
---
*Cái đẹp của sự cân bằng (Equal Sum) không phải lúc nào cũng hiển hiện ngay lập tức. Đôi khi ta phải đứng ở trung tâm (j) để quan sát về hai phía, ghi nhớ những tiềm năng từ quá khứ (Left HashSet) để đối chiếu với hy vọng ở tương lai (Right search). Sự hòa hợp thực sự chỉ đến khi bốn phương (4 directions) cùng hội tụ tại một giá trị duy nhất.*
The beauty of balance (Equal Sum) is not always immediately apparent. Sometimes we have to stand in the center (j) to observe both sides, remembering the potential from the past (Left HashSet) to compare with the hope in the future (Right search). True harmony only comes when four directions (4 directions) converge at a single value.
