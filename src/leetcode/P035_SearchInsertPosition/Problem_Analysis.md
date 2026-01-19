# 35. Search Insert Position / Tìm Vị Trí Chèn

## Problem Description / Mô tả bài toán
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
Cho một mảng các số nguyên khác nhau đã được sắp xếp và một giá trị đích, hãy trả về chỉ số nếu tìm thấy đích. Nếu không, hãy trả về chỉ số mà nó sẽ ở đó nếu được chèn theo thứ tự.

You must write an algorithm with `O(log n)` runtime complexity.
Bạn phải viết một thuật toán với độ phức tạp thời gian `O(log n)`.

### Example 1:
```text
Input: nums = [1,3,5,6], target = 5
Output: 2
```

### Example 2:
```text
Input: nums = [1,3,5,6], target = 2
Output: 1
```

### Example 3:
```text
Input: nums = [1,3,5,6], target = 7
Output: 4
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 10^4`
- `-10^4 <= nums[i] <= 10^4`
- `nums` contains **distinct** values sorted in **ascending** order.
- `-10^4 <= target <= 10^4`

---

## Analysis / Phân tích

### Approach: Binary Search / Tìm Kiếm Nhị Phân
- **Idea**: Standard binary search. The condition `lo <= hi` is used.
- **Ý tưởng**: Tìm kiếm nhị phân chuẩn. Điều kiện `lo <= hi` được sử dụng.
    - If `nums[mid] == target`, return `mid`.
    - If `nums[mid] < target`, `lo = mid + 1`.
    - If `nums[mid] > target`, `hi = mid - 1`.
- **Conclusion**: If the loop finishes without finding the target, `lo` will be the correct insertion position. This is because `lo` ends up pointing to the first element greater than `target`, or `length` if all are smaller.
- **Time Complexity**: O(log n).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Target smaller than all**: Returns 0.
2.  **Target larger than all**: Returns `n`.
3.  **Empty Array**: Not possible by constraint (len >= 1).
