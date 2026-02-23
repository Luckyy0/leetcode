# Result for Number of Connected Components in an Undirected Graph
# *Kết quả cho bài toán Số lượng Thành phần Liên thông trong Đồ thị Vô hướng*

## Description
## *Mô tả*

You have a graph of `n` nodes. You are given an integer `n` and an array `edges` where `edges[i] = [ai, bi]` indicates that there is an edge between `ai` and `bi` in the graph.
*Bạn có một đồ thị gồm `n` nút. Bạn được cho một số nguyên `n` và một mảng `edges` trong đó `edges[i] = [ai, bi]` chỉ ra rằng có một cạnh giữa `ai` và `bi` trong đồ thị.*

Return *the number of connected components in the graph*.
*Trả về *số lượng thành phần liên thông trong đồ thị*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 5, edges = [[0,1],[1,2],[3,4]]`
**Output:** `2`

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 2000`
*   `1 <= edges.length <= 5000`
*   `edges[i].length == 2`
*   `0 <= ai <= bi < n`
*   `ai != bi`
*   There are no repeated edges.
