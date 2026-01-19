# 260. Single Number III / Số Duy Nhất III

## Problem Description / Mô tả bài toán
Given an integer array `nums`, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in **any order**.
Cho một mảng số nguyên `nums`, trong đó chính xác hai phần tử chỉ xuất hiện một lần và tất cả các phần tử khác xuất hiện chính xác hai lần. Hãy tìm hai phần tử chỉ xuất hiện một lần. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
Bạn phải viết một thuật toán chạy với độ phức tạp thời gian tuyến tính và chỉ sử dụng không gian bổ sung hằng số.

### Example 1:
```text
Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.
```

### Example 2:
```text
Input: nums = [-1,0]
Output: [-1,0]
```

### Example 3:
```text
Input: nums = [0,1]
Output: [1,0]
```

## Constraints / Ràng buộc
- `2 <= nums.length <= 3 * 10^4`
- `-2^31 <= nums[i] <= 2^31 - 1`
- Each integer in `nums` will appear twice, only two integers will appear once.

---

## Theoretical Foundation / Cơ sở lý thuyết

### XOR Partitioning / Phân Vùng XOR
XOR property: `x ^ x = 0`, `x ^ 0 = x`.
If we XOR all numbers, duplicates cancel out.
`Total XOR = a ^ b` (where `a` and `b` are the two unique numbers).

Since `a != b`, `Total XOR` will have at least one bit set to 1.
This bit represents a position where `a` and `b` differ (one has 1, the other has 0).

**Strategy**:
1.  Calculate `diff = XOR(all nums)`.
2.  Find the rightmost set bit of `diff`: `bit = diff & -diff`.
3.  Iterate through `nums` and divide them into two groups based on whether `num & bit` is 0 or non-zero.
4.  XOR each group separately. One group yields `a`, the other yields `b` (duplicates within groups cancel).

---

## Analysis / Phân tích

### Approach: Bit Manipulation (XOR Grouping)

**Algorithm**:
1.  `xor = 0`. For num in nums: `xor ^= num`.
2.  `bit = xor & -xor` (Two's complement trick to isolate rightmost 1-bit).
    - Note: If `xor` is `Integer.MIN_VALUE`, `-xor` is also `MIN_VALUE`. Logic still holds.
3.  `num1 = 0`, `num2 = 0`.
4.  For num in nums:
    - If `(num & bit) == 0`: `num1 ^= num`.
    - Else: `num2 ^= num`.
5.  Return `[num1, num2]`.

### Complexity / Độ phức tạp
- **Time**: O(N) - Two passes.
- **Space**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Min Size**: 2 elements -> Both are unique.
2.  **Negatives**: Bitwise operations work on signed integers correctly in Java.
