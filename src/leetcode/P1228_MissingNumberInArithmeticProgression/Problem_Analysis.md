# 1228. Missing Number In Arithmetic Progression / Số còn thiếu trong Cấp số cộng

## Problem Description / Mô tả bài toán
Given an arithmetic progression array `arr` with one missing value.
Return the missing value.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sum Formula / Difference Check
1. Calculate expected sum: `(first + last) * (n+1) / 2`.
2. Actual sum: `sum(arr)`.
3. Missing = `Expected - Actual`.
Edge case: If `diff == 0`, elements are same. `n+1` elements same. If one missing, they are still same. Missing is `arr[0]`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Summation
Since the original sequence (including the missing number) is an arithmetic progression, the sum of its terms can be calculated using the formula $\frac{(\text{first} + \text{last}) \times \text{count}}{2}$, where count is `arr.length + 1`. The diffence between this expected sum and the actual sum of the array is the missing number. Note: if the progression is constant (difference 0), the missing number is just the first element.
Vì dãy ban đầu (bao gồm số còn thiếu) là một cấp số cộng, tổng các số hạng của nó có thể được tính bằng công thức $\frac{(\text{đầu} + \text{cuối}) \times \text{số lượng}}{2}$, trong đó số lượng là `arr.length + 1`. Sự khác biệt giữa tổng dự kiến này và tổng thực tế của mảng là số còn thiếu. Lưu ý: nếu cấp số cộng là hằng số (hiệu 0), số còn thiếu chỉ là phần tử đầu tiên.

---
