# 680. Valid Palindrome II / Chuỗi Đối xứng II

## Problem Description / Mô tả bài toán
Given a string `s`, return `true` if the `s` can be palindrome after deleting **at most one** character from it.
Cho một chuỗi `s`, trả về `true` nếu `s` có thể là chuỗi đối xứng sau khi xóa **nhiều nhất một** ký tự khỏi nó.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Two Pointers / Hai con Trỏ
We use two pointers, `left` and `right`, starting at the ends of the string.
Chúng ta sử dụng hai con trỏ, `left` và `right`, bắt đầu từ hai đầu chuỗi.

- If `s[left] == s[right]`, move both inwards.
- If `s[left] != s[right]`, we have two options:
  1. Skip `s[left]` and check if `s[left+1...right]` is a palindrome.
  2. Skip `s[right]` and check if `s[left...right-1]` is a palindrome.

If either option yields a palindrome, return `true`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of the string.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Greedy Divergence
A single mismatch triggers a verification of the two potential remaining substrings. This remains efficient because we only allow one deletion.
Một sự không khớp duy nhất sẽ kích hoạt việc xác minh hai chuỗi con tiềm năng còn lại. Điều này vẫn hiệu quả vì chúng ta chỉ cho phép một lần xóa.

---
