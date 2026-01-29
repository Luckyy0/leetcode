# 686. Repeated String Match / Chuỗi Lặp lại Khớp nhau

## Problem Description / Mô tả bài toán
Given two strings `a` and `b`, return the minimum number of times `a` has to be repeated such that `b` is a substring of it. If it is impossible, return -1.
Cho hai chuỗi `a` và `b`, hãy trả về số lần tối thiểu `a` phải được lặp lại sao cho `b` là một chuỗi con của nó. Nếu điều đó là không thể, hãy trả về -1.

Notice: string `"abc"` repeated 0 times is `""`, repeated 1 time is `"abc"`, repeated 2 times is `"abcabc"`.
Lưu ý: chuỗi "abc" lặp lại 0 lần là "", lặp lại 1 lần là "abc", lặp lại 2 lần là "abcabc".

---

## Theoretical Foundation / Cơ sơ lý thuyết

### String Manipulation / Thao tác Chuỗi
If `b` is a substring of repeated `a`, then `b` must appear within at most `ceil(b.length / a.length) + 1` repetitions.
Nếu `b` là một chuỗi con của `a` lặp lại, thì `b` phải xuất hiện trong tối đa `ceil(b.length / a.length) + 1` lần lặp.

- Repeat `a` until its length is >= `b.length`. This is `k` repeats.
- Check if `b` is in `a * k`.
- If not, check if `b` is in `a * (k + 1)`.
- If still no, return -1.

### Complexity / Độ phức tạp
- **Time**: O(N + M) where N and M are the lengths of `a` and `b` (using `indexOf` or KMP).
- **Space**: O(N + M) to store the repeated string.

---

## Analysis / Phân tích

### Approach: Bounded Search
Since `b` must fit within the repeated copies of `a`, once the total length exceeds `b`'s length plus two extra copies of `a`, no more repetitions can help.
Vì `b` phải nằm gọn trong các bản sao lặp lại của `a`, một khi tổng độ dài vượt quá độ dài của `b` cộng với hai bản sao thừa của `a`, thì không có lần lặp nào nữa có thể giúp ích được.

---
