# 332. Reconstruct Itinerary / Tái Tạo Lịch Trình

## Problem Description / Mô tả bài toán
You are given a list of airline `tickets` where `tickets[i] = [from_i, to_i]` represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.
Bạn được cung cấp một danh sách vé máy bay `tickets`. Tái tạo lịch trình theo thứ tự và trả lại nó.

All of the tickets belong to a man who departs from `"JFK"`, thus, the itinerary must begin with `"JFK"`. If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
Tất cả vé thuộc về một người khởi hành từ `"JFK"`, do đó, lịch trình phải bắt đầu bằng `"JFK"`. Nếu có nhiều vé hợp lệ, trả về vé có thứ tự từ điển nhỏ nhất.

- For example, the itinerary `["JFK", "LGA"]` has a smaller lexical order than `["JFK", "LGB"]`.

You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
Bạn có thể giả định tất cả các vé tạo thành ít nhất một lịch trình hợp lệ. Bạn phải sử dụng tất cả các vé.

### Example 1:
```text
Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
Output: ["JFK","MUC","LHR","SFO","SJC"]
```

### Example 2:
```text
Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"], but it is larger in lexical order.
```

## Constraints / Ràng buộc
- `1 <= tickets.length <= 300`
- `tickets[i].length == 2`
- `from_i.length == 3`, `to_i.length == 3`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Eulerian Path (Hierholzer's Algorithm) / Đường Euler
We need to traverse all edges exactly once. This is finding an Eulerian path in a directed graph.
Since start is fixed at "JFK" and a valid itinerary is guaranteed, we can use DFS (Hierholzer's).
To satisfy lexical order, we visit neighbors in lexical order.

**Algorithm**:
1.  Build Graph: `Map<String, PriorityQueue<String>>`. PQ ensures lexical order.
2.  `dfs(node)`:
    - While `graph.get(node)` is not empty:
        - `next = graph.get(node).poll()`. (Remove edge).
        - `dfs(next)`.
    - `result.addFirst(node)`. (Add to result AFTER visiting children - Post-order).
3.  Initial call: `dfs("JFK")`.
4.  Result is built in reverse order (or addFirst). The post-order traversal works because strictly traversing until stuck means we finished a cycle or reached the end of a non-cycle component. Backtracking fills the main path.

### Complexity / Độ phức tạp
- **Time**: `O(E log E)` due to sorting edges (PriorityQueue). E is number of tickets.
- **Space**: `O(E)`.

---

## Analysis / Phân tích

### Approach: Hierholzer's Algorithm DFS

**Algorithm**:
1.  Map `adj`.
2.  Populate `adj` with PQ.
3.  `LinkedList result`.
4.  `visit("JFK")`.

---
