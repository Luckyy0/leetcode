# Result for Network Delay Time
# *Kết quả cho bài toán Thời gian Trễ Mạng (Network Delay Time)*

## Description
## *Mô tả*

You are given a network of `n` nodes, labeled from `1` to `n`. You are also given `times`, a list of travel times as directed edges `times[i] = (ui, vi, wi)`, where `ui` is the source node, `vi` is the target node, and `wi` is the time it takes for a signal to travel from source to target.
*Bạn được cho một mạng lưới gồm `n` nút, được đánh số từ `1` đến `n`. Bạn cũng được cho `times`, một danh sách các thời gian di chuyển dưới dạng các cạnh có hướng `times[i] = (ui, vi, wi)`, trong đó `ui` là nút nguồn, `vi` là nút đích, và `wi` là thời gian cần thiết để tín hiệu truyền từ nguồn đến đích.*

We will send a signal from a given node `k`. Return the time it takes for all the `n` nodes to receive the signal. If it is impossible for all the `n` nodes to receive the signal, return `-1`.
*Chúng ta sẽ gửi một tín hiệu từ một nút `k` đã cho. Hãy trả về thời gian cần thiết để tất cả `n` nút nhận được tín hiệu. Nếu không thể để tất cả `n` nút nhận được tín hiệu, hãy trả về `-1`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
**Output:** 2
**Explanation:** 
- Node 2 sends signal to 1 and 3 (time 1).
- Node 3 sends signal to 4 (time 1).
- Total time for 4 to receive is 1 + 1 = 2.
- Total time implies the maximum of the shortest paths to all nodes.

## Example 2:
## *Ví dụ 2:*

**Input:** times = [[1,2,1]], n = 2, k = 1
**Output:** 1

## Example 3:
## *Ví dụ 3:*

**Input:** times = [[1,2,1]], n = 2, k = 2
**Output:** -1

---

## Constraints:
## *Ràng buộc:*

*   `1 <= k <= n <= 100`
*   `1 <= times.length <= 6000`
*   `times[i].length == 3`
*   `1 <= ui, vi <= n`
*   `ui != vi`
*   `0 <= wi <= 100`
*   All the pairs `(ui, vi)` are **unique**.
