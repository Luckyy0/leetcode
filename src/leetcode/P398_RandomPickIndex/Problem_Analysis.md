# 398. Random Pick Index / Lấy Chỉ Mục Ngẫu Nhiên

## Problem Description / Mô tả bài toán
Given an integer array `nums` with possible duplicates, randomly output the index of a given `target` number. You can assume that the given target number must exist in the array.
Cho một mảng số nguyên `nums` có khả năng trùng lặp, hãy xuất ngẫu nhiên chỉ mục của một số `target` đã cho. Bạn có thể giả định rằng số mục tiêu cho trước phải tồn tại trong mảng.

Implement the `Solution` class:
- `Solution(int[] nums)` Initializes the object with the array `nums`.
- `int pick(int target)` Picks a random index `i` from `nums` such that `nums[i] == target`. Each index should have the equal probability of being returned.

### Example 1:
```text
Input
["Solution", "pick", "pick", "pick"]
[[[1, 2, 3, 3, 3]], [3], [1], [3]]
Output
[null, 4, 0, 2]

Explanation
Solution solution = new Solution([1, 2, 3, 3, 3]);
solution.pick(3); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(1); // It should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(3); // It should return either 2, 3, or 4 randomly with equal probability.
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 2 * 10^4`
- `-2^31 <= nums[i] <= 2^31 - 1`
- `target` is guaranteed to be in `nums`.
- At most `10^4` calls will be made to `pick`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Reservoir Sampling / Lấy mẫu hồ chứa
Similar to problem 382. When we iterate through the array, if we find an element equal to `target`, we decide whether to pick its index.
For the `k`-th occurrence of `target` found, we pick its index with probability `1/k`.

### Pre-processing with HashMap
Store `Map<Integer, List<Integer>>` where key is value and value is list of indices.
This is faster if there are many `pick` calls on the same static array.

Given the constraints (2*10^4 elements, 10^4 pick calls), Reservoir Sampling is acceptable for O(1) space if we store `nums`.
However, `10^4` pick calls with O(2*10^4) each is `2 * 10^8` operations. Borderline on time limits.
But usually, LeetCode allows Reservoir Sampling for this problem.
I will use Reservoir Sampling to minimize memory overhead.

### Complexity / Độ phức tạp
- **Time**: O(N) per `pick` call.
- **Space**: O(N) to store the original `nums` array.

---

## Analysis / Phân tích

### Approach: Reservoir Sampling

**Algorithm**:
1.  Store `nums`.
2.  `pick(target)`:
    - `count = 0`. `result = -1`.
    - Loop `i` from 0 to `nums.length - 1`:
        - If `nums[i] == target`:
            - `count++`.
            - `if (rand.nextInt(count) == 0)`: `result = i`.
    - Return `result`.

---
