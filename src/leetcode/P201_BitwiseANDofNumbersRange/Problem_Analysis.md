# 201. Bitwise AND of Numbers Range / Phép AND Bit của Dãy Số

## Problem Description / Mô tả bài toán
Given two integers `left` and `right` that represent the range `[left, right]`, return the bitwise AND of all numbers in this range, inclusive.
Cho hai số nguyên `left` và `right` đại diện cho phạm vi `[left, right]`, hãy trả về kết quả của phép AND bit của tất cả các số trong phạm vi này.

### Example 1:
```text
Input: left = 5, right = 7
Output: 4
```

### Example 2:
```text
Input: left = 0, right = 0
Output: 0
```

### Example 3:
```text
Input: left = 1, right = 2147483647
Output: 0
```

## Constraints / Ràng buộc
- `0 <= left <= right <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Common Prefix Property / Tính chất Tiền tố Chung
The bitwise AND of a range of numbers produces a result where the bits are set ONLY if they are set in ALL numbers within the range.
Phép AND bit của một dãy số tạo ra kết quả trong đó các bit chỉ được bật NẾU chúng được bật trong TẤT CẢ các số trong dãy.

Consider the binary representation of `left` and `right`.
If we increment a number from `left` to `right`, the lower bits flip frequently (0 -> 1 -> 0...).
Any bit position that flips at least once in the range `[left, right]` will result in a `0` in the final AND result.
Wait until `left` and `right` are equal implies we found the common prefix. The remaining bits (the suffix) will all be 0 because they have changed at least once.

*Example: 5 to 7*
`5: 1 0 1`
`6: 1 1 0`
`7: 1 1 1`
AND: `1 0 0` (4)
Common prefix is `1xx`.

---

## Analysis / Phân tích

### Approach: Bit Shift (Finding Common Prefix)

**Algorithm**:
1.  Shift both `left` and `right` to the right (`>> 1`) until `left == right`.
2.  Keep track of the number of shifts `shiftCount`.
3.  The result is `left << shiftCount` (restore the position of the common prefix).

**Why this works**: Shifting right removes the differing lower bits. When `left == right`, we have isolated the common most significant bits (prefix). The shifted-out bits are the ones that changed, so they contribute 0 to the AND sum.

### Complexity / Độ phức tạp
- **Time**: O(log N) - specifically O(32) since integers are 32-bit.
- **Space**: O(1) - constant space.

---

## Edge Cases / Các trường hợp biên
1.  **left == right**: Return `left`.
2.  **left = 0**: Result is always 0.
3.  **Large range**: Efficient because limited to 32 shifts.
