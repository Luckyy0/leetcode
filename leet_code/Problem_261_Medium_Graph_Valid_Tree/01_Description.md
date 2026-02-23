# Result for Graph Valid Tree
# *Kết quả cho bài toán Cây hợp lệ trong đồ thị*

## Description
## *Mô tả*

You have a graph of `n` nodes labeled from `0` to `n - 1`. You are given an integer `n` and a list of `edges` where `edges[i] = [a_i, b_i]` indicates that there is an undirected edge between nodes `a_i` and `b_i` in the graph.
*Bạn có một đồ thị gồm `n` nút được dán nhãn từ `0` đến `n - 1`. Bạn được cho một số nguyên `n` và một danh sách `edges` trong đó `edges[i] = [a_i, b_i]` chỉ ra rằng có một cạnh vô hướng giữa các nút `a_i` và `b_i` trong đồ thị.*

Return `true` *if the edges of the given graph make up a valid tree, and* `false` *otherwise*.
*Trả về `true` *nếu các cạnh của đồ thị đã cho tạo thành một cây hợp lệ, và* `false` *nếu không*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]`
**Output:** `true`

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]`
**Output:** `false`

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 2000`
*   `0 <= edges.length <= 5000`
*   `edges[i].length == 2`
*   `0 <= a_i, b_i < n`
*   `a_i != b_i`
*   There are no self-loops or repeated edges.
