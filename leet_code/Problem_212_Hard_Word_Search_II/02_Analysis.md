# Analysis for Word Search II
# *Phân tích cho bài toán Tìm kiếm từ II*

## 1. Problem Essence & Optimization Needs
## *1. Bản chất vấn đề & Nhu cầu tối ưu hóa*

### Why standard DFS is slow
### *Tại sao DFS thông thường lại chậm*
If we run DFS for *each word* in the list, the complexity would be $O(K \times M \times N \times 4^L)$, where $K$ is the number of words. With $K=30,000$, this will TLE.
*Nếu chạy DFS cho *mỗi từ*, độ phức tạp sẽ quá lớn và gây TLE.*

### The Trie Solution
### *Giải pháp Trie*
Instead of searching for words one by one, we can store all `words` in a **Trie**. Then, we traverse the board **once**. During the traversal (DFS on the grid), we simultaneously traverse the Trie.
*Thay vì tìm từng từ, chúng ta lưu tất cả vào Trie. Sau đó duyệt bảng một lần. Trong quá trình duyệt bảng (DFS), chúng ta đồng thời duyệt Trie.*

If we reach a Trie node marked as `isEnd`, we found a word!
*Nếu gặp nút Trie có `isEnd`, ta đã tìm thấy từ!*

---

## 2. Approach: Backtracking with Trie Optimization
## *2. Hướng tiếp cận: Quay lui với Tối ưu hóa Trie*

### Logic
### *Logic*
1.  **Build Trie:** Insert all words into a Trie. Store the actual `word` string at the end node (optimization to avoid rebuilding string).
2.  **Iterate Grid:** For each cell `(i, j)`, start a DFS if `board[i][j]` matches a root child in the Trie.
3.  **DFS(row, col, trieNode):**
    - Mark cell as visited (e.g., replace char with `#`).
    - Move `trieNode` to `trieNode.children[current_char]`.
    - If `trieNode.word` is not null:
        - Add `trieNode.word` to result.
        - **Deduplication:** Set `trieNode.word = null` so we don't add it again.
    - Recurse to 4 neighbors.
    - **Backtrack:** Restore cell char.
4.  **Pruning (Critical Optimization):** If a Trie node has no children after exploring (meaning all words passing through this node are found), remove it from the parent. This gradually shrinks the Trie and speeds up search significantly.
    *Cắt tỉa (Tối ưu quan trọng): Nếu một nút Trie không còn con sau khi khám phá (nghĩa là tất cả các từ đi qua nút này đã được tìm thấy), hãy xóa nó khỏi cha. Điều này làm nhỏ Trie dần dần.*

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Multi-search efficiency:** We search for 30,000 words simultaneously.
    *Hiệu quả tìm kiếm đa năng: Tìm 30,000 từ cùng lúc.*
*   **Prefix Pruning:** If the current path on the board doesn't match any prefix in the Trie, we stop immediately.
    *Cắt tỉa tiền tố: Nếu đường dẫn hiện tại không khớp với bất kỳ tiền tố nào, dừng ngay lập tức.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \times N \times 4^L)$, where $L$ is just the max length of a word (10). This is vastly faster than iterating $K$ words.
    *Độ phức tạp thời gian: $O(M \times N \times 4^L)$. Nhanh hơn nhiều so với duyệt K từ.*
*   **Space Complexity:** $O(\sum \text{len}(words))$ (Trie size).
    *Độ phức tạp không gian: Tổng độ dài các từ.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Board:** `[['a']]`, **Words:** `["a"]`
1.  Trie: `root -> 'a' (word="a")`.
2.  DFS at (0,0) with `root`.
3.  Char is 'a'. Move to `root.children['a']`.
4.  It has `word="a"`. Add "a" to result. Set `word=null`.
5.  Backtrack.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Word Search II is the ultimate Trie problem. The "Leaf Removal" optimization (pruning the Trie as we find words) is what separates a generic solution from a top-tier solution that passes strict time limits. Always store the full string at the leaf node to avoid passing `StringBuilder` around.
*Tìm kiếm từ II là bài toán Trie tối thượng. Tối ưu hóa "Xóa lá" (cắt tỉa Trie khi tìm thấy từ) là yếu tố phân biệt giải pháp thường và giải pháp hàng đầu. Luôn lưu chuỗi đầy đủ tại nút lá để tránh phải truyền `StringBuilder`.*
---
*Đừng tìm kiếm từng chiếc kim trong đáy biển. Hãy dùng nam châm (Trie) để hút tất cả chúng cùng một lúc.*
Do not search for each needle in the haystack. Use a magnet (Trie) to attract all of them at once.
