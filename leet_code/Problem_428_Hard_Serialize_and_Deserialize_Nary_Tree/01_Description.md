# Result for Serialize and Deserialize N-ary Tree
# *Kết quả cho bài toán Tuần tự hóa và Giải tuần tự hóa Cây N-phân*

## Description
## *Mô tả*

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
*Tuần tự hóa (Serialization) là quá trình chuyển đổi một cấu trúc dữ liệu hoặc đối tượng thành một chuỗi các bit để nó có thể được lưu trữ trong một tệp hoặc vùng nhớ đệm, hoặc truyền qua một liên kết kết nối mạng để được tái cấu trúc sau này trong cùng một hoặc một môi trường máy tính khác.*

Design an algorithm to serialize and deserialize an N-ary tree. An N-ary tree is a rooted tree in which each node has no more than N children. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that an N-ary tree can be serialized to a string and this string can be deserialized to the original tree structure.
*Hãy thiết kế một thuật toán để tuần tự hóa và giải tuần tự hóa một cây N-phân. Một cây N-phân là một cây có gốc trong đó mỗi nút có không quá N con. Không có giới hạn về cách thức hoạt động của thuật toán tuần tự hóa/giải tuần tự hóa của bạn. Bạn chỉ cần đảm bảo rằng một cây N-phân có thể được tuần tự hóa thành một chuỗi và chuỗi này có thể được giải tuần tự hóa về lại cấu trúc cây ban đầu.*

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[0, 10^4]`.
*   `0 <= Node.val <= 10^4`
*   The height of the n-ary tree is less than or equal to `1000`.
*   Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
