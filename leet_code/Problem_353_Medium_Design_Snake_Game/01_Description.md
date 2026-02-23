# Result for Design Snake Game
# *Kết quả cho bài toán Thiết kế Trò chơi Rắn săn mồi*

## Description
## *Mô tả*

Design a Snake game that is played on a device with screen size height × width. The snake is initially positioned at the top left corner `(0, 0)` with a length of 1 unit.
*Thiết kế một trò chơi Rắn săn mồi được chơi trên một thiết bị có kích thước màn hình chiều cao × chiều rộng. Con rắn ban đầu nằm ở góc trên cùng bên trái `(0, 0)` với độ dài là 1.*

You are given a list of food's positions in row-column order. When a snake eats a food, its length increases by 1 and the next food appears on the screen.
*Bạn được cho một danh sách các vị trí của thức ăn theo thứ tự hàng-cột. Khi con rắn ăn một thức ăn, chiều dài của nó tăng thêm 1 và thức ăn tiếp theo sẽ xuất hiện trên màn hình.*

The food is guaranteed to appear one at a time on the screen. A food is conquered by the snake if its head occupies the same position as the food.
*Thức ăn được đảm bảo xuất hiện từng cái một trên màn hình. Con rắn ăn được thức ăn nếu đầu của nó nằm cùng vị trí với thức ăn.*

If the snake goes out of boundary or its head occupies a space that its body occupies (except for the case that the space just became empty because the snake is moving), the game is over.
*Nếu con rắn đi ra ngoài biên hoặc đầu của nó nằm ở không gian mà thân nó đang chiếm giữ (ngoại trừ trường hợp không gian đó vừa trở nên trống vì con rắn đang di chuyển), trò chơi sẽ kết thúc.*

Implement the `SnakeGame` class:
*Thực hiện lớp `SnakeGame`:*

*   `SnakeGame(int width, int height, int[][] food)` Initializes the object with a screen of size height x width and the positions of the food.
    *`SnakeGame(int width, int height, int[][] food)` Khởi tạo đối tượng với màn hình kích thước chiều cao x chiều rộng và các vị trí của thức ăn.*
*   `int move(String direction)` Returns the score of the game after the snake moves in the given direction. If the game is over, return -1.
    *`int move(String direction)` Trả về số điểm của trò chơi sau khi con rắn di chuyển theo hướng đã cho. Nếu trò chơi kết thúc, trả về -1.*

## Example 1:
## *Ví dụ 1:*

**Input:**
`["SnakeGame", "move", "move", "move", "move", "move", "move"]`
`[[3, 2, [[1, 2], [0, 1]]], ["R"], ["D"], ["R"], ["U"], ["L"], ["U"]]`
**Output:**
`[null, 0, 0, 1, 1, 2, -1]`

**Explanation:**
```java
SnakeGame snakeGame = new SnakeGame(3, 2, [[1, 2], [0, 1]]);
snakeGame.move("R"); // return 0
snakeGame.move("D"); // return 0
snakeGame.move("R"); // return 1, snake eats the first food and grows
snakeGame.move("U"); // return 1
snakeGame.move("L"); // return 2, snake eats the second food and grows
snakeGame.move("U"); // return -1, snake hits the top boundary
```

## Constraints:
## *Ràng buộc:*

*   `1 <= width, height <= 10^4`
*   `1 <= food.length <= 50`
*   `food[i].length == 2`
*   `0 <= row_i < height`, `0 <= col_i < width`
*   `direction` is one of `'U'`, `'D'`, `'L'`, `'R'`.
*   At most `10^4` calls will be made to `move`.
