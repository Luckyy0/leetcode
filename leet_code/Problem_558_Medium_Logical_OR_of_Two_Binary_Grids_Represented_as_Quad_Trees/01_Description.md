# Result for Logical OR of Two Binary Grids Represented as Quad-Trees
# *Kết quả cho bài toán Phép OR Logic của Hai Lưới Nhị phân biểu diễn bằng Cây Tứ phân*

## Description
## *Mô tả*

A Binary Matrix is represented as a **Quad-Tree**. Each node in the tree has at most four children: `topLeft`, `topRight`, `bottomLeft`, and `bottomRight`.
*Một Ma trận Nhị phân được biểu diễn dưới dạng **Cây Tứ phân**. Mỗi nút trong cây có tối đa bốn nút con: `topLeft`, `topRight`, `bottomLeft`, và `bottomRight`.*

A node has two attributes:
*Một nút có hai thuộc tính:*

*   `val`: True if the node represents a grid of 1's, or False if the node represents a grid of 0's.
    *`val`: True nếu nút biểu diễn một lưới các số 1, hoặc False nếu nút biểu diễn một lưới các số 0.*
*   `isLeaf`: True if the node is leaf node on the tree or False if the node has the four children.
    *`isLeaf`: True nếu nút là nút lá trên cây hoặc False nếu nút có bốn nút con.*

```java
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;
}
```

We can construct a Quad-Tree from a binary matrix as follows:
*Chúng ta có thể xây dựng Cây Tứ phân từ một ma trận nhị phân như sau:*

*   If the current matrix has the same value (i.e. all 1's or all 0's) set `isLeaf` True and set `val` to the value of the matrix and set the four children to Null and stop.
    *Nếu ma trận hiện tại có cùng giá trị (tức là tất cả là 1 hoặc tất cả là 0), hãy đặt `isLeaf` là True và đặt `val` thành giá trị của ma trận và đặt bốn nút con thành Null rồi dừng lại.*
*   If the current matrix has different values, set `isLeaf` False and set `val` to any value and divide the current matrix into four sub-matrices as shown in the photo.
    *Nếu ma trận hiện tại có các giá trị khác nhau, hãy đặt `isLeaf` là False và đặt `val` cho bất kỳ giá trị nào và chia ma trận hiện tại thành bốn ma trận con như hình minh họa.*
*   Recurse with each of the four sub-matrices with the corresponding children.
    *Đệ quy với mỗi ma trận trong số bốn ma trận con với các nút con tương ứng.*

Given two quad-trees `quadTree1` and `quadTree2`. `quadTree1` represents an `n x n` binary matrix and `quadTree2` represents another `n x n` binary matrix.
*Cho hai cây tứ phân `quadTree1` và `quadTree2`. `quadTree1` biểu diễn một ma trận nhị phân `n x n` và `quadTree2` biểu diễn một ma trận nhị phân `n x n` khác.*

Return *a Quad-Tree representing the `n x n` binary matrix which is the result of **logical bitwise OR** of the two binary matrices represented by `quadTree1` and `quadTree2`*.
*Trả về *Cây Tứ phân biểu diễn ma trận nhị phân `n x n`, là kết quả của **phép OR logic tương ứng** của hai ma trận nhị phân được biểu diễn bởi `quadTree1` và `quadTree2`*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `quadTree1 = [[0,1],[1,1],[1,1],[1,0],[1,0]], quadTree2 = [[0,1],[1,1],[0,1],[1,1],[1,0],[null,null],[null,null],[null,null],[null,null],[1,0],[1,0],[1,1],[1,1]]`
**Output:** `[[0,0],[1,1],[1,1],[1,1],[1,0]]`

## Constraints:
## *Ràng buộc:*

*   `quadTree1` and `quadTree2` are both valid Quad-Trees each representing a binary matrix of size `n x n`.
*   `n == 2^x` where `0 <= x <= 9`.
