# 1328. Break a Palindrome / Phá vỡ một Palindrome

## Problem Description / Mô tả bài toán
Given palindrome string `palindrome`.
Replace exactly ONE character to make it NOT a palindrome and lexicographically smallest.
If impossible (length 1), return "".

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Character Replacement
To make lexicographically smallest:
- Try changing first possible character to 'a'.
- If palindrome already has 'a', skip it.
- Exception: If changing a character results in still a palindrome (impossible since we change only one?).
- Wait. "Make it NOT a palindrome".
- If we look at first half of palindrome. If we change any char to 'a' (unless it is already 'a'), it breaks palindrome property (since symmetric char is unchanged).
- Iterate `i` from 0 to `n/2 - 1`.
- If `s[i] != 'a'`, change `s[i]` to `a`. Return.
- If all chars in first half are 'a', it implies string is "aaaa...". Or "aba".
- In this case, change the LAST character to 'b'.
- Edge case: `n=1`. Impossible.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Change First Non-'a'
Iterate through the first half of the string. If a character is not 'a', change it to 'a'. This guarantees the smallest lexicographical result and breaks the palindrome (unless length is odd and we change the middle char, but we stop before middle). If all characters in the first half are 'a', the string must be all 'a's (e.g., "aa", "aba", "aaaa"). In this case, change the very last character to 'b' to achieve the smallest non-palindrome result. If the string length is 1, return an empty string.
Lặp lại qua nửa đầu của chuỗi. Nếu một ký tự không phải là 'a', hãy thay đổi nó thành 'a'. Điều này đảm bảo kết quả từ điển nhỏ nhất và phá vỡ palindrome (trừ khi độ dài là số lẻ và chúng ta thay đổi ký tự giữa, nhưng chúng ta dừng lại trước khi đến giữa). Nếu tất cả các ký tự trong nửa đầu đều là 'a', chuỗi phải là tất cả các chữ 'a' (ví dụ: "aa", "aba", "aaaa"). Trong trường hợp này, hãy thay đổi ký tự cuối cùng thành 'b' để đạt được kết quả không phải palindrome nhỏ nhất. Nếu độ dài chuỗi là 1, trả về một chuỗi rỗng.

---
