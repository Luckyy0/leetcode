# 349. Intersection of Two Arrays / Giao Của Hai Mảng

## Problem Description / Mô tả bài toán
Given two integer arrays `nums1` and `nums2`, return an array of their intersection. Each element in the result must be **unique** and you may return the result in **any order**.
Cho hai mảng số nguyên `nums1` và `nums2`, trả về một mảng là giao điểm của chúng. Mỗi phần tử trong kết quả phải là **duy nhất** và bạn có thể trả về kết quả theo **bất kỳ thứ tự nào**.

### Example 1:
```text
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
```

### Example 2:
```text
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
```

## Constraints / Ràng buộc
- `1 <= nums1.length, nums2.length <= 1000`
- `0 <= nums1[i], nums2[i] <= 1000`

---

## Theoretical Foundation / Cơ sở lý thuyết

### HashSet / Tập Hợp
1.  Put `nums1` into a Set `set1` (removes duplicates).
2.  Iterate `nums2`. If element exists in `set1`:
    - Add to result set (to ensure result uniqueness if `nums2` has duplicates) OR simply check if it's in `set1`, add to result list, and remove from `set1` to prevent future addition.
3.  Convert result to array.

### Complexity / Độ phức tạp
- **Time**: O(N + M).
- **Space**: O(N + M) or O(min(N, M)) depending on implementation.

---

## Analysis / Phân tích

### Approach: Two Sets

**Algorithm**:
1.  `set1` from `nums1`.
2.  `intersection` set.
3.  Loop `n` in `nums2`: if `set1` contains `n`, `intersection.add(n)`.
4.  Convert `intersection` to array.

---
