# Analysis for Non-decreasing Subsequences
# *Phân tích cho bài toán Dãy con Không giảm*

## 1. Problem Essence & Subset Generation
## *1. Bản chất vấn đề & Tạo tập con*

### The Challenge
### *Thách thức*
Generating all valid subsequences (not subarrays) that are non-decreasing and have length $\ge 2$. Duplicates must be handled carefully ( e.g., result should not contain duplicate lists like `[4, 7]` twice if there are two 7s).

### Strategy: Backtracking (DFS)
### *Chiến lược: Quay lui (DFS)*

1.  **State:** `dfs(index, currentList)`.
2.  **Transitions:**
    - For `i` from `index` to `length`:
        - If `nums[i] >= list.last()`: Append and recurse.
        - Backtrack (remove last).
3.  **Duplicate Handling:**
    - Since input is not necessarily sorted (and cannot be sorted because *subsequence* order matters), we cannot simply skip `nums[i] == nums[i-1]`.
    - Instead, *at each recursion level*, use a `HashSet` to track used numbers for the *current position*. Only pick a number `x` if it hasn't been used as the next element at this specific step.
4.  **Base Case:** If `list.size() >= 2`, add to results.

---

## 2. Approach: Backtracking with Set
## *2. Hướng tiếp cận: Quay lui với Tập hợp*

### Logic
### *Logic*
(See above). The `Set<Integer> used` inside the `dfs` loop is crucial. It ensures that if we have `[4, 7(a), 7(b)]`, and we pick `4`, the next level sees two `7`s. The first `7` generates `[4, 7(a)...]`. The second `7` would generate `[4, 7(b)...]`. Since `7(a) == 7(b)`, we skip the second `7` to avoid duplicates.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Handling Unsorted Input:** Respects original order while filtering duplicates based on values.
    *Xử lý đầu vào không sắp xếp: Tôn trọng thứ tự ban đầu trong khi lọc trùng lặp dựa trên giá trị.*
*   **Recursive Enumeration:** Naturally explores the power set.
    *Liệt kê đệ quy: Khám phá tự nhiên tập hợp lũy thừa.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(2^N)$. With $N=15$, $2^{15} = 32768$, very safe.
    *Độ phức tạp thời gian: $O(2^N)$.*
*   **Space Complexity:** $O(N)$ for stack.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[4, 6, 7, 7]`
1. DFS(0, []):
   - Pick 4: DFS(1, [4]).
     - Pick 6: DFS(2, [4, 6]). Add `[4, 6]`.
       - Pick 7(idx 2): DFS(3, [4, 6, 7]). Add `[4, 6, 7]`.
         - Pick 7(idx 3): DFS(4, [4, 6, 7, 7]). Add `[4, 6, 7, 7]`.
       - Backtrack. `used` has {7}.
       - Loop `i=3`: `nums[3]=7`. Seen in `used`? Yes. Skip.
     - Backtrack.
     - Pick 7(idx 2): DFS(3, [4, 7]). Add `[4, 7]`. ...
     - Backtrack.
     - Pick 7(idx 3): Skip (used).
   - Backtrack.
   - Pick 6: DFS(2, [6]). ...

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Backtracking with a generic Set to deduplicate at each level.
*Quay lui với Set để loại bỏ trùng lặp tại mỗi cấp độ.*
---
*Một chuỗi số liệu (subsequence) chỉ có ý nghĩa khi nó thể hiện sự tiến bộ (non-decreasing) hoặc ít nhất là sự ổn định. Trong hành trình tìm kiếm những mô hình phát triển, ta phải cẩn trọng loại bỏ những bản sao vô nghĩa (duplicates) làm nhiễu loạn bức tranh tổng thể. Mỗi lựa chọn đều mở ra một nhánh tương lai, nhưng chỉ những lựa chọn duy nhất (unique) mới tạo nên giá trị thực sự.*
A sequence of data (subsequence) makes sense only when it shows progress (non-decreasing) or at least stability. In the journey of finding development models, we must be careful to eliminate meaningless copies (duplicates) that disturb the overall picture. Each choice opens a future branch, but only valid choices (Unique) create real value.
