# Result for Online Stock Span
# *Kết quả cho bài toán Nhịp độ Chứng khoán Trực tuyến*

## Description
## *Mô tả*

Design an algorithm that collects daily price quotes for some stock and returns the **span** of that stock's price for the current day.
*Thiết kế một thuật toán thu thập báo giá chứng khoán hàng ngày cho một loại cổ phiếu và trả về **nhịp độ** (span) giá của cổ phiếu đó cho ngày hiện tại.*

The **span** of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.
* **Nhịp độ** giá cổ phiếu trong một ngày là số ngày liên tiếp tối đa (bắt đầu từ ngày đó và lùi về quá khứ) mà giá cổ phiếu nhỏ hơn hoặc bằng giá của ngày hôm đó.*

For example, if the prices of the stock in the last four days is `[7,2,1,2]` and the price of the stock today is `2`, then the span of today is `4` because starting from today, the price of the stock was less than or equal `2` for `4` consecutive days.
*Ví dụ, nếu giá cổ phiếu trong bốn ngày qua là `[7,2,1,2]` và giá cổ phiếu hôm nay là `2`, thì nhịp độ của ngày hôm nay là `4` vì tính từ hôm nay, giá cổ phiếu đã nhỏ hơn hoặc bằng `2` trong `4` ngày liên tiếp.*

Also, if the prices of the stock in the last four days is `[7,34,1,2]` and the price of the stock today is `8`, then the span of today is `3` because starting from today, the price of the stock was less than or equal `8` for `3` consecutive days.
*Ngoài ra, nếu giá cổ phiếu trong bốn ngày qua là `[7,34,1,2]` và giá cổ phiếu hôm nay là `8`, thì nhịp độ của ngày hôm nay là `3` vì tính từ hôm nay, giá cổ phiếu đã nhỏ hơn hoặc bằng `8` trong `3` ngày liên tiếp.*

Implement the `StockSpanner` class:
*Triển khai lớp `StockSpanner`:*

*   `StockSpanner()` Initializes the object of the class.
    *   `StockSpanner()` Khởi tạo đối tượng của lớp.*
*   `int next(int price)` Returns the **span** of the stock's price given that today's price is `price`.
    *   `int next(int price)` Trả về **nhịp độ** giá cổ phiếu khi biết giá hôm nay là `price`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
**Output:** [null, 1, 1, 1, 2, 1, 4, 6]
**Explanation:** 
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2 (60 <= 70)
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4 (60, 70, 60 <= 75)
stockSpanner.next(85);  // return 6 (100 is > 85, but all others <= 85)

---

## Constraints:
## *Ràng buộc:*

*   `1 <= price <= 10^5`
*   At most `10^4` calls will be made to `next`.
