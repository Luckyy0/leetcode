# Result for Tag Validator
# *Kết quả cho bài toán Trình xác thực Thẻ*

## Description
## *Mô tả*

Given a string representing a code snippet, implement a tag validator to parse the code and return whether it is valid.
*Cho một chuỗi đại diện cho một đoạn mã, hãy triển khai trình xác thực thẻ để phân tích cú pháp mã và trả về kết quả xem nó có hợp lệ hay không.*

A code snippet is valid if all the following rules are satisfied:
*Một đoạn mã hợp lệ nếu tất cả các quy tắc sau đây được thỏa mãn:*

1.  The code must be wrapped in a **valid closed tag**. Otherwise, the code is invalid.
    *Mã phải được bao bọc trong một **thẻ đóng hợp lệ**. Nếu không, mã không hợp lệ.*
2.  A **valid closed tag** is defined as follows:
    *Một **thẻ đóng hợp lệ** được định nghĩa như sau:*
    - The start tag is in the format `<TAG_NAME>`, and the end tag is in the format `</TAG_NAME>`. The `TAG_NAME` in the start and end tags should be the same.
    - *Thẻ mở có định dạng `<TAG_NAME>`, và thẻ đóng có định dạng `</TAG_NAME>`. `TAG_NAME` trong thẻ mở và thẻ đóng phải giống nhau.*
    - `TAG_NAME` only contains **uppercase letters**, and has a length in the range `[1, 9]`.
    - *`TAG_NAME` chỉ chứa **chữ cái in hoa**, và có độ dài trong khoảng `[1, 9]`.*
3.  A **valid content** is defined as the characters between the start tag and the end tag. The content could contain other **valid closed tags**, **cdata** and any characters (including digits, lowercase letters, special characters, etc.) **EXCEPT** characters that look like `<TAG_NAME>` and `</TAG_NAME>` but are invalid (e.g. `<tag_name>`, `</TAG_NAME123>`, etc.).
    *Một **nội dung hợp lệ** được định nghĩa là các ký tự giữa thẻ mở và thẻ đóng. Nội dung có thể chứa các **thẻ đóng hợp lệ** khác, **cdata** và bất kỳ ký tự nào (bao gồm chữ số, chữ cái thường, ký tự đặc biệt, v.v.) **NGOẠI TRỪ** các ký tự trông giống `<TAG_NAME>` và `</TAG_NAME>` nhưng không hợp lệ.*
4.  **CDATA** is in the format `<![CDATA[CDATA_CONTENT]]>`. The `CDATA_CONTENT` could contain any characters. The format `<![CDATA[` and `]]>` is fixed and used to separate the `CDATA_CONTENT`.
    ***CDATA** có định dạng `<![CDATA[CDATA_CONTENT]]>`. `CDATA_CONTENT` có thể chứa bất kỳ ký tự nào. Định dạng `<![CDATA[` và `]]>` là cố định và được dùng để phân tách `CDATA_CONTENT`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** code = "<DIV>This is the first line <![CDATA[<div>]]><BR/></DIV>"
**Output:** true

---

## Constraints:
## *Ràng buộc:*

*   `1 <= code.length <= 500`
*   `code` consists of English letters, digits, `'<'`, `'>'`, `'/'`, `'!'`, `'['`, `']'`, and `' '`.
