# 34. Find First and Last Position of Element in Sorted Array / Tìm Vị Trí Đầu Tiên và Cuối Cùng Của Phần Tử Trong Mảng Đã Sắp Xếp

## Problem Description / Mô tả bài toán
Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given `target` value.
Cho một mảng số nguyên `nums` được sắp xếp theo thứ tự không giảm, hãy tìm vị trí bắt đầu và kết thúc của một giá trị `target` cho trước.

If `target` is not found in the array, return `[-1, -1]`.
Nếu `target` không được tìm thấy trong mảng, trả về `[-1, -1]`.

You must write an algorithm with `O(log n)` runtime complexity.
Bạn phải viết một thuật toán với độ phức tạp thời gian `O(log n)`.

### Example 1:
```text
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
```

### Example 2:
```text
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
```

### Example 3:
```text
Input: nums = [], target = 0
Output: [-1,-1]
```

## Constraints / Ràng buộc
- `0 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`
- `nums` is a non-decreasing array.
- `-10^9 <= target <= 10^9`

---

## Analysis / Phân tích

### Approach: Two Binary Searches / Hai Lần Tìm Kiếm Nhị Phân
- **Idea**: Since the array is sorted, we can use binary search. However, a standard binary search finds *any* index of the target. We need specifically the *first* and *last*.
- **Ý tưởng**: Vì mảng đã được sắp xếp, ta có thể dùng tìm kiếm nhị phân. Tuy nhiên, tìm kiếm nhị phân chuẩn chỉ tìm thấy *bất kỳ* chỉ số nào của target. Chúng ta cần cụ thể là *đầu tiên* và *cuối cùng*.
- **Algorithm**:
    1.  **Find First**: Run binary search. If `nums[mid] == target`, allow `hi` to move left (`hi = mid - 1`) to search for an earlier occurrence, while recording the current `mid` as a candidate.
    2.  **Find Last**: Run binary search. If `nums[mid] == target`, allow `lo` to move right (`lo = mid + 1`) to search for a later occurrence.
- **Time Complexity**: O(log n). We run binary search twice.
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Target Not Found**: Both searches should handle this gracefully or return index -1.
2.  **Empty Array**: Handle `nums.length == 0`.
3.  **Single Element**: `[1]`, target 1 -> `[0, 0]`.
