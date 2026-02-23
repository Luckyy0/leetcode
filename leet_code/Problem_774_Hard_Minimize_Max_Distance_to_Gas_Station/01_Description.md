# Result for Minimize Max Distance to Gas Station
# *Kết quả cho bài toán Tối thiểu hóa Khoảng cách Tối đa đến Trạm xăng*

## Description
## *Mô tả*

You are given an integer array `stations` that represents the positions of the gas stations on the **x-axis**. You are also given an integer `k`.
*Bạn được cho một mảng số nguyên `stations` đại diện cho vị trí của các trạm xăng trên **trục x**. Bạn cũng được cho một số nguyên `k`.*

You should add `k` new gas stations. You can add the stations anywhere on the **x-axis**, and not necessarily on an integer position.
*Bạn nên thêm `k` trạm xăng mới. Bạn có thể thêm các trạm ở bất cứ đâu trên **trục x**, và không nhất thiết phải ở vị trí số nguyên.*

Let `penalty()` be the maximum distance between **adjacent** gas stations after adding the `k` new stations.
*Gọi `penalty()` là khoảng cách tối đa giữa các trạm xăng **liền kề** sau khi thêm `k` trạm mới.*

Return *the smallest possible value of `penalty()`*. Answers within `10^-6` of the actual answer will be accepted.
*Trả về *giá trị nhỏ nhất có thể của `penalty()`*. Các câu trả lời nằm trong khoảng `10^-6` của câu trả lời thực tế sẽ được chấp nhận.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** stations = [1,2,3,4,5,6,7,8,9,10], k = 9
**Output:** 0.50000

## Example 2:
## *Ví dụ 2:*

**Input:** stations = [23,24,36,39,46,56,57,65,84,98], k = 1
**Output:** 14.00000

---

## Constraints:
## *Ràng buộc:*

*   `10 <= stations.length <= 2000`
*   `0 <= stations[i] <= 10^8`
*   `stations` is sorted in a strictly increasing order.
*   `1 <= k <= 10^6`
