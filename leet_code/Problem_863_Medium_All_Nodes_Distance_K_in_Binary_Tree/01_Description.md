# Result for All Nodes Distance K in Binary Tree
# *Kết quả cho bài toán Tất cả các Nút cách Khoảng K trong Cây Nhị phân*

## Description
## *Mô tả*

Given the `root` of a binary tree, the value of a target node `target`, and an integer `k`, return *an array of the values of all nodes that have a distance `k` from the target node*.
*Cho `root` của một cây nhị phân, giá trị của một nút mục tiêu `target` và một số nguyên `k`, hãy trả về *một mảng giá trị của tất cả các nút có khoảng cách `k` từ nút mục tiêu*.*

You can return the answer in **any order**.
*Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
**Output:** [7,4,1]
**Explanation:** The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.

## Example 2:
## *Ví dụ 2:*

**Input:** root = [1], target = 1, k = 3
**Output:** []

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 500]`.
*   `0 <= Node.val <= 500`
*   All `Node.val` are **unique**.
*   `target` is the value of one of the nodes in the tree.
*   `0 <= k <= 1000`
