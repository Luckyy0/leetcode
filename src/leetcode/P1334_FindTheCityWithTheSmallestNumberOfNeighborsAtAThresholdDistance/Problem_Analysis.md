# 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance / Tìm Thành phố Có Số lượng Hàng xóm Nhỏ nhất ở Khoảng cách Ngưỡng

## Problem Description / Mô tả bài toán
`n` cities, `edges`. `distanceThreshold`.
For each city, find number of cities reachable within distance.
Find city with MIN reachable count. Tie-break: max city index.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### All-Pairs Shortest Path (Floyd-Warshall)
Since N <= 100, Floyd-Warshall O(N^3) is perfect.
Initialize `dist[i][j]`.
Compute all pairs distances.
Iterate each city `i`. Count `j` where `dist[i][j] <= threshold`.
Track min count and best city.

### Complexity / Độ phức tạp
- **Time**: O(N^3).
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: Floyd-Warshall
Construct the distance matrix with edge weights. Initialize `dist[i][i] = 0` and `dist[i][j] = infinity`. Run Floyd-Warshall algorithm to find shortest paths between all pairs of cities. For each city `i`, count the number of other cities `j` such that `dist[i][j] <= distanceThreshold`. Keep track of the city with the minimum count (and the largest ID in case of ties).
Xây dựng ma trận khoảng cách với trọng số cạnh. Khởi tạo `dist[i][i] = 0` và `dist[i][j] = vô cực`. Chạy thuật toán Floyd-Warshall để tìm đường đi ngắn nhất giữa tất cả các cặp thành phố. Đối với mỗi thành phố `i`, đếm số lượng thành phố khác `j` sao cho `dist[i][j] <= distanceThreshold`. Theo dõi thành phố có số lượng nhỏ nhất (và ID lớn nhất trong trường hợp hòa).

---
