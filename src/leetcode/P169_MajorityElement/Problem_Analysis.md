# 169. Majority Element / Phần Tử Đa Số

## Problem Description / Mô tả bài toán
Given an array `nums` of size `n`, return the majority element.
Cho một mảng `nums` có kích thước `n`, hãy trả về phần tử đa số.

The majority element is the element that appears more than `⌊n / 2⌋` times. You may assume that the majority element always exists in the array.
Phần tử đa số là phần tử xuất hiện nhiều hơn `⌊n / 2⌋` lần. Bạn có thể giả định rằng phần tử đa số luôn tồn tại trong mảng.

### Example 1:
```text
Input: nums = [3,2,3]
Output: 3
```

### Example 2:
```text
Input: nums = [2,2,1,1,1,2,2]
Output: 2
```

## Constraints / Ràng buộc
- `n == nums.length`
- `1 <= n <= 5 * 10^4`
- `-10^9 <= nums[i] <= 10^9`

**Follow-up**: Could you solve the problem in linear time and in `O(1)` space?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Boyer-Moore Voting Algorithm / Thuật toán Bỏ phiếu Boyer-Moore
This is the optimal algorithm to find a majority element in O(1) space:
Đây là thuật toán tối ưu để tìm phần tử đa số trong không gian O(1):

**Logic**:
1.  Maintain a `candidate` and a `count`.
2.  Iterate through the array:
    - If `count == 0`, pick the current element as the `candidate`.
    - If the current element equals the `candidate`, increment `count`.
    - Otherwise, decrement `count`.
3.  The final `candidate` will be the majority element.

**Why it works?**
Since the majority element appears more than half the time, it will always "outvote" all other elements combined. Even if it gets cancelled out by other elements, its frequency is enough to survive until the end.

---

## Analysis / Phân tích

### Approach: Boyer-Moore Voting

**Complexity / Độ phức tạp**:
- **Time**: O(N) - single pass.
- **Space**: O(1) - two variables.

---

## Edge Cases / Các trường hợp biên
1.  **Single element array**: Returns the element.
2.  **Majority element at the start/end**: Handled by count logic.
3.  **Large numbers**: Handled by `int` comparison.
4.  **Alternating elements**: Boyer-Moore holds because majority > 50%.
5.  **Smallest majority**: (e.g., in size 3, appears 2 times).
6.  **Already sorted**: Handled correctly.
7.  **Worst case for count**: All other elements first, then majority (e.g., [1, 1, 2, 2, 2]). Correct.
