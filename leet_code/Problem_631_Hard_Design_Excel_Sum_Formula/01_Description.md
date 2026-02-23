# Result for Design Excel Sum Formula
# *Kết quả cho bài toán Thiết kế Công thức Tổng Excel*

## Description
## *Mô tả*

Design the basic function of Excel and implement the function of sum formula.
*Thiết kế các chức năng cơ bản của Excel và triển khai chức năng của công thức tính tổng.*

Implement the `Excel` class:
*Triển khai lớp `Excel`:*

*   `Excel(int height, char width)`: Initializes the object with the `height` and the `width` of the sheet. The `height` is an integer from `1` to `26` and the `width` is an uppercase character from `'A'` to `'Z'`.
    *   *`Excel(int height, char width)`: Khởi tạo đối tượng với `height` và `width` của bảng tính. `height` là một số nguyên từ `1` đến `26` và `width` là một ký tự in hoa từ `'A'` đến `'Z'`.*
*   `void set(int row, char column, int val)`: Sets the value of the cell specified by `row` and `column` to `val`.
    *   *`void set(int row, char column, int val)`: Thiết lập giá trị của ô được chỉ định bởi `row` và `column` thành `val`.*
*   `int get(int row, char column)`: Returns the value of the cell specified by `row` and `column`.
    *   *`int get(int row, char column)`: Trả về giá trị của ô được chỉ định bởi `row` và `column`.*
*   `int sum(int row, char column, List<String> numbers)`: Sets the value of the cell specified by `row` and `column` to the sum of the values of the cells specified by `numbers`. It should also return the value of that cell. If a cell specified by `numbers` is another sum cell, you should use the current value of that cell.
    *   *`int sum(int row, char column, List<String> numbers)`: Thiết lập giá trị của ô được chỉ định bởi `row` và `column` thành tổng các giá trị của các ô được chỉ định bởi `numbers`. Nó cũng nên trả về giá trị của ô đó. Nếu một ô được chỉ định bởi `numbers` là một ô tổng khác, bạn nên sử dụng giá trị hiện tại của ô đó.*

A format of a string in `numbers` can be:
*Định dạng của một chuỗi trong `numbers` có thể là:*
*   `"ColRow"`: e.g., `"A1"`.
*   `"ColRow1:ColRow2"`: e.g., `"A1:B3"`. This represents a range of cells.

---

## Example 1:
## *Ví dụ 1:*

**Input:**
["Excel", "set", "sum", "set", "get"]
[[3, "C"], [1, "A", 2], [3, "C", ["A1", "A1:B2"]], [2, "B", 2], [3, "C"]]
**Output:**
[null, null, 4, null, 6]

**Explanation:**
```
Excel excel = new Excel(3, 'C'); // height = 3, width = 'C'
excel.set(1, 'A', 2);            // A1 = 2
excel.sum(3, 'C', ["A1", "A1:B2"]); // A1 = 2, A1:B2 = A1+A2+B1+B2 = 2+0+0+0 = 2. Total = 2 + 2 = 4.
excel.set(2, 'B', 2);            // B2 = 2. A1:B2 now = A1+A2+B1+B2 = 2+0+0+2 = 4. C3 = 2 + 4 = 6.
excel.get(3, 'C');               // return 6
```

---

## Constraints:
## *Ràng buộc:*

*   `1 <= height <= 26`
*   `'A' <= width <= 'Z'`
*   `1 <= row <= height`
*   `'A' <= column <= width`
*   `-100 <= val <= 100`
*   `1 <= numbers.length <= 5`
*   At most `100` calls will be made to `set`, `get`, and `sum`.
