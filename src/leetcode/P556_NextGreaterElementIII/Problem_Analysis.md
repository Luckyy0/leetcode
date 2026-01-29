# 556. Next Greater Element III / Phần Tử Lớn Hơn Tiếp Theo III

## Problem Description / Mô tả bài toán
Given a positive integer `n`, find the smallest integer which has exactly the same digits existing in the integer `n` and is greater in value than `n`. If no such positive integer exists, return `-1`.
Cho một số nguyên dương `n`, hãy tìm số nguyên nhỏ nhất có chính xác các chữ số tồn tại trong số nguyên `n` và có giá trị lớn hơn `n`. Nếu không tồn tại số nguyên dương nào như vậy, hãy trả về `-1`.

Note: The answer fits in a **32-bit integer**. If the result is greater than the 32-bit integer limit, return `-1`.
Lưu ý: Câu trả lời nằm trong giới hạn **số nguyên 32-bit**. Nếu kết quả lớn hơn giới hạn số nguyên 32-bit, hãy trả về `-1`.

### Example 1:
```text
Input: n = 12
Output: 21
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Next Permutation Algorithm / Thuật toán Hoán vị Tiếp theo
This is the classic "Next Permutation" problem applied to digits of a number.

Algorithm:
1. Convert `n` to a char array (digits).
2. Scan from right to left to find the first digit that is **smaller** than the digit to its right. Call this index `i`.
   - If no such `i` exists (digits are descending), return -1.
3. Scan from right to left again to find the first digit that is **larger** than `digits[i]`. Call this index `j`.
4. Swap `digits[i]` and `digits[j]`.
5. Reverse the sub-array from `i + 1` to the end.
6. Convert back to long. check if > `Integer.MAX_VALUE`.

### Complexity / Độ phức tạp
- **Time**: O(number of digits) ~ O(log N).
- **Space**: O(log N) for char array.

---

## Analysis / Phân tích

### Approach: Next Permutation Logic

**Algorithm**:
1.  Identify pivot where `nums[i] < nums[i+1]`.
2.  Find smallest element right of pivot > `nums[i]`.
3.  Swap and reverse suffix.
4.  Check for Integer overflow.

---
