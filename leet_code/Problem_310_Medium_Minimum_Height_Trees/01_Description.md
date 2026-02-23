# Result for Minimum Height Trees
# *Kết quả cho bài toán Cây có Chiều cao Tối thiểu*

## Description
## *Mô tả*

A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.
*Một cây là một đồ thị vô hướng trong đó bất kỳ hai đỉnh nào cũng được kết nối bằng chính xác một đường đi. Nói cách khác, bất kỳ đồ thị liên thông nào không có chu trình đơn là một cây.*

Given a tree of `n` nodes labelled from `0` to `n - 1`, and an array of `n - 1` `edges` where `edges[i] = [ai, bi]` indicates that there is an undirected edge between the two nodes `ai` and `bi` in the tree, you can choose any node of the tree as the root. When you select a node `x` as the root, the result tree has height `h`. Among all possible rooted trees, those with minimum height (i.e. `min(h)`)  are called **minimum height trees** (MHTs).
*Cho một cây gồm `n` nút được dán nhãn từ `0` đến `n - 1`, và một mảng gồm `n - 1` `edges` trong đó `edges[i] = [ai, bi]` chỉ ra rằng có một cạnh vô hướng giữa hai nút `ai` và `bi` trong cây, bạn có thể chọn bất kỳ nút nào của cây làm gốc. Khi bạn chọn một nút `x` làm gốc, cây kết quả có chiều cao `h`. Trong số tất cả các cây có gốc có thể, những cây có chiều cao tối thiểu (tức là `min(h)`) được gọi là **cây có chiều cao tối thiểu** (MHTs).*

Return *a list of all **MHTs'** root labels*. You can return the answer in **any order**.
*Trả về *một danh sách tất cả các nhãn gốc của **MHTs***. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.*

The **height** of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
***Chiều cao** của một cây có gốc là số cạnh trên đường đi xuống dài nhất giữa gốc và một lá.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 4, edges = [[1,0],[1,2],[1,3]]`
**Output:** `[1]`
**Explanation:** As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]`
**Output:** `[3,4]`

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 2 * 10^4`
*   `edges.length == n - 1`
*   `0 <= ai, bi < n`
*   `ai != bi`
*   All the pairs `(ai, bi)` are distinct.
*   The given input is **guaranteed** to be a tree and there will be **no repeated** edges.
