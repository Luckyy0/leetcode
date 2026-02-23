# Analysis for Implement Trie (Prefix Tree)
# *Phân tích cho bài toán Triển khai Trie (Cây tiền tố)*

## 1. Problem Essence & Tree Structure
## *1. Bản chất vấn đề & Cấu trúc cây*

### Why not Hashes?
### *Tại sao không dùng Hash?*
A Hash Table can verify if a word exists in $O(1)$ (effectively $O(L)$ where $L$ is length). However, checking if *any* word starts with a prefix would require iterating all keys, which is $O(N \times L)$.
A Trie solves the **Prefix** problem efficiently. `startsWith` becomes $O(L)$ instead of $O(N \times L)$.
*Bảng băm có thể kiểm tra từ tồn tại trong $O(L)$. Tuy nhiên, kiểm tra tiền tố sẽ cần duyệt tất cả các khóa, tốn $O(N \times L)$. Trie giải quyết vấn đề **Tiền tố** hiệu quả. `startsWith` trở thành $O(L)$.*

### Node Anatomy
### *Giải phẫu nút*
Each node in a Trie represents a single character of a word.
It needs:
1.  **Children:** Links to next characters. Since inputs are lowercase 'a'-'z', an array `TrieNode[26]` is perfect.
2.  **End Flag:** A boolean `isEnd` to mark if the path from root to this node forms a complete inserted word. (e.g., "app" vs "apple").
*Mỗi nút trong Trie đại diện cho một ký tự. Nó cần: 1. Children: Liên kết đến các ký tự tiếp theo. Mảng `TrieNode[26]`. 2. End Flag: Biến boolean `isEnd` để đánh dấu từ hoàn chỉnh.*

---

## 2. Approach: N-ary Tree Operations
## *2. Hướng tiếp cận: Các thao tác trên cây N-ngôi*

### Insert
### *Chèn*
- Start at `root`.
- For each char in word:
    - Index = `char - 'a'`.
    - If `children[index]` is null, create new node.
    - Move to child.
- At the end, set `curr.isEnd = true`.

### Search
### *Tìm kiếm*
- Start at `root`.
- Traverse children based on chars.
- If child is null, return `false`.
- At the end, return `curr.isEnd` (Must be a complete word, not just a prefix).

### StartsWith
### *Tiền tố*
- Exactly like Search, but at the end, return `true` immediately (doesn't matter if it's an end or not, as long as the path exists).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Prefix Sharing:** Words like "apple", "apply", "ape" share the common path "ap". This saves space compared to storing each string independently if there are many common prefixes.
    *Chia sẻ tiền tố: Các từ chia sẻ đường dẫn chung, tiết kiệm không gian.*
*   **Speed:** All operations are $O(L)$, independent of the total number of words $N$ in the dictionary.
    *Tốc độ: Các thao tác là $O(L)$, độc lập với tổng số từ $N$.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** 
    - Insert: $O(L)$.
    - Search: $O(L)$.
    - StartsWith: $O(L)$.
    *Độ phức tạp thời gian: $O(L)$ cho mọi thao tác.*
*   **Space Complexity:** $O(N \times L)$ in the worst case (no common prefixes), but much better in practice.
    *Độ phức tạp không gian: $O(N \times L)$ trong trường hợp xấu nhất.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Insert "app"**:
Root -> 'a' node -> 'p' node -> 'p' node (set `isEnd=true`).

**Search "apple"**:
Root -> 'a' (OK) -> 'p' (OK) -> 'p' (OK) -> 'l' (Null!). Return False.

**Search "app"**:
Root -> 'a' -> 'p' -> 'p'. Path exists. `isEnd` is true. Return True.

**StartsWith "ap"**:
Root -> 'a' -> 'p'. Path exists. Return True.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Implementing a Trie is a fundamental skill. It appears in problems involving Autocomplete, Spell Checkers, and Grid Word Search (Boggle). The `children[26]` array technique is standard. Always remember the `isEnd` flag; without it, you can't distinguish between "a word" and "a prefix of another word".
*Triển khai Trie là kỹ năng cơ bản. Nó xuất hiện trong các bài toán Tự động hoàn thành, Kiểm tra chính tả, và Tìm từ trong lưới. Kỹ thuật mảng `children[26]` là tiêu chuẩn. Luôn nhớ cờ `isEnd`.*
---
*Một cái cây lớn bắt đầu từ một hạt mầm (gốc), và vạn từ ngữ bắt đầu từ những ký tự đầu tiên.*
A great tree starts from a seed (root), and ten thousand words start from the first characters.
