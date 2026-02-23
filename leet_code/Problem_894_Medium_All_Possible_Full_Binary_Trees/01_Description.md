# Result for All Possible Full Binary Trees
# *Kết quả cho bài toán Tất cả các Cây Nhị phân Đầy đủ*

## Description
## *Mô tả*

Given an integer `n`, return *a list of all possible **full binary trees** with `n` nodes*. Each node of each tree in the answer must have `Node.val == 0`.
*Cho một số nguyên `n`, hãy trả về *một danh sách tất cả các **cây nhị phân đầy đủ** với `n` nút*. Mỗi nút của mỗi cây trong câu trả lời phải có `Node.val == 0`.*

Each element of the answer is the root node of one possible tree. You may return the final list of trees in **any order**.
*Mỗi phần tử của câu trả lời là nút gốc của một cây có thể. Bạn có thể trả về danh sách cây cuối cùng theo **bất kỳ thứ tự nào**.*

A **full binary tree** is a binary tree where each node has exactly `0` or `2` children.
*Một **cây nhị phân đầy đủ** là một cây nhị phân trong đó mỗi nút có chính xác `0` hoặc `2` con.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 7
**Output:** [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]

## Example 2:
## *Ví dụ 2:*

**Input:** n = 3
**Output:** [[0,0,0]]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 20`
