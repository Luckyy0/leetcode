# 133. Clone Graph / Sao Chép Đồ Thị

## Problem Description / Mô tả bài toán
Given a reference of a node in a connected undirected graph, return a **deep copy** (clone) of the graph.
Cho một tham chiếu của một nút trong một đồ thị vô hướng liên thông, hãy trả về một **bản sao sâu** (clone) của đồ thị đó.

Each node in the graph contains a value (`int`) and a list (`List[Node]`) of its neighbors.
Mỗi nút trong đồ thị chứa một giá trị (`int`) và một danh sách các nút láng giềng (`List[Node]`).

```java
class Node {
    public int val;
    public List<Node> neighbors;
}
```

### Example 1:
```text
Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: There are 4 nodes in the graph.
1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
...
```

## Constraints / Ràng buộc
- The number of nodes in the graph is in the range `[0, 100]`.
- `1 <= Node.val <= 100`
- `Node.val` is unique for each node.
- There are no repeated edges and no self-loops in the graph.
- The Graph is connected and all nodes can be visited starting from the given node.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Deep Copy vs Shallow Copy / Sao chép Sâu vs Sao chép Nông
A deep copy means we must create entirely new instances of all nodes and their neighbor lists, rather than just copying references.
Một bản sao sâu có nghĩa là chúng ta phải tạo ra các phiên bản hoàn toàn mới của tất cả các nút và danh sách láng giềng của chúng, thay vì chỉ sao chép các tham chiếu.

### Graph Traversal with Mapping / Duyệt Đồ thị với Bản đồ
To correctly clone a graph, we need to keep track of nodes we have already visited and their corresponding clones:
Để sao chép đồ thị một cách chính xác, chúng ta cần theo dõi các nút đã được duyệt và các bản sao tương ứng của chúng:
1.  Use a **Map (HashMap)** where the key is the original node and the value is the cloned node.
2.  Traverse the graph using **DFS or BFS**.
3.  For each node:
    - If it's already in the Map, return the cloned node.
    - If not, create a new clone, add it to the Map, and then recursively (DFS) or iteratively (BFS) clone its neighbors.

---

## Analysis / Phân tích

### Approach: DFS with HashMap / DFS kết hợp HashMap

**Complexity / Độ phức tạp**:
- **Time**: O(V + E) - where V is the number of vertices and E is the number of edges.
- **Space**: O(V) - to store the mapping of all nodes and the recursion stack.

---

## Edge Cases / Các trường hợp biên
1.  **Empty Graph**: Given node is `null`.
2.  **Single Node**: Node with no neighbors.
3.  **Cyclic Graph**: Handle cycles using the visited map.
