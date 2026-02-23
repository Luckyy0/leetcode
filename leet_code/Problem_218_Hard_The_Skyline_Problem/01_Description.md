# Result for The Skyline Problem
# *Kết quả cho bài toán Đường chân trời*

## Description
## *Mô tả*

A city's **skyline** is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Given the locations and heights of all the buildings, return *the **skyline** formed by these buildings collectively*.
*Đường chân trời của một thành phố là đường viền bên ngoài của hình bóng được tạo thành bởi tất cả các tòa nhà trong thành phố đó khi nhìn từ xa. Cho vị trí và chiều cao của tất cả các tòa nhà, hãy trả về *đường chân trời được tạo thành bởi tập hợp các tòa nhà nàyan.*

The geometric information of each building is given in the array `buildings` where `buildings[i] = [lefti, righti, heighti]`:
* `lefti` is the x coordinate of the left edge of the `ith` building.
* `righti` is the x coordinate of the right edge of the `ith` building.
* `heighti` is the height of the `ith` building.

You may assume all buildings are perfect rectangles grounded on a flat surface at height 0.

The **skyline** should be represented as a list of "key points" sorted by their x-coordinate in the form `[[x1,y1],[x2,y2],...]`. Each key point is the left endpoint of some horizontal segment in the skyline except the last point in the list, which always has a y-coordinate 0 and marks the end of the skyline where the rightmost building ends. Any two adjacent buildings in the skyline must have different heights.

## Example 1:
## *Ví dụ 1:*

**Input:** `buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]`
**Output:** `[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]`

## Example 2:
## *Ví dụ 2:*

**Input:** `buildings = [[0,2,3],[2,5,3]]`
**Output:** `[[0,3],[5,0]]`

## Constraints:
## *Ràng buộc:*

*   `1 <= buildings.length <= 10^4`
*   `0 <= lefti < righti <= 2^31 - 1`
*   `1 <= heighti <= 2^31 - 1`
*   `buildings` is sorted by `lefti` in non-decreasing order.
