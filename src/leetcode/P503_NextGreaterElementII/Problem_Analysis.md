# 503. Next Greater Element II / Phần Tử Lớn Tiếp Theo II

## Problem Description / Mô tả bài toán
Given a circular integer array `nums` (i.e., the next element of `nums[nums.length - 1]` is `nums[0]`), return the **next greater number** for every element in `nums`.
Cho một mảng số nguyên xoay vòng `nums` (tức là phần tử tiếp theo của `nums[nums.length - 1]` là `nums[0]`), hãy trả về **phần tử lớn tiếp theo** cho mọi phần tử trong `nums`.

The **next greater number** of a number `x` is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return `-1` for this number.
**Phần tử lớn tiếp theo** của một số `x` là phần tử lớn hơn đầu tiên theo thứ tự duyệt trong mảng, nghĩa là bạn có thể tìm kiếm theo vòng tròn. Nếu nó không tồn tại, hãy trả về `-1`.

### Example 1:
```text
Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
```

### Example 2:
```text
Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 10^4`
- `-10^9 <= nums[i] <= 10^9`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Monotonic Stack with Virtual Concatenation / Ngăn xếp Đơn điệu với Liên kết ảo
To handle the circular property, we can imagine traversing the array **twice** (`0` to `2N-1`).
A monotonic stack can then be used to find the next greater element.

Algorithm:
1. Initialize a result array `res` filled with -1.
2. Initialize a stack to store the **indices** of elements.
3. Iterate `i` from 0 to `2N - 1`:
   - Use `index = i % N` to access the elements circularly.
   - While the stack is not empty and `nums[index] > nums[stack.peek()]`:
     - The next greater element for `stack.pop()` is `nums[index]`.
     - `res[poppedIndex] = nums[index]`.
   - If `i < N`, push `index` onto the stack (we only need to find results for the first N elements).
4. Return `res`.

### Complexity / Độ phức tạp
- **Time**: O(N) as each index is pushed and popped at most once.
- **Space**: O(N) for the stack.

---

## Analysis / Phân tích

### Approach: 2x Iteration Monotonic Stack

**Algorithm**:
1.  Initialize stack and result array.
2.  Loop $2 \times N$ times.
3.  Pop stack when `nums[curr] > nums[stack.peek()]`.
4.  Update result with `nums[curr]`.

---
