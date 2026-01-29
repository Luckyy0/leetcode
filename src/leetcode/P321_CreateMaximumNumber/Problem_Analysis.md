# 321. Create Maximum Number / Tạo Số Lớn Nhất

## Problem Description / Mô tả bài toán
You are given two integer arrays `nums1` and `nums2` of lengths `m` and `n` respectively. `nums1` and `nums2` represent the digits of two numbers. You are also given an integer `k`.
Bạn được cung cấp hai mảng số nguyên `nums1` và `nums2` có độ dài lần lượt là `m` và `n`.

Create the maximum number of length `k <= m + n` from digits of the two numbers. The relative order of the digits from the same array must be preserved.
Tạo số lớn nhất có độ dài `k` từ các chữ số của hai số. Thứ tự tương đối của các chữ số từ cùng một mảng phải được giữ nguyên.

Return an array of the `k` digits.
Trả về một mảng gồm `k` chữ số.

### Example 1:
```text
Input: nums1 = [3,4,6,5], nums2 = [9,1,2,5,8,3], k = 5
Output: [9,8,6,5,3]
```

### Example 2:
```text
Input: nums1 = [6,7], nums2 = [6,0,4], k = 5
Output: [6,7,6,0,4]
```

### Example 3:
```text
Input: nums1 = [3,9], nums2 = [8,9], k = 3
Output: [9,8,9]
```

## Constraints / Ràng buộc
- `m == nums1.length`
- `n == nums2.length`
- `1 <= m, n <= 1000`
- `1 <= k <= m + n`
- `0 <= nums1[i], nums2[i] <= 9`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Subproblems Decomposition / Phân Rã Bài Toán Con
We want to pick `i` digits from `nums1` and `(k - i)` digits from `nums2` such that when merged, they form the largest number.
1.  **Max Subsequence**: Find the largest subsequence of length `L` from an array `Arr`.
    - This can be solved using a **Monotonic Stack** (Greedy). Keep elements improving the sequence, maintain remaining count needed.
2.  **Merge**: Given two max subsequences, merge them to form the largest possible number.
    - Standard merge (compare `s1[i]` vs `s2[j]`).
    - **Crucial**: If `s1[i] == s2[j]`, we must look ahead to break ties properly. `compare(s1.substring(i), s2.substring(j))`.

**Algorithm**:
1.  Iterate `i` from `max(0, k - n)` to `min(k, m)`. (Must pick valid counts).
    - `len1 = i`, `len2 = k - i`.
2.  `sub1 = maxSubsequence(nums1, len1)`.
3.  `sub2 = maxSubsequence(nums2, len2)`.
4.  `candidate = merge(sub1, sub2)`.
5.  `maxNum = max(maxNum, candidate)` (Lexicographical max).
6.  Return `maxNum`.

### Complexity / Độ phức tạp
- **Max Subsequence**: O(N).
- **Merge**: O(K) * O(K) due to string compare lookahead in worst case (e.g. 9999 vs 9998).
- **Outer Loop**: K times.
- **Total**: O(K^3) or `O(K * (M+N + K^2))`. `M, N <= 1000`, `K <= 2000`. `K^3` is acceptable (10^9 is slightly high but average case much faster).

---

## Analysis / Phân tích

### Approach: Greedy + Stack + Merge

**Stack Logic**:
To get max subseq of length `L`:
- Traverse nums.
- While stack top < current and we have enough remaining items to fill `L`: pop.
- Push current.
- Truncate to `L`.

**Merge Logic**:
- Standard merge with lookahead.

---
