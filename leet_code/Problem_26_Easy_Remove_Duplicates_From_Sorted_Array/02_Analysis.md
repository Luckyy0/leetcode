# Analysis for Remove Duplicates from Sorted Array
# *Phân tích cho bài toán Xóa Các Phần Tử Trùng Lặp khỏi Mảng Đã Sắp Xếp*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Sorted array `nums`. *Mảng đã sắp xếp `nums`.*
*   **Output:** Integer `k` (number of unique elements). *Số nguyên `k` (số lượng phần tử duy nhất).*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `N` up to $3 \times 10^4$.
*   $O(N)$ time complexity.
*   $O(1)$ space complexity (In-place).
    *Độ phức tạp không gian $O(1)$ (Tại chỗ).*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Two Pointers
### *Hướng tiếp cận: Hai Con Trỏ*

*   **Intuition:** Since the array is sorted, duplicates are adjacent. We can keep a pointer `i` for the position of the last unique element found so far, and iterate with `j` to find new unique elements.
    *Ý tưởng: Vì mảng đã sắp xếp, các phần tử trùng lặp nằm liền kề. Chúng ta có thể giữ một con trỏ `i` cho vị trí của phần tử duy nhất cuối cùng được tìm thấy, và duyệt với `j` để tìm các phần tử duy nhất mới.*
*   **Algorithm Steps:**
    1.  If `nums.length == 0` return 0.
    2.  `i = 0`.
    3.  Loop `j` from 1 to `nums.length - 1`:
        *   If `nums[j] != nums[i]`:
            *   `i++`
            *   `nums[i] = nums[j]`
    4.  Return `i + 1`.

*   **Complexity:**
    *   Time: $O(N)$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`[0, 0, 1, 1, 1, 2, 2, 3, 3, 4]`
1.  `i=0` (val 0). `j=1` (val 0). Equal. Skip.
2.  `j=2` (val 1). Not equal `nums[i]`.
    *   `i=1`. `nums[1] = 1`. Array: `[0, 1, ...]`
3.  `j=3` (val 1). Equal `nums[i]` (1). Skip.
4.  ...
5.  `j=5` (val 2). Not equal.
    *   `i=2`. `nums[2] = 2`. Array: `[0, 1, 2, ...]`
Finally returns `i+1` (count).
