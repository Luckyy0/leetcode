# Result for Remove Boxes
# *Kết quả cho bài toán Xóa các Hộp*

## Description
## *Mô tả*

You are given several `boxes` with different colors represented by different positive numbers.
*Bạn được cho một số `boxes` (hộp) với các màu khác nhau được đại diện bởi các số dương khác nhau.*

You may experience several rounds to remove boxes until there is no box left. Each time you can choose some continuous boxes with the same color (i.e., composed of `k` boxes, `k >= 1`), remove them and get `k * k` points.
*Bạn có thể trải qua một số vòng để xóa các hộp cho đến khi không còn hộp nào. Mỗi lần bạn có thể chọn một số hộp liên tiếp có cùng màu (tức là, bao gồm `k` hộp, `k >= 1`), xóa chúng và nhận `k * k` điểm.*

Return *the maximum points you can get*.
*Trả về *số điểm tối đa bạn có thể nhận được*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `boxes = [1,3,2,2,2,3,4,3,1]`
**Output:** `23`
**Explanation:**
[1, 3, 2, 2, 2, 3, 4, 3, 1] 
----> [1, 3, 3, 4, 3, 1] (3*3=9 points) 
----> [1, 3, 3, 3, 1] (1*1=1 point) 
----> [1, 1] (3*3=9 points) 
----> [] (2*2=4 points)
Total points: 9 + 1 + 9 + 4 = 23.

## Example 2:
## *Ví dụ 2:*

**Input:** `boxes = [1,1,1]`
**Output:** `9`

## Example 3:
## *Ví dụ 3:*

**Input:** `boxes = [1]`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   `1 <= boxes.length <= 100`
*   `1 <= boxes[i] <= 100`
