# 1493. Longest Subarray of 1's After Deleting One Element / Mảng con 1 Dài nhất Sau khi Xóa Một Phần tử

## Problem Description / Mô tả bài toán
Binary array `nums`. Delete exactly one element.
Longest contiguous subarray of 1s.
Non-empty array. Must delete one.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window
Window `[left, right]`. Constraint: at most 1 zero allowed inside window.
If `zeros > 1`: shrink `left` until `zeros <= 1`.
Max length is `right - left`. (Size of window minus 1 deleted element).
Wait. If window has NO zeros, we MUST delete one 1. Length is `window size - 1`.
If window has 1 zero, we delete that zero. Length is `window size - 1`.
So result is always `max(right - left)`.
Be careful if all 1s. We must delete one. `total 1s - 1`.
The window logic gives `right - left + 1` size. Mimus one is `right - left`.
Formula: `max(right - left)` over valid windows.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Sliding Window
Expand `right`. Count zeros.
While `count > 1`, increment `left`.
Update max `right - left`.
Case: All 1s. Window goes 0 to n-1. `right-left` = n-1. Correct.
Cửa sổ trượt. Mở rộng `right`. Đếm số không.
Trong khi `count > 1`, tăng `left`.
Cập nhật max `right - left`.

---
