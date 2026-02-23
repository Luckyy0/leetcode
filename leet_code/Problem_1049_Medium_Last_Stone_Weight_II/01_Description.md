# Last Stone Weight II
# *Khối Lượng Viên Đá Cuối Cùng Dạng II*

## Description
## *Mô tả*

You are given an array of integers `stones` where `stones[i]` is the weight of the `ith` stone.
*Bạn được nhận một mảng các số nguyên `stones`, trong đó `stones[i]` là trọng lượng của viên đá thứ `i`.*

We are playing a game with the stones. On each turn, we choose any two stones and smash them together. Suppose the stones have weights `x` and `y` with `x <= y`. The result of this smash is:
*Chúng ta dấn thân vào trò chơi Tử Chiến Giành Đá. Bất kể ở lượt nào, ta thoải mái Bốc Tùy Ý hai viên đá bất kỳ nào đó và phang nát chọi vỡ chúng vào mặt nhau. Giả sử ta bóc nhầm được Đôi Đá trọng lượng `x` và `y` (với nguyên lý `x <= y`). Hậu kiểm sát cục diện vụ Nổ Đâm Sập:*
*   If `x == y`, both stones are destroyed.
*   *Nếu cân nặng ngang chóp Cân Đẩu Vân (`x == y`): Bùm! Cả 2 nát nhừ tử Tiêu Biến tan tành!*
*   If `x != y`, the stone of weight `x` is destroyed, and the stone of weight `y` has new weight `y - x`.
*   *Nếu Lệch Cân rạch ròi (`x != y`): Thằng mỏng cơm `x` Đột Tử Cát Bụi. Đứa Giày Thịt `y` sứt vành Càng và bẹp Cân đi một Mẩu Sẹo thành `y - x`.*

At the end of the game, there is **at most one** stone left.
*Lết đến Trận Sinh Tử Đêm Giao Thừa Cạn Mã, Cùng lắm Chỉ Có **Cao Kịch Độc 1 Viên Đá** Lành lặn Chóp Dư Ra Mảnh Sinh Mệnh Cuối Chào Sân Máu!*

Return the **smallest possible** weight of the left stone. If there are no stones left, return `0`.
*Trách Nhiệm Sinh Tử: Tìm ra cách đập Lấy Nhau Tài Tình Khôn Khéo Cỡ Nào Sao Cho... Cục Xác Sót Cuối Cùng Thu Cuộc Ấy Đạt Mốc Số Cân Nặng BI THẢM **NHỎ BÉ YẾU KHÉM NHẤT CÓ THỂ** Đo Được (Gần Zero nhất có thể). Trắng Băng Bể Kho Củi Hết Láng Sạch Rỗng Trơn Thì Trả Liền Nút Bạc `0`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** stones = [2,7,4,1,8,1]
**Output:** 1
**Explanation:** 
*Giải thích:*
We can combine 2 and 4 to get 2, so the array converts to [2,7,1,8,1] then,
we can combine 7 and 8 to get 1, so the array converts to [2,1,1,1] then,
we can combine 2 and 1 to get 1, so the array converts to [1,1,1] then,
we can combine 1 and 1 to get 0, so the array converts to [1], then that's the optimal value.
*Chọn đập khéo: Chọi 2 với 4 -> Dư Cục Mẻ Tẹo 2. Tái Mâm: [2,7,1,8,1].*
*Chọi Khốc 7 và 8 -> Dư Cục Sứt Sẹo 1. Bát Quân Bổn Chóp: [2, 1, 1, 1].*
*Giã Tiếp 2 và 1 -> Liềm 1. Ba Chỉ Sót: [1, 1, 1].*
*Kéo Gáy Hai Anh Song Sinh 1, 1 Chọi Nhau Tự Diệt Vô Hình. Vỏ Rỗng Vẩy Bé Em Sót Cặn Cùng: [1]. Đây Là Kịch Bản Rút Gọn Mỏng Mạnh Thủng Đáy Dễ Kiếm Cân Nặng Bé Nhất Tìm Mãn Lì! Kết Số Là 1.*

## Example 2:
## *Ví dụ 2:*

**Input:** stones = [31,26,33,21,40]
**Output:** 5

---

## Constraints:
## *Ràng buộc:*

*   `1 <= stones.length <= 30`
*   `1 <= stones[i] <= 100`
