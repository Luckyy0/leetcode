# Result for Maximum Difference Between Node and Ancestor
# *Kết quả cho bài toán Độ Chênh lệch lớn nhất giữa Nút Cha và Con cháu*

## Description
## *Mô tả*

Given the `root` of a binary tree, find the maximum value `v` for which there exist **different** nodes `a` and `b` where `v = |a.val - b.val|` and `a` is an ancestor of `b`.
*Được cung cấp gốc `root` của một cây nhị phân, hãy tìm giá trị lớn nhất `v` sao cho tồn tại hai **nút khác nhau** `a` và `b` thỏa mãn phương trình `v = |a.val - b.val|` và nút `a` bắt buộc phải là Tổ tiên (bậc cha/ông/cụ) của nút `b`.*

A node `a` is an ancestor of `b` if either: any child of `a` is equal to `b` or any child of `a` is an ancestor of `b`.
*Nút `a` được định nghĩa là **Tổ tiên** của `b` giả thiết nếu: Bất kỳ đứa con ruột nào của `a` chính là `b`, HOẶC bất kỳ đứa con ruột nào của `a` lại đóng vai trò là tổ tiên của `b` (Cây gia phả trực hệ kéo dọc xuống).*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [8,3,10,1,6,null,14,null,null,4,7,13]
**Output:** 7
**Explanation:** 
We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
*Giải thích: Đứng từ đỉnh cao nhất Tổ tiên số 8, dòm xuống dọc cây gia phả: Tổ tiên (8) trừ Con cháu (1) tạo ra độ chênh lệch tuyết đối $|8 - 1| = 7$. Đây là cú nhảy dốc độ cao lớn nhất toàn Cây gia phả. Những cặp cha - con khác (như $3$ và $7$ ra 4) đều thua thiết.*

## Example 2:
## *Ví dụ 2:*

**Input:** root = [1,null,2,null,0,3]
**Output:** 3
**Explanation:** 
The maximum difference occurs between ancestor 3 and node 0: |3 - 0| = 3.
There is also node 0 and ancestor 1: |1 - 0| = 1, etc.
*Giải thích: Nếu Tổ tiên 3 (bên dưới) chứa nọc lá 0, thì $|3 - 0| = 3$ chính là độ vênh vĩ đại nhất!*

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[2, 5000]`.
*   `0 <= Node.val <= 10^5`
