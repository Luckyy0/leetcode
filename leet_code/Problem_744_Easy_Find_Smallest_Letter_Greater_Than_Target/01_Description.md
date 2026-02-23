# Result for Find Smallest Letter Greater Than Target
# *Kết quả cho bài toán Tìm Ký tự Nhỏ nhất Lớn hơn Mục tiêu*

## Description
## *Mô tả*

You are given an array of characters `letters` that is sorted in **non-decreasing order**, and a character `target`. There are **at least two different** characters in `letters`.
*Bạn được cho một mảng các ký tự `letters` đã được sắp xếp theo **thứ tự không giảm**, và một ký tự `target`. Có **ít nhất hai** ký tự khác nhau trong `letters`.*

Return *the smallest character in `letters` that is lexicographically greater than `target`*. If such a character does not exist, return the first character in `letters`.
*Hãy trả về *ký tự nhỏ nhất trong `letters` mà lớn hơn `target` theo thứ tự từ điển*. Nếu ký tự như vậy không tồn tại, trả về ký tự đầu tiên trong `letters`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** letters = ["c","f","j"], target = "a"
**Output:** "c"
**Explanation:** The smallest character that is lexicographically greater than 'a' in letters is 'c'.

## Example 2:
## *Ví dụ 2:*

**Input:** letters = ["c","f","j"], target = "c"
**Output:** "f"
**Explanation:** The smallest character greater than 'c' is 'f'.

## Example 3:
## *Ví dụ 3:*

**Input:** letters = ["x","x","y","y"], target = "z"
**Output:** "x"
**Explanation:** There are no characters in letters that is lexicographically greater than 'z', so we return letters[0].

---

## Constraints:
## *Ràng buộc:*

*   `2 <= letters.length <= 10^4`
*   `letters[i]` is a lowercase English letter.
*   `letters` is sorted in **non-decreasing** order.
*   `letters` contains at least two different characters.
*   `target` is a lowercase English letter.
