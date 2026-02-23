# Result for Minimum Window Substring
# *Kết quả cho bài toán Chuỗi Con Cửa Sổ Tối Thiểu*

## Description
## *Mô tả*

Given two strings `s` and `t` of lengths `m` and `n` respectively, return *the **minimum window substring** of `s` such that every character in `t` (**including duplicates**) is included in the window*. If there is no such substring, return the empty string `""`.
*Cho hai chuỗi `s` và `t` có độ dài lần lượt là `m` và `n`, hãy trả về *chuỗi con cửa sổ tối thiểu** của `s` sao cho mọi ký tự trong `t` (**bao gồm cả các ký tự trùng lặp**) đều được bao gồm trong cửa sổ đó*. Nếu không có chuỗi con nào như vậy, hãy trả về chuỗi rỗng `""`.*

The testcases will be generated such that the answer is **unique**.
*Các trường hợp kiểm thử sẽ được tạo sao cho câu trả lời là **duy nhất**.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "ADOBECODEBANC", t = "ABC"`
**Output:** `"BANC"`
**Explanation:** The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "a", t = "a"`
**Output:** `"a"`
**Explanation:** The entire string s is the minimum window.

## Example 3:
## *Ví dụ 3:*

**Input:** `s = "a", t = "aa"`
**Output:** `" "`
**Explanation:** Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.

## Constraints:
## *Ràng buộc:*

*   `m == s.length`
*   `n == t.length`
*   `1 <= m, n <= 10^5`
*   `s` and `t` consist of uppercase and lowercase English letters.

## Follow up:
*   Could you find an algorithm that runs in $O(m + n)$ time?
