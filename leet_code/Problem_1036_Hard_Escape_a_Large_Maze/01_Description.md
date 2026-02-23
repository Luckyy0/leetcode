# Result for Escape a Large Maze
# *Kết quả bài toán Tẩu Thoát Khối Mê Cung Khổng Lồ*

## Description
## *Mô tả*

There is a 1 million by 1 million grid on an XY-plane, and the coordinates of each grid square are `(r, c)`.
*Tưởng tượng có một lưới tọa độ Địa Ngục trần gian khổng lồ kích thước 1 TRIỆU x 1 TRIỆU (1,000,000 x 1,000,000) ô vuông trải dài tít tắp, tọa độ từng ô chôn chân bằng `(r, c)` (hàng, cột).*

We begin at `source = [sr, sc]` and want to reach `target = [tr, tc]`. There is also an array of `blocked` squares, where each `blocked[i] = [r, c]` represents a blocked square with coordinates `(r, c)`.
*Quăng bạn rớt cái bụp xuống điểm xuất phát `source = [sr, sc]` và bắt buộc bạn lết thân vác xác đi thoi thóp cho kỳ được tới bờ đích `target = [tr, tc]`. Thế nhưng trên Bản Đồ Ngàn Trùng này có ĐỘT BIẾN mọc lên ngầm một Mảng Những Hố Bom TỬ THẦN `blocked` (Các ô vuông bị Vạc đứt khóa chết, cấm giẫm vào).*

Each move, we can walk one square north, south, east, or west, but we cannot step onto a blocked square or off the grid.
*Rải từng bước chân sinh tồn: Bốn bề Bắc, Nam, Đông, Tây (Lên, Xuống, Tạt Trái, Rẽ Phải). Nếu lỡ dại trượt chân rớt vô Hố Bom Tử thần (bị blocked), hay dốt nát nhảy ra khỏi mép tường (Grid Boundaries Lớn), bạn Chết Chắc.*

Return `true` if and only if it is possible to reach the target square from the source square through a sequence of valid moves.
*Cứu tinh trả lời câu hỏi: Trả về **`true`** Nếu và Chỉ Nếu ĐÍCH THỊ CÒN MỘT CỬA SỐNG CÓ THỂ BƯỚC BO RẠCH CÁCH ĐI THOÁT ĐẾN ĐÍCH ĐƯỢC từ Nơi Xuất Phát. Còn bị nhốt nát Thảm Chết Trong Góc thì về `false`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
**Output:** false
**Explanation:** The target square is inaccessible starting from the source square because we cannot move.
We cannot move north or west because those squares are off the grid.
We cannot move south or east because those squares are blocked.
*Giải thích: Đứng ngây dại ở góc tọa độ hẹp nách [0, 0].*
*Mảng nhốt góc ném Cục chặn ở Lề phải [0, 1] và Cửa đít [1, 0].*
*Tường phía Bắc, Tây đụng Vách Sắt. Cốt phía Nam, Đông đụng Lỗ Tử Thần. Chuột Sa Chĩnh Bí Ngòi -> Thảm Nám false.*

## Example 2:
## *Ví dụ 2:*

**Input:** blocked = [], source = [0,0], target = [999999,999999]
**Output:** true
**Explanation:** Because there are no blocked squares, it is possible to reach the target square.
*Giải thích: Không có viên thiên thạch Tử Thần nào Chắn Lối Tông! Đất trống thênh thang tít mù 1 Triệu dặm Lưới -> Thông Dong Chắn Chắc Chạm Tới Đích.*

---

## Constraints:
## *Ràng buộc:*

*   `0 <= blocked.length <= 200` *(KÊNH TIN TỨC ĐỘT PHÁ TỐT NHẤT: Bãi mìn rớt max tối đa là 200 Viên Đá thôi!)*
*   `blocked[i].length == 2`
*   `0 <= r, c < 10^6`
*   `source.length == target.length == 2`
*   `0 <= sr, sc, tr, tc < 10^6`
*   `source != target`
*   `source`, `target` are not in `blocked`.
