# 7. Reverse Integer / Đảo Ngược Số Nguyên

## Problem Description / Mô tả bài toán
Given a signed 32-bit integer `x`, return `x` with its digits reversed. If reversing `x` causes the value to go outside the signed 32-bit integer range `[-2^31, 2^31 - 1]`, then return `0`.
Cho một số nguyên 32-bit có dấu `x`, trả về `x` với các chữ số bị đảo ngược. Nếu việc đảo ngược `x` làm cho giá trị vượt ra ngoài phạm vi số nguyên 32-bit có dấu `[-2^31, 2^31 - 1]`, thì trả về `0`.

**Assume the environment does not allow you to store 64-bit integers (signed or unsigned).**
**Giả sử môi trường không cho phép bạn lưu trữ số nguyên 64-bit (có dấu hoặc không dấu).**

### Example 1:
```text
Input: x = 123
Output: 321
```

### Example 2:
```text
Input: x = -123
Output: -321
```

### Example 3:
```text
Input: x = 120
Output: 21
```

## Constraints / Ràng buộc
- `-2^31 <= x <= 2^31 - 1`

---

## Analysis / Phân tích

### Approach: Pop and Push Digits & Check for Overflow / Lấy và Đẩy Chữ Số & Kiểm Tra Tràn Số
- **Idea**: We can build the reverse number by repeatedly taking the last digit of `x` (`x % 10`) and appending it to the result (`rev * 10 + digit`).
- **Ý tưởng**: Chúng ta có thể xây dựng số đảo ngược bằng cách liên tục lấy chữ số cuối cùng của `x` (`x % 10`) và thêm nó vào kết quả (`rev * 10 + digit`).
- **Overflow Check**: The tricky part is preventing overflow *before* it happens because we verify `rev * 10 + digit`.
- **Kiểm tra Tràn Số**: Phần khó là ngăn chặn tràn số *trước khi* nó xảy ra vì ta cần kiểm tra `rev * 10 + digit`.
    - If `rev > Integer.MAX_VALUE / 10`, it will overflow.
    - If `rev == Integer.MAX_VALUE / 10` and `digit > 7` (since MAX is 2147483647), it will overflow.
    - Similarly for `Integer.MIN_VALUE` (MIN is -2147483648, last digit -8).
- **Time Complexity**: O(log(x)). The number of digits in x is roughly log10(x).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Positive Overflow**: 2147483647 (Reverse tries to be huge, return 0).
2.  **Negative Overflow**: -2147483648.
3.  **Trailing Zeros**: 120 -> 21.
4.  **Single Digit**: 5 -> 5.
