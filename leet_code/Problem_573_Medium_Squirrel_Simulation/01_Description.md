# Result for Squirrel Simulation
# *Kết quả cho bài toán Mô phỏng Sóc*

## Description
## *Mô tả*

You are given a tree with its position `tree` and a squirrel with its position `squirrel`. You are also given an array of nuts `nuts` where `nuts[i]` is the position of the `i`-th nut. All positions are given in (row, col) coordinates on a 2D grid.
*Bạn được cung cấp một cái cây với vị trí của nó `tree` và một con sóc với vị trí của nó `squirrel`. Bạn cũng được cung cấp một mảng các loại hạt `nuts` trong đó `nuts[i]` là vị trí của hạt thứ `i`. Tất cả các vị trí được đưa ra dưới dạng tọa độ (hàng, cột) trên một lưới 2D.*

The squirrel wants to collect all the nuts and put them into the tree one by one. The squirrel can only take **at most one nut** at a time and must put it into the tree before picking up the next nut. At the end of the simulation, the squirrel's position does not matter.
*Con sóc muốn thu thập tất cả các loại hạt và bỏ chúng vào cây từng cái một. Con sóc chỉ có thể lấy **tối đa một hạt** tại một thời điểm và phải bỏ nó vào cây trước khi nhặt hạt tiếp theo. Khi kết thúc mô phỏng, vị trí của con sóc không quan trọng.*

The squirrel can move in four directions (up, down, left, right) each taking one step. The distance between two positions $(r_1, c_1)$ and $(r_2, c_2)$ is $|r_1 - r_2| + |c_1 - c_2|$.
*Con sóc có thể di chuyển theo bốn hướng (lên, xuống, trái, phải), mỗi hướng tốn một bước. Khoảng cách giữa hai vị trí $(r_1, c_1)$ và $(r_2, c_2)$ là $|r_1 - r_2| + |c_1 - c_2|$.*

Find the **minimum distance** the squirrel needs to travel to collect all the nuts and put them into the tree.
*Tìm **khoảng cách tối thiểu** mà con sóc cần di chuyển để thu thập tất cả các hạt và bỏ chúng vào cây.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** height = 5, width = 7, tree = [2,2], squirrel = [4,4], nuts = [[3,0], [2,5]]
**Output:** 12
**Explanation:** 
- The squirrel goes from [4,4] to [3,0] (distance 5), then to [2,2] (distance 3). Total = 8.
- Then goes from [2,2] to [2,5] (distance 3), then to [2,2] (distance 3). Total = 8 + 6 = 14.
- Total distance = 14.
- If squirrel starts with [2,5], distance is 12.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= height, width <= 100`
*   `tree.length == squirrel.length == 2`
*   `1 <= nuts.length <= 5000`
*   `nuts[i].length == 2`
*   All positions are within the grid.
