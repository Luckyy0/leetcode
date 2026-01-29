# 421. Maximum XOR of Two Numbers in an Array / XOR Lớn Nhất Của Hai Số Trong Mảng

## Problem Description / Mô tả bài toán
Given an integer array `nums`, return the maximum result of `nums[i] XOR nums[j]`, where `0 <= i <= j < n`.
Cho một mảng số nguyên `nums`, hãy trả về kết quả lớn nhất của phép toán `nums[i] XOR nums[j]`.

### Example 1:
```text
Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.
```

### Example 2:
```text
Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 2 * 10^5`
- `0 <= nums[i] <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Greedy Bit Manipulation / Tham lam trên Bit
To maximize XOR, we want the bits at higher positions to be `1` as much as possible.
We can determine the maximum result bit by bit, from the most significant bit (MSB) down to the least significant bit (LSB).

Algorithm:
1. Initialize `maxResult = 0`.
2. Iterate from bit `i = 30` down to `0`:
   - Identify the prefixes of all numbers up to the `i-th` bit.
   - Set a `candidate` by assuming the `i-th` bit of `maxResult` is `1`: `candidate = maxResult | (1 << i)`.
   - Put all current prefixes into a `HashSet`.
   - For each prefix `p`, check if `HashSet` contains `p ^ candidate`.
     - *Proof*: If `p1 ^ p2 == candidate`, then `p1 ^ candidate == p2`.
   - If such a pair exists, update `maxResult = candidate`.

### Complexity / Độ phức tạp
- **Time**: O(31 * N) = O(N).
- **Space**: O(N) for the HashSet.

---

## Analysis / Phân tích

### Approach: Greedy Prefix Set

**Algorithm**:
1.  Outer loop for bits.
2.  Set for prefixes.
3.  Target check.

---
