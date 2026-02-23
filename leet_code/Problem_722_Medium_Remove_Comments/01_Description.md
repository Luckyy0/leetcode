# Result for Remove Comments
# *Kết quả cho bài toán Xóa Chú thích*

## Description
## *Mô tả*

In C++, there are two types of comments: line comments and block comments.
*Trong C++, có hai loại chú thích: chú thích dòng và chú thích khối.*

- **Line comments:** The string `//` starts a line comment, which causes the rest of the characters on the same line to be ignored.
- **Block comments:** The string `/*` starts a block comment, which causes every character until the next occurrence of `*/` to be ignored. (These occurrences can be on the same line or different lines.) The characters can't be part of another comment.

* - **Chú thích dòng:** Chuỗi `//` bắt đầu một chú thích dòng, khiến phần còn lại của các ký tự trên cùng một dòng đó bị bỏ qua.*
* - **Chú thích khối:** Chuỗi `/*` bắt đầu một chú thích khối, khiến mọi ký tự cho đến khi xuất hiện chuỗi `*/` tiếp theo bị bỏ qua. (Sự xuất hiện này có thể trên cùng một dòng hoặc khác dòng.) Các ký tự này không thể là một phần của chú thích khác.*

If we see `//` inside a block comment, it's ignored. Similarly, if we see `/*` inside a line or block comment, it's also ignored.
*Nếu chúng ta thấy `//` bên trong một chú thích khối, nó sẽ bị bỏ qua. Tương tự, nếu chúng ta thấy `/*` bên trong một chú thích dòng hoặc chú thích khối, nó cũng bị bỏ qua.*

The first effective comment takes precedence over others. For example, if we see `/*/`, the first `/*` starts a block comment, and the next `/` doesn't do anything because it's inside the comment.
*Chú thích có hiệu lực đầu tiên sẽ được ưu tiên hơn các chú thích khác. Ví dụ, nếu thấy `/*/`, chuỗi `/*` đầu tiên sẽ bắt đầu một chú thích khối, và dấu `/` tiếp theo không có tác dụng gì vì nó nằm bên trong chú thích.*

You are given a C++ program `source` as an array of strings. Return the source code after removing comments. If a block comment caused multiple lines to merge, they should remain merged.
*Bạn được cho một chương trình C++ `source` dưới dạng một mảng các chuỗi. Hãy trả về mã nguồn sau khi đã xóa bỏ các chú thích. Nếu một chú thích khối khiến nhiều dòng bị gộp lại, chúng phải được giữ nguyên trạng thái gộp đó.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** source = ["/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"]
**Output:** ["int main()","{ ","  ","int a, b, c;","a = b + c;","}"]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= source.length <= 100`
*   `0 <= source[i].length <= 80`
*   `source[i]` consists of printable ASCII characters.
*   Every open block comment is eventually closed.
*   There are no control characters like `\n` or `\t` in the input.
