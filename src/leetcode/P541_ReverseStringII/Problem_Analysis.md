# 541. Reverse String II / Đảo Ngược Chuỗi II

## Problem Description / Mô tả bài toán
Given a string `s` and an integer `k`, reverse the first `k` characters for every `2k` characters counting from the start of the string.
Cho một chuỗi `s` và một số nguyên `k`, hãy đảo ngược `k` ký tự đầu tiên cho mỗi `2k` ký tự tính từ đầu chuỗi.

If there are fewer than `k` characters left, reverse all of them. If there are less than `2k` but greater than or equal to `k` characters, then reverse the first `k` characters and leave the other as original.
Nếu còn ít hơn `k` ký tự, hãy đảo ngược tất cả chúng. Nếu có ít hơn `2k` nhưng lớn hơn hoặc bằng `k` ký tự, hãy đảo ngược `k` ký tự đầu tiên và giữ nguyên phần còn lại.

### Example 1:
```text
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
```

## Constraints / Ràng buộc
- `1 <= s.length <= 10^4`
- `1 <= k <= 10^4`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Iterative Swapping / Hoán đổi Lặp lại
We process the string in chunks of size `2k`.

Algorithm:
1. Convert string to char array.
2. Iterate `i` from `0` to length step `2k`.
3. For each `i`, define the sub-range to start at `i` and end at `min(i + k - 1, length - 1)`.
4. Reverse characters in this range.
5. Convert array back to string.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) for char array.

---

## Analysis / Phân tích

### Approach: Chunk-based Reversal

**Algorithm**:
1.  Iterate with step 2k.
2.  Identify reversal window [i, i+k-1].
3.  Perform in-place Swap.
4.  Handle boundary conditions.

---
