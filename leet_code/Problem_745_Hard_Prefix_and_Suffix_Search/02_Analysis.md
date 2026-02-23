# Analysis for Prefix and Suffix Search
# *Phân tích cho bài toán Tìm kiếm Tiền tố và Hậu tố*

## 1. Problem Essence & Combined Search
## *1. Bản chất vấn đề & Tìm kiếm Kết hợp*

### The Challenge
### *Thách thức*
We need to efficiently query words that match both a specific start (prefix) and a specific end (suffix). A standard Trie can verify a prefix efficiently, and a Reversed Trie can verify a suffix. However, intersecting the results from two separate Tries can be slow if many words share the same prefix or suffix.
*Chúng ta cần truy vấn hiệu quả các từ khớp với cả phần đầu cụ thể (tiền tố) và phần cuối cụ thể (hậu tố). Trie tiêu chuẩn có thể xác minh tiền tố hiệu quả, và Trie đảo ngược có thể xác minh hậu tố. Tuy nhiên, việc lấy giao của hai kết quả từ hai Trie riêng biệt có thể chậm nếu nhiều từ có chung tiền tố hoặc hậu tố.*

---

## 2. Strategy: Wrapped Suffix Trie
## *2. Chiến lược: Trie Hậu tố Bao bọc*

Instead of finding intersection, we can combine the suffix and prefix into a single search key.
*Thay vì tìm giao điểm, ta có thể kết hợp hậu tố và tiền tố thành một khóa tìm kiếm duy nhất.*

### Key Idea: `Suffix + { + Prefix`
### *Ý tưởng chính: `Hậu tố + { + Tiền tố`*
For a word `apple`, we want to find it with prefix `a` and suffix `e`.
Imagine we store the word in a format that exposes both ends.
Consider all suffixes of `apple`: `e`, `le`, `ple`, `pple`, `apple`.
For each suffix, append a separator `{` (ASCII > z) and then the full word.
- `e{apple`
- `le{apple`
- `ple{apple`
- `pple{apple`
- `apple{apple`

Now, to search for prefix `a` and suffix `e`, we search for `e{a` in the Trie!
- `e{a` matches the beginning of `e{apple`.
*Với từ `apple`, xét tất cả các hậu tố của nó. Với mỗi hậu tố, nối thêm dấu phân cách `{` và toàn bộ từ gốc. Khi tìm kiếm tiền tố `a` và hậu tố `e`, ta sẽ tìm chuỗi `e{a`. Chuỗi này sẽ khớp với đầu của `e{apple`.*

### Implementation Details
### *Chi tiết Cài đặt*
1.  **Trie Node:** Stores children and a `weight` (max index seen passing through this node).
2.  **Insertion:** For each word at index `i`, generate all keys `suffix + '{' + word` and insert them into the Trie. Update the `weight` at every visited node to `i`. Since we want the largest index, processing words in increasing order ensures the latest `i` overwrites or updates the `weight`.
3.  **Query:** Construct `suffix + '{' + prefix` and traverse the Trie. The `weight` at the final node matches the largest index of a word satisfying both conditions.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:**
    -   Initialization: $O(N \cdot L^2)$, where $N$ is number of words and $L$ is max length (10). For each word of length $L$, we insert $L$ keys of length approx $L$. Total $15000 \times 100$ operations. Very fast.
    -   Query: $O(L)$, length of prefix + suffix.
    *   **Độ phức tạp thời gian:** Khởi tạo $O(N \cdot L^2)$, Truy vấn $O(L)$.*
*   **Space Complexity:** $O(N \cdot L^2)$ nodes in the Trie. With $N=15000, L=10$, roughly 1.5M nodes. Feasible within memory limits.
    *   **Độ phức tạp không gian:** $O(N \cdot L^2)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Word:** "bad", index 0.
**Keys inserted:**
- `d{bad`
- `ad{bad`
- `bad{bad`

**Query:** `prefix="b", suffix="d"`
Search Key: `d{b`
- Path: `d` -> `{` -> `b`.
- Matches `d{bad`.
- Returns index 0.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

The "Paired Trie" or "Suffix-Wrapped Trie" technique transforms a multi-dimensional constraint (prefix AND suffix) into a single linear constraint (substring matching) by generating multiple search keys for each data item.
*Kỹ thuật "Trie Hậu tố Bao bọc" chuyển đổi một ràng buộc đa chiều (tiền tố VÀ hậu tố) thành một ràng buộc tuyến tính đơn giản (khớp chuỗi con) bằng cách tạo ra nhiều khóa tìm kiếm cho mỗi mục dữ liệu.*
---
*Tiền tố (Prefix) là sự khởi đầu, Hậu tố (Suffix) là sự kết thúc. Để tìm thấy một thực thể trọn vẹn (Word) thỏa mãn cả hai đầu, ta cần hợp nhất chúng thành một dòng chảy duy nhất (Composite Key). Dữ liệu dạy ta rằng bằng cách biến đổi góc nhìn (Wrapping keys), ta có thể biến hai điều kiện rời rạc thành một con đường liền mạch trong cây tìm kiếm (Trie path).*
Prefix (Prefix) is the beginning, Suffix (Suffix) is the end. To find a complete entity (Word) satisfying both ends, we need to unify them into a single flow (Composite Key). Data teaches us that by shifting perspective (Wrapping keys), we can transform two discrete conditions into a seamless path in the search tree (Trie path).
