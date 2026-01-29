# 646. Maximum Length of Pair Chain / Độ Dài Chuỗi Cặp Tối Đa

## Problem Description / Mô tả bài toán
You are given an array of `n` pairs `pairs` where `pairs[i] = [left_i, right_i]` and `left_i < right_i`.
Bạn được cho một mảng `n` cặp `pairs` trong đó `pairs[i] = [left_i, right_i]` và `left_i < right_i`.

A pair `p2 = [c, d]` follows a pair `p1 = [a, b]` if `b < c`. A chain of pairs can be formed in this fashion.
Một cặp `p2 = [c, d]` theo sau một cặp `p1 = [a, b]` nếu `b < c`. Một chuỗi các cặp có thể được hình thành theo cách này.

Return the length longest chain which can be formed.
Trả về độ dài chuỗi dài nhất có thể được hình thành.

You do not need to use up all the given intervals. You can select pairs in any order.
Bạn không cần phải sử dụng hết tất cả các khoảng đã cho. Bạn có thể chọn các cặp theo bất kỳ thứ tự nào.

### Example 1:
```text
Input: pairs = [[1,2],[2,3],[3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4].
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy (Interval Scheduling) / Tham Lam (Lập Lịch Khoảng)
This is equivalent to finding the maximum number of non-overlapping intervals.
Standard Greedy approach:
1. Sort pairs by their **end** time (`right_i`).
2. Iterate through sorted pairs.
3. Pick a pair if its `start` time > current chain's `end` time.
4. Update current end time.
   
Why sort by end time? By picking the interval that finishes earliest, we leave maximum room for future intervals.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Greedy Sort by End

**Algorithm**:
1.  Sort pairs by second element.
2.  Iterate and count compatible pairs.

---
