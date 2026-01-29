# 806. Number of Lines To Write String / Số dòng để Viết Chuỗi

## Problem Description / Mô tả bài toán
You are writing a string `s` onto a set of lines. Each line has a maximum width of 100 units.
Bạn đang viết một chuỗi `s` lên một tập hợp các dòng. Mỗi dòng có độ rộng tối đa là 100 đơn vị.

You are given an array `widths` where `widths[0]` is the width of 'a', `widths[1]` is the width of 'b', and so on.
Bạn được cung cấp một mảng `widths` trong đó `widths[0]` là độ rộng của chữ 'a', `widths[1]` là độ rộng của chữ 'b', v.v.

When you write a character, if it would exceed the 100-unit limit, you must start a new line.
Khi bạn viết một ký tự, nếu nó vượt quá giới hạn 100 đơn vị, bạn phải bắt đầu một dòng mới.

Return an array `[totalLines, lastLineWidth]`.
Trả về một mảng `[totalLines, lastLineWidth]`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation / Mô phỏng
This is a straightforward simulation of the writing process.
Đây là một mô phỏng trực tiếp quá trình viết.

Algorithm:
1. Initialize `lines = 1`, `currentWidth = 0`.
2. For each character `c` in `s`:
   - `w = widths[c - 'a']`.
   - If `currentWidth + w > 100`:
     - `lines++`.
     - `currentWidth = w`.
   - Else:
     - `currentWidth += w`.
3. Return `[lines, currentWidth]`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Greedy Line Filling
Fill each line as much as possible without exceeding the 100-limit. If a character cannot fit, it becomes the first character of the next line.
Điền vào mỗi dòng nhiều nhất có thể mà không vượt quá giới hạn 100. Nếu một ký tự không thể khớp, nó sẽ trở thành ký tự đầu tiên của dòng tiếp theo.

---
