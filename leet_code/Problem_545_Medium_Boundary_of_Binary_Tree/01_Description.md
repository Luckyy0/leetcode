# Result for Boundary of Binary Tree
# *Kết quả cho bài toán Biên của Cây Nhị phân*

## Description
## *Mô tả*

The **boundary** of a binary tree is the concatenation of the **root**, the **left boundary**, the **leaves** ordered from left-to-right, and the **reverse right boundary**.
***Biên** của một cây nhị phân là sự kết hợp của **gốc**, **biên trái**, **các lá** được sắp xếp từ trái sang phải, và **biên phải đảo ngược**.*

The **left boundary** is defined as the path from the root to the **left-most** node. `root` is not considered a part of the left boundary. If the root does not have a left child, then the left boundary is empty.
***Biên trái** được định nghĩa là đường dẫn từ gốc đến nút **ngoài cùng bên trái**. `root` không được coi là một phần của biên trái. Nếu gốc không có con trái, thì biên trái là rỗng.*

 The **left-most** node is defined as a **leaf** node that could be reached when always travelling to the left child if it exists; otherwise, towards the right child. This repeats until a leaf node is reached.
*Nút **ngoài cùng bên trái** được định nghĩa là một nút **lá** có thể đạt được khi luôn di chuyển đến con trái nếu nó tồn tại; nếu không, thì hướng về phía con phải. Điều này lặp lại cho đến khi đạt được một nút lá.*

The **right boundary** is defined similarly: the path from the root to the **right-most** node. `root` is not considered a part of the right boundary. If the root does not have a right child, then the right boundary is empty.
***Biên phải** được định nghĩa tương tự: đường dẫn từ gốc đến nút **ngoài cùng bên phải**. `root` không được coi là một phần của biên phải. Nếu gốc không có con phải, thì biên phải là rỗng.*

The **right-most** node is defined similarly: a **leaf** node that could be reached when always travelling to the right child if it exists; otherwise, towards the left child. This repeats until a leaf node is reached.
*Nút **ngoài cùng bên phải** được định nghĩa tương tự: một nút **lá** có thể đạt được khi luôn di chuyển đến con phải nếu nó tồn tại; nếu không, thì hướng về phía con trái. Điều này lặp lại cho đến khi đạt được một nút lá.*

Wait, the definitions of boundaries in the problem description are slightly more complex regarding leaves.
Ideally, the boundary excludes leaves that are part of the left/right boundary traversal but are covered by the "leaves" section?
Usually:
1. Root.
2. Left Boundary (excluding leaves).
3. Leaves (all leaves).
4. Right Boundary (excluding leaves) in reverse.
But the definition says "left boundary is the path to the left-most node". And "left-most node is defined as a leaf".
So if we include left boundary nodes, we might include the left-most leaf.
Standard approach: Handle overlapping carefully.
Common rule:
- Left Boundary: nodes on left path, *except leaf*.
- Right Boundary: nodes on right path, *except leaf*.
- Leaves: all leaves.
- Root: separate.
(If root is leaf, handle specifically).

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [1,null,2,3,4]`
**Output:** `[1,3,4,2]`
**Explanation:**
- The root is the node with value 1
- The left boundary is empty (no left child)
- The leaves are nodes 3 and 4
- The right boundary is node 2
Note: the root is also a left-most/right-most node but is handled separately.

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [1,2,3,4,5,6,null,null,null,7,8,9,10]`
**Output:** `[1,2,4,7,8,9,10,6,3]`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 10^4]`.
*   `-1000 <= Node.val <= 1000`
