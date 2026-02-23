# Result for Brick Wall
# *Kết quả cho bài toán Bức tường Gạch*

## Description
## *Mô tả*

There is a rectangular brick wall in front of you with `n` rows of bricks. The `ith` row has some number of bricks each of the same height (i.e., one unit) but they can be of different widths. The total width of each row is the same.
*Có một bức tường gạch hình chữ nhật trước mặt bạn với `n` hàng gạch. Hàng thứ `i` có một số lượng gạch, mỗi viên có cùng chiều cao (tức là 1 đơn vị) nhưng chúng có thể có chiều rộng khác nhau. Tổng chiều rộng của mỗi hàng là như nhau.*

Draw a vertical line from the top to the bottom and cross the least bricks. If your line goes through the edge of a brick, then the brick is not considered as crossed. You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.
*Hãy kẻ một đường thẳng đứng từ trên xuống dưới sao cho đi qua ít viên gạch nhất. Nếu đường thẳng của bạn đi qua cạnh của một viên gạch, thì viên gạch đó không được coi là bị cắt qua. Bạn không thể kẻ một đường thẳng chỉ dọc theo một trong hai cạnh đứng của bức tường, trong trường hợp đó đường thẳng rõ ràng sẽ không cắt qua viên gạch nào.*

Given the 2D array `wall` that contains the information about the wall, return *the minimum number of crossed bricks after drawing such a vertical line*.
*Cho mảng 2 chiều `wall` chứa thông tin về bức tường, hãy trả về *số lượng gạch bị cắt qua ít nhất sau khi kẻ một đường thẳng đứng như vậy*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]`
**Output:** `2`

## Example 2:
## *Ví dụ 2:*

**Input:** `wall = [[1],[1],[1]]`
**Output:** `3`

## Constraints:
## *Ràng buộc:*

*   `n == wall.length`
*   `1 <= n <= 10^4`
*   `1 <= wall[i].length <= 10^4`
*   `1 <= sum(wall[i].length) <= 2 * 10^4`
*   `sum(wall[i])` is the same for each row and is between `1` and `2^31 - 1`.
