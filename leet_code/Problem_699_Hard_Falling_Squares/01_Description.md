# Result for Falling Squares
# *Kết quả cho bài toán Các khối vuông rơi*

## Description
## *Mô tả*

There are several squares being dropped onto the X-axis of a 2D plane.
*Có một số khối vuông được thả xuống trục X của một mặt phẳng 2D.*

You are given a 2D integer array `positions` where `positions[i] = [left_i, sideLength_i]` represents the $i^{th}$ square with a side length `sideLength_i` that is dropped with its left edge aligned with X-coordinate `left_i`.
*Bạn được cho một mảng 2D `positions` trong đó `positions[i] = [left_i, sideLength_i]` đại diện cho khối vuông thứ $i$ có độ dài cạnh `sideLength_i`, được thả xuống với cạnh trái khớp với tọa độ X là `left_i`.*

Each square is dropped one by one from a large height onto the axis. When a square falls, it lands on the top of any vertical line segment it overlaps with on the X-axis or on the X-axis itself if there is no overlap.
*Mỗi khối vuông được thả từng cái một từ trên cao. Khi một khối vuông rơi xuống, nó sẽ nằm trên đỉnh của bất kỳ đoạn thẳng nào mà nó chồng lấp trên trục X, hoặc nằm trên trục X nếu không có chồng lấp nào.*

Return an integer array `ans` where `ans[i]` is the maximum height of any part of all squares that have been dropped after dropping the $i^{th}$ square.
*Hãy trả về một mảng số nguyên `ans` trong đó `ans[i]` là chiều cao lớn nhất của bất kỳ phần nào của tất cả các khối vuông đã được thả sau khi thả khối vuông thứ $i$.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** positions = [[1,2],[2,3],[6,1]]
**Output:** [2,5,5]
**Explanation:**
After the first drop, the maximum height is 2.
The second square overlaps with the first, so it sits on top of it, reaching height 2 + 3 = 5.
The third square does not overlap, so its top is at height 1. The global maximum remains 5.

## Example 2:
## *Ví dụ 2:*

**Input:** positions = [[100,100],[200,100]]
**Output:** [100,100]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= positions.length <= 1000`
*   `1 <= left_i <= 10^8`
*   `1 <= sideLength_i <= 10^6`
