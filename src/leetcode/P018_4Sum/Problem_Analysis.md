# 18. 4Sum / Tổng Bốn Số

## Problem Description / Mô tả bài toán
Given an array `nums` of `n` integers, return an array of all the **unique** quadruplets `[nums[a], nums[b], nums[c], nums[d]]` such that:
Cho một mảng `nums` gồm `n` số nguyên, trả về một mảng gồm tất cả các bộ bốn **duy nhất** `[nums[a], nums[b], nums[c], nums[d]]` sao cho:

- `0 <= a, b, c, d < n`
- `a, b, c, and d` are distinct.
- `nums[a] + nums[b] + nums[c] + nums[d] == target`

You may return the answer in **any order**.
Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.

### Example 1:
```text
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
```

### Example 2:
```text
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 200`
- `-10^9 <= nums[i] <= 10^9`
- `-10^9 <= target <= 10^9`

---

## Analysis / Phân tích

### Approach: Sorting + k-Sum (Generalization) / Sắp xếp + Tổng k số (Tổng quát hóa)
- **Idea**: Since we solved 3Sum and 2Sum, 4Sum is just one more layer of loop.
- **Ý tưởng**: Vì chúng ta đã giải quyết 3Sum và 2Sum, 4Sum chỉ là thêm một lớp vòng lặp nữa.
    - **Base Case (2Sum)**: Use two pointers `left`, `right`.
    - **Recursive Step (kSum)**: Loop `i` from `start` to `len - k + 1`. Recursive call `kSum(k-1, target - nums[i])`.
- **Implementation**:
    - Sort `nums`.
    - `fourSum` calls `kSum(4, 0, target)`.
    - `kSum(k, start, target)`:
        - If `k == 2`, run two pointers.
        - Else, Loop `i`: recurse.
- **Pruning**:
    - `nums[i] * k > target`: Smallest elements sum exceeds target -> impossible.
    - `nums[len-1] * k < target`: Largest elements sum less than target -> impossible.
- **Time Complexity**: O(n^3). k=4 reduces to O(n^(k-1)).
- **Space Complexity**: O(n) for recursion stack and sorting.

---

## Edge Cases / Các trường hợp biên
1.  **Small Array**: `len < 4` -> `[]`.
2.  **Overflow**: `target` and `num` values can be large (10^9), sum of 4 can exceed `Integer.MAX_VALUE`. Need `long` for sum calculation.
3.  **Duplicates**: Handle skip logic carefully.
