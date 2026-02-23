# Analysis for Add Bold Tag in String
# *Phân tích cho bài toán Thêm Thẻ In đậm vào Chuỗi*

## 1. Problem Essence & Boolean Masking
## *1. Bản chất vấn đề & Mặt nạ Boolean*

### The Challenge
### *Thách thức*
We need to highlight multiple potentially overlapping or consecutive substrings in a main string `s`.
*Chúng ta cần đánh dấu nhiều chuỗi con có khả năng chồng lấp hoặc liên tiếp nhau trong một chuỗi chính `s`.*

The merging rule is key: Any sequence of characters that belongs to at least one valid word should be wrapped in a single pair of `<b>...</b>`.
*Quy tắc hợp nhất là then chốt: Bất kỳ chuỗi ký tự nào thuộc về ít nhất một từ hợp lệ đều phải được bao bọc trong một cặp thẻ `<b>...</b>` duy nhất.*

---

## 2. Strategy: Flagging and Interval Merging
## *2. Chiến lược: Đánh dấu và Hợp nhất Khoảng*

Instead of trying to insert tags directly while searching (which is complex due to overlaps), we first mark which characters should be bold.
*Thay vì cố gắng chèn các thẻ trực tiếp trong khi tìm kiếm (việc này phức tạp do có sự chồng lấp), trước tiên chúng ta đánh dấu những ký tự nào nên được in đậm.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Boolean Mask:** Create a boolean array `isBold` of the same length as `s`, initialized to `false`.
    * **Mặt nạ Boolean:** Tạo một mảng boolean `isBold` có cùng độ dài với `s`, khởi tạo là `false`.*

2.  **Marking Clusters:** For each word in `words`, find all its occurrences in `s`.
    * **Đánh dấu các cụm:** Đối với mỗi từ trong `words`, hãy tìm tất cả các lần xuất hiện của nó trong `s`.*
    - For each occurrence from index `start` to `end`, set `isBold[i] = true` for all `i` in that range.
    - *Đối với mỗi lần xuất hiện từ chỉ số `start` đến `end`, hãy đặt `isBold[i] = true` cho tất cả các `i` trong phạm vi đó.*

3.  **Construct Result:** Traverse `s` and the `isBold` array simultaneously.
    * **Xây dựng Kết quả:** Duyệt qua `s` và mảng `isBold` đồng thời.*
    - When `isBold[i]` changes from `false` to `true`, append `<b>`.
    - *Khi `isBold[i]` chuyển từ `false` sang `true`, hãy thêm `<b>`.*
    - When `isBold[i]` changes from `true` to `false`, append `</b>`.
    - *Khi `isBold[i]` chuyển từ `true` sang `false`, hãy thêm `</b>`.*
    - Always append the character `s[i]`.
    - *Luôn thêm ký tự `s[i]`.*

4.  **Final Boundary:** If the string ends while `isBold` is still `true`, don't forget the closing `</b>`.
    * **Ranh giới Cuối cùng:** Nếu chuỗi kết thúc trong khi `isBold` vẫn là `true`, đừng quên thẻ đóng `</b>`.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Simplification:** Marking a boolean array elegantly handles both overlaps ("aaa" and "aab" in "aaab") and adjacency ("abc" and "def" in "abcdef").
    * **Sự đơn giản hóa:** Việc đánh dấu một mảng boolean xử lý một cách thanh lịch cả sự chồng lấp ("aaa" và "aab" trong "aaab") và sự liền kề ("abc" và "def" trong "abcdef").*
*   **Search Optimization:** Using `s.indexOf(word, fromIndex)` repeatedly is a simple and effective way to find all occurrences. For very large inputs, an Aho-Corasick automaton could be used for $O(N)$ multi-pattern matching.
    * **Tối ưu hóa Tìm kiếm:** Sử dụng `s.indexOf(word, fromIndex)` liên tục là một cách đơn giản và hiệu quả để tìm thấy tất cả các lần xuất hiện. Đối với đầu vào rất lớn, có thể sử dụng biểu đồ Aho-Corasick để khớp đa mẫu trong $O(N)$.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \times \sum L_i)$, where $N$ is the length of `s` and $L_i$ are lengths of words. We search for each word across the string.
    * **Độ phức tạp thời gian:** $O(N \times \sum L_i)$, trong đó $N$ là độ dài của `s` và $L_i$ là độ dài các từ. Chúng ta tìm kiếm từng từ trên toàn bộ chuỗi.*
*   **Space Complexity:** $O(N)$ for the boolean mask and the `StringBuilder` result.
    * **Độ phức tạp không gian:** $O(N)$ cho mặt nạ boolean và kết quả của `StringBuilder`.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** s = "aaabbcc", words = ["aaa", "aab", "bc"]
1. mask = [F,F,F,F,F,F,F]
2. word "aaa": mask[0..2] = T. Mask = [T,T,T,F,F,F,F]
3. word "aab": mask[1..3] = T. Mask = [T,T,T,T,F,F,F]
4. word "bc": mask[4..5] = T. Mask = [T,T,T,T,T,T,F]
5. Construction:
   - i=0: bold start! Add `<b>`, then 'a'.
   - i=1..5: all bold. Add characters.
   - i=6: bold end! Add `</b>`, then 'c'.
**Result:** "<b>aaabbc</b>c"

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

When dealing with interval merging on a discrete space (like characters in a string), a boolean mask is often the most robust solution. It decouples the "analysis" phase from the "transformation" phase, leading to cleaner code.
*Khi xử lý việc hợp nhất các khoảng trên một không gian rời rạc (như các ký tự trong một chuỗi), một mặt nạ boolean thường là giải pháp mạnh mẽ nhất. Nó tách biệt giai đoạn "phân tích" khỏi giai đoạn "biến đổi", dẫn đến mã nguồn sạch sẽ hơn.*
---
*Sự nhấn mạnh (Emphasis) là cách chúng ta định hướng sự chú ý. Trong một biển thông tin (String), những từ khóa (Words) cần được làm nổi bật để bộc lộ tầng ý nghĩa ẩn giấu. Việc hợp nhất (Merging) các vùng in đậm giúp ta nhìn thấy những cụm tri thức (Clusters) thay vì những mảnh vụn rời rạc.*
Emphasis (Emphasis) is how we direct attention. In a sea of information (String), keywords (Words) need to be highlighted to reveal hidden layers of meaning. Merging (Merging) bolded regions helps us see clusters of knowledge (Clusters) instead of scattered fragments.
