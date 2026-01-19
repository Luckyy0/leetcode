# 4. Median of Two Sorted Arrays / Trung Vị Của Hai Mảng Đã Sắp Xếp

## Problem Description / Mô tả bài toán
Given two sorted arrays `nums1` and `nums2` of size `m` and `n` respectively, return the median of the two sorted arrays.
Cho hai mảng đã sắp xếp `nums1` và `nums2` có kích thước lần lượt là `m` và `n`, trả về trung vị của hai mảng đã sắp xếp đó.

The overall run time complexity should be `O(log (m+n))`.
Độ phức tạp thời gian tổng thể phải là `O(log (m+n))`.

### Example 1:
```text
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
```

### Example 2:
```text
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
```

## Constraints / Ràng buộc
- `nums1.length == m`
- `nums2.length == n`
- `0 <= m <= 1000`
- `0 <= n <= 1000`
- `1 <= m + n <= 2000`
- `-10^6 <= nums1[i], nums2[i] <= 10^6`

---

## Analysis / Phân tích

### Approach 1: Merge Idea (Brute Force) / Ý tưởng Trộn (Vét cạn)
- **Idea**: Merge both arrays into a single sorted array and then find the median directly.
- **Ý tưởng**: Trộn cả hai mảng thành một mảng đã sắp xếp duy nhất và sau đó tìm trung vị trực tiếp.
- **Time Complexity**: O(m + n). We traverse both arrays once.
- **Space Complexity**: O(m + n) to store the merged array.

### Approach 2: Binary Search (Optimal) / Tìm kiếm nhị phân (Tối ưu)
- **Idea**: We want to partition both arrays into two halves such that the left half contains `(m + n + 1) / 2` elements.
- **Ý tưởng**: Chúng ta muốn phân chia cả hai mảng thành hai nửa sao cho nửa bên trái chứa `(m + n + 1) / 2` phần tử.
    - We perform binary search on the smaller array (say `nums1`).
    - Let `partition1` be the cut position in `nums1`, and `partition2` be the corresponding cut in `nums2`.
    - `partition2 = (m + n + 1) / 2 - partition1`.
    - We need to ensure:
        - `maxLeft1 <= minRight2`
        - `maxLeft2 <= minRight1`
    - If satisfying, we found the correct partition.
        - If `(m + n)` is odd: `max(maxLeft1, maxLeft2)`.
        - If `(m + n)` is even: `(max(maxLeft1, maxLeft2) + min(minRight1, minRight2)) / 2`.
- **Time Complexity**: O(log(min(m, n))). We only binary search on the smaller array.
- **Space Complexity**: O(1). No extra space used.

---

## Edge Cases / Các trường hợp biên
1.  **Empty Array**: One of the arrays is empty. The algorithm should handle this gracefully (partition at index 0 or length).
2.  **Disjoint Arrays**: All elements in one array are smaller than the other.
3.  **Duplicate Values**: Does not affect the logic as we only deal with finding the correct partition based on counts and values.
