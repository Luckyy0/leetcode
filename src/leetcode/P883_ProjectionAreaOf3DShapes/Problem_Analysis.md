# 883. Projection Area of 3D Shapes / Diện tích Hình chiếu của các Khối 3D

## Problem Description / Mô tả bài toán
You are given an `n x n` grid representing the height of cubes placed on each cell. We want to find the total projection area on the XY, YZ, and ZX planes.
Bạn được cấp một lưới `n x n` đại diện cho độ cao của các khối lập phương được đặt trên mỗi ô. Chúng ta muốn tìm tổng diện tích hình chiếu lên các mặt phẳng XY, YZ và ZX.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Projection Geometry / Hình học Hình chiếu
- **XY Plane (Top view)**: Count the number of cells that have `height > 0`.
Mặt phẳng XY (Nhìn từ trên): Đếm số lượng các ô có `độ cao > 0`.
- **YZ Plane (Side view)**: Sum of the maximum heights in each row.
Mặt phẳng YZ: Tổng các độ cao tối đa trong mỗi hàng.
- **ZX Plane (Front view)**: Sum of the maximum heights in each column.
Mặt phẳng ZX: Tổng các độ cao tối đa trong mỗi cột.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Marginal Maximum Summation
The total shadow of the 3D structure is the sum of its presence on the ground (count of occupied cells) plus the sum of its highest profiles from the two vertical perspectives (row and column maximums).
Tổng bóng của cấu trúc 3D là tổng mức độ hiện diện của nó trên mặt đất (số lượng các ô được chiếm giữ) cộng với tổng các mặt cắt cao nhất của nó từ hai góc nhìn thẳng đứng (giá trị tối đa của hàng và cột).

---
