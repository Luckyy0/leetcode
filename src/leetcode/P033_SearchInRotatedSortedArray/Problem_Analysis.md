# 33. Search in Rotated Sorted Array / Tìm Kiếm Trong Mảng Đã Sắp Xếp Bị Xoay

## Problem Description / Mô tả bài toán
There is an integer array `nums` sorted in ascending order (with **distinct** values).
Có một mảng số nguyên `nums` được sắp xếp theo thứ tự tăng dần (với các giá trị **khác nhau**).

Prior to being passed to your function, `nums` is **possibly rotated** at an unknown pivot index `k` (`1 <= k < nums.length`) such that the resulting array is `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (0-indexed). For example, `[0,1,2,4,5,6,7]` might be rotated at pivot index 3 and become `[4,5,6,7,0,1,2]`.
Trước khi được truyền vào hàm của bạn, `nums` có thể **bị xoay** tại một chỉ số trục `k` không xác định (`1 <= k < nums.length`) sao cho mảng kết quả là `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (chỉ số bắt đầu từ 0). Ví dụ, `[0,1,2,4,5,6,7]` có thể bị xoay tại chỉ số trục 3 và trở thành `[4,5,6,7,0,1,2]`.

Given the array `nums` **after** the possible rotation and an integer `target`, return the index of `target` if it is in `nums`, or `-1` if it is not in `nums`.
Cho mảng `nums` **sau khi** có thể bị xoay và một số nguyên `target`, trả về chỉ số của `target` nếu nó nằm trong `nums`, hoặc `-1` nếu nó không nằm trong `nums`.

You must write an algorithm with `O(log n)` runtime complexity.
Bạn phải viết một thuật toán với độ phức tạp thời gian `O(log n)`.

### Example 1:
```text
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

### Example 2:
```text
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```

### Example 3:
```text
Input: nums = [1], target = 0
Output: -1
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 5000`
- `-10^4 <= nums[i] <= 10^4`
- All values of `nums` are **unique**.
- `nums` is an ascending array that is possibly rotated.
- `-10^4 <= target <= 10^4`

---

## Analysis / Phân tích

### Approach: Binary Search / Tìm Kiếm Nhị Phân
- **Idea**: Even though the array is rotated, at least one half of the array (split by `mid`) will always be sorted.
- **Ý tưởng**: Mặc dù mảng bị xoay, ít nhất một nửa của mảng (chia bởi `mid`) sẽ luôn được sắp xếp.
- **Algorithm**:
    1.  Calculated `mid`.
    2.  Check if `nums[mid] == target`. If so, return `mid`.
    3.  Check if the left half `[lo, mid]` is sorted (`nums[lo] <= nums[mid]`):
        - If `target` is within this sorted range (`nums[lo] <= target < nums[mid]`), searching in the left: `hi = mid - 1`.
        - Otherwise, search in the right: `lo = mid + 1`.
    4.  Else, the right half `[mid, hi]` must be sorted:
        - If `target` is within this sorted range (`nums[mid] < target <= nums[hi]`), search in the right: `lo = mid + 1`.
        - Otherwise, search in the left: `hi = mid - 1`.
- **Time Complexity**: O(log n).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Single Element**: `[1]`.
2.  **Not Rotated**: `[1, 2, 3]`.
3.  **Pivot at Extremes**: Rotated effectively 0 or n times.
