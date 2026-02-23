# Result for Paint House II
# *Kết quả cho bài toán Sơn nhà II*

## Description
## *Mô tả*

There are a row of `n` houses, each house can be painted with one of the `k` colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
*Có một dãy `n` ngôi nhà, mỗi ngôi nhà có thể được sơn một trong `k` màu. Chi phí sơn mỗi ngôi nhà với một màu nhất định là khác nhau. Bạn phải sơn tất cả các ngôi nhà sao cho không có hai ngôi nhà liền kề nào có cùng màu.*

The cost of painting each house with a certain color is represented by an `n x k` cost matrix costs.
*Chi phí sơn mỗi ngôi nhà với một màu nhất định được biểu thị bằng ma trận chi phí `n x k` costs.*

*   For example, `costs[0][0]` is the cost of painting house 0 with color 0; `costs[1][2]` is the cost of painting house 1 with color 2, and so on...

Return *the minimum cost to paint all houses*.
*Trả về *chi phí tối thiểu để sơn tất cả các ngôi nhà*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `costs = [[1,5,3],[2,9,4]]`
**Output:** `5`
**Explanation:**
Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5; 
Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.

## Example 2:
## *Ví dụ 2:*

**Input:** `costs = [[1,3],[2,4]]`
**Output:** `5`

## Constraints:
## *Ràng buộc:*

*   `costs.length == n`
*   `costs[i].length == k`
*   `1 <= n <= 100`
*   `1 <= k <= 20`
*   `1 <= costs[i][j] <= 20`

**Follow up:** Could you solve it in `O(nk)` runtime?
**Câu hỏi mở rộng:** Bạn có thể giải quyết nó trong thời gian chạy `O(nk)` không?
