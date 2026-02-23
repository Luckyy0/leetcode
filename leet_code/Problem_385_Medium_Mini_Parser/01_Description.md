# Result for Mini Parser
# *Kết quả cho bài toán Bộ phân tích Nhỏ*

## Description
## *Mô tả*

Given a string `s` representing the serialization of a nested list, implement a parser to deserialize it and return the deserialized `NestedInteger`.
*Cho một chuỗi `s` đại diện cho việc tuần tự hóa của một danh sách lồng nhau, hãy triển khai một bộ phân tích để giải tuần tự hóa nó và trả về `NestedInteger` đã được giải tuần tự hóa.*

Each element is either an integer or a list whose elements may also be integers or other lists.
*Mỗi phần tử có thể là một số nguyên hoặc một danh sách mà các phần tử của nó cũng có thể là số nguyên hoặc các danh sách khác.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "324"`
**Output:** `324`
**Explanation:** You should return a NestedInteger object which contains a single integer 324.

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "[123,[456,[789]]]"`
**Output:** `[123,[456,[789]]]`
**Explanation:** Return a NestedInteger object containing a nested list with 2 elements:
1. An integer containing value 123.
2. A nested list containing two elements:
    i.  An integer containing value 456.
    ii. A nested list with one element:
         a. An integer containing value 789.

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 5 * 10^4`
*   `s` consists of digits, square brackets `[]`, negative sign `-`, and commas `,`.
*   `s` is the serialization of a valid `NestedInteger`.
*   All the given integers are in the range `[-10^6, 10^6]`.
