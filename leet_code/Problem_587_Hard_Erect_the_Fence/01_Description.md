# Result for Erect the Fence
# *Kết quả cho bài toán Dựng Hàng rào*

## Description
## *Mô tả*

You are given an array `trees` where `trees[i] = [xi, yi]` represents the location of a tree in the garden.
*Bạn được cung cấp một mảng `trees` trong đó `trees[i] = [xi, yi]` đại diện cho vị trí của một cây trong vườn.*

You are asked to fence the entire garden using the minimum length of rope as it is expensive. The garden is well-fenced only if **all the trees** are enclosed. 
*Bạn được yêu cầu rào toàn bộ khu vườn bằng cách sử dụng chiều dài dây thừng tối thiểu vì nó rất đắt. Khu vườn chỉ được rào tốt nếu **tất cả các cây** được bao quanh.*

Return the coordinates of trees that are exactly on the fence of the garden.
*Trả về tọa độ của những cái cây nằm chính xác trên hàng rào của khu vườn.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** points = [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
**Output:** [[1,1],[2,0],[4,2],[3,3],[2,4]]

## Example 2:
## *Ví dụ 2:*

**Input:** points = [[1,2],[2,2],[4,2]]
**Output:** [[4,2],[2,2],[1,2]]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= points.length <= 3000`
*   `points[i].length == 2`
*   `0 <= xi, yi <= 100`
*   All the given points are unique.
