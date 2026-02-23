# Result for Encode N-ary Tree to Binary Tree
# *Kết quả cho bài toán Mã hóa Cây N-phân thành Cây Nhị phân*

## Description
## *Mô tả*

Design an algorithm to encode an N-ary tree into a binary tree and decode the binary tree to get the original N-ary tree. An N-ary tree is a rooted tree in which each node has no more than N children. Similarly, a binary tree is a rooted tree in which each node has no more than 2 children. There is no restriction on how your encoding/decoding algorithm should work. You just need to ensure that an N-ary tree can be encoded to a binary tree and this binary tree can be decoded to the original N-ary tree structure.
*Hãy thiết kế một thuật toán để mã hóa một cây N-phân thành một cây nhị phân và giải mã cây nhị phân đó để lấy lại cây N-phân ban đầu. Một cây N-phân là một cây có gốc trong đó mỗi nút có không quá N con. Tương tự, một cây nhị phân là một cây có gốc trong đó mỗi nút có không quá 2 con. Không có hạn chế nào về cách thức hoạt động của thuật toán mã hóa/giải mã của bạn. Bạn chỉ cần đảm bảo rằng một cây N-phân có thể được mã hóa thành một cây nhị phân và cây nhị phân này có thể được giải mã về cấu trúc cây N-phân ban đầu.*

## Examples:
## *Ví dụ:*

**Input:** N-ary Tree root
**Binary Tree Representation:** 
- The first child of an N-ary tree node becomes the left child of the binary tree node.
- The next sibling of an N-ary tree node becomes the right child of the binary tree node.

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[0, 10^4]`.
*   `0 <= Node.val <= 10^4`
*   The N-ary tree is guaranteed to be valid.
