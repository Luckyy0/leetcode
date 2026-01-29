# 453. Minimum Moves to Equal Array Elements / Số Lượng Di Chuyển Tối Thiểu Để Làm Bằng Các Phần Tử Mảng

## Problem Description / Mô tả bài toán
Given an integer array `nums` of size `n`, return the minimum number of moves required to make all array elements equal.
Cho một mảng số nguyên `nums` có kích thước `n`, hãy trả về số lượng di chuyển tối thiểu cần thiết để làm cho tất cả các phần tử trong mảng bằng nhau.

In one move, you can increment `n - 1` elements of the array by `1`.
Trong một lần di chuyển, bạn có thể tăng `n - 1` phần tử của mảng lên `1` đơn vị.

### Example 1:
```text
Input: nums = [1,2,3]
Output: 3
Explanation: Only three moves are needed (remember each move increments two elements):
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
```

### Example 2:
```text
Input: nums = [1,1,1]
Output: 0
```

## Constraints / Ràng buộc
- `n == nums.length`
- `1 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`
- The answer is guaranteed to fit in a **32-bit** integer. (Wait, let's check. Actually, it can be large, but constraints say answer fits in 32-bit. Actually, sum of moves can easily exceed 2^31-1 if not careful. Let's use `long` just in case).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Mathematical Conversion / Chuyển đổi Toán học
Incrementing `n - 1` elements by 1 is mathematically equivalent to **decrementing** 1 element by 1.
To make all elements equal by decrementing, they must all reach the value of the **minimum** element in the array.

Logic:
1. Find the minimum value `minVal` in the array.
2. For each element `x`, the number of decrements needed to reach `minVal` is `x - minVal`.
3. The total moves is the sum of `(nums[i] - minVal)` for all `i`.

Formula:
`Total moves = Sum(nums) - n * minVal`

### Complexity / Độ phức tạp
- **Time**: O(N) to find the minimum and the sum.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Relative Decrement

**Algorithm**:
1.  Initialize `minVal` and `sum`.
2.  Iterate and compute.
3.  Calculate final result.

---
