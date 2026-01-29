# 1071. Greatest Common Divisor of Strings / Ước chung Lớn nhất của Chuỗi

## Problem Description / Mô tả bài toán
For two strings `s` and `t`, we say "t divides s" if and only if `s = t + ... + t` (i.e., `t` is concatenated with itself one or more times).
Đối với hai chuỗi `s` và `t`, chúng ta nói "t chia hết s" nếu và chỉ nếu `s = t + ... + t` (tức là, `t` được nối với chính nó một hoặc nhiều lần).

Given two strings `str1` and `str2`, return the largest string `x` such that `x` divides both `str1` and `str2`.
Cho hai chuỗi `str1` và `str2`, hãy trả về chuỗi lớn nhất `x` sao cho `x` chia hết cả `str1` và `str2`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### String Logic and GCD / Logic Chuỗi và GCD
If `str1 + str2 != str2 + str1`, then no solution exists.
Return `""`.
Nếu `str1 + str2 != str2 + str1`, thì không tồn tại giải pháp.
Trả về `""`.

If a common divisor string exists, its length must be `gcd(len1, len2)`.
Let `L = gcd(len1, len2)`. The candidate string is the prefix of `str1` of length `L`.

Proof:
If `x` divides `str1`, `len(x)` divides `len(str1)`. Same for `str2`. Thus `len(x)` divides `gcd(len1, len2)`.
The largest such `x` would have length `gcd(len1, len2)`.

Algorithm:
1. Check if `str1 + str2 == str2 + str1`. If not, return `""`.
2. Compute `g = gcd(str1.length(), str2.length())`.
3. Return `str1.substring(0, g)`.

### Complexity / Độ phức tạp
- **Time**: O(N + M). String concatenation check.
- **Space**: O(N + M).

---

## Analysis / Phân tích

### Approach: Euclidean Algorithm Extension
First, verify if a common base structure exists by checking if `str1 + str2` equals `str2 + str1`. If this commutative property holds, the Greatest Common Divisor string is simply the prefix of length `gcd(length(str1), length(str2))`. This leverages the property that string repetition structure is isomorphic to integer multiplication.
Đầu tiên, xác minh xem cấu trúc cơ sở chung có tồn tại hay không bằng cách kiểm tra xem `str1 + str2` có bằng `str2 + str1` hay không. Nếu thuộc tính giao hoán này được giữ, chuỗi Ước chung Lớn nhất chỉ đơn giản là tiền tố có độ dài `gcd(length(str1), length(str2))`. Điều này tận dụng thuộc tính rằng cấu trúc lặp lại chuỗi là đẳng cấu với phép nhân số nguyên.

---
