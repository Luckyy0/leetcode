# Result for Largest Time for Given Digits
# *Kết quả cho bài toán Thời gian Lớn nhất cho các Chữ số đã cho*

## Description
## *Mô tả*

Given an array `arr` of 4 digits, find the latest 24-hour time that can be made using each digit **exactly once**.
*Cho một mảng `arr` gồm 4 chữ số, hãy tìm thời gian 24 giờ muộn nhất có thể được tạo ra bằng cách sử dụng mỗi chữ số **chính xác một lần**.*

24-hour times are formatted as `"HH:MM"`, where `HH` is between `00` and `23`, and `MM` is between `00` and `59`. The earliest 24-hour time is `00:00`, and the latest is `23:59`.
*Thời gian 24 giờ được định dạng là `"HH:MM"`, trong đó `HH` nằm trong khoảng từ `00` đến `23`, và `MM` nằm trong khoảng từ `00` đến `59`. Thời gian 24 giờ sớm nhất là `00:00`, và muộn nhất là `23:59`.*

Return *the latest 24-hour time in `"HH:MM"` format*. If no valid time can be made, return an empty string.
*Trả về *thời gian 24 giờ muộn nhất ở định dạng `"HH:MM"`*. Nếu không tạo được thời gian hợp lệ nào, hãy trả về một chuỗi rỗng.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** arr = [1,2,3,4]
**Output:** "23:41"
**Explanation:** The valid 24-hour times are "12:34", "12:43", "13:24", "13:42", "14:23", "14:32", "21:34", "21:43", "23:14", and "23:41". Of these times, "23:41" is the latest.

## Example 2:
## *Ví dụ 2:*

**Input:** arr = [5,5,5,5]
**Output:** ""
**Explanation:** There are no valid 24-hour times as "55:55" is not valid.

## Example 3:
## *Ví dụ 3:*

**Input:** arr = [0,0,0,0]
**Output:** "00:00"

## Example 4:
## *Ví dụ 4:*

**Input:** arr = [0,0,1,0]
**Output:** "10:00"

---

## Constraints:
## *Ràng buộc:*

*   `arr.length == 4`
*   `0 <= arr[i] <= 9`
