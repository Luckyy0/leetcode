# Result for Recover a Tree From Preorder Traversal
# *Kết quả bài toán Khôi phục Cây từ phép duyệt Tiền tố (Preorder)*

## Description
## *Mô tả*

We run a preorder depth-first search (DFS) on the `root` of a binary tree.
*Chúng ta thực hiện trò chơi duyệt cây Đệ quy Ưu tiên Rễ (Preorder DFS) xuất phát từ `root` (gốc) của một cây nhị phân.*

At each node in this traversal, we output `D` dashes (where `D` is the depth of this node), then we output the value of this node. If the depth of a node is `D`, the depth of its immediate child is `D + 1`. The depth of the root node is `0`.
*Tại mỗi nút khi đi lướt qua trên hành trình này, chúng ta in ra `D` dấu gạch ngang (trong đó `D` biểu thị độ sâu của nút này), sau đó in lu mờ giá trị thực của chính nút đó. Nếu độ sâu của một nút là `D`, thì rễ con trực tiếp của nó bắt buộc thụt sâu mốc `D + 1`. Độ sâu của nút gốc trên cùng đứng ở `0` (không có vết gạch nào).*

If a node has only one child, that child is guaranteed to be **the left child**.
*Nếu một nút chỉ có một mụn con duy nhất, lề luật bắt buộc phải cho đứa con đó ngồi **bên nhánh Trái**.*

Given the output `traversal` of this traversal, recover the tree and return *its* `root`.
*Cho trước `traversal` (đầu ra chuỗi hỗn hợp của một cuộc duyệt cây), hãy khôi phục lại nguyên vẹn hình dáng cái cây và trả về `root` (Nút Gốc) của nó.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** traversal = "1-2--3--4-5--6--7"
**Output:** [1,2,5,3,4,6,7]
**Explanation:** 
- `1`: Root (Depth 0)
- `-2`: Left child of 1 (Depth 1)
- `--3`: Left child of 2 (Depth 2)
- `--4`: Right child of 2 (Depth 2)
- `-5`: Right child of 1 (Depth 1)
- `--6`: Left child of 5 (Depth 2)
- `--7`: Right child of 5 (Depth 2)
*Giải thích: Đọc chuỗi ký tự theo nguyên tắc Preorder. Gốc: không có dấu gạch `1`. Nút con Trái của $1$ là $2$ (1 gạch `-`). Xuống nhánh Trái của $2$ là $3$ (2 gạch `--`). Xong nhánh Trái thì quay qua nhánh Phải của $2$ là $4$ (cũng 2 gạch `--`). Hết con của 2, vòng về nhánh Phải của gốc $1$ là $5$ (1 gạch `-`). Con của 5 là 6 và 7 nằm ở độ sâu `--`.*

## Example 2:
## *Ví dụ 2:*

**Input:** traversal = "1-2--3---4-5--6---7"
**Output:** [1,2,5,3,null,6,null,4,null,7]
**Explanation:** 
- `1`
- `-2` (L child of 1)
- `--3` (L child of 2)
- `---4` (L child of 3)
- `-5` (R child of 1)
- `--6` (L child of 5)
- `---7` (L child of 6)

## Example 3:
## *Ví dụ 3:*

**Input:** traversal = "1-401--349---90--88"
**Output:** [1,401,null,349,88,90]
**Explanation:** Notice that values can uniquely span multiple digits (e.g., 401).

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the original tree is in the range `[1, 1000]`.
*   `1 <= Node.val <= 10^9`
