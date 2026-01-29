# 477. Total Hamming Distance / Tổng Khoảng Cách Hamming

## Problem Description / Mô tả bài toán
The **Hamming distance** between two integers is the number of positions at which the corresponding bits are different.
**Khoảng cách Hamming** giữa hai số nguyên là số lượng vị trí mà tại đó các bit tương ứng là khác nhau.

Given an integer array `nums`, return the sum of Hamming distances between all the pairs of the integers in `nums`.
Cho một mảng số nguyên `nums`, hãy trả về tổng các khoảng cách Hamming giữa tất cả các cặp số nguyên trong `nums`.

### Example 1:
```text
Input: nums = [4,14,2]
Output: 6
Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case).
The Hamming distances are:
HammingDistance(4, 14) = 2
HammingDistance(4, 2) = 2
HammingDistance(14, 2) = 2
Total = 2 + 2 + 2 = 6.
```

### Example 2:
```text
Input: nums = [4,14,4]
Output: 4
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 10^4`
- `0 <= nums[i] <= 10^9`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bit-by-Bit Counting / Đếm theo từng Bit
Comparing all pairs takes $O(N^2)$, which is $10^8$ operations. To optimize, we can calculate the contribution of each bit position independently.

Suppose for the `k-th` bit position, there are `m` numbers with bit `1` and `n-m` numbers with bit `0`.
Any pair consisting of one number with bit `1` and one number with bit `0` will contribute `1` to the total Hamming distance at this bit position.
The number of such pairs is `m * (n - m)`.

Algorithm:
1. Initialize `total = 0`.
2. For each bit position `k` from 0 to 31:
   - Count how many numbers in `nums` have the `k-th` bit set to `1`: `countOne`.
   - The number of zeros at this bit is `countZero = nums.length - countOne`.
   - Update `total += countOne * countZero`.
3. Return `total`.

### Complexity / Độ phức tạp
- **Time**: O(N * 32) = O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Positional Bit Summation

**Algorithm**:
1.  Outer loop: 0 to 31.
2.  Inner loop: iterate through `nums`.
3.  Calculate product of Ones and Zeros count.

---
