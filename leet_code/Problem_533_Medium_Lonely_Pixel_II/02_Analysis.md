# Analysis for Lonely Pixel II
# *Phân tích cho bài toán Điểm ảnh Cô đơn II*

## 1. Problem Essence & Grouping
## *1. Bản chất vấn đề & Nhóm*

### The Challenge
### *Thách thức*
Counting 'B's satisfying:
1. Row count = N.
2. Col count = N.
3. All rows contributing to the column must be identical.

### Strategy: HashMap of Row Strings
### *Chiến lược: HashMap của Chuỗi Hàng*

1.  **Map Rows:** Key = String representation of row, Value = Count of such rows.
2.  **Count Cols:** Array `colCount` tracking 'B's per column.
3.  **Validate:** Iterate through the Map.
    - Let `rowStr` be the row pattern, `count` be number of identical rows.
    - Rule 3 implies that if a column `j` has a 'B' in this `rowStr`, then *all* rows contributing to `colCount[j]` MUST be instances of `rowStr` (or identical copies).
    - If `count == N`: This satisfies the "Row count" part of implication? No.
    - If `count == N`: We have N identifying rows. If `rowStr` has `N` 'B's (Rule 2a), then for each 'B' at `j` in `rowStr`, we check if `colCount[j] == N` (Rule 2b).
    - If `colCount[j] == N` and we have `N` identical rows, then all 'B's in these N rows at col `j` are accounted for by these identical rows. Thus Rule 3 is satisfied.
    - Result adds `N` for each valid column `j`.

---

## 2. Approach: Hash Map + Precomputation
## *2. Hướng tiếp cận: Hash Map + Tính toán trước*

### Logic
### *Logic*
(See above).
- `rowCount` is implicitly handled by Map frequency if we use it correctly or just precompute it arrays.
- Actually key insight: If `colCount[j] == N` and there are `N` identical rows having 'B' at `j`, then those N rows are naturally the only contributors to that column (since sum is N). Thus Rule 3 is satisfied by logic.
- So we just need:
    1. Row pattern must appear exactly `N` times.
    2. Row pattern must have exactly `N` 'B's.
    3. For 'B' at column `j`, `colCount` must be `N`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(MN) Time:** Constructing strings takes O(N) per row -> O(MN).
    *Thời gian O(MN): Xây dựng chuỗi mất O(N) mỗi hàng.*
*   **Hash Map:** Groups identical rows efficiently.
    *Hash Map: Nhóm các hàng giống nhau hiệu quả.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \cdot N)$.
    *Độ phức tạp thời gian: $O(M \cdot N)$.*
*   **Space Complexity:** $O(M \cdot N)$ to store row strings.
    *Độ phức tạp không gian: $O(M \cdot N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `N=3`.
Rows 0, 1, 2: `WBWBBW`. Count = 3.
- Has 3 'B's? Yes (N=3).
- Loop cols of 'B': 1, 3, 4.
    - Col 1 count: 3. Matches N. Add N to result. (Res=3).
    - Col 3 count: 3. Matches N. Add N to result. (Res=6).
    - Col 4 count: 4. Fail.
Result: 6.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Group rows by content, check row count, 'B' count, and column counts.
*Nhóm các hàng theo nội dung, kiểm tra số lượng hàng, số lượng 'B' và số lượng cột.*
---
*Đôi khi sự giống nhau (identical rows) không phải là sự nhàm chán, mà là sự đồng lòng. Khi các hàng hợp sức lại (grouping) để tạo ra cùng một tiếng nói, chúng tạo nên sức mạnh cộng hưởng (N x N) để vượt qua những bài kiểm tra khắt khe nhất.*
Sometimes similarities (identical rows) are not boring, but consensus. When rows join forces (Grouping) to create the same voice, they create resonant power (N x N) to overcome the most rigorous tests.
