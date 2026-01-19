# 238. Product of Array Except Self / Tích của Mảng Ngoại Trừ Chính Nó

## Problem Description / Mô tả bài toán
Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`.
Cho một mảng số nguyên `nums`, hãy trả về một mảng `answer` sao cho `answer[i]` bằng tích của tất cả các phần tử của `nums` ngoại trừ `nums[i]`.

The product of any prefix or suffix of `nums` is **guaranteed** to fit in a **32-bit** integer.
Tích của bất kỳ tiền tố hoặc hậu tố nào của `nums` được **đảm bảo** nằm gọn trong một số nguyên **32-bit**.

You must write an algorithm that runs in `O(n)` time and without using the division operation.
Bạn phải viết một thuật toán chạy trong thời gian `O(n)` và không sử dụng phép chia.

### Example 1:
```text
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
```

### Example 2:
```text
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
```

## Constraints / Ràng buộc
- `2 <= nums.length <= 10^5`
- `-30 <= nums[i] <= 30`
- The product of any prefix or suffix of `nums` is guaranteed to fit in a **32-bit** integer.

**Follow up**: Can you solve the problem in `O(1)` extra space complexity? (The output array does not count as extra space for space complexity analysis.)

---

## Theoretical Foundation / Cơ sở lý thuyết

### Prefix and Suffix Products / Tích Tiền Tố và Hậu Tố
Since we cannot use division (which would allow computing Total Product / `nums[i]`), we need to construct the result from two parts:
1.  **Left Product**: Product of all elements to the left of `i`.
2.  **Right Product**: Product of all elements to the right of `i`.

`result[i] = Left[i] * Right[i]`

**Space Optimization**:
- Store `Left[i]` directly in the `result` array.
- Iterate backwards to compute `Right` on the fly and multiply it into `result[i]`.

---

## Analysis / Phân tích

### Approach: Two-Pass (Prefix then Suffix)

**Algorithm**:
1.  Initialize `result` array.
2.  **Pass 1 (Left to Right)**:
    - `result[0] = 1`.
    - `result[i] = result[i-1] * nums[i-1]`.
    - After this pass, `result[i]` contains the product of elements `0` to `i-1`.
3.  **Pass 2 (Right to Left)**:
    - Initialize `R = 1` (accumulated right product).
    - Loop `i` from `n-1` down to `0`.
    - `result[i] = result[i] * R`.
    - `R = R * nums[i]`.

### Complexity / Độ phức tạp
- **Time**: O(N) - Two passes.
- **Space**: O(1) - Auxiliary space (ignoring output).

---

## Edge Cases / Các trường hợp biên
1.  **Zeroes in array**:
    - One zero: All products are 0 except the one at the zero's index.
    - Two or more zeroes: All products are 0.
    - The logic naturally handles zeroes without special cases (unlike the division method which would crash or require careful tracking of zero count).
2.  **Negative numbers**: Product rule applies correctly.
