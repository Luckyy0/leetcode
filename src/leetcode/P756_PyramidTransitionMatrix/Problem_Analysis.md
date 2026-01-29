# 756. Pyramid Transition Matrix / Ma trận Chuyển đổi Kim tự tháp

## Problem Description / Mô tả bài toán
We are stacking blocks to form a pyramid. Each block has a color which is a one-letter string.
Chúng ta đang xếp chồng các khối để tạo thành một kim tự tháp. Mỗi khối có một màu là một chuỗi có một chữ cái.

We are given a `bottom` string representing the last row of the pyramid. We are also given a `allowed` list of strings of length 3, where `allowed[i] = "ABC"` means if two blocks of colors `A` and `B` are adjacent on a lower row, we can place a block of color `C` on top of them.
Chúng ta được cung cấp một chuỗi `bottom` đại diện cho hàng cuối cùng của kim tự tháp. Chúng ta cũng được cung cấp một danh sách `allowed` gồm các chuỗi có độ dài 3, trong đó `allowed[i] = "ABC"` có nghĩa là nếu hai khối màu `A` và `B` nằm kề nhau ở hàng dưới, chúng ta có thể đặt một khối màu `C` lên trên chúng.

Return `true` if we can build a pyramid until the top, or `false` otherwise.
Trả về `true` nếu chúng ta có thể xây dựng một kim tự tháp cho đến đỉnh, ngược lại trả về `false`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Backtracking / Quay lui
This is a search problem.
Đây là một bài toán tìm kiếm.

State: The current row of the pyramid.
Trạng thái: Hàng hiện tại của kim tự tháp.

Algorithm:
1. Start with the `bottom` row.
2. Generate all possible "next" rows that can be built on top of the current row.
3. For each possible next row, recurse.

Optimization:
- Use a `Map<String, List<Character>>` to store allowed transitions for each pair `AB`.
- Use memoization to store whether a specific `bottom` can lead to a solution.

### Complexity / Độ phức tạp
- **Time**: O(A^N) where A is the size of the alphabet and N is the length of bottom. Pruning reduces this.
- **Space**: O(N^2) for recursion and memo.

---

## Analysis / Phân tích

### Approach: Row-by-Row DFS
Build the next row character by character. Once a full row is completed, try building the row above it.
Xây dựng hàng tiếp theo từng ký tự một. Sau khi hoàn thành một hàng đầy đủ, hãy thử xây dựng hàng bên trên nó.

---
