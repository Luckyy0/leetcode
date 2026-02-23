# Analysis for Sentence Screen Fitting
# *Phân tích cho bài toán Lắp câu vào Màn hình*

## 1. Problem Essence & Continuous Character Stream
## *1. Bản chất vấn đề & Luồng ký tự liên tục*

### The Challenge
### *Thách thức*
Counting sentence repetitions on a grid. The constraint is that words cannot be split between lines. If a word doesn't fit, the entire word moves to the next row.

### Strategy: Cursor-based Simulation
### *Chiến lược: Mô phỏng dựa trên con trỏ*
1.  **Format the Sentence:** Join all words in the sentence into a single string `s` with a space between each word and **one extra space at the end**.
    - Example: `["hello", "world"]` $\to$ `"hello world "`.
2.  **Tracking Cursor:** Use a variable `start` to represent the total number of characters fitted globally.
3.  **Process Rows:** For each row:
    - Increment `start` by `cols` (assuming for a moment that all characters fit).
    - Check where the row ends in the cyclic string `s`:
        - If `s[start % len] == ' '`: The row ended exactly on a space. This is perfect. Increment `start++` to account for the space after the word.
        - If `s[(start - 1) % len] == ' '`: The row ended on the last character of a word. Perfect fit.
        - Otherwise: The row ended in the middle of a word. We must move `start` backward until we hit a space (effectively moving the incomplete word to the next line).
4.  **Result:** `start / s.length()`.

---

## 2. Approach: Circular String Matching
## *2. Hướng tiếp cận: Khớp chuỗi vòng*

### Logic
### *Logic*
(See above). The modulo operator `%` allows us to treat a single string as an infinite repetition. The backward correction ensures the non-splitting constraint is met.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(Rows + Length) Complexity:** Much faster than word-by-word simulation for large screens.
    *Hiệu quả O(Rows + Length): Nhanh hơn nhiều so với mô phỏng từng từ.*
*   **Intuitive Logic:** Correcting the "cursor" is more robust than handling split cases manually.
    *Logic trực quan: Sửa con trỏ đáng tin cậy hơn việc xử lý các trường hợp tách từ thủ công.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\text{rows} + \text{combined length of words})$.
    *Độ phức tạp thời gian: $O(\text{rows} + \text{tổng độ dài từ})$.*
*   **Space Complexity:** $O(\text{combined length of words})$.
    *Độ phức tạp không gian: $O(\text{tổng độ dài từ})$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Rows:** 3, **Cols:** 6, **Sentence:** `["a", "bcd", "e"]`
String `s`: `"a bcd e "` (Length 8).
1. `row 0`: `start = 0 + 6 = 6`. `s[6]` is 'e'. `s[6-1]` is ' ' (before 'e'). Good. `start` stays 6.
2. `row 1`: `start = 6 + 6 = 12`. `s[12%8=4]` is 'd'. Backtrack until space: `s[1]` is ' '. `start = 9`.
3. `row 2`: `start = 9 + 6 = 15`. `s[15%8=7]` is ' '. `start++` $\to$ 16.
Result: `16 / 8 = 2`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

String concatenation with space backtracking.
*Nối chuỗi với lùi con trỏ tại khoảng trắng.*
---
*Cuộc sống giống như việc sắp xếp những ngôn từ lên một trang giấy giới hạn (screen). Có những điều không thể bị chia cắt (words), và nếu chúng không còn chỗ đứng, ta buộc phải lùi bước (backtrack) để bắt đầu lại từ một khởi đầu mới (next row). Sự kiên nhẫn trong từng dòng kẻ sẽ mang lại ý nghĩa trọn vẹn (repetition count) cho cả một câu chuyện dài.*
Life is like arranging words on a limited page (screen). There are things that cannot be divided (words), and if they no longer have a place, we are forced to step back (backtrack) to start over from a new beginning (next row). Patience in each line will bring complete meaning (repetition count) to a long story.
