# 496. Next Greater Element I / Phần Tử Lớn Tiếp Theo I

## Problem Description / Mô tả bài toán
The **next greater element** of some element `x` in an array is the **first greater** element that is **to the right** of `x` in the same array.
**Phần tử lớn tiếp theo** của một phần tử `x` trong mảng là phần tử **lớn hơn đầu tiên** nằm ở **bên phải** của `x` trong cùng một mảng.

You are given two **distinct 0-indexed** integer arrays `nums1` and `nums2`, where `nums1` is a subset of `nums2`.
Bạn được cho hai mảng số nguyên **không trùng lặp và được đánh chỉ số từ 0** là `nums1` và `nums2`, trong đó `nums1` là một tập con của `nums2`.

For each `0 <= i < nums1.length`, find the index `j` such that `nums1[i] == nums2[j]` and determine the next greater element of `nums2[j]` in `nums2`. If there is no next greater element, then the answer for this query is `-1`.
Với mỗi `0 <= i < nums1.length`, hãy tìm chỉ số `j` sao cho `nums1[i] == nums2[j]` và xác định phần tử lớn tiếp theo của `nums2[j]` trong `nums2`. Nếu không có phần tử lớn tiếp theo, kết quả là `-1`.

Return an array `ans` of length `nums1.length` such that `ans[i]` is the next greater element as described above.
Hãy trả về một mảng `ans` có độ dài bằng `nums1.length` sao cho `ans[i]` là phần tử lớn tiếp theo như mô tả ở trên.

### Example 1:
```text
Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
```

### Example 2:
```text
Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]
```

## Constraints / Ràng buộc
- `1 <= nums1.length <= nums2.length <= 1000`
- `0 <= nums1[i], nums2[i] <= 10^4`
- All integers in `nums1` and `nums2` are **unique**.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Monotonic Stack / Ngăn xếp Đơn điệu
We can pre-calculate the next greater element for ALL elements in `nums2` using a monotonic stack in $O(N)$ time.

Algorithm:
1. Create a `HashMap<Integer, Integer> map` to store the next greater element for each value in `nums2`.
2. Create a `Stack<Integer> stack` to maintain elements in decreasing order.
3. For each `num` in `nums2`:
   - While the stack is not empty and `num > stack.peek()`:
     - The next greater element for `stack.pop()` is `num`. Store this in `map.put(popped, num)`.
   - Push `num` onto the stack.
4. For any elements remaining in the stack, they don't have a next greater element (default to -1).
5. Build the result for `nums1` by looking up each value in the `map`.

### Complexity / Độ phức tạp
- **Time**: O(N + M) where N is `nums2` length and M is `nums1` length.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Monotonic Stack with Hash Mapping

**Algorithm**:
1.  Iterate through `nums2`.
2.  Maintain decreasing stack.
3.  Pop and map when a larger number is found.
4.  Construct result from map.

---
