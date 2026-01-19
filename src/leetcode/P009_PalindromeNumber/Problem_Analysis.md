# 9. Palindrome Number / Số Đối Xứng

## Problem Description / Mô tả bài toán
Given an integer `x`, return `true` if `x` is a palindrome integer.
Cho một số nguyên `x`, trả về `true` nếu `x` là một số nguyên đối xứng.

An integer is a palindrome when it reads the same backward as forward.
Một số nguyên là đối xứng khi nó đọc giống nhau từ sau ra trước cũng như từ trước ra sau.
- For example, `121` is a palindrome while `123` is not.
- Ví dụ, `121` là số đối xứng trong khi `123` thì không.

### Example 1:
```text
Input: x = 121
Output: true
```

### Example 2:
```text
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
```

### Example 3:
```text
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
```

## Constraints / Ràng buộc
- `-2^31 <= x <= 2^31 - 1`

**Follow up**: Could you solve it without converting the integer to a string?
**Mở rộng**: Bạn có thể giải quyết vấn đề mà không cần chuyển đổi số nguyên thành chuỗi không?

---

## Analysis / Phân tích

### Approach 1: Convert to String / Chuyển sang Chuỗi
- **Idea**: Convert integer to string and check if the string is a palindrome (easy).
- **Ý tưởng**: Chuyển số nguyên thành chuỗi và kiểm tra xem chuỗi có đối xứng không (dễ).
- **Time Complexity**: O(log10(x)) to convert to string.
- **Space Complexity**: O(log10(x)) to store the string.

### Approach 2: Revert Half of the Number / Đảo Ngược Một Nửa Số
- **Idea**: To avoid overflow and extra space, we can revert the second half of the number and compare it with the first half.
- **Ý tưởng**: Để tránh tràn số và tốn thêm không gian, ta có thể đảo ngược nửa sau của số và so sánh với nửa đầu.
    - Example: `x = 1221`. Reverted second half: `12`. First half: `12`. `12 == 12`.
    - Example: `x = 12321`. Reverted second half: `123`. First half: `12`. Loop ends. Wait, we handle odd/even lengths carefully.
        - Correct logic: loop while `x > revertedNumber`.
        - End check: `x == revertedNumber` (even length) or `x == revertedNumber / 10` (odd length).
- **Edge Cases**:
    - Negative numbers: Always `false`.
    - Ends with 0 (but not 0 itself): Always `false` (e.g., 10 -> 01 is not equal).
- **Time Complexity**: O(log10(x)). We process half the digits.
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  `x < 0`: Return `false` immediately.
2.  `x = 0`: Return `true`.
3.  `x % 10 == 0` and `x != 0`: Return `false` (e.g., 10, 20).
4.  `x` is max integer (handled naturally).
