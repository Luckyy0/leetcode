# Result for String Without AAA or BBB
# *Kết quả cho bài toán Chuỗi không có AAA hoặc BBB*

## Description
## *Mô tả*

Given two integers `a` and `b`, return **any** string `s` such that:
*Cho hai số nguyên `a` và `b`, trả về **bất kỳ** chuỗi `s` nào sao cho:*

*   `s` has length `a + b` and contains exactly `a` `'a'` letters, and exactly `b` `'b'` letters,
    *   *`s` có độ dài `a + b` và chứa chính xác `a` chữ cái `'a'`, và chính xác `b` chữ cái `'b'`,*
*   The substring `'aaa'` does not occur in `s`, and
    *   *Chuỗi con `'aaa'` không xuất hiện trong `s`, và*
*   The substring `'bbb'` does not occur in `s`.
    *   *Chuỗi con `'bbb'` không xuất hiện trong `s`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** a = 1, b = 2
**Output:** "abb"
**Explanation:** "abb", "bab" and "bba" are all correct answers.

## Example 2:
## *Ví dụ 2:*

**Input:** a = 4, b = 1
**Output:** "aabaa"

---

## Constraints:
## *Ràng buộc:*

*   `0 <= a, b <= 100`
*   It is guaranteed such an `s` exists for the given `a` and `b`.
