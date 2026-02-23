# Analysis for Clone Graph
# *Phân tích cho bài toán Sao Chép Đồ Thị*

## 1. Problem Core: Deep Copy vs. Shallow Copy
## *1. Cốt Lõi Vấn Đề: Bản Sao Sâu so với Bản Sao Nông*

### What is a Deep Copy?
### *Bản Sao Sâu Là Gì?*
*   A shallow copy only copies the references to the original nodes. If you modify a node in a shallow copy, the original graph is affected.
    *Bản sao nông chỉ sao chép các tham chiếu đến các nút ban đầu. Nếu bạn sửa đổi một nút trong bản sao nông, đồ thị ban đầu sẽ bị ảnh hưởng.*
*   A deep copy requires creating entirely new instances of every `Node` and recreating all edges (neighbor lists) such that the new graph is structurally identical but memory-independent from the original.
    *Bản sao sâu yêu cầu tạo các phiên bản hoàn toàn mới của mọi `Node` và tái tạo tất cả các cạnh (danh sách nút lân cận) sao cho đồ thị mới giống hệt về mặt cấu trúc nhưng độc lập về bộ nhớ với đồ thị ban đầu.*

### The Cyclic Challenge
### *Thử Thách Về Chu Trình*
*   Graphs often contain cycles (e.g., node 1 points to 2, and 2 points back to 1). If we don't track which nodes we have already cloned, we will fall into an infinite recursion or loop.
    *Đồ thị thường chứa các chu trình (ví dụ: nút 1 trỏ đến 2, và 2 trỏ ngược lại 1). Nếu chúng ta không theo dõi những nút nào đã được sao chép, chúng ta sẽ rơi vào vòng lặp hoặc đệ quy vô hạn.*

---

## 2. Approach: BFS or DFS with HashMap
## *2. Hướng Tiếp Cận: BFS hoặc DFS với HashMap*

The key to solving this problem is a **Mapping** between original nodes and their clones.
*Chìa khóa để giải quyết vấn đề này là một **Ánh xạ (Mapping)** giữa các nút gốc và bản sao của chúng.*

### Logic (using BFS)
### *Logic (sử dụng BFS)*
1.  Use a `HashMap<Node, Node> visited` where the key is the original node and the value is its cloned counterpart.
    *Sử dụng một `HashMap<Node, Node> visited` trong đó khóa là nút gốc và giá trị là bản sao tương ứng của nó.*
2.  Start BFS from the given `node`.
    -   Create a clone of the initial node and add it to the map: `visited.put(node, new Node(node.val))`.
    -   Add the original `node` to a `Queue`.
3.  While the queue is not empty:
    -   Pop the current original node `u`.
    -   For each `neighbor` of `u`:
        -   If `neighbor` has **not** been visited (not in the map):
            1.  Clone it: `visited.put(neighbor, new Node(neighbor.val))`.
            2.  Add it to the `Queue`.
        -   Add the cloned neighbor to the cloned version of `u`: `visited.get(u).neighbors.add(visited.get(neighbor))`.
            *Thêm nút lân cận đã sao chép vào phiên bản sao chép của `u`.*

---

## 3. Structural Nuances: Why HashMap?
## *3. Sắc Thái Cấu Trúc: Tại Sao Dùng HashMap?*

The `HashMap` serves two purposes:
*`HashMap` phục vụ hai mục đích:*
1.  **Tracking Visited Nodes:** It prevents infinite loops by knowing if a node has already been created.
    *Theo dõi các nút đã truy cập: Nó ngăn chặn các vòng lặp vô hạn bằng cách biết liệu một nút đã được tạo hay chưa.*
2.  **Lookup:** It allows us to quickly find the cloned version of any original node so we can link it as a neighbor.
    *Tra cứu: Nó cho phép chúng ta nhanh chóng tìm thấy phiên bản sao chép của bất kỳ nút gốc nào để chúng ta có thể liên kết nó như một nút lân cận.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N + E)$, where $N$ is the number of nodes (vertices) and $E$ is the number of edges. We visit each node and each edge exactly once.
    *Độ phức tạp thời gian: $O(N + E)$, trong đó $N$ là số lượng nút và $E$ là số lượng cạnh. Chúng ta truy cập mỗi nút và mỗi cạnh đúng một lần.*
*   **Space Complexity:** $O(N)$. We need the `HashMap` to store all $N$ nodes and their clones. Additionally, the BFS queue can grow up to $O(N)$.
    *Độ phức tạp không gian: $O(N)$. Chúng ta cần `HashMap` để lưu trữ tất cả $N$ nút và bản sao của chúng. Ngoài ra, hàng đợi BFS có thể tăng lên đến $O(N)$.*

---

## 5. Summary Recommendation
## *5. Khuyến nghị tổng kết*

Both BFS and DFS work perfectly for this problem. BFS is often slightly more intuitive for "cloning" level-by-level, while DFS is shorter code-wise if done recursively. The use of a `Map` is mandatory to handle cycles. This is a foundational graph problem that tests your understanding of object references and graph traversal.
*Cả BFS và DFS đều hoạt động hoàn hảo cho bài toán này. BFS thường trực quan hơn một chút để "sao chép" theo từng tầng, trong đó DFS có mã ngắn hơn nếu thực hiện theo kiểu đệ quy. Việc sử dụng `Map` là bắt buộc để xử lý các chu trình. Đây là một bài toán đồ thị cơ bản kiểm tra sự hiểu biết của bạn về tham chiếu đối tượng và duyệt đồ thị.*
---
*Việc tạo ra một bản sao hoàn chỉnh đòi hỏi sự trung thành tuyệt đối với mọi liên kết cũ trong một thực thể mới.*
Creating a complete copy requires absolute fidelity to every old link within a new entity.
