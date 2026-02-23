# Result for Coloring A Border
# *Kết quả bài toán Tô Màu Viền Biên Giới*

## Description
## *Mô tả*

You are given an `m x n` integer matrix `grid`, and three integers `row`, `col`, and `color`. Each value in the grid represents the color of the grid square at that location.
*Bạn được cấp một ma trận số nguyên `grid` kích thước `m x n` (gồm các ô vuông), cùng với ba con số nguyên chỉ điểm `row` (hàng), `col` (cột), và `color` (màu sắc mới). Mỗi con số bên trong ma trận đại diện cho màu sắc hiện tại của ô vuông ruộng đất tại chính vị trí đó.*

Two squares belong to the same **connected component** if they have the same color and are next to each other in any of the 4 directions.
*Hai ô vuông được coi là cùng chung một **Khối Linh Hồn Liên Kết Đồng Màu** (connected component) nếu chúng mặc chung một màu áo giống hệt nhau VÀ đứng sát rạt cạnh nhau theo 4 hướng kề vách (Lên, Xuống, Trái, Phải).*

The **border of a connected component** is all the squares in the connected component that are either 4-directionally adjacent to a square not in the component, or on the boundary of the grid (the first or last row or column).
***Đường Viền Biên Giới của Khối Đồng Màu** đó chính là TẤT CẢ các ô vuông nằm TRONG khối, nhưng gánh chịu rủi ro: Hoặc bị một ô mang màu dị giáo (không cùng Khối) áp sát sờ mó tiếp giáp Tứ phía; Hoặc bản thân nó xui xẻo nằm trơ trọi chênh vênh ngay trên MÉP VỰC ranh giới tận cùng của cái Ma Trận (hàng đầu, hàng chót, cột chót, cột đầu).*

You should color the **border** of the **connected component** that contains the square `grid[row][col]` with `color`.
*Sứ mệnh của bạn là hãy thô bạo **Vẩy Sơn (Tô màu)** đè lên **Đường Viền Biên Giới** của cái Khối Đồng Màu đang bao bọc chứa đựng ôm ấp ô tọa độ `grid[row][col]` bằng cái màu MỚI là `color`.*

Return *the final `grid`*.
*Trả về *Ma trận `grid` chốt sổ* sau cơn tàn sát vẩy sơn biên giới đó.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
**Output:** [[3,3],[3,2]]
**Explanation:** 
- Start at (0,0), its color is 1. The connected component of color 1 is (0,0), (0,1), (1,0).
- Check borders of this component:
  - (0,0) is on the matrix boundary -> color it to 3.
  - (0,1) is on the matrix boundary -> color it to 3.
  - (1,0) is on the matrix boundary -> color it to 3.
- (1,1) is color 2, not in the component, so it stays 2.
*Giải thích: Đứng ở Nút (0,0) là màu Vàng (1). Nguyên Cục Màu Vàng đồng minh dính lẹo nhau gồm 3 ô vuông góc trái. Cả 3 ô này xui cái ĐỀU nằm tè he dính mép Bờ tường Ma trận! Thành thử cả đám 3 ô này LÀ VIỀN BIÊN GIỚI mẹ nó rồi! Lôi đầu cả 3 ra tát sơn Phủ bằng màu Xanh (3). Ô Đỏ góc phải dưới (2) thì văng ngoài cuộc, CÒN NGUYÊN.*

## Example 2:
## *Ví dụ 2:*

**Input:** grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
**Output:** [[1,3,3],[2,3,3]]
**Explanation:** 
- Start at (0,1), color 2. Connected component is (0,1), (0,2), (1,2).
- They are all borders (touching boundaries or different colors).
- All change to 3.
*Giải thích: Nút trung tâm là (0, 1) mang màu 2. Cục rác Khối màu 2 gồm 3 ô (0,1) (0,2) và (1,2). Tất cả tụi nó đều lồi lõm dính tường biên hoặc đụng màu lạ. Tạt sơn thành 3 sạch sẽ!*

## Example 3:
## *Ví dụ 3:*

**Input:** grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
**Output:** [[2,2,2],[2,1,2],[2,2,2]]
**Explanation:** 
- The entire 3x3 grid is a single connected component of color 1.
- The "border" is the outer ring.
- The middle cell (1,1) is NOT a border because all its 4 neighbors are inside the component. Thus, it stays 1.
- Everything else is on the matrix boundary and gets colored to 2.
*Giải thích: Kinh điển của Cục Sắt Đặc ruột! Lưới $3 \times 3$ Nguyên một nùi MÀU VÀNG (1). Ra lệnh bóp ngay rốn lõi là (1,1). Khối Màu là Toàn Cục $3 \times 3$. Giờ Lùng Điểm VIỀN: Mọi ô vòng Xuyến Bao Nhốt Xung quanh đều cạ Mép Bản Đồ $\to$ Tô hết thành MÀU XANH (2). Duy nhất Ô Chua Lõi Cục Ở Giữa Lòng (1,1) là THOÁT NẠN, bì 4 phía Bắc Nam Đông Tây của nó ĐỀU là Đồng Bọn Tình Nghĩa Huyết Nhục Đã Phủ Kín Gió Táp, Nó An Toàn Ru Rú Ẩn Mình Ko Thấy Ánh Sáng Mép $\to$ GIỮ MÀU 1 CŨ!*

---

## Constraints:
## *Ràng buộc:*

*   `m == grid.length`
*   `n == grid[i].length`
*   `1 <= m, n <= 50`
*   `1 <= grid[i][j], color <= 1000`
*   `0 <= row < m`
*   `0 <= col < n`
