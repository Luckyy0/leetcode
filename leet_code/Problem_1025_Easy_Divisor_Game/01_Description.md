# Result for Divisor Game
# *Kết quả cho bài toán Trò Chơi Chia Ước Số*

## Description
## *Mô tả*

Alice and Bob take turns playing a game, with Alice starting first.
*Alice và Bob chơi một trò chơi đánh theo lượt, trong đó Alice luôn là người đi trước.*

Initially, there is a number `n` on the chalkboard. On each player's turn, that player makes a move consisting of:
*Ban đầu, trên bảng đen có viết một số `n`. Trong mỗi lượt chơi, người chơi thực hiện một nước đi lặp lại gồm:*

*   Choosing any `x` with `0 < x < n` and `n % x == 0`.
    *   *Chọn bất kỳ một số `x` nào sao cho `0 < x < n` và `n` chia hết cho `x` (`n % x == 0`).*
*   Replacing the number `n` on the chalkboard with `n - x`.
    *   *Xóa số `n` trên bảng đen và thay thế bằng kết quả phép trừ `n - x`.*

Also, if a player cannot make a move, they lose the game.
*Bên cạnh đó, nếu đến lượt một người chơi mà người đó không thể tìm ra bất kỳ nước đi `x` nào hợp lệ (không có ước số nhỏ hơn), người đó lập tức thua cuộc.*

Return `true` *if and only if Alice wins the game, assuming both players play optimally*.
*Trả về `true` **nếu và chỉ nếu** Alice là người chiến thắng, với giả định rằng cả hai người chơi đều suy tính những nước đi hoàn hảo và Tối Ưu Nhất thiên hạ.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 2
**Output:** true
**Explanation:** 
Alice chooses 1, and Bob has no more moves.
*Giải thích: Bảng ghi số 2. Alice được đi trước, chọn ước số `x = 1` (vì $2 \% 1 == 0$ và $1 < 2$). Cục trên bảng biến thành $2 - 1 = 1$. Tới lượt Bob nhìn số 1, không tìm được số `x` nào thỏa $0 < x < 1$. Bob ngắc ngoải nộp mạng. Alice thắng (`true`).*

## Example 2:
## *Ví dụ 2:*

**Input:** n = 3
**Output:** false
**Explanation:** 
Alice chooses 1, Bob chooses 1, and Alice has no more moves.
*Giải thích: Bảng ghi số 3. Lượt 1: Alice chỉ có một lựa chọn `x = 1`. Trên bảng còn $3 - 1 = 2$. Lượt 2: Bob bốc ngay `x = 1`, bảng còn $2 - 1 = 1$. Lượt 3: Móc ngược về Alice đứng nhìn số 1 tủi thân vì hết cửa. Alice tự sát tắt máy. Kết quả Alice thua (`false`).*

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 1000`
