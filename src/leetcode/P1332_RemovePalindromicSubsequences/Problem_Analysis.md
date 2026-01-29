# 1332. Remove Palindromic Subsequences / Xóa các Chuỗi con Palindrome

## Problem Description / Mô tả bài toán
String `s` (only 'a', 'b').
In one step, remove a palindromic *subsequence*.
Return min steps to make string empty.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Subsequence Property
If `s` is empty -> 0 steps.
If `s` is already palindrome -> 1 step.
If `s` not palindrome:
- Since only 'a' and 'b', we can remove ALL 'a's in one step (subsequence of all 'a's is palindrome "aaa...").
- Then remove ALL 'b's in second step.
- So at most 2 steps.
Check if string is palindrome.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) or O(1).

---

## Analysis / Phân tích

### Approach: Check Palindrome
Since we can remove *subsequences*, and there are only two characters ('a', 'b'), we can always remove all 'a's (which form a palindrome subsequence) in step 1, and all 'b's in step 2. Thus, the answer is at most 2. If the string is empty, return 0. If the string itself is a palindrome, we can remove it all in 1 step. Return 1. Otherwise, return 2.
Vì chúng ta có thể xóa các *chuỗi con*, và chỉ có hai ký tự ('a', 'b'), chúng ta luôn có thể xóa tất cả các chữ 'a' (tạo thành một chuỗi con palindrome) trong bước 1 và tất cả các chữ 'b' trong bước 2. Do đó, câu trả lời tối đa là 2. Nếu chuỗi trống, trả về 0. Nếu chính chuỗi đó là một palindrome, chúng ta có thể xóa tất cả trong 1 bước. Trả về 1. Ngược lại, trả về 2.

---
