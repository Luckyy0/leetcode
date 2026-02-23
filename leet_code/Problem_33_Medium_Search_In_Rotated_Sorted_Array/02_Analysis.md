# Analysis for Search in Rotated Sorted Array
# *Phân tích cho bài toán Tìm Kiếm trong Mảng Đã Sắp Xếp Dịch Chuyển*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Rotated sorted array `nums`, integer `target`. *Mảng đã sắp xếp xoay `nums`, số nguyên `target`.*
*   **Output:** Index or -1. *Chỉ số hoặc -1.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `O(log n)` required.
*   Values are distinct.

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Modified Binary Search
### *Hướng tiếp cận: Tìm kiếm Nhị phân Sửa đổi*

*   **Intuition:** At any pivot, at least one half of the array (left or right) is sorted. We can check if the target lies within the sorted half.
    *Ý tưởng: Tại bất kỳ điểm chốt nào, ít nhất một nửa mảng (trái hoặc phải) đã được sắp xếp. Chúng ta có thể kiểm tra xem target có nằm trong nửa đã sắp xếp hay không.*
*   **Algorithm Steps:**
    1.  `low = 0`, `high = n - 1`.
    2.  While `low <= high`:
        *   `mid = (low + high) / 2`.
        *   If `nums[mid] == target`, return `mid`.
        *   **Check sorted half:**
            *   If `nums[low] <= nums[mid]`: (Left half sorted)
                *   If `nums[low] <= target < nums[mid]`: Target in left. `high = mid - 1`.
                *   Else: Target in right. `low = mid + 1`.
            *   Else: (Right half sorted)
                *   If `nums[mid] < target <= nums[high]`: Target in right. `low = mid + 1`.
                *   Else: Target in left. `high = mid - 1`.
    3.  Return -1.

*   **Complexity:**
    *   Time: $O(\log N)$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`[4,5,6,7,0,1,2]`, target `0`.
1.  L=0(4), H=6(2). Mid=3(7).
    *   `4 <= 7`. Left sorted.
    *   Is `4 <= 0 < 7`? No. Go right. `low = 4` (0).
2.  L=4(0), H=6(2). Mid=5(1).
    *   `0 <= 1`. Left sorted.
    *   Is `0 <= 0 < 1`? Yes. Go left. `high = 5 - 1 = 4`.
3.  L=4(0), H=4(0). Mid=4(0). Match! Return 4.
