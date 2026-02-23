# Result for Max Increase to Keep City Skyline
# *Kết quả cho bài toán Tăng tối đa để giữ nguyên đường chân trời thành phố*

## Description
## *Mô tả*

There is a city composed of `n x n` blocks, where each block contains a single building shaped like a vertical square prism. You are given a **0-indexed** `n x n` integer matrix `grid` where `grid[r][c]` is the height of the building located at row `r` and column `c`.
*Có một thành phố gồm các khối `n x n`, mỗi khối chứa một tòa nhà. Bạn được cho một ma trận `grid` trong đó `grid[r][c]` là chiều cao tòa nhà.*

A city's **skyline** is the outer contour formed by all the buildings when viewed from a distance. The skyline from each cardinal direction (north, east, south, and west) may be different.
*Đường chân trời của thành phố là hình bóng của các tòa nhà nhìn từ xa. Đường chân trời từ các hướng khác nhau có thể khác nhau.*

We are allowed to increase the height of any number of buildings, by any amount (the amount can be different for different buildings). The height of a building can be `0`. After increasing the heights, the city's **skyline** from any of the four cardinal directions must be the **same** as the original city's skyline.
*Ta được phép tăng chiều cao các tòa nhà sao cho đường chân trời từ bốn hướng không thay đổi.*

Return *the **maximum total sum** that the height of the buildings can be increased*.
*Trả về *tổng lượng tối đa chiều cao có thể tăng thêm*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
**Output:** 35
**Explanation:** 
The original skyline viewed from top or bottom is [9, 4, 8, 7].
The original skyline viewed from left or right is [8, 7, 9, 3].
The grid after increasing building heights without changing skylines is:
gridNew = [[8,4,8,7],[7,4,7,7],[9,4,8,7],[3,3,3,3]]

---

## Constraints:
## *Ràng buộc:*

*   `n == grid.length`, `n == grid[i].length`
*   `2 <= n <= 50`
*   `0 <= grid[i][j] <= 100`
