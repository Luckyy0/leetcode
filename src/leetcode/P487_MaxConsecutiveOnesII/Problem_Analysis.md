# 487. Max Consecutive Ones II / Số Lượng Chữ Số 1 Liên Tiếp Tối Đa II

## Problem Description / Mô tả bài toán
Given a binary array `nums`, return the maximum number of consecutive `1`'s in the array if you can flip at most one `0`.
Cho một mảng nhị phân `nums`, hãy trả về số lượng tối đa các chữ số `1` liên tiếp trong mảng nếu bạn có thể lật tối đa một chữ số `0`.

### Example 1:
```text
Input: nums = [1,0,1,1,0]
Output: 4
Explanation: Flip the first 0 will get the maximum number of consecutive 1s (4).
```

### Example 2:
```text
Input: nums = [1,0,1,1,0,1]
Output: 4
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 10^5`
- `nums[i]` is either `0` or `1`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window / Cửa sổ trượt
We can maintain a sliding window `[left, right]` where the number of zeros is at most 1.

Algorithm:
1. Initialize `left = 0`, `zeros = 0`, `maxLen = 0`.
2. Iterate `right` from 0 to `n-1`:
   - If `nums[right] == 0`, increment `zeros`.
   - While `zeros > 1`:
     - If `nums[left] == 0`, decrement `zeros`.
     - Increment `left`.
   - `maxLen = max(maxLen, right - left + 1)`.
3. Return `maxLen`.

### Follow up:
What if the input is an infinite stream?
- We just need to store the index of the last zero seen.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Sliding Window with Zero Count

**Algorithm**:
1.  Expand `right` pointer.
2.  If `zeros > 1`, shrink `left`.
3.  Calculate window size.

---
