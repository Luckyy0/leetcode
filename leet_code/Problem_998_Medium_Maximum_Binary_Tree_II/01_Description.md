# Result for Maximum Binary Tree II
# *Kết quả cho bài toán Cây Nhị phân Lớn nhất II*

## Description
## *Mô tả*

A **maximum tree** is a tree where every node has a value greater than any other value in its subtree.
*Một **cây lớn nhất** là một cây mà mọi nút có giá trị lớn hơn bất kỳ giá trị nào khác trong cây con của nó.*

You are given the `root` of a maximum binary tree and an integer `val`.
*Bạn được cho `gốc` của một cây nhị phân lớn nhất và một số nguyên `val`.*

Just as in the previous problem, the given tree was constructed from a list `a` (`root = Construct(a)`) recursively with the following `Construct(a)` routine:
*Giống như trong bài toán trước, cây đã cho được xây dựng từ một danh sách `a` (`root = Construct(a)`) một cách đệ quy với quy trình `Construct(a)` như sau:*

*   If `a` is empty, return `null`.
    *   *Nếu `a` trống, trả về `null`.*
*   Otherwise, let `a[i]` be the largest element of `a`. Create a `root` node with the value `a[i]`.
    *   *Nếu không, gọi `a[i]` là phần tử lớn nhất của `a`. Tạo một nút `root` với giá trị `a[i]`.*
*   The left child of `root` will be `Construct([a[0], a[1], ..., a[i - 1]])`.
    *   *Con trái của `root` sẽ là `Construct([a[0], a[1], ..., a[i - 1]])`.*
*   The right child of `root` will be `Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]])`.
    *   *Con phải của `root` sẽ là `Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]])`.*
*   Return `root`.
    *   *Trả về `root`.*

Note that we were not given `a` directly, only a root node `root` of a tree constructed by the above formula.
*Lưu ý rằng chúng ta không được cho `a` trực tiếp, chỉ cho một nút gốc `root` của một cây được xây dựng theo công thức trên.*

Suppose `b` is a copy of `a` with the value `val` appended to it. It is guaranteed that `b` has unique values.
*Giả sử `b` là một bản sao của `a` với giá trị `val` được nối vào đó. Đảm bảo rằng `b` có các giá trị duy nhất.*

Return `Construct(b)`.
*Trả về `Construct(b)`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** root = [4,1,3,null,null,2], val = 5
**Output:** [5,4,null,1,3,null,null,2]
**Explanation:** a = [1,4,2,3], b = [1,4,2,3,5]

## Example 2:
## *Ví dụ 2:*

**Input:** root = [5,2,4,null,1], val = 3
**Output:** [5,2,4,null,1,null,3]
**Explanation:** a = [2,1,5,4], b = [2,1,5,4,3]

## Example 3:
## *Ví dụ 3:*

**Input:** root = [5,2,3,null,1], val = 4
**Output:** [5,2,4,null,1,3]
**Explanation:** a = [2,1,5,3], b = [2,1,5,3,4]

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 100]`.
*   `1 <= Node.val <= 100`
*   All the values of the tree are **unique**.
*   `1 <= val <= 100`
