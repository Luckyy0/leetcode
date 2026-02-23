# Result for Binary Watch
# *Kết quả cho bài toán Đồng hồ Nhị phân*

## Description
## *Mô tả*

A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom which represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.
*Một chiếc đồng hồ nhị phân có 4 đèn LED ở phía trên đại diện cho số giờ (0-11) và 6 đèn LED ở phía dưới đại diện cho số phút (0-59). Mỗi đèn LED đại diện cho 0 hoặc 1, với bit ít quan trọng nhất nằm ở bên phải.*

For example, the below binary watch reads "4:51".
*(Ví dụ, đồng hồ nhị phân dưới đây hiển thị "4:51".)*

Given an integer `turnedOn` which represents the number of LEDs that are currently on, return all possible times the watch could represent. You may return the answer in **any order**.
*Cho một số nguyên `turnedOn` đại diện cho số lượng đèn LED hiện đang bật, hãy trả về tất cả các thời gian khả thi mà đồng hồ có thể hiển thị. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.*

The hour must not contain a leading zero.
*Giờ không được chứa số 0 ở đầu.*
- For example, "01:00" is not valid, it should be "1:00".

The minute must be consist of two digits and may contain a leading zero.
*Phút phải bao gồm hai chữ số và có thể chứa số 0 ở đầu.*
- For example, "10:2" is not valid, it should be "10:02".

## Example 1:
## *Ví dụ 1:*

**Input:** `turnedOn = 1`
**Output:** `["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]`

## Example 2:
## *Ví dụ 2:*

**Input:** `turnedOn = 9`
**Output:** `[]`

## Constraints:
## *Ràng buộc:*

*   `0 <= turnedOn <= 10`
