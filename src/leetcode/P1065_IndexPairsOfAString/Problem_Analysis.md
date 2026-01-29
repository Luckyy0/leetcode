# 1065. Index Pairs of a String / Các cặp Chỉ số của một Chuỗi

## Problem Description / Mô tả bài toán
Given a string `text` and an array of strings `words`, return all index pairs `[i, j]` such that `text[i...j]` is in `words`.
Cho một chuỗi `text` và một mảng các chuỗi `words`, hãy trả về tất cả các cặp chỉ số `[i, j]` sao cho `text[i...j]` nằm trong `words`.

Return the pairs sorted by `i` (start index) in increasing order, and then by `j` (end index) in increasing order.
Trả về các cặp được sắp xếp theo `i` (chỉ số bắt đầu) theo thứ tự tăng dần, và sau đó theo `j` (chỉ số kết thúc) theo thứ tự tăng dần.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Trie / Cấu trúc Trie
Algorithm:
1. Build a Trie from `words`. Mark end nodes.
2. Iterate `i` from 0 to `text.length()`.
3. From `i`, traverse Trie with `text[i], text[i+1], ...`
4. If node is end of a word, add `[i, k]` to results.
5. If match fails, break inner loop.

### Complexity / Độ phức tạp
- **Time**: O(N * L + W * M), where N is text length, L is max word length, W is number of words, M is avg word length. Trie build O(WM). Scan O(NL).
- **Space**: O(WM).

---

## Analysis / Phân tích

### Approach: Trie-based Scanning
Index all dictionary words into a Trie for efficient prefix finding. For every position in the text, attempt to traverse the Trie. Whenever a Trie node marking the end of a word is encountered, record the current span as a valid pair. Sorting is guaranteed by the iteration order (left-to-right start index, then expanding end index).
Lập chỉ mục tất cả các từ trong từ điển vào Trie để tìm tiền tố hiệu quả. Đối với mọi vị trí trong văn bản, hãy cố gắng duyệt qua Trie. Bất cứ khi nào gặp một nút Trie đánh dấu sự kết thúc của một từ, hãy ghi lại khoảng hiện tại là một cặp hợp lệ. Việc sắp xếp được đảm bảo bởi thứ tự lặp (chỉ số bắt đầu từ trái sang phải, sau đó mở rộng chỉ số kết thúc).

---
