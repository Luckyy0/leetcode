# Result for Stamping The Sequence
# *Kết quả cho bài toán Đóng dấu Chuỗi*

## Description
## *Mô tả*

You are given two strings `stamp` and `target`. Initially, there is a string `s` of length `target.length` with all `s[i] == '?'`.
*Bạn được cho hai chuỗi `stamp` và `target`. Ban đầu, có một chuỗi `s` có độ dài bằng `target.length` với tất cả `s[i] == '?'`.*

In one turn, you can place `stamp` over `s` and replace every letter in the `s` with the corresponding letter from `stamp`.
*Trong một lượt, bạn có thể đặt `stamp` lên `s` và thay thế mọi chữ cái trong `s` bằng chữ cái tương ứng từ `stamp`.*

*   For example, if `stamp = "abc"` and `target = "abcba"`, then `s` is `"?????"` initially. In one turn you can:
    *   place `stamp` at index `0` of `s` to obtain `"abc??"`,
    *   place `stamp` at index `1` of `s` to obtain `"?abc?"`, or
    *   place `stamp` at index `2` of `s` to obtain `"??abc"`.
    *   Note that `stamp` must be fully contained in the boundaries of `s` in order to stamp (i.e., you cannot place `stamp` at index `3` of `s`).
    *   *Lưu ý rằng `stamp` phải nằm hoàn toàn trong giới hạn của `s` để đóng dấu (tức là bạn không thể đặt `stamp` tại chỉ số `3` của `s`).*

We want to make `s` equal to `target` using **at most** `10 * target.length` turns.
*Chúng ta muốn làm cho `s` bằng `target` bằng cách sử dụng **tối đa** `10 * target.length` lượt.*

Return *an array of the index of the left-most letter being stamped at each turn*. If we cannot make `s` equal to `target`, return an empty array.
*Hãy trả về *một mảng chỉ số của chữ cái ngoài cùng bên trái được đóng dấu ở mỗi lượt*. Nếu chúng ta không thể làm cho `s` bằng `target`, hãy trả về một mảng rỗng.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** stamp = "abc", target = "ababc"
**Output:** [0,2]
**Explanation:** Initially s = "?????".
- Place stamp at index 0 to get "abc??".
- Place stamp at index 2 to get "ababc".
[1,0,2] would be incorrect because the new stamp must be fully contained in the boundaries of s.

## Example 2:
## *Ví dụ 2:*

**Input:** stamp = "abca", target = "aabcaca"
**Output:** [3,0,1]
**Explanation:** Initially s = "???????".
- Place stamp at index 3 to get "???abca".
- Place stamp at index 0 to get "abcabca".
- Place stamp at index 1 to get "aabcaca".

---

## Constraints:
## *Ràng buộc:*

*   `1 <= stamp.length <= target.length <= 1000`
*   `stamp` and `target` consist of lowercase English letters.
