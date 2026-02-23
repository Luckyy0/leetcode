# Analysis for Arithmetic Slices II - Subsequence
# *Phân tích cho bài toán Lát cắt Cấp số cộng II - Dãy con*

## 1. Problem Essence & Dynamic Programming on Differences
## *1. Bản chất vấn đề & Quy hoạch động trên Hiệu số*

### The Challenge
### *Thách thức*
Counting all arithmetic subsequences of length $\ge 3$. Unlike arithmetic slices (which are contiguous), subsequences can pick elements from anywhere. The total number of subsequences is exponential, so we need DP to aggregate counts efficiently.

### Strategy: DP with Map of Counts
### *Chiến lược: Quy hoạch động với Bản đồ Số lượng*

1.  **State Definition:** `dp[i]` is a Map where `dp[i].get(diff)` represents the number of arithmetic subsequences ending at index `i` with common difference `diff`.
    - Note: These subsequences have length $\ge 2$.
2.  **Transitions:**
    - For each pair $(j, i)$ with $j < i$:
        - `diff = nums[i] - nums[j]`.
        - Let `countAtJ = dp[j].getOrDefault(diff, 0)`.
        - This `countAtJ` represents subsequences of length $\ge 2$ ending at `j`.
        - By adding `nums[i]`, they become subsequences of length $\ge 3$ ending at `i`.
        - Total result `res += countAtJ`.
        - Update `dp[i]`: `dp[i].put(diff, dp[i].getOrDefault(diff, 0) + countAtJ + 1)`.
        - The `+ 1` accounts for the new subsequence of length 2: `[nums[j], nums[i]]`.
3.  **Key Insight:** We track sequences of length 2 to build sequences of length 3, but we only add to the final result when we extend an existing sequence (making it length $\ge 3$).

---

## 2. Approach: DP with Difference Maps
## *2. Hướng tiếp cận: Quy hoạch động với Bản đồ Hiệu số*

### Logic
### *Logic*
(See above). We use `Long` for differences to avoid overflow. Each index `i` stores its own map of `diff -> count`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Polynomial Complexity:** Reduces an exponential problem to $O(n^2)$.
    *Độ phức tạp đa thức: Giảm một bài toán lũy thừa xuống O(n^2).*
*   **Space Management:** Maps only store existing differences, saving space compared to a fixed 2D array.
    *Quản lý không gian: Bản đồ chỉ lưu trữ các hiệu số hiện có.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(n^2)$, where $n$ is length of `nums`.
    *Độ phức tạp thời gian: $O(n^2)$.*
*   **Space Complexity:** $O(n \cdot (\text{distinct differences}))$, worst case $O(n^2)$.
    *Độ phức tạp không gian: $O(n^2)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `nums = [2, 4, 6]`
1. `i = 0`: `dp[0] = {}`.
2. `i = 1`: `j = 0, diff = 2`.
   - `countAt0 = 0`.
   - `dp[1] = {2: 1}` (The seq [2,4]).
   - `res = 0`.
3. `i = 2`: `j = 0, diff = 4`.
   - `dp[2] = {4: 1}`.
   - `j = 1, diff = 2`.
   - `countAt1 = 1`.
   - `res += 1 = 1`. (The seq [2,4,6]).
   - `dp[2] = {4: 1, 2: 2}` ([4,6] and [2,4,6]).
Result: 1.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

$O(n^2)$ DP with a map of differences for each index.
*Duyệt O(n^2) với quy hoạch động sử dụng bản đồ hiệu số cho mỗi chỉ số.*
---
*Mỗi sự kiện trong chuỗi thời gian (subsequences) đều mang một nhịp điệu (difference). Để nhìn nhận được sự hài hòa tổng thể (arithmetic sequence), ta phải ghi nhớ những nhịp điệu lẻ loi giữa hai điểm (length 2) và tìm cách kết nối chúng thành những bản nhạc dài hơn (length $\ge 3$). Trong sự phức tạp của vô vàn tổ hợp, Quy hoạch động chính là người nhạc trưởng giúp ta đếm được những giai điệu hoàn hảo.*
Every event in the time sequence (subsequences) carries a rhythm (difference). To perceive the overall harmony (arithmetic sequence), we must remember the solitary rhythms between two points (length 2) and find ways to connect them into longer pieces of music (length $\ge 3$). Amidst the complexity of countless combinations, Dynamic Programming is the conductor that helps us count the perfect melodies.
