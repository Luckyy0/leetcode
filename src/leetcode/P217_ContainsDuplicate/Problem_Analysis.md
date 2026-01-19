# 217. Contains Duplicate / Chứa Phần Tử Trùng Lặp

## Problem Description / Mô tả bài toán
Given an integer array `nums`, return `true` if any value appears **at least twice** in the array, and return `false` if every element is distinct.
Cho một mảng số nguyên `nums`, hãy trả về `true` nếu bất kỳ giá trị nào xuất hiện **ít nhất hai lần** trong mảng, và trả về `false` nếu mọi phần tử đều khác biệt.

### Example 1:
```text
Input: nums = [1,2,3,1]
Output: true
```

### Example 2:
```text
Input: nums = [1,2,3,4]
Output: false
```

### Example 3:
```text
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Hashing / Băm
The most efficient way to check for existence is using a Hash Set.
Cách hiệu quả nhất để kiểm tra sự tồn tại là sử dụng Hash Set.

1.  Iterate through each number `x` in `nums`.
2.  If `x` is already in the `HashSet`, return `true`.
3.  Add `x` to the `HashSet`.
4.  If loop finishes, return `false`.

### Sorting / Sắp xếp
Alternatively, sort the array (O(N log N)) and check adjacent elements. If `nums[i] == nums[i+1]`, return `true`. This uses O(1) extra space (ignoring sort stack).

---

## Analysis / Phân tích

### Approach: HashSet

**Complexity / Độ phức tạp**:
- **Time**: O(N) - Average case for HashSet operations is O(1).
- **Space**: O(N) - To store unique elements.

---

## Edge Cases / Các trường hợp biên
1.  **Empty array**: False (though constraint length >= 1).
2.  **Single element**: False.
3.  **Large range of values**: HashSet handles this well.
