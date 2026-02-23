# Analysis for Search in Rotated Sorted Array II
# *Phân tích cho bài toán Tìm Kiếm Trong Mảng Được Xoay Đã Sắp Xếp II*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Rotated sorted array `nums` with duplicates, and `target`. *Mảng đã sắp xếp và bị xoay `nums` có các phần tử trùng lặp, và giá trị mục tiêu `target`.*
*   **Output:** Boolean (found or not). *Boolean (tìm thấy hay không).*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Duplicates make it harder to determine the sorted half.
*   Worst case time complexity is $O(n)$ if all elements are the same.
*   *Các phần tử trùng lặp làm cho việc xác định nửa đã sắp xếp trở nên khó khăn hơn.*
*   *Độ phức tạp thời gian trường hợp xấu nhất là $O(n)$ nếu tất cả các phần tử đều giống nhau.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Modified Binary Search
### *Hướng tiếp cận: Tìm kiếm Nhị phân Sửa đổi*

*   **Logic:**
    1.  If `nums[low] == nums[mid] == nums[high]`, we cannot tell which half is sorted. Simply increment `low` and decrement `high`.
    2.  Otherwise, check if the left half is sorted (`nums[low] <= nums[mid]`):
        *   If `target` is within the range `[nums[low], nums[mid])`, search left.
        *   Else, search right.
    3.  If the right half is sorted:
        *   If `target` is within the range `(nums[mid], nums[high]]`, search right.
        *   Else, search left.

*   **Algorithm Steps:**
    1.  Initialize `low = 0, high = nums.length - 1`.
    2.  While `low <= high`:
        *   Calculate `mid`.
        *   If `nums[mid] == target`, return `true`.
        *   If `nums[low] == nums[mid] == nums[high]`: `low++; high--`.
        *   Standard rotation binary search logic for other cases.
    3.  Return `false`.

*   **Complexity:**
    *   Time: Average $O(\log n)$, Worst case $O(n)$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`nums = [1,0,1,1,1], target = 0`
1. `low=0, high=4, mid=2`. `nums[2]=1`.
2. `nums[low]=1, nums[mid]=1, nums[high]=1`. Case 1.
3. `low=1, high=3`.
4. `mid=2`. `nums[2]=1`.
5. `nums[1]=0, nums[2]=1, nums[3]=1`.
6. `nums[low]=0 <= nums[mid]=1`. Left half sorted.
7. `target=0` is in `[0, 1)`. `high = mid - 1 = 1`.
8. `mid=1`. `nums[1]=0 == target`. Return `true`.
---
*Xử lý các phần tử trùng lặp là điểm mấu chốt để tránh các quyết định sai lầm.*
Handling duplicates is the key point to avoid wrong decisions.
