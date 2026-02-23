# Analysis for Frog Jump
# *Phân tích cho bài toán Ếch Nhảy*

## 1. Problem Essence & State Management
## *1. Bản chất vấn đề & Quản lý Trạng thái*

### The Challenge
### *Thách thức*
Determining reachability in a sequence with variable step sizes dependent on the previous step. This is a classic dynamic programming problem where the "state" is not just the current position, but also the velocity (jump size).

### Strategy: DP with Map of Sets
### *Chiến lược: DP với Bản đồ các Tập hợp*
1.  **State Definition:** For each stone, we need to know all the jump sizes that could have brought the frog to that stone.
2.  **Data Structure:** `Map<Integer, Set<Integer>>`.
    - Key: Stone position.
    - Value: A Set of jump sizes `k` that land on this stone.
3.  **Process:**
    - Initialize the Map with all stone positions.
    - Add `0` to the Set of the first stone (position 0).
    - Iterate through each stone `s` in order:
        - For each jump size `k` in `Set[s]`:
            - Try next jumps: `step = k - 1, k, k + 1`.
            - If `step > 0` and `s + step` is a valid stone:
                - Add `step` to the `Set[s + step]`.
4.  **Termination:** If the `Set` of the last stone is not empty, return `true`.

---

## 2. Approach: Iterative Dynamic Programming
## *2. Hướng tiếp cận: Quy hoạch động Lặp*

### Logic
### *Logic*
(See above). The Map allows $O(1)$ lookup for stone existence, and the Set prevents redundant calculations for the same incoming jump size.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Efficient Reachability:** Only explores reachable positions and valid jump sizes.
    *Hiệu quả: Chỉ khám phá các vị trí có thể tiếp cận và các kích thước bước nhảy hợp lệ.*
*   **Automatic Deduplication:** `Set` ensures we don't re-calculate the same next steps if multiple paths land on the same stone with the same jump size.
    *Tự động loại bỏ trùng lặp: Tập hợp đảm bảo không tính toán lại cùng một bước tiếp theo.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$ in the worst case where $N$ is the number of stones.
    *Độ phức tạp thời gian: $O(N^2)$.*
*   **Space Complexity:** $O(N^2)$ to store the sets of jump sizes for each stone.
    *Độ phức tạp không gian: $O(N^2)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Stones:** `[0, 1, 3]`
1. `Map[0] = {0}`
2. Process `Stone 0`: `k=0`. Next jumps: `k+1 = 1`. Reach `0+1 = 1`.
   - `Map[1].add(1)`.
3. Process `Stone 1`: `k=1`. Next jumps: `k-1=0 (skip), k=1, k+1=2`.
   - `1+1 = 2` (no stone).
   - `1+2 = 3` (stone found!). `Map[3].add(2)`.
Result: `Map[3]` is not empty. Returns `true`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

DP with `Map<Stone, Set<JumpSize>>`.
*Quy hoạch động với Bản đồ các bước nhảy.*
---
*Mỗi bước tiến trong tương lai (next jump) luôn phụ thuộc vào quán tính của quá khứ (previous jump). Bằng cách ghi lại mọi khả năng có thể xảy ra tại mỗi điểm dừng (stone), chú ếch nhỏ có thể kiên trì tìm ra con đường duy nhất nối liền hai bờ cách biệt.*
Every step forward in the future (next jump) always depends on the inertia of the past (previous jump). By recording every possibility at each stop (stone), the little frog can persistently find the only path connecting the two separate shores.
