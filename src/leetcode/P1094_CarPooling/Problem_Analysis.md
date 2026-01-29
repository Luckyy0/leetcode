# 1094. Car Pooling / Đi chung Xe

## Problem Description / Mô tả bài toán
There is a car with `capacity` empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).
Given a list of `trips`, `trip[i] = [numPassengers, from, to]`.
Return `true` if it is possible to pick up and drop off all passengers for all the given trips, or `false` otherwise.
Chiếc xe chỉ đi về phía đông. Cho danh sách `trips`, trả về `true` nếu có thể đón và trả tất cả hành khách cho tất cả các chuyến đi đã cho, hoặc `false` nếu ngược lại.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Difference Array / Sweep Line / Mảng Hiệu / Quét Đường
We need to check if at any point the number of passengers > capacity.
Locations are up to 1000.
Algorithm:
1. Create array `diff` of size 1001.
2. For each trip:
   - `diff[from] += numPassengers`.
   - `diff[to] -= numPassengers`.
3. Iterate `diff`, maintaining `currentLoad`.
   - `currentLoad += diff[i]`.
   - If `currentLoad > capacity`, return false.

### Complexity / Độ phức tạp
- **Time**: O(N + M), where N is trips, M is range (1001).
- **Space**: O(M).

---

## Analysis / Phân tích

### Approach: Capacity Difference Tracking
Use the difference array technique to track passenger load changes over the route. For each trip, increment passenger count at the start location and decrement at the end location. Sweep through the locations to calculate the cumulative load at every point, verifying it never exceeds capacity.
Sử dụng kỹ thuật mảng hiệu số để theo dõi thay đổi tải hành khách trên tuyến đường. Đối với mỗi chuyến đi, tăng số lượng hành khách tại địa điểm bắt đầu và giảm tại địa điểm kết thúc. Quét qua các địa điểm để tính toán tải tích lũy tại mọi điểm, xác minh rằng nó không bao giờ vượt quá sức chứa.

---
