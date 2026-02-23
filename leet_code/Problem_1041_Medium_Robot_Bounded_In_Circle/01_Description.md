# Robot Bounded In Circle
# *Robot Bị Giới Hạn Trong Đường Tròn*

## Description
## *Mô tả*

On an infinite plane, a robot initially stands at `(0, 0)` and faces north.
*Trên một mặt phẳng vô hạn, có một con robot ban đầu đứng ở tọa độ `(0, 0)` và hướng mặt về phía Bắc.*

The robot can receive one of three instructions:
*Robot có thể nhận một trong ba mệnh lệnh sau:*
- `"G"`: go straight 1 unit;
- *"G": Đi thẳng về phía trước 1 đơn vị khoảng cách;*
- `"L"`: turn 90 degrees to the left;
- *"L": Rẽ ngoặt 90 độ sang bên Trái;*
- `"R"`: turn 90 degrees to the right.
- *"R": Rẽ ngoặt 90 độ sang bên Phải.*

The robot performs the `instructions` given in order, and repeats them forever.
*Robot sẽ thực hiện các chuỗi mệnh lệnh `instructions` được cấp theo đúng thứ tự, và cứ thế lặp đi lặp lại chuỗi đó mãi mãi đến tận cùng thời gian.*

Return `true` if and only if there exists a circle in the plane such that the robot never leaves the circle.
*Trả về `true` nếu và chỉ nếu tồn tại một ranh giới vòng tròn trên mặt phẳng đo đạc mà con robot này không bao giờ có thể thoát ra khỏi vòng tròn đó.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** instructions = "GGLLGG"
**Output:** true
**Explanation:** 
*Giải thích:*
The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
*Robot đi thẳng từ (0,0) đến (0,2), quay đầu 180 độ (2 vòng rẽ Trái L), và sau đó đi thẳng ngược lại về điểm xuất phát (0,0).*
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
*Khi nhai lại chuỗi lệnh này mãi, robot sẽ cứ kẹt đi đi lại lại trong cái vòng tròn bán kính 2 quanh tâm tọa độ.*

## Example 2:
## *Ví dụ 2:*

**Input:** instructions = "GG"
**Output:** false
**Explanation:** 
*Giải thích:*
The robot moves from (0,0) to (0,2), (0,4), (0,6), and so on.
*Robot cứ thế cắm đầu đi thẳng từ (0,0) lên vút (0,2), (0,4), (0,6), bay tuốt lút lên trời.*
The robot travels infinitely on the y-axis.
*Nó sẽ đi lạc trôi bất tận trên trục tung y. Không hề bị giới hạn.*

## Example 3:
## *Ví dụ 3:*

**Input:** instructions = "GL"
**Output:** true
**Explanation:** 
*Giải thích:*
The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
*Robot sẽ bò theo lộ tuyến: (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...*
It draws a square, never moving away from the center bounding box.
*Nó tự quấn lặp để vẽ ra một hình vuông, không bao giờ trốn khỏi chiếc lồng tâm.*

---

## Constraints:
## *Ràng buộc:*

*   `1 <= instructions.length <= 100`
*   `instructions[i]` is `'G'`, `'L'` or, `'R'`
*   *Lệnh `instructions[i]` chỉ có thể là `'G'`, `'L'` hoặc `'R'`*
