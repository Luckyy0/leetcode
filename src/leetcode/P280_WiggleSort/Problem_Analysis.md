# 280. Wiggle Sort / Sắp Xếp Lắc Lư

## Problem Description / Mô tả bài toán
Given an integer array `nums`, reorder it such that `nums[0] <= nums[1] >= nums[2] <= nums[3]...`.
Cho một mảng số nguyên `nums`, sắp xếp lại nó sao cho `nums[0] <= nums[1] >= nums[2] <= nums[3]...`.

You may assume the input array always has a valid answer.
Bạn có thể giả định rằng mảng đầu vào luôn có câu trả lời hợp lệ.

### Example 1:
```text
Input: nums = [3,5,2,1,6,4]
Output: [3,5,1,6,2,4]
Explanation: [1,6,2,5,3,4] is also accepted.
```

### Example 2:
```text
Input: nums = [6,6,5,6,3,8]
Output: [6,6,5,6,3,8]
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 5 * 10^4`
- `0 <= nums[i] <= 10^4`

**Follow up**: Could you do it without decoding it? (i.e., O(n) time).

---

## Theoretical Foundation / Cơ sở lý thuyết

### One Pass Swap / Trao Đổi Một Lần Quét
We examine overlapping pairs.
- Index 0: `nums[0] <= nums[1]`. If not, swap.
- Index 1: `nums[1] >= nums[2]`. If not, swap.
- Index 2: `nums[2] <= nums[3]`. If not, swap.

**Reasoning**:
- Suppose we are at index `i` (odd). We need `nums[i] >= nums[i+1]`.
- We just ensured `nums[i-1] <= nums[i]`.
- If `nums[i] < nums[i+1]`, we swap them.
    - New `nums[i]` is now the larger value.
    - Is `nums[i-1] <= new_nums[i]` still valid? Yes, because `new_nums[i] (was i+1) > old_nums[i] >= nums[i-1]`.
- Similar logic for even indices.
- Thus, a greedy swap works.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Greedy Swap

**Algorithm**:
1.  Loop `i` from 0 to `n-2`.
2.  If `i % 2 == 0`: Check `nums[i] <= nums[i+1]`. If not, swap.
3.  If `i % 2 == 1`: Check `nums[i] >= nums[i+1]`. If not, swap.

---

## Edge Cases / Các trường hợp biên
1.  **Duplicate elements**: Logic holds (equality is allowed `<=`).
