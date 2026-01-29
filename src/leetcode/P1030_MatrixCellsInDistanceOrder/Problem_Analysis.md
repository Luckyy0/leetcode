# 1030. Matrix Cells in Distance Order / Các Ô Ma trận theo Thứ tự Khoảng cách

## Problem Description / Mô tả bài toán
Given rows `R`, cols `C`, and coordinates `(rCenter, cCenter)`, return the coordinates of all cells in the matrix, sorted by their distance from `(rCenter, cCenter)`. Distance is Manhattan distance: `|r1 - r2| + |c1 - c2|`.
Cho số hàng `R`, số cột `C` và tọa độ `(rCenter, cCenter)`, hãy trả về tọa độ của tất cả các ô trong ma trận, được sắp xếp theo khoảng cách của chúng tới `(rCenter, cCenter)`. Khoảng cách là khoảng cách Manhattan: `|r1 - r2| + |c1 - c2|`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting / BFS / Sắp xếp / BFS
Three approaches:
1. Generate all cells, put into list, and sort using comparator. O(RC log(RC)).
2. Bucket Sort (since max distance is tiny R+C). O(RC).
3. BFS from center. O(RC).

Algorithm (Sorting - simplest to implement):
1. Create `List<int[]>`.
2. Add all `R*C` cells.
3. Sort based on `abs(r - rC) + abs(c - cC)`.

### Complexity / Độ phức tạp
- **Time**: O(RC log(RC)).
- **Space**: O(RC).

---

## Analysis / Phân tích

### Approach: Distance-Based Sorting
Generate the complete set of grid coordinates. Sort this collection using a custom comparator that calculates the Manhattan distance to the target center point. This provides a direct and simple solution.
Tạo tập hợp hoàn chỉnh các tọa độ lưới. Sắp xếp bộ sưu tập này bằng cách sử dụng bộ so sánh tùy chỉnh để tính khoảng cách Manhattan đến điểm trung tâm đích. Điều này cung cấp một giải pháp trực tiếp và đơn giản.

---
