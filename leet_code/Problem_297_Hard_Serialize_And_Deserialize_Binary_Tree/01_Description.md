# Result for Serialize and Deserialize Binary Tree
# *Kết quả cho bài toán Tuần tự hóa và Giải tuần tự hóa Cây nhị phân*

## Description
## *Mô tả*

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
*Tuần tự hóa là quá trình chuyển đổi cấu trúc dữ liệu hoặc đối tượng thành một chuỗi bit để có thể lưu trữ trong tệp hoặc bộ đệm bộ nhớ, hoặc truyền qua liên kết mạng để tái tạo lại sau này trong cùng hoặc môi trường máy tính khác.*

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
*Thiết kế một thuật toán để tuần tự hóa và giải tuần tự hóa cây nhị phân. Không có hạn chế nào về cách thuật toán của bạn hoạt động. Bạn chỉ cần đảm bảo rằng cây nhị phân có thể được tuần tự hóa thành một chuỗi và chuỗi này có thể được giải tuần tự hóa thành cấu trúc cây ban đầu.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [1,2,3,null,null,4,5]`
**Output:** `[1,2,3,null,null,4,5]`

## Example 2:
## *Ví dụ 2:*

**Input:** `root = []`
**Output:** `[]`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[0, 10^4]`.
*   `-1000 <= Node.val <= 1000`
