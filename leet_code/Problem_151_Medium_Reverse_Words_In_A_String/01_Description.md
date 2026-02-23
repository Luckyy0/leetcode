# Result for Reverse Words in a String
# *Kết quả cho bài toán Đảo ngược từ trong chuỗi*

## Description
## *Mô tả*

Given an input string `s`, reverse the order of the **words**.
*Cho một chuỗi đầu vào `s`, hãy đảo ngược thứ tự của các **từ***.*

A **word** is defined as a sequence of non-space characters. The **words** in `s` will be separated by at least one space.
*Một **từ** được định nghĩa là một chuỗi các ký tự không phải khoảng trắng. Các **từ** trong `s` được phân tách bởi ít nhất một khoảng trắng.*

Return *a string of the words in reverse order concatenated by a single space*.
*Trả về *một chuỗi các từ theo thứ tự đảo ngược nối với nhau bằng một khoảng trắng duy nhất***.*

**Note** that `s` may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
**Lưu ý** rằng `s` có thể chứa các khoảng trắng ở đầu hoặc cuối hoặc nhiều khoảng trắng giữa hai từ. Chuỗi trả về chỉ nên có một khoảng trắng duy nhất ngăn cách các từ. Đừng bao gồm bất kỳ khoảng trắng dư thừa nào.

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "the sky is blue"`
**Output:** `"blue is sky the"`

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "  hello world  "`
**Output:** `"world hello"`
**Explanation:** Your reversed string should not contain leading or trailing spaces.

## Example 3:
## *Ví dụ 3:*

**Input:** `s = "a good   example"`
**Output:** `"example good a"`
**Explanation:** You need to reduce multiple spaces between two words to a single space in the reversed string.

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 10^4`
*   `s` contains English letters (upper-case and lower-case), digits, and spaces `' '`.
*   There is **at least one** word in `s`.
