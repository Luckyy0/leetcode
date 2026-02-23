# Result for Binary Search Tree Iterator
# *Kết quả cho bài toán Bộ lặp cho cây tìm kiếm nhị phân*

## Description
## *Mô tả*

Implement the `BSTIterator` class that represents an iterator over the **in-order traversal** of a binary search tree (BST):
*Triển khai lớp `BSTIterator` đại diện cho một bộ lặp qua phép **duyệt thứ tự giữa (in-order traversal)** của một cây tìm kiếm nhị phân (BST):*

*   `BSTIterator(TreeNode root)` Initializes an object of the `BSTIterator` class. The `root` of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
    *`BSTIterator(TreeNode root)` Khởi tạo một đối tượng của lớp `BSTIterator`. `root` của BST được cung cấp như một phần của hàm khởi tạo. Con trỏ nên được khởi tạo ở một số không tồn tại, nhỏ hơn bất kỳ phần tử nào trong BST.*
*   `boolean hasNext()` Returns `true` if there exists a number in the traversal to the right of the pointer, otherwise returns `false`.
    *`boolean hasNext()` Trả về `true` nếu tồn tại một số trong phép duyệt ở bên phải con trỏ, ngược lại trả về `false`.*
*   `int next()` Moves the pointer to the right, then returns the number at the pointer.
    *`int next()` Di chuyển con trỏ sang phải, sau đó trả về số tại con trỏ.*

Notice that by initializing the pointer to a non-existent smallest number, the first call to `next()` will return the smallest element in the BST.
*Lưu ý rằng bằng cách khởi tạo con trỏ ở số nhỏ nhất không tồn tại, lần gọi `next()` đầu tiên sẽ trả về phần tử nhỏ nhất trong BST.*

You may assume that `next()` calls will always be valid. That is, there will be at least a next number in the in-order traversal when `next()` is called.
*Bạn có thể giả định rằng các lần gọi `next()` sẽ luôn hợp lệ.*

## Example 1:
## *Ví dụ 1:*

**Input**
`["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]`
`[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]`
**Output**
`[null, 3, 7, true, 9, true, 15, true, 20, false]`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 10^5]`.
*   `0 <= Node.val <= 10^6`
*   At most `10^5` calls will be made to `hasNext`, and `next`.

**Follow up:** Could you implement `next()` and `hasNext()` to run in average **O(1)** time and use **O(h)** memory, where `h` is the height of the tree?
**Câu hỏi mở rộng:** Bạn có thể triển khai `next()` và `hasNext()` để chạy trong thời gian trung bình **O(1)** và sử dụng bộ nhớ **O(h)** không, trong đó `h` là chiều cao của cây?
