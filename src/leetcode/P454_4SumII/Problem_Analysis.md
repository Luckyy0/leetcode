# 454. 4Sum II / Tổng 4 Số II

## Problem Description / Mô tả bài toán
Given four integer arrays `nums1`, `nums2`, `nums3`, and `nums4` all of length `n`, return the number of tuples `(i, j, k, l)` such that:
Cho bốn mảng số nguyên `nums1`, `nums2`, `nums3`, và `nums4` đều có độ dài `n`, hãy trả về số lượng các bộ `(i, j, k, l)` sao cho:

- `0 <= i, j, k, l < n`
- `nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0`

### Example 1:
```text
Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
Output: 2
Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
```

### Example 2:
```text
Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
Output: 1
```

## Constraints / Ràng buộc
- `n == nums1.length == nums2.length == nums3.length == nums4.length`
- `1 <= n <= 200`
- `-2^28 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2^28`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Meet-in-the-middle (Hash Map) / Chia đôi để tính (Bảng băm)
A brute force approach would take $O(n^4)$, which is too slow ($200^4 = 1.6 \times 10^9$).
We can split the four arrays into two groups: `(nums1, nums2)` and `(nums3, nums4)`.

Algorithm:
1. Create a `HashMap` to store the sums of all pairs from `nums1` and `nums2`.
   - The key is the sum `nums1[i] + nums2[j]`.
   - The value is the frequency of that sum.
2. Iterate through all pairs from `nums3` and `nums4`:
   - Calculate their sum `currentSum = nums3[k] + nums4[l]`.
   - Check if the negation `-currentSum` exists in the `HashMap`.
   - If it does, add the frequency of `-currentSum` to the total count.
3. Return the total count.

### Complexity / Độ phức tạp
- **Time**: O(N^2) for the two pairs of nested loops.
- **Space**: O(N^2) to store the sums in the HashMap.

---

## Analysis / Phân tích

### Approach: Two-Group Hash Mapping

**Algorithm**:
1.  Map first two arrays' pairwise sums.
2.  Iterate second two arrays' pairwise sums.
3.  Match and accumulate.

---
