# 1208. Get Equal Substrings Within Budget / Lấy Chuỗi con Bằng nhau Trong Ngân sách

## Problem Description / Mô tả bài toán
Given strings `s` and `t` (same length), change `s` to `t`. Cost to change `s[i]` to `t[i]` is `|s[i] - t[i]|`.
Return max length of a substring of `s` that can be changed to corresponding substring of `t` with total cost <= `maxCost`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window / Cửa sổ Trượt
Array of costs: `diff[i] = abs(s[i] - t[i])`.
Find longest subarray with sum <= maxCost.
Standard sliding window: Expand right, if sum > maxCost, shrink left. Maximize window size.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) or O(1).

---

## Analysis / Phân tích

### Approach: Cost Array and Sliding Window
Compute the transformation cost for each character index: `cost[i] = |s[i] - t[i]|`. The problem reduces to finding the longest subarray in the `cost` array such that its sum does not exceed `maxCost`. Use a sliding window approach: extend the `right` pointer to include elements, and increment the `left` pointer to shrink the window whenever the current sum exceeds `maxCost`. The maximum window size achieved is the answer.
Tính chi phí chuyển đổi cho mỗi chỉ số ký tự: `cost[i] = |s[i] - t[i]|`. Bài toán quy về việc tìm mảng con dài nhất trong mảng `cost` sao cho tổng của nó không vượt quá `maxCost`. Sử dụng phương pháp cửa sổ trượt: mở rộng con trỏ `right` để bao gồm các phần tử và tăng con trỏ `left` để thu nhỏ cửa sổ bất cứ khi nào tổng hiện tại vượt quá `maxCost`. Kích thước cửa sổ tối đa đạt được là câu trả lời.

---
