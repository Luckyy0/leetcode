# Analysis for Design Add and Search Words Data Structure
# *Phân tích cho bài toán Thiết kế cấu trúc dữ liệu thêm và tìm kiếm từ*

## 1. Problem Essence & Trie Variation
## *1. Bản chất vấn đề & Biến thể Trie*

### The "Dot" Challenge
### *Thách thức "Dấu chấm"*
This is a standard Trie problem with a twist. The dot `.` character acts as a **wildcard**.
- Conventional `search` follows a specific path.
- Wildcard `search` must explore **all possible paths** at the current level.
*Đây là bài toán Trie tiêu chuẩn với một chút biến tấu. Ký tự dấu chấm `.` hoạt động như một **kí tự đại diện**. Tìm kiếm thông thường đi theo một đường dẫn cụ thể. Tìm kiếm đại diện phải khám phá **tất cả các đường dẫn có thể** ở tầng hiện tại.*

---

## 2. Approach: Trie with DFS Backtracking
## *2. Hướng tiếp cận: Trie với DFS Quay lui*

### Data Structure
### *Cấu trúc dữ liệu*
Reuse the `TrieNode` from Problem 208:
- `children`: Array of size 26.
- `isEnd`: Boolean.

### Algorithms
### *Thuật toán*
1.  **`addWord(word)`**: Standard Trie insertion. $O(L)$.
2.  **`search(word)`**: Recursive function `match(node, index)`.
    - **Base Case:** If `index == word.length`, return `node.isEnd`.
    - **Recursive Step:** Let `c = word[index]`.
        - If `c` is a letter: Go to `node.children[c - 'a']`. If null, return false. Recurse for `index + 1`.
        - If `c` is `'.'`: Loop through ALL 26 children. If any child is not null, recurse `match(child, index + 1)`. If *any* recursion returns true, return true.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Elasticity:** The DFS approach naturally handles the branching caused by the wildcard `.` without complex state management.
    *Tính linh hoạt: Cách tiếp cận DFS xử lý việc rẽ nhánh do kí tự đại diện `.` một cách tự nhiên.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:**
    - `addWord`: $O(L)$.
    - `search`: Worst case $O(26^L)$ if the word is all dots `.......`. In practice (with few dots), it's much faster.
    *Độ phức tạp thời gian: `addWord` là $O(L)$. `search` trường hợp xấu nhất là $O(26^L)$ nếu toàn dấu chấm.*
*   **Space Complexity:** $O(N \times L)$ for storing words.
    *Độ phức tạp không gian: $O(N \times L)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Trie:** `b -> a -> d (End)`, `d -> a -> d (End)`

**Search ".ad"**:
1.  `match(root, 0)`. Char is `.`.
    - Try 'b': `match(b_node, 1)`. Char is 'a'. Found. Next 'd'. Found. Return True.
    - (Since one path returned true, we stop and return True).

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

This problem is the standard follow-up question to "Implement Trie". Ensure you handle the recursion correctly, especially the base case (end of word) vs. the null check (end of path but valid).
*Bài toán này là câu hỏi mở rộng tiêu chuẩn cho "Triển khai Trie". Hãy đảm bảo bạn xử lý đệ quy chính xác, đặc biệt là trường hợp cơ sở (cuối từ) so với kiểm tra null (cuối đường dẫn nhưng hợp lệ).*
---
*Một dấu chấm nhỏ có thể đại diện cho vô vàn khả năng, cũng như một quyết định nhỏ có thể mở ra trăm ngàn ngã rẽ.*
A small dot can represent countless possibilities, just as a small decision can open up hundreds of thousands of turns.
