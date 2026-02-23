# Analysis for Freedom Trail
# *Phân tích cho bài toán Đường mòn Tự do*

## 1. Problem Essence & Dynamic Programming
## *1. Bản chất vấn đề & Quy hoạch Động*

### The Challenge
### *Thách thức*
Minimizing total rotation steps to match a sequence of characters.
- At each step `i` (matching `key[i]`), the ring can end up at multiple potential positions (indices where `ring[idx] == key[i]`).
- The cost to reach `key[i]` depends on where we were at `key[i-1]`.
- This is a sequential decision problem -> DP.

### Strategy: DP with State (Index in Key, Current Ring Position)
### *Chiến lược: DP với Trạng thái (Chỉ số trong Key, Vị trí Vòng Hiện tại)*

1.  **State:** `dp[k_idx][r_idx]` = min steps to spell `key[k_idx:]` given that the ring is currently at `r_idx` (aligned at 12:00).
    - Or simpler forward DP: `dp[i][j]` = min steps to spell `key[0..i]` ending at ring index `j`.
2.  **Transitions:**
    - To compute `dp[i][j]` (where `ring[j] == key[i]`):
        - Iterate over all possible previous positions `prev_j` (where `ring[prev_j] == key[i-1]`).
        - `cost = min(clockwise_dist, counter_clockwise_dist)`.
        - `dp[i][j] = min(dp[i][j], dp[i-1][prev_j] + cost + 1)`. (+1 for press).
3.  **Preprocessing:** Map each character 'a'-'z' to a list of indices in `ring` for fast lookup.

---

## 2. Approach: Memoization (Top-Down)
## *2. Hướng tiếp cận: Ghi nhớ (Top-Down)*

### Logic
### *Logic*
`solve(keyIndex, ringIndex)`:
- If `keyIndex == key.length`, return 0.
- Char `target = key[keyIndex]`.
- For each `nextRingIndex` where `ring[nextRingIndex] == target`:
    - `diff = abs(ringIndex - nextRingIndex)`.
    - `step = min(diff, ringLen - diff)`.
    - `res = min(res, step + 1 + solve(keyIndex + 1, nextRingIndex))`.
- Cache result.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Optimal Substructure:** Best way to finish depends only on where we are now.
    *Cấu trúc con tối ưu: Cách tốt nhất để hoàn thành chỉ phụ thuộc vào vị trí hiện tại của chúng ta.*
*   **Small State Space:** $100 \times 100$. Very fast.
    *Không gian trạng thái nhỏ: 100 x 100. Rất nhanh.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(K \cdot N^2)$. Where $K$ is key length, $N$ is ring length. For each key char, we might check up to $N$ ring positions against $N$ previous positions.
    *Độ phức tạp thời gian: $O(K \cdot N^2)$.*
*   **Space Complexity:** $O(K \cdot N)$.
    *Độ phức tạp không gian: $O(K \cdot N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `ring="godding"`, `key="gd"`
1. `solve(0, 0)`: target 'g'.
   - 'g' at 0. Dist(0->0)=0. Recurse `solve(1, 0)`.
   - 'g' at 6. Dist(0->6)=1. Recurse `solve(1, 6)`.
2. `solve(1, 0)`: target 'd'.
   - 'd' at 2. Dist(0->2)=2. Cost 2+1=3.
   - 'd' at 3. Dist(0->3)=3. Cost 3+1=4.
   - ...
3. Min path ends up being 4.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

DP mapping key index and current ring alignment.
*DP ánh xạ chỉ số khóa và sự căn chỉnh vòng hiện tại.*
---
*Đường đến tự do (Freedom Trail) hiếm khi là một đường thẳng. Đôi khi ta phải xoay chuyển tình thế (rotate ring) theo cả hai chiều xuôi ngược để tìm ra lối thoát ngắn nhất. Mỗi bước đi (step) đều có giá của nó, nhưng nếu biết tính toán kỹ lưỡng (DP), ta sẽ mở được cánh cửa cuối cùng với cái giá thấp nhất.*
The road to freedom (Freedom Trail) is rarely a straight line. Sometimes we have to turn the situation (Rotate Ring) in both directions to find the shortest escape. Each step (Step) has its price, but if calculated carefully (DP), we will open the final door with the lowest price.
