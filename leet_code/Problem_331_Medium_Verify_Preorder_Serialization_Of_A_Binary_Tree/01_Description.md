# Result for Verify Preorder Serialization of a Binary Tree
# *Kết quả cho bài toán Xác minh Tuần tự hóa Preorder của Cây Nhị phân*

## Description
## *Mô tả*

One way to serialize a binary tree is to use **preorder traversal**. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as `'#'`.
*Một cách để tuần tự hóa cây nhị phân là sử dụng **duyệt tiền thứ tự (preorder)**. Khi chúng ta gặp một nút không null, chúng ta ghi lại giá trị của nút đó. Nếu nó là một nút null, chúng ta ghi lại bằng cách sử dụng một giá trị lính canh chẳng hạn như `'#'`.*

For example, the above binary tree can be serialized to the string `"9,3,4,#,#,1,#,#,2,#,6,#,#"`, where `#` represents a null node.
*Ví dụ, cây nhị phân trên có thể được tuần tự hóa thành chuỗi `"9,3,4,#,#,1,#,#,2,#,6,#,#"`, trong đó `#` đại diện cho một nút null.*

Given a string of comma-separated values `preorder`, return `true` if it is a correct preorder traversal serialization of a binary tree.
*Cho một chuỗi các giá trị được phân tách bằng dấu phẩy `preorder`, trả về `true` nếu nó là một tuần tự hóa duyệt tiền thứ tự chính xác của một cây nhị phân.*

It is **guaranteed** that each comma-separated value in the string must be either an integer or a character `'#'` representing null pointer.
*Được **đảm bảo** rằng mỗi giá trị được phân tách bằng dấu phẩy trong chuỗi phải là một số nguyên hoặc một ký tự `'#'` đại diện cho con trỏ null.*

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as `"1,,3"`.
*Bạn có thể giả định rằng định dạng đầu vào luôn hợp lệ, ví dụ nó không bao giờ chứa hai dấu phẩy liên tiếp như `"1,,3"`.*

**Note:** You are not allowed to reconstruct the tree.
**Lưu ý:** Bạn không được phép xây dựng lại cây.

## Example 1:
## *Ví dụ 1:*

**Input:** `preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"`
**Output:** `true`

## Example 2:
## *Ví dụ 2:*

**Input:** `preorder = "1,#"`
**Output:** `false`

## Example 3:
## *Ví dụ 3:*

**Input:** `preorder = "9,#,#,1"`
**Output:** `false`

## Constraints:
## *Ràng buộc:*

*   `1 <= preorder.length <= 10^4`
*   `preorder` consist of integers in the range `[0, 100]` and `'#'` separated by commas `','`.
