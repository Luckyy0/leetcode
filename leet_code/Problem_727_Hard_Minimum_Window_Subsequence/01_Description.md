# Result for Minimum Window Subsequence
# *Kết quả cho bài toán Chuỗi con tối thiểu chứa Dãy con (Minimum Window Subsequence)*

## Description
## *Mô tả*

Given strings `s1` and `s2`, return the minimum contiguous **substring** of `s1` such that `s2` is a **subsequence** of this substring.
*Cho hai chuỗi `s1` và `s2`, hãy trả về **chuỗi con** liên tục ngắn nhất của `s1` sao cho `s2` là một **dãy con** của chuỗi con này.*

If there is no such window in `s1` that covers all characters in `s2`, return the empty string `""`. If there are multiple such minimum-length windows, return the one with the **left-most starting index**.
*Nếu không có cửa sổ nào trong `s1` bao phủ toàn bộ các ký tự trong `s2`, hãy trả về chuỗi rỗng `""`. Nếu có nhiều cửa sổ có độ dài tối thiểu bằng nhau, hãy trả về cửa sổ có **chỉ số bắt đầu nằm ngoài cùng bên trái**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s1 = "abcdebdde", s2 = "bde"
**Output:** "bcde"
**Explanation:** 
"bcde" is the smallest substring of s1 that has "bde" as a subsequence.
"bdde" is also a substring that has "bde" as a subsequence, but "bcde" has a smaller start index.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s1.length <= 2 * 10^4`
*   `1 <= s2.length <= 100`
*   `s1` and `s2` consist of lowercase English letters.
