# Result for IPO
# *Kết quả cho bài toán IPO*

## Description
## *Mô tả*

Suppose LeetCode will start its **IPO** soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most `k` distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most `k` distinct projects.
*Giả sử LeetCode sẽ sớm bắt đầu **IPO**. Để bán được giá cổ phiếu tốt cho Quỹ Đầu tư Mạo hiểm, LeetCode muốn thực hiện một số dự án để tăng vốn trước khi IPO. Vì nguồn lực có hạn, họ chỉ có thể hoàn thành tối đa `k` dự án khác nhau trước khi IPO. Hãy giúp LeetCode thiết kế cách tốt nhất để tối đa hóa tổng vốn sau khi hoàn thành tối đa `k` dự án khác nhau.*

You are given `n` projects where the `i^th` project has a pure profit `profits[i]` and a minimum capital of `capital[i]` is needed to start it.
*Bạn được cho `n` dự án trong đó dự án thứ `i` có lợi nhuận ròng `profits[i]` và số vốn tối thiểu `capital[i]` cần thiết để bắt đầu.*

Initially, you have `w` capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
*Ban đầu, bạn có số vốn `w`. Khi bạn hoàn thành một dự án, bạn sẽ nhận được lợi nhuận ròng của nó và lợi nhuận này sẽ được cộng vào tổng vốn của bạn.*

Pick a list of **at most** `k` distinct projects from given projects to **maximize your final capital**, and return *the final maximized capital*.
*Chọn một danh sách **tối đa** `k` dự án khác nhau từ các dự án đã cho để **tối đa hóa số vốn cuối cùng của bạn**, và trả về *số vốn tối đa cuối cùng này*.*

The answer is guaranteed to fit in a 32-bit signed integer.
*Đáp án được đảm bảo nằm trong phạm vi số nguyên có dấu 32-bit.*

## Example 1:
## *Ví dụ 1:*

**Input:** `k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]`
**Output:** `4`
**Explanation:** Since your initial capital is 0, you can only start the project indexed 0.
After finishing it you will obtain profit 1 and your capital becomes 1.
With capital 1, you can either start the project indexed 1 or the project indexed 2.
Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
Therefore, output the final capital, which is 0 + 1 + 3 = 4.

## Example 2:
## *Ví dụ 2:*

**Input:** `k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]`
**Output:** `6`

## Constraints:
## *Ràng buộc:*

*   `1 <= k <= 10^5`
*   `0 <= w <= 10^9`
*   `n == profits.length`
*   `n == capital.length`
*   `1 <= n <= 10^5`
*   `0 <= profits[i] <= 10^4`
*   `0 <= capital[i] <= 10^9`
