# Result for Cut Off Trees for Golf Event
# *Kết quả cho bài toán Chặt cây cho Sự kiện Golf*

## Description
## *Mô tả*

You are asked to cut off all the trees in a forest for a golf event. The forest is represented as an `m x n` matrix. In this matrix:
*Bạn được yêu cầu chặt tất cả các cây trong một khu rừng cho một sự kiện golf. Khu rừng được biểu diễn dưới dạng một ma trận `m x n`. Trong ma trận này:*

- `0` means the ground is blocked and cannot be walked through.
    - *`0` nghĩa là mặt đất bị chặn và không thể đi qua.*
- `1` means the ground can be walked through.
    - *`1` nghĩa là mặt đất có thể đi qua.*
- A value `> 1` means there is a tree with that height that can be walked through, and you can cut off the tree.
    - *Một giá trị `> 1` nghĩa là có một cái cây với chiều cao đó có thể đi qua, và bạn có thể chặt cây đó.*

You start from the point `(0, 0)`. In each move, you can go to the four adjacent directions: up, down, left, and right. You are required to cut off all the trees in order from the shortest tree to the tallest tree.
*Bạn bắt đầu từ điểm `(0, 0)`. Trong mỗi lượt di chuyển, bạn có thể đi theo bốn hướng liền kề: lên, xuống, trái và phải. Bạn được yêu cầu chặt tất cả các cây theo thứ tự từ cây thấp nhất đến cây cao nhất.*

When you cut off a tree, the value at that cell becomes `1` (ground).
*Khi bạn chặt một cái cây, giá trị tại ô đó trở thành `1` (mặt đất).*

You will always start from `(0, 0)` and you should output the minimum steps you need to walk to cut off all the trees. If you cannot cut off all the trees, output -1.
*Bạn sẽ luôn bắt đầu từ `(0, 0)` và bạn nên đưa ra số bước tối thiểu bạn cần đi bộ để chặt tất cả các cây. Nếu bạn không thể chặt tất cả các cây, hãy xuất ra -1.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** forest = [[1,2,3],[0,0,4],[7,6,5]]
**Output:** 6
**Explanation:** Following the path (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (2,1) -> (2,0) to cut off all the trees.

## Example 2:
## *Ví dụ 2:*

**Input:** forest = [[1,2,3],[0,0,0],[7,6,5]]
**Output:** -1
**Explanation:** The tree with height 5 cannot be reached.

---

## Constraints:
## *Ràng buộc:*

*   `m == forest.length`
*   `n == forest[i].length`
*   `1 <= m, n <= 50`
*   `0 <= forest[i][j] <= 10^9`
