# Analysis for 01 Matrix
# *Phân tích cho bài toán Ma trận 01*

## 1. Problem Essence & Multi-Source BFS
## *1. Bản chất vấn đề & BFS Đa nguồn*

### The Challenge
### *Thách thức*
Finding minimum distance from any '0' to specific '1's.
- This is equivalent to finding distance from nearest '0'.
- Instead of BFS from each '1' (too slow), we BFS from all '0's simultaneously.

### Strategy: Multi-Source BFS
### *Chiến lược: BFS Đa nguồn*

1.  **Queue:** Initialize queue with all '0' coordinates.
2.  **Distance:** Initialize `dist` matrix with `INT_MAX` (or -1) for '1's, and 0 for '0's.
3.  **Expansion:**
    - Poll `(r, c)`.
    - Check 4 neighbors.
    - If `dist[nr][nc] > dist[r][c] + 1`, update `dist[nr][nc] = dist[r][c] + 1` and add to queue.

### Alternative: DP (Two Pass)
### *Phương án thay thế: DP (Hai lần duyệt)*
- Pass 1 (Top-Left): `dist[i][j] = min(dist[i][j], min(top, left) + 1)`.
- Pass 2 (Bottom-Right): `dist[i][j] = min(dist[i][j], min(bottom, right) + 1)`.
- Very efficient space-wise (in-place).

---

## 2. Approach: DP (Two Pass)
## *2. Hướng tiếp cận: DP (Hai lần duyệt)*

### Logic
### *Logic*
(See above). Initialize '1's with a large value (infinity).
Pass 1: Check `(i-1, j)` and `(i, j-1)`.
Pass 2: Check `(i+1, j)` and `(i, j+1)`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Recursion Free:** No Queue overhead.
    *Không đệ quy: Không tốn chi phí Queue.*
*   **Cache Locality:** Sequential access is faster than random BFS access.
    *Tính cục bộ Cache: Truy cập tuần tự nhanh hơn truy cập BFS ngẫu nhiên.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \cdot N)$. Two passes.
    *Độ phức tạp thời gian: $O(M \cdot N)$.*
*   **Space Complexity:** $O(1)$ (In-place modification of result matrix).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[[0,0,0], [0,1,0], [1,1,1]]`
Init: `[[0,0,0], [0,INF,0], [INF,INF,INF]]`.
Pass 1 (TL->BR):
- `(1,1)`: min(0, INF)+1 = 1.
- `(2,0)`: min(INF, 0)+1 = 1.
- `(2,1)`: min(1, 1)+1 = 2.
- `(2,2)`: min(INF, 2)+1 = 3.
Current: `[[0,0,0], [0,1,0], [1,2,3]]`.
Pass 2 (BR->TL):
- `(2,2)`: min(3, `(2,1)`=2+1, `(1,2)`=0+1) -> 1.
- `(2,1)`: ...
Result converges to correct distances.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Two-pass DP approach for efficiency.
*Phương pháp DP hai lần duyệt để đạt hiệu quả.*
---
*Khoảng cách đến sự thật (zero) không bao giờ là vô tận. Đôi khi chỉ cần nhìn lên trên và sang trái (Pass 1), đôi khi phải nhìn xuống dưới và sang phải (Pass 2), ta sẽ tìm thấy con đường ngắn nhất để trở về điểm cân bằng.*
The distance to the truth (Zero) is never infinite. Sometimes just look up above and to the left (Pass 1), sometimes look down below and to the right (Pass 2), we will find the shortest way to return to the equilibrium point.
