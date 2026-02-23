# Analysis for Sentence Similarity
# *Phân tích cho bài toán Sự tương đồng của Câu*

## 1. Problem Essence & Local Similarity
## *1. Bản chất vấn đề & Sự tương đồng Cục bộ*

### The Challenge
### *Thách thức*
We need to determine if two sentences are similar based on a predefined set of word pairs. Crucially, similarity is bidirectional (if A is similar to B, then B is similar to A) but **not transitive** (if A ~ B and B ~ C, it doesn't mean A ~ C). This makes the problem much simpler than a full connectivity problem.
*Chúng ta cần xác định xem hai câu có tương đồng hay không dựa trên một tập hợp các cặp từ cho trước. Quan trọng nhất, sự tương đồng có tính đối xứng (nếu A giống B thì B giống A) nhưng **không có tính bắc cầu** (nếu A ~ B và B ~ C, không nhất thiết A ~ C). Điều này làm cho bài toán đơn giản hơn nhiều so với bài toán về tính liên thông đầy đủ.*

---

## 2. Strategy: HashSet for Instant Lookup
## *2. Chiến lược: HashSet để Tra cứu Tức thì*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Length Check:** If `sentence1` and `sentence2` have different lengths, they cannot be similar.
    * **Kiểm tra Độ dài:** Hai câu khác độ dài thì không thể tương đồng.*

2.  **Preprocessing Pairs:** Store the similarity pairs in a `Set<String>` to enable $O(1)$ lookup. To handle the bidirectional nature, we can either store both `w1#w2` and `w2#w1` or check both orientations during lookup.
    * **Tiền xử lý các Cặp:** Lưu các cặp tương đồng vào một `HashSet`. Để xử lý tính đối xứng, ta có thể lưu cả hai hướng hoặc kiểm tra cả hai hướng khi tra cứu.*

3.  **Strict Index-wise Comparison:**
    - Iterate from `i = 0` to `n-1`.
    - Retrieve `word1` and `word2` at index `i`.
    - **Conditions for similarity:**
        - They are the same word: `word1.equals(word2)`.
        - The pair `(word1, word2)` exists in the set.
        - The pair `(word2, word1)` exists in the set.
    - If none of the conditions are met, return `false`.
    * **So sánh từng Chỉ số:** Duyệt qua từng vị trí trong câu. Hai từ được coi là tương đồng nếu chúng giống hệt nhau hoặc tồn tại trong danh sách cặp (bất kể thứ tự).*

4.  **Final Result:** If the loop finishes, return `true`.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(P + N \cdot L)$, where $P$ is the number of pairs, $N$ is the number of words in a sentence, and $L$ is the average length of a word. We process each pair once and each word once.
    * **Độ phức tạp thời gian:** $O(P + N \cdot L)$.*
*   **Space Complexity:** $O(P \cdot L)$ to store all similar pairs in the HashSet.
    * **Độ phức tạp không gian:** $O(P \cdot L)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**s1 = ["great"], s2 = ["fine"], pairs = [["great", "fine"]]**
1. Set contains "great#fine".
2. Word pair: ("great", "fine").
3. Are they the same? No.
4. Is "great#fine" in set? **Yes.**
**Result:** true.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Using a `HashSet` of strings (joined with a delimiter like `#`) is a robust way to store relationships in Java. Since transitivity is not required, this $O(1)$ lookup approach is optimal.
*Sử dụng một `HashSet` chứa các chuỗi (nối bằng ký tự phân cách như `#`) là cách mạnh mẽ để lưu trữ các mối quan hệ. Vì không yêu cầu tính bắc cầu, cách tra cứu $O(1)$ này là tối ưu.*
---
*Sự tương đồng (Similarity) là một sợi dây liên kết giữa những biểu hiện khác nhau của cùng một ý niệm. Trong cấu trúc của ngôn ngữ, mỗi từ mang một trọng lượng riêng, và chỉ khi mọi thành phần đều cộng hưởng (Index-wise match), câu văn mới đạt được sự thống nhất. Dữ liệu dạy ta rằng bằng cách ghi nhớ những mối liên hệ trực tiếp (HashSet) và tôn trọng trật tự của sự sắp đặt (Sequential comparison), ta có thể xác nhận được sự đồng điệu đằng sau những hình thức khác biệt.*
Similarity (Similarity) is a bridge between different expressions of the same concept. In the structure of language, each word carries its own weight, and only when every component resonates (Index-wise match) can the sentence achieve unity. Data teaches us that by remembering direct connections (HashSet) and respecting the order of arrangement (Sequential comparison), we can confirm the harmony behind different forms.
