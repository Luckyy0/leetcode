# Result for Reorder Data in Log Files
# *Kết quả cho bài toán Sắp xếp lại Dữ liệu trong Tệp Nhật ký*

## Description
## *Mô tả*

You are given an array of `logs`. Each log is a space-delimited string of words, where the first word is the **identifier**.
*Bạn được cấp một mảng `logs`. Mỗi nhật ký là một chuỗi các từ được phân tách bằng dấu cách, trong đó từ đầu tiên là **mã định danh**.*

There are two types of logs:
*Có hai loại nhật ký:*

*   **Letter-logs**: All words (except the identifier) consist of lowercase English letters.
    *   **Nhật ký chữ cái**: Tất cả các từ (ngoại trừ mã định danh) bao gồm các chữ cái tiếng Anh viết thường.*
*   **Digit-logs**: All words (except the identifier) consist of digits.
    *   **Nhật ký chữ số**: Tất cả các từ (ngoại trừ mã định danh) bao gồm các chữ số.*

Reorder these logs so that:
*Sắp xếp lại các nhật ký này sao cho:*

1.  The **letter-logs** come before all **digit-logs**.
    *   **Nhật ký chữ cái** đứng trước tất cả **nhật ký chữ số**.*
2.  The **letter-logs** are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
    *   **Nhật ký chữ cái** được sắp xếp theo thứ tự từ điển theo nội dung của chúng. Nếu nội dung của chúng giống nhau, hãy sắp xếp chúng theo thứ tự từ điển theo mã định danh của chúng.*
3.  The **digit-logs** maintain their relative ordering.
    *   **Nhật ký chữ số** duy trì thứ tự tương đối của chúng.*

Return *the final order of the logs*.
*Trả về *thứ tự cuối cùng của nhật ký*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
**Output:** ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
**Explanation:**
The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".

## Example 2:
## *Ví dụ 2:*

**Input:** logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
**Output:** ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= logs.length <= 100`
*   `3 <= logs[i].length <= 100`
*   All the tokens of `logs[i]` are separated by a single space.
*   `logs[i]` is guaranteed to have an identifier and at least one word after the identifier.
