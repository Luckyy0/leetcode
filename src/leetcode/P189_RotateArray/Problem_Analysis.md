# 189. Rotate Array / Xoay Mảng

## Problem Description / Mô tả bài toán
Given an integer array `nums`, rotate the array to the right by `k` steps, where `k` is non-negative.
Cho một mảng số nguyên `nums`, hãy xoay mảng sang phải `k` bước, trong đó `k` không âm.

### Example 1:
```text
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
```

### Example 2:
```text
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 10^5`
- `-2^31 <= nums[i] <= 2^31 - 1`
- `0 <= k <= 10^5`

**Follow up**:
- Try to come up with as many solutions as you can. There are at least **three** different ways to solve this problem.
- Could you do it **in-place** with `O(1)` extra space?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Array Reversal Strategy / Chiến lược Đảo ngược Mảng
This is a clever O(1) space trick to rotate an array:
Đây là một mẹo nhỏ với không gian O(1) để xoay một mảng:
1.  **Reverse the entire array**.
2.  **Reverse the first `k` elements**.
3.  **Reverse the remaining `n - k` elements**.

*Example for `[1,2,3,4,5,6,7], k=3`:*
1.  Reverse all: `[7,6,5,4,3,2,1]`
2.  Reverse first 3: `[5,6,7, 4,3,2,1]`
3.  Reverse rest: `[5,6,7, 1,2,3,4]` → Result!

---

## Analysis / Phân tích

### Approach: Triple Reversal (In-place)

**Algorithm**:
1.  `k = k % n` (handle cases where `k > n`).
2.  Reverse `0` to `n - 1`.
3.  Reverse `0` to `k - 1`.
4.  Reverse `k` to `n - 1`.

**Complexity / Độ phức tạp**:
- **Time**: O(N) - we visit each element twice.
- **Space**: O(1) - in-place rotation.

---

## Edge Cases / Các trường hợp biên
1.  **k = 0**: Array remains same.
2.  **k % n = 0**: Array remains same.
3.  **k > n**: Handled by modulo.
4.  **n = 1**: Array remains same.
