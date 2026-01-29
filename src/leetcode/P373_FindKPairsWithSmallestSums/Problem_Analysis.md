# 373. Find K Pairs with Smallest Sums / Tìm K Cặp Có Tổng Nhỏ Nhất

## Problem Description / Mô tả bài toán
You are given two integer arrays `nums1` and `nums2` sorted in **non-decreasing order** and an integer `k`.
Bạn được cung cấp hai mảng số nguyên `nums1` và `nums2` được sắp xếp theo **thứ tự không giảm** và một số nguyên `k`.

Define a pair `(u, v)` which consists of one element from the first array and one element from the second array.
Định nghĩa một cặp `(u, v)` bao gồm một phần tử từ mảng thứ nhất và một phần tử từ mảng thứ hai.

Return the `k` pairs `(u1, v1), (u2, v2), ..., (uk, vk)` with the smallest sums.
Trả về `k` cặp có tổng nhỏ nhất.

### Example 1:
```text
Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
```

### Example 2:
```text
Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [[1,1],[1,1]]
```

## Constraints / Ràng buộc
- `1 <= nums1.length, nums2.length <= 10^5`
- `-10^9 <= nums1[i], nums2[i] <= 10^9`
- `nums1` and `nums2` are sorted in non-decreasing order.
- `1 <= k <= 10^4`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Min-Heap (Priority Queue) / Hàng Đợi Ưu Tiên
This is similar to "Merge K Sorted Lists".
We have implicit lists:
- `row 0`: `(nums1[0], nums2[0]), (nums1[0], nums2[1]), ...`
- `row 1`: `(nums1[1], nums2[0]), (nums1[1], nums2[1]), ...`
- ...
Since nums2 is sorted, each row is sorted by sum.
We can push the first element of each row `(nums1[i], nums2[0])` into a Min-Heap.
Wait, if `nums1` is large, we can't push all N elements.
Actually, we only need to push `min(k, nums1.length)` elements initially.
Because `nums1[0] + nums2[0]` is the global min.
If we pick `(nums1[i], nums2[j])`, the next candidate from this "stream" is `(nums1[i], nums2[j+1])`.

Algorithm:
1.  Min-Heap stores `{sum, i, j}` or `{nums1[i], nums2[j], j}`. Compare by sum.
2.  Init: Push `(nums1[i] + nums2[0], i, 0)` for `i` in range `[0, min(k, len1)-1]`.
3.  Loop k times:
    - Poll min `(sum, i, j)`. Add pair to result.
    - If `j + 1 < len2`, push `(nums1[i] + nums2[j+1], i, j+1)`.

### Complexity / Độ phức tạp
- **Time**: O(K log K) (since heap size <= K).
- **Space**: O(K).

---

## Analysis / Phân tích

### Approach: Min-Heap

**Algorithm**:
1.  PQ stores `int[]{nums1[i], nums2[j], j}`? Need to retrieve values. Or index `int[]{i, j}` and compare sums from arrays.
    - PQ of `int[] {i, j}`. Comparator uses `nums1[i] + nums2[j]`.
    - BUT arrays are large, referring by index ok.
    - Initial push: `(i, 0)` for `i < k`.
    - Next: push `(i, j+1)`.

---
