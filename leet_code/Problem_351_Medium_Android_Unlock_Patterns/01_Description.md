# Result for Android Unlock Patterns
# *Kết quả cho bài toán Mẫu Khóa Android*

## Description
## *Mô tả*

Android devices have a special lock screen with a `3 x 3` grid of dots. Users can create an "unlock pattern" by connecting the dots in a specific sequence. A pattern is valid if it meets the following rules:
*Thiết bị Android có màn hình khóa đặc biệt với lưới chấm `3 x 3`. Người dùng có thể tạo "mẫu mở khóa" bằng cách kết nối các chấm theo một trình tự cụ thể. Một mẫu là hợp lệ nếu nó đáp ứng các quy tắc sau:*

1.  Each pattern must connect at least `m` dots and at most `n` dots.
    *Mỗi mẫu phải kết nối ít nhất `m` chấm và tối đa `n` chấm.*
2.  All dots in a pattern must be **distinct**.
    *Tất cả các chấm trong một mẫu phải **khác biệt**.*
3.  If the line connecting two consecutive dots in the pattern passes through any other dot, the other dot **must have previously been in the pattern**. No other dots can be skipped.
    *Nếu đường nối hai chấm liên tiếp trong mẫu đi qua bất kỳ chấm nào khác, chấm đó **phải thuộc mẫu từ trước đó**. Không chấm nào khác được phép bị bỏ qua.*
4.  The order of dots matters.
    *Thứ tự của các chấm là quan trọng.*

Return *the number of unique and valid unlock patterns of the Android lock screen* that consist of at least `m` keys and at most `n` keys.
*Trả về *số lượng mẫu mở khóa Android duy nhất và hợp lệ* bao gồm ít nhất `m` khóa và tối đa `n` khóa.*

Two patterns are considered unique if there is a dot in one sequence that is not in the other, or the order of the dots is different.
*Hai mẫu được coi là duy nhất nếu có một chấm trong trình tự này không có trong trình tự kia, hoặc thứ tự của các chấm là khác nhau.*

## Example 1:
## *Ví dụ 1:*

**Input:** `m = 1, n = 1`
**Output:** `9`

## Example 2:
## *Ví dụ 2:*

**Input:** `m = 1, n = 2`
**Output:** `65`

## Constraints:
## *Ràng buộc:*

*   `1 <= m, n <= 9`
