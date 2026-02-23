# Result for Binary Search Tree to Greater Sum Tree
# *Kết quả bài toán Biến Đổi Cây Tìm Kiếm Nhị Phân Thành Cây Có Tổng Lớn Hơn*

## Description
## *Mô tả*

Given the `root` of a Binary Search Tree (BST), convert it to a **Greater Tree** such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
*Bạn được giao cho một cái Gốc Mễ (`root`) của một Cây Tìm Kiếm Nhị Phân (BST) truyền thống. Yêu cầu của bài toán là hãy nhào nặn làm phép biến hóa nó trở thành một cấu trúc **Cây Vĩ Đại Hơn (Greater Tree)** với luật lệ rùng rợn như sau: Giá trị của TỪNG NÚT một trên cái Cây Cũ mộc mục này phải bị lôi ra Đắp Thêm Khống đổi Mới thành BẰNG tổng của (Giá trị cũ của chính cái nút đó) CỘNG CHO (Tổng ráo riết Giá trị của TẤT CẢ các Nút Khác vất vưởng trên Cây Cũ mà DÁM có giá trị LỚN HƠN cái Nút Đang Xét).*

As a reminder, a binary search tree is a tree that satisfies these constraints:
*Chỉ xin nhắc khéo lại một quy ước đinh rỉ từ thời đồ đá về Cây Tìm Kiếm Nhị Phân (BST) đó là:*
*   The left subtree of a node contains only nodes with keys **less than** the node's key.
    *- Toàn bộ phần nhánh con chui lỉm BÊN PHÍA TAY TRÁI của một cái Nút Đều mang giá trị Nhỏ Bé Còm Cõi hơn Giá trị Cột Lõi của Nút Đó.*
*   The right subtree of a node contains only nodes with keys **greater than** the node's key.
    *- Toàn bộ phần nhánh con vươn cành BÊN PHÍA TAY PHẢI của Nút Ấy thì 100% Phải Rực Rỡ Giá Trị Lớn Hơn Chóp Bu gốc đấy.*
*   Both the left and right subtrees must also be binary search trees.
    *- Và sự rành mạch Trái/Phải Nhỏ/Lớn đó Đều được Áp dụng Triệt để cho cả Mầm Nhánh rễ sâu lút đến đáy Đại Cục Cây mẹ mài! (Đệ Quy Luật Nghĩa Đen).*

---

## Example 1:
## *Ví dụ 1:*

![BST to Greater Tree](https://assets.leetcode.com/uploads/2019/05/02/tree.png)
**Input:** root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
**Output:** [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
**Explanation:** 
*Giải thích: Đưa cho một cái Cây Nhị Phân Tìm kiếm Kinh Điển.*
*Thằng khổng lồ to nái nhất cây là lá `8`. Vì nó vô mưu không có ai to hơn mình cả, rốn của nó giữ Giá trị nguyên gốc `8`.*
*Thằng lớn nhì là `7`. Do nó nằm chót vót, duy nhất bị ông kẹ Số Oái Oăm `8` vượt mặt, vậy số Lõi Mới của nó BẰNG Cũ (7) + Kẻ Vượt Tầm (8) = `15`.*
*Thằng trung bình `6`. Lưng lửng trên Bàn Nước. Tổng Những Đứa Bự Hơn Cả Mình Gồm Đỉnh (7) và chót (8). Cũ (6) + Kẻ Vượt (7 + 8) = Cũ (6) + 15 = `21`.*
*Thằng Nhỏ Tí Tẹo Nhất Cây Là `0`. Đám bự hơn Nó Tính Hết Xót Bầu Cả Cái Hệ Sinh Thái Đứa Nào CŨNG LỚN HƠN NÓ XẤP XỈ! Tức là Chóp Bu Mới Của Nó sẽ Gom Ép Sạch Ráo Tổng Diện Tích Nguyên Cả Cái Rừng Cây Lượng Tính `36` Cụm Hóa Nốt.*

## Example 2:
## *Ví dụ 2:*

**Input:** root = [0,null,1]
**Output:** [1,null,1]
*Giải thích:* 
*Đỉnh đầu Mỏ neo là Nút (0). Rẽ phải mọc Nút Độc Hại (1). Cả Rừng Cây Rặt 2 Lá này.*
*Thằng Hạt (1) Vẫn Giữ Nhựa Sống Cũ Vì Ko Ai Đủ Cơ Vượt Mặt Nữa. (1).*
*Thằng Cha Hạt (0) Xong Dớp Cái Được Hưởng Bổng Khoản Kẻ Đạp Cổ Qua Mép Nước. 0 + 1 = Lên Mão Rồng Làm Hạt Tổng `1`.*

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 100]`.
    *(Số lượng hạt Cây đâm rễ bèo nhèo từ 1 đến Tối đa 100 nút nụ Tỏa Tách).*
*   `0 <= Node.val <= 100` *(Trị sổ đúc Lõi Nút cũng loanh quanh trăm số).*
*   All the values in the tree are **unique**. *(Tránh Rác Nỗi Đau Lên Ruột: Mỗi Lá rụng Bấm Biển Đánh Dấu Đặc Điểm Số Giá Trị KHÁC NHAU ĐỘC NHẤT, ko Trùng Lặp).*
