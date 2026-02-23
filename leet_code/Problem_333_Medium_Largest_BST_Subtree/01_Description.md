# Result for Largest BST Subtree
# *Kết quả cho bài toán Cây con BST Lớn nhất*

## Description
## *Mô tả*

Given the root of a binary tree, find the largest subtree, which is also a Binary Search Tree (BST), where the largest means subtree has the largest number of nodes.
*Cho gốc của một cây nhị phân, hãy tìm cây con lớn nhất, cũng là Cây Tìm kiếm Nhị phân (BST), trong đó "lớn nhất" có nghĩa là cây con có số lượng nút lớn nhất.*

A **subtree** of a tree `T` is a tree consisting of a node in `T` and all of its descendants.
*Một **cây con** của cây `T` là một cây bao gồm một nút trong `T` và tất cả các hậu duệ của nó.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [10,5,15,1,8,null,7]`
**Output:** `3`
**Explanation:** The Largest BST Subtree is shown in bold. The BST subtree rooted at 5 has size 3. (Subtree rooted at 15 is technically a BST of size 2, but 3 is larger. The whole tree is not a BST because 1 < 10 but 8 < 10? No 8 is child of 5. Wait. 10 -> 5, 15. 5 -> 1, 8. 15 -> null, 7. 7 < 10 (ok). 8 < 10 (ok). 5 < 10. 15 > 10. 1 < 5. 8 > 5. 7 < 15.
Is whole tree BST?
10
/  \
5   15
/ \    \
1   8    7
7 is right child of 15. 7 must be > 15. Fail. So rooted at 15 is not BST.
Wait. 15 -> null, 7. 7 is RIGHT child of 15? In array rep `[10,5,15,1,8,null,7]`, index 0=10. Left=5, Right=15.
15's Left is null. 15's Right is 7.
Right child 7 MUST be > 15. 7 < 15. So 15-subtree is NOT BST.
Left subtree: 5 -> 1, 8. 1 < 5, 8 > 5. Is BST. Size 3.
So max size 3.

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [4,2,7,2,3,5,null,2,null,null,null,null,null,1]`
**Output:** `2`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[0, 10^4]`.
*   `-10^4 <= Node.val <= 10^4`

**Follow up:** Can you figure out ways to solve it with O(n) time complexity?
**Câu hỏi mở rộng:** Bạn có thể tìm ra cách giải quyết vấn đề với độ phức tạp thời gian O(n) không?
