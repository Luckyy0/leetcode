# 726. Number of Atoms / Số lượng Nguyên tử

## Problem Description / Mô tả bài toán
Given a string `formula` representing a chemical formula, return the count of each atom.
Cho một chuỗi `formula` đại diện cho một công thức hóa học, hãy trả về số lượng của mỗi nguyên tử.

The atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.
Phần tử nguyên tử luôn bắt đầu bằng một ký tự viết hoa, sau đó là không hoặc nhiều chữ cái viết thường, đại diện cho tên.

One or more digits representing the count may follow if the count is greater than 1. If the count is 1, no digits will follow.
Một hoặc nhiều chữ số đại diện cho số lượng có thể theo sau nếu số lượng lớn hơn 1. Nếu số lượng là 1, sẽ không có chữ số nào theo sau.

The formula may contain parentheses and digits after those.
Công thức có thể chứa các dấu ngoặc đơn và các chữ số sau chúng.

Return the count of all elements as a string in the following form: the first name (in lexicographical order), followed by its count (if that count is more than 1), followed by the second name (in lexicographical order), followed by its count (if that count is more than 1), and so on.
Trả về số lượng của tất cả các phần tử dưới dạng một chuỗi ở định dạng sau: tên đầu tiên (theo thứ tự từ điển), tiếp theo là số lượng của nó (nếu số lượng đó lớn hơn 1), tiếp theo là tên thứ hai, v.v.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Stack and HashMap / Ngăn xếp và HashMap
We can use a stack of HashMaps to handle nested parentheses.
Chúng ta có thể sử dụng một ngăn xếp các HashMap để xử lý các dấu ngoặc đơn lồng nhau.

Each HashMap stores `Atoms -> Count`.
When a `(` is encountered, push a new HashMap onto the stack.
When a `)` is encountered, pop the top HashMap, multiply all its counts by the number following the `)`, and add those to the current top HashMap.

### Complexity / Độ phức tạp
- **Time**: O(N^2) where N is the length of the formula (due to map merges).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Recursive/Stack Parser
Process the string. Parse atom names and counts. Handle nested groups by multiplying entire sub-maps.
Xử lý chuỗi. Phân tích tên nguyên tử và số lượng. Xử lý các nhóm lồng nhau bằng cách nhân toàn bộ các bản đồ con.

---
