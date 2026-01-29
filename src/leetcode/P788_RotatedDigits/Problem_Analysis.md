# 788. Rotated Digits / Chữ số được Xoay

## Problem Description / Mô tả bài toán
An integer `x` is **good** if after rotating each digit individually by 180 degrees, we get a valid number that is different from `x`.
Một số nguyên `x` là **tốt** nếu sau khi xoay từng chữ số một góc 180 độ, chúng ta nhận được một số hợp lệ khác với `x`.

Rules for rotating digits:
- `0, 1, 8` rotate to themselves.
- `2, 5` rotate to each other.
- `6, 9` rotate to each other.
- `3, 4, 7` are invalid after rotation.

Return the number of good integers in the range `[1, n]`.
Trả về số lượng số nguyên tốt trong phạm vi `[1, n]`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Digital Property / Thuộc tính Chữ số
Condition:
1. The number must NOT contain any of `[3, 4, 7]`.
2. The number MUST contain at least one of `[2, 5, 6, 9]`.
   (If it only contains `[0, 1, 8]`, it rotates to itself, which is not "good").

Algorithm:
- Check each number in `[1, n]`.

### Complexity / Độ phức tạp
- **Time**: O(N * log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Digit-wise Rule Verification
A straightforward check for each integer. For each digit, categorize it into "invalid", "stable", or "flippable".
Một kiểm tra trực tiếp cho mỗi số nguyên. Đối với mỗi chữ số, hãy phân loại nó thành "không hợp lệ", "ổn định" hoặc "có thể lật".

---
