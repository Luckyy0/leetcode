# Result for Closest Leaf in a Binary Tree
# *Kết quả cho bài toán Lá Gần nhất trong Cây Nhị phân*

## Description
## *Mô tả*

Given the `root` of a binary tree where every node has **a unique value** and a target integer `k`, return *the value of the **nearest leaf node** to the target `k` in the tree*.
*Cho `root` của một cây nhị phân nơi mỗi nút có **một giá trị duy nhất** và một số nguyên mục tiêu `k`, hãy trả về *giá trị của **nút lá gần nhất** với mục tiêu `k` trong cây*.*

**Nearest** to a leaf means the least number of edges traveled on the binary tree to reach any leaf of the tree. Also, a node is called a leaf if it has no children.
* **Gần nhất** với một lá nghĩa là số lượng cạnh ít nhất cần đi trên cây nhị phân để đến bất kỳ lá nào của cây. Ngoài ra, một nút được gọi là lá nếu nó không có con.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [1, 3, 2], k = 1
**Output:** 2 or 3
**Explanation:** Either 2 or 3 is the nearest leaf node to the target of 1.

## Example 2:
## *Ví dụ 2:*

**Input:** root = [1], k = 1
**Output:** 1
**Explanation:** The nearest leaf node is the root node itself.

## Example 3:
## *Ví dụ 3:*

**Input:** root = [1,2,3,4,null,null,null,5,null,6], k = 2
**Output:** 3
**Explanation:** The leaf node with value 3 (and not the leaf node with value 6) is nearest to the node with value 2.

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 1000]`.
*   `1 <= Node.val <= 1000`
*   All the values of the tree nodes are **unique**.
*   There exist some node in the tree where `Node.val == k`.
