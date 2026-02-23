# Analysis for Number of Provinces
# *Phân tích cho bài toán Số lượng Tỉnh thành*

## 1. Problem Essence & The Anatomy of Connectivity
## *1. Bản chất vấn đề & Giải phẫu sự Kết nối*

### The Challenge
### *Thách thức*
In this problem, we are managing a set of entities (cities) and their mutual relationships (direct connections).
*Trong bài toán này, chúng ta đang quản lý một tập hợp các thực thể (thành phố) và các mối quan hệ tương hỗ của chúng (kết nối trực tiếp).*

The concept of a "province" is mathematically equivalent to a **Connected Component** in an undirected graph.
*Khái niệm về một "tỉnh" tương đương về mặt toán học với một **Thành phần Liên thông** trong một đồ thị vô hướng.*

The transitivity property (if A connects to B and B connects to C, then A connects to C) implies that we need to explore the full reach of each connection to identify the boundaries of a province.
*Tính chất bắc cầu (nếu A kết nối với B và B kết nối với C, thì A kết nối với C) ngụ ý rằng chúng ta cần khám phá toàn bộ phạm vi của mỗi kết nối để xác định ranh giới của một tỉnh.*

---

## 2. Strategy: Graph Traversal (The "Infection" Model)
## *2. Chiến lược: Duyệt Đồ thị (Mô hình "Lây lan")*

To count the number of disjoint provinces, we can use either Depth-First Search (DFS), Breadth-First Search (BFS), or Disjoint Set Union (DSU).
*Để đếm số lượng các tỉnh rời nhau, chúng ta có thể sử dụng Tìm kiếm theo chiều sâu (DFS), Tìm kiếm theo chiều rộng (BFS) hoặc Cấu trúc các tập hợp rời nhau (DSU).*

### Approach: Depth-First Search (DFS)
### *Hướng tiếp cận: Tìm kiếm theo chiều sâu (DFS)*

1.  **Initialize:** Create a boolean array `visited` of size `N` to keep track of explored cities.
    * **Khởi tạo:** Tạo một mảng boolean `visited` kích thước `N` để theo dõi các thành phố đã được khám phá.*
2.  **Iterate:** Loop through every city `i` from `0` to `N-1`.
    * **Lặp:** Duyệt qua mọi thành phố `i` từ `0` đến `N-1`.*
3.  **Explore:** If city `i` has not been visited:
    * **Khám phá:** Nếu thành phố `i` chưa được thăm:*
    - It marks the discovery of a **new province**. Increment the province count.
    - *Nó đánh dấu việc phát hiện ra một **tỉnh mới**. Tăng số lượng tỉnh lên.*
    - Start a DFS from city `i` to visit all cities that are directly or indirectly connected to it, marking them all as `visited`.
    - *Bắt đầu một DFS từ thành phố `i` để thăm tất cả các thành phố kết nối trực tiếp hoặc gián tiếp với nó, đánh dấu tất cả chúng là `visited`.*
4.  **Repeat:** Once the DFS for city `i` finishes, move to the next unvisited city.
    * **Lặp lại:** Khi DFS cho thành phố `i` kết thúc, chuyển sang thành phố chưa được thăm tiếp theo.*

---

## 3. Structural Advantages & Implementation Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái Triển khai*

*   **Adjacency Matrix Efficiency:** Since the input is an adjacency matrix, DFS is very straightforward as we can immediately see all neighbors of city `i` by scanning the $i$-th row.
    * **Hiệu quả của Ma trận kề:** Vì đầu vào là một ma trận kề, DFS rất trực diện vì chúng ta có thể thấy ngay tất cả các thành phố lân cận của thành phố `i` bằng cách quét hàng thứ $i$.*
*   **Space Optimization:** We only need an $O(N)$ boolean array for tracking, which is minimal compared to the $O(N^2)$ size of the input.
    * **Tối ưu hóa Không gian:** Chúng ta chỉ cần một mảng boolean $O(N)$ để theo dõi, đây là mức tối thiểu so với kích thước $O(N^2)$ của đầu vào.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$. We visit each city once, but for each city, we scan its entire row in the adjacency matrix to find neighbors.
    * **Độ phức tạp thời gian:** $O(N^2)$. Chúng ta thăm mỗi thành phố một lần, nhưng với mỗi thành phố, chúng ta quét toàn bộ hàng của nó trong ma trận kề để tìm các nước láng giềng.*
*   **Space Complexity:** $O(N)$. This is required for the `visited` array and the recursion stack depth in the worst-case scenario.
    * **Độ phức tạp không gian:** $O(N)$. Điều này là cần thiết cho mảng `visited` và độ sâu của ngăn xếp đệ quy trong kịch bản xấu nhất.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input Matrix:**
```
[1, 1, 0]
[1, 1, 0]
[0, 0, 1]
```
- Start at City 0. `visited[0] = false`. 
- **New Province Found (Count = 1).**
- DFS(0):
  - Check City 0 (Self-loop): Ignore.
  - Check City 1: `isConnected[0][1] == 1`. Call DFS(1).
    - DFS(1): Mark `visited[1] = true`. Check its neighbors... none unvisited.
  - Check City 2: `isConnected[0][2] == 0`. Ignore.
- Move to City 1: Already visited.
- Move to City 2: `visited[2] = false`.
- **New Province Found (Count = 2).**
- DFS(2): Mark `visited[2] = true`.
- Final Count: 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

DFS is the most intuitive approach here, while Union-Find is excellent if you need to perform multiple merging operations dynamically.
*DFS là cách tiếp cận trực quan nhất ở đây, trong khi Union-Find là lựa chọn tuyệt vời nếu bạn cần thực hiện nhiều thao tác hợp nhất một cách linh hoạt.*
---
*Mỗi thành phố có thể là một hòn đảo (Isolated node) hoặc là một phần của một lục địa (Province). Bằng cách đi sâu (DFS) vào từng sợi dây liên kết, ta tìm thấy sự thống nhất trong sự đa dạng. Một mạng lưới chỉ thực sự có ý nghĩa khi ta biết rõ ranh giới của những sự thuộc về (Membership).*
Every city can be an island (Isolated node) or part of a continent (Province). By going deep (DFS) into each link, we find unity in diversity. A network is only truly meaningful when we clearly know the boundaries of belonging (Membership).
