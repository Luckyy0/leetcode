# 300. Longest Increasing Subsequence / Chuỗi Con Tăng Dài Nhất

## Problem Description / Mô tả bài toán
Given an integer array `nums`, return the length of the longest strictly increasing subsequence.
Cho một mảng số nguyên `nums`, hãy trả về độ dài của chuỗi con tăng nghiêm ngặt dài nhất.

A **subsequence** is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.
Một **chuỗi con** là một chuỗi có thể được tạo ra từ một mảng bằng cách xóa một số hoặc không phần tử nào mà không thay đổi thứ tự của các phần tử còn lại.

### Example 1:
```text
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
```

### Example 2:
```text
Input: nums = [0,1,0,3,2,3]
Output: 4
```

### Example 3:
```text
Input: nums = [7,7,7,7,7,7,7]
Output: 1
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 2500`
- `-10^4 <= nums[i] <= 10^4`

**Follow up**: Can you come up with an algorithm that runs in `O(n log(n))` time complexity?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Dynamic Programming (O(N^2)) / Quy Hoạch Động
`dp[i]` = length of LIS ending at index `i`.
`dp[i] = 1 + max(dp[j])` for all `0 <= j < i` where `nums[j] < nums[i]`.
Max result is max of all `dp[i]`.

### Patience Sorting (Binary Search) (O(N log N)) / Sắp Xếp Kiên Nhẫn
We maintain an array `tails` where `tails[i]` stores the **smallest tail** of all increasing subsequences of length `i+1` found so far.
- Why? To make a subsequence of length `k` extendable, we want its ending value to be as small as possible.
- Iterate `x` in `nums`:
    - If `x > tails[last]`: append `x`. (Extends the longest found subsequence).
    - Else: find the smallest element in `tails` that is `>= x` and replace it with `x`. (Updates a shorter/equal subsequence to have a smaller tail, improving potential for future extension).
    - This update uses Binary Search because `tails` is always sorted.

**Algorithm**:
1.  `tails` array size N. `size = 0`.
2.  Loop `x : nums`:
    - Binary search `target = x` in `tails[0...size-1]`.
    - If `x` not found, insertion point is returned.
    - If insertion point `== size`, `tails[size++] = x`.
    - Else `tails[index] = x`. (Replace).
3.  Return `size`.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Binary Search (Patience Sort)

**Algorithm**:
1.  `tails` list.
2.  Loop nums.
3.  BinarySearch for insertion point.

---
