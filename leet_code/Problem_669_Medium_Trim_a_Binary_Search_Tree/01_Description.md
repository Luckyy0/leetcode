# Result for Trim a Binary Search Tree
# *Kết quả cho bài toán Cắt tỉa Cây Nhị phân Tìm kiếm*

## Description
## *Mô tả*

Given the `root` of a binary search tree and the lowest and highest boundaries as `low` and `high`, trim the tree so that all its elements lies in `[low, high]`.
*Cho gốc `root` của một cây nhị phân tìm kiếm (BST) và các ranh giới thấp nhất và cao nhất `low` và `high`, hãy cắt tỉa cây sao cho tất cả các phần tử của nó nằm trong `[low, high]`.*

Trimming the tree should **not** change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a **unique answer**.
*Việc cắt tỉa cây **không được** làm thay đổi cấu trúc tương đối của các phần tử còn lại (tức là bất kỳ hậu duệ nào của một nút vẫn phải là hậu duệ). Có thể chứng minh được rằng có một **đáp án duy nhất**.*

Return the root of the trimmed binary search tree. Note that the root may change depending on the given boundaries.
*Trả về gốc của cây nhị phân tìm kiếm đã được cắt tỉa. Lưu ý rằng nút gốc có thể thay đổi tùy thuộc vào các ranh giới đã cho.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [1,0,2], low = 1, high = 2
**Output:** [1,null,2]

## Example 2:
## *Ví dụ 2:*

**Input:** root = [3,0,4,null,2,null,null,1], low = 1, high = 3
**Output:** [3,2,null,1]

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 10^4]`.
*   `0 <= Node.val <= 10^4`
*   The value of each node in the tree is **unique**.
*   `root` is guaranteed to be a valid binary search tree.
*   `0 <= low <= high <= 10^4`
