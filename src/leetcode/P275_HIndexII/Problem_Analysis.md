# 275. H-Index II / Chỉ Số H II

## Problem Description / Mô tả bài toán
Given an array of integers `citations` where `citations[i]` is the number of citations a researcher received for their `i-th` paper and `citations` is **sorted in ascending order**, return the researcher's h-index.
Cho một mảng các số nguyên `citations` trong đó `citations[i]` là số lượng trích dẫn mà một nhà nghiên cứu nhận được cho bài báo thứ `i` của họ và `citations` được **sắp xếp theo thứ tự tăng dần**, hãy trả về chỉ số h của nhà nghiên cứu đó.

You must write an algorithm that runs in logarithmic time.
Bạn phải viết một thuật toán chạy trong thời gian logarit.

### Example 1:
```text
Input: citations = [0,1,3,5,6]
Output: 3
Explanation: [0,1,3,5,6] means the researcher has 5 papers in total...
```

### Example 2:
```text
Input: citations = [1,2,100]
Output: 2
```

## Constraints / Ràng buộc
- `n == citations.length`
- `1 <= n <= 10^5`
- `0 <= citations[i] <= 1000`
- `citations` is sorted in ascending order.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Binary Search / Tìm Kiếm Nhị Phân
The array is sorted. `0, 1, 3, 5, 6`.
If we pick an index `i`, then number of papers with count `>= citations[i]` is `n - i`.
However, we don't necessarily need `citations[i] == n - i`.
We need the largest `h` such that `count >= h` and `vals >= h`.
Actually, consider the condition: At index `i`, there are `n - i` papers with value `>= citations[i]`.
If `citations[i] >= n - i`, it means we have at least `n - i` papers with `n - i` citations (since `citations[i] >= n-i`). This makes `h = n - i` a valid candidate.
Since the array is increasing, moving left (smaller `i`) increases `n - i` but decreases `citations[i]`. Moving right decreases `n - i`.
We want the **largest** `n - i` such that `citations[i] >= n - i`.
This means finding the **smallest** `i` (leftmost) such that `citations[i] >= n - i`.

**Algorithm**:
1.  `low = 0`, `high = n - 1`.
2.  `ans = 0`.
3.  While `low <= high`:
    - `mid = low + (high - low) / 2`.
    - `count = n - mid`.
    - If `citations[mid] >= count`:
        - Current index satisfies condition. We have `count` papers with enough citations.
        - Try to find a larger `count` by moving left (smaller `mid` -> larger `n - mid`).
        - `high = mid - 1`.
        - Record `count` as potential answer? Actually if we move left and find another valid index, result will be larger.
    - Else (`citations[mid] < count`):
        - Values are too small for this count. Need to reduce count (move right).
        - `low = mid + 1`.
4.  Return `n - low`. Or calculate carefully.
    - If `citations[mid] >= n - mid`, we store `n - mid` and move left.
    - Correct logic: The answer is `n - low`. Because `low` is the first index where `citations[low] >= n - low`.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Binary Search

**Example**: `[0, 1, 3, 5, 6]`, N=5.
- `L=0, R=4`. `mid=2` (val 3). `count=3`. `3 >= 3`. Valid. `high=1`. `ans=3`?
- `L=0, R=1`. `mid=0` (val 0). `count=5`. `0 < 5`. `low=1`.
- `L=1, R=1`. `mid=1` (val 1). `count=4`. `1 < 4`. `low=2`.
- `L=2, R=1`. Stop. Result `N - L = 5 - 2 = 3`. Matches.

---

## Edge Cases / Các trường hợp biên
1.  **[0]**: L=0, R=0. M=0. 0 < 1. L=1. Res 1-1=0.
2.  **[1]**: L=0, R=0. M=0. 1 >= 1. R=-1. L=0. Res 1-0=1.
3.  **[100]**: L=0, R=0. M=0. 100 >= 1. R=-1. Res 1.
