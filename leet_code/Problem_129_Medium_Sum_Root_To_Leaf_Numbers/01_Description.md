# Result for Sum Root to Leaf Numbers
# *Kết quả cho bài toán Tổng Các Số Từ Gốc Đến Lá*

## Description
## *Mô tả*

You are given the `root` of a binary tree containing digits from `0` to `9` only.
*Bạn được cho `root` của một cây nhị phân chỉ chứa các chữ số từ `0` đến `9`.*

Each root-to-leaf path in the tree represents a number.
*Mỗi con đường từ gốc đến lá trong cây đại diện cho một con số.*

*   For example, the root-to-leaf path `1 -> 2 -> 3` represents the number `123`.
    *Ví dụ, con đường từ gốc đến lá `1 -> 2 -> 3` đại diện cho số `123`.*

Return *the total sum of all root-to-leaf numbers*. Test cases are generated so that the answer will fit in a **32-bit** integer.
*Trả về *tổng số của tất cả các con số từ gốc đến lá**. Các trường hợp kiểm thử được tạo ra sao cho câu trả lời sẽ khớp với một số nguyên **32-bit**.*

A **leaf** node is a node with no children.
*Một nút **lá** là một nút không có con.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [1,2,3]`
**Output:** `25`
**Explanation:**
The root-to-leaf path `1 -> 2` represents the number `12`.
The root-to-leaf path `1 -> 3` represents the number `13`.
Therefore, sum = 12 + 13 = 25.

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [4,9,0,5,1]`
**Output:** `1026`
**Explanation:**
The root-to-leaf path `4 -> 9 -> 5` represents the number `495`.
The root-to-leaf path `4 -> 9 -> 1` represents the number `491`.
The root-to-leaf path `4 -> 0` represents the number `40`.
Therefore, sum = 495 + 491 + 40 = 1026.

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 1000]`.
*   `0 <= Node.val <= 9`
*   The depth of the tree will not exceed `10`.
