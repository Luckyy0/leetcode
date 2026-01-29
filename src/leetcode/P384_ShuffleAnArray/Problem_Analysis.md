# 384. Shuffle an Array / Xáo Trộn Mảng

## Problem Description / Mô tả bài toán
Given an integer array `nums`, design an algorithm to randomly shuffle the array. All permutations of the array should be **equally likely** as a result of the shuffling.
Cho một mảng số nguyên `nums`, thiết kế một thuật toán để xáo trộn mảng ngẫu nhiên.

Implement the `Solution` class:
- `Solution(int[] nums)` Initializes the object with the integer array `nums`.
- `int[] reset()` Resets the array to its original configuration and returns it.
- `int[] shuffle()` Returns a random shuffling of the array.

### Example 1:
```text
Input
["Solution", "shuffle", "reset", "shuffle"]
[[[1, 2, 3]], [], [], []]
Output
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
                       // Any permutation of [1,2,3] must be equally likely to be returned.
                       // Example: return [3, 1, 2]
solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 50`
- `-10^6 <= nums[i] <= 10^6`
- All the elements of `nums` are **unique**.
- At most `10^4` calls in total will be made to `reset` and `shuffle`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Fisher-Yates Shuffle / Thuật Toán Fisher-Yates
To shuffle an array of size N uniformly:
- Iterate `i` from `0` to `n-1` (or `n-1` down to `0`).
- Pick a random index `j` in range `[i, n-1]` (or `[0, i]`).
- Swap `nums[i]` and `nums[j]`.
Proof:
- Item at index 0 has probability `1/N` of staying/swapping to any position.
- Item at index 1 has `(N-1)/N * 1/(N-1) = 1/N` chance ...

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) (Storage of original).

---

## Analysis / Phân tích

### Approach: Fisher-Yates

**Algorithm**:
1.  Store `original` array (clone).
2.  `array` used for shuffling.
3.  `reset()`: return copy of `original` (and reset internal state? Or just reset internal array to match original).
    - `array = original.clone()`.
4.  `shuffle()`:
    - Loop `i` from 0 to N-1.
    - `j = rand.nextInt(i + 1)`. Wait.
    - Standard Fisher Yates: `for (i = n-1; i > 0; i--) j = rand(i+1)`. Range 0..i.
    - Or `for (i = 0; i < n; i++) j = rand(i, n)`. Range i..n.
    - Using `rand.nextInt(n - i) + i`.

---
