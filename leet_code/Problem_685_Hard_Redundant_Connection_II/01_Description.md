# Result for Redundant Connection II
# *Kết quả cho bài toán Kết nối Dư thừa II*

## Description
## *Mô tả*

In this problem, a rooted tree is a **directed graph** such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.
*Trong bài toán này, một cây có gốc là một **đồ thị có hướng** sao cho, có đúng một nút (gốc) mà tất cả các nút khác đều là hậu duệ của nút này, cộng với việc mỗi nút đều có đúng một cha, ngoại trừ nút gốc không có cha.*

The given graph started as a rooted tree with `n` nodes (with values from `1` to `n`), with one additional directed edge added. The added edge has two different vertices chosen from `1` to `n`, and was not an edge that already existed.
*Đồ thị đã cho ban đầu là một cây có gốc với `n` nút (với các giá trị từ `1` đến `n`), với một cạnh có hướng bổ sung được thêm vào. Cạnh được thêm vào có hai đỉnh khác nhau được chọn từ `1` đến `n`, và không phải là một cạnh đã tồn tại.*

The graph is represented as a 2D-array `edges`. Each element of `edges` is a pair `[ui, vi]` that represents a **directed** edge connecting node `ui` to node `vi`, where `ui` is a parent of child `vi`.
*Đồ thị được biểu diễn dưới dạng mảng 2D `edges`. Mỗi phần tử của `edges` là một cặp `[ui, vi]` đại diện cho một cạnh **có hướng** kết nối nút `ui` với nút `vi`, trong đó `ui` là cha của con `vi`.*

Return an edge that can be removed so that the resulting graph is a rooted tree of `n` nodes. If there are multiple answers, return the answer that occurs last in the input.
*Hãy trả về một cạnh có thể được loại bỏ để đồ thị kết quả là một cây có gốc gồm `n` nút. Nếu có nhiều đáp án, hãy trả về đáp án xuất hiện cuối cùng trong đầu vào.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** edges = [[1,2],[1,3],[2,3]]
**Output:** [2,3]

## Example 2:
## *Ví dụ 2:*

**Input:** edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
**Output:** [4,1]

---

## Constraints:
## *Ràng buộc:*

*   `n == edges.length`
*   `3 <= n <= 1000`
*   `edges[i].length == 2`
*   `1 <= ui, vi <= n`
*   `ui != vi`
