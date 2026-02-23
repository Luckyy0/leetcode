# Analysis for Pour Water
# *Phân tích cho bài toán Đổ Nước*

## 1. Problem Essence & Simulation
## *1. Bản chất vấn đề & Mô phỏng*

### The Challenge
### *Thách thức*
We must simulate the physical behavior of water droplets one by one. Each droplet seeks the lowest ground nearby. The preference is **Left** then **Right**.
*Chúng ta phải mô phỏng hành vi vật lý của từng giọt nước. Mỗi giọt nước tìm vùng đất thấp nhất lân cận. Ưu tiên là **Trái** rồi đến **Phải**.*

### Movement Logic
### *Logic Di chuyển*
For a droplet starting at `K`:
1.  **Look Left:** Traverse left as long as the terrain does not go *up* (`heights[i-1] <= heights[i]`). Track the best candidate position (lowest height found so far).
    - If we find a position with height strictly less than `heights[K]`, that's a candidate.
    - Important: Among multiple local minima, water settles in the one that is bounded by higher ground. But here the simulation simplifies: just find the "best" index `d` (lowest height) in the reachable range to the left. If `heights[d] < heights[K]`, we drop there.
    - Clarification: If the path is `2, 1, 1, 2` (K at rightmost 2), it flows `2->1->1`. Best is index 1 or 2? Usually water flows to the bottom of the "V". If flat bottom, it fills the side closer to where it came from?
    - Standard LeetCode logic for this problem: Find index `d` such that `heights[d]` is minimal in the valid path. If there are multiple minimal indices, pick the one **closest to K**? No, wait.
    - If we have `2, 1, 0, 1` and K=0 (val 2). It goes to 0.
    - Only if `heights[d] < heights[K]`, we fill `d`. Otherwise we try right.
    *   **Nhìn sang Trái:** Duyệt sang trái chừng nào địa hình chưa đi *lên*. Tìm vị trí ứng viên tốt nhất (thấp nhất). Nếu tìm thấy vị trí thấp hơn `K`, đổ vào đó.*

2.  **Look Right:** If left didn't work (best left isn't lower than K), traverse right similarly.
    *   **Nhìn sang Phải:** Nếu bên trái không được, duyệt sang phải tương tự.*

3.  **Stay:** If neither found a strictly lower spot, increment `heights[K]`.
    *   **Ở lại:** Nếu không tìm thấy chỗ thấp hơn, tăng tại `K`.*

---

## 2. Strategy: Droplet Simulation
## *2. Chiến lược: Mô phỏng Giọt nước*

### Step-by-Step Algorithm
### *Thuật toán từng bước*

Loop `V` times:
1.  `curr = K`.
2.  **Scan Left:**
    - `best = K`.
    - Loop `i` from `K-1` down to `0`:
        - If `heights[i] > heights[i+1]`, break (wall blocking).
        - If `heights[i] < heights[best]`, update `best = i`.
    - If `best != K`, increments `heights[best]`. Continue to next droplet.
3.  **Scan Right:**
    - `best = K`.
    - Loop `i` from `K+1` up to `N-1`:
        - If `heights[i] > heights[i-1]`, break.
        - If `heights[i] < heights[best]`, update `best = i`.
    - If `best != K`, increment `heights[best]`. Continue.
4.  **Else:** Increment `heights[K]`.

**Wait, Tie-breaking rules:**
"Ideally, the droplet moves to the lowest point... If multiple indices with same lowest height, chooses the one closest to k"? No, the example `2,1,1,2` (K=3, val 2). Left path: `1, 1`. Lowest is 1. Indices 1 and 2. It fills index 2 (closer to K).
Correct logic: Scan and update `best` only if `heights[i] < heights[best]`? No, that would pick the *first* minimum encountered (closest to K). Yes, that matches "closest to K".
Let's refine: moving left `i` goes `K-1` down to `0`. If `h[i] < h[best]`, update `best`. If `h[i] == h[best]`, do we update? No, because we want closest to K (larger index for left side).
So: strict inequality `<` ensures we keep the one closest to K.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(V \cdot N)$. For each unit of volume, we scan at most $N$ elements. $2000 \times 100 = 2 \cdot 10^5$. Fast enough.
    *   **Độ phức tạp thời gian:** $O(V \cdot N)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**h=[2,1,1,2], V=1, K=3**
1. Left scan from 3 (val 2):
   - i=2 (val 1). 1 < 2. best=2.
   - i=1 (val 1). 1 == 1. best remains 2.
   - i=0 (val 2). 2 > 1. Break.
2. `best` is 2. `h[2]` is 1. `h[K]` is 2. Since 1 < 2, fill `h[2]`.
- Result: `[2, 1, 2, 2]`.

**h=[1,2,3,4], V=1, K=3**
1. Left scan: 4->3->2->1. Best is index 0. Fill 0.
- Result: `[2, 2, 3, 4]`.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Simply implement the simulation loop. Be careful with loop break conditions (when terrain goes up) and strictly finding the minimum `best` to handle the distance tie-breaking correctly.
*Đơn giản là cài đặt vòng lặp mô phỏng. Cẩn trọng với điều kiện ngắt vòng lặp (khi địa hình đi lên) và việc tìm `best` tối thiểu để xử lý đúng quy tắc ưu tiên khoảng cách.*
---
*Nước chảy chỗ trũng (Water seeks low ground). Quy luật tự nhiên này dẫn dắt mỗi giọt nước tìm về nơi thấp nhất (Minimal height) mà nó có thể chạm tới. Dữ liệu dạy ta rằng bằng cách tuân theo tuần tự ưu tiên (Left then Right) và tôn trọng chướng ngại vật (Terrain walls), ta có thể mô phỏng chính xác sự kiến tạo của thiên nhiên trên một bản đồ số.*
Water seeks low ground (Water seeks low ground). This natural law guides every droplet to find the lowest place (Minimal height) it can reach. Data teaches us that by following the priority sequence (Left then Right) and respecting obstacles (Terrain walls), we can accurately simulate nature's formation on a digital map.
