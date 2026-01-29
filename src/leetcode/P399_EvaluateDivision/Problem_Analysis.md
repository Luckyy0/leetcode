# 399. Evaluate Division / Đánh Giá Phép Chia

## Problem Description / Mô tả bài toán
You are given an array of variable pairs `equations` and an array of real numbers `values`, where `equations[i] = [Ai, Bi]` and `values[i]` represent the equation `Ai / Bi = values[i]`. Each `Ai` or `Bi` is a string that represents a single variable.
Bạn được cho một mảng các cặp biến `equations` và một mảng các số thực `values`, trong đó `equations[i] = [Ai, Bi]` và `values[i]` đại diện cho phương trình `Ai / Bi = values[i]`. Mỗi `Ai` hoặc `Bi` là một chuỗi đại diện cho một biến duy nhất.

You are also given some `queries`, where `queries[j] = [Cj, Dj]` represents the `j-th` query where you must find the answer for `Cj / Dj = ?`.
Bạn cũng được cho một số `queries`, trong đó `queries[j] = [Cj, Dj]` đại diện cho truy vấn thứ `j` mà bạn phải tìm câu trả lời cho `Cj / Dj = ?`.

Return the answers to all queries. If a single answer cannot be determined, return `-1.0`.
Hãy trả về câu trả lời cho tất cả các truy vấn. Nếu không thể xác định được một câu trả lời duy nhất, hãy trả về `-1.0`.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
Lưu ý: Đầu vào luôn hợp lệ. Bạn có thể giả định rằng việc đánh giá các truy vấn sẽ không dẫn đến việc chia cho số không và không có sự mâu thuẫn.

### Example 1:
```text
Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
```

## Constraints / Ràng buộc
- `1 <= equations.length <= 20`
- `equations[i].length == 2`
- `Ai.length, Bi.length <= 5`
- `values.length == equations.length`
- `0.0 < values[i] <= 20.0`
- `1 <= queries.length <= 20`
- `queries[i].length == 2`
- `Cj.length, Dj.length <= 5`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Graph + DFS/BFS / Đồ thị + Duyệt theo chiều sâu/chiều rộng
We can represent the variables and their relationships as a directed, weighted graph.
Each variable is a node. For `A / B = v`:
- Edge `A -> B` with weight `v`.
- Edge `B -> A` with weight `1/v`.

To evaluate `C / D`:
- Find a path from `C` to `D`.
- The result is the product of weights along the path.
- If no path exists, return `-1.0`.

### Complexity / Độ phức tạp
- **Time**:
    - Building graph: O(E) where E is the number of equations.
    - Answering queries: O(Q * (V + E)) where Q is queries, V is variables. Since constraints are very small (20 equations, 20 queries), this is very fast.
- **Space**: O(V + E).

---

## Analysis / Phân tích

### Approach: Graph DFS

**Algorithm**:
1.  Build an adjacency list `graph`: `Map<String, Map<String, Double>>`.
2.  For each query `start, end`:
    - If `start` or `end` not in graph, return `-1.0`.
    - If `start == end`, return `1.0`.
    - Perform DFS to find `end` starting from `start`, tracking cumulative product.
    - Keep a `visited` set to avoid cycles.
3.  Store results in array.

---
