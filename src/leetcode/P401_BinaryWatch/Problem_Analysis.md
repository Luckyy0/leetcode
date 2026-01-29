# 401. Binary Watch / Đồng Hồ Nhị Phân

## Problem Description / Mô tả bài toán
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom which represent the minutes (0-59).
Một chiếc đồng hồ nhị phân có 4 đèn LED ở phía trên đại diện cho số giờ (0-11) và 6 đèn LED ở phía dưới đại diện cho số phút (0-59).

Each LED represents a zero or one, with the least significant bit on the right.
Mỗi đèn LED đại diện cho số 0 hoặc 1, với bit ít quan trọng nhất nằm ở bên phải.

Given an integer `turnedOn` which represents the number of LEDs that are currently on, return all possible times the watch could represent. You may return the answer in any order.
Cho một số nguyên `turnedOn` đại diện cho số lượng đèn LED hiện đang bật, hãy trả về tất cả các mốc thời gian có thể có mà đồng hồ có thể hiển thị. Bạn có thể trả về câu trả lời theo bất kỳ thứ tự nào.

The hour must not contain a leading zero.
- For example, "01:00" is not valid, it should be "1:00".
Số giờ không được chứa số 0 ở đầu.

The minute must be consist of two digits and may contain a leading zero.
- For example, "10:2" is not valid, it should be "10:02".
Số phút phải bao gồm hai chữ số và có thể chứa số 0 ở đầu.

### Example 1:
```text
Input: turnedOn = 1
Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
```

### Example 2:
```text
Input: turnedOn = 9
Output: []
```

## Constraints / Ràng buộc
- `0 <= turnedOn <= 10`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Bit Counting / Đếm Bit
Since the range of hours (0-11) and minutes (0-59) is very small, we can iterate through all possible combinations of hours and minutes.
For each combination `(h, m)`, we calculate the total number of set bits (1s) in both `h` and `m`.
If `Integer.bitCount(h) + Integer.bitCount(m) == turnedOn`, the time is valid.

### Complexity / Độ phức tạp
- **Time**: O(1) - specifically checking 12 * 60 = 720 combinations.
- **Space**: O(1) - excluding the space for the result list.

---

## Analysis / Phân tích

### Approach: Brute Force Iteration

**Algorithm**:
1.  Initialize an empty list `res`.
2.  Loop `h` from 0 to 11:
    - Loop `m` from 0 to 59:
        - If `Integer.bitCount(h) + Integer.bitCount(m) == turnedOn`:
            - Format the time as `h:mm`.
            - Add to `res`.
3.  Return `res`.

---
