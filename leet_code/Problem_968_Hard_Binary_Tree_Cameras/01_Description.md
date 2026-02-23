# Result for Binary Tree Cameras
# *Kết quả cho bài toán Camera Cây Nhị phân*

## Description
## *Mô tả*

You are given the `root` of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.
*Bạn được cho `gốc` của một cây nhị phân. Chúng tôi lắp đặt các camera trên các nút của cây, trong đó mỗi camera tại một nút có thể giám sát cha của nó, chính nó và con cái trực tiếp của nó.*

Return *the minimum number of cameras needed to monitor all nodes of the tree*.
*Trả về *số lượng camera tối thiểu cần thiết để giám sát tất cả các nút của cây*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [0,0,null,0,0]
**Output:** 1
**Explanation:** One camera is enough to monitor all nodes if placed as shown.

## Example 2:
## *Ví dụ 2:*

**Input:** root = [0,0,null,0,null,0,null,null,0]
**Output:** 2
**Explanation:** At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 1000]`.
*   `Node.val == 0`
