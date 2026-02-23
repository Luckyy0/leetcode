# Result for Sum of Root To Leaf Binary Numbers
# *Kết quả cho bài toán Tổng các Số Nhị phân từ Gốc đến Lá*

## Description
## *Mô tả*

You are given the `root` of a binary tree where each node has a value `0` or `1`. Each root-to-leaf path represents a binary number starting with the most significant bit.
*Bạn được cung cấp `root` (gốc) của một cây nhị phân, trong đó mỗi nút có giá trị là `0` hoặc `1`. Mỗi đường đi từ gốc đến lá đại diện cho một số nhị phân bắt đầu bằng bit có nghĩa cao nhất.*

*   For example, if the path is `0 -> 1 -> 1 -> 0 -> 1`, then this could represent `01101` in binary, which is `13`.
    *   *Ví dụ, nếu đường đi là `0 -> 1 -> 1 -> 0 -> 1`, điều này sẽ đại diện cho `01101` trong hệ nhị phân, tương đương với số `13` ở hệ thập phân.*

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return *the sum of these numbers*.
*Đối với tất cả các lá trong cây, hãy xem xét các con số được đại diện bởi đường đi từ gốc đến chiếc lá đó. Trả về tổng của tất cả các con số này.*

The test cases are generated so that the answer fits in a **32-bits** integer.
*Các bộ test được thiết kế sao cho đáp án nằm vừa vặn trong một số nguyên **32-bit**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [1,0,1,0,1,0,1]
**Output:** 22
**Explanation:** (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
*Giải thích: Đứng ở Gốc 1, rẽ trái-trái được đuôi "100" -> số 4. Rẽ trái-phải ra đuôi "101" -> số 5. Rẽ vế cánh phải tương tự được "110" và "111", tức là số 6 và 7. Cộng tổng lại ra 22.*

## Example 2:
## *Ví dụ 2:*

**Input:** root = [0]
**Output:** 0
*Giải thích: Cây chỉ có mỗi gốc chứa 0 đứt nụ, nên mã nhị phân là 0.*

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 1000]`.
*   `Node.val` is `0` or `1`.
