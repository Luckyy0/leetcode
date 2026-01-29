# 1189. Maximum Number of Balloons / Số lượng Bóng bay Tối đa

## Problem Description / Mô tả bài toán
Given a string `text`, you want to use the characters of `text` to form as many instances of the word "balloon" as possible.
You can use each character in `text` at most once. Return the maximum number of instances that can be formed.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Frequency Count
Count 'b', 'a', 'l', 'o', 'n'.
'l' and 'o' require 2 instances per word.
Result = `min(b, a, l/2, o/2, n)`.

---
