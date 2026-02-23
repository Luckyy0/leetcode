# Analysis for Keys and Rooms
# *Phân tích cho bài toán Chìa khóa và Căn phòng*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We need to determine if all nodes in a directed graph are reachable starting from node 0. Each room is a node, and each key is a directed edge to another room.
*Chúng ta cần xác định xem tất cả các nút trong một đồ thị có hướng có thể đến được từ nút 0 hay không. Mỗi căn phòng là một nút, và mỗi chìa khóa là một cạnh có hướng đến phòng khác.*

---

## 2. Strategy: Graph Traversal (BFS/DFS)
## *2. Chiến lược: Duyệt đồ thị (BFS/DFS)*

### Why Traversal?
### *Tại sao dùng Duyệt đồ thị?*
Since we start at room 0 and can only access rooms for which we have keys, this is a classic reachability problem. We can use either Breadth-First Search (BFS) or Depth-First Search (DFS) to explore all reachable rooms.
*Vì chúng ta bắt đầu ở phòng 0 và chỉ có thể vào những phòng mà mình có chìa khóa, đây là bài toán khả năng tiếp cận (reachability) kinh điển. Chúng ta có thể dùng BFS hoặc DFS để khám phá tất cả các phòng có thể đến được.*

### Algorithm Steps (DFS approach)
### *Các bước thuật toán (Cách tiếp cận DFS)*

1.  **Initialize:** Create a boolean array `visited` of size `n` to track visited rooms. Mark `visited[0] = true`.
    *   **Khởi tạo:** Tạo mảng boolean `visited` kích thước `n`. Đánh dấu `visited[0] = true`.*

2.  **Stack/Recursion:** Use a Stack for iterative DFS or use recursion. Push room 0 onto the stack.
    *   **Ngăn xếp/Đệ quy:** Sử dụng Stack cho DFS lặp hoặc sử dụng đệ quy. Đẩy phòng 0 vào ngăn xếp.*

3.  **Explore:** While the stack is not empty:
    - Pop a room.
    - For each key in that room:
        - If the corresponding room has not been visited:
            - Mark it as visited.
            - Push it onto the stack.
    *   **Khám phá:** Trong khi ngăn xếp chưa trống: Lấy một phòng ra. Với mỗi chìa khóa trong phòng đó: Nếu phòng tương ứng chưa được tham quan, đánh dấu đã tham quan và đẩy vào ngăn xếp.*

4.  **Check Result:** After traversal, count how many rooms were visited. If count equals `n`, return `true`.
    *   **Kiểm tra kết quả:** Sau khi duyệt, đếm số phòng đã tham quan. Nếu bằng `n`, trả về `true`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    boolean[] visited = new boolean[rooms.size()];
    visited[0] = true;
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    int count = 1;

    while (!stack.isEmpty()) {
        int node = stack.pop();
        for (int next : rooms.get(node)) {
            if (!visited[next]) {
                visited[next] = true;
                stack.push(next);
                count++;
            }
        }
    }
    return count == rooms.size();
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N + E)$, where $N$ is the number of rooms and $E$ is the total number of keys. Each room and each key are processed at most once.
    *   **Độ phức tạp thời gian:** $O(N + E)$, với $N$ là số phòng và $E$ là tổng số chìa khóa.*
*   **Space Complexity:** $O(N)$ for the `visited` array and the stack used for traversal.
    *   **Độ phức tạp không gian:** $O(N)$ cho mảng `visited` và ngăn xếp.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simple graph traversal is the most effective way to solve connectivity problems. DFS is often slightly easier to implement recursively, but iterative BFS/DFS is safer against stack overflow for very large graphs.
*Duyệt đồ thị đơn giản là cách hiệu quả nhất để giải các bài toán về tính liên thông. DFS thường dễ triển khai bằng đệ quy hơn, nhưng BFS/DFS lặp sẽ an toàn hơn trước lỗi tràn ngăn xếp với đồ thị lớn.*
