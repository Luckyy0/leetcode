# Last Stone Weight
# *Khối Lượng Viên Đá Cuối Cùng*

## Description
## *Mô tả*

You are given an array of integers `stones` where `stones[i]` is the weight of the `ith` stone.
*Bạn được cấp một mảng các số nguyên `stones` đại điện cho các viên đá, tại đó `stones[i]` là cân nặng đo lường của viên đá thứ `i`.*

We are playing a game with the stones. On each turn, we choose the **heaviest two stones** and smash them together. Suppose the heaviest two stones have weights `x` and `y` with `x <= y`. The result of this smash is:
*Chúng ta đang chơi một trò Đập Lò với những viên đá này. Bất kể ở lượt nào, mình cũng lôi ra **hai viên đá Nặng Nhất, Chà Bá Nhất** trong xóm Cục gạch và Táng Chọi Thẳng Chúng Nó Vào Mặt Nhau! Giả dụ 2 cục Voi đó là Cục ốm `x` và Cục mập `y` (đương nhiên `x <= y`). Thảm họa Đứt Gãy Rơi ra Mảnh Cục như sau:*
*   If `x == y`, both stones are destroyed.
*   *Nếu cân nặng Đồng Cân Đồng Lạng (`x == y`): Bùm! Cả 2 Cục Tan Rã Vụn Sạch Xía!*
*   If `x != y`, the stone of weight `x` is destroyed, and the stone of weight `y` has new weight `y - x`.
*   *Nếu Cân Thể Rạch Ròi Căng Điệu (`x != y`): Thằng mỏ gầy Gà Còi `x` Chết Tan Nát Bột Bụi. Nho Voi chóp `y` Bị sứt Cằm Kính Cận Đau Bi Rút cân thành Cục Nham mẻ chui ra mang Tầm Vóc Cân Mới là `y - x`!*

At the end of the game, there is **at most one** stone left.
*Cho tới Lúc Cạn Kiệt Giờ Chụp Cơn Mê Đập Đuổi Cào Quặp Tận Tới Cùng, Kéo Ngót Trận Đồ Tàn Tro Bãi Chiến Mộ Sẽ CHỈ SÓT LẠI **Cao Tay Lắm Là Rõ Một Khối Tảng Viên Đá Duy Mảnh Lẻ Loi** Mỏ Quặng Mà Thôi.*

Return the weight of the last remaining stone. If there are no stones left, return `0`.
*Xoay Gọn Hỏi Câu: Trả về Khối Lượng Tính Cân Của Viện Đá Cương Thi Sống Sót Cuối Cùng Rót Thấy. Ngược Lạ Chả Còn Ma Quỷ Nào Xót Phân Đào Chóp Mạt Nát Vụn Đuối Tít Chẳng Sót Bãi nào, Dập Số `0`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** stones = [2,7,4,1,8,1]
**Output:** 1
**Explanation:** 
*Giải thích:*
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
*Mò hai cục To Voi Nhất Mỏ: Gọi Nhị Vị 7 và 8 Kháp Mặt. Đập Ngay. 8 Trừ 7 = 1 Sót Cục 1. Dàn Quân: [2,4,1,1,1].*
*Lôi Tiếp Thằng To Nhất: Gọi 4 và 2. Nổ Tan! Dư 2. Bát Quân Bổn Chóp: [2, 1, 1, 1].*
*Hốt Tiếp Rổ To: Gọi 2 và 1. Đập. Lỗ ra mẻ 1. Ba Chỉ Sót: [1, 1, 1].*
*Kéo Gáy Hai Anh Lớn Nhất là Song Sinh 1, 1 Chọi. Boom! Bốc Khói Tắt Thở Không Còn Lãnh Mảnh. Rổ Trống Vỏn vẹn Dư Vẩy Bé Em Cạn Đáy Áo Cũ: [1]. Đây Là Xác Gỗ Cuối Cùng Kỷ Lục Trận Đồ! Ráp Về 1!*

## Example 2:
## *Ví dụ 2:*

**Input:** stones = [1]
**Output:** 1

---

## Constraints:
## *Ràng buộc:*

*   `1 <= stones.length <= 30`
*   `1 <= stones[i] <= 1000`
