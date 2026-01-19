# 228. Summary Ranges / Tóm tắt Phạm vi

## Problem Description / Mô tả bài toán
You are given a **sorted unique** integer array `nums`.
Bạn được cung cấp một mảng số nguyên `nums` đã **sắp xếp và duy nhất**.

A **range** `[a,b]` is the set of all integers from `a` to `b` (inclusive).
Một **phạm vi** `[a,b]` là tập hợp tất cả các số nguyên từ `a` đến `b` (bao gồm cả `a` và `b`).

Return the **smallest sorted list of ranges** that cover all the numbers in the array exactly. That is, each element of `nums` is covered by exactly one of the ranges, and there is no integer `x` such that `x` is in one of the ranges but not in `nums`.
Hãy trả về **danh sách các phạm vi được sắp xếp nhỏ nhất** bao phủ chính xác tất cả các số trong mảng. Tức là, mỗi phần tử của `nums` được bao phủ bởi chính xác một trong các phạm vi, và không có số nguyên `x` nào sao cho `x` nằm trong một trong các phạm vi nhưng không nằm trong `nums`.

Each range `[a,b]` in the list should be output as:
- `"a->b"` if `a != b`
- `"a"` if `a == b`

### Example 1:
```text
Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
```

### Example 2:
```text
Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
```

## Constraints / Ràng buộc
- `0 <= nums.length <= 20`
- `-2^31 <= nums[i] <= 2^31 - 1`
- All the values of `nums` are unique.
- `nums` is sorted in ascending order.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Linear Scan with Range Tracking / Quét Tuyến Tính với Theo Dõi Phạm Vi
Iterate through the sorted array.
- Maintain a `start` of the current range.
- If `nums[i] == nums[i-1] + 1`, the current range extends.
- Else (gap detected), the previous range ended at `nums[i-1]`.
    - Format and add range `start` to `nums[i-1]`.
    - Start new range at `nums[i]`.
- Don't forget to add the last range.

### Complexity / Độ phức tạp
- **Time**: O(N) - One pass.
- **Space**: O(1) - Output list storage excludes auxiliary.

---

## Edge Cases / Các trường hợp biên
1.  **Empty array**: Return empty list.
2.  **Single element**: Return `["a"]`.
3.  **No consecutive**: `[1, 3, 5]` -> `["1", "3", "5"]`.
