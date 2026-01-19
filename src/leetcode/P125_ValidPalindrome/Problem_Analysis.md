# 125. Valid Palindrome / Chuỗi Đối Xứng Hợp Lệ

## Problem Description / Mô tả bài toán
A phrase is a **palindrome** if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Một cụm từ là một **chuỗi đối xứng** nếu, sau khi chuyển đổi tất cả các chữ hoa thành chữ thường và loại bỏ tất cả các ký tự không phải chữ cái-số, nó đọc giống nhau theo chiều thuận và chiều ngược. Các ký tự chữ cái-số bao gồm chữ cái và số.

Given a string `s`, return `true` if it is a **palindrome**, or `false` otherwise.
Cho một chuỗi `s`, trả về `true` nếu nó là một **chuỗi đối xứng**, hoặc `false` nếu không.

### Example 1:
```text
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
```

### Example 2:
```text
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
```

### Example 3:
```text
Input: s = " "
Output: true
Explanation: After removing non-alphanumeric, s is empty "". An empty string is a palindrome.
```

## Constraints / Ràng buộc
- `1 <= s.length <= 2 * 10^5`
- `s` consists only of printable ASCII characters.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Palindrome Definition / Định nghĩa Chuỗi Đối Xứng
A string `s` is a palindrome if `s == reverse(s)`.
Một chuỗi `s` là chuỗi đối xứng nếu `s == reverse(s)`.

Equivalently: `s[i] == s[n-1-i]` for all `0 <= i < n/2`.
Tương đương: `s[i] == s[n-1-i]` cho tất cả `0 <= i < n/2`.

### Two Pointer Technique / Kỹ thuật Hai Con Trỏ
Instead of creating a cleaned string, we can check in-place:
Thay vì tạo một chuỗi đã làm sạch, chúng ta có thể kiểm tra tại chỗ:

1.  Use `left` pointer starting from 0, `right` pointer from end.
2.  Skip non-alphanumeric characters.
3.  Compare alphanumeric characters (case-insensitive).
4.  If mismatch found, return false.
5.  If pointers cross without mismatch, return true.

### Character Classification / Phân loại Ký tự
- **Alphanumeric**: `'0'-'9'`, `'a'-'z'`, `'A'-'Z'`.
- Java: `Character.isLetterOrDigit(c)`.
- For comparison: `Character.toLowerCase(c)`.

---

## Analysis / Phân tích

### Approach: Two Pointers / Hai Con Trỏ

**Algorithm**:
```
left = 0, right = s.length - 1

while left < right:
    // Skip non-alphanumeric from left
    while left < right and not alphanumeric(s[left]):
        left++
    
    // Skip non-alphanumeric from right
    while left < right and not alphanumeric(s[right]):
        right--
    
    // Compare
    if toLowerCase(s[left]) != toLowerCase(s[right]):
        return false
    
    left++
    right--

return true
```

### Complexity / Độ phức tạp
- **Time**: O(N) - each character visited at most once.
- **Space**: O(1) - only pointers used.

---

## Edge Cases / Các trường hợp biên
1.  **Empty or whitespace only**: Return true.
2.  **Single character**: Return true.
3.  **All non-alphanumeric**: Return true.
4.  **Numbers included**: "0P" vs "P0" - not palindrome.
