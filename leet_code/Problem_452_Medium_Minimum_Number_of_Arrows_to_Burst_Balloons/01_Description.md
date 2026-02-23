# Result for Minimum Number of Arrows to Burst Balloons
# *Kết quả cho bài toán Số lượng Mũi tên Tối thiểu để Bắn vỡ Bóng bay*

## Description
## *Mô tả*

There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array `points` where `points[i] = [xstart, xend]` denotes a balloon whose **horizontal diameter** stretches between `xstart` and `xend`. You do not know the exact y-coordinates of the balloons.
*Có một số quả bóng bay hình cầu được dán trên một bức tường phẳng đại diện cho mặt phẳng XY. Các quả bóng được biểu diễn dưới dạng mảng số nguyên 2D `points` trong đó `points[i] = [xstart, xend]` biểu thị một quả bóng có **đường kính ngang** kéo dài từ `xstart` đến `xend`. Bạn không biết tọa độ y chính xác của các quả bóng.*

Arrows can be shot up **vertically** (in the positive y-direction) from different points along the x-axis. A balloon with `xstart` and `xend` is **burst** by an arrow shot at `x` if `xstart <= x <= xend`. There is **no limit** to the number of arrows that can be shot. A single arrow shot at some x-coordinate can burst all balloons which include that x-coordinate.
*Các mũi tên có thể được bắn lên **chiều dọc** (theo hướng y dương) từ các điểm khác nhau dọc theo trục x. Một quả bóng có `xstart` và `xend` sẽ bị **bắn vỡ** bởi một mũi tên bắn tại `x` nếu `xstart <= x <= xend`. Không có **giới hạn** về số lượng mũi tên có thể bắn. Một mũi tên duy nhất bắn tại một tọa độ x có thể làm nổ tất cả bóng bay bao hàm tọa độ x đó.*

Given the array `points`, return *the **minimum** number of arrows that must be shot to burst all balloons*.
*Cho mảng `points`, hãy trả về *số lượng **tối thiểu** các mũi tên phải bắn để làm nổ tất cả các quả bóng*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `points = [[10,16],[2,8],[1,6],[7,12]]`
**Output:** `2`
**Explanation:** The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].

## Example 2:
## *Ví dụ 2:*

**Input:** `points = [[1,2],[3,4],[5,6],[7,8]]`
**Output:** `4`

## Constraints:
## *Ràng buộc:*

*   `1 <= points.length <= 10^5`
*   `points[i].length == 2`
*   `-2^{31} <= xstart < xend <= 2^{31} - 1`
