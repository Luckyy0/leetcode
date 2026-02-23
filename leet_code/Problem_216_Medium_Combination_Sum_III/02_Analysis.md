# Analysis for Combination Sum III
# *Phân tích cho bài toán Tổng tổ hợp III*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### Limited Domain
### *Miền giới hạn*
This is a specific version of Combination Sum where:
- Candidates are strictly `[1, 2, ..., 9]`.
- No duplicates allowed.
- Fixed Size: `k` numbers.
- Fixed Sum: `n`.
*Đây là phiên bản cụ thể của Tổng tổ hợp: Ứng viên `[1..9]`. Không trùng lặp. Kích thước cố định `k`. Tổng cố định `n`.*

### Backtracking Framework
### *Khung quay lui*
Since we need to **enumerate all** possibilities, this is a Backtracking problem.
State: `(startNum, currentCombination, currentSum)`.
*Vì cần liệt kê tất cả, đây là bài toán Quay lui. Trạng thái: `(số_bắt_đầu, tổ_hợp_hiện_tại, tổng_hiện_tại)`.*

---

## 2. Approach: Backtracking
## *2. Hướng tiếp cận: Quay lui*

### Logic
### *Logic*
`backtrack(start, k, n, path)`
1.  **Base Case (Success):** If `k == 0` and `n == 0`:
    - Add `path` to results. Return.
2.  **Base Case (Failure):** If `k == 0` or `n < 0`:
    - Return.
3.  **Recursive Step:** Loop `i` from `start` to `9`.
    - If `i > n` (Pruning): Break (Since `i` keeps increasing, impossible to sum to `n`).
    - Add `i` to `path`.
    - Recurse: `backtrack(i + 1, k - 1, n - i, path)`. (Use `i + 1` because no duplicates).
    - Remove `i` from `path` (Backtrack).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Fixed Depth:** The recursion depth is at most `k` (max 9).
*   **Small Branching:** Branching factor decreases. 1st level has 9 options, 2nd has 8...
    *Độ sâu cố định `k`. Phân nhánh nhỏ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(C(9, K))$. The number of combinations of 9 things taken K at a time. Maximum is $C(9, 4) = 126$ or so. It's extremely small constant time.
    *Độ phức tạp thời gian: $O(C(9, K))$. Số lượng tổ hợp rất nhỏ.*
*   **Space Complexity:** $O(K)$ for the recursion stack and path.
    *Độ phức tạp không gian: $O(K)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `k=3, n=7`

1.  `backtrack(1, 3, 7)`
    - Pick 1. Remain: `k=2, n=6`. Next start: 2.
    - `backtrack(2, 2, 6)`
        - Pick 2. Remain: `k=1, n=4`. Next start: 3.
        - `backtrack(3, 1, 4)`
            - Pick 3. Remain: `k=0, n=1`. Fail.
            - Pick 4. Remain: `k=0, n=0`. **Success**. Add `[1,2,4]`.
            - Pick 5. `5>4`. Break.
    - Pick 2. Remain: `k=2, n=5`. Next start: 3.
        ...

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Since the constraints (`1-9` and `k<=9`) are so tight, brute-force backtracking is heavily optimized by default. The key is strict pruning: `if (n < 0)` and `break`.
*Vì các ràng buộc rất chặt chẽ, quay lui vét cạn đã được tối ưu hóa mặc định. Chìa khóa là cắt tỉa chặt chẽ.*
---
*Chỉ có 9 chữ số đơn giản, nhưng vô vàn cách chúng kết hợp lại để tạo nên ý nghĩa.*
Only 9 simple digits, but countless ways they combine to create meaning.
