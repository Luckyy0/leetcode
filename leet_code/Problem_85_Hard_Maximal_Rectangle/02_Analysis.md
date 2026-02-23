# Analysis for Maximal Rectangle
# *Phân tích cho bài toán Hình Chữ Nhật Lớn Nhất*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Binary matrix of chars '0' and '1'. *Ma trận nhị phân gồm các ký tự '0' và '1'.*
*   **Output:** Maximum rectangle area of 1s. *Diện tích hình chữ nhật tối đa của các số 1.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Matrix size up to 200x200. $O(R \cdot C)$ complexity is expected.
*   The problem is essentially finding the largest rectangle in multiple histograms.
*   *Kích thước ma trận lên tới 200x200. Độ phức tạp $O(R \cdot C)$ được mong đợi.*
*   *Bài toán này thực chất là tìm hình chữ nhật lớn nhất trong nhiều biểu đồ cột.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Histogram Based (Dynamic Programming + Stack)
### *Hướng tiếp cận: Dựa trên Biểu đồ cột (Quy hoạch động + Ngăn xếp)*

*   **Logic:**
    1.  Maintain an array `heights` of the same width as the matrix columns.
    2.  Iterate through each row of the matrix:
        *   Update `heights`: if `matrix[row][col] == '1'`, `heights[col]++`. Else, `heights[col] = 0`.
        *   After updating `heights` for current row, use the "Largest Rectangle in Histogram" logic (Problem 84) to find the max area for this row's histogram.
    3.  Keep track of the global maximum area.

*   **Complexity:**
    *   Time: $O(R \cdot C)$ where $R$ is number of rows and $C$ is number of columns.
    *   Space: $O(C)$ to store the heights of the current histogram.

### Dry Run
### *Chạy thử*
`matrix = [["1","0"],["1","1"]]`
1. Row 0: `heights = [1, 0]`. Max Area in Histogram `[1, 0]` is 1.
2. Row 1: 
   - `matrix[1][0] == '1'` -> `heights[0] = 1 + 1 = 2`.
   - `matrix[1][1] == '1'` -> `heights[1] = 0 + 1 = 1`.
   - `heights = [2, 1]`. Max Area in Histogram `[2, 1]` is 2.
Result: 2.
---
*Việc chuyển đổi bài toán ma trận thành bài toán biểu đồ cột là bước ngoặt quan trọng.*
Converting the matrix problem into a histogram problem is the key turning point.
