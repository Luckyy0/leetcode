# Result for Path Sum III
# *Kết quả cho bài toán Tổng đường đi III*

## Description
## *Mô tả*

Given the `root` of a binary tree and an integer `targetSum`, return *the number of paths where the sum of the values along the path equals `targetSum`*.
*Cho `root` của một cây nhị phân và một số nguyên `targetSum`, hãy trả về *số lượng các đường đi mà tổng các giá trị dọc theo đường đi đó bằng `targetSum`***.*

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
*Đường đi không cần phải bắt đầu hoặc kết thúc tại gốc hoặc lá, nhưng nó phải đi xuống (nghĩa là chỉ di chuyển từ các nút cha đến các nút con).*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8`
**Output:** `3`
**Explanation:** The paths that sum to 8 are [5,3], [5,2,1], and [-3,11].

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22`
**Output:** `3`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[0, 1000]`.
*   `-10^9 <= Node.val <= 10^9`
*   `-1000 <= targetSum <= 1000`
