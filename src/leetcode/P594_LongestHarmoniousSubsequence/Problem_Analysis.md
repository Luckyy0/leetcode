# 594. Longest Harmonious Subsequence / Chuỗi Con Hài Hòa Dài Nhất

## Problem Description / Mô tả bài toán
We define a harmonious array as an array where the difference between its maximum value and its minimum value is **exactly 1**.
Chúng tôi xác định một mảng hài hòa là một mảng trong đó sự khác biệt giữa giá trị tối đa và giá trị tối thiểu của nó là **chính xác là 1**.

Given an integer array `nums`, return the length of its longest harmonious subsequence among all its possible subsequences.
Cho một mảng số nguyên `nums`, trả về độ dài của chuỗi con hài hòa dài nhất của nó trong số tất cả các chuỗi con có thể có của nó.

A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.
Một chuỗi con của mảng là một chuỗi có thể được bắt nguồn từ mảng bằng cách xóa một số hoặc không có phần tử nào mà không thay đổi thứ tự của các phần tử còn lại.

### Example 1:
```text
Input: nums = [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### HashMap Frequency / Tần Suất HashMap
We look for a subset of numbers consisting ONLY of `x` and `x+1`.
Length = `count(x) + count(x+1)`.
Algorithm:
1. Count frequencies of all numbers.
2. Iterate through keys in map.
3. If map contains `key + 1`:
   - `len = map.get(key) + map.get(key + 1)`.
   - `maxLen = max(maxLen, len)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Frequency Map

**Algorithm**:
1.  Count occurrences of each number.
2.  Iterate map keys.
3.  Check if `key + 1` exists.
4.  If yes, sum counts and update max.

---
