# 219. Contains Duplicate II / Chứa Phần Tử Trùng Lặp II

## Problem Description / Mô tả bài toán
Given an integer array `nums` and an integer `k`, return `true` if there are two **distinct indices** `i` and `j` in the array such that `nums[i] == nums[j]` and `abs(i - j) <= k`.
Cho một mảng số nguyên `nums` và một số nguyên `k`, hãy trả về `true` nếu có hai **chỉ số khác nhau** `i` và `j` trong mảng sao cho `nums[i] == nums[j]` và `abs(i - j) <= k`.

### Example 1:
```text
Input: nums = [1,2,3,1], k = 3
Output: true
```

### Example 2:
```text
Input: nums = [1,0,1,1], k = 1
Output: true
```

### Example 3:
```text
Input: nums = [1,2,3,1,2,3], k = 2
Output: false
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`
- `0 <= k <= 10^5`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Sliding Window with HashSet / Cửa sổ trượt với HashSet
We maintain a window of size `k` (or `k + 1` elements essentially, looking back `k` spots).
Chúng ta duy trì một cửa sổ có kích thước `k` (hoặc thực chất là `k + 1` phần tử, nhìn lại `k` vị trí).

1.  Iterate through the array with index `i`.
2.  For each element `nums[i]`:
    - If `nums[i]` is already in the `HashSet`, it means we found a duplicate within the last `k` indices.
    - Add `nums[i]` to the `HashSet`.
    - If the size of the set grows larger than `k`, remove the element that falls out of the window (`nums[i - k]`).

### Complexity / Độ phức tạp
- **Time**: O(N) - doing add/remove/contains takes O(1) on average.
- **Space**: O(min(N, k)) - the set size never exceeds `k + 1`.

---

## Edge Cases / Các trường hợp biên
1.  **k = 0**: Should always return `false` (distinct indices requirement, `abs(i-j) <= 0` implies `i=j` which violates distinctness).
2.  **Empty array**: False.
3.  **Large k**: Set grows to size N.
