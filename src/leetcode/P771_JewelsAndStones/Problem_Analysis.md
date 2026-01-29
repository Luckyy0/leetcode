# 771. Jewels and Stones / Trang sức và Đá

## Problem Description / Mô tả bài toán
You're given strings `jewels` representing the types of stones that are jewels, and `stones` representing the stones you have. Each character in `stones` is a type of stone you have. You want to know how many of the stones you have are also jewels.
Bạn được cung cấp các chuỗi `jewels` đại diện cho các loại đá là trang sức và `stones` đại diện cho các loại đá bạn có. Mỗi ký tự trong `stones` là một loại đá bạn đang sở hữu. Bạn muốn biết có bao nhiêu viên đá bạn có cũng là trang sức.

Letters are case sensitive, so `"a"` is considered a different type of stone from `"A"`.
Các chữ cái phân biệt chữ hoa chữ thường, vì vậy `"a"` được coi là một loại đá khác với `"A"`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### HashSet for Fast Lookup / HashSet để tra cứu nhanh
We can store all character types from `jewels` into a `HashSet` for O(1) lookup.
Chúng ta có thể lưu trữ tất cả các loại ký tự từ `jewels` vào một `HashSet` để tra cứu với O(1).

Algorithm:
1. Store all characters of `jewels` in a `Set`.
2. Iterate through `stones`.
3. Increment count if the current stone exists in the `Set`.

### Complexity / Độ phức tạp
- **Time**: O(J + S) where J is length of jewels and S is length of stones.
- **Space**: O(J).

---

## Analysis / Phân tích

### Approach: Linear Selection
A simple membership check. Efficient and direct.
Một kiểm tra tư cách thành viên đơn giản. Hiệu quả và trực tiếp.

---
