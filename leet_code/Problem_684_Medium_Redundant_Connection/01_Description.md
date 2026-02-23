# Result for Redundant Connection
# *Kết quả cho bài toán Kết nối Dư thừa*

## Description
## *Mô tả*

In this problem, a tree is an **undirected graph** that is connected and has no cycles.
*Trong bài toán này, một cây là một **đồ thị vô hướng** liên thông và không có chu trình.*

You are given a graph that started as a tree with `n` nodes denoted from `1` to `n`, with one additional edge added. The added edge has two different vertices chosen from `1` to `n`, and was not an edge that already existed. The graph is represented as an array `edges` of length `n` where `edges[i] = [ai, bi]` indicates that there is an edge between nodes `ai` and `bi` in the graph.
*Bạn được cho một đồ thị ban đầu là một cây với `n` nút được ký hiệu từ `1` đến `n`, với một cạnh bổ sung được thêm vào. Cạnh được thêm vào có hai đỉnh khác nhau được chọn từ `1` đến `n`, và không phải là một cạnh đã tồn tại. Đồ thị được biểu diễn dưới dạng một mảng `edges` có độ dài `n` trong đó `edges[i] = [ai, bi]` cho biết có một cạnh giữa các nút `ai` và `bi` trong đồ thị.*

Return an edge that can be removed so that the resulting graph is a tree of `n` nodes. If there are multiple answers, return the answer that occurs last in the input.
*Hãy trả về một cạnh có thể được loại bỏ để đồ thị kết quả là một cây gồm `n` nút. Nếu có nhiều đáp án, hãy trả về đáp án xuất hiện cuối cùng trong đầu vào.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** edges = [[1,2],[1,3],[2,3]]
**Output:** [2,3]

## Example 2:
## *Ví dụ 2:*

**Input:** edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
**Output:** [1,4]

---

## Constraints:
## *Ràng buộc:*

*   `n == edges.length`
*   `3 <= n <= 1000`
*   `edges[i].length == 2`
*   `1 <= ai < bi <= edges.length`
*   `ai != bi`
*   There are no repeated edges.
*   The given graph is connected.
