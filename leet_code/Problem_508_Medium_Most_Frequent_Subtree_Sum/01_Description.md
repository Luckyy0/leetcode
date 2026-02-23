# Result for Most Frequent Subtree Sum
# *Kết quả cho bài toán Tổng Cây con Thường gặp nhất*

## Description
## *Mô tả*

Given the `root` of a binary tree, return the most frequent **subtree sum**. If there is a tie, return all the values with the highest frequency in any order.
*Cho `root` của một cây nhị phân, hãy trả về **tổng cây con** thường gặp nhất. Nếu có sự hòa nhau, hãy trả về tất cả các giá trị có tần suất cao nhất theo bất kỳ thứ tự nào.*

The **subtree sum** of a node is defined as the sum of all the node values in the subtree rooted at that node (including the node itself).
***Tổng cây con** của một nút được định nghĩa là tổng của tất cả các giá trị nút trong cây con có gốc tại nút đó (bao gồm cả chính nút đó).*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [5,2,-3]`
**Output:** `[2,-3,4]`
**Explanation:** The returns values are 2, -3, and 4, which calculation is:
- The node 5 (root): 5 + 2 + (-3) = 4
- The node 2: 2
- The node -3: -3

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [5,2,-5]`
**Output:** `[2]`
**Explanation:** The returns values are 2.
- The node 5 (root): 5 + 2 + (-5) = 2
- The node 2: 2
- The node -5: -5
The frequent values is 2 (occurs twice).

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 10^4]`.
*   `-10^5 <= Node.val <= 10^5`
