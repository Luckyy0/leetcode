# Result for Moving Stones Until Consecutive
# *Kết quả bài toán Di chuyển những hòn đá cho đến khi chúng liên tiếp*

## Description
## *Mô tả*

There are three stones in different positions on the X-axis. You are given three integers `a`, `b`, and `c`, the positions of the stones.
*Có ba hòn đá được đặt rải rác ở ba vị trí hoàn toàn khác nhau dọc theo một trục tọa độ X dài vô tận. Bạn được cung cấp ba con số nguyên `a`, `b`, và `c`, đại diện cho tọa độ độc lập của ba hòn đá này.*

In one move, you pick up a stone at an endpoint (i.e., either the lowest or highest position stone), and move it to an unoccupied position between those endpoints. Formally, let's say the stones are currently at positions `x`, `y`, and `z` with `x < y < z`. You pick up the stone at either position `x` or position `z`, and move that stone to an integer position `k`, with `x < k < z` and `k != y`.
*Trong một lượt đi (nước cờ), bạn có quyền bốc lên một hòn đá nằm ở ngoài cùng LÌA CẠNH (Tức là hoặc hòn đá đang lọt thỏm ở Tọa độ Nhỏ nhất, hoặc hòn đá cheo leo ở Tọa độ Lớn nhất), và ném nó nhích vào một bến đỗ "Trống Trải" xen kẽ ĐÂU ĐÓ LỌT KHE giữa hai hòn đá còn lại. Nói một cách toán học rành mạch, ví dụ bạn có tọa độ $x < y < z$. Móng vuốt của bạn chỉ được chộp hòn đá chót $x$ hoặc hòn đá mút $z$, nhấc bổng lên và đập cái rầm xuống một tọa độ nguyên $k$ MỚI TINH lọt thỏm làm sao cho $x < k < z$ và KHÔNG ĐƯỢC ÉP CHỒNG lên ô nhà thằng $y$ ($k \neq y$).*

The game ends when you cannot make any more moves (i.e., the stones are in three consecutive positions).
*Trò chơi văng đá kết thúc khi bạn bó tay không thể tạo thêm nổi lượt luồn lách nào nữa (Có nghĩa là ba hòn đá đã co cụm dính chặt thành một cục khắng khít liên tiếp 3 số nguyên tự nhiên kề vai nhau, ví dụ: 4, 5, 6).*

Return *an integer array `answer` of length `2` where*:
* `answer[0]` is the minimum number of moves you can play, and
* `answer[1]` is the maximum number of moves you can play.
*Yêu cầu: Trả về một **mảng gồm đúng 2 con số nguyên**, mang ý nghĩa phán quyết:*
*- Số đầu tiên: Số bước Chạy Đôn Chạy Đáo **Tối Thiểu (ÍT Nhất có thể)** để hốt Cú chót (stones liên tiếp).*
*- Số thứ hai: Số bước Chạy Nhẩn Nha Dạo Mát **Tối Đa (NHIỀU Nhất có thể)** để câu giờ dây dưa trò chơi cho tới lúc cắm ngàm đá liên tiếp!*

---

## Example 1:
## *Ví dụ 1:*

**Input:** a = 1, b = 2, c = 5
**Output:** [1,2]
**Explanation:** Move the stone from 5 to 3, or move the stone from 5 to 4 to 3.
*Giải thích: Tọa độ gốc: $1, 2, 5$. Các đá nằm ở x=1, y=2, z=5.*
*Min Bẹp Dính = 1 Bươc: Bợ hòn đá nằm tuốt mốc c=5, phi một phát chui tọt vô Lỗ Hổng mốc 3 $\implies$ Đá nằm xếp 1, 2, 3 (Dính Liền Nhau $\to$ Xong việc!).*
*Max Nhì Nhằng = 2 Bước: Bợ cục c=5 nhảy tẹp xuống mốc 4 (đội thành 1,2,4). Bước 2: Bợ cục 4 ném tụt xuống lỗ 3 (1,2,3 $\to$ Nghỉ game!).*

## Example 2:
## *Ví dụ 2:*

**Input:** a = 4, b = 3, c = 2
**Output:** [0,0]
**Explanation:** We cannot make any moves.
*Giải thích: Đưa vô 4, 3, 2 lộn xộn, Sắp lại Đẹp: 2, 3, 4. Nó Mẹ Nó vốn 3 thằng đứng đúc dính lẹo nhau nguyên Khối Liên Tiếp sẵn luôn rồi! Khỏi cần chơi. Số bước Lật Min = 0, Max = 0.*

## Example 3:
## *Ví dụ 3:*

**Input:** a = 3, b = 5, c = 1
**Output:** [1,2]
**Explanation:** Move the stone from 1 to 4; or move the stone from 1 to 2 to 4.
*Giải thích: Mốc Rải Rác: $1, 3, 5$. Min: Bợ thằng 1 ném vô 4 $\implies 3,4,5$ (1 nước).*

---

## Constraints:
## *Ràng buộc:*

*   `1 <= a, b, c <= 100`
*   `a`, `b`, and `c` have different values. (ba hòn đá có tọa độ khác biệt).
