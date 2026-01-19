# 259. 3Sum Smaller / Tổng 3 Số Nhỏ Hơn

## Problem Description / Mô tả bài toán
Given an array of `n` integers `nums` and an integer `target`, find the number of index triplets `(i, j, k)` with `0 <= i < j < k < n` that satisfy the condition `nums[i] + nums[j] + nums[k] < target`.
Cho một mảng `n` số nguyên `nums` và một số nguyên `target`, tìm số lượng bộ ba chỉ số `(i, j, k)` với `0 <= i < j < k < n` thỏa mãn điều kiện `nums[i] + nums[j] + nums[k] < target`.

### Example 1:
```text
Input: nums = [-2,0,1,3], target = 2
Output: 2
Explanation: Because there are two triplets which sums are less than 2:
[-2,0,1]
[-2,0,3]
```

### Example 2:
```text
Input: nums = [], target = 0
Output: 0
```

### Example 3:
```text
Input: nums = [0], target = 0
Output: 0
```

## Constraints / Ràng buộc
- `n == nums.length`
- `0 <= n <= 3500`
- `-100 <= nums[i] <= 100`
- `-100 <= target <= 100`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Sort + Two Pointers / Sắp xếp + Hai Con Trỏ
This is a variation of the 3Sum problem (Target sum).
1.  **Sort the array**. sorting allows us to make decisions about ranges.
2.  Iterate `i` from `0` to `n-3`.
3.  Use two pointers `left = i + 1`, `right = n - 1`.
4.  Check `sum = nums[i] + nums[left] + nums[right]`.
    - If `sum < target`:
        - Because the array is sorted, if `nums[i] + nums[left] + nums[right] < target`, then replacing `nums[right]` with any smaller number (i.e., any element between `left` and `right`) will *also* result in a sum < target.
        - Therefore, all pairs `(left, x)` where `left < x <= right` are valid.
        - Determine count: `count += right - left`.
        - Move `left++` to try a larger sum.
    - If `sum >= target`:
        - We need a smaller sum. Move `right--`.

### Complexity / Độ phức tạp
- **Time**: O(N^2) - Sorting O(N log N) + Loop O(N) * Two Pointers O(N).
- **Space**: O(1) or O(log N) for sort.

---

## Analysis / Phân tích

### Approach: Two Pointers Optimal

**Algorithm**:
1.  Arrays.sort(nums).
2.  Count = 0.
3.  For `i` from 0 to `len-3`:
    - `left = i + 1`, `right = len - 1`.
    - While `left < right`:
        - If `nums[i] + nums[left] + nums[right] < target`:
            - `count += right - left`.
            - `left++`.
        - Else:
            - `right--`.
4.  Return count.

---

## Edge Cases / Các trường hợp biên
1.  **Size < 3**: 0.
2.  **Empty**: 0.
