# Analysis for Lexicographical Numbers
# *Phân tích cho bài toán Số theo Thứ tự Từ điển*

## 1. Problem Essence & Pre-order Traversal
## *1. Bản chất vấn đề & Duyệt Tiền thứ tự*

### The Challenge
### *Thách thức*
Generating numbers $1 \dots n$ in the order they would appear in a dictionary. For example, `10` comes before `2` because '1' < '2'.

### Strategy: DFS on a 10-ary Tree
### *Chiến lược: DFS trên Cây 10-nhánh*
Imagine a tree where the root has children 1-9. Each node $x$ has children $10x, 10x+1, \dots, 10x+9$.
The lexicographical order is identical to a **pre-order traversal** of this tree, constrained by $x \le n$.

### Iterative Logic:
### *Logic Lặp:*
1.  Start with `curr = 1`.
2.  Repeat $n$ times:
    - Add `curr` to result.
    - If `curr * 10 <= n`: Go deeper (e.g., $1 \to 10 \to 100$).
    - Else:
        - If we reached the limit (`curr >= n`) or the end of a digit group (`curr % 10 == 9`), we need to "go up" the tree levels.
        - While `curr % 10 == 9` or `curr + 1 > n`: `curr /= 10`.
        - `curr++` (Move to the next sibling).

---

## 2. Approach: Iterative Number Generation
## *2. Hướng tiếp cận: Tạo số bằng vòng lặp*

### Logic
### *Logic*
(See above). This simulates DFS without using recursion or stack space.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Complexity:** Every number is generated exactly once.
    *Hiệu quả O(N): Mỗi số chỉ được tạo ra đúng một lần.*
*   **O(1) Extra Space:** No recursion stack or additional data structures.
    *Không gian phụ O(1): Không dùng ngăn xếp đệ quy hay cấu trúc dữ liệu bổ sung.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$ extra (excluding the result list).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `n = 13`
1. `curr = 1`. Add 1.
2. `1 * 10 = 10 <= 13`. `curr = 10`. Add 10.
3. `10 * 10 = 100 > 13`. Try `curr + 1 = 11 <= 13`. `curr = 11`. Add 11.
4. `11 + 1 = 12 <= 13`. `curr = 12`. Add 12.
5. `12 + 1 = 13 <= 13`. `curr = 13`. Add 13.
6. `13 + 1 = 14 > 13`. Sibling branch full. Go up: `13 / 10 = 1`. Next sibling of 1: `curr = 2`. Add 2...
Result: `[1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Iterative DFS simulation.
*Mô phỏng DFS bằng vòng lặp.*
---
*Thứ tự từ điển (lexicographical order) dạy chúng ta rằng chiều sâu (multiply by 10) đôi khi quan trọng hơn bề rộng. Bằng cách khám phá hết tận cùng của một hướng đi trước khi chuyển sang nhánh mới (sibling), chúng ta sẽ thấy được sự logic tuyệt đối ẩn sau những con số.*
Lexicographical order teaches us that depth (multiply by 10) is sometimes more important than breadth. By exploring the end of a path before moving to a new branch (sibling), we will see the absolute logic hidden behind numbers.
