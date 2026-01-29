# 1162. As Far from Land as Possible / Càng xa Đất Liền Càng tốt

## Problem Description / Mô tả bài toán
Given an `n x n` binary grid containing 0 (water) and 1 (land).
Find a water cell (0) such that its distance to the nearest land cell (1) is maximized. Return this distance. If no land or no water, return -1.
Manhattan distance.
Cho một lưới nhị phân `n x n` chứa 0 (nước) và 1 (đất liền).
Tìm một ô nước (0) sao cho khoảng cách của nó đến ô đất liền gần nhất (1) được tối đa hóa. Trả về khoảng cách này. Nếu không có đất liền hoặc không có nước, hãy trả về -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Multi-Source BFS / BFS Đa nguồn
1. Put all Land cells into Queue. Dist = 0.
2. BFS out to water cells.
3. Update max distance encountered.
4. If queue initially full or empty, return -1.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: Multi-Source BFS Expansion
Initialize a BFS queue with all land cells (distance 0). Expand outwards layer by layer into the water cells. For each visited water cell, record its distance. The last water cell visited will have the maximum minimum distance to any land cell. If the grid contains only land or only water, handle these as edge cases.
Khởi tạo hàng đợi BFS với tất cả các ô đất nền (khoảng cách 0). Mở rộng ra bên ngoài từng lớp vào các ô nước. Đối với mỗi ô nước đã truy cập, hãy ghi lại khoảng cách của nó. Ô nước cuối cùng được truy cập sẽ có khoảng cách tối thiểu tối đa đến bất kỳ ô đất nền nào. Nếu lưới chỉ chứa đất hoặc chỉ chứa nước, hãy xử lý các trường hợp biên này.

---
