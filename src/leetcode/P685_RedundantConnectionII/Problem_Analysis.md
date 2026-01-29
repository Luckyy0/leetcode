# 685. Redundant Connection II / Kết nối Dư thừa II

## Problem Description / Mô tả bài toán
In this problem, a rooted tree is a **directed graph** such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.
Trong bài toán này, một cây có gốc là một **đồ thị có hướng** sao cho có đúng một nút (gốc) mà tất cả các nút khác đều là con cháu của nút này, cộng với mọi nút đều có chính xác một nút cha, ngoại trừ nút gốc không có cha.

The graph given is a directed graph that started as a rooted tree with `n` nodes labeled from 1 to `n`, with one additional directed edge added.
Đồ thị được đưa ra là một đồ thị có hướng bắt đầu như một cây có gốc với `n` nút được đánh số từ 1 đến `n`, với một cạnh có hướng bổ sung được thêm vào.

Return an edge that can be removed so that the resulting graph is a rooted tree of `n` nodes. If there are multiple answers, return the answer that occurs last in the input.
Trả về một cạnh có thể được loại bỏ để đồ thị kết quả là một cây có gốc gồm `n` nút. Nếu có nhiều câu trả lời, hãy trả về câu trả lời xuất hiện cuối cùng trong đầu vào.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Directed Graph Anomalies / Bất thường trong Đồ thị có hướng
The addition of an edge to a tree creates one of two situations (or both):
Việc thêm một cạnh vào cây tạo ra một trong hai tình huống (hoặc cả hai):

1. **A node has two parents** (two edges point into it).
Một nút có hai cha (hai cạnh trỏ vào nó).
2. **A cycle is created**.
Một chu trình được tạo ra.

Algorithm:
- Check for a node with two parents. Let the two competing edges be `edge1` and `edge2`.
- Test if removing `edge2` resolves the cycle (using Union-Find).
- If no node has two parents, then a simple cycle exists; find the redundant edge using standard Union-Find.

### Complexity / Độ phức tạp
- **Time**: O(N * α(N)).
- **Space**: O(N) for DSU and parent tracking.

---

## Analysis / Phân tích

### Approach: Multi-case DSU
Identify potential parents conflict. If found, test cycle detection with one of the candidates temporarily disabled. If no conflict exists, the last edge creating a cycle is the culprit.
Xác định xung đột nút cha tiềm năng. Nếu tìm thấy, hãy kiểm tra phát hiện chu trình với một trong các ứng viên bị vô hiệu hóa tạm thời. Nếu không có xung đột, cạnh cuối cùng tạo ra chu trình là thủ phạm.

---
