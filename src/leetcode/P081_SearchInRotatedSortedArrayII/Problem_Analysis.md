# 81. Search in Rotated Sorted Array II / Tìm Kiếm Trong Mảng Đã Sắp Xếp Xoay II

## Problem Description / Mô tả bài toán
There is an integer array `nums` sorted in non-decreasing order (not necessarily with **distinct** values).
Có một mảng số nguyên `nums` được sắp xếp theo thứ tự không giảm (không nhất thiết phải có các giá trị **khác nhau**).

Before being passed to your function, `nums` is **rotated** at an unknown pivot index `k` (`0 <= k < nums.length`) such that the resulting array is `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (0-indexed).
Trước khi được chuyển đến hàm của bạn, `nums` được **xoay** tại một chỉ số chốt `k` không xác định (`0 <= k < nums.length`) sao cho mảng kết quả là `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (chỉ số bắt đầu từ 0).

Given the array `nums` **after** the rotation and an integer `target`, return `true` if `target` is in `nums`, or `false` if it is not in `nums`.
Cho mảng `nums` **sau** khi xoay và một số nguyên `target`, trả về `true` nếu `target` có trong `nums`, hoặc `false` nếu nó không có trong `nums`.

You must decrease the overall operation steps as much as possible.
Bạn phải giảm bớt các bước thao tác tổng thể càng nhiều càng tốt.

### Example 1:
```text
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
```

### Example 2:
```text
Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 5000`
- `-10^4 <= nums[i] <= 10^4`
- `nums` is guaranteed to be rotated at some pivot.
- `-10^4 <= target <= 10^4`

---

## Analysis / Phân tích

### Approach: Modified Binary Search / Tìm Kiếm Nhị Phân Sửa Đổi
- **Idea**: Similar to "Search in Rotated Sorted Array I", but duplicates add ambiguity.
- **Problem**: If `nums[lo] == nums[mid] == nums[hi]`, we don't know which side is sorted. e.g., `[1, 0, 1, 1, 1]` vs `[1, 1, 1, 0, 1]`.
- **Solution**: If `nums[lo] == nums[mid] && nums[mid] == nums[hi]`, simply increment `lo` and decrement `hi` to shrink window (linear step). Otherwise, proceed with standard rotated binary search logic.
- **Algorithm**:
    1.  `mid = (lo + hi) / 2`.
    2.  If `target == nums[mid]`, return true.
    3.  If `nums[lo] == nums[mid] == nums[hi]`, `lo++`, `hi--`.
    4.  Else if `nums[lo] <= nums[mid]` (Left sorted):
        - If `nums[lo] <= target < nums[mid]`, `hi = mid - 1`.
        - Else `lo = mid + 1`.
    5.  Else (Right sorted):
        - If `nums[mid] < target <= nums[hi]`, `lo = mid + 1`.
        - Else `hi = mid - 1`.
- **Time Complexity**: Average O(log N), Worst Case O(N) (all duplicates).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **All Duplicates**: `[1,1,1,1]`, target 2 -> false.
2.  **Pivot at ends**: `[1,2,3]` or `[3,1,2]`.
