# Result for Kth Smallest Element in a BST
# *Kết quả cho bài toán Phần tử nhỏ thứ K trong BST*

## Description
## *Mô tả*

Given the `root` of a binary search tree, and an integer `k`, return *the* `k`*th smallest value (**1-indexed**) of all the values of the nodes in the tree*.
*Cho `root` của một cây tìm kiếm nhị phân, và một số nguyên `k`, hãy trả về *giá trị nhỏ thứ `k` (**chỉ số bắt đầu từ 1**) trong tất cả các giá trị của các nút trong cây*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [3,1,4,null,2], k = 1`
**Output:** `1`

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [5,3,6,2,4,null,null,1], k = 3`
**Output:** `3`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is `n`.
*   `1 <= k <= n <= 10^4`
*   `0 <= Node.val <= 10^4`

**Follow up:** If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
**Câu hỏi mở rộng:** Nếu BST thường xuyên bị sửa đổi (tức là chúng ta có thể thực hiện các thao tác chèn và xóa) và bạn cần tìm phần tử nhỏ thứ k thường xuyên, bạn sẽ tối ưu hóa như thế nào?
