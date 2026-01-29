# 457. Circular Array Loop / Vòng Lặp Mảng Xoay Vòng

## Problem Description / Mô tả bài toán
You are playing a game involving a **circular** array of non-zero integers `nums`. Each `nums[i]` denotes the number of indices forward/backward you must move if you are at index `i`.
Bạn đang chơi một trò chơi liên quan đến một mảng **xoay vòng** gồm các số nguyên khác không `nums`. Mỗi `nums[i]` biểu thị số lượng chỉ số bạn phải di chuyển tiến/lùi nếu bạn đang ở chỉ số `i`.

A cycle in the array is a sequence of indices `indices` of length `k > 1` such that:
Một chu kỳ trong mảng là một dãy các chỉ số `indices` có độ dài `k > 1` sao cho:
- All `nums[i]` in the cycle must be **entirely positive** or **entirely negative**.
- The cycle begins and ends at the same index.

Return `true` if there is a cycle in `nums`, or `false` otherwise.
Trả về `true` nếu có một chu kỳ trong `nums`, ngược lại trả về `false`.

### Example 1:
```text
Input: nums = [2,-1,1,2,2]
Output: true
Explanation: The cycle is 0 -> 2 -> 3 -> 0.
```

### Example 2:
```text
Input: nums = [-1,2]
Output: false
Explanation: The cycle 1 -> 1 is invalid because its length is 1.
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 5000`
- `-1000 <= nums[i] <= 1000`
- `nums[i] != 0`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Fast and Slow Pointers (Cycle Detection) / Con trỏ nhanh và chậm (Phát hiện chu kỳ)
This problem can be solved using Floyd's Cycle-Finding Algorithm (Tortoise and Hare).

Algorithm:
1. For each starting index `i`:
   - Use two pointers: `slow` and `fast`, both starting at `i`.
   - In each step:
     - `slow` moves forward once.
     - `fast` moves forward twice.
   - To handle the circular property, the next index is `(curr + nums[curr]) % n`. (In Java, handle negative results by adding `n`: `((curr + nums[curr]) % n + n) % n`).
   - All elements in a cycle must have the same sign. If any element encountered by `fast` has a different sign from `nums[i]`, break.
   - If `slow == fast`:
     - Check if the cycle length is > 1. If `slow == getNext(slow)`, it's a self-loop (length 1), which is invalid.
     - If valid, return `true`.
2. Optimization: After processing index `i`, we can mark all nodes on its path as "visited" (e.g., by setting them to 0) to avoid re-calculating.

### Complexity / Độ phức tạp
- **Time**: O(N) because each node is visited at most a constant number of times.
- **Space**: O(1) (if we modify in-place) or O(N) if we use a separate visited set.

---

## Analysis / Phân tích

### Approach: Fast/Slow Pointers with Path Verification

**Algorithm**:
1.  Iterate through each index.
2.  Maintain sign consistency check.
3.  Detect cycle and verify length > 1.

---
