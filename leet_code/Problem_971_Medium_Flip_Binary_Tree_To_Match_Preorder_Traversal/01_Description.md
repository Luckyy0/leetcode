# Result for Flip Binary Tree To Match Preorder Traversal
# *Kết quả cho bài toán Lật cây nhị phân để khớp với Duyệt tiền thứ tự*

## Description
## *Mô tả*

You are given the `root` of a binary tree with `n` nodes, where each node is uniquely assigned a value from `1` to `n`. You are also given a sequence of `n` values `voyage`, which is the desired **pre-order traversal** of the binary tree.
*Bạn được cho `gốc` của một cây nhị phân với `n` nút, trong đó mỗi nút được gán duy nhất một giá trị từ `1` đến `n`. Bạn cũng được cho một chuỗi `n` giá trị `voyage`, đây là **duyệt tiền thứ tự** mong muốn của cây nhị phân.*

Any node in the binary tree can be **flipped** by swapping its left and right subtrees. For example, flipping node 1 will have the following effect:
*Bất kỳ nút nào trong cây nhị phân đều có thể được **lật** bằng cách hoán đổi cây con trái và phải của nó. Ví dụ, lật nút 1 sẽ có hiệu ứng sau:*

Flip the smallest number of nodes so that the pre-order traversal of the tree matches `voyage`.
*Lật số lượng nút nhỏ nhất sao cho duyệt tiền thứ tự của cây khớp với `voyage`.*

Return *a list of the values of all flipped nodes. You may return the answer in **any order**. If it is **impossible** to flip the nodes in the tree to make the pre-order traversal match* `voyage`, *return the list* `[-1]`.
*Trả về *một danh sách các giá trị của tất cả các nút đã lật. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**. Nếu **không thể** lật các nút trong cây để duyệt tiền thứ tự khớp với* `voyage`, *trả về danh sách* `[-1]`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [1,2], voyage = [2,1]
**Output:** [-1]
**Explanation:** It is impossible to flip the nodes such that the pre-order traversal becomes [2,1].

## Example 2:
## *Ví dụ 2:*

**Input:** root = [1,2,3], voyage = [1,3,2]
**Output:** [1]
**Explanation:** Flipping node 1 swaps nodes 2 and 3, so pre-order traversal becomes [1,3,2].

## Example 3:
## *Ví dụ 3:*

**Input:** root = [1,2,3], voyage = [1,2,3]
**Output:** []
**Explanation:** The tree's pre-order traversal is already [1,2,3], so no flips are needed.

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is `n`.
*   `n == voyage.length`
*   `1 <= n <= 100`
*   `1 <= Node.val, voyage[i] <= n`
*   All the values in the tree are **unique**.
*   All the values in `voyage` are **unique**.
