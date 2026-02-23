# Result for Robot Room Cleaner
# *Kết quả cho bài toán Robot Hút bụi*

## Description
## *Mô tả*

You are controlling a robot that is located somewhere in a room. The room is modeled as an `m x n` binary grid, where `0` represents a wall and `1` represents an empty space.
*Bạn đang điều khiển một robot nằm ở đâu đó trong phòng. Căn phòng được mô hình hóa dưới dạng lưới nhị phân `m x n`, trong đó `0` đại diện cho bức tường và `1` đại diện cho khoảng trống.*

The robot starts at an unknown location in the room. The robot has a camera that the robot can use to "see" the 4 directions (forward, left, backward, right).
*Robot bắt đầu ở một vị trí không xác định trong phòng. Robot có một camera mà nó có thể sử dụng để "nhìn" 4 hướng (trước, trái, sau, phải).*

The robot operates with the following API:
*Robot hoạt động với API sau:*

*   `boolean move()`: Returns true if the cell in front is open and robot moves into the cell. Returns false if the cell in front is blocked and robot stays in the current cell.
    *`boolean move()`: Trả về true nếu ô phía trước đang mở và robot di chuyển vào ô đó. Trả về false nếu ô phía trước bị chặn và robot ở lại ô hiện tại.*
*   `void turnLeft()`: Robot turns 90 degrees to the left.
    *`void turnLeft()`: Robot quay 90 độ sang trái.*
*   `void turnRight()`: Robot turns 90 degrees to the right.
    *`void turnRight()`: Robot quay 90 độ sang phải.*
*   `void clean()`: Cleans the current cell.
    *`void clean()`: Làm sạch ô hiện tại.*

Design an algorithm and implement it on the `Robot` class that forces the robot to clean the entire room.
*Thiết kế một thuật toán và triển khai nó trên lớp `Robot` để buộc robot làm sạch toàn bộ căn phòng.*

**Notes:**

1.  The initial direction of the robot will be facing up. You can assume the robot's initial position is always empty.
    *Hướng ban đầu của robot sẽ hướng lên trên. Bạn có thể giả định vị trí ban đầu của robot luôn trống.*
2.  The room is guaranteed to be connected.
    *Căn phòng được đảm bảo là được kết nối.*
3.  The robot knows nothing about the room layout and its coordinates.
    *Robot không biết gì về bố cục căn phòng và tọa độ của nó.*

