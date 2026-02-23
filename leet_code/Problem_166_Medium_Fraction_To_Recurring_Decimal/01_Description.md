# Result for Fraction to Recurring Decimal
# *Kết quả cho bài toán Chuyển đổi phân số thành số thập phân vô hạn tuần hoàn*

## Description
## *Mô tả*

Given two integers representing the `numerator` and `denominator` of a fraction, return *the fraction in string format*.
*Cho hai số nguyên đại diện cho `tử số` và `mẫu số` của một phân số, hãy trả về *phân số đó dưới định dạng chuỗi***.*

If the fractional part is repeating, enclose the repeating part in parentheses.
*Nếu phần thập phân bị lặp lại, hãy đặt phần lặp lại đó trong dấu ngoặc đơn.*

If multiple answers are possible, return **any of them**.
*Nếu có nhiều câu trả lời khả thi, hãy trả về **bất kỳ câu trả lời nào trong số đó***.*

It is **guaranteed** that the length of the answer string is less than `10^4` for all the given test cases.
*Đảm bảo rằng độ dài của chuỗi kết quả nhỏ hơn `10^4` cho tất cả các trường hợp kiểm thử.*

## Example 1:
## *Ví dụ 1:*

**Input:** `numerator = 1, denominator = 2`
**Output:** `"0.5"`

## Example 2:
## *Ví dụ 2:*

**Input:** `numerator = 2, denominator = 1`
**Output:** `"2"`

## Example 3:
## *Ví dụ 3:*

**Input:** `numerator = 4, denominator = 333`
**Output:** `"0.(012)"`

## Constraints:
## *Ràng buộc:*

*   `-2^31 <= numerator, denominator <= 2^31 - 1`
*   `denominator != 0`
