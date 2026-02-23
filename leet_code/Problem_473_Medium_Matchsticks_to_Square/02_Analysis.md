# Analysis for Matchsticks to Square
# *Phân tích cho bài toán Que diêm tạo Hình vuông*

## 1. Problem Essence & Partitioning
## *1. Bản chất vấn đề & Phân vùng*

### The Challenge
### *Thách thức*
Partitioning an array of numbers into 4 subsets such that the sum of each subset is equal. This is a specific case of the **Partition to K Equal Sum Subsets** problem where $K=4$.

### Strategy: Backtracking with Optimizations
### *Chiến lược: Quay lui kết hợp Tối ưu hóa*

1.  **Total Sum Check:** First, verify if `totalSum % 4 == 0`. If not, it's impossible. Target side length is `side = totalSum / 4`.
2.  **Sorting:** Sort `matchsticks` in **descending order**. Why? Placing larger items first reduces the branching factor early on, leading to faster prunings (fail-fast).
3.  **Backtracking State:**
    - `index`: Current matchstick being considered.
    - `sums[4]`: Current lengths of the 4 sides.
4.  **Transitions:**
    - Try adding `matchsticks[index]` to `sums[0]`, then `sums[1]`, etc.
    - Only add if `sums[i] + matchstick <= side`.
    - Recursively check next index.
    - Determine success if `index == length`.
5.  **Optimizations (Pruning):**
    - **Duplicates:** If `sums[i] == sums[i-1]`, skipping `i-1` implies we should skip `i` too because they are symmetric states. (Wait, for array `sums`, the baskets are identical initially. So effectively we can break symmetry).
    - **Early Exit:** If `matchsticks[i] > side`, return false immediately.

---

## 2. Approach: DFS with 4 Buckets
## *2. Hướng tiếp cận: DFS với 4 Xô*

### Logic
### *Logic*
(See above). The constraint $N \le 15$ suggests exponential complexity $O(4^N)$ is acceptable, especially with pruning.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Symmetry Breaking:** Ensuring we don't try the same failing configuration into identical empty buckets.
    *Phá vỡ tính đối xứng: Đảm bảo không thử lại cấu hình thất bại vào các xô rỗng giống hệt nhau.*
*   **Greedy-ish Processing:** Handling big elements first fills buckets quicker or fails quicker.
    *Xử lý kiểu tham lam: Xử lý phần tử lớn trước giúp lấp đầy xô nhanh hơn hoặc thất bại sớm hơn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(4^N)$. With $N=15$, $4^{15} \approx 10^9$ is theoretically high, but valid branches are sparse. Sorting makes it much faster.
    *Độ phức tạp thời gian: $O(4^N)$.*
*   **Space Complexity:** $O(N)$ for recursion stack.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, 1, 2, 2, 2]` Total=8, Side=2.
Sorted: `[2, 2, 2, 1, 1]`
1. Stick `2`: Put in Bucket 0. `[2, 0, 0, 0]`.
2. Stick `2`: Bucket 0 full. Put in Bucket 1. `[2, 2, 0, 0]`.
3. Stick `2`: Put in Bucket 2. `[2, 2, 2, 0]`.
4. Stick `1`: Put in Bucket 3. `[2, 2, 2, 1]`.
5. Stick `1`: Bucket 0-2 full. Put in Bucket 3. `[2, 2, 2, 2]`.
Success.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Backtracking with descending sort.
*Quay lui kết hợp sắp xếp giảm dần.*
---
*Xây dựng nền móng vững chắc (square) đòi hỏi sự cân bằng tuyệt đối. Khi phân chia nguồn lực (matchsticks), việc ưu tiên giải quyết những vấn đề lớn nhất trước (sorting descending) sẽ giúp ta nhìn rõ cục diện. Nếu những mảnh ghép lớn đã yên vị, việc lấp đầy những khoảng trống nhỏ bé còn lại chỉ là vấn đề thời gian. Sự sắp xếp khôn ngoan biến những điều tưởng chừng hỗn độn thành trật tự hoàn hảo.*
Building a solid foundation (Square) requires absolute balance. When distributing resources (Matchsticks), prioritizing the biggest problems first (Sorting Descending) will help us see the situation clearly. If the large pieces are settled, filling the remaining small gaps is only a matter of time. Wise arrangement turns seemingly chaotic things into perfect order.
