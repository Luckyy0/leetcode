# Result for Number of Boomerangs
# *Kết quả cho bài toán Số lượng Boomerang*

## Description
## *Mô tả*

You are given `n` points in the plane that are all **distinct**, where `points[i] = [xi, yi]`. A **boomerang** is a tuple of points `(i, j, k)` such that the distance between `i` and `j` equals the distance between `i` and `k` (**the order of the tuple matters**).
*Bạn được cho `n` điểm trên mặt phẳng hoàn toàn **phân biệt**, trong đó `points[i] = [xi, yi]`. Một **boomerang** là một bộ ba điểm `(i, j, k)` sao cho khoảng cách giữa `i` và `j` bằng khoảng cách giữa `i` và `k` (**thứ tự của bộ ba là có ý nghĩa**).*

Return *the number of boomerangs*.
*Hãy trả về *số lượng các boomerang*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `points = [[0,0],[1,0],[2,0]]`
**Output:** `2`
**Explanation:** The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]].

## Example 2:
## *Ví dụ 2:*

**Input:** `points = [[1,1],[2,2],[3,3]]`
**Output:** `2`

## Example 3:
## *Ví dụ 3:*

**Input:** `points = [[1,1]]`
**Output:** `0`

## Constraints:
## *Ràng buộc:*

*   `n == points.length`
*   `1 <= n <= 500`
*   `points[i].length == 2`
*   `-10^4 <= xi, yi <= 10^4`
*   All the points are **unique**.
