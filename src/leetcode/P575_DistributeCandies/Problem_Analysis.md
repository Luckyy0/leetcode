# 575. Distribute Candies / Phân Phối Kẹo

## Problem Description / Mô tả bài toán
Alice has `n` candies, where the `i-th` candy is of type `candyType[i]`. Alice noticed that she started to gain weight, so she visited a doctor.
Alice có `n` viên kẹo, trong đó viên kẹo thứ `i` thuộc loại `candyType[i]`. Alice nhận thấy mình bắt đầu tăng cân nên cô đã đi khám bác sĩ.

The doctor advised Alice to only eat `n / 2` of the candies she has (n is always even). Alice likes her candies very much, and she wants to eat the maximum number of different types of candies while still following the doctor's advice.
Bác sĩ khuyên Alice chỉ nên ăn `n / 2` số kẹo mà cô có (n luôn là số chẵn). Alice rất thích kẹo của mình, và cô ấy muốn ăn số lượng loại kẹo khác nhau tối đa trong khi vẫn tuân theo lời khuyên của bác sĩ.

Given the integer array `candyType` of length `n`, return the maximum number of different types of candies she can eat if she only eats `n / 2` of them.
Cho mảng số nguyên `candyType` có độ dài `n`, hãy trả về số lượng loại kẹo khác nhau tối đa cô ấy có thể ăn nếu cô ấy chỉ ăn `n / 2` trong số chúng.

### Example 1:
```text
Input: candyType = [1,1,2,2,3,3]
Output: 3
Explanation: maximize types -> 1, 2, 3. Total eaten = 3. 3 <= n/2 (3).
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### HashSet / HashSet
We want to maximize unique types.
1. Count the number of unique candy types using a HashSet.
2. The limit is `n / 2`.
3. The result is `min(unique_types, n / 2)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Set Cardinality with Limit

**Algorithm**:
1.  Store all candy types in a HashSet.
2.  Count unique types (`size()`).
3.  Calculate max allowed candies (`n / 2`).
4.  Return smaller of the two values.

---
