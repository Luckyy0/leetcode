# Result for Closest Binary Search Tree Value II
# *Kết quả cho bài toán Giá trị Cây tìm kiếm nhị phân gần nhất II*

## Description
## *Mô tả*

Given the `root` of a binary search tree, a `target` value, and an integer `k`, return *the* `k` *values in the BST that are closest to the* `target`. You may return the answer in **any order**.
*Cho `root` của một cây tìm kiếm nhị phân, một giá trị `target`, và một số nguyên `k`, hãy trả về `k` *giá trị trong BST gần nhất với* `target`. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.*

You are guaranteed that there are only `k` closest values.
*Bạn được đảm bảo rằng chỉ có `k` giá trị gần nhất.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [4,2,5,1,3], target = 3.714286, k = 2`
**Output:** `[4,3]`

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [1], target = 0.000000, k = 1`
**Output:** `[1]`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is `n`.
*   `1 <= k <= n <= 10^4`
*   `0 <= Node.val <= 10^9`
*   `-10^9 <= target <= 10^9`

**Follow up:** Assume that the BST is balanced. Could you solve it in less than `O(n)` runtime (where `n = total nodes`)?
**Câu hỏi mở rộng:** Giả sử rằng BST đã cân bằng. Bạn có thể giải quyết nó trong thời gian chạy ít hơn `O(n)` không (trong đó `n = tổng số nút`)?
