# Result for Dungeon Game
# *Kết quả cho bài toán Trò chơi trong ngục tối*

## Description
## *Mô tả*

The demons had captured the princess and imprisoned her in the bottom-right corner of a `dungeon`. The `dungeon` consists of `m x n` rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through `dungeon` to rescue the princess.
*Lũ quỷ đã bắt giữ công chúa và giam giữ cô ấy ở góc dưới bên phải của một `ngục tối`. `ngục tối` bao gồm `m x n` căn phòng được bố trí trong một lưới 2D. Hiệp sĩ dũng cảm của chúng ta ban đầu đứng ở căn phòng trên cùng bên trái và phải chiến đấu vượt qua `ngục tối` để giải cứu công chúa.*

The knight has an initial health point represented by a positive integer. If at any point his health point drops to `0` or below, he dies immediately.
*Hiệp sĩ có một điểm sức khỏe ban đầu được biểu diễn bằng một số nguyên dương. Nếu tại bất kỳ thời điểm nào điểm sức khỏe của hiệp sĩ giảm xuống `0` hoặc thấp hơn, hiệp sĩ sẽ hy sinh ngay lập tức.*

Some of the rooms are guarded by demons (represented by negative integers), so the knight loses health upon entering these rooms; other rooms are empty (represented as 0) or contain magic orbs that increase the knight's health (represented by positive integers).
*Một số phòng có quỷ canh giữ (được biểu thị bằng số nguyên âm), vì vậy hiệp sĩ mất máu khi vào các phòng này; các phòng khác để trống (0) hoặc chứa các quả cầu ma thuật tăng máu cho hiệp sĩ (số nguyên dương).*

In order to reach the princess as quickly as possible, the knight decides to move only **rightward** or **downward** in each step.
*Để giải cứu công chúa nhanh nhất có thể, hiệp sĩ quyết định chỉ di chuyển sang **phải** hoặc xuống **dưới** trong mỗi bước.*

Return *the knight's minimum initial health so that he can rescue the princess*.
*Trả về *số điểm sức khỏe ban đầu tối thiểu của hiệp sĩ để anh ta có thể giải cứu công chúa***.*

**Note** that any room can contain threats or power-ups, even the first and last rooms.
**Lưu ý** rằng bất kỳ phòng nào cũng có thể chứa mối đe dọa hoặc năng lượng, ngay cả phòng đầu tiên và phòng cuối cùng.

## Example 1:
## *Ví dụ 1:*

**Input:** `dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]`
**Output:** `7`
**Explanation:** The initial health of the knight must be at least 7 if he follows the optimal path: RIGHT -> RIGHT -> DOWN -> DOWN.

## Example 2:
## *Ví dụ 2:*

**Input:** `dungeon = [[0]]`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   `m == dungeon.length`
*   `n == dungeon[i].length`
*   `1 <= m, n <= 200`
*   `-1000 <= dungeon[i][j] <= 1000`
