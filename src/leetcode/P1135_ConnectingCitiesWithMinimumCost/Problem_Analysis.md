# 1135. Connecting Cities With Minimum Cost / Kết nối các Thành phố Với Chi phí Tối thiểu

## Problem Description / Mô tả bài toán
There are `n` cities labeled from `1` to `n`. You are given the connections between them where `connections[i] = [city1, city2, cost]`.
Return the minimum cost to connect all the `n` cities such that there is at least one path between each pair of cities. If it is impossible, return -1.
Có `n` thành phố được đánh số từ `1` đến `n`. Bạn được cho các kết nối giữa chúng trong đó `connections[i] = [city1, city2, cost]`.
Trả về chi phí tối thiểu để kết nối tất cả `n` thành phố sao cho có ít nhất một đường đi giữa mỗi cặp thành phố. Nếu không thể, hãy trả về -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Minimum Spanning Tree (Kruskal's / Prim's) / Cây Khung Nhỏ nhất (Kruskal / Prim)
Kruskal algorithm is best for edge list.
1. Sort edges by cost.
2. Use Union-Find to add edges.
3. Track count of merged components (start n, end 1) and total cost.
4. If final components > 1, return -1.

### Complexity / Độ phức tạp
- **Time**: O(E log E).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Kruskal's Algorithm
This is the classic Minimum Spanning Tree (MST) problem. Sort all edges by cost. Iterate through the sorted edges and use a Union-Find (Disjoint Set Union) data structure to connect cities. Add an edge if the two cities are not already connected. Track the total cost and the number of connected components. If the graph is fully connected (1 component) at the end, return the cost; otherwise, return -1.
Đây là bài toán Cây Khung Nhỏ nhất (MST) cổ điển. Sắp xếp tất cả các cạnh theo chi phí. Lặp qua các cạnh đã sắp xếp và sử dụng cấu trúc dữ liệu Union-Find (Tập hợp Không Giao nhau) để kết nối các thành phố. Thêm một cạnh nếu hai thành phố chưa được kết nối. Theo dõi tổng chi phí và số lượng các thành phần được kết nối. Nếu đồ thị được kết nối hoàn toàn (1 thành phần) ở cuối, hãy trả về chi phí; nếu không, hãy trả về -1.

---
