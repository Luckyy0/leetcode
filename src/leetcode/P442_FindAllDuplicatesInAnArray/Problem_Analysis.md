# 442. Find All Duplicates in an Array / Tìm Tất Cả Các Phần Tử Trùng Lặp Trong Mảng

## Problem Description / Mô tả bài toán
Given an integer array `nums` of length `n` where all the integers of `nums` are in the range `[1, n]` and each integer appears **once** or **twice**, return an array of all the integers that appears **twice**.
Cho một mảng số nguyên `nums` có độ dài `n`, trong đó tất cả các số nguyên nằm trong phạm vi `[1, n]` và mỗi số nguyên xuất hiện **một** hoặc **hai** lần, hãy trả về một mảng chứa tất cả các số nguyên xuất hiện **hai** lần.

You must write an algorithm that runs in `O(n)` time and uses only constant extra space.
Bạn phải viết một thuật toán chạy trong thời gian `O(n)` và chỉ sử dụng không gian bổ sung không đổi.

### Example 1:
```text
Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
```

### Example 2:
```text
Input: nums = [1,1,2]
Output: [1]
```

## Constraints / Ràng buộc
- `n == nums.length`
- `1 <= n <= 10^5`
- `1 <= nums[i] <= n`
- Each element appears **once** or **twice**.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Index as Hash Map / Sử dụng Chỉ số như bảng băm
Since all values are in the range `[1, n]`, we can use the array itself as a hash map by treating values as indices.
When we see a value `x`, we go to index `abs(x) - 1` and flip the sign of the value at that index.
1. If the value at `abs(x) - 1` is positive, it means we are seeing `x` for the first time. Flip it to negative.
2. If the value at `abs(x) - 1` is already negative, it means we have seen `x` before. Add `abs(x)` to our result list.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of `nums`.
- **Space**: O(1) (excluding the space for the result list).

---

## Analysis / Phân tích

### Approach: Sign Flipping at Indices

**Algorithm**:
1.  Initialize empty result list.
2.  Iterate through `nums`.
3.  Calculate index `idx = abs(num) - 1`.
4.  If `nums[idx] < 0`, add `idx + 1` to result.
5.  Else `nums[idx] = -nums[idx]`.

---
