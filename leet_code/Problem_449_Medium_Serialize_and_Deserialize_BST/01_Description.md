# Result for Serialize and Deserialize BST
# *Kết quả cho bài toán Tuần tự hóa và Giải tuần tự hóa BST*

## Description
## *Mô tả*

Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
*Tuần tự hóa (Serialization) là quá trình chuyển đổi một cấu trúc dữ liệu hoặc đối tượng thành một chuỗi các bit để nó có thể được lưu trữ trong một tệp hoặc vùng nhớ đệm, hoặc truyền qua một liên kết kết nối mạng để được tái cấu trúc sau này.*

Design an algorithm to serialize and deserialize a **binary search tree**. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.
*Hãy thiết kế một thuật toán để tuần tự hóa và giải tuần tự hóa một **cây tìm kiếm nhị phân** (BST). Không có giới hạn về cách thức hoạt động của thuật toán. Bạn chỉ cần đảm bảo rằng một cây BST có thể được tuần tự hóa thành một chuỗi, và chuỗi này có thể được giải tuần tự hóa về lại cấu trúc cây ban đầu.*

The encoded string should be as compact as possible.
*Chuỗi mã hóa nên được thu gọn nhất có thể.*

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[0, 10^4]`.
*   `0 <= Node.val <= 10^4`
*   The input tree is guaranteed to be a binary search tree.
