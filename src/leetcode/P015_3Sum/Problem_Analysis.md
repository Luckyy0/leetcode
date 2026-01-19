# 15. 3Sum / Tổng Ba Số

## Problem Description / Mô tả bài toán
Given an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.
Cho một mảng số nguyên `nums`, trả về tất cả các bộ ba `[nums[i], nums[j], nums[k]]` sao cho `i != j`, `i != k`, và `j != k`, và `nums[i] + nums[j] + nums[k] == 0`.

Notice that the solution set must not contain duplicate triplets.
Lưu ý rằng tập hợp kết quả không được chứa các bộ ba trùng lặp.

### Example 1:
```text
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
```

### Example 2:
```text
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet sums to 2.
```

### Example 3:
```text
Input: nums = [0,0,0]
Output: [[0,0,0]]
```

## Constraints / Ràng buộc
- `3 <= nums.length <= 3000`
- `-10^5 <= nums[i] <= 10^5`

---

## Analysis / Phân tích

### Approach 1: Brute Force / Vét cạn
- **Idea**: Three nested loops checking `nums[i] + nums[j] + nums[k] == 0`. Sort triplet and add to a Set to avoid duplicates.
- **Ý tưởng**: Ba vòng lặp lồng nhau kiểm tra `nums[i] + nums[j] + nums[k] == 0`. Sắp xếp bộ ba và thêm vào Set để tránh trùng lặp.
- **Time Complexity**: O(n^3). Too slow for n=3000.
- **Space Complexity**: O(n).

### Approach 2: Sorting + Two Pointers (Optimal) / Sắp xếp + Hai con trỏ (Tối ưu)
- **Idea**:
    1.  Sort the array.
    2.  Iterate `i` from 0 to n-2.
    3.  If `nums[i] > 0`, break (impossible to sum to 0 with remaining positive numbers).
    4.  Skip duplicate `i`: `if i > 0 && nums[i] == nums[i-1] continue`.
    5.  Use two pointers `lo = i + 1`, `hi = n - 1` to find pairs summing to `-nums[i]`.
    6.  If `sum == 0`:
        - Add triplet.
        - Skip duplicate `lo`: `while lo < hi && nums[lo] == nums[lo+1] lo++`.
        - Skip duplicate `hi`: `while lo < hi && nums[hi] == nums[hi-1] hi--`.
        - `lo++`, `hi--`.
    7.  If `sum < target`, `lo++`.
    8.  If `sum > target`, `hi--`.
- **Time Complexity**: O(n^2). Sorting takes O(n log n), loop takes O(n^2).
- **Space Complexity**: O(log n) or O(n) depending on sorting implementation.

---

## Edge Cases / Các trường hợp biên
1.  **No Solution**: `[1, 2, 3]` -> `[]`.
2.  **All Zeros**: `[0, 0, 0]` -> `[[0, 0, 0]]`.
3.  **Duplicates**: `[-1, -1, 0, 1]` -> `[[-1, 0, 1]]`.
