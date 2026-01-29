# 691. Stickers to Spell Word / Nhãn dán để Đánh vần Từ

## Problem Description / Mô tả bài toán
We are given `n` different types of stickers. Each sticker has a lowercase English word on it.
Chúng ta được cho `n` loại nhãn dán khác nhau. Mỗi nhãn dán có một từ tiếng Anh viết thường trên đó.

You would like to spell out the given target string `target` by cutting individual letters from your stickers and rearranging them. You can use each sticker more than once if you want, and you have infinite quantities of each sticker.
Bạn muốn đánh vần chuỗi mục tiêu `target` bằng cách cắt các chữ cái riêng lẻ từ các nhãn dán của mình và sắp xếp lại chúng. Bạn có thể sử dụng mỗi nhãn dán nhiều hơn một lần nếu muốn và bạn có số lượng vô hạn mỗi loại nhãn dán.

Return the minimum number of stickers that you need to spell out `target`. If the task is impossible, return -1.
Trả về số lượng nhãn dán tối thiểu bạn cần để đánh vần `target`. Nếu nhiệm vụ không khả thi, hãy trả về -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Recursion with Memoization (DP) / Đệ quy với Ghi nhớ (DP)
This is a variation of the change-making problem but with multiple character types.
Đây là một biến thể của bài toán đổi tiền nhưng với nhiều loại ký tự.

State: The remaining characters needed to form the `target`.
Trạng thái: Các ký tự còn lại cần thiết để tạo thành `target`.

Optimization:
- Only consider stickers that contain the first character needed in the current target string. This significantly prunes the search space.
- Store frequencies of characters for both stickers and target.

### Complexity / Độ phức tạp
- **Time**: O(2^T * S * T) where T is length of target and S is number of stickers.
- **Space**: O(2^T).

---

## Analysis / Phân tích

### Approach: Frequency-based DFS
Represent the target as a sorted string or a sorted frequency map. Use memoization to avoid redundant computations of the same sub-target.
Biểu diễn mục tiêu dưới dạng một chuỗi đã sắp xếp hoặc một bản đồ tần suất đã sắp xếp. Sử dụng ghi nhớ để tránh các tính toán thừa cho cùng một mục tiêu con.

---
