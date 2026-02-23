# Analysis for Search a 2D Matrix
# *Phân tích cho bài toán Tìm Kiếm Trong Ma Trận 2 Chiều*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Sorted m x n matrix, target integer. *Ma trận m x n đã sắp xếp, số nguyên mục tiêu.*
*   **Output:** Boolean (found or not). *Boolean (tìm thấy hay không).*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   m, n up to 100.
*   Time complexity requirement: $O(\log(m \cdot n))$.
*   *m, n lên tới 100.*
*   *Yêu cầu độ phức tạp thời gian: $O(\log(m \cdot n))$.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Binary Search on Flattened Matrix
### *Hướng tiếp cận: Tìm kiếm Nhị phân trên Ma trận trải phẳng*

*   **Intuition:** The matrix can be viewed as a single sorted array of size `m * n`. We can perform a binary search on this virtual array.
*   *Ý tưởng: Ma trận có thể được coi là một mảng đã sắp xếp duy nhất có kích thước `m * n`. Chúng ta có thể thực hiện tìm kiếm nhị phân trên mảng ảo này.*

*   **Algorithm Steps:**
    1.  `low = 0`, `high = m * n - 1`.
    2.  While `low <= high`:
        *   `mid = low + (high - low) / 2`.
        *   Convert `mid` to matrix coordinates: `row = mid / n`, `col = mid % n`.
        *   `midValue = matrix[row][col]`.
        *   If `midValue == target`, return `true`.
        *   Else if `midValue < target`, `low = mid + 1`.
        *   Else, `high = mid - 1`.
    3.  Return `false`.

*   **Complexity:**
    *   Time: $O(\log(M \cdot N))$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`[[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3`
1. `m=3, n=4`. `low=0, high=11`.
2. `mid=5`. `row=5/4=1, col=5%4=1`. `matrix[1][1] = 11`.
3. `11 > 3`, `high = 4`.
4. `mid=2`. `row=2/4=0, col=2%4=2`. `matrix[0][2] = 5`.
5. `5 > 3`, `high = 1`.
6. `mid=0`. `row=0/4=0, col=0%4=0`. `matrix[0][0] = 1`.
7. `1 < 3`, `low = 1`.
8. `mid=1`. `row=1/4=0, col=1%4=1`. `matrix[0][1] = 3`.
9. `3 == 3`. Return `true`.
---
*Ánh xạ chỉ số giữa mảng 1 chiều và ma trận 2 chiều là kỹ thuật mấu chốt ở đây.*
Mapping indices between a 1D array and a 2D matrix is the key technique here.
