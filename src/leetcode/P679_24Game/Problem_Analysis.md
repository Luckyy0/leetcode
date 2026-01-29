# 679. 24 Game / Trò chơi 24

## Problem Description / Mô tả bài toán
You are given an integer array `cards` of length 4. You have four cards, each containing a number in the range `[1, 9]`. You should arrange the numbers on these cards in a mathematical expression using operators `['+', '-', '*', '/']` and parentheses `('(', ')')` to get the value 24.
Bạn được cho một mảng số nguyên `cards` có độ dài 4. Bạn có bốn thẻ, mỗi thẻ chứa một số trong phạm vi `[1, 9]`. Bạn nên sắp xếp các số trên các thẻ này trong một biểu thức toán học bằng cách sử dụng các toán tử `['+', '-', '*', '/']` và dấu ngoặc đơn `('(', ')')` để có được giá trị 24.

Return `true` if you can get such expression that evaluates to 24, and `false` otherwise.
Trả về `true` nếu bạn có thể lấy biểu thức như vậy có giá trị bằng 24, ngược lại trả về `false`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Backtracking & Enumeration / Quay lui & Liệt kê
Since there are only 4 cards, the number of possible expressions is small enough to use recursion.
Vì chỉ có 4 thẻ, số lượng biểu thức khả thi đủ nhỏ để sử dụng đệ quy.

At each step:
1. Pick any two numbers from the current list.
2. Apply one of the four operators to those two numbers.
3. Replace the two picked numbers with the result to form a new list of length `n-1`.
4. Recurse until only one number remains.
5. Check if the remaining number is approximately 24 (handle floating point precision).

### Complexity / Độ phức tạp
- **Time**: O(1) - The number of cards is fixed at 4, so the total number of permutations and operations is constant.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Recursive Reduction
We pick two cards `a` and `b`, compute `a+b, a-b, b-a, a*b, a/b, b/a`, and then call the function with the remaining cards and the new result. Division by zero must be skipped.
Chúng ta chọn hai thẻ `a` và `b`, tính toán các phép tính và sau đó gọi hàm với các thẻ còn lại và kết quả mới. Phải bỏ qua phép chia cho số không.

---
