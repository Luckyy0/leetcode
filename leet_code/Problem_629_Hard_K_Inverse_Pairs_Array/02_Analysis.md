# Analysis for K Inverse Pairs Array
# *Phân tích cho bài toán Mảng có K Cặp Nghịch thế*

## 1. Problem Essence & Combinatorial Recursion
## *1. Bản chất vấn đề & Đệ quy Tổ hợp*

### The Challenge
### *Thách thức*
We need to count permutations of $\{1, 2, ..., n\}$ that have exactly $k$ inverse pairs.
*Chúng ta cần đếm số lần hoán vị của $\{1, 2, ..., n\}$ có đúng $k$ cặp nghịch thế.*

When we add the $n$-th element (which is the largest) into a permutation of $\{1, 2, ..., n-1\}$, its position determines how many new inverse pairs it creates:
*Khi chúng ta thêm phần tử thứ $n$ (là phần tử lớn nhất) vào một hoán vị của $\{1, 2, ..., n-1\}$, vị trí của nó xác định bao nhiêu cặp nghịch thế mới được tạo ra:*
- Put at the end: 0 new pairs.
- Put at the second last: 1 new pair.
- ...
- Put at the front: $n-1$ new pairs.

---

## 2. Strategy: Dynamic Programming with Optimization
## *2. Chiến lược: Quy hoạch động với Tối ưu hóa*

Let $dp[n][k]$ be the number of permutations of $n$ elements with $k$ inverse pairs.
*Gọi $dp[n][k]$ là số lượng hoán vị của $n$ phần tử với $k$ cặp nghịch thế.*

### Recursive Relation
### *Quan hệ Đệ quy*
$dp[n][k] = \sum_{i=0}^{\min(k, n-1)} dp[n-1][k-i]$
*This represents putting the number $n$ in a position that creates $i$ inverse pairs.*

### Optimization
### *Tối ưu hóa*
The summation $dp[n][k] = dp[n-1][k] + dp[n-1][k-1] + ... + dp[n-1][k-(n-1)]$ can be calculated in $O(1)$ by observing the difference between $dp[n][k]$ and $dp[n][k-1]$:
*Tổng $dp[n][k] = dp[n-1][k] + dp[n-1][k-1] + ... + dp[n-1][k-(n-1)]$ có thể được tính trong $O(1)$ bằng cách quan sát sự khác biệt giữa $dp[n][k]$ và $dp[n][k-1]$:*
$dp[n][k] = dp[n][k-1] + dp[n-1][k] - dp[n-1][k-n]$.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Sliding Window Sum:** The optimized formula effectively uses a sliding window of size $n$ on the previous row of DP.
    * **Tổng Cửa sổ trượt:** Công thức tối ưu hóa sử dụng hiệu quả một cửa sổ trượt có kích thước $n$ trên hàng trước đó của DP.*
*   **Space Optimization:** Since $dp[n]$ only depends on $dp[n-1]$, we can reduce space complexity to $O(k)$ by using two rows or updating in-place.
    * **Tối ưu hóa Không gian:** Vì $dp[n]$ chỉ phụ thuộc vào $dp[n-1]$, chúng ta có thể giảm độ phức tạp không gian xuống $O(k)$ bằng cách sử dụng hai hàng hoặc cập nhật tại chỗ.*
*   **Modulo Arithmetic:** Be careful with the subtraction `dp[n][k-1] + dp[n-1][k] - dp[n-1][k-n]`. We must add the MOD value before taking the modulo to avoid negative results.
    * **Số học Modulo:** Cẩn thận với phép trừ `dp[n][k-1] + dp[n-1][k] - dp[n-1][k-n]`. Chúng ta phải cộng thêm giá trị MOD trước khi lấy modulo để tránh kết quả âm.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \times K)$. With the sliding window optimization, each state $(n, k)$ is computed in $O(1)$.
    * **Độ phức tạp thời gian:** $O(N \times K)$. Với tối ưu hóa cửa sổ trượt, mỗi trạng thái $(n, k)$ được tính toán trong $O(1)$.*
*   **Space Complexity:** $O(K)$ if using space-optimized DP, or $O(NK)$ for the full table.
    * **Độ phức tạp không gian:** $O(K)$ nếu sử dụng DP tối ưu hóa không gian, hoặc $O(NK)$ cho toàn bộ bảng.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**n=3, k=1**
- dp[2][0] = 1 ([1,2])
- dp[2][1] = 1 ([2,1])
- dp[3][1] = dp[3][0] + dp[2][1] = 1 + 1 = 2.
**n=3, k=2**
- dp[3][2] = dp[3][1] + dp[2][2] - dp[2][2-3] = 2 + 0 - 0 = 2. ([3,2,1] and [2,3,1] are wrong, let's recheck).
- Permutations for (3,2): [2,3,1], [3,1,2]. (Correct).

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For DP problems involving sums of ranges from the previous state, look for a recurrence relation that allows $O(1)$ updates (prefix sums or sliding windows). This is a common pattern to reduce $O(N^3)$ to $O(N^2)$.
*Đối với các bài toán DP liên quan đến tổng các phạm vi từ trạng thái trước đó, hãy tìm một quan hệ đệ quy cho phép cập nhật $O(1)$ (tổng tiền tố hoặc cửa sổ trượt). Đây là một mô hình phổ biến để giảm $O(N^3)$ xuống $O(N^2)$.*
---
*Nghịch thế (Inverse pairs) là thước đo của sự xáo trộn. Trong một mảng có trật tự, mọi thứ đều tiến về phía trước; nhưng khi ta thay đổi vị trí, ta tạo ra những ranh giới chồng lấp. Dữ liệu dạy ta rằng sự hỗn loạn (Complexity) có thể được định lượng và tính toán thông qua những bước chuyển tiếp âm thầm (DP transitions) của cấu trúc.*
Disorder (Inverse pairs) is a measure of disturbance. In an ordered array, everything moves forward; but when we change positions, we create overlapping boundaries. Data teaches us that chaos (Complexity) can be quantified and calculated through subtle transitions (DP transitions) of a structure.
