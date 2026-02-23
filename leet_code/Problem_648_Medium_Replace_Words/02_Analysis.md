# Analysis for Replace Words
# *Phân tích cho bài toán Thay thế Từ*

## 1. Problem Essence & Shortest Root Matching
## *1. Bản chất vấn đề & Khớp Gốc từ Ngắn nhất*

### The Challenge
### *Thách thức*
We have a list of prefix "roots" and a sentence. For each word in the sentence, we need to check if any root is a prefix of that word. If multiple roots match, we choose the shortest one.
*Chúng ta có một danh sách các "gốc từ" và một câu văn. Với mỗi từ trong câu, chúng ta cần kiểm tra xem có gốc từ nào là tiền tố của từ đó hay không. Nếu có nhiều gốc từ khớp, chúng ta chọn từ ngắn nhất.*

---

## 2. Strategy: Trie (Prefix Tree)
## *2. Chiến lược: Trie (Cây tiền tố)*

A **Trie** is the optimal structure for prefix-based searches.
*Một **Trie** là cấu trúc tối ưu cho các tìm kiếm dựa trên tiền tố.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Build Trie:** Insert all words from the `dictionary` into the Trie.
    * **Xây dựng Trie:** Chèn tất cả các từ trong `dictionary` vào Trie.*
    - Mark the end of each root with an `isEndOfRoot` boolean.

2.  **Sentence Parsing:** Split the `sentence` into individual words.
    * **Phân tích Câu:** Chia `sentence` thành các từ riêng lẻ.*

3.  **Prefix Search:** For each word:
    * **Tìm kiếm Tiền tố:** Với mỗi từ: *
    - Traverse the Trie character by character.
    - If we encounter a node with `isEndOfRoot == true`, it means we reached the shortest root for this word. Return this root.
    - If we reach a character that is not in the Trie before finding the end of a root, the word has no root in the dictionary. Return the original word.

4.  **Reconstruction:** Join the processed words back with spaces.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Shortest Match:** By traversing the Trie and stopping at the *first* `isEndOfRoot` encountered, we naturally satisfy the requirement to pick the shortest root.
    * **Khớp ngắn nhất:** Bằng cách duyệt Trie và dừng lại ở `isEndOfRoot` *đầu tiên* gặp phải, chúng ta đáp ứng yêu cầu chọn gốc từ ngắn nhất.*
*   **Efficiency:** Instead of $O(\text{Roots} \times \text{WordLength})$ per word, we only spend $O(\text{WordLength})$ per word using the Trie.
    * **Hiệu suất:** Thay vì tốn $O(Gốc \times Độ dài)$ cho mỗi từ, chúng ta chỉ tốn $O(Độ dài)$ nhờ sử dụng Trie.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(D + S)$, where $D$ is the total number of characters in the dictionary and $S$ is the number of characters in the sentence. Building the Trie takes $O(D)$, and processing the sentence takes $O(S)$.
    * **Độ phức tạp thời gian:** $O(D + S)$, trong đó $D$ là tổng số ký tự trong từ điển và $S$ là số ký tự trong câu.*
*   **Space Complexity:** $O(D \times 26)$ worst case for the Trie structure.
    * **Độ phức tạp không gian:** $O(D \times 26)$ trong trường hợp xấu nhất cho cấu trúc Trie.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Dictionary:** ["cat", "bat", "rat"]
**Word:** "cattle"
1. 'c' - in Trie.
2. 'a' - in Trie.
3. 't' - in Trie and is end of root ("cat").
**Result:** "cat".

**Word:** "battery"
1. 'b' - in Trie.
2. 'a' - in Trie.
3. 't' - in Trie and is end of root ("bat").
**Result:** "bat".

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Trie-based prefix matching is a staple for text processing applications. It provides the best performance for "dictionary-driven" replacement or validation tasks.
*Khớp tiền tố dựa trên Trie là một phần không thể thiếu cho các ứng dụng xử lý văn bản. Nó cung cấp hiệu suất tốt nhất cho các nhiệm vụ thay thế hoặc xác thực dựa trên từ điển.*
---
*Gốc rễ (Root) là khởi nguồn của ý nghĩa. Trong sự phái sinh (Derivative) phức tạp của ngôn ngữ, việc tìm về cội nguồn ngắn nhất (Shortest root) giúp ta giản lược sự rườm rà mà không làm mất đi thông điệp. Dữ liệu dạy ta rằng bằng cách xây dựng một hệ thống phân cấp (Trie), ta có thể chắt lọc tinh hoa từ những hình thức sơ khai nhất.*
Roots (Root) are the source of meaning. In the complex derivation (Derivative) of language, finding the shortest root (Shortest root) helps us simplify verbosity without losing the message. Data teaches us that by building a hierarchical system (Trie), we can distill the essence from the most primitive forms.
