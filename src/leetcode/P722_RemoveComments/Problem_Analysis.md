# 722. Remove Comments / Loại bỏ Chú thích

## Problem Description / Mô tả bài toán
Given a C++ program, remove comments from it. The program source is an array of strings `source` where `source[i]` is the `ith` line of the source code. This function should return the source code after removing comments.
Cho một chương trình C++, hãy loại bỏ các chú thích khỏi chương trình đó. Nguồn chương trình là một mảng các chuỗi `source` trong đó `source[i]` là dòng thứ `i` của mã nguồn. Hàm này sẽ trả về mã nguồn sau khi loại bỏ các chú thích.

There are two types of comments in C++:
- Line comments `//`: Everything to its right is ignored until the end of the line.
- Block comments `/* ... */`: Everything between them is ignored. These can span multiple lines.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### State Machine / String Parsing / Máy trạng thái / Phân tích Chuỗi
We need to track whether we are currently inside a block comment or not.
Chúng ta cần theo dõi xem hiện tại mình có đang ở bên trong một chú thích khối hay không.

States:
1. **Normal mode**: Look for `//` or `/*`.
   - If `//` is found, ignore the rest of the string.
   - If `/*` is found, switch to **comment mode**.
2. **Comment mode**: Look for `*/`.
   - If `*/` is found, switch back to **normal mode**.

Crucially, when a block comment ends, the text before it and after it might end up on the same line.
Quan trọng là, khi một chú thích khối kết thúc, văn bản trước và sau nó có thể nằm trên cùng một dòng.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the total number of characters in the source.
- **Space**: O(N) for string reconstruction.

---

## Analysis / Phân tích

### Approach: Character-by-Character Processing
Process each character of each line. Use a boolean `inBlock` to track the state. Accumulate characters that are not part of any comment into a buffer. Only flush the buffer to the result list when out of block comment mode and at the end of a line.
Xử lý từng ký tự của từng dòng. Sử dụng một biến boolean `inBlock` để theo dõi trạng thái. Tích lũy các ký tự không thuộc bất kỳ chú thích nào vào một vùng đệm. Chỉ đẩy vùng đệm vào danh sách kết quả khi không ở chế độ chú thích khối và ở cuối dòng.

---
