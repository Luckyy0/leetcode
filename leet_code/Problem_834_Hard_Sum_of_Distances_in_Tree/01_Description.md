# Result for Sum of Distances in Tree
# *Kết quả cho bài toán Tổng khoảng cách trong Cây*

## Description
## *Mô tả*

There is an undirected, connected tree with `n` nodes labeled from `0` to `n - 1` and `n - 1` edges.
*Có một cây vô hướng, kết nối với `n` nút được gắn nhãn từ `0` đến `n - 1` và có `n - 1` cạnh.*

You are given the integer `n` and the array `edges` where `edges[i] = [ai, bi]` indicates that there is an edge between nodes `ai` and `bi` in the tree.
*Bạn được cho số nguyên `n` và mảng `edges` trong đó `edges[i] = [ai, bi]` cho biết có một cạnh giữa các nút `ai` và `bi` trong cây.*

Return *an array `ans` of length `n` where `ans[i]` is the sum of the distances between the `i`-th node and all other nodes in the tree*.
*Trả về *một mảng `ans` độ dài `n` trong đó `ans[i]` là tổng khoảng cách giữa nút thứ `i` và tất cả các nút khác trong cây*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
**Output:** [8,12,6,10,10,10]
**Explanation:** The tree is shown above.
We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
= 1 + 1 + 2 + 2 + 2 = 8.
Similarly, dist(2,0) + dist(2,1) + dist(2,3) + dist(2,4) + dist(2,5)
= 1 + 2 + 1 + 1 + 1 = 6.

## Example 2:
## *Ví dụ 2:*

**Input:** n = 1, edges = []
**Output:** [0]

## Example 3:
## *Ví dụ 3:*

**Input:** n = 2, edges = [[1,0]]
**Output:** [1,1]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 3 * 10^4`
*   `edges.length == n - 1`
*   `edges[i].length == 2`
*   `0 <= ai, bi < n`
*   `ai != bi`
*   The given input represents a valid tree.
