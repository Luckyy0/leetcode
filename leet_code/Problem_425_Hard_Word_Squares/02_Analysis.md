# Analysis for Word Squares
# *Phân tích cho bài toán Hình vuông Từ vựng*

## 1. Problem Essence & Recursive Building
## *1. Bản chất vấn đề & Xây dựng Đệ quy*

### The Challenge
### *Thách thức*
Generating all valid word squares. A word square has a strict constraint: `word[i][j] == word[j][i]`.
This means when we choose the $i$-th word for row $i$, its characters at index $0, 1, \dots, i-1$ are already determined by the previous words chosen for rows $0, 1, \dots, i-1$.
Specifically, the $i$-th word must start with a prefix formed by the $i$-th characters of all previously chosen words.

### Strategy: Backtracking + Trie
### *Chiến lược: Quay lui + Trie*
1.  **Prefix Lookup:** We need to quickly find all words that start with a given prefix. A **Trie** is perfect for this. Each node in the Trie can store a list of all words that pass through it.
2.  **Backtracking:**
    -   Start with an empty list of words.
    -   At step `step` (trying to fill row `step`):
        -   Construct the required prefix: character `step` from `words[0]`, character `step` from `words[1]`, ..., character `step` from `words[step-1]`.
        -   Find all words in the Trie that match this prefix.
        -   For each candidate word, add it to the list and recurse to `step + 1`.
        -   Backtrack (remove the word) and try the next candidate.
3.  **Base Case:** If `step == wordLength`, we found a valid square. Add to results.

---

## 2. Approach: Trie-Accelerated Backtracking
## *2. Hướng tiếp cận: Quay lui Tăng tốc bởi Trie*

### Logic
### *Logic*
(See above). The Trie acts as a "candidate generator" that significantly prunes the search space. Without it, the search would be $O(N^L)$ which is too slow.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Powerful Pruning:** Only exploring valid prefixes drastically reduces exploration.
    *Cắt tỉa mạnh mẽ: Chỉ khám phá các tiền tố hợp lệ giúp giảm thiểu đáng kể việc tìm kiếm.*
*   **Efficient Retrieval:** Trie provides $O(L)$ prefix lookup.
    *Truy xuất hiệu quả: Trie cung cấp việc tra cứu tiền tố trong O(L).*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot L \cdot 26^L)$ in very worst case, but practically much faster due to limited dictionary words.
    *Độ phức tạp thời gian: $O(N \cdot L \cdot 26^L)$ trong trường hợp xấu nhất.*
*   **Space Complexity:** $O(N \cdot L)$ to store the Trie.
    *Độ phức tạp không gian: $O(N \cdot L)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `["area","lead","wall","lady","ball"]`, $L=4$.
1. Pick `wall`:
   - Step 1: Prefix needed is `w`'s 2nd char? No, prefix for row 1 is `words[0][1]` ('a').
   - Find words starting with `a`: `area`. Add `area`.
   - Step 2: Prefix for row 2 is `words[0][2]` ('l') + `words[1][2]` ('e') = `le`.
   - Find words starting with `le`: `lead`. Add `lead`.
   - Step 3: Prefix for row 3 is `words[0][3]` ('l') + `words[1][3]` ('a') + `words[2][3]` ('d') = `lad`.
   - Find words starting with `lad`: `lady`. Add `lady`.
Result: `[wall, area, lead, lady]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Backtracking with a Trie for prefix matching.
*Quay lui kết hợp với Trie để khớp tiền tố.*
---
*Hình vuông từ vựng là một cấu trúc của sự đan xen hoàn mỹ. Mỗi từ được chọn không chỉ lấp đầy một hàng (row) mà còn định hình nên tương lai của các cột (columns) kế tiếp. Bằng cách sử dụng một nỗ lực ghi nhớ (Trie) và sự kiên trì tìm kiếm (backtracking), ta có thể dệt nên những tấm lưới ngôn từ nơi mà chiều dọc và chiều ngang hòa quyện làm một.*
A word square is a structure of perfect intertwining. Each chosen word not only fills a row (row) but also shapes the future of the following columns (columns). By using a memory effort (Trie) and search persistence (backtracking), we can weave word nets where vertical and horizontal blend into one.
