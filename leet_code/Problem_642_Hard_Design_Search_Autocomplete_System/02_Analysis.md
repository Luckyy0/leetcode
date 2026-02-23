# Analysis for Design Search Autocomplete System
# *Phân tích cho bài toán Thiết kế Hệ thống Gợi ý Tìm kiếm*

## 1. Problem Essence & Data Modeling
## *1. Bản chất vấn đề & Mô hình hóa Dữ liệu*

### The Challenge
### *Thách thức*
We need to manage a dynamic dictionary of sentences with their frequencies and provide real-time suggestions as the user types character by character. 
*Chúng ta cần quản lý một từ điển động gồm các câu cùng với tần suất của chúng và cung cấp các gợi ý thời gian thực khi người dùng nhập từng ký tự một.*

Key requirements:
1.  **Prefix Matching:** Quickly find all sentences starting with the current input.
2.  **Ranking:** Sort results by frequency (desc) and lexicographical order (asc).
3.  **Persistence:** Save the complete sentence when '#' is typed and update frequencies.

---

## 2. Strategy: Trie with Node Counts
## *2. Chiến lược: Trie với Bộ đếm tại Nút*

A **Trie (Prefix Tree)** is the ideal data structure for prefix matching.
*Một **Trie (Cây tiền tố)** là cấu trúc dữ liệu lý tưởng cho việc khớp tiền tố.*

### Data Structures
### *Cấu trúc Dữ liệu*

1.  **TrieNode:**
    - `Map<Character, TrieNode> children`: Links to child characters.
    - `Map<String, Integer> counts`: At each node, we can store all sentences passing through this node and their frequencies. This speeds up retrieval but uses more memory.
    - *Mỗi nút Trie có thể lưu trữ tất cả các câu đi qua nó và tần suất của chúng để tăng tốc truy xuất.*

2.  **Global Frequency Map:** To easily update the counts in the Trie when a sentence is finished.
    * **Bản đồ Tần suất Toàn cầu:** Để dễ dàng cập nhật số lượng trong Trie khi một câu kết thúc.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Initialization:** Build the Trie using the initial sentences and frequencies.
    * **Khởi tạo:** Xây dựng Trie bằng các câu và tần suất ban đầu.*

2.  **Input Character Handling:**
    * **Xử lý Ký tự Nhập vào:** *
    - If '#': Update the current sentence's frequency in the Trie and reset the current prefix tracking.
    - If a character: Move the current Trie pointer to the corresponding child. If no child exists, keep track but return empty.
    - Retrieval: From the current Trie node, get all stored sentences and pick the top 3 using a Custom Comparator or a Priority Queue.

3.  **Top 3 Selection:** Sort the list of sentences found at the current node:
    - Primary: `frequency` descending.
    - Secondary: `sentence` ascending.
    - *Chọn Top 3: Sắp xếp danh sách các câu tìm thấy tại nút hiện tại theo tần suất (giảm dần) và từ điển (tăng dần).*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Caching at Nodes:** By storing `Map<String, Integer>` at every node, we avoid traversing the whole subtree to find all sentences. Since the constraints are relatively small (100 sentences/length), this trade-off between memory and speed is beneficial.
    * **Bộ nhớ đệm tại Nút:** Bằng cách lưu trữ `Map<String, Integer>` tại mỗi nút, chúng ta tránh được việc duyệt qua toàn bộ cây con để tìm tất cả các câu.*
*   **Case Sensitivity:** The Trie must handle uppercase, lowercase, and spaces.
    * **Phân biệt chữ hoa chữ thường:** Trie phải xử lý chữ hoa, chữ thường và khoảng trắng.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** 
    - `AutocompleteSystem` (Init): $O(\sum L \times S)$, where $L$ is sentence length and $S$ is number of sentences.
    - `input`: $O(1)$ to find the node, but $O(M \log M)$ to sort $M$ sentences at that node.
    - *Độ phức tạp thời gian: Khởi tạo $O(\sum L \times S)$. Hàm `input` tốn $O(M \log M)$ để sắp xếp $M$ câu tại nút đó.*
*   **Space Complexity:** $O(\sum L \times S)$ to store the Trie and theCached maps.
    * **Độ phức tạp không gian: $O(\sum L \times S)$ để lưu trữ Trie và các bản đồ đệm.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** "i"
1. Trie traverses to 'i' node.
2. Current node has map: {"i love you": 5, "island": 3, "i love leetcode": 2}.
3. Sorting and limit 3 results in `["i love you", "island", "i love leetcode"]`.

**Input:** " " (Space)
1. Trie traverses from 'i' node to ' ' node.
2. Current node has map: {"i love you": 5, "i love leetcode": 2}.
3. Sorting results in `["i love you", "i love leetcode"]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For complex autocomplete systems, a Trie is the standard choice. Depending on the scale, you can choose to store counts at every node (high performance, high memory) or only at terminal nodes and traverse on demand (low performance, low memory).
*Đối với các hệ thống gợi ý tìm kiếm phức tạp, Trie là lựa chọn tiêu chuẩn. Tùy thuộc vào quy mô, bạn có thể chọn lưu trữ số lượng tại mọi nút hoặc chỉ tại các nút kết thúc.*
---
*Sự tiên đoán (Autocomplete) là cầu nối giữa ý định và hành động. Trong mạng lưới các từ ngữ (Trie), mỗi bước đi (Character) thu hẹp dần những khả năng, để lại những gì quen thuộc và ý nghĩa nhất (Hot sentences). Dữ liệu dạy ta rằng lịch sử (Historical frequency) không chỉ là con số, mà là la bàn định hướng cho sự tìm kiếm trong tương lai.*
Prediction (Autocomplete) is the bridge between intention and action. In the web of words (Trie), each step (Character) gradually narrows the possibilities, leaving what is most familiar and meaningful (Hot sentences). Data teaches us that history (Historical frequency) is not just a number, but a compass for future search.
