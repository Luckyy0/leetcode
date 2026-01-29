# 661. Image Smoother / Làm mịn Hình ảnh

## Problem Description / Mô tả bài toán
An image smoother is a filter of the size `3 x 3` that can be applied to each cell of an image by rounding down the average of the cell and its eight neighbors.
Một bộ làm mịn hình ảnh là một bộ lọc có kích thước `3 x 3` có thể được áp dụng cho mỗi ô của hình ảnh bằng cách làm tròn xuống giá trị trung bình của ô đó và tám ô lân cận của nó.

If one or more of the neighbors of a cell are empty, we will not consider them while calculating the average.
Nếu một hoặc nhiều ô lân cận của một ô trống, chúng ta sẽ không xem xét chúng khi tính giá trị trung bình.

Given an `m x n` integer matrix `img` representing the grayscale of an image, return the image after applying the smoother on each cell of it.
Cho một ma trận số nguyên `m x n` `img` đại diện cho mức xám của một hình ảnh, hãy trả về hình ảnh sau khi áp dụng bộ làm mịn lên mỗi ô của nó.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Matrix Traversal / Duyệt Ma trận
For each cell `(r, c)`, we iterate through its neighbors in a `[-1, 1]` range for both row and column offsets.
Đối với mỗi ô `(r, c)`, chúng ta lặp qua các ô lân cận của nó trong phạm vi `[-1, 1]` cho cả độ lệch hàng và cột.

We check if the neighbor index is within the bounds of the matrix.
Chúng ta kiểm tra xem chỉ số của ô lân cận có nằm trong phạm vi của ma trận hay không.

### Complexity / Độ phức tạp
- **Time**: O(M * N) where M and N are dimensions of the image.
- **Space**: O(M * N) to store the result matrix.

---

## Analysis / Phân tích

### Approach: Neighborhood Averaging
For every pixel, calculate the sum and count of all valid neighbors (including itself) and store the floor of the average in a new matrix.
Đối với mỗi pixel, hãy tính tổng và số lượng của tất cả các ô lân cận hợp lệ (bao gồm cả chính nó) và lưu giá trị làm tròn xuống của trung bình vào một ma trận mới.

---
