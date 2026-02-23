# Result for All Paths From Source to Target
# *Kết quả cho bài toán Tất cả các đường đi từ Nguồn đến Đích*

## Description
## *Mô tả*

Given a directed acyclic graph (DAG) of `n` nodes labeled from `0` to `n - 1`, find all possible paths from node `0` to node `n - 1` and return them in **any order**.
*Cho một đồ thị có hướng không chu trình (DAG) gồm `n` nút được đánh số từ `0` đến `n - 1`, hãy tìm tất cả các đường đi có thể từ nút `0` đến nút `n - 1` và trả về chúng theo **thứ tự bất kỳ**.*

The graph is given as follows: `graph[i]` is a list of all nodes you can visit from node `i` (i.e., there is a directed edge from node `i` to node `graph[i][j]`).
*Đồ thị được cho như sau: `graph[i]` là danh sách tất cả các nút bạn có thể đến từ nút `i` (nghĩa là có một cạnh có hướng từ nút `i` đến nút `graph[i][j]`).*

---

## Example 1:
## *Ví dụ 1:*

**Input:** graph = [[1,2],[3],[3],[]]
**Output:** [[0,1,3],[0,2,3]]
**Explanation:** There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

## Example 2:
## *Ví dụ 2:*

**Input:** graph = [[4,3,1],[3,2,4],[3],[4],[]]
**Output:** [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]

---

## Constraints:
## *Ràng buộc:*

*   `n == graph.length`
*   `2 <= n <= 15`
*   `0 <= graph[i][j] < n`
*   `graph[i][j] != i` (no self-loops)
*   The input graph is guaranteed to be a **DAG**.
