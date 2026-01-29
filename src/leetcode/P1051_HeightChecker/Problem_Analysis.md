# 1051. Height Checker / Trình kiểm tra Chiều cao

## Problem Description / Mô tả bài toán
A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in **non-decreasing order** by height.
Một ngôi trường đang cố gắng chụp ảnh thường niên cho tất cả học sinh. Các học sinh được yêu cầu xếp thành một hàng dọc theo **thứ tự không giảm** về chiều cao.

Let this ordering be represented by the integer array `expected` where `expected[i]` is the expected height of the `i-th` student in line.
Hãy để thứ tự này được biểu diễn bởi mảng số nguyên `expected` trong đó `expected[i]` là chiều cao mong đợi của học sinh thứ `i` trong hàng.

You are given an integer array `heights` representing the current order that the students are standing in. Each `heights[i]` is the height of the `i-th` student in line (0-indexed).
Bạn được cho một mảng số nguyên `heights` đại diện cho thứ tự hiện tại mà các học sinh đang đứng. Mỗi `heights[i]` là chiều cao của học sinh thứ `i` trong hàng (chỉ số 0).

Return the number of indices where `heights[i] != expected[i]`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting and Comparison / Sắp xếp và So sánh
We need to compare the current array with the sorted version of itself.

Algorithm:
1. Create a copy of `heights`: `expected = heights.clone()`.
2. Sort `expected`.
3. Iterate `i` from 0 to `n-1`.
4. If `heights[i] != expected[i]`, `count++`.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Reference Comparison
Construct the theoretically correct arrangement by sorting the original array. Perform a linear scan to compare the actual arrangement against this reference, counting every position where the student does not match the expected height.
Xây dựng sự sắp xếp chính xác về mặt lý thuyết bằng cách sắp xếp mảng ban đầu. Thực hiện quét tuyến tính để so sánh sự sắp xếp thực tế với tham chiếu này, đếm mọi vị trí mà học sinh không khớp với chiều cao mong đợi.

---
