# 350. Intersection of Two Arrays II / Giao Của Hai Mảng II

## Problem Description / Mô tả bài toán
Given two integer arrays `nums1` and `nums2`, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in **any order**.
Cho hai mảng số nguyên `nums1` và `nums2`, trả về một mảng là giao điểm của chúng. Mỗi phần tử trong kết quả phải xuất hiện số lần bằng số lần nó xuất hiện trong cả hai mảng

### Example 1:
```text
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
```

### Example 2:
```text
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
```

## Constraints / Ràng buộc
- `1 <= nums1.length, nums2.length <= 1000`
- `0 <= nums1[i], nums2[i] <= 1000`

**Follow up**:
- What if the given array is already sorted? How would you optimize your algorithm?
- What if `nums1`'s size is small compared to `nums2`'s size? Which algorithm is better?
- What if elements of `nums2` are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

---

## Theoretical Foundation / Cơ sở lý thuyết

### HashMap Counter / Bộ Đếm HashMap
1.  Count frequency of each element in `nums1` (or smaller array).
2.  Iterate `nums2`. If element exists in map and count > 0:
    - Add to result.
    - Decrement count in map.

### Sorting + Two Pointers / Sắp Xếp + Hai Con Trỏ
If arrays are sorted (Follow-up 1):
- Use two pointers `i, j`.
- If `n1[i] < n2[j]`: `i++`.
- If `n1[i] > n2[j]`: `j++`.
- If equal: Add to result, `i++`, `j++`.
Space O(1) if ignoring result.

I will implement the **HashMap** approach as it is generic O(N+M).

---

## Analysis / Phân tích

### Approach: HashMap

**Algorithm**:
1.  Map `count` for `nums1`.
2.  List `res`.
3.  Loop `nums2`: check and decrement.

---
