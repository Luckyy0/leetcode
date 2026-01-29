# 370. Range Addition / Cộng Theo Phạm Vi

## Problem Description / Mô tả bài toán
You are given an integer `length` and an array `updates` where `updates[i] = [start_i, end_i, inc_i]`.
Bạn được cho số nguyên `length` và mảng `updates`.

You have an array `arr` of length `length` initialized to all `0`. For each `updates[i]`, you should increment all the elements `arr[start_i], arr[start_i + 1], ..., arr[end_i]` by `inc_i`.
Trả về `arr` sau khi áp dụng tất cả các bản cập nhật.

Return `arr` after applying all `updates`.

### Example 1:
```text
Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
Output: [-2,0,3,5,3]
Explanation:
Initial state:
[0, 0, 0, 0, 0]
After updates[0] = [1, 3, 2]:
[0, 2, 2, 2, 0]
After updates[1] = [2, 4, 3]:
[0, 2, 5, 5, 3]
After updates[2] = [0, 2, -2]:
[-2, 0, 3, 5, 3]
```

## Constraints / Ràng buộc
- `1 <= length <= 10^5`
- `0 <= updates.length <= 10^4`
- `0 <= start_i <= end_i < length`
- `-1000 <= inc_i <= 1000`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Difference Array / Mảng Hiệu
Instead of updating `arr[start...end]` in O(N), we can update endpoints in O(1).
Concept:
- `diff[i] = arr[i] - arr[i-1]`.
- To increment `arr[start...end]` by `val`:
    - `diff[start] += val`.
    - `diff[end + 1] -= val`.
- After processing all updates, compute prefix sums of `diff` to retrieve `arr`.
    - `arr[i] = arr[i-1] + diff[i]`. (Since `arr[-1]` is 0).

### Complexity / Độ phức tạp
- **Time**: O(K + N) where K is number of updates, N is length.
- **Space**: O(N) for the array.

---

## Analysis / Phân tích

### Approach: Difference Array

**Algorithm**:
1.  `res` array size `length`.
2.  Loop update `[s, e, val]`:
    - `res[s] += val`.
    - if `e + 1 < length`: `res[e + 1] -= val`.
3.  Loop `i` from 1 to `length - 1`:
    - `res[i] += res[i - 1]`.
4.  Return `res`.

---
