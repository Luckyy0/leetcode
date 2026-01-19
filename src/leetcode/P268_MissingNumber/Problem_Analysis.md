# 268. Missing Number / Số Bị Thiếu

## Problem Description / Mô tả bài toán
Given an array `nums` containing `n` distinct numbers in the range `[0, n]`, return the only number in the range that is missing from the array.
Cho một mảng `nums` chứa `n` số phân biệt nằm trong khoảng `[0, n]`, hãy trả về số duy nhất trong khoảng đó bị thiếu trong mảng.

### Example 1:
```text
Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
```

### Example 2:
```text
Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
```

## Constraints / Ràng buộc
- `n == nums.length`
- `1 <= n <= 10^4`
- `0 <= nums[i] <= n`
- All the numbers of `nums` are **unique**.

**Follow up**: Could you implement a solution using only `O(1)` extra space complexity and `O(n)` runtime complexity?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Mathematical Sum / Tổng Toán Học
The sum of numbers from `0` to `n` is `n * (n + 1) / 2`.
The missing number is simply `Total Sum - Array Sum`.

### XOR Approach / Tiếp Cận XOR
XORing all indices `[0, n]` and all values `nums[i]` will cancel out matching pairs. The remaining value is the missing number.
`missing = (0 ^ 1 ^ ... ^ n) ^ (nums[0] ^ ... ^ nums[n-1])`.

This approach avoids potential integer overflow with Sum (though `n <= 10^4` sum fits in int easily, but XOR is safer generally for very large N).

---

## Analysis / Phân tích

### Approach: XOR (O(1) Space, O(N) Time)

**Algorithm**:
1.  Initialize `missing = n`.
2.  Loop `i` from `0` to `n-1`:
    - `missing ^= i ^ nums[i]`.
3.  Return `missing`.

(Why init with `n`? Because loop covers indices `0` to `n-1`. We need to XOR `n` as well).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Missing 0**: `[1, 2, ... n]`. XOR works.
2.  **Missing n**: `[0, 1, ... n-1]`. XOR works.
