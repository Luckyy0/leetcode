# Result for Largest Triangle Area
# *Kết quả cho bài toán Diện tích Tam giác lớn nhất*

## Description
## *Mô tả*

Given an array of points on the **X-Y plane** `points` where `points[i] = [xi, yi]`, return *the area of the largest triangle that can be formed by any three different points*. Answers within `10^-5` of the actual answer will be accepted.
*Cho một mảng các điểm trên **mặt phẳng X-Y** `points` trong đó `points[i] = [xi, yi]`, trả về *diện tích của tam giác lớn nhất có thể được tạo thành bởi bất kỳ ba điểm khác nhau nào*. Các câu trả lời nằm trong khoảng `10^-5` so với giá trị thực tế sẽ được chấp nhận.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
**Output:** 2.00000
**Explanation:** The five points are shown in the above figure. The red triangle is formed by (0,0), (0,2), and (2,0) and has area 2.

## Example 2:
## *Ví dụ 2:*

**Input:** points = [[1,0],[0,0],[0,1]]
**Output:** 0.50000

---

## Constraints:
## *Ràng buộc:*

*   `3 <= points.length <= 50`
*   `-50 <= xi, yi <= 50`
*   All the given points are **unique**.
