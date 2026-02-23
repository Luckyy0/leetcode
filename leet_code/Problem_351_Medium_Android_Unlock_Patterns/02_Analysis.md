# Analysis for Android Unlock Patterns
# *Phân tích cho bài toán Mẫu Khóa Android*

## 1. Problem Essence & Backtracking
## *1. Bản chất vấn đề & Quay lui*

### The Challenge
### *Thách thức*
Counting permutations of dots (lengths m to n) with a "jump" constraint.
A jump happens when a straight line between two dots passes through a third dot. That intermediate dot must be visited first.

### Jump Rules (3x3 Grid)
### *Quy tắc Nhảy (Lưới 3x3)*
Let the dots be numbered 1 to 9:
```
1 2 3
4 5 6
7 8 9
```
- Horizontal: 1-3 passes 2; 4-6 passes 5; 7-9 passes 8.
- Vertical: 1-7 passes 4; 2-8 passes 5; 3-9 passes 6.
- Diagonal: 1-9 passes 5; 3-7 passes 5.

### Symmetry
### *Tính đối xứng*
The grid is highly symmetric:
1.  **Corners:** 1, 3, 7, 9 are functionally equivalent. (Count for '1' * 4).
2.  **Edges:** 2, 4, 6, 8 are functionally equivalent. (Count for '2' * 4).
3.  **Center:** 5 is unique. (Count for '5' * 1).

---

## 2. Approach: Backtracking with Symmetry
## *2. Hướng tiếp cận: Quay lui với Đối xứng*

### Logic
### *Logic*
1.  Precompute a `skip[10][10]` matrix where `skip[i][j]` is the dot that must be visited to jump from `i` to `j`.
2.  `dfs(currentDot, remainingLength)`:
    - Mark `currentDot` as visited.
    - If `remainingLength == 0`: count = 1.
    - Else: iterate all `nextDot` (1-9):
        - If `nextDot` not visited:
            - If `skip[currentDot][nextDot] == 0` (no jump) OR `visited[skip[currentDot][nextDot]]` (jump is valid):
                - `count += dfs(nextDot, remainingLength - 1)`.
    - Unmark `currentDot`.
3.  Sum results for lengths from `m` to `n`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Symmetry Reduction:** Reduces DFS search space by nearly 60%.
    *Giảm thiểu đối xứng: Giảm không gian tìm kiếm DFS gần 60%.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N!)$ in theory where N=9, but heavily pruned by skip rules. Actual states are small.
    *Độ phức tạp thời gian: $O(N!)$.*
*   **Space Complexity:** $O(N)$ for recursion stack and visited array.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Goal:** Count patterns of length 2.
- Start at 1:
    - Go to 2, 4, 5, 6, 8 (valid). (5 paths).
    - Go to 3 (only if 2 visited - NO).
    - Go to 7 (only if 4 visited - NO).
    - Go to 9 (only if 5 visited - NO).
- By symmetry, similar logic for others...

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Backtracking with skip matrix is the optimal way.
*Quay lui với ma trận nhảy là cách tối ưu.*
---
*Mục tiêu (patterns) không chỉ là về việc bạn đi được bao xa (n), mà là về những bước đệm (intermediate dots) mà bạn đã trải qua để đạt được điều đó. Sự đối xứng trong cuộc sống giúp chúng ta đơn giản hóa những bài toán phức tạp.*
Goals (patterns) are not just about how far you go (n), but about the stepping stones (intermediate dots) you've gone through to get there. Symmetry in life helps us simplify complex problems.
