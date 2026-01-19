# 283. Move Zeroes / Di Chuyển Các Số Không

## Problem Description / Mô tả bài toán
Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.
Cho một mảng số nguyên `nums`, hãy di chuyển tất cả các số `0` về cuối mảng trong khi vẫn giữ nguyên thứ tự tương đối của các phần tử khác 0.

Note that you must do this in-place without making a copy of the array.
Lưu ý rằng bạn phải thực hiện việc này tại chỗ (in-place) mà không được tạo bản sao của mảng.

### Example 1:
```text
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
```

### Example 2:
```text
Input: nums = [0]
Output: [0]
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 10^4`
- `-2^31 <= nums[i] <= 2^31 - 1`

**Follow up**: Could you minimize the total number of operations?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Two Pointers (Snowball) / Hai Con Trỏ
We maintain a pointer `lastNonZeroFoundAt`.
Iterate through the array:
- If current element is non-zero, we swap it with the element at `lastNonZeroFoundAt` and increment `lastNonZeroFoundAt`.
- This effectively shifts non-zeros to the front. Zeros naturally accumulate ("snowball") after the `lastNonZeroFoundAt`.

**Optimized Swap**:
- Instead of generic swap, if `i == lastNonZeroFoundAt`, just increment index (no-op swap).
- Or: copy non-zeros to front, then fill remaining with 0. (Write count N + Fill Count M). This minimizes writes if mostly non-zeros.
- But swap approach is standard "in-place swap" logic.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Two Pointers (Swap)

**Algorithm**:
1.  `j = 0` (write pointer).
2.  Loop `i` from 0 to `N-1`:
    - If `nums[i] != 0`:
        - Swap `nums[j]` and `nums[i]`.
        - `j++`.

---

## Edge Cases / Các trường hợp biên
1.  **No zeros**: Loop runs, `i==j`, swaps with self.
2.  **All zeros**: `j` stays 0. No swaps.
