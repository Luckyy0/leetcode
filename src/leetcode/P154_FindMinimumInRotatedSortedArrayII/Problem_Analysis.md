# 154. Find Minimum in Rotated Sorted Array II / Tìm Giá Trị Nhỏ Nhất Trong Mảng Được Xoay II

## Problem Description / Mô tả bài toán
Suppose an array of length `n` sorted in ascending order is **rotated** between `1` and `n` times.
Cho một mảng có độ dài `n` được sắp xếp tăng dần và bị xoay từ `1` đến `n` lần.

Given the sorted rotated array `nums` that may contain **duplicates**, return the minimum element of this array.
Cho mảng `nums` đã xoay, có thể chứa các **phần tử lặp lại**, hãy trả về phần tử nhỏ nhất của mảng này.

You must write an algorithm that runs in **O(log n)** time on average.

### Example 1:
```text
Input: nums = [1,3,5]
Output: 1
```

### Example 2:
```text
Input: nums = [2,2,2,0,1]
Output: 0
```

## Constraints / Ràng buộc
- `n == nums.length`
- `1 <= n <= 5000`
- `-5000 <= nums[i] <= 5000`
- `nums` is sorted and rotated between `1` and `n` times.

**Follow-up**: This problem is similar to "Find Minimum in Rotated Sorted Array", but `nums` may contain duplicates. Would this affect the runtime complexity? How and why?
**Theo dõi**: Bài toán này tương tự bài toán trước nhưng có chứa bản sao. Điều này có ảnh hưởng đến độ phức tạp thời gian không? Tại sao?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Handling Duplicates in Binary Search / Xử lý phần tử lặp lại trong Tìm kiếm Nhị phân
The presence of duplicates makes it impossible to always decide which half to discard using just the middle and end elements.
Sự xuất hiện của các phần tử lặp lại khiến chúng ta không thể luôn quyết định nên bỏ đi nửa nào chỉ bằng cách sử dụng phần tử ở giữa và phần cuối.

**Scenario**: `nums[left] == nums[mid] == nums[right]`
- Example: `[2, 2, 2, 0, 1, 2, 2]`
- `mid` is `2`. `right` is `2`.
- We don't know if the min is to the left or right of `mid`.

**Strategy**:
1.  If `nums[mid] > nums[right]`: Min is in right half (`left = mid + 1`).
2.  If `nums[mid] < nums[right]`: Min is in left half (`right = mid`).
3.  If `nums[mid] == nums[right]`: We cannot be sure. We only know we can safely **decrement `right`** because even if `nums[right]` was the minimum, `nums[mid]` is equal and still exists in the range.

---

## Analysis / Phân tích

### Approach: Binary Search with Duplicate Skip

**Algorithm**:
1.  Initialize `left = 0`, `right = nums.length - 1`.
2.  While `left < right`:
    - `mid = left + (right - left) / 2`.
    - If `nums[mid] > nums[right]`: `left = mid + 1`.
    - Else if `nums[mid] < nums[right]`: `right = mid`.
    - Else (equal): `right--`.
3.  Return `nums[left]`.

### Complexity / Độ phức tạp
- **Average Time**: O(log N).
- **Worst Case Time**: O(N) - when all elements are the same (e.g., `[2, 2, 2, 2]`).
- **Space**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **All elements identical**: O(N).
2.  **Minimum is at the very beginning or end**: Handled.
3.  **No rotation**: Handled.
