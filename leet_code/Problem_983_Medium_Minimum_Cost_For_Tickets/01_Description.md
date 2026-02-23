# Result for Minimum Cost For Tickets
# *Kết quả cho bài toán Chi phí Tối thiểu cho Vé*

## Description
## *Mô tả*

You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array `days`. Each day is an integer from `1` to `365`.
*Bạn đã lên kế hoạch đi du lịch bằng tàu hỏa trước một năm. Các ngày trong năm mà bạn sẽ đi du lịch được cho dưới dạng một mảng số nguyên `days`. Mỗi ngày là một số nguyên từ `1` đến `365`.*

Train tickets are sold in **three different ways**:
*Vé tàu được bán theo **ba cách khác nhau**:*

*   a **1-day** pass is sold for `costs[0]` dollars,
    *   *vé **1 ngày** được bán với giá `costs[0]` đô la,*
*   a **7-day** pass is sold for `costs[1]` dollars, and
    *   *vé **7 ngày** được bán với giá `costs[1]` đô la, và*
*   a **30-day** pass is sold for `costs[2]` dollars.
    *   *vé **30 ngày** được bán với giá `costs[2]` đô la.*

The passes allow that many days of consecutive travel.
*Các loại vé cho phép đi du lịch liên tiếp trong số ngày đó.*

*   For example, if we get a **7-day** pass on day `2`, then we can travel for `7` days: `2`, `3`, `4`, `5`, `6`, `7`, and `8`.
    *   *Ví dụ, nếu chúng ta mua vé **7 ngày** vào ngày `2`, thì chúng ta có thể đi du lịch trong `7` ngày: `2`, `3`, `4`, `5`, `6`, `7`, và `8`.*

Return *the minimum number of dollars you need to travel every day in the given list of days*.
*Trả về *số đô la tối thiểu bạn cần để đi du lịch mỗi ngày trong danh sách các ngày đã cho*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** days = [1,4,6,7,8,20], costs = [2,7,15]
**Output:** 11
**Explanation:** 
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total, you spent $11 and covered all the days of your travel.

## Example 2:
## *Ví dụ 2:*

**Input:** days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
**Output:** 17
**Explanation:** 
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
In total, you spent $17 and covered all the days of your travel.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= days.length <= 365`
*   `1 <= days[i] <= 365`
*   `days` is in strictly increasing order.
*   `costs.length == 3`
*   `1 <= costs[i] <= 1000`
