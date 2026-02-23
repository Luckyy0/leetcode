# Result for Longest Univalue Path
# *Kết quả cho bài toán Đường đi Đồng nhất Dài nhất*

## Description
## *Mô tả*

Given the `root` of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.
*Cho `root` của một cây nhị phân, hãy trả về độ dài của đường đi dài nhất mà mỗi nút trong đường đi đó đều có cùng một giá trị. Đường đi này có thể có hoặc không đi qua gốc.*

The **length of the path** between two nodes is represented by the number of edges between them.
* **Độ dài của đường đi** giữa hai nút được đại diện bởi số lượng cạnh giữa chúng.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [5,4,5,1,1,null,5]
**Output:** 2
**Explanation:** The longest path with the same value is marked by 5-5-5.

## Example 2:
## *Ví dụ 2:*

**Input:** root = [1,4,5,4,4,null,5]
**Output:** 2
**Explanation:** The longest path with the same value is marked by 4-4-4.

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[0, 10^4]`.
*   `-1000 <= Node.val <= 1000`
*   The depth of the tree will not exceed `1000`.
