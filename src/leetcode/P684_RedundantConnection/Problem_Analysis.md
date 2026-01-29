# 684. Redundant Connection / Kết nối Dư thừa

## Problem Description / Mô tả bài toán
In this problem, a tree is an **undirected graph** that is connected and has no cycles.
Trong bài toán này, một cây là một **đồ thị vô hướng** được kết nối và không có chu kỳ.

You are given a graph that started as a tree with `n` nodes labeled from 1 to `n`, with one additional edge added. The added edge has two different vertices chosen from 1 to `n`, and was not an edge that already existed. The graph is represented as an array `edges` of length `n` where `edges[i] = [ai, bi]` indicates that there is an edge between nodes `ai` and `bi` in the graph.
Bạn được cho một đồ thị bắt đầu như một cây có `n` nút được đánh số từ 1 đến `n`, với một cạnh bổ sung được thêm vào. Cạnh được thêm vào có hai đỉnh khác nhau được chọn từ 1 đến `n` và không phải là một cạnh đã tồn tại. Đồ thị được biểu diễn dưới dạng một mảng `edges` có độ dài `n` trong đó `edges[i] = [ai, bi]` cho biết có một cạnh giữa các nút `ai` và `bi` trong đồ thị.

Return an edge that can be removed so that the resulting graph is a tree of `n` nodes. If there are multiple answers, return the answer that occurs last in the input.
Trả về một cạnh có thể được loại bỏ để đồ thị kết quả là một cây có `n` nút. Nếu có nhiều câu trả lời, hãy trả về câu trả lời xuất hiện cuối cùng trong đầu vào.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Union-Find / Tìm kiếm Tập hợp rời nhau
Union-Find is an ideal data structure for detecting cycles in an undirected graph.
Union-Find là một cấu trúc dữ liệu lý tưởng để phát hiện các chu trình trong đồ thị vô hướng.

Initially, each node belongs to its own set. For each edge `(u, v)`, we check if `u` and `v` are already in the same set.
Ban đầu, mỗi nút thuộc về tập hợp của chính nó. Đối với mỗi cạnh `(u, v)`, chúng ta kiểm tra xem `u` và `v` đã nằm trong cùng một tập hợp chưa.

- If they are, then this edge creates a cycle and is redundant.
- If they are not, we union the sets of `u` and `v`.

### Complexity / Độ phức tạp
- **Time**: O(N * α(N)), where α is the inverse Ackermann function (nearly constant).
- **Space**: O(N) to store parents in the Union-Find structure.

---

## Analysis / Phân tích

### Approach: Disjoint Set Union (DSU)
Iterate through the edges from start to finish. Use DSU to join the vertices. The first edge encountered that connects two vertices already in the same component is the redundant edge that closes a cycle.
Lặp lại qua các cạnh từ đầu đến cuối. Sử dụng DSU để nối các đỉnh. Cạnh đầu tiên gặp phải kết nối hai đỉnh đã ở trong cùng một thành phần là cạnh dư thừa tạo thành chu trình.

---
