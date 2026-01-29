# 901. Online Stock Span / Khoảng giá Cổ phiếu Trực tuyến

## Problem Description / Mô tả bài toán
Design an algorithm that collects daily price quotes for some stock and returns the **span** of that stock's price for the current day.
Thiết kế một thuật toán thu thập báo giá cổ phiếu hàng ngày và trả về **khoảng (span)** giá của cổ phiếu đó cho ngày hiện tại.

The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.
Khoảng giá cổ phiếu trong một ngày là số ngày liên tiếp tối đa (bắt đầu từ ngày đó và đi ngược về trước) mà giá cổ phiếu nhỏ hơn hoặc bằng giá của ngày đó.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Monotonic Stack / Ngăn xếp Đơn điệu
This is a classic application of a monotonic stack.
Đây là một ứng dụng kinh điển của ngăn xếp đơn điệu.

Algorithm:
1. Maintain a stack of pairs `(price, span)`.
2. When a `next(price)` call arrives:
   - Initialize `currentSpan = 1`.
   - While the stack is not empty and the top price is less than or equal to the current `price`:
     - Pop the top and add its span to `currentSpan`.
   - Push `(price, currentSpan)` onto the stack.
   - Return `currentSpan`.

### Complexity / Độ phức tạp
- **Time**: O(1) amortized per call.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Dynamic Aggregation
Use a stack to remember previous price peaks. By "collapsing" all contiguous lower prices into a single summary span, we avoid re-scanning historical data and achieve high efficiency.
Sử dụng một ngăn xếp để ghi nhớ các đỉnh giá trước đó. Bằng cách "thu gọn" tất cả các mức giá thấp hơn liên tiếp thành một khoảng giá tóm tắt duy nhất, chúng ta tránh việc quét lại dữ liệu lịch sử và đạt được hiệu quả cao.

---
