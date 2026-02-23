# Analysis for Number of Boomerangs
# *Phân tích cho bài toán Số lượng Boomerang*

## 1. Problem Essence & Distance Grouping
## *1. Bản chất vấn đề & Nhóm theo Khoảng cách*

### The Challenge
### *Thách thức*
Counting tuples $(i, j, k)$ where $dist(i, j) = dist(i, k)$. Here, point $i$ acts as the **pivot** or center. For each pivot, we want to know how many other points are at the same distance.

### Strategy: Frequency Map of Squared Distances
### *Chiến lược: Bản đồ Tần suất Bình phương Khoảng cách*

1.  **Iterate through each point `i`:** Treat this point as the center.
2.  **Calculate distances:** For every other point `j`, calculate the squared Euclidean distance $d^2 = (x1-x2)^2 + (y1-y2)^2$. 
    - (We use squared distance to avoid floating-point issues with `sqrt`).
3.  **Group by Distance:** Use a `HashMap<Integer, Integer>` to store `SquaredDistance -> count`.
4.  **Permutation Calculation:** 
    - If there are $m$ points at a specific distance from `i`, we can choose any 2 of them to be $j$ and $k$.
    - Since order matters (boomerang is $(i, j, k)$ vs $(i, k, j)$), the number of ways is $P(m, 2) = m \times (m-1)$.
5.  **Aggregate:** Sum up these counts for all pivots and all distances.

---

## 2. Approach: Pivot-based Counting
## *2. Hướng tiếp cận: Đếm dựa trên Tâm xoay*

### Logic
### *Logic*
(See above). The $O(n^2)$ complexity is acceptable given $n \le 500$. We clear the map for each new pivot point.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Robust Distance Metric:** Squared distances are integers, ensuring exact comparisons.
    *Số đo khoảng cách tin cậy: Bình phương khoảng cách là số nguyên, đảm bảo so sánh chính xác.*
*   **Decoupled Calculation:** Each pivot is handled independently.
    *Tính toán tách biệt: Mỗi tâm được xử lý độc lập.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(n^2)$, where $n$ is the number of points.
    *Độ phức tạp thời gian: $O(n^2)$.*
*   **Space Complexity:** $O(n)$ to store the map for each pivot.
    *Độ phức tạp không gian: $O(n)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[[0,0], [1,0], [2,0]]`
1. Pivot `[1,0]`:
   - Dist to `[0,0]` is 1. `Map: {1: 1}`.
   - Dist to `[2,0]` is 1. `Map: {1: 2}`.
   - Ways for distance 1: $2 \times (2-1) = 2$.
2. Pivot `[0,0]`:
   - Dist to `[1,0]` is 1. `Map: {1: 1}`.
   - Dist to `[2,0]` is 4. `Map: {1:1, 4:1}`.
   - Ways: $1\times 0 + 1\times 0 = 0$.
3. Pivot `[2,0]`:
   - Ways: 0.
Total: 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

$O(n^2)$ iteration with distance hashing.
*Duyệt O(n^2) kết hợp bảng băm khoảng cách.*
---
*Một boomerang (i, j, k) luôn cần một tâm (pivot point) vững chắc để quay về. Khi ta tìm thấy nhiều người bạn (points) ở cùng một khoảng cách định mệnh (equal distance), sự kết nối giữa họ có thể được hoán đổi (permutations) để tạo nên vô vàn những vòng lặp kỳ diệu. Sự đối xứng trong hình học phản chiếu sự cân bằng trong cuộc sống, nơi mọi hành động đều có phản ứng tương đương.*
A boomerang (i, j, k) always needs a solid center (pivot point) to return to. When we find many friends (points) at the same fated distance (equal distance), the connection between them can be swapped (permutations) to create countless magical loops. Symmetry in geometry reflects balance in life, where every action has an equivalent reaction.
