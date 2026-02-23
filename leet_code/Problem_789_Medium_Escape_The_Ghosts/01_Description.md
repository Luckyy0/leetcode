# Result for Escape The Ghosts
# *Kết quả cho bài toán Trốn thoát khỏi Bóng ma*

## Description
## *Mô tả*

You are playing a simplified Pacman game. You start at the point `[0, 0]`, and your destination is `target = [xt, yt]`. There are several ghosts on the map with their starting positions given as an array `ghosts`, where `ghosts[i] = [xi, yi]` represents the starting position of the `i`-th ghost.
*Bạn đang chơi một trò chơi Pacman đơn giản hóa. Bạn bắt đầu tại điểm `[0, 0]`, và đích đến của bạn là `target = [xt, yt]`. Có một số bóng ma trên bản đồ với vị trí bắt đầu của chúng được cho dưới dạng một mảng `ghosts`, trong đó `ghosts[i] = [xi, yi]` đại diện cho vị trí bắt đầu của bóng ma thứ `i`.*

Each turn, you and all the ghosts simultaneously may move in one of the following 4 directions: north, east, south, or west, going to a neighbor 1 unit away.
*Mỗi lượt, bạn và tất cả bóng ma đồng thời có thể di chuyển theo một trong 4 hướng sau: bắc, đông, nam, hoặc tây, đến một điểm lân cận cách 1 đơn vị.*

You escape if and only if you can reach the target **before** any ghost reaches you used as "reach any square that you occupy". To make it strictly harder for you, assume the ghosts know your every move and will try to catch you. If you reach the target at the same time as a ghost, you do **not** escape.
*Bạn trốn thoát khi và chỉ khi bạn có thể đến đích **trước khi** bất kỳ bóng ma nào chạm vào bạn. Để làm khó bạn hơn, giả sử bóng ma biết mọi di chuyển của bạn và sẽ cố gắng bắt bạn. Nếu bạn đến đích cùng lúc với một bóng ma, bạn sẽ **không** thoát được.*

Return `true` *if it is possible to escape, otherwise return* `false`.
*Trả về `true` *nếu có thể trốn thoát, ngược lại trả về* `false`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** ghosts = [[1,0],[0,3]], target = [0,1]
**Output:** true
**Explanation:**
You can reach the destination (0, 1) after 1 turn.
The ghosts located at (1, 0) and (0, 3) cannot catch you.

## Example 2:
## *Ví dụ 2:*

**Input:** ghosts = [[1,0]], target = [2,0]
**Output:** false
**Explanation:**
You need to reach the destination (2, 0), but the ghost at (1, 0) lies between you and the destination.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= ghosts.length <= 100`
*   `ghosts[i].length == 2`
*   `-10^4 <= xi, yi <= 10^4`
*   `target.length == 2`
*   `-10^4 <= xt, yt <= 10^4`
