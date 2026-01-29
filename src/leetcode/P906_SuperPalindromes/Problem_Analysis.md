# 906. Super Palindromes / Số Siêu Đối xứng

## Problem Description / Mô tả bài toán
A positive integer is a super-palindrome if it is a palindrome, and it is also the square of a palindrome.
Một số nguyên dương được gọi là siêu đối xứng nếu nó là một số đối xứng và nó cũng là bình phương của một số đối xứng.

Given boundaries `left` and `right`, return the number of super-palindromes in the inclusive range `[left, right]`.
Cho các giới hạn `left` và `right`, hãy trả về số lượng các số siêu đối xứng trong khoảng `[left, right]`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Palindrome Construction / Xây dựng số Đối xứng
A super-palindrome is `P^2` where `P` is a palindrome.
Số siêu đối xứng có dạng `P^2` với `P` là một số đối xứng.
Since `right` can be up to 10^18, `P` can be up to 10^9.

Algorithm:
1. Generate all palindromes `P` up to 10^9.
   - You can generate half-numbers `h` and mirror them to create `P`.
2. For each `P`:
   - Calculate `V = P * P`.
   - Check if `V` is within `[left, right]`.
   - Check if `V` is a palindrome.

### Complexity / Độ phức tạp
- **Time**: O(R^(1/4) log R).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Root-based Generation
Instead of checking all numbers up to $10^{18}$, we generate potential square roots (palindromes) up to $10^9$. This reducing the search space to a manageable size.
Thay vì kiểm tra tất cả các số lên tới $10^{18}$, chúng ta tạo ra các căn bậc hai tiềm năng (các số đối xứng) lên tới $10^9$. Điều này giúp giảm không gian tìm kiếm xuống một quy mô có thể quản lý được.

---
